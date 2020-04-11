package com.app.aforo255.historical.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.aforo255.historical.model.entity.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TransactionEvents {

	private static final Logger LOG = LoggerFactory.getLogger(TransactionEvents.class);
	
	private @Autowired ObjectMapper objectMapper;
	private @Autowired ITransactionService transactionService;
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, 
		JsonProcessingException {
		LOG.info("Before Process TransactionEvent {}", consumerRecord.value());
		Transaction transactionEvent = this.objectMapper.readValue(consumerRecord.value(), Transaction.class);
		LOG.info("TransactionEvent: {}", transactionEvent.getAccountId());
		this.transactionService.save(transactionEvent);
		LOG.info("Successfully Persisted transaction {}", transactionEvent);
	}
	
}
