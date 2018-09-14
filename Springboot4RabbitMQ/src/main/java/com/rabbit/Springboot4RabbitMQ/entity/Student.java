
/*
 * Copyright @ 2018 Springboot4RabbitMQ 下午3:46:51 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.entity;


import java.io.Serializable;


/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年9月9日 下午3:46:51
 * @history:
 * @version: v1.0
 */

public class Student implements Serializable
{

    private static final long serialVersionUID = -843291207135298784L;

    private String id;

    private String name;

    private String messageId;

    public String getId()
    {

        return id;
    }

    public void setId(String id)
    {

        this.id = id;
    }

    public String getName()
    {

        return name;
    }

    public void setName(String name)
    {

        this.name = name;
    }

    public String getMessageId()
    {

        return messageId;
    }

    public void setMessageId(String messageId)
    {

        this.messageId = messageId;
    }

    @Override
    public String toString()
    {
        return "Student [id=" + id + ", name=" + name + ", messageId=" + messageId + "]";
    }

    /**
     * @param id
     * @param name
     * @param messageId
     */

    public Student(String id, String name, String messageId)
    {
        super();
        this.id = id;
        this.name = name;
        this.messageId = messageId;
    }

    /**
    */

    public Student()
    {}

}
