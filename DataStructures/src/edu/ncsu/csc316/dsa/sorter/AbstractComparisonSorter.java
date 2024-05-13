package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;
/**
 * This is super class of InsertSorter, BubbleSorter, and SelectionSorter
 * It has functionality to add custom comparators
 * @author Tilak
 *
 * @param <E> Java generic type
 */
public abstract class AbstractComparisonSorter<E extends Comparable<E>> implements Sorter<E> {

	/** Instance of comparator of type E*/
    private Comparator<E> comparator;
    
    /**
     * Constructor
     * @param comparator comparator can be custom or null
     */
    public AbstractComparisonSorter(Comparator<E> comparator) {
        setComparator(comparator);
    }
    
    private void setComparator(Comparator<E> comparator) {
        if(comparator == null) {
            this.comparator = new NaturalOrder();
        } else {
            this.comparator = comparator;
        }
    }   
    
    private class NaturalOrder implements Comparator<E> {
        public int compare(E first, E second) {
            return ((Comparable<E>) first).compareTo(second);
        }
    }
    /**
     * Compares two object of type E
     * @param data1 object of type E
     * @param data2 object of type E
     * @return 1 if data1 is greater than data2,
     * 		  -1, if data1 is less than data2,
     *         0, if data1 is equal to data2,
     */
    public int compare(E data1, E data2) {
        return comparator.compare(data1,  data2);
    }
}