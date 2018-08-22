package com.zhangbo.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "test")
	public void processMessage(ConsumerRecord<?, ?> record) {
		System.out.println("message" + String.valueOf(record.value()));
	}

}
