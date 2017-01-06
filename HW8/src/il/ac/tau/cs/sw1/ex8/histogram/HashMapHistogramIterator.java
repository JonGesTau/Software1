package il.ac.tau.cs.sw1.ex8.histogram;

import java.util.*;


/**************************************
 *  Add your code to this class !!!   *
 **************************************/
public class HashMapHistogramIterator<T extends Comparable<T>> implements Iterator<T>{
	Map<T, Integer> histogram;
	SortedMap<T, Integer> sortedHistogram;
	Object[] keysArray;
	int currentIndex;

	public HashMapHistogramIterator(Map<T, Integer> histogram) {
		this.histogram = histogram;
		this.sortedHistogram = new TreeMap<T, Integer>(new HistComparator());
		this.sortedHistogram.putAll(histogram);
		this.keysArray = sortedHistogram.keySet().toArray();
		this.currentIndex = -1;
	}
	

	@Override
	public boolean hasNext() {
		return currentIndex + 1 < keysArray.length;
	}

	@Override
	public T next() {
		currentIndex++;
		return (T) keysArray[currentIndex];
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	public class HistComparator implements Comparator<T> {
		@Override
		public int compare(T item1, T item2) {
			return histogram.get(item1) == histogram.get(item2) ? item1.compareTo(item2) : histogram.get(item2) - histogram.get(item1);
		}
	}
}

