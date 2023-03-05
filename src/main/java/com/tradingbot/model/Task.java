package com.tradingbot.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Runnable {    
    private long delay;
    private long initialDelay = 1;
    private TimeUnit timeUnit = TimeUnit.MINUTES;

    @Override
    public void run() {
        System.out.println(this.toString());
        System.out.println("Task executed at " + new Date());
    }
}
