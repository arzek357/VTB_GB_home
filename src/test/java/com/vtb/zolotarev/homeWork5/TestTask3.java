package com.vtb.zolotarev.homeWork5;

import com.vtb.zolotarev.homeWork5.Task3.entity.Apple;
import com.vtb.zolotarev.homeWork5.Task3.entity.Box;
import com.vtb.zolotarev.homeWork5.Task3.entity.Orange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTask3 {
    private Apple apple;
    private Orange orange;

    private Box<Apple> box1;
    private Box<Orange> box2;

    @BeforeEach
    void init() {
        apple = new Apple();
        orange = new Orange();
        box1 = new Box<>(30, "Box №1");
        box2 = new Box<>(20, "Box №2");
    }

    @Test
    void fillBoxTest() {
        box1.fill(13, apple);
        Assertions.assertEquals(13, box1.getActiveWeight());
    }

    @Test
    void fillBoxInvalidWeightTest() {
        box1.fill(40, apple);
        Assertions.assertEquals(0, box1.getActiveWeight());
    }

    @Test
    void fillBoxInvalidWeightTest2() {
        box1.fill(28, apple);
        box1.fill(4, apple);
        Assertions.assertEquals(28, box1.getActiveWeight());
    }

    @Test
    void compareBoxesTest() {
        box1.fill(15, apple);
        box2.fill(10, orange);
        Assertions.assertTrue(box1.compareWeightWith(box2));
    }

    @Test
    void dropInAnotherBoxTest(){
        Box<Apple> testBox = new Box<>(30,"testBox");
        box1.fill(15,apple);
        testBox.fill(5,apple);
        box1.dropInAnotherBox(testBox);
        Assertions.assertEquals(20,testBox.getActiveWeight());
        Assertions.assertEquals(0,box1.getActiveWeight());
    }
}
