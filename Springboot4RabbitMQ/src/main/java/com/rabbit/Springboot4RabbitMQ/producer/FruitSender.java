
/*
 * Copyright @ 2018 Springboot4RabbitMQ 下午9:58:38 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.producer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabbit.Springboot4RabbitMQ.entity.Fruit;


/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年10月9日 下午9:58:38
 * @history:
 * @version: v1.0
 */

@Component
public class FruitSender
{
    private String exchange = "fruit-exchange";

    private String routingKey = "fruit-exchange";

    /*
     * @Bean public MessageConverter jsonMessageConverter(ObjectMapper objectMapper) { return new
     * Jackson2JsonMessageConverter(objectMapper); }
     */

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Fruit fruit)
    {
        rabbitTemplate.convertAndSend(exchange, routingKey, fruit);
    }

}
