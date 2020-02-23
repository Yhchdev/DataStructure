package com.yhch.ppt;
public class Jichu {
    public static void main(String[] args) {
        // 1. String 是什么类型？(值、引用)
        // 2. == 和 equals的区别？
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));

        Student s1 = new Student("小明",20);
        Student s2 = new Student("小明",20);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);

    }
}
class Student{
    private String name;
    private int age;

    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
