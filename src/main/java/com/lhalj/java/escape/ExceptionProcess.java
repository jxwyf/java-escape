package com.lhalj.java.escape;

/**
 * @author : 刘唯卿
 * @date : 21:05 2021/2/1
 * java异常处理
 *
 *
 * java异常处理实践原则
 * 1.使用异常 而不是返回码或类似 因为异常会更加详细
 * 2.主动捕获检查性异常 并对异常消息进行反馈 日志或标记
 * 3.保持代码整洁 一个方法中不要有多个try catch 或者嵌套的try catch
 * 4.捕获更加具体的异常 而不是通用的Exception
 * 5.合理的设计自定义的异常类
 */
public class ExceptionProcess {

    private static class User{}


    /**
     * java异常本质--抛出异常
     */
    private void throwException(){
        User user = null;
        //....
        if(user==null){
            throw new NullPointerException();
        }
    }



    /**
     * 不能捕获空指针异常
     */
    private void canNotCatchNpeException(){

        try{
            throwException();
        }catch (ClassCastException cce){
            System.out.println(cce.getMessage());
            System.out.println(cce.getClass().getName());
        }
    }


    /**
     * 能够捕获空指针异常
     */
    private void canCatchNpeException(){
        try{
            throwException();
        }catch (ClassCastException cce){
            System.out.println(cce.getMessage());
            System.out.println(cce.getClass().getName());
        }catch (NullPointerException npe){
            System.out.println(npe.getMessage());
            System.out.println(npe.getClass().getName());
        }
    }


    public static void main(String[] args) {
        ExceptionProcess process = new ExceptionProcess();
        process.canCatchNpeException();
        process.canNotCatchNpeException();
    }
}
