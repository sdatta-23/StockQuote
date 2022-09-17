package com.Api.Stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Api.Stock.dto.QuotationCustomResponseDTO;
import com.Api.Stock.service.ConsumerService;

@RestController
@RequestMapping(path="stocks")

public class StockController {
	
	@Autowired
	ConsumerService consumerService;
	
	//Consuming Global Quotes API as String Response
	@GetMapping("/quotes/asString")
	public String getStockQuotationsAsString(@RequestParam String symbol) 
	{
		System.out.println("Calling the Global Quotes API as String Response");
		return consumerService.getStockQuotationsAsString(symbol);
	}
	//Consuming Global Quotes API with Proper Response Object
	@GetMapping("/quotes")
	public QuotationCustomResponseDTO getStockQuotations(@RequestParam String symbol)
	{
		System.out.println("Calling the Global Quotes API with Proper Response Object");
		return consumerService.getQuotationServiceResponse(symbol);
	}

}
