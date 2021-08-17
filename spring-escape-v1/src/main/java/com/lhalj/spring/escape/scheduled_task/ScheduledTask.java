package com.lhalj.spring.escape.scheduled_task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 描述:
 */
@Slf4j
@Component
public class ScheduledTask {


    @Scheduled(fixedRate = 1000)
    public void task01() throws Exception{
        log.info("Schedule Task process task01.");
        while (true){
            Thread.sleep(2000);
            log.info("Schedule Task process something!");
        }
    }


    @Scheduled(fixedRate = 1000)
    public void task02() throws Exception{
        log.info("Schedule Task process task02.");

    }


}
