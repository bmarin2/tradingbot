package com.tradingbot.scheduler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;


@Configuration
@EnableScheduling
public class ScheduledTaskConfig implements SchedulingConfigurer {
    private ScheduledThreadPoolExecutor executor;
    private final Map<String, ScheduledFuture<?>> scheduledTasks = new ConcurrentHashMap<>();

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        executor = new ScheduledThreadPoolExecutor(10);
        taskRegistrar.setScheduler(executor);
    }

    public void addTask(String taskName, Runnable task, long initialDelay, long delay, TimeUnit unit) {
		ScheduledFuture<?> scheduledTask = executor.scheduleWithFixedDelay(task, initialDelay, delay, unit);
		scheduledTasks.put(taskName, scheduledTask);
    }

    public void removeTask(String taskName) {
        ScheduledFuture<?> scheduledTask = scheduledTasks.get(taskName);
        if (scheduledTask != null) {
            scheduledTask.cancel(true);
            scheduledTasks.remove(taskName);
        }
    }
}
