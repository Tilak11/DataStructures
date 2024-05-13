package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
* This class uses bubble sort to sort data
* 
* @author Tilak
*
* @param <E> Java generic type
*/
public class BubbleSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> implements Sorter<E> {

	/**
     * Default constructor
     */
	public BubbleSorter() {
		super(null);
	}

	/**
	 * Constructor for custom comparator
	 * @param comparator a custom comparator
	 */
	public BubbleSorter(Comparator<E> comparator) {
		super(comparator);
	}

	@Override
	public void sort(E[] data) {
		boolean r = true;
		while (r) {
			r = false;
			for (int i = 1; i < data.length; i++) {
				if (super.compare(data[i], data[i - 1]) < 0 ) {
					E x = data[i - 1];
					data[i - 1] = data[i];
					data[i] = x;
					r = true;
				}
			}
		}

	}

}
