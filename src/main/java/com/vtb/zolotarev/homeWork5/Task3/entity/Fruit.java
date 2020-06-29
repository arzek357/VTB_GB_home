package com.vtb.zolotarev.homeWork5.Task3.entity;

public abstract class Fruit {

    abstract double getWeight();

    abstract String getName();

    abstract <T extends Fruit> T getNewFruit();
}
