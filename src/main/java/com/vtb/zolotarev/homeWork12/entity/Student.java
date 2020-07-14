package com.vtb.zolotarev.homeWork12.entity;

import com.vtb.zolotarev.homeWork12.annotations.DbColumn;
import com.vtb.zolotarev.homeWork12.annotations.DbId;
import com.vtb.zolotarev.homeWork12.annotations.DbTable;

@DbTable(name = "students")
public class Student {
    @DbId
    private long id;
    @DbColumn
    private String first_name;
    @DbColumn
    private String second_name;
    @DbColumn
    private int age;
    @DbColumn
    private int label;

    public Student(String first_name, String second_name, int age, int label) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.age = age;
        this.label = label;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", age=" + age +
                ", label=" + label +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public int getAge() {
        return age;
    }

    public int getLabel() {
        return label;
    }
}
