package il.ac.tau.cs.sw1.Sets;

public class Sets {
	
	public Sets(int[] is) {
		// TODO Auto-generated constructor stub
	}

	public Sets() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create a singleton set containing x (i.e. {x}) and add it to this object.
	 * 
	 * @pre x>=0
	 * @post this == $prev(this) U {{x}}
	 */
	public void makeSet(int x) 
	{
		//TODO
	}
	
	/**
	 * Delete all occurrences of x 
	 * 
	 * 
	 * @post for all i: x not in Si
	 * * @return the number of occurrences deleted
	 */
	public void delete(int x) 
	{
		//TODO
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
