package com.fuyi.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * 创建一个将Input消息通道作为输出通道的接口
 *
 * Created by fuyi on 2018/1/11.
 */
public interface SinkSender {

    @Output("input11") //向sink的input通道生产消息
    MessageChannel output();

}
