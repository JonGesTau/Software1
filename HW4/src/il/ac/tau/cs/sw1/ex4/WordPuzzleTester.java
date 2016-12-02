package il.ac.tau.cs.sw1.ex4;

import java.util.Arrays;
import java.util.Scanner;

public class WordPuzzleTester {
//	public static void main(String[] args) {
//		String vocabularyText = "I look at the floor and I see it needs sweeping while my guitar gently wheeps";
//		Scanner vocabularyScanner = new Scanner(vocabularyText);
//		String[] vocabulary = WordPuzzle.scanVocabulary(vocabularyScanner);
//		String pattern1 = "**_*_";
//		String pattern2 = "__*__";
//
//		if (!WordPuzzle.isInVocabulary(vocabulary, "while")){
//			System.out.println("Error 1");
//		}
//		if (!WordPuzzle.checkPattern("while", pattern1)){
//			System.out.println("Error 2");
//		}
//		if (WordPuzzle.checkPattern("guiltar", pattern2)){
//			System.out.println("Error 3");
//		}
//		if (WordPuzzle.countBlanksInPattern(pattern2) != 4){
//			System.out.println("Error 4");
//		}
//		String pattern3 = "__*";
//		char[] puzzle1 = WordPuzzle.createPuzzle("the", pattern3);
//		if (!Arrays.equals(puzzle1, new char[]{'_', '_', 'e'})){
//			System.out.println("Error 5");
//		}
//		if (!WordPuzzle.hasUniqueSolution(pattern3, puzzle1, vocabulary)){
//			System.out.println("Error 6");
//		}
//		char[] puzzle2 = new char[] {'w','_', '_', 'l', 'e'};
//		int numOfChangedLetters = WordPuzzle.applyGuess('i', "while", puzzle2);
//		if (numOfChangedLetters != 1){
//			System.out.println("Error 7");
//		}
//	}

//
	public static void main(String[] args){
		String vocabularyText = "I look at the floor and I see it needs sweeping while my guitar gently wheeps";
		Scanner vocabularyScanner = new Scanner(vocabularyText);
		String[] vocabulary = WordPuzzle.scanVocabulary(vocabularyScanner);
		String pattern1 = "**_*_";
		String pattern2 = "__*__";
		if (!WordPuzzle.isInVocabulary(vocabulary, "while")){
			System.out.println("Error 1");
		}
		if (!WordPuzzle.checkPattern("while", pattern1)){
			System.out.println("Error 2");
		}
		if (WordPuzzle.checkPattern("guiltar", pattern2)){
			System.out.println("Error 3");
		}
		if (WordPuzzle.countBlanksInPattern(pattern2) != 4){
			System.out.println("Error 4");
		}
		String pattern3 = "__*";
		char[] puzzle1 = WordPuzzle.createPuzzle("the", pattern3);
		if (!Arrays.equals(puzzle1, new char[]{'_', '_', 'e'})){
			System.out.println("Error 5");
		}
		if (!WordPuzzle.hasUniqueSolution(pattern3, puzzle1, vocabulary)){
			System.out.println("Error 6");
		}
		char[] puzzle2 = new char[] {'w','_', '_', 'l', 'e'};
		int numOfChangedLetters = WordPuzzle.applyGuess('i', "while", puzzle2);
		if (numOfChangedLetters != 1){
			System.out.println("Error 7");
		}
		if (!Arrays.equals(puzzle2, new char[] {'w','_', 'i', 'l', 'e'})){
			System.out.println("Error 8");
		}
		System.out.println("done!");
	}
}
