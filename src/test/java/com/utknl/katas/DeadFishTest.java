package com.utknl.katas;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class DeadFishTest {

    @org.junit.Test
    public void exampleTests() {
        assertArrayEquals(new int[]{8, 64}, DeadFish.parse("iiisdoso"));
        assertArrayEquals(new int[]{8, 64, 3600}, DeadFish.parse("iiisdosodddddiso"));
    }

    @Test
    public void seeOutput() {
        System.out.println(Arrays.toString(DeadFish.parse("iiisdoso")));
    }
}