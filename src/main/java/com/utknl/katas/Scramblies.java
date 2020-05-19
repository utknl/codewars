package com.utknl.katas;

import java.util.HashMap;
import java.util.Map;

public class Scrambles {

    public static boolean scramble(String str1, String str2) {

        Map<String, Integer> letterCountMap = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            String letter = String.valueOf(str1.charAt(i));
            if (!letterCountMap.containsKey(letter)) {
                letterCountMap.put(letter, 1);
            } else {
                Integer value = letterCountMap.get(letter);
                letterCountMap.replace(letter, value, value + 1);
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            String letter = String.valueOf(str1.charAt(i));
            if (letterCountMap.containsKey(letter)) {
                Integer value = letterCountMap.get(letter);
                letterCountMap.replace(letter, value, value - 1);
                if (letterCountMap.get(letter) == 0) {
                    letterCountMap.remove(letter);
                }
                return true;
            }
        }
        return false;

    }


}
