package com.yhch.ch09;


import java.io.Serializable;

// 创建一个可序列化的对象 实现接口
public class Persion implements Serializable {

    //序列化ID
    //private static final long serializableUUID = 222222222222222;
    private int age;
    private String name;
    private char sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
