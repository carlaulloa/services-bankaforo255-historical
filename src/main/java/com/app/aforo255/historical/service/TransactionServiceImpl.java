package com.app.aforo255.historical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.aforo255.historical.model.entity.Transaction;
import com.app.aforo255.historical.model.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService {

	private @Autowired TransactionRepository transactionRepository;
	
	@Override
	public List<Transaction> findAll() {
		return this.transactionRepository.findAll();
	}

	@Override
	public List<Transaction> findByAccointId(Integer accountId) {
		return (List<Transaction>) this.transactionRepository.findByAccountId(accountId);
	}

	@Override
	public Transaction save(Transaction transaction) {
		return this.transactionRepository.save(transaction);
	}

}
