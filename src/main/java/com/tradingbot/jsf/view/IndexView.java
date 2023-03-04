package com.tradingbot.jsf.view;

import jakarta.faces.view.ViewScoped;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
public class IndexView {
	
	public String check() {
		return "hello from Component";
	}
	
}
