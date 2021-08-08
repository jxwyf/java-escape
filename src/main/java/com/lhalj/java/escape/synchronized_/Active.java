package com.lhalj.java.escape.synchronized_;

/**
 * 描述:对value进行减法操作
 */
public class Active implements Runnable{

    private int value = 1000;

    @Override
    public void run() {

        String name = Thread.currentThread().getName();

        while (true){
            if(value > 0){
                System.out.println(name + " start :" + value);
                value--;
                System.out.println(name + " done :" + value);
            }else {
                break;
            }
        }

    }
}
