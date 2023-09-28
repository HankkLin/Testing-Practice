package edu.virginia.sde.hw2.wordle;

import static edu.virginia.sde.hw2.wordle.LetterResult.*;

/**
 * This class handles getting the result from a guess in a Wordle Game. This class is used by
 * {@link Game#submitGuess(String)}.
 */
public class GuessResult {
    private final String guess;
    private final String answer;

    /**
     * Constructor for GuessResult
     * @param guess - the Wordle player's guessed word
     * @param answer - the word the player is trying to guess
     * @throws IllegalArgumentException if either word is not 5-characters long.
     */
    public GuessResult(String guess, String answer) {
        validateWordLengths(guess, answer);
        this.guess = guess;
        this.answer = answer;
    }

    private static void validateWordLengths(String guess, String answer) {
        if (guess.length() != WordValidator.WORDLE_WORD_LENGTH || answer.length() != WordValidator.WORDLE_WORD_LENGTH) {
            throw new IllegalArgumentException(String.format("""
                            Invalid GuessResult initialization:
                                guess: %s
                                answer: %s
                            Words must be %d letters long.""",
                    guess, answer, WordValidator.WORDLE_WORD_LENGTH));
        }
    }

    /**
     * Returns the guess submitted by the player.
     */
    public String getGuess() {
        return guess;
    }

    /**
     * Returns the answer the player is trying to guess.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Returns true if the player's guess matches the answer (case-insensitive)
     */
    public boolean isCorrect() {
        LetterResult[] results = this.getLetterResults();
        for (int i = 0; i < results.length; i++){
            if (!(results[i].equals(GREEN))){
                System.out.println(i);
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the {@link LetterResult} array of GREEN, YELLOW, and GRAY based on how well the player's guess. This
     * function is case-insensitive.
     */
    public LetterResult[] getLetterResults() {
        LetterResult[] results = new LetterResult[5];
        boolean[] x = {false, false, false, false, false};
        for (int i = 0; i < 5; i++) {
            if (answer.charAt(i) == guess.charAt(i)) {
                results[i] = GREEN;
                x[i] = true;
            }
            else if (answer.indexOf(guess.charAt(i))==-1){
                results[i] = GRAY;
            }
        }
        for (int i =0; i <5; i++){
            if(results[i]==null){
                for(int j=0;j<5;j++){
                    if(answer.charAt(j)==guess.charAt(i)&& !(x[j])){
                        x[j] = true;
                        results[i] = YELLOW;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            if (results[i] == null) {
                results[i] = GRAY;
            }
        }
        return results;
    }


}
