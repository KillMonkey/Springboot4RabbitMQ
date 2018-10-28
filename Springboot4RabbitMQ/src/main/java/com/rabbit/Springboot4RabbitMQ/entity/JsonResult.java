
/*
 * Copyright @ 2018 Springboot4RabbitMQ 下午10:08:42 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.entity;

/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年10月8日 下午10:08:42
 * @history:
 * @version: v1.0
 */

public class JsonResult
{

    private int code;

    private String message;

    /**
    */

    public JsonResult()
    {
        super();
        this.code = 1;
        this.message = "success";
    }

    /**
     * @param code
     * @param message
     */

    public JsonResult(int code, String message)
    {
        super();
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "JsonResult [code=" + code + ", message=" + message + "]";
    }

}
