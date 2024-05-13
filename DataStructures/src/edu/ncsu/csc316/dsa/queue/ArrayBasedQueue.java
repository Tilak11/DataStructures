package edu.ncsu.csc316.dsa.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * The Array-based Queue is implemented as a circular array-based data structure
 * to support efficient, O(1) worst-case Queue abstract data type behaviors. The
 * internal array dynamically resizes using the doubling strategy to ensure O(1)
 * amortized cost for adding to the queue.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the queue
 */
public class ArrayBasedQueue<E> extends AbstractQueue<E> {

	/**
	 * Internal array to store the data within the queue
	 */
	private E[] data;

	/**
	 * A reference to the index of the first element in the queue
	 */
	private int front;
	/**
	 * A reference to the index of the element immediately after last element in the
	 * queue
	 */
	private int rear;

	/**
	 * The number of elements stored in the queue
	 */
	private int size;

	/**
	 * The initial default capacity of the internal array that stores the data
	 */
	private static final int DEFAULT_CAPACITY = 2;

	/**
	 * Constructs a new array-based queue with the given initialCapcity for the
	 * array
	 * 
	 * @param initialCapacity the initial capacity to use when creating the initial
	 *                        array
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedQueue(int initialCapacity) {
		data = (E[]) (new Object[initialCapacity]);
		size = 0;
	}

	/**
	 * Constructs a new array-based queue with the default initial capacity for the
	 * array
	 */
	public ArrayBasedQueue() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * To ensure amortized O(1) cost for adding to the array-based queue, use the
	 * doubling strategy on each resize. Here, we add +1 after doubling to handle
	 * the special case where the initial capacity is 0 (otherwise, 0*2 would still
	 * produce a capacity of 0).
	 * 
	 * @param minCapacity the minimium capacity that must be supported by the
	 *                    internal array
	 */
	private void ensureCapacity(int minCapacity) {
		int oldCapacity = data.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = (oldCapacity * 2) + 1;
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			data = Arrays.copyOf(data, newCapacity);

		}
	}

	/*
	 * Citing Help from the Course Textbook The code for this method is based on the
	 * ArrayQueue code given on page 243 in the course textbook
	 * "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th
	 * Edition).
	 */
	@Override
	public void enqueue(E element) {
		
		ensureCapacity(size + 1);
		rear = (front + size) % data.length;
		data[rear] = element;
		size++;

	}

	/*
	 * Citing Help from the Course Textbook The code for this method is based on the
	 * ArrayQueue code given on page 243 in the course textbook
	 * "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th
	 * Edition).
	 */
	@Override
	public E dequeue() {
		if (isEmpty())
			throw new NoSuchElementException();
		E elem = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;
		return elem;
	}

	@Override
	public E front() {
		if (isEmpty())
			throw new NoSuchElementException();
		return data[front];
	}

	@Override
	public int size() {
		return size;
	}

}