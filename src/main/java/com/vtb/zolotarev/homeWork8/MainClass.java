package com.vtb.zolotarev.homeWork8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainClass {

    /*
     * 1) Взять строку, состоящую из 100 слов разделенных пробелом, получить список слов длиннее 5 символов,
     * и склеить их в одну строку с пробелом в качестве разделителя;
     * 2) Найти список уникальных слов в двумерном массиве размером 5х5;
     * 3) Посчитать сумму четных чисел в пределах от 100 до 200 (включительно);
     * 4) Посчитать суммарную длину строк в одномерном массиве;
     * 5) Из массива слов получить первые три слова в алфавитном порядке;
     * */

    //Task1
    public static String getUniqueStringWithFixLength(String str, Predicate<String> pr) {
        return Arrays.stream(str.split("\\s")).distinct().filter(pr).collect(Collectors.joining(" "));
    }

    //Task2
    public static List<String> getUniqueWordsInArray(String[][] array) {
        return Stream.of(array).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
    }

    //Task3
    public static int getSumEvenNumbersInFixRange(int minBound, int maxBound) {
        return IntStream.rangeClosed(minBound, maxBound).filter(s -> s % 2 == 0).sum();
    }

    //Task4
    public static int getSumOfLengthStrings(String... strings) {
        return Arrays.stream(strings).mapToInt(String::length).sum();
    }

    //Task5
    public static List<String> getSortedWordsFixNumber(long number, String... strings) {
        return Arrays.stream(strings).sorted().limit(number).collect(Collectors.toList());
    }
}
