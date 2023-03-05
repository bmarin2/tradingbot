package com.tradingbot.service;

import jakarta.annotation.PostConstruct;
import java.util.Map;
import org.springframework.stereotype.Service;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import lombok.Data;

@Service
@Data
public class TaskService {
    
    public static final Logger LOGGER = Logger.getLogger(TaskService.class.getName());

    private ScheduledExecutorService executorService;

    private final Map<String, ScheduledFuture<?>> scheduledTasks = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        System.out.println("Constructing Executor service");
        executorService = Executors.newScheduledThreadPool(4); // creates a thread pool with 5 threads
    }

    public void addTask(String taskId, Runnable task, long initialDelay, long delay, TimeUnit unit) {
        ScheduledFuture<?> scheduledFuture = executorService.scheduleWithFixedDelay(task, initialDelay, delay, unit);
        scheduledTasks.put(taskId, scheduledFuture);
        LOGGER.info("Task added!");
        System.out.println("Task added!");
    }

    public void removeTask(String taskId) {
        ScheduledFuture<?> scheduledFuture = scheduledTasks.get(taskId);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            scheduledTasks.remove(taskId);
        }
    }
}