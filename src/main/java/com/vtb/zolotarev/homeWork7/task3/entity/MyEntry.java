package com.vtb.zolotarev.homeWork7.task3.entity;

public class MyEntry {

    private final int key;
    private final int value;


    public MyEntry(int key) {
        this.key = key;
        this.value = (int) (Math.random() * Integer.MAX_VALUE);
    }

    public int getValue() {
        return value;
    }
}
