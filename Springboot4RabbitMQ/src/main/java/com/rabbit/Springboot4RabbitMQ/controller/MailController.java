
/*
 * Copyright @ 2018 Springboot4RabbitMQ 下午10:05:48 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.rabbit.Springboot4RabbitMQ.entity.JsonResult;
import com.rabbit.Springboot4RabbitMQ.mail.IMailServiceImpl;


/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年10月8日 下午10:05:48
 * @history:
 * @version: v1.0
 */
@RestController
@RequestMapping("email")
public class MailController
{
    @Autowired
    private IMailServiceImpl mailService;// 注入发送邮件的各种实现方法

    @Autowired
    private TemplateEngine templateEngine;// 注入模板引擎

    @RequestMapping
    public JsonResult index()
    {
        try
        {
            mailService.sendSimpleMail("13027733981@163.com", "SpringBoot Email", "这是一封普通的SpringBoot测试邮件");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return new JsonResult(-1, "邮件发送失败!!");
        }
        return new JsonResult();
    }

    @RequestMapping("/htmlEmail")
    public JsonResult htmlEmail()
    {
        try
        {
            mailService.sendHtmlMail("13027733981@163.com",
                "IJPay让支付触手可及",
                "<body style=\"text-align: center;margin-left: auto;margin-right: auto;\">\n"
                                + " <div id=\"welcome\" style=\"text-align: center;position: absolute;\" >\n" + "      <h3>欢迎使用IJPay -By Javen</h3>\n"
                                + "      <span>https://github.com/Javen205/IJPay</span>" + "     <div\n"
                                + "         style=\"text-align: center; padding: 10px\"><a style=\"text-decoration: none;\" href=\"https://github.com/Javen205/IJPay\" target=\"_bank\" ><strong>IJPay 让支付触手可及,欢迎Start支持项目发展:)</strong></a></div>\n"
                                + "     <div\n" + "         style=\"text-align: center; padding: 4px\">如果对你有帮助,请任意打赏</div>\n"
                                + "     <img width=\"180px\" height=\"180px\"\n"
                                + "         src=\"https://javen205.gitbooks.io/ijpay/content/assets/wxpay.png\">\n" + " </div>\n" + "</body>");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return new JsonResult(-1, "邮件发送失败!!");
        }
        return new JsonResult();
    }

    @RequestMapping("/attachmentsMail")
    public JsonResult attachmentsMail()
    {
        try
        {
            String filePath = "D:\\qq20131110\\1249082798\\FileRecv\\p005.jpg";
            mailService.sendAttachmentsMail("13027733981@163.com", "这是一封带附件的邮件", "邮件中有附件，请注意查收！", filePath);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return new JsonResult(-1, "邮件发送失败!!");
        }
        return new JsonResult();
    }

    @RequestMapping("/resourceMail")
    public JsonResult resourceMail()
    {
        try
        {
            String rscId = "xiaoge";
            String content = "<html><body>这是有图片的邮件<br/><img src=\'cid:" + rscId + "\' ></body></html>";
            String imgPath = "D:\\qq20131110\\1249082798\\FileRecv\\p005.jpg";
            mailService.sendResourceMail("13027733981@163.com", "这邮件中含有图片", content, imgPath, rscId);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return new JsonResult(-1, "邮件发送失败!!");
        }
        return new JsonResult();
    }

    @RequestMapping("/templateMail")
    public JsonResult templateMail()
    {
        try
        {
            Context context = new Context();
            context.setVariable("project", "SpringBootRabbitMQEmail");
            context.setVariable("author", "晓哥");
            context.setVariable("url", "https://github.com/KillMonkey/Springboot4RabbitMQ");
            String emailContent = templateEngine.process("emailTemp", context);

            mailService.sendHtmlMail("13027733981@163.com", "这是模板邮件", emailContent);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return new JsonResult(-1, "邮件发送失败!!");
        }
        return new JsonResult();
    }

}
