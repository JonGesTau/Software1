package il.ac.tau.cs.sw1.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Sets {
	private static int lastId = 0;
	private int id;
	private int numSets;
	private ArrayList<Integer> allSets = new ArrayList<Integer>();

	public Sets(int[] is) {
		this();
		this.numSets = is.length;
		for (int set : is) {
			allSets.add(set);
		}
	}

	public Sets() {
		this.id = lastId++;
		this.lastId++;
		this.numSets = 0;
		this.allSets = allSets;
	}

	/**
	 * Create a singleton set containing x (i.e. {x}) and add it to this object.
	 * 
	 * @pre x>=0
	 * @post this == $prev(this) U {{x}}
	 */
	public void makeSet(int x) 
	{
		Sets sets = this;
		sets.allSets.add(x);
		sets.numSets++;
	}
	
	/**
	 * Delete all occurrences of x 
	 * 
	 * 
	 * @post for all i: x not in Si
	 * * @return the number of occurrences deleted
	 */
	public int delete(int x)
	{
		Sets sets = this;
		int removed = 0;
		int[][] allSetsArray = convertSetsListToArray();
		for (int i = 0; i < allSetsArray.length; i++) {
			if (allSetsArray[i][0] == x) {
				sets.allSets.remove(i);
				sets.numSets--;
				removed--;
			}
		}

		return removed;
	}


	/**
	 * Return true if and only if x is in a set of this object
	 * 
	 * @pre true ("no precondition")
	 * @return true iff exists i such that x is in Si
	 */
	public boolean inASet(int x)
	{
		Sets sets = this;
		int[][] allSetsArray = convertSetsListToArray();
		for (int i = 0; i < allSetsArray.length; i++) {
			if (allSetsArray[i][0] == x) {
				return true;
			}
		}

		return false;
	}
	/**
	* @pre there exists i such that x is in Si
	 * @return the number of different sets i such that x is in Si
	 */
	public int numOfSets(int x)
	{
		int counter = 0;
		Sets sets = this;
		int[][] allSetsArray = convertSetsListToArray();
		for (int i = 0; i < allSetsArray.length; i++) {
			if (allSetsArray[i][0] == x) {
				counter++;
			}
		}

		return counter;
	}

	/**
	 * Return the number of sets in S (not include empty sets)
	 * 
	 * @return |S|
	 */
	public int getNumSets()
	{
		int counter = 0;
		Sets sets = this;
		int[][] allSetsArray = convertSetsListToArray();
		return allSetsArray.length > 0 ? allSetsArray.length : 0;
	}

	/**
	 * 
	 * 
	 * @return Return the number of distinct values in S
	 */
	public int getNumValues()
	{
		Sets sets = this;
		Set<Integer> setOfSets = new HashSet<Integer>(sets.allSets);
		return setOfSets.size();
	}

	private int[][] convertSetsListToArray() {
		Sets sets = this;
		int[][] allSetsArray = new int[sets.allSets.size()][1];
		for (int i = 0; i < allSetsArray.length; i++) {
			allSetsArray[i] = new int[] {sets.allSets.get(i)};
		}

		return allSetsArray;
	}

}
