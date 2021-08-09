package com.lhalj.java.escape.blocking_queue;

import java.util.concurrent.BlockingQueue;

/**
 * 描述:消费者
 */
public class Consumer implements Runnable{

    //阻塞队列
    private final BlockingQueue<Integer> blockingQueue;
    private static int element = 0;

    public Consumer(BlockingQueue<Integer> blockingQueue){
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {

        try {
            while (true){
                int value = blockingQueue.take();
                System.out.println("Consume: " + value);

                if(value >= 99){
                    break;
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Consumer Done!");
    }
}
