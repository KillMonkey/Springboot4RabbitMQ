
/*
 * Copyright @ 2018 Springboot4RabbitMQ 下午7:00:11 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rabbit.Springboot4RabbitMQ.entity.Order;


/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年9月12日 下午7:00:11
 * @history:
 * @version: v1.0
 */

public class FastJsonConvertUtil
{

    /**
     * @author: 吴晓
     * @createTime: 2018年9月12日 下午7:04:44
     * @history:
     * @param order
     * @return String
     */

    public static String convertObjectToJSON(Order order)
    {
        return JSON.toJSONString(order);

    }

    /**
     * @author: 吴晓
     * @createTime: 2018年9月12日 下午7:15:33
     * @history:
     * @param message
     * @param class1
     * @return Order
     */

    public static Order convertJSONToObject(String message, Class<Order> class1)
    {
        JSONObject json = JSONObject.parseObject(message);
        return json.toJavaObject(class1);
    }

}
