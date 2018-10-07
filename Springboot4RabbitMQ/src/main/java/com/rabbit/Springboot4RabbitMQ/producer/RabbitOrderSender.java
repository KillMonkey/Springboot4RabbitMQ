
/*
 * Copyright @ 2018 Springboot4RabbitMQ 下午7:10:21 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.producer;


import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabbit.Springboot4RabbitMQ.constant.Constants;
import com.rabbit.Springboot4RabbitMQ.entity.Order;
import com.rabbit.Springboot4RabbitMQ.mapper.BrokerMessageLogMapper;
import com.rabbit.Springboot4RabbitMQ.utils.FastJsonConvertUtil;


/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年9月12日 下午7:10:21
 * @history:
 * @version: v1.0
 */
@Component
public class RabbitOrderSender
{

    // 自动注入RabbitTemplate模板类
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;

    // 回调函数: confirm确认
    final ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback()
    {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause)
        {
            System.err.println("correlationData: " + correlationData);
            String messageId = correlationData.getId();
            if (ack)
            {
                // 如果confirm返回成功 则进行更新
                int num = brokerMessageLogMapper.changeBrokerMessageLogStatus(messageId, Constants.ORDER_SEND_SUCCESS, new Date());
                System.err.println("num:" + num);
            }
            else
            {
                // 失败则进行具体的后续操作:重试 或者补偿等手段
                System.err.println("异常处理...");
            }
        }
    };

    // 发送消息方法调用: 构建自定义对象消息
    public void sendOrder(Order order)
        throws Exception
    {
        rabbitTemplate.setConfirmCallback(confirmCallback);
        // 消息唯一ID
        CorrelationData correlationData = new CorrelationData(order.getMessageId());
        rabbitTemplate.convertAndSend("order-exchange", "order.ABC", FastJsonConvertUtil.toJsonObject(order), correlationData);
    }
}
