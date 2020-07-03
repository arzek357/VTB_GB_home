package com.vtb.zolotarev.homeWork7;

import com.vtb.zolotarev.homeWork7.task3.entity.MyEntry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class TestTask3 {
    private static HashMap<Integer, Integer> hashMap;
    private static ArrayList<MyEntry> arrayList;

    @BeforeAll
    static void init() {
        hashMap = new HashMap<>(50000);
        arrayList = new ArrayList<>(50000);

        for (int i = 0; i < 50000; i++) {
            arrayList.add(new MyEntry(i));
            hashMap.put(i, arrayList.get(i).getValue());
        }
    }


    /*Results For Task3
     *             50000
     * ArrayList   10-20
     * HashMap     10-20
     * */

    @Test
    void task3Part1Test() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            int value = arrayList.get((int) (Math.random() * 49999)).getValue();
        }
        long arrayListTime = System.currentTimeMillis() - time;
        System.out.println("Time for ArrayList: " + arrayListTime);
    }

    @Test
    void task3Part2Test() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            int value = hashMap.get((int) (Math.random() * 49999));
        }
        long hashMapTime = System.currentTimeMillis() - time;
        System.out.println("Time for HashMap: " + hashMapTime);
    }
}
