
/*
 * Copyright @ 2018 Springboot4RabbitMQ 上午11:40:57 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.entity;


import java.io.Serializable;


/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年9月12日 上午11:40:57
 * @history:
 * @version: v1.0
 */

public class Order implements Serializable
{

    private static final long serialVersionUID = -7128203829971899888L;

    private String id;

    private String name;

    private String messageId;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id == null ? null : id.trim();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
    }

    public String getMessageId()
    {
        return messageId;
    }

    public void setMessageId(String messageId)
    {
        this.messageId = messageId == null ? null : messageId.trim();
    }

    @Override
    public String toString()
    {
        return "Order [id=" + id + ", name=" + name + ", messageId=" + messageId + "]";
    }

}
