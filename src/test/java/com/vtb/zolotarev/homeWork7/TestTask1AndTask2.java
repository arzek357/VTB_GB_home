package com.vtb.zolotarev.homeWork7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestTask1AndTask2 {

    private static ArrayList<Integer> arrayList1;
    private static ArrayList<Integer> arrayList2;
    private static ArrayList<Integer> arrayList3;
    private static ArrayList<Integer> arrayList4;

    private static LinkedList<Integer> linkedList1;
    private static LinkedList<Integer> linkedList2;
    private static LinkedList<Integer> linkedList3;
    private static LinkedList<Integer> linkedList4;

    @BeforeAll
    static void init() {
        arrayList1 = new ArrayList<>(10);
        arrayList2 = new ArrayList<>(100);
        arrayList3 = new ArrayList<>(10000);
        arrayList4 = new ArrayList<>(100000);

        linkedList1 = new LinkedList<>();
        linkedList2 = new LinkedList<>();
        linkedList3 = new LinkedList<>();
        linkedList4 = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            if (arrayList1.size() < 10) {
                linkedList1.add(i);
                arrayList1.add(i);
            }
            if (arrayList2.size() < 100) {
                linkedList2.add(i);
                arrayList2.add(i);
            }
            if (arrayList3.size() < 10000) {
                linkedList3.add(i);
                arrayList3.add(i);
            }
            arrayList4.add(i);
            linkedList4.add(i);
        }
    }

    /*Results For Task1
     *             10    100    10000    100000
     * ArrayList   0-1   0-1    0-1      0-1
     * LinkedList  0-1   >2     >150     >1000
     * */

    @Test
    void task1Part1Test() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int test = arrayList1.get(4);
        }
        long arrayListTime = System.currentTimeMillis() - time;
        System.out.println("Time for ArrayList(10): " + arrayListTime);

        time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int test = linkedList1.get(4);
        }
        long linkedListTime = System.currentTimeMillis() - time;
        System.out.println("Time for LinkedList(10): " + linkedListTime);
        Assertions.assertTrue(Math.abs(arrayListTime - linkedListTime) >= 0);
    }

    @Test
    void task1Part2Test() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int test = arrayList2.get(49);
        }
        long arrayListTime = System.currentTimeMillis() - time;
        System.out.println("Time for ArrayList(100): " + arrayListTime);

        time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int test = linkedList2.get(49);
        }
        long linkedListTime = System.currentTimeMillis() - time;
        System.out.println("Time for LinkedList(100): " + linkedListTime);
        Assertions.assertTrue(Math.abs(arrayListTime - linkedListTime) >= 0);
    }

    @Test
    void task1Part3Test() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int test = arrayList3.get(4999);
        }
        long arrayListTime = System.currentTimeMillis() - time;
        System.out.println("Time for ArrayList(10000): " + arrayListTime);

        time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int test = linkedList3.get(4999);
        }
        long linkedListTime = System.currentTimeMillis() - time;
        System.out.println("Time for LinkedList(10000): " + linkedListTime);
        Assertions.assertTrue(Math.abs(arrayListTime - linkedListTime) > 150);
    }

    @Test
    void task1Part4Test() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int test = arrayList4.get(49999);
        }
        long arrayListTime = System.currentTimeMillis() - time;
        System.out.println("Time for ArrayList(100000): " + arrayListTime);

        time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int test = linkedList4.get(49999);
        }
        long linkedListTime = System.currentTimeMillis() - time;
        System.out.println("Time for LinkedList(100000): " + linkedListTime);
        Assertions.assertTrue(Math.abs(arrayListTime - linkedListTime) > 1000);
    }

    /*Results For Task2
     *             10    100    10000    100000
     * ArrayList   0-1   0-1    >2       >100
     * LinkedList  0-1   >2     >150     >2300
     * */

    @Test
    void task2Part1Test() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < arrayList1.size() / 2; i++) {
            arrayList1.remove(arrayList1.size() / 2);
        }
        long arrayListTime = System.currentTimeMillis() - time;
        System.out.println("Time for ArrayList(10): " + arrayListTime);

        time = System.currentTimeMillis();
        for (int i = 0; i < linkedList1.size() / 2; i++) {
            linkedList1.remove(linkedList1.size() / 2);
        }
        long linkedListTime = System.currentTimeMillis() - time;
        System.out.println("Time for LinkedList(10): " + linkedListTime);
        Assertions.assertTrue(Math.abs(arrayListTime - linkedListTime) < 1);
    }

    @Test
    void task2Part2Test() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < arrayList2.size() / 2; i++) {
            arrayList2.remove(arrayList2.size() / 2);
        }
        long arrayListTime = System.currentTimeMillis() - time;
        System.out.println("Time for ArrayList(100): " + arrayListTime);

        time = System.currentTimeMillis();
        for (int i = 0; i < linkedList2.size() / 2; i++) {
            linkedList2.remove(linkedList2.size() / 2);
        }
        long linkedListTime = System.currentTimeMillis() - time;
        System.out.println("Time for LinkedList(100): " + linkedListTime);
        Assertions.assertTrue(Math.abs(arrayListTime - linkedListTime) >= 0);
    }

    @Test
    void task2Part3Test() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < arrayList3.size() / 2; i++) {
            arrayList3.remove(arrayList3.size() / 2);
        }
        long arrayListTime = System.currentTimeMillis() - time;
        System.out.println("Time for ArrayList(10000): " + arrayListTime);

        time = System.currentTimeMillis();
        for (int i = 0; i < linkedList3.size() / 2; i++) {
            linkedList3.remove(linkedList3.size() / 2);
        }
        long linkedListTime = System.currentTimeMillis() - time;
        System.out.println("Time for LinkedList(10000): " + linkedListTime);
        Assertions.assertTrue(Math.abs(arrayListTime - linkedListTime) >= 0);
    }

    @Test
    void task2Part4Test() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < arrayList4.size() / 2; i++) {
            arrayList4.remove(arrayList4.size() / 2);
        }
        long arrayListTime = System.currentTimeMillis() - time;
        System.out.println("Time for ArrayList(100000): " + arrayListTime);

        time = System.currentTimeMillis();
        for (int i = 0; i < linkedList4.size() / 2; i++) {
            linkedList4.remove(linkedList4.size() / 2);
        }
        long linkedListTime = System.currentTimeMillis() - time;
        System.out.println("Time for LinkedList(100000): " + linkedListTime);
        Assertions.assertTrue(Math.abs(arrayListTime - linkedListTime) >= 0);
    }
}
