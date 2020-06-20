package com.pxwx.test.tx;

import com.pxwx.tx.config.TxConfig;
import com.pxwx.tx.service.ServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TxConfig.class)
public class Test {

    @Resource
    private ServiceImpl service;

    @org.junit.Test
    public void test(){
        String insertSQL = "insert into durp_test values (?,?)";
        service.execSql(insertSQL, "1", 1);
    }

    @org.junit.Test
    public void testTx(){
        String insertSQL = "insert into durp_test values (?,?)";
        service.execSqlWithTx(insertSQL, "1", 1);
    }
}
