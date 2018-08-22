package com.zhangbo.rabbitmq.producter;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProducter {

	private final AmqpAdmin amqpAdmin;

	private final AmqpTemplate amqpTemplate;

	@Autowired
	public MessageProducter(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate) {
		this.amqpAdmin = amqpAdmin;
		this.amqpTemplate = amqpTemplate;
	}

	public void sendMessage(String message) {
		amqpTemplate.convertAndSend("test", message);
	}

}
