package com.tradingbot.model;

import com.tradingbot.service.TaskCodeGeneratorService;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TradeBot implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String symbol;
	
	@Column
	private LocalDateTime createdDate = LocalDateTime.now();
	
	@Column
	private String taskId = TaskCodeGeneratorService.generateRandomString();
	
	@Column
	private Integer orderPrice = 10;
	
	@Column // max orders in a cycle
	private Integer cycleMaxOrders = 5;
	
	@Column
	private Double orderStep = 0.6;
	
	@Column
	private String description;
	
	@Column
	private long initialDelay = 1;
		
	@Column
	private long delay = 5;
	
	@Column
	private TimeUnit timeUnit = TimeUnit.MINUTES;
	
	@Column
	private TradeBotStatus status = TradeBotStatus.RUNNING;
	
}
