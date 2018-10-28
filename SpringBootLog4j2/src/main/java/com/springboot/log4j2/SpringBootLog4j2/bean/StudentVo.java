
/*
 * Copyright @ 2018 SpringBootLog4j2 下午8:57:16 All right reserved.
 */

package com.springboot.log4j2.SpringBootLog4j2.bean;

/**
 * @desc: SpringBootLog4j2
 * @author: 吴晓
 * @createTime: 2018年8月9日 下午8:57:16
 * @history:
 * @version: v1.0
 */

public class StudentVo
{

    private String id;

    private String name;

    private String address;

    private boolean children;

    private int age;

    public String getId()
    {

        return id;
    }

    public void setId(String id)
    {

        this.id = id;
    }

    public String getName()
    {

        return name;
    }

    public void setName(String name)
    {

        this.name = name;
    }

    public String getAddress()
    {

        return address;
    }

    public void setAddress(String address)
    {

        this.address = address;
    }

    public boolean isChildren()
    {

        return children;
    }

    public void setChildren(boolean children)
    {

        this.children = children;
    }

    public int getAge()
    {

        return age;
    }

    public void setAge(int age)
    {

        this.age = age;
    }

    @Override
    public String toString()
    {
        return "StudentVo [id=" + id + ", name=" + name + ", address=" + address + ", children="
               + children + ", age=" + age + "]";
    }

}
