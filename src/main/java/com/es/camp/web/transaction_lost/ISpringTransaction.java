package com.es.camp.web.transaction_lost;

public interface ISpringTransaction {

    /** 主动捕获异常，导致事务不能回滚 */
    void CatchExceptionCanNotRollback();

    /** 非运行时异常不能回滚 */
    void NotRuntimeExceptionCanNotRollback() throws CustomException;

    /** unchecked 异常可以回滚 */
    void RuntimeExceptionCanRollback();

    /** 指定 rollback 可以回滚 */
    void AssignExceptionCanRollback() throws CustomException;

    /** 同一个类中， 一个非事务方法调用事务方法， 事务会失效 */
    void NotTransactionCanRollback();



}
