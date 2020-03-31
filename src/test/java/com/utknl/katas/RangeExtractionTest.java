package com.utknl.katas;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangeExtractionTest {

    @Test
    public void test_BasicTests() {

        assertEquals("-6,-3-1,3-5,7-11,14,15,17-20",
                RangeExtraction.rangeExtraction(new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}));

        assertEquals("-3--1,2,10,15,16,18-20",
                RangeExtraction.rangeExtraction(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20}));

    }

    @Test
    public void test1() {

        int[] arr = new int[]{-10, -9, -7, -4, -3, -2, -1, 0, 1, 3, 5, 7, 9, 12, 13, 14, 16, 17, 20, 22, 25, 26, 29, 30, 33, 34, 37, 39, 40};
        System.out.println(RangeExtraction.rangeExtraction(arr));


    }
}