package com.bamboo.compass.dbcp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description
 * DBCP数据库连接池测试
 * @Author victor su
 * @Date 2019/7/15 10:13
 **/
public class DBCPUtil {
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("data-pool.xml");

        DataSource dataSource = (DataSource) ctx.getBean("dbcp2DataSource");
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        int resultSet = connection.prepareStatement("INSERT INTO test(name) values('xiaoge')").executeUpdate();

        connection.commit();
        System.out.println(resultSet);
    }
}
