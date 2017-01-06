package il.ac.tau.cs.sw1.ex8.wordsRank;

import il.ac.tau.cs.sw1.ex8.histogram.HashMapHistogram;
import il.ac.tau.cs.sw1.ex8.histogram.HashMapHistogramIterator;

import java.io.File;
import java.io.IOException;
import java.util.*;


/**************************************
 *  Add your code to this class !!!   *
 **************************************/

public class FileIndex {
	
	public static final int UNRANKED_CONST = 20;
	private List<String> allTokens = new ArrayList<>();
	private HashMap<String, HashMapHistogram> filesIndex = new HashMap<>();

	/*
	 * @pre: the directory is no empty, and contains only readable text files
	 */
  	public void indexDirectory(String folderPath) {
		//This code iterates over all the files in the folder. add your code wherever is needed

		File folder = new File(folderPath);
		File[] listFiles = folder.listFiles();
		for (File file : listFiles) {
			// for every file in the folder
			if (file.isFile()) {
				filesIndex.put(file.getName(), new HashMapHistogram());
				List<String> tokens = null;
				try {
					tokens = FileUtils.readAllTokens(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				for (String token : tokens) {
					filesIndex.get(file.getName()).addItem(token);
					allTokens.add(token);
				}
			}
		}
	}
	
  	/*
	 * @pre: the index is initialized
	 */
	public int getCountInFile(String filename, String word) throws FileIndexException{
		word = word.toLowerCase();
		if (!filesIndex.containsKey(filename)) {
			throw new FileIndexException("This file does no exist");
		}

		return filesIndex.get(filename).getCountForItem(word);
	}
	
	/*
	 * @pre: the index is initialized
	 */
	public int getRankForWordInFile(String filename, String word) throws FileIndexException{
		word = word.toLowerCase();
		if (!filesIndex.containsKey(filename)) {
			throw new FileIndexException("This file does no exist");
		}

		Iterator<String> iterator = filesIndex.get(filename).iterator();

		int rank = 0;
		for (Iterator<String> it = iterator; it.hasNext(); ) {
			String wordInIterator = it.next();
			rank++;
			if (wordInIterator.equals(word)) {
				return rank;
			}
		}

		return rank + UNRANKED_CONST; //replace this with the actual returned value

	}
	
	/*
	 * @pre: the index is initialized
	 */
	public int getAverageRankForWord(String word){
		HashMap<String, Integer> ranks = new HashMap<>();
		for (String file : filesIndex.keySet()) {
			try {
				ranks.put(file, getRankForWordInFile(file, word));
			} catch (FileIndexException e) {
				e.printStackTrace();
			}
		}

		RankedWord rankedWord = new RankedWord(word, ranks);
		return rankedWord.getRankByType(RankedWord.rankType.average);
	}
	
	
	
	public List<String> getWordsBelowAverageRank(int k){
		List<RankedWord> wordsList = new ArrayList<>();
		List<String> result = new ArrayList<>();
		for (String token : allTokens) {
			wordsList.add(getRankedWord(token));
		}

		Collections.sort(wordsList, new RankedWordComparator(RankedWord.rankType.average));
		for (RankedWord word : wordsList) {
			if (word.getRankByType(RankedWord.rankType.average) <= k) {
				if (!result.contains(word.getWord())) {
					result.add(word.getWord());
				}
			}
		}
		return result;
	}
	
	public List<String> getWordsBeloweMinRank(int k){
		List<RankedWord> wordsList = new ArrayList<>();
		List<String> result = new ArrayList<>();
		for (String token : allTokens) {
			wordsList.add(getRankedWord(token));
		}

		Collections.sort(wordsList, new RankedWordComparator(RankedWord.rankType.min));
		for (RankedWord word : wordsList) {
			if (word.getRankByType(RankedWord.rankType.min) <= k) {
				if (!result.contains(word.getWord())) {
					result.add(word.getWord());
				}
			}
		}
		return result;
	}
	
	public List<String> getWordsBelowMaxRank(int k){
		List<RankedWord> wordsList = new ArrayList<>();
		List<String> result = new ArrayList<>();
		for (String token : allTokens) {
			wordsList.add(getRankedWord(token));
		}

		Collections.sort(wordsList, new RankedWordComparator(RankedWord.rankType.max));
		for (RankedWord word : wordsList) {
			if (word.getRankByType(RankedWord.rankType.max) <= k) {
				if (!result.contains(word.getWord())) {
					result.add(word.getWord());
				}
			}
		}
		return result;
	}

	public RankedWord getRankedWord(String word) {
		HashMap<String, Integer> ranks = new HashMap<>();
		for (String file : filesIndex.keySet()) {
			try {
				ranks.put(file, getRankForWordInFile(file, word));
			} catch (FileIndexException e) {
				e.printStackTrace();
			}
		}

		return new RankedWord(word, ranks);
	}
}
