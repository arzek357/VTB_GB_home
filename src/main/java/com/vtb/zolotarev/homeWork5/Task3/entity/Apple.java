package com.vtb.zolotarev.homeWork5.Task3.entity;

public class Apple extends Fruit {
    private static final double WEIGHT = 1.0f;
    private static final String NAME = "Apple";


    @Override
    double getWeight() {
        return WEIGHT;
    }

    @Override
    String getName() {
        return NAME;
    }

    @Override
    <T extends Fruit> T getNewFruit() {
        return (T) new Apple();
    }

}
