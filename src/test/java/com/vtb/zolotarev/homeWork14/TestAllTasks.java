package com.vtb.zolotarev.homeWork14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestAllTasks {
    @Test
    public void test1Task1() {
        Assertions.assertEquals(5, MainClass.checkRepeatNumber(new File("src/test/resources/rhomeWork14/test_file1.txt"), "va"));
    }

    @Test
    public void test2Task1() {
        Assertions.assertEquals(7, MainClass.checkRepeatNumber(new File("src/test/resources/rhomeWork14/test_file1.txt"), "v"));
    }

    @Test
    public void test3Task1() {
        Assertions.assertEquals(1, MainClass.checkRepeatNumber(new File("src/test/resources/rhomeWork14/test_file1.txt"), "aeff"));
    }

    @Test
    public void test1Task2() {
        String expectedString = "11111\n22222\n7\n33333\n";
        StringBuilder sb = new StringBuilder();
        MainClass.joinAllFilesFromDir(new File("src/test/resources/rhomeWork14/task2directory"), new File("src/test/resources/rhomeWork14/task2result.txt"));
        try (BufferedReader bf = new BufferedReader(new FileReader("src/test/resources/rhomeWork14/task2result.txt"))) {
            String str;
            while ((str = bf.readLine()) != null) {
                sb.append(str).append("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Assertions.assertEquals(expectedString, sb.toString());
    }

    @Test
    public void test1Task3(){
        File fileToDestroy = new File("src/test/resources/rhomeWork14/dirToDestroy");
        MainClass.fullDeleteDir(fileToDestroy);
        Assertions.assertFalse(fileToDestroy.exists());
    }
}
