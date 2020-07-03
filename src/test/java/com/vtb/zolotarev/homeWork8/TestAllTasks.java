package com.vtb.zolotarev.homeWork8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAllTasks {

    @Test
    void task1Test() {
        String testString = "Тщетно тщится щука ущемить леща " +
                "Тщетно тщится щука ущемить леща " +
                "Тщетно тщится щука ущемить леща " +
                "Тщетно тщится щука ущемить леща " +
                "Тщетно тщится щука ущемить леща " +
                "Тщетно тщится щука ущемить леща " +
                "Тщетно тщится щука ущемить леща " +
                "Тщетно тщится щука ущемить леща " +
                "Тщетно тщится щука ущемить леща " +
                "Тщетно тщится щука ущемить леща";

        String expectedString = "Тщетно тщится ущемить";
        Assertions.assertEquals(expectedString, MainClass.getUniqueStringWithFixLength(testString, s -> s.length() > 5));
    }

    @Test
    void task2Test() {
        String[][] testArr = new String[5][5];

        for (int i = 0; i < testArr.length; i++) {
            Arrays.fill(testArr[i], String.format("Hi, %d", i));
        }

        testArr[0][0] = "Miss!";

        List<String> expectedList = new ArrayList<>(Arrays.asList("Miss!", "Hi, 0", "Hi, 1", "Hi, 2", "Hi, 3", "Hi, 4"));
        Assertions.assertEquals(expectedList, MainClass.getUniqueWordsInArray(testArr));
    }

    @Test
    void task3Test() {
        int expectedResult = 7650;
        Assertions.assertEquals(expectedResult, MainClass.getSumEvenNumbersInFixRange(100, 200));
    }

    @Test
    void task4Test() {
        String[] testArr = {"a", "bb", "ccc", "dddd", "eeeee"};
        int expectedResult = 15;
        Assertions.assertEquals(expectedResult, MainClass.getSumOfLengthStrings(testArr));
    }

    @Test
    void task5Test() {
        String[] testArr = {"cc", "gggg", "aaa", "bbbbbbbbbbbbbbb", "p", "l"};
        List<String> expectedList = new ArrayList<>(Arrays.asList("aaa", "bbbbbbbbbbbbbbb", "cc"));
        Assertions.assertEquals(expectedList, MainClass.getSortedWordsFixNumber(3, testArr));
    }
}
