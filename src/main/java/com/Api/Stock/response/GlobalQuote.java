package com.Api.Stock.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GlobalQuote {
	@JsonProperty("01. symbol")
	private String  symbol = null;
	
	@JsonProperty("02. open")
	private String  open = null;
	
	@JsonProperty("03. high")
	private String  high = null;
	
	@JsonProperty("04. low")
	private String  low = null;
	
	@JsonProperty("05. price")
	private String  price = null;
	
	@JsonProperty("06. volume")
	private String  volume = null;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	
}
