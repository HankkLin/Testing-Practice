# Reflection Questions

Answer these questions thoroughly after completing the assignment, using examples from your code. Good answers will be 1-2 paragraphs that cite specific code examples and show a meaningful reflection on how your development went, and how it could be improved in the future.

## Question 1

 In the Black-Box testing for GameState.submitGuess() portion of the assignment, list the partitions of inputs and fields that you used for your test plan. Cite specific tests by name and line number that cover each partition. A bulleted list is acceptable here. You should include all of your tests covering at least one partition. Additionally, for each partition, label it is equivalence, boundary, or exception.

## Answer

I start with the three basic function, which is all_green, all_yellow, or all_gray. (line 15, 22, 29). These three functions are the most basic case for all result for all the letters. I consider them at three different partitions becuase each is being handle by different part of the code. I later include a test code mix, which is the example on the docs just to confirm everything is working. I later include another two different cases:
```java
    public void test_double_yellow_getLetterResult()
    public void test_overGuess_getLetterResult()
```
These two are boundary case, the first one have "apple" as the answer and the user guess "palap". There are two 'p' in the answer, so for the result, both 'p' should be label as YELLOW. And for char 'a', it only appear in the answer once, so the first 'a' should be label as YELLOW but the second one should be label as GRAY. This is a special case that although the letter exist but the because the user guess the same letter more than once so the second same letter will be GRAY instead of YELLOW.
For the second case, the user guess 'a' for four times but only one 'a' appear in the answer, so it should only have the first 'a' being YELLOW, the rest should be GREEN. 


## Question 2

The function submitGuess(String) in WordleGameState can throw two different Exceptions. Why would we as developers intentionally design our program to throw Exceptions? What is the benefit?

## Answer

The exceptions is a good way for developers to confirm the error or the bug that cause the code to not work. Just like assert, the exception can include details about the error, such as the type of error, the location where it occurred, and potentially additional context.
Beside that it is a seperate flow of the program. It allows developers to separate the code that detects and handles errors from the normal flow of the program. This separation can lead to cleaner and more readable code. 
