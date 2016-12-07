package il.ac.tau.cs.sw1.ex5;

import java.io.IOException;

public class BigramModelTester {
	public static final String ALL_YOU_NEED_FILENAME = "src/resources/hw5/all_you_need.txt";
	public static final String EMMA_FILENAME = "src/resources/hw5/emma.txt";
	public static final String ALL_YOU_NEED_COUNTS_DIR = "src/resources/hw5/all_you_need_counts.txt";

	public static void main(String[] args) throws IOException{
		BigramModel sG = new BigramModel();
		int numOfWords = sG.buildModelFromFile(ALL_YOU_NEED_FILENAME);
		if (numOfWords != 5){
			System.out.println("Error 1");
		}
//		if (sG.getBigramCount("is", "love") != 3){
//			System.out.println("Error 2:");
//		}
//		if (sG.getBigramCount("all", "love") != 0){
//			System.out.println("Error 3");
//		}
//		if (sG.getWordIndex("you") != 1){
//			System.out.println("Error 4");
//		}
		sG.saveModelToFile(ALL_YOU_NEED_COUNTS_DIR);
//		sG.loadModelFromFile(ALL_YOU_NEED_COUNTS_DIR);
//		if (sG.getBigramCount("is", "love") != 3){
//			System.out.println("Error 4");
//		}
//		if (!sG.getMostFrequentProceeding("is").equals("love")){
//			System.out.println("Error 5");
//		}
//		if (!sG.buildSentence("all", 3).equals("all you need")){
//			System.out.println("Error 6");
//		}
//		if (!sG.buildSentence("all", 6).equals("all you need is love all")){
//			/* <love all> and <love love> have the same number of counts, but since we select
//			the word with the lowest index, we pick all over love */
//			System.out.println("Error 7");
//		}
//		if (BigramModel.calcCosineSim(new int[] {1,2,0,4, 2}, new int[] {5, 0, 3, 1, 1}) != 11./30){
//			System.out.println("Error 8");
//		}
//		sG.buildModelFromFile(EMMA_FILENAME);
//		if (!sG.getClosestWord("scheme").equals("trick")){
//			System.out.println("Error 9");
//		}
//		if (!sG.getClosestWord("good").equals("great")){
//			System.out.println("Error 10");
//		}
//		System.out.println("done!");

	}
}
