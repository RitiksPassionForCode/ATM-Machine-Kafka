//package com.neosoft.atmservice.config;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.annotation.EnableKafkaStreams;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//
//import com.fasterxml.jackson.databind.JsonSerializable;
//import com.fasterxml.jackson.databind.ser.std.StringSerializer;
//import com.neosoft.atmservice.entity.Deposit;
//
//@Configuration
//@EnableKafka
//@EnableKafkaStreams
//public class KafkaProducerConfig {
//
//	@Value("${spring.kafka.producer.bootstrap-servers}")
//	private String bootStrapServer;
//	
//	public KafkaTemplate<String, Deposit> kafkaTemplate(){
//		return new KafkaTemplate<>(producerfactory());
//	}
//
//	public ProducerFactory<String, Deposit> producerfactory() {
//		Map<String,Object> map = new HashMap<>();
//		map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
//		map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializable.class);
//		return new DefaultKafkaProducerFactory<>(map);
//	}
//}
