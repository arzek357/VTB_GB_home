package com.vtb.zolotarev.homeWork9;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ForkJoinPool;

public class TestAllTasks {
    static Integer[] testArray;

    /*Results

    (Test №1)
     *                                      Time (ms)
     * Stream (solo)                         967
     * Stream (parallel)                     404
     * RecursiveTask (without split)         1448

     (Test №2)
     *                                      Time (ms)
     * Stream (solo)                         1170
     * Stream (parallel)                     420
     * RecursiveTask (split on 2 threads)    1119

     (Test №3)
     *                                      Time (ms)
     * Stream (solo)                         1409
     * Stream (parallel)                     433
     * RecursiveTask (split on 4 threads)    1217
     * */

    @BeforeAll
    static void init() {
        testArray = new Integer[100_000_000];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = (int) (Math.random() * 100_000);
        }
    }

    @Test
    void streamTest() {
        long time = System.currentTimeMillis();
        int result = Arrays.stream(testArray).max(Comparator.comparingInt(o -> o)).get();
        System.out.println(result);
        System.out.println(System.currentTimeMillis()-time);
    }

    @Test
    void parStreamTest() {
        long time = System.currentTimeMillis();
        int result = Arrays.asList(testArray).parallelStream().max(Comparator.comparingInt(o -> o)).get();
        System.out.println(result);
        System.out.println(System.currentTimeMillis()-time);
    }

    @Test
    void recursiveTaskTest(){
        long time = System.currentTimeMillis();
        int result = ForkJoinPool.commonPool().invoke(new DemoRecursiveTask(testArray));
        System.out.println(result);
        System.out.println(System.currentTimeMillis()-time);
    }
}
