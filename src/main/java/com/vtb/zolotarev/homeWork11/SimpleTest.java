package com.vtb.zolotarev.homeWork11;

import com.vtb.zolotarev.homeWork11.annotations.AfterSuite;
import com.vtb.zolotarev.homeWork11.annotations.BeforeSuite;
import com.vtb.zolotarev.homeWork11.annotations.Test;

public class SimpleTest {
    @BeforeSuite
    public void beforeTests() {
        System.out.println("Start!");
    }

    @Test(priority = 3)
    public void test1() {
        System.out.println("Test 1 successful!");
    }

    @Test(priority = 9)
    public void test2() {
        System.out.println("Test 2 successful!");
    }

    @Test(priority = 1)
    public void test3() {
        System.out.println("Test 3 successful!");
    }

    @Test(priority = 1)
    public void test4() {
        System.out.println("Test 4 successful!");
    }

    @AfterSuite
    public void afterTests() {
        System.out.println("End!");
    }
}
