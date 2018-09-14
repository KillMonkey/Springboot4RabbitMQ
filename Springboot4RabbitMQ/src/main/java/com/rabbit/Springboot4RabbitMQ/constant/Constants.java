
/*
 * Copyright @ 2018 Springboot4RabbitMQ 下午12:01:49 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.constant;

/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年9月12日 下午12:01:49
 * @history:
 * @version: v1.0
 */

public final class Constants
{
    public static final String ORDER_SENDING = "0"; // 发送中

    public static final String ORDER_SEND_SUCCESS = "1"; // 成功

    public static final String ORDER_SEND_FAILURE = "2"; // 失败

    public static final int ORDER_TIMEOUT = 1; /* 分钟超时单位：min */
}
