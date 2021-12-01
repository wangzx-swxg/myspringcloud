package com.hzx.springcloud.service.impl;

import cn.hutool.core.lang.UUID;
import com.hzx.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/*
 * @author
 * @param   @EnableBinding(Source.class)定义消息的推送管道，将Channel和Exchange绑定在一起
 * @return
 */
@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessageProvider {
    /*
     * @author
     * @param  消息发送管道
     * @return
     */
    @Resource
    private MessageChannel output;
    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        Message<String> build = MessageBuilder.withPayload(s).build();
        output.send(build);
        System.out.println("serial====" + s);
        return null;
    }
}
