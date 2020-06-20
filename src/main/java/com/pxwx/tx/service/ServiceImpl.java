package com.pxwx.tx.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ServiceImpl {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void execSql(String sql, String name, Integer num) {
        jdbcTemplate.update(sql, "1", 1);
    }

    @Transactional(rollbackFor = Exception.class)
    public void execSqlWithTx(String sql, String name, Integer num) {
        jdbcTemplate.update(sql, "1", 1);
        throw new RuntimeException();
    }
}
