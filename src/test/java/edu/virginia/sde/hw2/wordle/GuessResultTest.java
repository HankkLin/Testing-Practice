package edu.virginia.sde.hw2.wordle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
public class GuessResultTest {
    @Test
    public void test_all_correct_getLetterResult(){
        var test = new GuessResult("brown","brown");
        for (int i = 0; i < test.getLetterResults().length; i++){
            assertEquals(LetterResult.GREEN,test.getLetterResults()[i]);
        }
    }
    @Test
    public void test_all_yellow_getLetterResult(){
        var test = new GuessResult("brown","nwrob");
        for (int i = 0; i < test.getLetterResults().length; i++){
            assertEquals(LetterResult.YELLOW,test.getLetterResults()[i]);
        }
    }
    @Test
    public void test_all_gray_getLetterResult(){
        var test = new GuessResult("apple","smncx");
        for (int i = 0; i < test.getLetterResults().length; i++){
            assertEquals(LetterResult.GRAY,test.getLetterResults()[i]);
        }
    }
    @Test
    public void test_mix_getLetterResult(){
        var test = new GuessResult("brain","basic");
        for (int i = 0; i < test.getLetterResults().length; i++){
            LetterResult[] answer = {LetterResult.GREEN,LetterResult.GRAY,LetterResult.YELLOW,LetterResult.GREEN,LetterResult.GRAY};
            assertEquals(answer[i],test.getLetterResults()[i]);
        }
    }
    @Test
    public void test_double_yellow_getLetterResult(){
        var test = new GuessResult("apple","palap");
        for (int i = 0; i < test.getLetterResults().length; i++){
            LetterResult[] answer = {LetterResult.YELLOW,LetterResult.GREEN,LetterResult.YELLOW,LetterResult.GRAY,LetterResult.YELLOW};
            assertEquals(answer[i],test.getLetterResults()[i]);
        }
    }
    @Test void test_isCorrect(){
        var test = new GuessResult("apple","apple");
    }
    @Test void test_getGuess(){
        var test = new GuessResult("apple","apple");
        assertEquals("apple",test.getGuess());
        assertNotEquals("ascde",test.getGuess());
    }
    @Test void test_getAnswer(){
        var test = new GuessResult("apple","apple");
        assertEquals("apple",test.getAnswer());
        assertNotEquals("ascde",test.getAnswer());
    }
}
