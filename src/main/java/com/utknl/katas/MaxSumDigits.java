package com.utknl.katas;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codewars.com/kata/55f5efd21ad2b48895000040/train/java
 * <p>
 * We want to find the numbers higher or equal than 1000 that the sum of every four consecutives digits cannot
 * be higher than a certain given value. If the number is num = d1d2d3d4d5d6,
 * and the maximum sum of 4 contiguous digits is maxSum, then:
 * <p>
 * d1 + d2 + d3 + d4 <= maxSum
 * d2 + d3 + d4 + d5 <= maxSum
 * d3 + d4 + d5 + d6 <= maxSum
 * For that purpose, we need to create a function, max_sumDig(), that receives nMax,
 * as the max value of the interval to study (the range (1000, nMax) ), and a certain value,
 * maxSum, the maximum sum that every four consecutive digits should be less or equal to.
 * The function should output the following list with the data detailed bellow:
 * <p>
 * [(1), (2), (3)]
 * <p>
 * (1) - the amount of numbers that satisfy the constraint presented above
 * <p>
 * (2) - the closest number to the mean of the results, if there are more than one, the smallest number should be chosen.
 * <p>
 * (3) - the total sum of all the found numbers
 * <p>
 * Let's see a case with all the details:
 * <p>
 * max_sumDig(2000, 3) -------> [11, 1110, 12555]
 * <p>
 * (1) -There are 11 found numbers: 1000, 1001, 1002, 1010, 1011, 1020, 1100, 1101, 1110, 1200 and 2000
 * <p>
 * (2) - The mean of all the found numbers is:
 * (1000 + 1001 + 1002 + 1010 + 1011 + 1020 + 1100 + 1101 + 1110 + 1200 + 2000) /11 = 1141.36363,
 * so 1110 is the number that is closest to that mean value.
 * <p>
 * (3) - 12555 is the sum of all the found numbers
 * 1000 + 1001 + 1002 + 1010 + 1011 + 1020 + 1100 + 1101 + 1110 + 1200 + 2000 = 12555
 * <p>
 * Finally, let's see another cases
 * max_sumDig(2000, 4) -----> [21, 1120, 23665]
 * <p>
 * max_sumDig(2000, 7) -----> [85, 1200, 99986]
 * <p>
 * max_sumDig(3000, 7) -----> [141, 1600, 220756]
 */

public class MaxSumDigits {

    public static long[] maxSumDig(long nmax, int maxsm) {
        List<Long> validNumbers = new ArrayList<>();
        for (int i = 1000; i <= nmax; i++) {
            if (getValidNumbers(i, maxsm)) {
                validNumbers.add((long) i);
            }
        }
        return new long[]{validNumbers.size(), getMeanNumber(validNumbers), sumValidNumbers(validNumbers)};
    }

    static boolean getValidNumbers(long number, long maxsm) {
        List<Long> numberToList = new ArrayList<>();
        for (char i : String.valueOf(number).toCharArray()) {
            numberToList.add((long) Character.getNumericValue(i));
        }
        for (int i = 0; i <= numberToList.size(); i++) {
            if (i + 3 < numberToList.size()) {
                long one = numberToList.get(i);
                long two = numberToList.get(i + 1);
                long three = numberToList.get(i + 2);
                long four = numberToList.get(i + 3);
                var sum = one + two + three + four;
                if (sum > maxsm) {
                    return false;
                }
            }
        }
        return true;
    }

    static Long sumValidNumbers(List<Long> numbers) {
        long sumOfNumbers = 0;
        for (Long i : numbers) {
            sumOfNumbers += i;
        }
        return sumOfNumbers;
    }

    static Long getMeanNumber(List<Long> numbers) {
        long meanResult = sumValidNumbers(numbers) / numbers.size();
        long currentNumber = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (Math.abs(numbers.get(i) - meanResult) < Math.abs(currentNumber - meanResult)) {
                currentNumber = numbers.get(i);
            } else if (Math.abs(numbers.get(i) - meanResult) == Math.abs(currentNumber - meanResult)) {
                if (numbers.get(i) > currentNumber) {
                    currentNumber = numbers.get(i);
                }
            }
        }
        return currentNumber;
    }
}
