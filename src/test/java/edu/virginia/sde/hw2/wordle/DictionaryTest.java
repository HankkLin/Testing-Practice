package edu.virginia.sde.hw2.wordle;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    @Test
    void getWordSet() {
        var startingWordSet = new HashSet<>(Set.of("apple", "black", "camel"));
        var dictionary = new Dictionary(startingWordSet, new WordValidator());

        var wordSet = dictionary.getWordSet();
        assertEquals(3, wordSet.size());
        assertTrue(wordSet.contains("apple"));
        assertTrue(wordSet.contains("black"));
        assertTrue(wordSet.contains("camel"));
    }

    @Test
    void getWordSet_initiallyEmpty() {
        var dictionary = new Dictionary();

        var wordSet = dictionary.getWordSet();
        assertTrue(wordSet.isEmpty());
    }
    @Test
    public void check_contains_true(){
        var startingWordSet = new HashSet<>(Set.of("apple", "black", "camel"));
        var dictionary = new Dictionary(startingWordSet, new WordValidator());
        assertTrue(dictionary.contains("apple"));
        assertTrue(dictionary.contains("black"));
        assertTrue(dictionary.contains("camel"));
    }
    @Test
    public void check_contains_false(){
        var startingWordSet = new HashSet<>(Set.of("apple", "black", "camel"));
        var dictionary = new Dictionary(startingWordSet, new WordValidator());
        assertFalse(dictionary.contains("hohoh"));
        assertFalse(dictionary.contains("13423"));
        assertFalse(dictionary.contains("fhbj"));
    }

    @Test
    public void check_size_equal(){
        var startingWordSet = new HashSet<>(Set.of("apple", "black", "camel","dhddd"));
        var dictionary = new Dictionary(startingWordSet, new WordValidator());
        assertEquals(4,dictionary.size());
    }
    @Test
    public void check_size_not_equal(){
        var startingWordSet = new HashSet<>(Set.of("apple", "black", "camel","dhddd"));
        var dictionary = new Dictionary(startingWordSet, new WordValidator());
        assertNotEquals(3,dictionary.size());
    }
}