package com.Api.Stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuotationCustomResponseDTO {

	@JsonProperty("Custom Quotes")
	private Custom_Global_Quote custQuote= null;
	
	public Custom_Global_Quote getCustQuote()
	{
		return custQuote;
	}
	
	public void setCustQuote(Custom_Global_Quote custQuote)
	{
		this.custQuote = custQuote;
	}
}
