package com.lhalj.java.escape.threadpool;

import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:自定义线程工厂 带有监控功能
 */
public class ExecutorsUtil extends ThreadPoolExecutor {
    /**
     * 关闭
     *
     * @return boolean
     */
    @Override
    public boolean isShutdown() {
        System.out.println(String.format(""));
        return super.isShutdown();
    }

    @Override
    public boolean isTerminating() {
        return super.isTerminating();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
    }

    private ConcurrentHashMap<String, Date> startTimes;
    private String poolName;


    public ExecutorsUtil(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                         TimeUnit unit, BlockingQueue<Runnable> workQueue,
                         String poolName){
        super(corePoolSize,maximumPoolSize,keepAliveTime,unit,workQueue,
                new ExecutorsUtil.EventThreadFactory(poolName));

        this.startTimes = new ConcurrentHashMap<>();
        this.poolName = poolName;
    }


    /**
     * 线程工厂
     */
    private static class EventThreadFactory implements ThreadFactory{

        //线程池编号
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        //线程编号
        private static final AtomicInteger threadNumber = new AtomicInteger(1);
        //线程名字
        private final String namePrefix;

        EventThreadFactory(String poolName){
            SecurityManager s = System.getSecurityManager();
            //线程池组
            group = (s !=null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = poolName + "-pool-" +
                    poolNumber.getAndIncrement() + "-thread";
        }
        @Override
        public Thread newThread(Runnable r) {


            Thread t = new Thread(group,r,
                    namePrefix + threadNumber.getAndIncrement(),
            0 //内部局部变量 当前线程指定栈的大小
            );
            //如果是守护线程
            if(t.isDaemon()){
                t.setDaemon(false);
            }
            //优先级
            if(t.getPriority() != Thread.NORM_PRIORITY){
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }


}
