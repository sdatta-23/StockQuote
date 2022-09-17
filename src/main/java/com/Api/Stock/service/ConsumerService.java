package com.Api.Stock.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Api.Stock.dto.QuotationCustomResponseDTO;
import com.Api.Stock.response.QuoteResponse;
import com.Api.Stock.dto.Custom_Global_Quote;

@Service
public class ConsumerService 
{
	
	@Value("${alphavantage.api.host}")
	private String externalHost;

	@Value("${alphavantage.function.globalquote}")
	private String globalquoteFunction;
	
	@Value("${alphavantage.api.key}")
	private String apiKey;
	

	public String getStockQuotationsAsString(String symbol) 
	{
		
		String url = externalHost+"/query?function="+globalquoteFunction+"&symbol="+symbol+"&apikey="+apiKey;
		RestTemplate rest_template = new RestTemplate();  
		String stock_quotes = rest_template.getForObject(url, String.class);
		System.out.println(stock_quotes);
		return stock_quotes;
	}

	public QuotationCustomResponseDTO getQuotationServiceResponse(String symbol) {
		String url = externalHost+"/query?function="+globalquoteFunction+"&symbol="+symbol+"&apikey="+apiKey;
		RestTemplate rest_template = new RestTemplate();
		QuotationCustomResponseDTO customResponseDTO = new QuotationCustomResponseDTO();
		QuoteResponse response = rest_template.getForObject(url, QuoteResponse.class);
		
		if(response!=null) 
		{		
			Custom_Global_Quote customGlobalQuote= new Custom_Global_Quote();

			customGlobalQuote.setSymbol(response.getGlobalquote().getSymbol());
			customGlobalQuote.setOpen(response.getGlobalquote().getOpen());
			customGlobalQuote.setHigh(response.getGlobalquote().getHigh());
			customGlobalQuote.setLow(response.getGlobalquote().getLow());
			customGlobalQuote.setPrice(response.getGlobalquote().getPrice());
			customGlobalQuote.setVolume(response.getGlobalquote().getVolume());
			
			double previousClose= Double.parseDouble(response.getGlobalquote().getPreviousClose());
			double todayOpen = Double.parseDouble(response.getGlobalquote().getOpen());
			double currentPrice= Double.parseDouble(response.getGlobalquote().getPrice());
			
			if(todayOpen>previousClose) 
			{
				customGlobalQuote.setDayStartIndicator("GREEN");
			}
				else 
				{
					customGlobalQuote.setDayStartIndicator("RED");
				}
			
			if(currentPrice>previousClose) 
			{
				customGlobalQuote.setCurrentIndicator("GREEN");
			}
				else 
				{
					customGlobalQuote.setCurrentIndicator("RED");
				}
			
			customResponseDTO.setCustQuote(customGlobalQuote);
		}
		
		System.out.println(customResponseDTO);
		return customResponseDTO;
	}

}
