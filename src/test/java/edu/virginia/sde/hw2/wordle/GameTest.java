package edu.virginia.sde.hw2.wordle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static edu.virginia.sde.hw2.wordle.GameStatus.*;
import static edu.virginia.sde.hw2.wordle.LetterResult.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private static Dictionary defaultGuessesDictionary, defaultAnswersDictionary;
    @BeforeAll
    public static void initialize() {
        defaultGuessesDictionary = DefaultDictionaries.getGuessesDictionary();
        defaultAnswersDictionary = DefaultDictionaries.getAnswersDictionary();
    }
    @Test
    public void test_init_zeroArgumentConstructor() {
        var game = new Game();
        assertEquals(defaultGuessesDictionary, game.getGuessDictionary());
        assertTrue(defaultAnswersDictionary.contains(game.getAnswer()));
        assertEquals(6, game.getGuessesRemaining());
        assertEquals(PLAYING, game.getGameStatus());
    }
    @Test
    public void test_init_4ArgumentConstructor() {
        var game = new Game(defaultGuessesDictionary, "TREND", 6, PLAYING);

        assertEquals(defaultGuessesDictionary, game.getGuessDictionary());
        assertEquals("TREND", game.getAnswer());
        assertEquals(6, game.getGuessesRemaining());
        assertEquals(PLAYING, game.getGameStatus());
    }
    @Test
    public void test_isGameOver_WIN_True() {
        var game = new Game(defaultGuessesDictionary, "TREND", 5, WIN);
        assertEquals(WIN, game.getGameStatus());
        assertTrue(game.isGameOver());
    }
    @Test
    public void submitGuess_guessremaining_test() {
        var game = new Game(defaultGuessesDictionary, "TREND", 5, WIN);
        try {game.submitGuess("ghost");}
        catch (Exception e){}
        assertEquals(4,game.getGuessesRemaining());
        try {game.submitGuess("sssss");}
        catch (Exception e){}
        assertEquals(4,game.getGuessesRemaining());
        try {game.submitGuess("TREND");}
        catch (Exception e){}
        assertEquals(3,game.getGuessesRemaining());
    }
    @Test
    public void submitGuess_gameStatus_win_test() {
        var game = new Game(defaultGuessesDictionary, "TREND", 3, WIN);
        try {game.submitGuess("TREND");}
        catch (Exception e){}
        assertEquals(WIN,game.getGameStatus());
    }
    public void submitGuess_gameStatus_lose_test() {
        var game = new Game(defaultGuessesDictionary, "TREND", 1, WIN);
        try {game.submitGuess("GHOST");}
        catch (Exception e){}
        assertEquals(LOSS,game.getGameStatus());
    }
    public void submitGuess_gameStatus_playing_test() {
        var game = new Game(defaultGuessesDictionary, "TREND", 3, WIN);
        try {game.submitGuess("GHOST");}
        catch (Exception e){}
        assertEquals(PLAYING,game.getGameStatus());
    }
}