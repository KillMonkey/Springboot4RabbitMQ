
/*
 * Copyright @ 2018 Springboot4RabbitMQ 下午6:53:14 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.service;


import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbit.Springboot4RabbitMQ.constant.Constants;
import com.rabbit.Springboot4RabbitMQ.entity.BrokerMessageLog;
import com.rabbit.Springboot4RabbitMQ.entity.Order;
import com.rabbit.Springboot4RabbitMQ.mapper.BrokerMessageLogMapper;
import com.rabbit.Springboot4RabbitMQ.mapper.OrderMapper;
import com.rabbit.Springboot4RabbitMQ.producer.RabbitOrderSender;
import com.rabbit.Springboot4RabbitMQ.utils.FastJsonConvertUtil;


/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年9月12日 下午6:53:14
 * @history:
 * @version: v1.0
 */
@Service
public class OrderService
{
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;

    @Autowired
    private RabbitOrderSender rabbitOrderSender;

    public void createOrder(Order order)
        throws Exception
    {
        // 使用当前时间当做订单创建时间（为了模拟一下简化）
        Date orderTime = new Date();
        // 插入业务数据
        orderMapper.insertOrde(order);
        // 插入消息记录表数据
        BrokerMessageLog brokerMessageLog = new BrokerMessageLog();
        // 消息唯一ID
        brokerMessageLog.setMessageId(order.getMessageId());
        // 保存消息整体 转为JSON 格式存储入库
        brokerMessageLog.setMessage(FastJsonConvertUtil.convertObjectToJSON(order));
        // 设置消息状态为0 表示发送中
        brokerMessageLog.setStatus("0");
        // 设置消息未确认超时时间窗口为 一分钟
        brokerMessageLog.setNextRetry(DateUtils.addMinutes(orderTime, Constants.ORDER_TIMEOUT));
        brokerMessageLog.setCreateTime(new Date());
        brokerMessageLog.setUpdateTime(new Date());

        brokerMessageLog.setTryCount(0);
        brokerMessageLogMapper.insertMessageLog(brokerMessageLog);
        // 发送消息
        rabbitOrderSender.sendOrder(order);
    }

}
