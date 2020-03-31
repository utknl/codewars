package com.utknl.katas;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/51ba717bb08c1cd60f00002f
 * <p>
 * A format for expressing an ordered list of integers is to use a comma separated list of either
 * <p>
 * individual integers
 * or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'.
 * The range includes all integers in the interval including both endpoints. It is not considered a range unless it
 * spans at least 3 numbers. For example ("12, 13, 15-17")
 * Complete the solution so that it takes a list of integers in increasing order and returns a correctly
 * formatted string in the range format.
 * <p>
 * Example:
 * <p>
 * Solution.rangeExtraction(new int[] {-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
 * # returns "-6,-3-1,3-5,7-11,14,15,17-20"
 */

public class RangeExtraction {

    public static String rangeExtraction(int[] arr) {

        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        StringBuilder s = new StringBuilder();
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                s.append(arr[i]);
                return s.toString();
            }
            if (arr[i + 1] - arr[i] != 1) {
                s.append(arr[i]).append(",");
            } else if (arr[i + 1] - arr[i] == 1) {
                if (i + 2 < arr.length && arr[i + 2] - arr[i + 1] != 1) {
                    s.append(arr[i]).append(",").append(arr[i + 1]).append(",");
                    i++;
                } else if (i + 2 == arr.length) {
                    s.append(arr[i]).append(",").append(arr[i + 1]);
                    return s.toString();
                } else {
                    s.append(arr[i]).append("-");
                    while (arr[i + 1] - arr[i] == 1) {
                        if (i + 1 == arr.length - 1) {
                            s.append(arr[i + 1]);
                            return s.toString();
                        }
                        i++;
                    }
                    s.append(arr[i]).append(",");
                }
            }
        }
        return s.toString();
    }
}
