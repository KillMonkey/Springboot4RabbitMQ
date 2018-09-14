package com.rabbit.Springboot4RabbitMQ;


import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabbit.Springboot4RabbitMQ.entity.Order;
import com.rabbit.Springboot4RabbitMQ.entity.Student;
import com.rabbit.Springboot4RabbitMQ.producer.RabbitOrderSender;
import com.rabbit.Springboot4RabbitMQ.producer.StudentSend;
import com.rabbit.Springboot4RabbitMQ.service.OrderService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot4RabbitMqApplicationTests
{

    @Autowired
    private StudentSend studentSend;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RabbitOrderSender rabbitOrderSender;

    @Test
    public void contextLoads()
    {
        System.out.println("Hello JunitTest");
    }

    @Test
    public void testSendStudent()
    {
        Student student = new Student();
        student.setId("41282919930303");
        student.setName("wuxiao");
        student.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
        studentSend.send(student);
    }

    @Test
    public void testSendOrder()
        throws Exception
    {
        Order order = new Order();
        order.setId("20160323");
        order.setName("First Work");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
        orderService.createOrder(order);
        // rabbitOrderSender.sendOrder(order);

    }

}
