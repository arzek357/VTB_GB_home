package com.vtb.zolotarev.homeWork6.task2.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TelephoneDirectory {
    Map<String, HashSet<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        HashSet<String> phones = getPhones(surname);
        phones.add(phoneNumber);
    }

    private HashSet<String> getPhones(String surname) {
        return phoneBook.computeIfAbsent(surname, key -> new HashSet<>());
    }

    public HashSet<String> get(String surname) {
        System.out.println(surname+": "+phoneBook.get(surname));
        return phoneBook.get(surname);
    }

}
