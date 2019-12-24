package com.itheima.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JDBCTemplateTest {
    @Test
    public void test() throws PropertyVetoException {
        ComboPooledDataSource dataSource =new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db4");
        dataSource.setUser("root");
        dataSource.setPassword("19980616");

        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        //设置数据源对象  知道数据库在哪
        jdbcTemplate.setDataSource(dataSource);
        int tom = jdbcTemplate.update("insert into account values (?,?)", "tom", 11111);
        System.out.println(tom);
    }

    @Test
    public void test2() throws PropertyVetoException {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        int jerry = jdbcTemplate.update("insert into account values (?,?)", "lisi", 11111);
        System.out.println(jerry);

    }

}
