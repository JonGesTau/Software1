package il.ac.tau.cs.sw1.hw6;

import java.util.Arrays;

public class SectionB {
	
	/*
	* @post $ret == true iff exists i such that array[i] == value
	*/
	public static boolean contains(int[] array, int value) { 
		for (int item : array) {
			if (item == value) {
				return true;
			}
		}

		return false;
	}
	/*
	* @pre array != null
	* @pre array.length > 2
	* @pre Arrays.equals(array, Arrays.sort(array))
	*/
	public static int guess(int[] array) { 
		// Nothing to do here really. As long as preconditions are met (assuming they are met), return the answer to everything.
		return 42;
	}
	/*
	* @pre Arrays.equals(array, Arrays.sort(array))
	* @pre array.length >= 1
	* @post for all i array[i] >= $ret
	*/
	public static int min(int[] array) {
		// The array is sorted so the first item is the smallest.
		return array[0];
	}
	
	/*
	* @pre array.length >=1
	* @post for all i array[i] >= $ret
	* @post Arrays.equals(array, prev(array))
	*/
	public static int min2(int[] array) { 
		int[] tempArray = Arrays.copyOf(array, array.length);
		Arrays.sort(tempArray);
		return tempArray[0];
	}
	
	/*
	* @pre word.length() >=1
	* @post for all i : $ret.charAt(i) == word.charAt(a.length() - i - 1)

	*/
	public String reverse(String word)
	{
		String result = "";
		for (int i = 0; i < word.length(); i++) {
			result = word.charAt(i) + result;
		}
		return result;
	}
}
