package com.utknl.katas;

import java.util.*;
import java.util.stream.*;

/**
 * https://www.codewars.com/kata/5270d0d18625160ada0000e4/train/java
 * <p>
 * Greed is a dice game played with five six-sided dice. Your mission, should
 * you choose to accept it, is to score a throw according to these rules. You
 * will always be given an array with five six-sided dice values.
 * <p>
 * Three 1's => 1000 points Three 6's => 600 points Three 5's => 500 points
 * Three 4's => 400 points Three 3's => 300 points Three 2's => 200 points One 1
 * => 100 points One 5 => 50 point A single die can only be counted once in each
 * roll. For example, a "5" can only count as part of a triplet (contributing to
 * the 500 points) or as a single 50 points, but not both in the same roll.
 * <p>
 * Example scoring
 * <p>
 * Throw Score --------- ------------------ 5 1 3 4 1 50 + 2 * 100 = 250 1 1 1 3
 * 1 1000 + 100 = 1100 2 4 4 5 4 400 + 50 = 450
 */
public class Greed {
    static List<Rule> rules = List.of(new Rule(1, 3, 1000),
            new Rule(2, 3, 200), new Rule(3, 3, 300),
            new Rule(4, 3, 400), new Rule(5, 3, 500),
            new Rule(6, 3, 600), new Rule(1, 1, 100),
            new Rule(5, 1, 50));

    public static List<Rule> getRules(int number) {
        return rules.stream().filter(it -> it.getNumber() == number).collect(Collectors.toList());
    }

    // https://docs.microsoft.com/tr-tr/visualstudio/liveshare/reference/security#code-commands
    public static int greedy(int[] dice) {
        // code here
        int score = 0;
        Map<Integer, Integer> numberMap = new HashMap<>(); // [1, 3] [2,2] [5,1]

        for (int die : dice) {
            numberMap.merge(die, 1, Integer::sum);
        }

        for (var entry : numberMap.entrySet()) {
            var number = entry.getKey();
            var count = entry.getValue();
            var rules = getRules(number);
            for (Rule rule : rules) {
                var times = count / rule.getCount();
                if (times > 0) {
                    score += times * rule.getPoint();
                    count -= times * rule.getCount();
                }
            }
        }
        return score;
    }

}

class Rule {

    private int number;
    private int count;
    private int point;

    public Rule(int number, int count, int point) {
        this.number = number;
        this.count = count;
        this.point = point;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}