package com.ply.pojo;

import java.io.Serializable;

/*
 * @author ply
 * @date 2018/11/13 0013 下午 11:04
 */
public class Student implements Serializable {
    private String name;
    private Integer age;
    private String sex;
    private Integer idd;

    public Student(String name, Integer age, String sex, Integer id) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.idd = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", idd=" + idd +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getIdd() {
        return idd;
    }

    public void setIdd(Integer idd) {
        this.idd = idd;
    }
}
