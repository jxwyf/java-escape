package com.lhalj.java.escape.copy_on_rite;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:并发读写会抛出异常
 */
public class TaskPoolProblem {

    //ArrayList线程不安全
    private static final List<String> tasks = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        for (int i = 0; i !=10; i++) {
            tasks.add("task-" + i);
        }


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    tasks.add("task-x");
                }
            }
        });

        //守护进程方式
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(1000L);

        //读取任务
        for(String task: tasks){
            System.out.println(task);
        }
    }

}
