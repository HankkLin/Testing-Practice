package edu.virginia.sde.hw2.wordle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordValidatorTest {
    private static WordValidator wordValidator;
    @BeforeAll
    public static void initialize() {
        wordValidator = new WordValidator();
    }
    @Test
    public void isValidWord_false_tooLong() {
        assertFalse(wordValidator.isValidWord("DOGGIE"));
    }
    @Test
    public void isValidWord_false_tooShort() {
        assertFalse(wordValidator.isValidWord("java"));
    }
    @Test
    public void isValidWord_true(){
        assertTrue(wordValidator.isValidWord("apple"));
    }
    @Test
    public void isValidWord_false_notEnglish(){
        assertFalse((wordValidator.isValidWord("12345")));
    }

}
