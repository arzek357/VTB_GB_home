package com.vtb.zolotarev.homeWork15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestAllTasks {
    @Test
    public void test1Task1() {
        Assertions.assertEquals(5, MainClass.checkRepeatNumberNio(new File("src/test/resources/rhomeWork15/file_test_task1.txt"), "va"));
    }

    @Test
    public void test2Task1() {
        Assertions.assertEquals(7, MainClass.checkRepeatNumberNio(new File("src/test/resources/rhomeWork15/file_test_task1.txt"), "v"));
    }

    @Test
    public void test3Task1() {
        Assertions.assertEquals(1, MainClass.checkRepeatNumberNio(new File("src/test/resources/rhomeWork15/file_test_task1.txt"), "aeff"));
    }

    @Test
    public void test1Task2() {
        String expectedString = "11111\n22222\n7\n33333\n";
        StringBuilder sb = new StringBuilder();
        MainClass.joinAllFilesFromDirNio(new File("src/test/resources/rhomeWork15/task2directory"), new File("src/test/resources/rhomeWork15/task2result.txt"));
        try (BufferedReader bf = new BufferedReader(new FileReader("src/test/resources/rhomeWork15/task2result.txt"))) {
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
    public void test1Task3() {
        List<File> files = new ArrayList<>();
        files.add(new File("src/test/resources/rhomeWork15/task3directory/exampleDir/1.txt"));
        files.add(new File("src/test/resources/rhomeWork15/task3directory/exampleDir/2.txt"));
        files.add(new File("src/test/resources/rhomeWork15/task3directory/exampleDir/3.txt"));
        Assertions.assertEquals(files, MainClass.findAllFilesLessOrEquals(new File("src/test/resources/rhomeWork15/task3directory"), 100L));
    }
}
