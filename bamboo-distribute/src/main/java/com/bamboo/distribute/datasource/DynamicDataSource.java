package com.bamboo.distribute.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Description
 * 动态切换数据源
 * @Author victor su
 * @Date 2019/10/22 22:14
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSource) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSource);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }

    public static void setDataSource (String dataSource) {
        CONTEXT_HOLDER.set(dataSource);
    }

    public static String getDataSource () {
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSource () {
        CONTEXT_HOLDER.remove();
    }
}
