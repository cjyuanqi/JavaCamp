package com.es.camp.web.service;


import com.es.camp.web.transaction_lost.CustomException;
import com.es.camp.web.transaction_lost.ISpringTransaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestTransactionLost {

    @Autowired
    private ISpringTransaction iSpringTransaction;

    @Test
    public void testCatchExceptionCannotRollback() {
        iSpringTransaction.CatchExceptionCanNotRollback();
    }

    @Test
    public void testNotRuntimeExceptionCanNotRollback() throws CustomException {
        iSpringTransaction.NotRuntimeExceptionCanNotRollback();
    }

    @Test
    public void testRuntimeExceptionCanRollback() {
        iSpringTransaction.RuntimeExceptionCanRollback();
    }

    @Test
    public void testAssignExceptionCanRollback() throws CustomException {
        iSpringTransaction.AssignExceptionCanRollback();
    }
}
