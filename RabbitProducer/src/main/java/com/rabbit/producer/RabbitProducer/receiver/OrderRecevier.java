
/*
 * Copyright @ 2018 RabbitProducer 上午10:25:29 All right reserved.
 */

package com.rabbit.producer.RabbitProducer.receiver;


import java.util.Map;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.rabbit.producer.RabbitProducer.entity.Order;
import com.rabbit.producer.RabbitProducer.util.JsonConvertUtils;
import com.rabbitmq.client.Channel;


/**
 * @desc: RabbitProducer
 * @author: 吴晓
 * @createTime: 2018年9月17日 上午10:25:29
 * @history:
 * @version: v1.0
 */

@Component
public class OrderRecevier
{

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${spring.rabbitmq.listener.order.queue.name}", durable = "${spring.rabbitmq.listener.order.queue.durable}"), exchange = @Exchange(value = "${spring.rabbitmq.listener.order.exchange.name}", durable = "${spring.rabbitmq.listener.order.exchange.durable}", type = "${spring.rabbitmq.listener.order.exchange.type}", ignoreDeclarationExceptions = "${spring.rabbitmq.listener.order.exchange.ignoreDeclarationeExceptions}"), key = "${spring.rabbitmq.listener.order.key}"))
    public void onOrderMessage(@Payload JSONObject object, Channel channel, @Headers Map<String, Object> headers)
        throws Exception
    {
        System.err.println("----------------------------------");
        Order order = JsonConvertUtils.convertJSONToObject(object);
        System.err.println("消费端Order: " + order.toString());
        Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);

    }

}
