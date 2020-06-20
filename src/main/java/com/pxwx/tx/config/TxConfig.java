package com.pxwx.tx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(value={"com.pxwx.tx.*"})
@EnableTransactionManagement
public class TxConfig {

    @Bean
    public DataSource dateSource() {
        SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://123.56.135.138:3306/test?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=Asia/Shanghai");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dateSource) {
        return new JdbcTemplate(dateSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dateSource) {
        return new DataSourceTransactionManager(dateSource);
    }
}
