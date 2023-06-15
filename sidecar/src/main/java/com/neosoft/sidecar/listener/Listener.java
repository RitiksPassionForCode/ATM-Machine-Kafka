package com.neosoft.sidecar.listener;

import java.util.Properties;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.kafka.support.serializer.JsonSerde;

import com.neosoft.sidecar.dto.Account;

public class Listener {

	public void consume() {

		Properties props = new Properties();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "account-transaction-listener");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

		StreamsBuilder builder = new StreamsBuilder();

		KStream<String, Account> accountBalanceStream = builder.stream("account-transactions",
				Consumed.with(Serdes.String(), new JsonSerde<>(Account.class)));

		accountBalanceStream.foreach((key, value) -> {
			// Handle account balance update event
			// Check if the account balance falls below 100 EUR and notify the user
			if (value.getBalance() < 100) {
				System.out.println("Account " + key + " balance is below 100 EUR.");
			}
		});

		// Build and start Kafka Streams application
		KafkaStreams streams = new KafkaStreams(builder.build(), props);
		streams.start();

		// Add shutdown hook to gracefully close the application
		Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

	}
}
