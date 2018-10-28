package com.springboot.log4j2.SpringBootLog4j2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class SpringBootLog4j2Application extends SpringBootServletInitializer
{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        return builder.sources(SpringBootLog4j2Application.class);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootLog4j2Application.class, args);
    }
}
