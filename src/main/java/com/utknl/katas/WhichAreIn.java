package com.utknl.katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.codewars.com/kata/550554fd08b86f84fe000a58/train/java
 * <p>
 * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which
 * are substrings of strings of a2.
 * <p>
 * #Example 1: a1 = ["arp", "live", "strong"]
 * <p>
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 * <p>
 * returns ["arp", "live", "strong"]
 * <p>
 * #Example 2: a1 = ["tarp", "mice", "bull"]
 * <p>
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 * <p>
 * returns []
 */

public class WhichAreIn {


    public static void main(String[] args) {
        String[] array1 = new String[]{"arp", "live", "strong"};
        String[] array2 = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};

        System.out.println(Arrays.toString(inArray(array1, array2)));

    }

    public static String[] inArray(String[] array1, String[] array2) {

//        return Arrays.stream(array1)
//                .filter(s -> Arrays.stream(array2).anyMatch(word -> word.contains(s)))
//                .distinct()
//                .sorted()
//                .toArray(String[]::new);

        List<String> results = new ArrayList<>();
        for (String s : array1) {
            for (String word : array2) {
                if (word.contains(s)) {
                    results.add(s);
                    break;
                }
            }
        }

        Collections.sort(results);
        return results.toArray(new String[0]);
    }


}
