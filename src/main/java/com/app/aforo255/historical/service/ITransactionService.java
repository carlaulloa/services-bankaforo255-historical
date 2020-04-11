package com.app.aforo255.historical.service;

import java.util.List;

import com.app.aforo255.historical.model.entity.Transaction;

public interface ITransactionService {
	
	public List<Transaction> findAll();
	
	public List<Transaction> findByAccointId(Integer accountId);

	public Transaction save(Transaction transaction);
}
