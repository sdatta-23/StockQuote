package com.Api.Stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Custom_Global_Quote {

	@JsonProperty("Symbol")
	private String Symbol = null;
	
	@JsonProperty("Open")
	private String Open = null;
	
	@JsonProperty("High")
	private String High = null;
	
	@JsonProperty("Low")
	private String Low = null;
	
	@JsonProperty("Price")
	private String Price = null;
	
	@JsonProperty("Volume")
	private String Volume = null;

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public String getOpen() {
		return Open;
	}

	public void setOpen(String open) {
		Open = open;
	}

	public String getHigh() {
		return High;
	}

	public void setHigh(String high) {
		High = high;
	}

	public String getLow() {
		return Low;
	}

	public void setLow(String low) {
		Low = low;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getVolume() {
		return Volume;
	}

	public void setVolume(String volume) {
		Volume = volume;
	}
	
	
}
