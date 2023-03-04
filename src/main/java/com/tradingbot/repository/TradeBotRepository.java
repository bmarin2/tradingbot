package com.tradingbot.repository;

import com.tradingbot.model.TradeBot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeBotRepository extends JpaRepository<TradeBot, Long> {
	
}
