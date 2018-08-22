package com.zhangbo.rabbitmq;

import com.zhangbo.rabbitmq.producter.MessageProducter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitmqTest {

	@Autowired
	private MessageProducter messageProducter;

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Test
	public void rabbitmqSend() {
		amqpTemplate.convertAndSend("test", "hello rabbitmq");
	}

}
