package com.vtb.zolotarev.homeWork6;

import com.vtb.zolotarev.homeWork6.task2.entity.TelephoneDirectory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class TestTask2 {

    TelephoneDirectory telephoneDirectory;

    @BeforeEach
    void init(){
       telephoneDirectory = new TelephoneDirectory();
    }

    @Test
    void addNewPhoneNumberTest(){
        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("222-44-11");
        telephoneDirectory.add("Ivanov","222-44-11");
        Assertions.assertEquals(expectedSet,telephoneDirectory.get("Ivanov"));
    }

    @Test
    void addSeveralPhoneNumberTest(){
        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("222-44-11");
        expectedSet.add("222-55-88");
        expectedSet.add("355-44-11");
        telephoneDirectory.add("Ivanov","222-44-11");
        telephoneDirectory.add("Ivanov","222-55-88");
        telephoneDirectory.add("Ivanov","355-44-11");
        Assertions.assertEquals(expectedSet,telephoneDirectory.get("Ivanov"));
    }
}
