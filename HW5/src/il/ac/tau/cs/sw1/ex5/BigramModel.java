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
		int vocabularySize = 0;
		while ((line = bufferedReader.readLine()) != null && vocabularySize < MAX_VOCABULARY_SIZE) {
			fileText += line + " ";
			String[] words = line.split(" ");
			for (String word : words) {
				String vocabularyWord = getValidWord(word);
				if (vocabularyWord != "") {
					if (getStringIndex(vocabularyString.split(" "), vocabularyWord) == NOT_FOUND || vocabularyString == "") {
						vocabularyString += vocabularyWord + " ";
						vocabularySize++;
					}
				}
			}
		}

		vocabulary = vocabularyString.split(" ");

		bufferedReader.close();

		bigramCounts = new int[vocabulary.length][vocabulary.length];

		String[] textLines = fileText.split(" ");

		for (int k = 0; k < textLines.length - 1; k++) {
			String firstWord = textLines[k].toLowerCase();
			String secondWord = textLines[k+1].toLowerCase();

			if (getWordIndex(firstWord) != NOT_FOUND && getWordIndex(secondWord) != NOT_FOUND) {
				bigramCounts[getWordIndex(firstWord)][getWordIndex(secondWord)]++;
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
		String result = "";
		int max = 0;

		for (int i = 0; i < bigramCounts[getWordIndex(word)].length; i++) {
			int occurences = bigramCounts[getWordIndex(word)][i];
			if (occurences > max) {
				max = occurences;
				result = vocabulary[i];
			}
		}

		if (max == 0) {
			result = null;
		}

		return result;
	}
	
	/* @pre: n > 1, word is in lowercase
	 * @pre: the language model is initialized
	 * @post: if word is in the vocabulary, $ret is a sentence of at most n words, starting with word.
	 * otherwise, $ret = ""
	 */
	public String buildSentence(String word, int n){
		String result;
		if (getWordIndex(word) == NOT_FOUND) {
			return "";
		} else {
			result = word;
			int counter = 0;
			while (counter < n - 1) {
				String[] sentenceArray = result.split(" ");
				String lastWord = sentenceArray[sentenceArray.length - 1];
				if (getMostFrequentProceeding(lastWord) == null) {
					counter = n;
				} else {
					result += " " + getMostFrequentProceeding(lastWord);
					counter++;
				}
			}
		}

		return result;
	}
	
	
	/*
	 * @pre: word is in vocabulary
	 * @pre: the language model is initialized
	 * @post: $ret = w implies that w is the word with the largest cosineSimilarity(vector for word, vector for w) among all the
	 * other words in vocabulary
	 */
	public String getClosestWord(String word){
		int[] wordVector = bigramCounts[getWordIndex(word)];
		double max = 0;
		String result = "";

		for (String vocabularyWord : vocabulary) {
			if (!vocabularyWord.equals(word)) {
				int[] vocabuaryWordVector = bigramCounts[getWordIndex(vocabularyWord)];
				double cosineSim = calcCosineSim(wordVector, vocabuaryWordVector);
				if (cosineSim > max) {
					max = cosineSim;
					result = vocabularyWord;
				}
			}
		}
		return result;
	}
	
	/*
	 * @pre: arr1.length = arr2.legnth
	 * post if arr1 or arr2 are only filled with zeros, $ret = 0, otherwise
	 */
	public static double calcCosineSim(int[] arr1, int[] arr2){
		if (isAllArrayZeros(arr1) || isAllArrayZeros(arr2)) {
			return 0;
		} else {
			double numerator = 0;
			double denominator = calcVectorSize(arr1) * calcVectorSize(arr2);

			for (int i = 0; i < arr1.length; i++) {
				numerator += arr1[i] * arr2[i];
			}

			return numerator / denominator;
		}
	}

	public static String getValidWord(String word) {
		String result = "";
		if (!word.matches(".*[a-zA-Z]+.*")) {
			return result;
		}

		if (word.matches("[0-9]+")) {
			result = SOME_NUM;
		} else {
			result = word.toLowerCase();
		}

		return result;
	}

	public static boolean isAllArrayZeros(int[] array) {
		for (int item : array) {
			if (item != 0) {
				return false;
			}
		}

		return true;
	}

	public static double calcVectorSize(int[] vector) {
		double sqauresSum = 0;
		for (int cordinate : vector) {
			sqauresSum += Math.pow(cordinate, 2);
		}

		return Math.sqrt(sqauresSum);
	}

	public int getStringIndex(String[] array, String word){
		if (array.length > 0) {
			for (int i = 0; i < array.length; i++) {
				if (word.equals(array[i])) {
					return i;
				}
			}
		}

		return NOT_FOUND;
	}

}
