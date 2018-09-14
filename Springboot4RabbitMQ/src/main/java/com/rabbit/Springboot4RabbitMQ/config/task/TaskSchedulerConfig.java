
/*
 * Copyright @ 2018 Springboot4RabbitMQ 下午12:00:25 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.config.task;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;


/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年9月12日 下午12:00:25
 * @history:
 * @version: v1.0
 */
@Configuration
@EnableScheduling
public class TaskSchedulerConfig implements SchedulingConfigurer
{

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar)
    {
        taskRegistrar.setScheduler(taskScheduler());
    }

    @Bean(destroyMethod = "shutdown")
    public Executor taskScheduler()
    {
        return Executors.newScheduledThreadPool(100);
    }

}
