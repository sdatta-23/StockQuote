package com.Api.Stock.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class quoteResponse {
 
	@JsonProperty("Global quotes")
	private GlobalQuote globalquote = null;

	public GlobalQuote getGlobalquote() {
		return globalquote;
	}

	public void setGlobalquote(GlobalQuote globalquote) {
		this.globalquote = globalquote;
	}
	
	
}
