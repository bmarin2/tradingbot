package com.tradingbot.api;

import java.util.LinkedHashMap;

public class OrdersParams {

	public static LinkedHashMap<String, Object> getOrderBuyParams(String symbol) {
		return getParams("BUY", symbol);
	}
	
	public static LinkedHashMap<String, Object> getOrderSellParams(String symbol) {
		return getParams("SELL", symbol);
	}
	
	private static LinkedHashMap<String, Object> getParams(String side, String symbol){
		
		LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();		
		parameters.put("symbol", symbol);
		parameters.put("side", side);
		parameters.put("type", "MARKET");
		parameters.put("timeInForce", "GTC");
		parameters.put("quoteOrderQty", 10);
		parameters.put("timestamp", System.currentTimeMillis());		
		return parameters;
	}
	
	public static LinkedHashMap<String, Object> getTickerSymbolParams(String symbol) {
		LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("symbol", symbol);
		return parameters;
	}
}
