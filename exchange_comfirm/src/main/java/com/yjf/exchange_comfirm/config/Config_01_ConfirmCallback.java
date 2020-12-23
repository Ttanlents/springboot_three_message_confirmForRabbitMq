package com.yjf.exchange_comfirm.config;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Config_01_ConfirmCallback implements RabbitTemplate.ConfirmCallback {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    private void init() {
        rabbitTemplate.setConfirmCallback(this);
    }

    /**
     * @param correlationData: 配置相关信息
     * @param ack:             交换机是否成功收到消息
     * @param cause:           失败原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {

        System.out.println("confirm executed...");

        if (ack) {
            System.out.println("success: " + cause);
        }else{
            System.out.println("error: " + cause);
        }
    }
}