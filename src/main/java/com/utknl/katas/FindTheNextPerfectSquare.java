package com.utknl.katas;

/**
 * https://www.codewars.com/kata/56269eb78ad2e4ced1000013/train/java
 * <p>
 * You might know some pretty large perfect squares. But what about the NEXT one?
 * <p>
 * Complete the findNextSquare method that finds the next integral perfect square after the one passed as a parameter.
 * Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.
 * <p>
 * If the parameter is itself not a perfect square, than -1 should be returned. You may assume the parameter is positive.
 */

public class FindTheNextPerfectSquare {

    public static long findNextSquare(long sq) {
        int x = (int) Math.sqrt(sq);
        if (Math.pow(x, 2) != sq) {
            return -1L;
        }
        return (long) Math.pow(Math.sqrt(sq) + 1, 2);
    }

}

/*
  Good ones:

  return Math.sqrt(sq) % 1 != 0 ? -1 : (long)Math.pow(Math.sqrt(sq)+1,2);

 */