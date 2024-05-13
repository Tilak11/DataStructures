package edu.ncsu.csc316.dsa.sorter;

/**
 * Interface that defines the sorting behavior
 * @author Dr. King
 * @param <E> Java generic type
 */
public interface Sorter<E> {
	/**
	 * This method sorts array of type E (generic)
	 * @param data array of type E
	 */
	public void sort(E[] data);
}
