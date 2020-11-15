package com.utknl.katas;

import java.util.ArrayList;
import java.util.List;

public class JosephusSurvivor {


    public static void main(String[] args) {
        int until = 7;
        int leap = 3;

        System.out.println(josephusSurvivor(7, 3));

    }

    public static int josephusSurvivor(final int n, final int k) {

        List<Integer> numberList = new ArrayList<>();


        for (int i = 1; i <= n; i++) {
            numberList.add(i);
        }

        int count = 0;
        int index = 0;
        while (numberList.size() != 1) {
            if (count == k - 1) {
                numberList.remove(index);
                count = 0;
                if (index == numberList.size()) {
                    index = 0;
                    continue;
                }
                continue;
            }
            count++;
            if (index == numberList.size() - 1) {
                index = 0;
                continue;
            }
            index++;
        }
        return numberList.get(0);
    }


}
