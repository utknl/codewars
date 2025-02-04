package com.utknl.katas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScramblesTest {

    private static void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void letterTest() {

        assertTrue(Scramblies.scramble("mahmutmasddfgrfm", "mahmut"));

    }

    @Test
    public void test() {
        System.out.println("Fixed Tests scramble");
        testing(Scramblies.scramble("rkqodlw", "world"), true);
        testing(Scramblies.scramble("cedewaraaossoqqyt", "codewars"), true);
        testing(Scramblies.scramble("katas", "steak"), false);
        testing(Scramblies.scramble("scriptjavx", "javascript"), false);
        testing(Scramblies.scramble("scriptingjava", "javascript"), true);
        testing(Scramblies.scramble("scriptsjava", "javascripts"), true);
        testing(Scramblies.scramble("javscripts", "javascript"), false);
        testing(Scramblies.scramble("aabbcamaomsccdd", "commas"), true);
        testing(Scramblies.scramble("commas", "commas"), true);
        testing(Scramblies.scramble("sammoc", "commas"), true);
    }

}