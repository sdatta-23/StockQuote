package com.Api.Stock.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Api.Stock.dto.QuotationCustomResponseDTO;
import com.Api.Stock.response.quoteResponse;
import com.Api.Stock.dto.Custom_Global_Quote;

@Service
public class ConsumerService {
	
	@Value("${alphavantage.api.host}")
	private String externalHost;

	@Value("${alphavantage.function.globalquote}")
	private String globalquoteFunction;
	
	@Value("${alphavantage.api.key}")
	private String apiKey;
	

	public String getStockQuotationsAsString(String Symbol) {
		
		String url = externalHost+"/query?function="+globalquoteFunction+"&Symbol="+Symbol+"&apiKey="+apiKey;
		RestTemplate rest_template = new RestTemplate();
		String stock_quotes = rest_template.getForObject(url, String.class);
		System.out.println(stock_quotes);
		return stock_quotes;
	}

	public QuotationCustomResponseDTO getQuotationServiceResponse(String Symbol) {
		String url = externalHost+"/query?function="+globalquoteFunction+"&Symbol="+Symbol+"&apiKey="+apiKey;
		RestTemplate rest_template = new RestTemplate();
		QuotationCustomResponseDTO qcDTO = new QuotationCustomResponseDTO();
		quoteResponse response = rest_template.getForObject(url, quoteResponse.class);
		
		if(response!=null) {		
			Custom_Global_Quote customGlobalQuote= new Custom_Global_Quote();
			customGlobalQuote.setSymbol(response.getGlobalquote().getSymbol());
			customGlobalQuote.setOpen(response.getGlobalquote().getOpen());
			customGlobalQuote.setHigh(response.getGlobalquote().getHigh());
			customGlobalQuote.setLow(response.getGlobalquote().getLow());
			customGlobalQuote.setPrice(response.getGlobalquote().getPrice());

			
			qcDTO.setCustQuote(customGlobalQuote);
		}
		
		System.out.println(qcDTO);
		return qcDTO;
	}

}
