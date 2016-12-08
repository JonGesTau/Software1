package il.ac.tau.cs.sw1.ex5;

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.*;

public class BigramModel {
	// constants 
	public static final int MAX_VOCABULARY_SIZE = 15000;
	public static final String SOME_NUM = "some_num";
	public static final int NOT_FOUND = -1;
	
	// class members
	private String[] vocabulary;
	private int[][] bigramCounts;

	public int buildModelFromFile(String fileName) throws IOException{
		File fromFile = new File(fileName);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile));
		String vocabularyString = "";
		int numWordsInVocabulary = 0;
		String fileText = "";

		String line;
		int counter = 0;
		while ((line = bufferedReader.readLine()) != null && counter < MAX_VOCABULARY_SIZE) {
			fileText += line + " ";
			String[] words = line.split(" ");
			for (String word : words) {
				String vocabularyWord = getValidWord(word);
				if (vocabularyWord != "") {
					// Remove parentheses and punctuation marks.
					vocabularyWord = vocabularyWord.replaceAll("\\p{P}","");
					if (!vocabularyString.matches(".*\\b" + vocabularyWord + "\\b.*")) {
						vocabularyString += vocabularyWord + " ";
					}
				}
			}
			counter++;
		}

		vocabulary = vocabularyString.split(" ");

		bufferedReader.close();

		bigramCounts = new int[vocabulary.length][vocabulary.length];

		String[] textLines = fileText.split(" ");

		for (int i = 0; i < vocabulary.length; i++) {
			String word1 = vocabulary[i].replaceAll("\\p{P}","");

			for (int j = 0; j < vocabulary.length; j++) {
				String word2 = vocabulary[j].replaceAll("\\p{P}","");

				for (int k = 0; k < textLines.length - 1; k++) {
					String firstWord = textLines[k].replaceAll("\\p{P}","").toLowerCase();
					String secondWord = textLines[k+1].replaceAll("\\p{P}","").toLowerCase();

					if (firstWord.equals(word1) && secondWord.equals(word2)) {
						bigramCounts[i][j]++;
					}
				}
			}
		}

		return vocabulary.length;
	}

	/*
	 * @pre: the language model is initialized
	 * @pre: fileName is a valid path
	 */
	public boolean saveModelToFile(String fileName) throws IOException{
		if (vocabulary == null || bigramCounts == null) {
			return false;
		}

		File toFile = new File(fileName);
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile));

		bufferedWriter.write(vocabulary.length + " words\r\n");
		for (int i = 0; i < vocabulary.length; i++) {
			String word1 = vocabulary[i];

			for (int j = 0; j < bigramCounts[i].length; j++) {
				String word2 = vocabulary[j];
				int coupleCount = bigramCounts[i][j];

				if (coupleCount > 0) {
					bufferedWriter.write(word1 + ", " + word2 + ": " + coupleCount + '\n');
				}
			}
		}
		bufferedWriter.close();
	    return true;
	}
	
	/*
	 * @pre: fileName is a valid path that contains a model with a legal format
	 */
	public int loadModelFromFile(String fileName) throws IOException{
		vocabulary = null;
		bigramCounts = null;

		File fromFile = new File(fileName);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile));

		String line;
		String vocabularyString = "";
		int counter = 0;
		int vocabularySize = 0;

		while ((line = bufferedReader.readLine()) != null) {
			if (vocabularySize == 0) {
				vocabularySize = Integer.parseInt(line.split(" ")[0]);
				vocabulary = new String[vocabularySize];
				bigramCounts = new int[vocabularySize][vocabularySize];
			} else {
				String word1 = line.split(", ")[0];
				String word2 = line.split(", ")[1].split(": ")[0];
				int coupleCount = Integer.parseInt(line.split(", ")[1].split(": ")[1]);

				if (getWordIndex(word1) == NOT_FOUND) {
					vocabulary[counter] = word1;
					counter++;
				}

				if (getWordIndex(word2) == NOT_FOUND) {
					vocabulary[counter] = word2;
					counter++;
				}

				bigramCounts[getWordIndex(word1)][getWordIndex(word2)] = coupleCount;
			}
		}
		return vocabulary.length;
	}
	
	/*
	 * @pre: word is in lowercase
	 * @pre: the language model is initialized
	 * @post: $ret = -1 if word is not in vocabulary, otherwise $ret = the index of word in vocabulary
	 */
	public int getWordIndex(String word){
		if (vocabulary.length > 0) {
			for (int i = 0; i < vocabulary.length; i++) {
				if (word.equals(vocabulary[i])) {
					return i;
				}
			}
		}

		return NOT_FOUND;
	}
	
	/*
	 * @pre: word1, word2 are in lowercase
	 * @pre: the language model is initialized
	 * @post: $ret = the count for the bigram <word1, word2>. if one of the words does not
	 * exist in the vocabulary, $ret = 0
	 */
	public int getBigramCount(String word1, String word2){
		if (getWordIndex(word1) == NOT_FOUND || getWordIndex(word2) == NOT_FOUND) {
			return 0;
		} else {
			return bigramCounts[getWordIndex(word1)][getWordIndex(word2)];
		}
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
