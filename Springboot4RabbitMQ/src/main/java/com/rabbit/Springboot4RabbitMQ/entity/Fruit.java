
/*
 * Copyright @ 2018 Springboot4RabbitMQ 下午9:56:23 All right reserved.
 */

package com.rabbit.Springboot4RabbitMQ.entity;

/**
 * @desc: Springboot4RabbitMQ
 * @author: 吴晓
 * @createTime: 2018年10月9日 下午9:56:23
 * @history:
 * @version: v1.0
 */

public class Fruit
{
    private String name;

    private float price;

    private int level;

    public String getName()
    {

        return name;
    }

    public void setName(String name)
    {

        this.name = name;
    }

    public float getPrice()
    {

        return price;
    }

    public void setPrice(float price)
    {

        this.price = price;
    }

    public int getLevel()
    {

        return level;
    }

    public void setLevel(int level)
    {

        this.level = level;
    }

    @Override
    public String toString()
    {
        return "Fruit [name=" + name + ", price=" + price + ", level=" + level + "]";
    }

}
