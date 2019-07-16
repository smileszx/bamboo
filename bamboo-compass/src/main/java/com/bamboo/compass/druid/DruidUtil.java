package com.bamboo.compass.druid;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/15 11:42
 **/
public class DruidUtil {
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("data-pool.xml");

        DataSource dataSource = (DataSource) ctx.getBean("druidDataSource");
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        int resultSet = connection.prepareStatement("INSERT INTO test(name) values('xiaoge')").executeUpdate();

        connection.commit();
        System.out.println(resultSet);
    }
}
