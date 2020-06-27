package com.vtb.zolotarev.homeWork5;

import com.vtb.zolotarev.homeWork5.MainClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestTask1AndTask2Methods {

    @Test
    void changePosInArrayIntegerTest(){
        Integer[] testArray = {3,1,4,77,3,6};
        Integer[] expectedArray = {77,1,4,3,3,6};
        MainClass.changePosInArray(testArray,0,3);
        Assertions.assertArrayEquals(testArray,expectedArray);
    }
    @Test
    void changePosInArrayStringTest(){
        String[] testArray = {"A","B","C","D"};
        String[] expectedArray = {"D","B","C","A"};
        MainClass.changePosInArray(testArray,0,3);
        Assertions.assertArrayEquals(testArray,expectedArray);
    }
    @Test
    void changePosInArrayDoubleTest(){
        Double[] testArray = {17.0,12.3,22.45,21.09};
        Double[] expectedArray = {21.09,12.3,22.45,17.0};
        MainClass.changePosInArray(testArray,0,3);
        Assertions.assertArrayEquals(testArray,expectedArray);
    }
    @Test
    void arrayToArrayListIntegerTest(){
        Integer[] testArray = {3,1,4,77,3,6};

        ArrayList<Integer> testArrayList = MainClass.arrayToArrayList(testArray);
        ArrayList<Integer> expectedArrayList = new ArrayList<>(Arrays.asList(testArray));

        Assertions.assertEquals(testArrayList.size(),expectedArrayList.size());
        for (int i =0;i<testArray.length;i++){
            Assertions.assertEquals(testArrayList.get(0),expectedArrayList.get(0));
        }
    }
    @Test
    void arrayToArrayListStringTest(){
        String[] testArray = {"A","B","C","D"};

        ArrayList<String> testArrayList = MainClass.arrayToArrayList(testArray);
        ArrayList<String> expectedArrayList = new ArrayList<>(Arrays.asList(testArray));

        Assertions.assertEquals(testArrayList.size(),expectedArrayList.size());
        for (int i =0;i<testArray.length;i++){
            Assertions.assertEquals(testArrayList.get(0),expectedArrayList.get(0));
        }
    }
    @Test
    void arrayToArrayListDoubleTest(){
        Double[] testArray = {17.0,12.3,22.45,21.09};

        ArrayList<Double> testArrayList = MainClass.arrayToArrayList(testArray);
        ArrayList<Double> expectedArrayList = new ArrayList<>(Arrays.asList(testArray));

        Assertions.assertEquals(testArrayList.size(),expectedArrayList.size());
        for (int i =0;i<testArray.length;i++){
            Assertions.assertEquals(testArrayList.get(0),expectedArrayList.get(0));
        }
    }
}
