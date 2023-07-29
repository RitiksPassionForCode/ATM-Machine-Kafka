package com.neosoft.sidecar.listener;

import java.time.Duration;
import java.util.Collections;
import java.util.Optional;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.connect.json.JsonDeserializer;
import org.springframework.beans.factory.annotation.Autowired;

import com.neosoft.atmservice.entity.User;
import com.neosoft.atmservice.events.MoneyWithdrawnEvent;
import com.neosoft.atmservice.repository.UserRepository;

public class NotificationsService {
	
	@Autowired
	private UserRepository repository;

	public void notification() {
		
		Properties consumerConfig = new Properties();
		consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		KafkaConsumer<String, Object> consumer = new KafkaConsumer<>(consumerConfig);
		consumer.subscribe(Collections.singletonList("account-events"));
		
		while (true) {
		    ConsumerRecords<String, Object> records = consumer.poll(Duration.ofMillis(100));
		    for (ConsumerRecord<String, Object> record : records) {
		        // Process the event
		        Object event = record.value();
		        if (event instanceof MoneyWithdrawnEvent) {
		            MoneyWithdrawnEvent moneyWithdrawnEvent = (MoneyWithdrawnEvent) event;
		            // Check if the balance falls below 100 EUR
		            if (moneyWithdrawnEvent.getAmount() > getCurrentAccountBalance(moneyWithdrawnEvent.getAccountNo())) {
		                // Send a notification to the user
		                sendBalanceNotification(moneyWithdrawnEvent.getAccountNo());
		            }
		        }
		    }
		    consumer.close();
		}
	}

	private void sendBalanceNotification(String accountNo) {
		 System.out.println("Sending balance notification for account: " + accountNo);
		 System.out.println("Your account balance has fallen below 100 EUR. Please take necessary actions.");
		
	}

	private double getCurrentAccountBalance(String accountNo) {
		Optional<User> userAccount = repository.findByAccountNumber(accountNo);
		double balance = 0.0;
		if(userAccount.isPresent()) {
			balance = userAccount.get().getBalance();
		} else {
			System.out.println("Failed to get balance for account: " + accountNo);
		}
			return balance;
	}
	
	
	
}
