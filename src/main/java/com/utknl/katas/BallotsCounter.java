package com.utknl.katas;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/554910d77a3582bbe300009c/train/java
 */

public class BallotsCounter {

    public static void main(String[] args) {
        List<String> votes = Arrays.asList("A", "A", "B", "B", "C", "C", "C");
        System.out.println(getWinner(votes));
    }

    public static String getWinner(final List<String> listOfBallots) {
        int n = listOfBallots.size();
        int majority = (n / 2) + 1;

        // compute PARTY -> VOTES mapping
        Map<String, Long> counts = listOfBallots.stream().collect(Collectors.groupingBy(Object::toString, Collectors.counting()));

        // determine winner
        return counts.entrySet().stream().filter((e) -> e.getValue() >= majority).map(Map.Entry::getKey).findFirst().orElse(null);
    }


//
//    public static String getWinner(final List<String> listOfBallots) {
//
//        // int n = listOfBallots.size();
//        //      int majority = (n/2) + 1;
//        //
//        //      // compute PARTY -> VOTES mapping
//        //      Map<String, Long> counts = listOfBallots.stream().collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
//        //
//        //      // determine winner
//        //      return counts.entrySet().stream().filter((e) -> e.getValue() >= majority).map(Map.Entry::getKey).findFirst().orElse(null);
//
//        Map<String, Integer> numberCount = new HashMap<>();
//
//        for (String v : listOfBallots) {
//            numberCount.merge(v, 1, Integer::sum);
//        }
//
//        int highest = 0;
//        String ballot = "";
//
//        for (Map.Entry<String, Integer> entry : numberCount.entrySet()) {
//            if (entry.getValue() > highest) {
//                highest = entry.getValue();
//                ballot = entry.getKey();
//            }
//        }
//
//        int count = 0;
//        for (Map.Entry<String, Integer> entry : numberCount.entrySet()) {
//            if (entry.getValue() == highest) {
//                count++;
//            }
//        }
//
//        if (count > 1) {
//            return null;
//        }
//
//        if (numberCount.get(ballot) > listOfBallots.size() / 2) {
//            return ballot;
//        } else {
//            return null;
//        }
//    }

}
