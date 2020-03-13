package com.utknl.katas;

/**
 * https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec/train/java
 * <p>
 * Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence,
 * which is the number of times you must multiply the digits in num until you reach a single digit.
 * <p>
 * persistence(39) == 3 // because 3*9 = 27, 2*7 = 14, 1*4=4
 * // and 4 has only one digit
 * <p>
 * persistence(999) == 4 // because 9*9*9 = 729, 7*2*9 = 126,
 * // 1*2*6 = 12, and finally 1*2 = 2
 * <p>
 * persistence(4) == 0 // because 4 is already a one-digit number
 * <p>
 * persistence(4325) == 2 // 4*3*2*5 = 120 => 1 * 2 * 0 = 0
 */

public class PersistentBugger {

    public static int persistence(long n) {
        int count = 0;
        while (n >= 10) {
            n = getProduct(n);
            count++;
        }
        return count;
    }

    private static long getProduct(long n) {
        long product = 1L;
        while (n >= 10) {
            product *= n % 10;
            n = n / 10;
        }
        product *= n;
        return product;
    }

//        public static int persistence(long n) {
//
//        int count = 0;
//        while (n >= 10) {
//            n = getNewNumber(getList(n));
//            count++;
//        }
//        return count;
//    }
//
//    public static List<Long> getList(long n) {
//        List<Long> list = new ArrayList<>();
//        while (n >= 10) {
//            list.add(n % 10);
//            n = n / 10;
//        }
//        list.add(n);
//        return list;
//    }
//
//    public static long getNewNumber(List<Long> list) {
//        long number = 1L;
//        for (long i : list) {
//            number *= i;
//        }
//        return number;
//    }

}
