package com.utknl.katas;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codewars.com/kata/587136ba2eefcb92a9000027/train/java
 * <p>
 * Your task is to make a simple class called SnakesLadders. The test cases will call the method play(die1, die2)
 * independantly of the state of the game or the player turn. The variables die1 and die2 are the die thrown in a turn
 * and are both integers between 1 and 6. The player will move the sum of die1 and die2.
 * <p>
 * Rules
 * 1.  There are two players and both start off the board on square 0.
 * <p>
 * 2.  Player 1 starts and alternates with player 2.
 * <p>
 * 3.  You follow the numbers up the board in order 1=>100
 * <p>
 * 4.  If the value of both die are the same then that player will have another go.
 * <p>
 * 5.  Climb up ladders. The ladders on the game board allow you to move upwards and get ahead faster.
 * If you land exactly on a square that shows an image of the bottom of a ladder, then you may move the player
 * all the way up to the square at the top of the ladder. (even if you roll a double).
 * <p>
 * 6.  Slide down snakes. Snakes move you back on the board because you have to slide down them.
 * If you land exactly at the top of a snake, slide move the player all the way to the square at the bottom of the snake or chute.
 * (even if you roll a double).
 * <p>
 * 7.  Land exactly on the last square to win. The first person to reach the highest square on the board wins.
 * But there's a twist! If you roll too high, your player "bounces" off the last square and moves back.
 * You can only win by rolling the exact number needed to land on the last square. For example,
 * if you are on square 98 and roll a five, move your game piece to 100 (two moves), then "bounce" back to 99, 98, 97
 * (three, four then five moves.)
 * <p>
 * Returns
 * Return Player n Wins!. Where n is winning player that has landed on square 100 without any remainding moves left.
 * <p>
 * Return Game over! if a player has won and another player tries to play.
 * <p>
 * Otherwise return Player n is on square x. Where n is the current player and x is the sqaure they are currently on.
 */

public class SnakesAndLadders {

    Player player1 = new Player(0, "1");
    Player player2 = new Player(0, "2");
    Player currentPlayer = player1;
    Map<Integer, Integer> rules = new HashMap<>();

    public SnakesAndLadders() {
        rules.put(2, 38);
        rules.put(7, 14);
        rules.put(8, 31);
        rules.put(15, 26);
        rules.put(21, 42);
        rules.put(28, 84);
        rules.put(36, 44);
        rules.put(51, 67);
        rules.put(71, 91);
        rules.put(78, 98);
        rules.put(87, 94);
        rules.put(16, 6);
        rules.put(46, 25);
        rules.put(49, 11);
        rules.put(62, 19);
        rules.put(64, 60);
        rules.put(74, 53);
        rules.put(89, 68);
        rules.put(92, 88);
        rules.put(95, 75);
        rules.put(99, 80);
    }

    public String play(int die1, int die2) {

        if (currentPlayer.getPosition() == 100) {
            return "Game over!";
        }

        int forward = die1 + die2;
        currentPlayer.move(forward);

        currentPlayer.moveIfOnAnyRule(rules);

        if (currentPlayer.getPosition() == 100) {
            return "Player " + currentPlayer.getName() + " Wins!";
        } else {
            String message = "Player " + currentPlayer.getName() + " is on square " + currentPlayer.getPosition();
            if (die1 != die2) {
                switchPlayer();
            }
            return message;
        }

    }

    private void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}

class Player {

    private int position;
    private String name;

    public Player(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int steps) {
        if (position + steps > 100) {
            position = 100 - (position + steps - 100);
        } else {
            position += steps;
        }
    }

    public String getName() {
        return name;
    }

    public void moveIfOnAnyRule(Map<Integer, Integer> rules) {
        Integer position = rules.get(this.position);
        if (position != null) {
            this.position = position;
        }
    }

}