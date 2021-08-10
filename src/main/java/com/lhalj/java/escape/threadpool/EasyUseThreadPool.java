package com.lhalj.java.escape.threadpool;

import java.util.concurrent.*;

/**
 * 描述: 简单使用线程池
 */
public class EasyUseThreadPool {

    /**
     * 使用固定线程池
     * 固定大小的线程池会导致内存急剧上升
     * @param threadCount 线程数
     */
    private static void useFixedThreadPool(int threadCount){

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        Runnable runnable01 = new Reading(3,"java 编程思想");
        Runnable runnable02 = new Reading(2,"Spring 实战");
        Runnable runnable03 = new Reading(1,"SpringBoot 实战");
        Runnable runnable04 = new Reading(4,"Mysql 权威指南");
        Runnable runnable05 = new Reading(6,"SpringCloud 实战");

        executor.execute(runnable05);
        executor.execute(runnable04);
        executor.execute(runnable03);
        executor.execute(runnable02);
        executor.execute(runnable01);

        executor.shutdown();

    }


    /**
     * 自定义线程池
     */
    private static void customThreadPoll(){

        ThreadPoolExecutor custom1 =
                new ThreadPoolExecutor(
                        1,1 , 30,
                        TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(2));


        ThreadPoolExecutor custom2 =
                new ThreadPoolExecutor(
                        1,
                        1 ,
                        30,
                        TimeUnit.MINUTES,
                        new ArrayBlockingQueue<Runnable>(2),
                        new CustomRejectHandler());

        for (int i = 0; i !=5 ; i++) {
            custom2.execute(new Reading(3,"java 编程思想"));
        }

        //关闭线程池
        custom2.shutdown();
    }

    /*
     * 自定义拒绝策略
     * 防止线程数和阻塞队列满时抛出异常
     */
    private static class CustomRejectHandler implements RejectedExecutionHandler{

        /**
         * 拒绝执行
         */
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            try {

                //满了 阻塞
                executor.getQueue().put(r);

            }catch (InterruptedException ex){
                ex.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        //useFixedThreadPool(3);
        customThreadPoll();
    }


}
