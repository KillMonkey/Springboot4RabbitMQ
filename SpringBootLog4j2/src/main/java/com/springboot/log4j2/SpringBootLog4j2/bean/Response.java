
/*
 * Copyright @ 2018 SpringBootLog4j2 上午9:18:57 All right reserved.
 */

package com.springboot.log4j2.SpringBootLog4j2.bean;

/**
 * @desc: SpringBootLog4j2
 * @author: 吴晓
 * @createTime: 2018年8月10日 上午9:18:57
 * @history:
 * @version: v1.0
 */

public class Response
{

    private Object object;

    private String status;

    private String errorInfo;

    public String getStatus()
    {

        return status;
    }

    public void setStatus(String status)
    {

        this.status = status;
    }

    public String getErrorInfo()
    {

        return errorInfo;
    }

    public void setErrorInfo(String errorInfo)
    {

        this.errorInfo = errorInfo;
    }

    public Object getObject()
    {

        return object;
    }

    public void setObject(Object object)
    {

        this.object = object;
    }

    @Override
    public String toString()
    {
        return "Response [object=" + object + ", status=" + status + ", errorInfo=" + errorInfo + "]";
    }

}
