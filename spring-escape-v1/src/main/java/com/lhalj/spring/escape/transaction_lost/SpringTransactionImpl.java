package com.lhalj.spring.escape.transaction_lost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.beans.Transient;

/**
 * 描述:
 */
@Service
public class SpringTransactionImpl implements ISpringTransaction{

    @Autowired
    private IdAndNameDao idAndNameDao;

    @Override
    @Transactional
    public void CatchExceptionCanNotRollback() {

        try {
            idAndNameDao.save(new IdAndName("qinyi"));
            throw new RuntimeException();
        }catch (Exception ex){
            ex.printStackTrace();
            //手动标记回滚 编程式事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    @Override
    @Transactional
    public void NotRuntimeExceptionCanNotRollback() throws CustomException {
        try {
            idAndNameDao.save(new IdAndName("NotRuntimeExceptionCanNotRollback"));
            throw new RuntimeException();
        }catch (Exception ex){
          throw new CustomException(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public void RuntimeExceptionCanRollback() {

            idAndNameDao.save(new IdAndName("RuntimeExceptionCanRollback"));
            throw new RuntimeException();

    }

    @Override
    @Transactional(rollbackFor = {CustomException.class}) //指定可以回滚的异常
    public void AssignExceptionCanRollback() throws CustomException {
        try {
            idAndNameDao.save(new IdAndName("AssignExceptionCanRollback"));
            throw new RuntimeException();
        }catch (Exception ex){
            throw new CustomException(ex.getMessage());
        }
    }

    @Transactional
    public void anotherOneSaveMethod(){
        idAndNameDao.save(new IdAndName("anotherOneSaveMethod"));
        throw new RuntimeException();
    }

    @Override
    public void NonTransactionalCanNotRollback() {
        anotherOneSaveMethod();
    }
}
