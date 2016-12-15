package il.ac.tau.cs.sw1.Sets;

import java.util.ArrayList;
import java.util.List;

public class Sets {
	private static int lastId = 0;
	private int id;
	private int numSets;
	ArrayList<Integer> allSets = new ArrayList<Integer>();

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
		for (int i = 0; i < sets.allSets.size(); i++) {
			if (sets.allSets.get(i) == x) {
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
		return false;
		//TODO
	}
	/**
	* @pre there exists i such that x is in Si
	 * @return the number of different sets i such that x is in Si
	 */
	public int numOfSets(int x)
	{
		return 0;
		//TODO
	}

	/**
	 * Return the number of sets in S (not include empty sets)
	 * 
	 * @return |S|
	 */
	public int getNumSets() 
	{
		return 0;
		//TODO
	}

	/**
	 * 
	 * 
	 * @return Return the number of distinct values in S
	 */
	public int getNumValues()
	{
		return 0;
		//TODO
	}


}
