package com.utknl.katas;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class DoubleColaTest {
    @Test
    public void test1() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 19;
        assertEquals("Sheldon", DoubleCola.whoIsNext(names, n));
    }

    @Test //23 2 24 3
    public void test2() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 21;
        assertEquals("Leonard", DoubleCola.whoIsNext(names, n));
    }

    @Test
    public void test4() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 80;
        assertEquals("Leonard", DoubleCola.whoIsNext(names, n));
    }

    @Test
    public void test3() {
        String[] names = new String[]{"a", "b", "c", "d", "e"};
        // List<String> strings1 = Arrays.asList(names); // immutable oldugu icin yalnizca iterator edebilirsin
        List<String> strings = Arrays.stream(names).collect(Collectors.toList());
        System.out.println("1" + strings);
        String first = strings.get(0);
        strings.remove(first);
        strings.add(first);
        strings.add(first);

        System.out.println("2" + strings);
    }

    @Test
    public void orderFinder() {
        int position = 0;
        int order = 44;
        double x = 0;

        while (position < order) {
            x++;
            position = (int) (Math.pow(2d, x) * 5d);
        }

        System.out.println("p " + position);
        System.out.println("o " + order);
        System.out.println("x " + x);

    }
}