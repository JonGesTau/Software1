package il.ac.tau.cs.sw1.ex4;

import java.io.File;
import java.lang.String;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class WordPuzzle {
	public static final char BLANK_CHAR = '_';
	public static final int MAX_VOCABULARY_SIZE = 3000;
	
	public static String[] scanVocabulary(Scanner scanner){
		String words = "";
		String inputString = "";
		String[] truncArray = null;

		while (scanner.hasNextLine()) {
			inputString += scanner.nextLine() + " ";
		}

		String[] input = inputString.split(" ");

		// Remove duplicates from the string
		for (String word : input) {
			word = word.replaceAll("^[^a-zA-Z0-9\\s]+|[^a-zA-Z0-9\\s]+$", "");
			String lowerCaseWord = word.toLowerCase();
			if (!words.matches(".*\\b" + lowerCaseWord + "\\b.*")) {
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
		boolean result = false;
		for (String vocabularyWord : vocabulary) {
			if (vocabularyWord.equals(word)) {
				result = true;
				break;
			}
		}

		return result;
	}

	
	public static boolean checkPattern(String word, String pattern){
		// Test #1 - Same length
		if (pattern.length() != word.length()) {
			return false;
		}

		// Test #2 - At least one letter is hidden
		if (!pattern.contains("_")) {
			return false;
		}

		// Test #3 - Pattern contains only '*' and '_'
		if (!pattern.matches("[*_]+")) {
			return false;
		}

		// Test #4 - If a letter appears more than once, it's hidden \ shown consistently
		String[] wordArray = word.split("");
		String shown = "";
		String hidden = "";

		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			char patternChar = pattern.charAt(i);

			if (patternChar == '*') {
				if (hidden.indexOf(letter) > -1) {
					return false;
				}
				shown += letter;
			} else {
				if (shown.indexOf(letter) > -1) {
					return false;
				}
				hidden += letter;
			}
		}
		return true;
	}
	
	public static int countBlanksInPattern(String pattern){
		int counter = 0;
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) == '_') {
				counter++;
			}
		}
		return counter;
	}

	public static char[] createPuzzle(String word, String pattern){
		char[] result = new char[word.length()];

		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			char patternChar = pattern.charAt(i);
			boolean isHidden = patternChar == '_';

			if (isHidden) {
				result[i] = '_';
			} else {
				result[i] = letter;
			}
		}

		return result;
	}
	
	
	public static boolean hasUniqueSolution(String pattern, char[] puzzle, String[] vocabulary){
		String possibleMatches = "";
		int patternLength = pattern.length();
		int matchesCounter = 0;

		// If a word matches the pattern's legality, it's a possible match
		for (String word : vocabulary) {
			if (checkPattern(word, pattern)) {
				possibleMatches += word + " ";
			}
		}

		String[] possibleMatchesArray = possibleMatches.split(" ");

		if (possibleMatchesArray.length == 1) {
			// If there's only one possible match, it's the unique match.
			return true;
		} else {
			// Otherwise, iterate all possible matches and compare every known letter.
			for (String match : possibleMatchesArray) {
				int mismatchCounter = 0;
				for (int i = 0; i < puzzle.length; i++) {
					char piece = puzzle[i];
					if (piece != '_' && piece != match.charAt(i)) {
						mismatchCounter++;
					}
				}

				// If there's no mismatches after comparing a word, increase matchesCounter.
				if (mismatchCounter == 0) {
					matchesCounter++;
				}
			}

			// If there's only one match by comparing letters, it's the unique match.
			if (matchesCounter == 1) {
				return true;
			}
		}

		return false; 
	}
	
	public static int applyGuess(char guess, String word, char[] puzzle){
		int matches = 0;

		for (int i = 0; i < word.length(); i++) {
			if (puzzle[i] == '_' && word.charAt(i) == guess) {
				puzzle[i] = guess;
				matches++;
			}
		}

		return matches;
	}

	public static void main(String[] args) throws Exception{
		String vocabularyText = "";
		System.out.println("Please provide a file name (e.g src/resources/hw4/vocabulary.txt):");

		Scanner scanner = new Scanner(System.in);
		String FILE_NAME = scanner.nextLine();

		// Check for invalid file here

		Scanner vocabularyScanner = new Scanner(new File(FILE_NAME));
		String[] vocabulary = WordPuzzle.scanVocabulary(vocabularyScanner);
		printReadVocabulary(FILE_NAME, vocabulary.length);
		vocabularyScanner.close();

		printSettingsMessage();
		enterWord(vocabulary, scanner);


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

//	public static String getUserInput(String scannerName) {
//		Scanner scannerName = new Scanner(System.in);
//		return scannerName.nextLine();
//	}

	public static void enterWord(String[] vocabulary, Scanner scanner) {
		printEnterWordMessage();

		String word = scanner.nextLine();

		if (WordPuzzle.isInVocabulary(vocabulary, word)) {
			enterPattern(vocabulary, scanner, word);
		} else {
			printIllegalWordMessage();
			enterWord(vocabulary, scanner);
		}
	}

	public static void enterPattern(String[] vocabulary, Scanner scanner, String word) {
		printEnterYourPattern();
		String pattern = scanner.nextLine();
		char[] puzzle = createPuzzle(word, pattern);

		if (checkPattern(word, pattern) && hasUniqueSolution(pattern, puzzle, vocabulary)) {
			startGame(vocabulary, scanner, word, pattern, puzzle);
		} else {
			printIllegalPatternMessage();
			enterPattern(vocabulary, scanner, word);
		}
	}

	public static void startGame(String[] vocabulary, Scanner scanner, String word, String pattern,char[] puzzle) {
		int ADD_TO_ATTEMPTS = 3;
		int startBlanksCount = countBlanksInPattern(pattern);
		int remainigBlanksToSolve = startBlanksCount;
		int remainingAttempts = startBlanksCount + ADD_TO_ATTEMPTS;

		printGameStageMessage();

		while (remainigBlanksToSolve > 0 && remainingAttempts > 0) {
			printPuzzle(puzzle);

			printEnterYourGuessMessage();
			String guess = scanner.nextLine();
			int flippedBlanks = applyGuess(guess.charAt(0), word, puzzle);

			if (flippedBlanks > 0) {
				remainigBlanksToSolve -= flippedBlanks;
				remainingAttempts--;
				printCorrectGuess(remainingAttempts);
			} else {
				remainingAttempts--;
				printWrongGuess(remainingAttempts);
			}
		}

		if (remainigBlanksToSolve == 0) {
			printWinMessage();
		} else {
			printGameOver();
		}

		return;
	}
}
