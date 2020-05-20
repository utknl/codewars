package com.utknl.katas;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codewars.com/kata/5508249a98b3234f420000fb/train/java
 * <p>
 * The action of a Caesar cipher is to replace each plaintext letter with a different one a fixed number of places up
 * or down the alphabet.
 * <p>
 * This program performs a variation of the Caesar shift. The shift increases by 1 for each character
 * (on each iteration).
 * <p>
 * If the shift is initially 1, the first character of the message to be encoded will be shifted by 1,
 * the second character will be shifted by 2, etc...
 * <p>
 * Coding: Parameters and return of function "movingShift"
 * param s: a string to be coded
 * param shift: an integer giving the initial shift
 * <p>
 * The function "movingShift" first codes the entire string and then returns an array of strings containing
 * the coded string in 5 parts (five parts because, to avoid more risks, the coded message will be given to five runners,
 * one piece for each runner).
 * <p>
 * If possible the message will be equally divided by message length between the five runners. If this is not possible,
 * parts 1 to 5 will have subsequently non-increasing lengths, such that parts 1 to 4 are at least as long as
 * when evenly divided, but at most 1 longer. If the last part is the empty string this empty string must be
 * shown in the resulting array.
 * <p>
 * For example, if the coded message has a length of 17 the five parts will have lengths of 4, 4, 4, 4, 1.
 * The parts 1, 2, 3, 4 are evenly split and the last part of length 1 is shorter. If the length is 16 the parts
 * will be of lengths 4, 4, 4, 4, 0. Parts 1, 2, 3, 4 are evenly split and the fifth runner will stay at home since
 * his part is the empty string. If the length is 11, equal parts would be of length 2.2,
 * hence parts will be of lengths 3, 3, 3, 2, 0.
 * <p>
 * You will also implement a "demovingShift" function with two parameters
 * <p>
 * Decoding: parameters and return of function "demovingShift"
 * 1) an array of strings: s (possibly resulting from "movingShift", with 5 strings)
 * <p>
 * 2) an int shift
 * <p>
 * "demovingShift" returns a string.
 * <p>
 * Example:
 * u = "I should have known that you would have a perfect answer for me!!!"
 * <p>
 * movingShift(u, 1) returns :
 * <p>
 * v = ["J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!"]
 * <p>
 * (quotes added in order to see the strings and the spaces, your program won't write these quotes,
 * see Example Test Cases)
 * <p>
 * and demovingShift(v, 1) returns u. #Ref:
 */

public class CaesarCipher {

    public static List<String> movingShift(String s, int shift) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int value = ((i + shift) % 26) + s.charAt(i);
            if (65 <= s.charAt(i) && s.charAt(i) <= 90) {
                if (value > 90) {
                    builder.append((char) ((value + 64) - 90));
                } else {
                    builder.append((char) value);
                }
            } else if (97 <= s.charAt(i) && s.charAt(i) <= 122) {
                if (value > 122) {
                    builder.append((char) ((value + 96) - 122));
                } else {
                    builder.append((char) value);
                }
            } else {
                builder.append(s.charAt(i));
            }
        }

        int size = builder.toString().length();
        int divideCount = (int) Math.ceil(size / 5.0);

        List<String> dividedString = new ArrayList<>();

        while (size > divideCount) {
            dividedString.add(builder.substring(0, divideCount));
            builder.replace(0, divideCount, "");
            size -= divideCount;
        }
        dividedString.add(builder.substring(0, size));

        if (dividedString.size() == 4) {
            dividedString.add("");
        }

        return dividedString;
    }

    public static String demovingShift(List<String> s, int shift) {

        StringBuilder builder = new StringBuilder();
        for (String letter : s) {
            builder.append(letter);
        }

        List<Integer> asciiValues = new ArrayList<>();
        List<Integer> updatedAsciiValues = new ArrayList<>();

        for (char c : builder.toString().toCharArray()) {
            asciiValues.add((int) c);
        }

        for (int i = 0; i < asciiValues.size(); i++) {
            if (65 <= asciiValues.get(i) && asciiValues.get(i) <= 90) {
                int value = asciiValues.get(i) - ((i + shift) % 26);
                if (value < 65) {
                    updatedAsciiValues.add((value + 90) - 64);
                } else {
                    updatedAsciiValues.add(value);
                }
            } else if (97 <= asciiValues.get(i) && asciiValues.get(i) <= 122) {
                int value = asciiValues.get(i) - ((i + shift) % 26);
                if (value < 97) {
                    updatedAsciiValues.add((value + 122) - 96);
                } else {
                    updatedAsciiValues.add(value);
                }
            } else {
                updatedAsciiValues.add(asciiValues.get(i));
            }
        }

        StringBuilder builder2 = new StringBuilder();

        for (int asciiValue : updatedAsciiValues) {
            builder2.append((char) asciiValue);
        }

        return builder2.toString();
    }

}
