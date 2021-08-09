package com.lhalj.java.escape.copy_on_rite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 描述: 使用 CopyOnWrite 并发读写不会抛出异常
 * CopyOnWrite优缺点
 * 优点: 并发读不需要加锁 提高了程序的并发性
 * 缺点: 内存占用问题 一致性问题 最终一致性没问题  不能保证数据的实时一致性
 * 应用场景: 适合读多少写的并发场景 例如白名单 黑名单
 * 注意 减少扩容开销 使用批量添加
 */
public class TaskPoolNoProblem {

    private static final List<String> tasks = new CopyOnWriteArrayList<>();

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
