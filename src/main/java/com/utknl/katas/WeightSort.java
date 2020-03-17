package com.utknl.katas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/55c6126177c9441a570000cc/train/java
 * <p>
 * My friend John and I are members of the "Fat to Fit Club (FFC)". John is worried because each month a list
 * with the weights of members is published and each month he is the last on the list which means he is the heaviest.
 * <p>
 * I am the one who establishes the list so I told him: "Don't worry any more, I will modify the order of the list".
 * It was decided to attribute a "weight" to numbers. The weight of a number will be from now on the sum of its digits.
 * <p>
 * For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list 100 will come before 99.
 * Given a string with the weights of FFC members in normal order can you give this string ordered by "weights" of these numbers?
 * <p>
 * Example:
 * "56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes: "100 180 90 56 65 74 68 86 99"
 * <p>
 * When two numbers have the same "weight", let us class them as if they were strings (alphabetical ordering)
 * and not numbers: 100 is before 180 because its "weight" (1) is less than the one of 180 (9) and 180 is before 90 since,
 * having the same "weight" (9), it comes before as a string.
 * <p>
 * All numbers in the list are positive numbers and the list can be empty.
 * <p>
 * Notes
 * * it may happen that the input string have leading, trailing whitespaces and more than a unique whitespace
 * between two consecutive numbers
 * <p>
 * * Don't modify the input
 * <p>
 * * For C: The result is freed
 */

public class WeightSort {
    public static String orderWeight(String string) {
        List<Long> collect = Arrays.stream(string.split(" "))
                .filter(x -> x.length() != 0)
                .map(Long::valueOf)
                .sorted(WeightSort::compare)
                .collect(Collectors.toList());
        int length = collect.toString().replace(",", "").length();
        return collect.toString().replace(",", "")
                .substring(1, length - 1);
    }

    public static int compare(Long i1, Long i2) {
        int weight1 = getWeight(i1);
        int weight2 = getWeight(i2);
        if (weight1 > weight2) {
            return 1;
        } else if (weight1 == weight2) {
            return i1.toString().compareTo(i2.toString());
        } else {
            return -1;
        }
    }

    public static int getWeight(Long i) {
        int weight = 0;
        while (i >= 10) {
            weight += i % 10;
            i /= 10;
        }
        weight += i;
        return weight;
    }
}
