package com.Api.Stock.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteResponse {
 
	@JsonProperty("Global Quote")
	private GlobalQuote globalquote = null;

	public GlobalQuote getGlobalquote() {
		return globalquote;
	}

	public void setGlobalquote(GlobalQuote globalquote) {
		this.globalquote = globalquote;
	}
	
	
}
