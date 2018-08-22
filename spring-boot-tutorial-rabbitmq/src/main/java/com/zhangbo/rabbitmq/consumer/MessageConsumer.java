package com.zhangbo.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

	@RabbitListener(queues = "test")
	public void listener(String message) {
		System.out.println(message);
	}
}
