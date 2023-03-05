package com.tradingbot.jsf.view;

import com.tradingbot.model.Task;
import com.tradingbot.model.TradeBot;
import com.tradingbot.service.TaskService;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
public class IndexView implements Serializable {
    
    @Autowired
    private TaskService taskService;

    public void createBot() {
        TradeBot tradeBot = new TradeBot();
        tradeBot.setSymbol("BTCUSDT");

        Task task = new Task();
        task.setDelay(1);

        taskService.addTask(tradeBot.getTaskId(), task, task.getInitialDelay(), task.getDelay(), task.getTimeUnit());
        System.out.println("The size of thread pool is: " + taskService.getScheduledTasks().size());
    }
    public String samp() {
        System.out.println("jfldsjflskjdflajsdlfjlk");
        return "hellllooooo";
    }
}
