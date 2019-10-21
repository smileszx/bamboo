package com.bamboo.jdk.leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * 参考博客：https://www.sohu.com/a/232008315_453160
 * Snowflake算法，Twitter公司采用的算法，目前是分布式系统中生成全局唯一且趋势递增的ID
 * SnowFlake-64bit long数据结构，生成的ID分成4部分：
 * - 1 占用1bit，其值始终是0，无实际作用
 * - 2 时间戳， 占用41bit，精确到毫秒ms，总共可以容纳69年的时间
 * - 3 工作机器id， 占用10bit，其中高5bit是数据中心ID（datacenterId）， 低5bit是工作节点ID(workerId),最多容纳1024个节点
 * - 4 序列号，占用12bit，该值在同一毫秒同一节点上从0开始不断累加，最多可累加到4095
 *
 * 问题1：Snowflake算法同一毫秒内最多可以生成多少全局唯一ID呢？
 * 同一毫秒ID数量 = 1024 * 4096 = 4194304，该数字可以满足绝大多数并发场景。
 *
 * 问题2：获取单一机器下一个序列号，如何保证在并发环境是线程安全的？
 * 通过synchronized控制并发，而未采用CAS方式，因为CAS不适合并发量非常高的场景，参考CAS的自旋
 *
 * 问题3：如果当前毫秒某台机器序列号已经增长至最大值4095，如何处理？
 * while循环等待直到下一毫秒开始
 *
 * 问题4：如果当前时间小于记录的上一个毫秒值怎么处理？
 * 说明这台机器的时间回拨了，抛出异常。如果这台机器的系统时间在启动之前回拨过，那么有可能出现ID重复的危险，如何解决呢？
 *
 * Snowflake优点：
 * - 生成ID不依赖DB，完全在内存生成，高性能高可用
 * - ID呈现趋势递增，后续插入索引树时性能较好
 *
 * Snowflake缺点：
 * 依赖于系统时钟的一致性，如果某台机器系统时钟回拨，可能造成ID冲突，或者ID乱序
 * @Author victor su
 * @Date 2019/8/14 12:23
 **/
public class SnowFlakeIdGenerator {

    //初始时间截 (2017-01-01)
    private static final long INITIAL_TIME_STAMP = 1483200000000L;
    //机器id所占的位数
    private static final long WORKER_ID_BITS = 5L;
    //数据标识id所占的位数
    private static final long DATACENTER_ID_BITS = 5L;
    //支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);
    //支持的最大数据标识id，结果是31
    private static final long MAX_DATACENTER_ID = ~(-1L << DATACENTER_ID_BITS);
    //序列在id中占的位数
    private final long SEQUENCE_BITS = 12L;
    //机器ID的偏移量(12)
    private final long WORKERID_OFFSET = SEQUENCE_BITS;
    //数据中心ID的偏移量(12+5)
    private final long DATACENTERID_OFFSET = SEQUENCE_BITS + SEQUENCE_BITS;
    //时间截的偏移量(5+5+12)
    private final long TIMESTAMP_OFFSET = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;
    //生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095)
    private final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);
    //工作节点ID(0~31)
    private long workerId;
    //数据中心ID(0~31)
    private long datacenterId;
    //毫秒内序列(0~4095)
    private long sequence = 0L;
    //上次生成ID的时间截
    private long lastTimestamp = -1L;
    /**
     * 构造函数
     *
     * @param workerId 工作ID (0~31)
     * @param datacenterId 数据中心ID (0~31)
     */
    public SnowFlakeIdGenerator(long workerId, long datacenterId) {
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(String.format("WorkerID 不能大于 %d 或小于 0", MAX_WORKER_ID));
        }
        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("DataCenterID 不能大于 %d 或小于 0", MAX_DATACENTER_ID));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }
    /**
     * 获得下一个ID (用同步锁保证线程安全)
     *
     * @return SnowflakeId
     */
    public synchronized long nextId() {
        long timestamp = System.currentTimeMillis();
        //如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("当前时间小于上一次记录的时间戳！");
        }
        //如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            //sequence等于0说明毫秒内序列已经增长到最大值
            if (sequence == 0) {
                //阻塞到下一个毫秒,获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        //时间戳改变，毫秒内序列重置
        else {
            sequence = 0L;
        }
        //上次生成ID的时间截
        lastTimestamp = timestamp;
        //移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - INITIAL_TIME_STAMP) << TIMESTAMP_OFFSET)
                | (datacenterId << DATACENTERID_OFFSET)
                | (workerId << WORKERID_OFFSET)
                | sequence;
    }
    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     *
     * @param lastTimestamp 上次生成ID的时间截
     * @return 当前时间戳
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }
    public static void main(String[] args) {
        final SnowFlakeIdGenerator idGenerator = new SnowFlakeIdGenerator(1, 1);
        //线程池并行执行10000次ID生成
        ExecutorService executorService = Executors.newCachedThreadPool();;
        for (int i = 0; i < 10000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    long id = idGenerator.nextId();
                    System.out.println(id);
                }
            });
        }
        executorService.shutdown();
    }
}
