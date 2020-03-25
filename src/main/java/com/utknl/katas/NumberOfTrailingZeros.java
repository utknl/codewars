package com.utknl.katas;

/*

https://www.codewars.com/kata/52f787eb172a8b4ae1000a34/train/java

Write a program that will calculate the number of trailing zeros in a factorial of a given number.

N! = 1 * 2 * 3 * ... * N

Be careful 1000! has 2568 digits...

For more info, see: http://mathworld.wolfram.com/Factorial.html

Examples
zeros(6) = 1
# 6! = 1 * 2 * 3 * 4 * 5 * 6 = 720 --> 1 trailing zero

zeros(12) = 2
# 12! = 479001600 --> 2 trailing zeros

Hint: You're not meant to calculate the factorial. Find another way to find the number of zeros.

*/

public class NumberOfTrailingZeros {

    public static int zeros(int n) {

        int trailingZero = 0;
        while (n >= 5) {
            trailingZero += n / 5;
            n = n / 5;
        }
        return trailingZero;

    }

}