package com.utknl.katas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DidYouMeanTest {

    @Test
    public void testBerries() {
        var dictionary = new DidYouMean(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
//        assertEquals("strawberry", dictionary.findMostSimilar("strawbery"));
        assertEquals("cherry", dictionary.findMostSimilar("berry"));
    }

    @Test
    public void testLanguages() {
        var dictionary = new DidYouMean(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
        assertEquals("java", dictionary.findMostSimilar("heaven"));
        assertEquals("javascript", dictionary.findMostSimilar("javascript"));
    }

    @Test
    public void name() {
        var dictionary = new DidYouMean(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
        dictionary.findMostSimilar("strawbery");

    }
}