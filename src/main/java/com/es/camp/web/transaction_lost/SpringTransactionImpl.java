package com.es.camp.web.transaction_lost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;


@Service
public class SpringTransactionImpl implements ISpringTransaction {

    @Autowired
    private IdAndNameDao idAndNameDao;

    @Override
    @Transactional
    public void CatchExceptionCanNotRollback() {
        try {
            idAndNameDao.save(new IdAndName("qinyi"));
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
            // 出现异常 手动标记回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    @Override
    @Transactional
    public void NotRuntimeExceptionCanNotRollback() throws CustomException {
        try {
            idAndNameDao.save(new IdAndName("qinyi"));
            throw new RuntimeException();
        } catch (Exception e) {
            // 抛出的是非运行时异常， 是检查异常，不会回滚
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void RuntimeExceptionCanRollback() {
        idAndNameDao.save(new IdAndName("qinyi"));
        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackOn = {CustomException.class})
    public void AssignExceptionCanRollback() throws CustomException {
        idAndNameDao.save(new IdAndName("qinyi"));
        throw new CustomException("checked exception");
    }

    /**
     * 需要注意的是，@Transactional 只能标注在 public method 上。 标注在 private, protected 方法上不会生效的。
     * 数据库的引擎也得支持事务才会生效。
     */
    @Transactional
    public void anotherOneSaveMethod() {
        idAndNameDao.save(new IdAndName("qinyi"));
        throw new RuntimeException();
    }

    /** In one class , one no-trans-method call a trans-method, transaction will invalid */
    @Override
    public void NotTransactionCanRollback() {
        anotherOneSaveMethod();
    }
}
