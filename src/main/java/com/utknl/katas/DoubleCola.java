package com.utknl.katas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/551dd1f424b7a4cdae0001f0/train/java
 * <p>
 * Sheldon, Leonard, Penny, Rajesh and Howard are in the queue for a "Double
 * Cola" drink vending machine; there are no other people in the queue. The
 * first one in the queue (Sheldon) buys a can, drinks it and doubles! The
 * resulting two Sheldons go to the end of the queue. Then the next in the queue
 * (Leonard) buys a can, drinks it and gets to the end of the queue as two
 * Leonards, and so on.
 * <p>
 * For example, Penny drinks the third can of cola and the queue will look like
 * this:
 * <p>
 * Rajesh, Howard, Sheldon, Sheldon, Leonard, Leonard, Penny, Penny Write a
 * program that will return the name of the person who will drink the n-th cola.
 * <p>
 * Input The input data consist of an array which contains at least 1 name, and
 * single integer n which may go as high as the biggest number your language of
 * choice supports (if there's such limit, of course).
 * <p>
 * Output / Examples Return the single line — the name of the person who drinks
 * the n-th can of cola. The cans are numbered starting from 1.
 * <p>
 * string[] names = new string[] { "Sheldon", "Leonard", "Penny", "Rajesh",
 * "Howard" }; Line.WhoIsNext(names, 1) == "Sheldon" Line.WhoIsNext(names, 52)
 * == "Penny" Line.WhoIsNext(names, 7230702951) == "Leonard"
 */

public class DoubleCola {
    public static String whoIsNext(String[] names, int n) {

        List<String> collect = Arrays.stream(names).collect(Collectors.toList());

        if (n <= 5) {
            return collect.get(n - 1);
        }

        int order = findOrder(n);
        int beginningIndex = findBeginningIndex(order);
        int difference = n - beginningIndex;

        if (difference <= (int) Math.pow(2, order)) {
            return collect.get(0);
        }
        int index = difference / (int) Math.pow(2, order);
        if (difference % (int) Math.pow(2, order) == 0) {
            return collect.get(index - 1);
        } else {
            return collect.get(index);

        }

    }

    public static int findOrder(int n) {
        int position = 5;
        double x = 0;

        while (position <= n) {
            x++;
            position += (int) (Math.pow(2d, x) * 5d);
        }
        return (int) x;
    }

    public static int findBeginningIndex(int n) {
        int beginningIndex = 0;

        for (int i = 0; i < n; i++) {
            beginningIndex += (int) (Math.pow(2, i) * 5);
        }

        return beginningIndex;
    }

    /*
      1 2 3 4 5
      2 3 4 5 1 1
      3 4 5 1 1 2 2
      4
      5
      1
      1
      2
      2
      3
      3
      4
      4                                1: 1 6 7 16 17 18 19
      5                                2: 2 8 9 20 21 22 23
      5
      1
      1
      1
      1
      2
      2
      2
      2
      3
      3
      3
      3
      4
      4
      4
      4
      5
      5
      5
      5

*/

}