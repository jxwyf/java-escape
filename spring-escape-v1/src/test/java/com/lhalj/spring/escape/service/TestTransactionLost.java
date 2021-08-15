package com.lhalj.spring.escape.service;

import com.lhalj.spring.escape.transaction_lost.CustomException;
import com.lhalj.spring.escape.transaction_lost.ISpringTransaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestTransactionLost {

    @Autowired
    private ISpringTransaction springTransaction;

    @Test
    public void testCatchExceptionCanNotRollback(){
        springTransaction.CatchExceptionCanNotRollback();
    }

    @Test
    public void testNotRuntimeExceptionCanNotRollback() throws CustomException {
        springTransaction.NotRuntimeExceptionCanNotRollback();
    }

    public void testRuntimeExceptionCanRollback(){
        springTransaction.RuntimeExceptionCanRollback();
    }

    @Test
    public void testNonTransactionalCanNotRollback(){
        springTransaction.NonTransactionalCanNotRollback();
    }
}

