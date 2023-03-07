package com.tradingbot.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Runnable {    

    private String taskId;

    @Override
    public void run() {
        System.out.println(this.toString());
        System.out.println("Task: " + this.taskId + "Executed at: " + new Date());
    }
}
