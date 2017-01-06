package il.ac.tau.cs.sw1.ex8.wordsRank;

import java.io.File;
import java.util.List;



/**************************************
 *  Add your code to this class !!!   *
 **************************************/

public class FileIndex {
	
	public static final int UNRANKED_CONST = 20;
	
	

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
				/*******************/
				//your code goes here!
				/*******************/
			}
		}
		/*******************/
		//your code goes here!
		/*******************/
	}
	
  	/*
	 * @pre: the index is initialized
	 */
	public int getCountInFile(String filename, String word) throws FileIndexException{
		//your code goes here!
		return 0; //replace this with the actual returned value
	}
	
	/*
	 * @pre: the index is initialized
	 */
	public int getRankForWordInFile(String filename, String word) throws FileIndexException{
		//your code goes here!
		return 0; //replace this with the actual returned value

	}
	
	/*
	 * @pre: the index is initialized
	 */
	public int getAverageRankForWord(String word){
		//your code goes here!
		return 0; //replace this with the actual returned value
	}
	
	
	
	public List<String> getWordsBelowAverageRank(int k){
		//your code goes here!
		return null; //replace this with the actual returned value
	}
	
	public List<String> getWordsBeloweMinRank(int k){
		//your code goes here!
		return null; //replace this with the actual returned value
	}
	
	public List<String> getWordsBelowMaxRank(int k){
		//your code goes here!
		return null; //replace this with the actual returned value
	}

}
