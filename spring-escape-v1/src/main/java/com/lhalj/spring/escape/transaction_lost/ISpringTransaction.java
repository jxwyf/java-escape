package com.lhalj.spring.escape.transaction_lost;

/*
 * 注解演示接口定义
 */
public interface ISpringTransaction {

    /*
     * 主动捕获了异常 导致事务不能回滚
     */
    void CatchExceptionCanNotRollback();

    /*
     * 不是 unchecked 异常 事务不能回滚
     */
    void NotRuntimeExceptionCanNotRollback() throws CustomException;

    /*
     * unchecked异常 可以回滚
     */
    void RuntimeExceptionCanRollback();

    /*
     * 指定rollbackFor 事务可以回滚
     */
    void AssignExceptionCanRollback() throws CustomException;

    /*
     * 同一个类中 应该不标注事务的方法去调用标注了事务的方法 事务会失效
     */
    void NonTransactionalCanNotRollback();
}
