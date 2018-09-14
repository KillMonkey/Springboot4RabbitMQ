
/*
 * Copyright @ 2018 Springboot4RabbitMQ 下午4:01:34 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.producer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabbit.Springboot4RabbitMQ.entity.Student;


/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年9月9日 下午4:01:34
 * @history:
 * @version: v1.0
 */
@Component
public class StudentSend
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Student student)
    {
        CorrelationData correlationData = new CorrelationData(student.getMessageId());
        rabbitTemplate.convertAndSend("student-exchange", "student.producer", student, correlationData);
    }
}
