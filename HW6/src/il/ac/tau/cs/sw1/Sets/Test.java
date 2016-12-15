package il.ac.tau.cs.sw1.Sets;

public class Test {
public static void main(String[] args) {
		
		
		Sets s = new Sets(); // s = {}

		System.out.println(s.getNumSets());
		
		s.makeSet(3); // s = {{3}}
		s.makeSet(4); // s = {{3}, {4}}

		printError(s.getNumValues() == 2,
				"should be 2 distinct valus in s");

		s.makeSet(3); // s = {{3}, {4}, {3}}


		printError(s.getNumValues() == 2,
			"should be 2 distinct valus in s");

		printError(s.getNumSets() == 3,
				"should be 3 distinct sets in s");


		printError(s.inASet(3) == true,
				" 3 should be in a set in s");

		printError(s.numOfSets(3) == 2,
				" 3 should be in 2 sets in s");

//


		int [] arr = {16,2,3};
		Sets s2 = new Sets(arr); // {{1},{2},{3}}

		printError(s2.getNumSets() == 3,
				"should be 3 sets in s2");

		s2.delete(2); // {{1},{3}}


		printError(s2.getNumSets() == 2,
				"should be 2 sets in s2");


		
		
	}

	public static void printError(boolean condition, String message) {
		if (!condition) {
			throw new RuntimeException("[ERROR] " + message);
		}
	}

}
