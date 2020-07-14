package com.vtb.zolotarev.homeWork12.entity;

import com.vtb.zolotarev.homeWork12.annotations.DbColumn;
import com.vtb.zolotarev.homeWork12.annotations.DbId;
import com.vtb.zolotarev.homeWork12.annotations.DbTable;

@DbTable(name = "cats")
public class Cat {
    @DbId
    private long id;
    @DbColumn
    private String name;
    @DbColumn
    private int age;
    @DbColumn
    private String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public Cat() {
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }
}
