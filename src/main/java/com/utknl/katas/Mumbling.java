package com.utknl.katas;

/**
 * https://www.codewars.com/kata/5667e8f4e3f572a8f2000039/java
 * <p>
 * This time no story, no theory. The examples below show you how to write function accum
 * <p>
 * The parameter of accum is a string which includes only letters from a..z and A..Z.
 */

public class Mumbling {

    public static String accum(String s) {
        var builder = new StringBuilder();
        var array = s.split("");

        for (int x = 0; x < array.length; x++) {
            builder.append("-");
            builder.append(array[x].toUpperCase());
            var lower = array[x].toLowerCase();
            builder.append(lower.repeat(x));
        }
        return builder.substring(1);
    }

//    public static String accum(String s) {
//        var builder = new StringBuilder();
//        var array = s.split("");
//        int i = 0;
//        for (var letter : array) {
//            builder.append(letter.toUpperCase());
//            for (int j = 0; j < i; j++) {
//                builder.append(letter.toLowerCase());
//            }
//            builder.append("-");
//            i++;
//        }
//        return builder.deleteCharAt(builder.length()-1).toString();
//    }

}
