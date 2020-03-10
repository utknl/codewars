package com.utknl.katas;

/**
 * https://www.codewars.com/kata/525f50e3b73515a6db000b83/train/java
 * <p>
 * Write a function that accepts an array of 10 integers (between 0 and 9),
 * that returns a string of those numbers in the form of a phone number.
 */


public class CreatePhoneNumber {

    public String createPhoneNumber(int[] numbers) throws Exception {

        if (numbers.length != 10) {
            throw new Exception("Array size should be ten");
        }

        return String.format("(%s) %s-%s", getInitials(numbers), getMid(numbers), getLast(numbers));

    }

    public String getInitials(int[] numbers) {
        int first = numbers[0];
        int second = numbers[1];
        int third = numbers[2];
        return String.format("%s%s%s", first, second, third);
    }

    public String getMid(int[] numbers) {
        int fourth = numbers[3];
        int fifth = numbers[4];
        int sixth = numbers[5];
        return String.format("%s%s%s", fourth, fifth, sixth);
    }

    public String getLast(int[] numbers) {
        int seventh = numbers[numbers.length - 4];
        int eigth = numbers[numbers.length - 3];
        int nineth = numbers[numbers.length - 2];
        int tenth = numbers[numbers.length - 1];
        return String.format("%s%s%s%s", seventh, eigth, nineth, tenth);
    }

}

/**
 * Good ones
 * <p>
 * return String.format("(%d%d%d) %d%d%d-%d%d%d%d", java.util.stream.IntStream.of(numbers).boxed().toArray());
 */
