package com.bamboo.test.diff;

import com.google.common.collect.Maps;
import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import de.danielbechler.diff.node.Visit;
import de.danielbechler.diff.path.NodePath;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

/**
 * @Description
 * 分析两个对象不同点
 * @Author victor su
 * @Date 2019/11/9 22:42
 **/
@Slf4j
public class ObjectDiffTest {

    /**
     * 测试Map中只包含一个key-value对时的对象改变情况
     */
    @Test
    public void testSingleMapDiff() {
        Map<String, String> working = Collections.singletonMap("item", "foo");
        Map<String, String> base = Collections.singletonMap("item", "bar");
        DiffNode diff = ObjectDifferBuilder.buildDefault().compare(working, base);

        log.info("差异： {}", diff.toString());

        assert diff.hasChanges();
        assert diff.childCount() == 1;

        NodePath itemPath = NodePath.startBuilding().mapKey("item").build();
        assert diff.getChild(itemPath).getState() == DiffNode.State.CHANGED;

        diff.visit((node, visit) -> log.info("traverse : {} => {}", node.getPath() , node.getState()));

    }

    @Test
    public void testMultiKVMapDiff () {
        Map<String, String> multiWorkingMap = Maps.newHashMap();
        multiWorkingMap.put("k1", "xiaomi");
        multiWorkingMap.put("k2", "jingdong");
        multiWorkingMap.put("k3", "ali");
        multiWorkingMap.put("k4", "meituan");
        multiWorkingMap.put("k5", "didi");


        Map<String, String> multiBaseMap = Maps.newHashMap();
        multiBaseMap.put("k1", "xiaomi");
        multiBaseMap.put("k2", "jingdonggou");
        multiBaseMap.put("k3", "ali");
        multiBaseMap.put("k4", "meituancaituan");
        multiBaseMap.put("k5", "didi");

        DiffNode diffNode = ObjectDifferBuilder.buildDefault().compare(multiWorkingMap, multiBaseMap);
        log.info("差异： {}", diffNode.toString());

        diffNode.visit((node, visit) -> log.info("traverse : {} => {}", node.getPath() , node.getState()));

    }
}
