package com.yjf.exchange_comfirm.demo;

import com.yjf.exchange_comfirm.ExchangeComfirmApplication;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author 余俊锋
 * @date 2020/12/23 20:55
 * @Description
 */

@SpringBootTest(classes = ExchangeComfirmApplication.class)
public class Demo {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 确认模式：
     */
    @Test
    public void testConfirm() {
        // 发送消息   故意写错交换机
        rabbitTemplate.convertAndSend("test_exchange_confirm2", "confirm", "message confirm....");
    }
}
