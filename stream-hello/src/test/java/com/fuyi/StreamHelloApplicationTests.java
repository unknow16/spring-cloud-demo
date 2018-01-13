package com.fuyi;

import com.fuyi.sender.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class StreamHelloApplicationTests {

	@Autowired
	//private SinkSender sinkSender;
	private MessageChannel input;

	@Test
	public void contextLoads() {
		input.send(MessageBuilder.withPayload("From sinkSender ").build());
	}

}
