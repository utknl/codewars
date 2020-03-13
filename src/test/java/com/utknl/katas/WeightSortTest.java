package com.utknl.katas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeightSortTest {

    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals("2000 103 123 4444 99", WeightSort.orderWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999",
                WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }

    @Test
    public void whiteSpace() {
        String numbers = "  12    13 14       17     ";
        String[] split = numbers.split("");
        if (split[0].equals(" ")) {
            split[0] = "";
        }
        for (String n : split) {

        }
    }

}