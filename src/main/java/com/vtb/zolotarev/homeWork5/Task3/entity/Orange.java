package com.vtb.zolotarev.homeWork5.Task3.entity;

public class Orange extends Fruit {
    private static final double WEIGHT = 1.5f;
    private static final String NAME = "Orange";

    @Override
    double getWeight() {
        return WEIGHT;
    }

    @Override
    String getName() {
        return NAME;
    }
}
