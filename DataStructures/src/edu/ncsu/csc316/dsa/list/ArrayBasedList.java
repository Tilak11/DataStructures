package edu.ncsu.csc316.dsa.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* Citing Help from the Textbooks
 * The code for this class is based on the ArrayList code and ArrayIterator code given on pages 260-261 and page 285 in the course textbook
 * "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
 */
/**
 * An array-based list is a contiguous-memory representation of the List
 * abstract data type. This array-based list dynamically resizes to ensure O(1)
 * amortized cost for adding to the end of the list. Size is maintained as a
 * global field to allow for O(1) size() and isEmpty() behaviors.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the list
 */
public class ArrayBasedList<E> extends AbstractList<E> {

	/**
	 * The initial capacity of the list if the client does not provide a capacity
	 * when constructing an instance of the array-based list
	 **/
	private final static int DEFAULT_CAPACITY = 0;

	/** The array in which elements will be stored **/
	private E[] data;

	/** The number of elements stored in the array-based list data structure **/
	private int size;

	/**
	 * Constructs a new instance of an array-based list data structure with the
	 * default initial capacity of the internal array
	 */
	public ArrayBasedList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constructs a new instance of an array-based list data structure with the
	 * provided initial capacity
	 * 
	 * @param capacity the initial capacity of the internal array used to store the
	 *                 list elements
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList(int capacity) {
		data = (E[]) (new Object[capacity]);
		size = 0;
	}

	/* Citing Help from the Textbooks
	 * The code for this method is based on the ArrayList code page 261 in the course textbook
	 * "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public void add(int index, E element) {
		checkIndexForAdd(index);
		ensureCapacity(size + 1);
		for (int i = size() - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = element;
		size++;

	}

	/* Citing Help from the Textbooks
	 * The code for this method is based on the ArrayList code page 261 in the course textbook
	 * "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public E get(int index) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Invalid Index");
		return data[index];
	}

	/* Citing Help from the Textbooks
	 * The code for this method is based on the ArrayList code page 261 in the course textbook
	 * "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public E remove(int index) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Invalid Index");
		E temp = data[index];
		for (int i = index; i < size() - 1; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return temp;
	}

	/* Citing Help from the Textbooks
	 * The code for this method is based on the ArrayList code page 261 in the course textbook
	 * "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public E set(int index, E element) {

		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Invalid Index");
		E temp = data[index];
		data[index] = element;
		return temp;

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ElementIterator();
	}

	/**
	 * To ensure amortized O(1) cost for adding to the end of the array-based list,
	 * use the doubling strategy on each resize. Here, we add +1 after doubling to
	 * handle the special case where the initial capacity is 0 (otherwise, 0*2 would
	 * still produce a capacity of 0).
	 * 
	 * @param minCapacity the minimium capacity that must be supported by the
	 *                    internal array
	 */
	private void ensureCapacity(int minCapacity) {
		int oldCapacity = data.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = oldCapacity * 2 + 1;
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			data = Arrays.copyOf(data, newCapacity);
		}
	}

	/* Citing Help from the Textbooks
	 * The code for this innerclass and its methods is based on the ArrayIterator code given on page 285 in the course textbook
	 * "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	private class ElementIterator implements Iterator<E> {
		/** index of current pointer */
		private int position;
		/** turns true if it is eligible to remove */
		private boolean removeOK = false;

		/**
		 * Construct a new element iterator where the cursor is initialized to the
		 * beginning of the list.
		 */
		public ElementIterator() {
			position = 0;
		}

		@Override
		public boolean hasNext() {
			if (position < size) {
				return true;
			}
			return false;
		}

		@Override
		public E next() {
			if (position != size) {
				removeOK = true;
				int pos = position;
				position++;
				return data[pos];
			} else
				throw new NoSuchElementException();

		}

		@Override
		public void remove() {
			if (removeOK) {
				ArrayBasedList.this.remove(position - 1);
				position--;
				removeOK = false;

			} else
				throw new IllegalStateException();
		}
	}
}
