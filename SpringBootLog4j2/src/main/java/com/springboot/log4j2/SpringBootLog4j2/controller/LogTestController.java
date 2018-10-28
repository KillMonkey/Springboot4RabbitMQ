
/*
 * Copyright @ 2018 com.iflysse.trains SpringBootLog4j2 下午3:07:31 All right reserved.
 */

package com.springboot.log4j2.SpringBootLog4j2.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.log4j2.SpringBootLog4j2.bean.Response;
import com.springboot.log4j2.SpringBootLog4j2.bean.StudentVo;


/**
 * @desc: SpringBootLog4j2
 * @author: 吴晓
 * @createTime: 2018年8月9日 下午3:10:32
 * @history:
 * @version: v1.0
 */

@RestController
@RequestMapping("/log")
public class LogTestController
{

    private static Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/hello")
    public String hello(@RequestParam String name)
    {
        logger.info("hello :" + name);
        return "Hello world!" + name;
    }

    @RequestMapping(value = "/json", method = RequestMethod.POST)
    public Response testJsonLog(@RequestBody StudentVo studentVo)
    {
        logger.info("testJsonLog :" + studentVo);
        Response response = new Response();
        response.setStatus("success");
        response.setObject(studentVo);
        return response;
    }

    @GetMapping("/bad")
    public String badException()
    {
        Object obj = null;
        obj.toString();
        return "success";
    }

    @RequestMapping("/testResponse")
    @ResponseBody
    public StudentVo testResponse()
    {
        StudentVo studentVo = new StudentVo();
        studentVo.setId("chetuanwang");
        studentVo.setName("wuxiao");
        studentVo.setAge(18);
        return studentVo;
    }

}
