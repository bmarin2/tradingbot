package com.tradingbot.model;

import com.binance.connector.client.impl.SpotClientImpl;
import com.tradingbot.api.OrdersParams;
import com.tradingbot.bean.SpotClientConfig;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Task implements Runnable {

	@Getter @Setter
	private TradeBot tradeBot;
	
	@Getter @Setter
	private SpotClientImpl spotClientImpl;
	
	public Task(){
		spotClientImpl = SpotClientConfig.spotClientOnlyBaseURLProd();
	}
	
	@Override
	public void run() {
		
		String result = spotClientImpl.createMarket().tickerSymbol(OrdersParams.getTickerSymbolParams(tradeBot.getSymbol()));
		
		System.out.println();
		System.out.println("Bot-ID: " + tradeBot.getTaskId() + " Executed at: " + LocalDateTime.now());
		System.out.println(result);
	}
}
