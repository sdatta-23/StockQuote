package com.Api.Stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Api.Stock.dto.QuotationCustomResponseDTO;
import com.Api.Stock.service.ConsumerService;

@RestController
@RequestMapping(path="stockings")

public class StockController {
	
	@Autowired
	ConsumerService consumerService;
	
	@GetMapping("/quotations/asString")
	public String getStockQuotationsAsString(@RequestParam String symbol) 
	{
		System.out.println("Calls the Global Quotes as String API");
		return consumerService.getStockQuotationsAsString(symbol);
	}
	//this one 2nd round
	@GetMapping("quotations")
	public QuotationCustomResponseDTO getStockQuotations(@RequestParam String symbol)
	{
		System.out.println("Calls the Global Quotes normally (withou STRING) API");
		return consumerService.getQuotationServiceResponse(symbol);
	}

}
