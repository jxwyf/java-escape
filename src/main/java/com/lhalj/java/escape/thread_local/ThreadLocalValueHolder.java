package com.lhalj.java.escape.thread_local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述:在线程池中使用ThreadLocal
 * 线程自己维护ThreadLocal
 *  适用场景
 *  1. 每一个线程需要有自己单独的实例副本
 *  2.实例需要在多个方法中共享 但是并不喜欢被多线程共享
 */
public class ThreadLocalValueHolder {

    private static final ThreadLocal<Integer> holder = ThreadLocal.withInitial(()->0);


    public static int getValue(){
        return holder.get();
    }

    public static void remove(){
        holder.remove();
    }

    public static void increment(){
        holder.set(holder.get() + 1);
    }


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i !=15 ; i++) {
            executor.execute(
                    ()->{
                        try {
                            long threadId = Thread.currentThread().getId();
                            int before = getValue();
                            increment();
                            int after = getValue();

                            System.out.println("threadId: "+ threadId +" before: " + before + ", after: "+after);

                        }finally {
                            remove();
                        }

                    }
            );
        }

        executor.shutdown();
    }

}
