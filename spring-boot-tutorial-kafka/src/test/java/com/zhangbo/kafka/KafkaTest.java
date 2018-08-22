package com.zhangbo.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class KafkaTest {

	@Autowired
	KafkaTemplate kafkaTemplate;

	@Test
	public void sendMessage() {
		for (int i = 0; i < 100; i++) {
			ListenableFuture future = kafkaTemplate.send("test", "hello kafka-" + i);

			future.addCallback(new ListenableFutureCallback() {

				@Override
				public void onFailure(Throwable throwable) {
					System.out.println("发送失败");
				}

				@Override
				public void onSuccess(Object o) {
					System.out.println("发送成功");
				}
			});
		}

	}

}
