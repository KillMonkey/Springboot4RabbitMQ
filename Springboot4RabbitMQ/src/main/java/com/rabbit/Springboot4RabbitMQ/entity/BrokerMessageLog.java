
/*
 * Copyright @ 2018 Springboot4RabbitMQ 上午11:42:28 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.entity;


import java.util.Date;


/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年9月12日 上午11:42:28
 * @history:
 * @version: v1.0
 */

public class BrokerMessageLog
{
    private String messageId;

    private String message;

    private Integer tryCount;

    private String status;

    private Date nextRetry;

    private Date createTime;

    private Date updateTime;

    public String getMessageId()
    {
        return messageId;
    }

    public void setMessageId(String messageId)
    {
        this.messageId = messageId == null ? null : messageId.trim();
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message == null ? null : message.trim();
    }

    public Integer getTryCount()
    {
        return tryCount;
    }

    public void setTryCount(Integer tryCount)
    {
        this.tryCount = tryCount;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status == null ? null : status.trim();
    }

    public Date getNextRetry()
    {
        return nextRetry;
    }

    public void setNextRetry(Date nextRetry)
    {
        this.nextRetry = nextRetry;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }
}
