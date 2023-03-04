package com.tradingbot.manager;

import com.tradingbot.model.TradeBot;
import com.tradingbot.repository.TradeBotRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeBotManager {
	
	@Autowired
	TradeBotRepository tradeBotRepository;

	public void createTradeBot(String symbol) {
		TradeBot tradeBot = new TradeBot();
		tradeBot.setSymbol(symbol);
		tradeBotRepository.save(tradeBot);
	}
	
	public List<TradeBot> getAllTradeBots() {
		return tradeBotRepository.findAll();
	}
	
	public TradeBot getTradeBot(long id) {
		return tradeBotRepository.findById(id).get();
	}
	
	public TradeBot updateTradeBot(long id, TradeBot bot) {
		TradeBot tradeBot = getTradeBot(id);
		
		tradeBot.setSymbol(bot.getSymbol());
		tradeBot.setCreatedDate(bot.getCreatedDate());
		
		return tradeBotRepository.save(tradeBot);
	}
	
	public void deleteTradeBot(TradeBot bot) {
		tradeBotRepository.delete(bot);
	}
}
