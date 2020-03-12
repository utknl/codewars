package com.utknl.katas;

/**
 * https://www.codewars.com/kata/5526fc09a1bbd946250002dc/train/java
 * <p>
 * You are given an array (which will have a length of at least 3, but could be very large) containing integers.
 * The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N.
 * Write a method that takes the array as an argument and returns this "outlier" N.
 */

public class FindTheParityOutlier {

    static int find(int[] numbers) {
        Integer lastEven = null;
        Integer lastOdd = null;

        for (int i = 0; i < 2; i++) {
            if (isEven(numbers[i])) {
                lastEven = numbers[i];
            } else {
                lastOdd = numbers[i];
            }
        }

        if (lastEven != null && lastOdd != null) {
            //gonna find the answer
            if (isEven(numbers[2])) {
                return lastOdd;
            } else {
                return lastEven;
            }
        }

        var lookForEven = lastOdd != null;

        for (int i = 3; i < numbers.length; i++) {
            if (lookForEven && isEven(numbers[i])) {
                return numbers[i];
            } else if (!lookForEven && !isEven(numbers[i])) {
                return numbers[i];
            }
        }
        throw new IllegalArgumentException();
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

//    public static int find(int[] numbers) {
//        List<Integer> evens = new ArrayList<>();
//        List<Integer> odds = new ArrayList<>();
//
//        for (var i = 0; i < numbers.length; i++) {
//            if (numbers[i] % 2 == 0) {
//                evens.add(numbers[i]);
//            } else {
//                odds.add(numbers[i]);
//            }
//        }
//        if (evens.size() > odds.size()) {
//            return odds.get(0);
//        } else {
//            return evens.get(0);
//        }
//    }

 /* EVIL MODE ON

    [1,2,3,4] => done
    [0,2,11,4] => done
    [1,3,5,7,9,4] -> lookForEven=true;=>done
    [2,4,6,8,10,11] -> lookForEven=false;=>done
//    static int find(int[] numbers) {
//        Integer lastEven = null;
//        Integer lastOdd = null;
//
//        for (int i = 0; i < 2; i++) {
//            if (isEven(numbers[i])) {
//                lastEven = numbers[i];
//            } else {
//                lastOdd = numbers[i];
//            }
//        }
//
//        if (lastEven != null && lastOdd != null) {
//            //gonna find the answer
//            if (isEven(numbers[2])) {
//                return lastOdd;
//            } else {
//                return lastEven;
//            }
//        }
//
//        return IntStream.range(3, numbers.length)
//                .filter(getPredicate(lastOdd))
//                .findFirst()
//                .orElseThrow();
//    }
//
//    private static IntPredicate getPredicate(Integer lastOdd) {
//        return lastOdd != null
//                ? FindTheParityOutlier::isEven
//                : nor(FindTheParityOutlier::isEven);
//    }
//
//    private static boolean isEven(int number) {
//        return number % 2 == 0;
//    }
//
//    private static IntPredicate nor(IntPredicate predicate) {
//        return value -> !predicate.test(value);
//    }
  */
}


