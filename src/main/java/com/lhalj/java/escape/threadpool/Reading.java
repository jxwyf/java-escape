package com.lhalj.java.escape.threadpool;

/**
 * 描述: 读书的任务
 */
public class Reading implements Runnable{


    private int count;
    private String name;

    public Reading(int count,String name){
        this.count = count;
        this.name = name;
    }
    @Override
    public void run() {

        while (count > 0){

            System.out.println(Thread.currentThread().getName() + " reading " + name);

            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            --count;
        }
    }
}
