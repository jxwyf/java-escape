package com.lhalj.spring.escape.async_task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 描述:异步任务配置类
 */
@Configuration
@Slf4j
public class AsyncTaskConfig implements AsyncConfigurer {

    //线程池
    @Override
    public Executor getAsyncExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("imooc-2021-task-");
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(8);
        executor.setKeepAliveSeconds(5);
        executor.setQueueCapacity(100);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy()); //拒绝策略

        //设置线程池关闭的时候 等待所有任务都完成
        executor.setWaitForTasksToCompleteOnShutdown(true);

        //线程等待时间
        executor.setAwaitTerminationSeconds(60);

        //初始化
        executor.initialize();

        return executor;
    }

    //异步任务出错处理器
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
                //TODO 发送报警邮件 短信等等
                log.error("Async Task Has Some Error:{},{},{}",throwable.getMessage(),
                        method.getDeclaringClass().getName() + "." + method.getName(),
                        Arrays.toString(objects));
            }
        };
    }
}
