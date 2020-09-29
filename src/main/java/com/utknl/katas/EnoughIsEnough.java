package com.utknl.katas;

import java.util.*;
import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/554ca54ffa7d91b236000023/train/java
 * <p>
 * Enough is enough!
 * Alice and Bob were on a holiday. Both of them took many pictures of the places they've been,
 * and now they want to show Charlie their entire collection. However, Charlie doesn't like these sessions,
 * since the motive usually repeats. He isn't fond of seeing the Eiffel tower 40 times. He tells them that
 * he will only sit during the session if they show the same motive at most N times. Luckily,
 * Alice and Bob are able to encode the motive as a number. Can you help them to remove numbers such that their list
 * contains each number only up to N times, without changing the order?
 * <p>
 * Task
 * Given a list lst and a number N, create a new list that contains each number of lst at most N times without reordering.
 * For example if N = 2, and the input is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next [1,2]
 * since this would lead to 1 and 2 being in the result 3 times, and then take 3, which leads to [1,2,3,1,2,3].
 */

public class EnoughIsEnough {


    public static void main(String[] args) {
        int[] elements = new int[]{1, 2, 3, 1, 2, 1, 2, 3};
        int maxOccurrences = 2;
        //2,2,3,3,4
        System.out.println(Arrays.toString(deleteNth(elements, maxOccurrences)));

    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        Map<Integer, Integer> numberFrequency = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int element : elements) {
            numberFrequency.putIfAbsent(element, 0);
            if (numberFrequency.get(element) != maxOccurrences) {
                numberFrequency.put(element, numberFrequency.get(element) + 1);
                list.add(element);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] deleteNth2(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> occurrence = new HashMap<>();
        return IntStream.of(elements)
                .filter(motif -> occurrence.merge(motif, 1, Integer::sum) <= maxOccurrences)
                .toArray();
    }


}
