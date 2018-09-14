
/*
 * Copyright @ 2018 Springboot4RabbitMQ 上午11:37:31 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.controller;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.Springboot4RabbitMQ.entity.Order;
import com.rabbit.Springboot4RabbitMQ.service.OrderService;


/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年9月14日 上午11:37:31
 * @history:
 * @version: v1.0
 */
@RestController
@RequestMapping("/producer")
public class ProducerController
{
    @Autowired
    private OrderService orderService;

    @RequestMapping("/createOrder")
    public String createOrder(@RequestBody Order order)
        throws Exception
    {
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
        orderService.createOrder(order);
        return "success";
    }

    @RequestMapping("/test")
    public String hello()
    {
        return "Hello World!";
    }

}
