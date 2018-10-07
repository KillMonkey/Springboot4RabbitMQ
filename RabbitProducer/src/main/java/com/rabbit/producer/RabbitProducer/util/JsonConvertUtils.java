
/*
 * Copyright @ 2018 RabbitProducer 下午4:39:30 All right reserved.
 */

package com.rabbit.producer.RabbitProducer.util;


import com.alibaba.fastjson.JSONObject;
import com.rabbit.producer.RabbitProducer.entity.Order;


/**
 * @desc: RabbitProducer
 * @author: 吴晓
 * @createTime: 2018年10月7日 下午4:39:30
 * @history:
 * @version: v1.0
 */

public class JsonConvertUtils
{

    public static Order convertJSONToObject(JSONObject json)
    {
        return JSONObject.toJavaObject(json, Order.class);
    }
}
