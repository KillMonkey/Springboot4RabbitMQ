
/*
 * Copyright @ 2018 Springboot4RabbitMQ 下午12:52:45 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.mapper;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rabbit.Springboot4RabbitMQ.entity.BrokerMessageLog;


/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年9月12日 下午12:52:45
 * @history:
 * @version: v1.0
 */

public interface BrokerMessageLogMapper
{
    /**
     * 查询消息状态为0(发送中) 且已经超时的消息集合
     * 
     * @return
     */
    List<BrokerMessageLog> query4StatusAndTimeoutMessage();

    /**
     * 重新发送统计count发送次数 +1
     * 
     * @param messageId
     * @param updateTime
     */
    void update4ReSend(@Param("messageId") String messageId, @Param("updateTime") Date updateTime);

    /**
     * 更新最终消息发送结果 成功 or 失败
     * 
     * @param messageId
     * @param status
     * @param updateTime
     */
    int changeBrokerMessageLogStatus(@Param("messageId") String messageId, @Param("status") String status, @Param("updateTime") Date updateTime);

    /**
     * @author: 吴晓
     * @createTime: 2018年9月12日 下午7:11:30
     * @history:
     * @param brokerMessageLog
     *            void
     */

    void insertMessageLog(BrokerMessageLog brokerMessageLog);
}
