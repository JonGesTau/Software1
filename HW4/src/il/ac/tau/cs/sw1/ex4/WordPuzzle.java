package il.ac.tau.cs.sw1.ex4;

import java.io.File;
import java.lang.String;
import java.util.Arrays;
import java.util.Scanner;

public class WordPuzzle {
	public static final char BLANK_CHAR = '_';
	public static final int MAX_VOCABULARY_SIZE = 3000;
	
	public static String[] scanVocabulary(Scanner scanner){
		String words = "";
		String[] truncArray = null;
		String[] input = scanner.nextLine().split(" ");

		// Remove duplicates from the string
		for (String word : input) {
			String lowerCaseWord = word.toLowerCase();
			if (words.indexOf(lowerCaseWord) == -1) {
				words += lowerCaseWord + " ";
			}
		}

		// Create array of words
		String[] wordsNoDuplicates = words.split(" ");

		// If there's more than MAX_VOCABUARY_SIZE words, create a new truncated array
		if (wordsNoDuplicates.length > MAX_VOCABULARY_SIZE) {
			truncArray = Arrays.copyOfRange(wordsNoDuplicates, 0, MAX_VOCABULARY_SIZE);
		}

		String[] result = truncArray == null ? wordsNoDuplicates : truncArray;
		Arrays.sort(result);

		return result;
	}
	
	public static boolean isInVocabulary(String[] vocabulary, String word){
		// replace with your code
		return false; 
	}

	
	public static boolean checkPattern(String word, String pattern){
		// replace with your code
		return false; 
	}
	
	public static int countBlanksInPattern(String pattern){
		// replace with your code
		return 0; 
	}

	public static char[] createPuzzle(String word, String pattern){
		// replace with your code
		return null; 
	}
	
	
	public static boolean hasUniqueSolution(String pattern, char[] puzzle, String[] vocabulary){
		// replace with your code
		return false; 
	}
	
	public static int applyGuess(char guess, String word, char[] puzzle){
		// replace with your code
		return guess; 
	}

	public static void main(String[] args) throws Exception{
		// add with your code here
	}


	
	/*****************************************************************************************************/
	/********************** helper functions *************************************************************/
	/*****************************************************************************************************/
	
	public static void printReadVocabulary(String vocabularyFileName, int numOfWords){
		System.out.println("Read " + numOfWords + " words from " + vocabularyFileName);
	}

	public static void printSettingsMessage(){
		System.out.println("--- Settings stage ---");
	}
	
	public static void printEnterWordMessage(){
		System.out.println("Enter your word:");
	}
	
	public static void printIllegalWordMessage(){
		System.out.println("Illegal word!");
	}
	
	public static void printEnterYourPattern(){
		System.out.println("Enter your pattern:");
	}
	
	public static void printIllegalPatternMessage(){
		System.out.println("Illegal pattern!");
	}

	public static void printGameStageMessage(){
		System.out.println("--- Game stage ---");
	}
	
	public static void printPuzzle(char[] puzzle){
		System.out.println(puzzle);
	}
	
	public static void printEnterYourGuessMessage(){
		System.out.println("Enter your guess:");
	}
	
	public static void printCorrectGuess(int attemptsNum){
		System.out.println("Correct Guess, " + attemptsNum + " guesses left");
	}
	
	public static void printWrongGuess(int attemptsNum){
		System.out.println("Wrong Guess, " + attemptsNum + " guesses left");
	}

	public static void printWinMessage(){
		System.out.println("Congratulations! You solved the puzzle");
	}
	
	public static void printGameOver(){
		System.out.println("Game over!");
	}

}
