package com.tradingbot.model;

import com.binance.connector.client.exceptions.BinanceClientException;
import com.binance.connector.client.exceptions.BinanceConnectorException;
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
		spotClientImpl = SpotClientConfig.spotClientSignTest();
	}
	
	@Override
	public void run() {
		
		
		long timeStamp = System.currentTimeMillis();
		
//		try {
//			String result = spotClientImpl.createTrade().newOrder(OrdersParams.getParams(tradeBot.getSymbol(), OrderSide.BUY, tradeBot.getQuoteOrderQty(), timeStamp));
//			System.out.println(result);
//		} catch (BinanceConnectorException e) {
//			System.err.println((String) String.format("fullErrMessage: %s", e.getMessage()));
//		} catch (BinanceClientException e) {
//			System.err.println((String) String.format("fullErrMessage: %s \nerrMessage: %s \nerrCode: %d \nHTTPStatusCode: %d",
//				e.getMessage(), e.getErrMsg(), e.getErrorCode(), e.getHttpStatusCode()));
//		}
	}
}
