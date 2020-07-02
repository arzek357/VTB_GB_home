package com.vtb.zolotarev.homeWork6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTask1 {

    @Test
    void printUniqueWordsTest1(){
        String expectedResult = "a: 2\nv: 1\np: 1\neffe: 2\n";
        String[] words = {"a","a","v","p","effe","effe"};
        Assertions.assertEquals(expectedResult,Task1.printUniqueWords(words));
    }
}
