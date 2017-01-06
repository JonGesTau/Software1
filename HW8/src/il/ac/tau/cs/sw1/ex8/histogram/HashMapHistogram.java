package il.ac.tau.cs.sw1.ex8.histogram;

import java.util.*;

/**************************************
 *  Add your code to this class !!!   *
 **************************************/
public class HashMapHistogram<T extends Comparable<T>> implements IHistogram<T>{
	Map<T, Integer> histogram = new HashMap<>();

	@Override
	public void addItem(T item) {
		histogram.put(item, histogram.containsKey(item) ? histogram.get(item) + 1 : 1);
	}

	@Override
	public void addItemKTimes(T item, int k) throws IllegalKValue {
		histogram.put(item, histogram.containsKey(item) ? histogram.get(item) + k : k);
	}

	@Override
	public int getCountForItem(T item) {
		return histogram.containsKey(item) ? histogram.get(item) : 0;
	}

	@Override
	public void addAll(Collection<T> items) {
		for (T item : items) {
			addItem(item);
		}
	}

	@Override
	public void clear() {
		histogram.clear();
	}

	@Override
	public Set<T> getItemsSet() {
		return histogram.keySet();
	}

	@Override
	public Iterator<T> iterator() {
		return new HashMapHistogramIterator(histogram);
	}
	
}
