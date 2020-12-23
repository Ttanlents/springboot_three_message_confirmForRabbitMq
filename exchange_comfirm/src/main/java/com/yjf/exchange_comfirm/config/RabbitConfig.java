package com.yjf.exchange_comfirm.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    /**
     * 定义direct交换机
     * @return
     */
    @Bean
    public Exchange testExchangeConfirm(){
        return ExchangeBuilder.directExchange("test_exchange_confirm").build();
    }

    /**
     * 定义一个队列
     * @return
     */
    @Bean
    public Queue testQueueConfirm(){
        return QueueBuilder.durable("test_queue_confirm").build();
    }

    /**
     * Queue和Exchange进行绑定
     * @return
     */
    @Bean
    public Binding testBindingConfirm(){

        Queue queue = testQueueConfirm();
        Exchange exchange = testExchangeConfirm();

        return BindingBuilder.bind(queue).to(exchange).with("confirm").noargs();
    }
}