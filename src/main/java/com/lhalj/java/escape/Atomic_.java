package com.lhalj.java.escape;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:多线程下的变量值更新
 */
public class Atomic_ {

    private static int count = 0;

    private static AtomicInteger atomicCount = new AtomicInteger(0);

    /*
     * 线程不安全的累加
     */
    private static void accumulator(int acc) throws Exception {
        //倒计时器
        CountDownLatch cd1 = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < acc; i++) {
                    count++;
                }
                cd1.countDown(); //-1
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < acc; i++) {
                    count++;
                }
                cd1.countDown(); //-1
            }
        });

        t1.start();
        t2.start();
        //主线程阻塞
        cd1.await();
        System.out.println("result: " + count);
    }

    /*
     * 线程安全的累加
     */
    private static void atomicAccumulator(int acc) throws Exception{
        //倒计时器
        CountDownLatch cd1 = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < acc; i++) {
                    atomicCount.incrementAndGet();
                }
                cd1.countDown(); //-1
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < acc; i++) {
                    atomicCount.incrementAndGet();
                }
                cd1.countDown(); //-1
            }
        });

        t1.start();
        t2.start();
        //主线程阻塞
        cd1.await();
        System.out.println("result: " + atomicCount.get());
    }
    public static void main(String[] args) throws Exception{

        //accumulator(1000);
        atomicAccumulator(1000);
    }

}
