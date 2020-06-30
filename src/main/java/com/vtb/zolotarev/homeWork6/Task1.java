package com.vtb.zolotarev.homeWork6;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task1 {

    public static String printUniqueWords(String[] array) {
        StringBuffer sb = new StringBuffer();
        Map<String, Integer> frequencyByWord = new LinkedHashMap<>();

        for (String word : array) {
            frequencyByWord.merge(word, 1, Integer::sum);
        }

        frequencyByWord.forEach((word, frequency) -> {
            sb.append(word).append(": ").append(frequency).append("\n");
            System.out.println(word + ": " + frequency);
        });

        return sb.toString();
    }
}
