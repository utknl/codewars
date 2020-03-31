package com.utknl.katas;

import java.util.ArrayList;
import java.util.function.BiConsumer;

/**
 * https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1/train/java
 * <p>
 * Snail Sort
 * Given an n x n array, return the array elements arranged from outermost elements to the middle element,
 * traveling clockwise.
 * <p>
 * array = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * snail(array) #=> [1,2,3,6,9,8,7,4,5]
 * For better understanding, please follow the numbers of the next array consecutively:
 * <p>
 * array = [[1,2,3],
 * [8,9,4],
 * [7,6,5]]
 * snail(array) #=> [1,2,3,4,5,6,7,8,9]
 * <p>
 * array = [[2,3,4,5,6,7],
 * [8,9,1,a,b,c],
 * [d,e,f,g,h,i],
 * [j,k,l,m,n,o],
 * [p,r,q,s,t,v]]
 * <p>
 * -> [2,3,4,5,6,7,c,i,o,v,t,s,q,r,p,j,d,8,9,1,a,b,h,n,m,l,k,j,d,e,f,g]
 */


public class Snail {

    public static int[] snail(int[][] array) {

        int N = array.length;
        if (N == 0 || array[0].length == 0) return new int[]{};
        var result = new ArrayList<Integer>();
        int[] oRight = {0, N};
        int[] oDown = {0, N};
        int[] oLeft = {0, N};
        int[] oUp = {0, N};

        BiConsumer<Integer, Integer> pusher = (i, j) -> {
            result.add(array[i][j]);
        };

        while (result.size() != N * N) {
            for (int i = oRight[0]; i < oRight[1]; i++) {
                pusher.accept(oDown[0], i);
            }
            if (result.size() == N * N) break;
            oRight[0]++;
            for (int i = ++oDown[0]; i < oDown[1]; i++) {
                pusher.accept(i, oDown[1] - 1);
            }
            if (result.size() == N * N) break;
            oRight[1]--;
            oDown[1]--;
            for (int i = ++oLeft[0]; i < oLeft[1]; i++) {
                pusher.accept(oDown[1], N - 1 - i);
            }
            oLeft[1]--;
            if (result.size() == N * N) break;
            oUp[1]--;
            for (int i = ++oUp[0]; i < oUp[1]; i++) {
                pusher.accept(N - 1 - i, oRight[0] - 1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}



