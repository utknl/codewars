package com.utknl.katas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codewars.com/kata/59590976838112bfea0000fa/train/java
 * <p>
 * Born a misinterpretation of this kata, your task here is pretty simple: given an array of values and an amount of beggars,
 * you are supposed to return an array with the sum of what each beggar brings home, assuming they all take regular turns,
 * from the first to the last.
 * <p>
 * For example: [1,2,3,4,5] for 2 beggars will return a result of [9,6], as the first one takes [1,3,5], the second collects [2,4].
 * <p>
 * The same array with 3 beggars would have in turn have produced a better out come for the second beggar: [5,7,3],
 * as they will respectively take [1,4], [2,5] and [3].
 * <p>
 * Also note that not all beggars have to take the same amount of "offers", meaning that the length of the array is not
 * necessarily a multiple of n; length can be even shorter, in which case the last beggars will of course take nothing (0).
 * <p>
 * Note: in case you don't get why this kata is about English beggars, then you are not familiar on how religiously
 * queues are taken in the kingdom ;)
 */


public class EnglishBeggars {

    public static void main(String[] args) {
        int[] values = new int[]{2, 3, 4, 5, 6, 7};
        // 2 4 6 = 12
        // 3 5 7 = 15
        int n = 1;
        System.out.println(Arrays.toString(beggars2(values, n)));
    }

    public static int[] beggars2(int[] values, int n) {
        if (n == 0) {
            return new int[]{};
        }
        int[] array = new int[n];
        int order = 0;
        for (int value : values) {
            array[order] += value;
            order++;
            if (order == n) {
                order = 0;
            }
        }
        return array;
    }

    public static int[] beggars3(int[] values, int n) {
        int[] result;

        if (n < 1) {//return empty array
            result = new int[0];
        } else {
            result = new int[n];
            for (int i = 0; i < values.length; i++) {

                // add value to currently queued element
                result[i % n] += values[i];
            }
        }

        return result;
    }


}
