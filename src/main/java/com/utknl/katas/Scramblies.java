package com.utknl.katas;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codewars.com/kata/55c04b4cc56a697bb0000048/train/java
 * <p>
 * Complete the function scramble(str1, str2) that returns true if a portion of
 * str1 characters can be rearranged to match str2, otherwise returns false.
 * <p>
 * Notes:
 * <p>
 * Only lower case letters will be used (a-z). No punctuation or digits will be included.
 * Performance needs to be considered
 * Input strings s1 and s2 are null terminated.
 * Examples
 * scramble('rkqodlw', 'world') ==> True
 * scramble('cedewaraaossoqqyt', 'codewars') ==> True
 * scramble('katas', 'steak') ==> False
 */

public class Scramblies {

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
            String letter = String.valueOf(str2.charAt(i));

            if (!letterCountMap.containsKey(letter)) {
                return false;
            }

            Integer value = letterCountMap.get(letter);
            letterCountMap.replace(letter, value, value - 1);
            if (letterCountMap.get(letter) == 0) {
                letterCountMap.remove(letter);
            }
        }
        return true;
    }

//    var sortedStr1=Arrays.stream(str1.split("")).sorted().collect(Collectors.groupingBy(it->it));
//    var sortedStr2=Arrays.stream(str2.split("")).sorted().collect(Collectors.groupingBy(it->it));
//    sortedStr2.entrySet().stream().allMatch(it -> sortedStr1.getOrDefault(it.getKey(),List.of()).size()> it.getValue().size());

}
