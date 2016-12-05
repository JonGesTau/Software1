package il.ac.tau.cs.sw1.ex5;

import java.io.*;

public class BigramModel {
	// constants 
	public static final int MAX_VOCABULARY_SIZE = 15000;
	public static final String SOME_NUM = "some_num";
	
	// class members
	private String[] vocabulary;
	private int[][] bigramCounts;

	public int buildModelFromFile(String fileName) throws IOException{
		File fromFile = new File(fileName);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile));
		String vocabularyString = "";

		String line;
		int counter = 0;
		while ((line = bufferedReader.readLine()) != null && counter < MAX_VOCABULARY_SIZE) {
			String[] words = line.split(" ");
			for (String word : words) {
				String vocabularyWord = getValidWord(word);
				if (vocabularyWord != "" && !vocabularyString.matches(".*\\b" + vocabularyWord + "\\b.*")) {
					vocabularyString += vocabularyWord + " ";
				}
			}
			counter++;
		}

		vocabulary = vocabularyString.split(" ");

		return vocabulary.length;
	}

	/*
	 * @pre: the language model is initialized
	 * @pre: fileName is a valid path
	 */
	public boolean saveModelToFile(String fileName) throws IOException{
		// replace with your code
	    return false;
	}
	
	/*
	 * @pre: fileName is a valid path that contains a model with a legal format
	 */
	public int loadModelFromFile(String fileName) throws IOException{
		// replace with your code
		return 0;
	}
	
	/*
	 * @pre: word is in lowercase
	 * @pre: the language model is initialized
	 * @post: $ret = -1 if word is not in vocabulary, otherwise $ret = the index of word in vocabulary
	 */
	public int getWordIndex(String word){
		// replace with your code
		return 0;
	}
	
	/*
	 * @pre: word1, word2 are in lowercase
	 * @pre: the language model is initialized
	 * @post: $ret = the count for the bigram <word1, word2>. if one of the words does not
	 * exist in the vocabulary, $ret = 0
	 */
	public int getBigramCount(String word1, String word2){
		// replace with your code
		return 0;
	}
	
	/*
	 * @pre word is in vocabulary
	 * @pre: the language model is initialized
	 * @post $ret = the word with the lowest vocabulary index that appears most fequently after word (if a bigram starting with
	 * word was never seen, $ret will be null
	 */
	public String getMostFrequentProceeding(String word){
		// replace with your code
		return null;
	}
	
	/* @pre: n > 1, word is in lowercase
	 * @pre: the language model is initialized
	 * @post: if word is in the vocabulary, $ret is a sentence of at most n words, starting with word.
	 * otherwise, $ret = ""
	 */
	public String buildSentence(String word, int n){
		// replace with your code
		return null;
	}
	
	
	/*
	 * @pre: word is in vocabulary
	 * @pre: the language model is initialized
	 * @post: $ret = w implies that w is the word with the largest cosineSimilarity(vector for word, vector for w) among all the
	 * other words in vocabulary
	 */
	public String getClosestWord(String word){
		// replace with your code
		return null;
	}
	
	/*
	 * @pre: arr1.length = arr2.legnth
	 * post if arr1 or arr2 are only filled with zeros, $ret = 0, otherwise
	 */
	public static double calcCosineSim(int[] arr1, int[] arr2){
		// replace with your code
		return 0;
	}

	public static String getValidWord(String word) {
		String result = "";
		if (!word.matches(".*[a-z].*")) {
			return result;
		}

		if (word.matches("[0-9]+")) {
			result = SOME_NUM;
		} else {
			result = word.toLowerCase();
		}

		return result;
	}
}
