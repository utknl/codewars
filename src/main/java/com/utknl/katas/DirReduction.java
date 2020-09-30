package com.utknl.katas;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://www.codewars.com/kata/550f22f4d758534c1100025a/train/java
 * <p>
 * Once upon a time, on a way through the old wild mountainous west,…
 * … a man was given directions to go from one point to another. The directions were "NORTH", "SOUTH", "WEST", "EAST".
 * Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST" too.
 * <p>
 * Going to one direction and coming back the opposite direction right away is a needless effort.
 * Since this is the wild west, with dreadfull weather and not much water, it's important to save yourself some energy,
 * otherwise you might die of thirst!
 * <p>
 * How I crossed a mountain desert the smart way.
 * The directions given to the man are, for example, the following (depending on the language):
 * <p>
 * ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
 * or
 * <p>
 * { "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
 * or
 * <p>
 * [North, South, South, East, West, North, West]
 * You can immediatly see that going "NORTH" and immediately "SOUTH" is not reasonable, better stay to the same place!
 * So the task is to give to the man a simplified version of the plan. A better plan in this case is simply:
 * <p>
 * ["WEST"]
 * or
 * <p>
 * { "WEST" }
 * or
 * <p>
 * [West]
 * Other examples:
 * In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and coming back right away.
 * <p>
 * The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore,
 * the final result is [] (nil in Clojure).
 * <p>
 * In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite but
 * they become directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].
 * <p>
 * Task
 * Write a function dirReduc which will take an array of strings and returns an array of strings with the needless
 * directions removed (W<->E or S<->N side by side).
 * <p>
 * The Haskell version takes a list of directions with data Direction = North | East | West | South.
 * The Clojure version returns nil when the path is reduced to nothing.
 * The Rust version takes a slice of enum Direction {NORTH, SOUTH, EAST, WEST}.
 */

public class DirReduction {

    public static void main(String[] args) {
        String[] directions = new String[]{"NORTH", "SOUTH", "EAST", "EAST", "WEST"};
        System.out.println(Arrays.toString(dirReduc(directions)));
    }

    public static String[] dirReduc(String[] arr) {

        Stack<String> shortened = new Stack<>();

        for (String s : arr) {
            if (shortened.isEmpty()) {
                shortened.push(s);
            } else {
                String peek = shortened.peek();
                if (isOpposite(s, peek)) {
                    shortened.pop();
                } else shortened.push(s);
            }
        }
        return shortened.toArray(new String[0]);
    }

    public static boolean isOpposite(String s1, String s2) {
        if ((s1.equals("NORTH") && s2.equals("SOUTH")) || (s1.equals("SOUTH") && s2.equals("NORTH"))) {
            return true;
        } else return s1.equals("WEST") && s2.equals("EAST") || (s1.equals("EAST") && s2.equals("WEST"));
    }

}
