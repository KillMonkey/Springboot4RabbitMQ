
/*
 * Copyright @ 2018 SpringBootLog4j2 下午5:52:57 All right reserved.
 */

package com.springboot.log4j2.SpringBootLog4j2.aop;


import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * @desc: SpringBootLog4j2
 * @author: 吴晓
 * @createTime: 2018年8月9日 下午5:52:57
 * @history:
 * @version: v1.0
 */

@Aspect
@Component
public class LogAspect
{

    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.springboot.log4j2.SpringBootLog4j2.controller.*.*(..))")
    public void webLog()
    {}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint)
        throws Throwable
    {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret)
        throws Throwable
    {
        logger.info("返回的内容：" + ret);
    }

    @After("webLog()")
    public void after(JoinPoint jp)
    {
        System.out.println("方法最后执行.....");
    }

    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp)
    {
        logger.info("方法环绕start");
        try
        {
            Object object = pjp.proceed();
            logger.info("方法环绕end");
            return object;
        }
        catch (Throwable e)
        {
            logger.error("方法环绕异常" + e.getStackTrace().toString());
            return null;
        }
    }

}
