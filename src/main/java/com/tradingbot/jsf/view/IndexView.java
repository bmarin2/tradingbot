package com.tradingbot.jsf.view;

import com.tradingbot.model.Task;
import com.tradingbot.model.TradeBot;
import com.tradingbot.repository.TradeBotRepository;
import com.tradingbot.service.TaskService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
@Data
public class IndexView implements Serializable {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TradeBotRepository tradeBotRepository;
	
	private List<TradeBot> bots;

	private TradeBot selectedTradeBot;

	@PostConstruct
	private void init() {
		selectedTradeBot = new TradeBot();
		bots = getAllBots();
	}
	
	private List<TradeBot> getAllBots() {
		return tradeBotRepository.findAll();
	}
	
	public void updateBot() {
		Task task = new Task();
		task.setTradeBot(selectedTradeBot);
		
		taskService.addTask(selectedTradeBot.getTaskId(),
				task, 
				selectedTradeBot.getInitialDelay(),
				selectedTradeBot.getDelay(),
				selectedTradeBot.getTimeUnit());
		
		tradeBotRepository.saveAndFlush(selectedTradeBot);
		System.out.println(selectedTradeBot);
		PrimeFaces.current().executeScript("PF('manageBot').hide()");
		//PrimeFaces.current().ajax().update("form:messages", "form:dt-releases");
	}
	
	public void newBot() {
		selectedTradeBot = new TradeBot();
	}
	
	public boolean isBotRunning(String taskId) {
		return taskService.getScheduledTasks().containsKey(taskId);
	}

	public TimeUnit[] getUnits() {
		return TimeUnit.values();
	}

	public void confirmStop(){
		System.out.println("BOT STOPPED");
	}
}
