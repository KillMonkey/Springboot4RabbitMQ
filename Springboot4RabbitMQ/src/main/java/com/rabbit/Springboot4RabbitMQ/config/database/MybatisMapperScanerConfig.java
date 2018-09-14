
/*
 * Copyright @ 2018 Springboot4RabbitMQ 上午11:58:24 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.config.database;


import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年9月12日 上午11:58:24
 * @history:
 * @version: v1.0
 */
@Configuration
@AutoConfigureAfter(MybatisDataSourceConfig.class)
public class MybatisMapperScanerConfig
{
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer()
    {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.rabbit.Springboot4RabbitMQ.mapper");
        return mapperScannerConfigurer;
    }
}
