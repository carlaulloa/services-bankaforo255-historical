package com.app.aforo255.historical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.aforo255.historical.model.entity.Transaction;
import com.app.aforo255.historical.service.ITransactionService;

@RestController
public class HistoricalController {

	private @Autowired ITransactionService transactionService;
	
	@GetMapping("/v1/transactions")
	public List<Transaction> findAll(){
		return this.transactionService.findAll();
	}
	
	@GetMapping("/v1/transactions/accounts/{accountId}")
	public List<Transaction> findByAccountId(@PathVariable Integer accountId){
		return this.transactionService.findByAccointId(accountId);
	}
	
}
