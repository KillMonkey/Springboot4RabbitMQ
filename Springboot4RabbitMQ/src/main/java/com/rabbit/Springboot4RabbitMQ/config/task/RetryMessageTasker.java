
/*
 * Copyright @ 2018 Springboot4RabbitMQ 下午7:15:02 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.config.task;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rabbit.Springboot4RabbitMQ.constant.Constants;
import com.rabbit.Springboot4RabbitMQ.entity.BrokerMessageLog;
import com.rabbit.Springboot4RabbitMQ.entity.Order;
import com.rabbit.Springboot4RabbitMQ.mapper.BrokerMessageLogMapper;
import com.rabbit.Springboot4RabbitMQ.producer.RabbitOrderSender;
import com.rabbit.Springboot4RabbitMQ.utils.FastJsonConvertUtil;


/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年9月12日 下午7:15:02
 * @history:
 * @version: v1.0
 */
@Component
public class RetryMessageTasker
{
    @Autowired
    private RabbitOrderSender rabbitOrderSender;

    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;

    @Scheduled(initialDelay = 5000, fixedDelay = 10000)
    public void reSend()
    {
        // pull status = 0 and timeout message
        List<BrokerMessageLog> list = brokerMessageLogMapper.query4StatusAndTimeoutMessage();
        list.forEach(messageLog -> {
            if (messageLog.getTryCount() >= 3)
            {
                // update fail message
                brokerMessageLogMapper.changeBrokerMessageLogStatus(messageLog.getMessageId(), Constants.ORDER_SEND_FAILURE, new Date());
            }
            else
            {
                // resend
                brokerMessageLogMapper.update4ReSend(messageLog.getMessageId(), new Date());
                Order reSendOrder = FastJsonConvertUtil.convertJSONToObject(messageLog.getMessage(), Order.class);
                try
                {
                    rabbitOrderSender.sendOrder(reSendOrder);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.err.println("-----------异常处理-----------");
                }
            }
        });
    }
}
