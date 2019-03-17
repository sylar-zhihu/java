package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class Test_1_DataSource_NoSpring {

    @Test
    // 不使用Spring 直接使用jdbc
    public void testNoSpringDataSource() {
        // 创建连接池:
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // 设置参数:
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring");
        dataSource.setUsername("root");
        dataSource.setPassword("123");

        // 使用JDBC的模板:
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("create table testNoSpring (id int primary key auto_increment,name varchar(20))");
    }

}
