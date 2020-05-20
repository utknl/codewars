package com.utknl.katas;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/5259510fc76e59579e0009d4/train/java
 * <p>
 * I'm sure, you know Google's "Did you mean ...?", when you entered a search term and mistyped a word.
 * In this kata we want to implement something similar.
 * <p>
 * You'll get an entered term (lowercase string) and an array of known words (also lowercase strings).
 * Your task is to find out, which word from the dictionary is most similar to the entered one.
 * The similarity is described by the minimum number of letters you have to add, remove or replace in order to get
 * from the entered word to one of the dictionary. The lower the number of required changes,
 * the higher the similarity between each two words.
 * <p>
 * Same words are obviously the most similar ones. A word that needs one letter to be changed is more similar
 * to another word that needs 2 (or more) letters to be changed. E.g. the mistyped term berr is more similar to beer
 * (1 letter to be replaced) than to barrel (3 letters to be changed in total).
 * <p>
 * Extend the dictionary in a way, that it is able to return you the most similar word from the list of known words.
 * <p>
 * Dictionary fruits = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
 * <p>
 * fruits.findMostSimilar("strawbery"); // must return "strawberry"
 * fruits.findMostSimilar("berry"); // must return "cherry"
 * <p>
 * Dictionary things = new Dictionary(new String[]{"stars", "mars", "wars", "codec", "codewars"});
 * things.findMostSimilar("coddwars"); // must return "codewars"
 * <p>
 * Dictionary languages = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
 * languages.findMostSimilar("heaven"); // must return "java"
 * languages.findMostSimilar("javascript"); // must return "javascript" (same words are obviously the most similar ones)
 * <p>
 * I know, many of you would disagree that java is more similar to heaven than all the other ones, but in this kata it is ;)
 * <p>
 * Additional notes:
 * <p>
 * there is always exactly one possible correct solution
 */

public class DidYouMean {

    private final String[] words;

    public DidYouMean(String[] words) {
        this.words = words;
    }

    public String findMostSimilar(String to) {

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            List<String> collect = Arrays.stream(word.split("")).collect(Collectors.toList());
            List<String> wordList = Arrays.stream(to.split("")).collect(Collectors.toList());
            int count = 0;
            for (String s : wordList) {
                if (collect.contains(s)) {
                    count++;
                }
            }
            map.put(word, count);
        }
        System.out.println(map);
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null).getKey();


    }

}
