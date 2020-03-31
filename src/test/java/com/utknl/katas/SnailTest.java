package com.utknl.katas;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class SnailTest {

    @Test
    public void SnailTest1() {
        int[][] array
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        test(array, r);
    }

    public String int2dToString(int[][] a) {
        return Arrays.stream(a).map(row -> Arrays.toString(row)).collect(joining("\n"));
    }

    public void test(int[][] array, int[] result) {
        String text = int2dToString(array) + " should be sorted to " + Arrays.toString(result);
        System.out.println(text);
        Assert.assertArrayEquals(result, Snail.snail(array));
    }

    @Test
    public void getMatris() {
        int[][] array1
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int hor1 = array1[0].length - 1;
        int ver1 = array1.length - 1;


        System.out.println("array 1 hor and ver = " + hor1 + " - " + ver1);
//        System.out.println("array 2 hor and ver = " + hor2 + " - " + ver2);


        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= hor1; i++) {
            list.add(array1[0][i]);
        }

        for (int i = 1; i <= ver1; i++) {
            list.add(array1[i][ver1]);
        }

        for (int i = hor1 - 1; i >= 0; i--) {
            list.add(array1[ver1][i]);
        }

        for (int i = ver1 - 1; i > 0; i--) {
            list.add(array1[i][0]);
        }

        for (int i = 1; i <= hor1 - 1; i++) {
            list.add(array1[hor1 - 1][i]);
        }

        System.out.println(list);

    }

    @Test
    public void test2() {
        int[][] array
                = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}
        };

        int horSize = array[0].length;
        int verSize = array.length;
        int totalItem = horSize * verSize;

        int hor = array[0].length - 1;
        int ver = array.length - 1;

        System.out.println(hor + " " + ver);

        List<Integer> list = new ArrayList<>();

        int beginningIndex = 0;
        // 0 2
        // 1 2
        // 1 0
        // 1

        //

        while (totalItem > 0) {

            for (int i = beginningIndex; i <= hor; i++) {
                list.add(array[0][i]);
                totalItem--;
            }

            for (int i = 1; i <= ver; i++) {
                list.add(array[i][ver]);
                totalItem--;
            }

            for (int i = hor - 1; i >= 0; i--) {
                list.add(array[ver][i]);
                totalItem--;
            }

            for (int i = ver - 1; i > 0; i--) {
                list.add(array[i][0]);
                totalItem--;
            }

        }


        System.out.println(list);

    }
}