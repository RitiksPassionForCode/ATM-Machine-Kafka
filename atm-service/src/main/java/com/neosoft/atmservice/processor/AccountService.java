package com.neosoft.atmservice.processor;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.neosoft.atmservice.events.AccountCreatedEvent;
import com.neosoft.atmservice.events.MoneyDepositedEvent;
import com.neosoft.atmservice.events.MoneyWithdrawnEvent;

public class AccountService {

	public void kafkaUserCreatedProducer(String accountNo, int userId, int initialBalance) {

		Properties producerConfig = new Properties();
		producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		KafkaProducer<String, Object> producer = new KafkaProducer<>(producerConfig);

		AccountCreatedEvent accountCreatedEvent = new AccountCreatedEvent(accountNo, userId, initialBalance);
		producer.send(new ProducerRecord<>("account-events", accountCreatedEvent.getAccountId(), accountCreatedEvent));
	}

	public void kafkaAmountDepositProducer(String accountNo, int amount) {

		Properties producerConfig = new Properties();
		producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		KafkaProducer<String, Object> producer = new KafkaProducer<>(producerConfig);

		MoneyDepositedEvent moneyDepositedEvent = new MoneyDepositedEvent(accountNo, amount);
		producer.send(new ProducerRecord<>("account-events", moneyDepositedEvent.getAccountId(), moneyDepositedEvent));
	}
	
	public void kafkaAmountWithdranProducer(String accountNo, int amount) {

		Properties producerConfig = new Properties();
		producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		KafkaProducer<String, Object> producer = new KafkaProducer<>(producerConfig);

		MoneyWithdrawnEvent moneyWithdrawnEvent = new MoneyWithdrawnEvent(accountNo, amount);
		producer.send(new ProducerRecord<>("account-events", moneyWithdrawnEvent.getAccountId(), moneyWithdrawnEvent));
	}

}
