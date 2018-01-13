package com.fuyi.receiver;

import com.fuyi.StreamHelloApplication;
import com.fuyi.sender.SinkSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * 在@EnableBinding中指定SinkSender，使Spring Cloud Stream 能创建出对应的实例。
 *
 * 它@EnableBinding用来指定一个或多个定义了@Input或@Output注解的接口，以此实现对消息通道的绑定。
 *
 * 它@StreamListener作用是将被修饰的方法注册为消息中间件上数据流的事件监听器，注解中的属性之对应了监听的消息通道名。
 *
 * Created by fuyi on 2018/1/10.
 */
@EnableBinding(value= {Sink.class, SinkSender.class})
public class SinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(StreamHelloApplication.class);

    @StreamListener(Sink.INPUT) //从sink的通道消费消息
    public void receive(Object payload){
        logger.info("Received: " + payload);
    }
}
