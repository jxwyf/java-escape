package com.lhalj.java.escape.thread_local;

/**
 * 描述:ThreadLocal使用和理解
 */
public class Main {


    /**
     * ThreadLocal不支持继承
     */
    private static void threadLocalCanNotInherit(){

        ThreadLocal<String> name = new ThreadLocal<>();
        name.set("java");

        Thread sub = new Thread(()->{
            System.out.println("Name in sub:" + name.get());
        });
        sub.start();

        System.out.println("Name in Main:" + name.get());
    }


    public static void main(String[] args) {

        //for (int i = 0; i <4 ; i++) {
        //    new Thread(
        //            ()->{
        //                DoCompetition doCompetition = new DoCompetition();
        //                doCompetition.code();
        //                doCompetition.config();
        //                doCompetition.print();
        //            },"Thread-" + (i+1)
        //    ).start();
        //}

        threadLocalCanNotInherit();
        
    }

}
