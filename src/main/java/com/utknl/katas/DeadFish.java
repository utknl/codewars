package com.utknl.katas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.codewars.com/kata/51e0007c1f9378fa810002a9/train/java
 * <p>
 * Write a simple parser that will parse and run Deadfish.
 * <p>
 * Deadfish has 4 commands, each 1 character long:
 * <p>
 * i increments the value (initially 0)
 * d decrements the value
 * s squares the value
 * o outputs the value into the return array
 * Invalid characters should be ignored.
 * <p>
 * Deadfish.parse("iiisdoso") =- new int[] {8, 64};
 */

public class DeadFish {

    public static int[] parse(String data) {
        int initial = 0;
        List<Integer> list = new ArrayList<>();

        for (String s : data.split("")) {
            switch (s) {
                case "i":
                    initial += 1;
                    break;
                case "d":
                    initial -= 1;
                    break;
                case "s":
                    initial *= initial;
                    break;
                case "o":
                    list.add(initial);
                    break;
            }
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

}
