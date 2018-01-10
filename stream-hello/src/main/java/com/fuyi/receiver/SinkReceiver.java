package com.fuyi.receiver;

import com.fuyi.StreamHelloApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by fuyi on 2018/1/10.
 */
@EnableBinding(Sink.class)
public class SinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(StreamHelloApplication.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        logger.info("Received: " + payload);
    }
}
