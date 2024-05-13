package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A singly-linked list is a linked-memory representation of the List abstract
 * data type. This list maintains a dummy/sentinel front node in the list to
 * help promote cleaner implementations of the list behaviors. This list also
 * maintains a reference to the tail/last node in the list at all times to
 * ensure O(1) worst-case cost for adding to the end of the list. Size is
 * maintained as a global field to allow for O(1) size() and isEmpty()
 * behaviors.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the list
 */
public class SinglyLinkedList<E> extends AbstractList<E> {

	/** A reference to the dummy/sentinel node at the front of the list **/
	private LinkedListNode<E> front;

	/** A reference to the last/final node in the list **/
	private LinkedListNode<E> tail;

	/** The number of elements stored in the list **/
	private int size;

	/**
	 * Constructs an empty singly-linked list
	 */
	public SinglyLinkedList() {
		front = null; // new LinkedListNode<E>(null);
		tail = null;
		size = 0;
	}

	@Override
	public void add(int index, E element) {
		checkIndexForAdd(index);
		LinkedListNode<E> current = front;

		if (index == 0) {
			LinkedListNode<E> node = new LinkedListNode<E>(element);
			node.next = front;
			front = node;
			if (index == size) {

				tail = node;
			}
			size++;
			return;

		}
		current = front;
		LinkedListNode<E> node = new LinkedListNode<E>(element);
		for (int i = 1; i < index; i++) {
			current = current.next;
		}

		node.next = current.next;
		current.next = node;
		if (index == size) {

			tail = node;
		}
		size++;
//		System.out.println(tail.data);
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		LinkedListNode<E> current = front;
		if (index == 0) {
			return front.data;
		}
		for (int i = 1; i < index; i++) {
			current = current.next;
		}
		E e = current.next.data;
		return e;
	}

	@Override
	public E remove(int index) {
		checkIndex(index);

		// TODO Auto-generated method stub
		if (index == 0) {
			if (size > 1) {
				LinkedListNode<E> current = front;
				E e = current.data;
				front = front.next;
				size--;
//				current = front;
//				while (current.next != null) {
//					current = current.next;
//				}
//				tail = current;
				return e;
			} else {
				size--;
				E e = front.data;
				front = null;
				return e;

			}

		}
		LinkedListNode<E> current = front;
		for (int i = 1; i < index; i++) {
			current = current.next;
		}
		E e = current.next.data;
		if (index < size - 1)
			current.next = current.next.next;
		else
			current.next = null;

		size--;

		current = front;
		while (current.next != null) {
			current = current.next;
		}
		tail = current;
//		System.out.println("remove : "+tail.data);

		return e;
	}

	@Override
	public E set(int index, E element) {
		checkIndex(index);

		// TODO Auto-generated method stub
		LinkedListNode<E> current = front;
		if (index == 0) {
			LinkedListNode<E> node = new LinkedListNode<E>(element);
			node.next = front.next;
			front = node;
			return current.data;
		}

		for (int i = 1; i < index; i++) {
			current = current.next;
		}
		E e = current.getNext().data;
		LinkedListNode<E> node = new LinkedListNode<E>(element, current.next.next);
		current.next = node;
		if (index == size - 1) {
			tail = node;
		}
		return e;

	}

	/**
	 * {@inheritDoc} For a singly-linked list, this behavior has O(1) worst-case
	 * runtime.
	 */
	@Override
	public E last() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("The list is empty");
		}
		return tail.getElement();
	}

	/**
	 * {@inheritDoc} For this singly-linked list, addLast(element) behavior has O(1)
	 * worst-case runtime.
	 */
	@Override
	public void addLast(E element) {
		if (size == 0) {
			LinkedListNode<E> node = new LinkedListNode<E>(element);
			tail = node;
			front = node;
			size++;
			return;
		}
		LinkedListNode<E> node = new LinkedListNode<E>(element);
		tail.setNext(node);
		tail = node;
		size++;
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

	private static class LinkedListNode<E> {

		/** data */
		private E data;
		/** next node in the list */
		private LinkedListNode<E> next;

		public LinkedListNode(E e) {
			data = e;
		}

		public LinkedListNode(E e, LinkedListNode<E> node) {
			setElement(e);
			setNext(node);
		}

		public LinkedListNode<E> getNext() {
			return next;
		}

		public E getElement() {
			return data;
		}

		public void setNext(LinkedListNode<E> node) {
			next = node;
		}

		public void setElement(E e) {
			data = e;
		}

	}

	private class ElementIterator implements Iterator<E> {
		/**
		 * Keep track of the next node that will be processed
		 */
		private LinkedListNode<E> current;

		/**
		 * Keep track of the node that was processed on the last call to 'next'
		 */
		private LinkedListNode<E> previous;

		/**
		 * Keep track of the previous-previous node that was processed so that we can
		 * update 'next' links when removing
		 */
		private LinkedListNode<E> previousPrevious;

		/**
		 * Keep track of whether it's ok to remove an element (based on whether next()
		 * has been called immediately before remove())
		 */
		private boolean removeOK = false;

		/**
		 * Construct a new element iterator where the cursor is initialized to the
		 * beginning of the list.
		 */
		public ElementIterator() {
			current = front;
//			previous.next=current;
//			previousPrevious.next=previous.next;
		}

		@Override
		public boolean hasNext() {
			if (current != null) {

				return true;
			}
			return false;
		}

		@Override
		public E next() {
			try {
				E temp = current.data;
				previousPrevious = previous;
				previous = current;
				current = current.next;
				setRemoveOK(true);
				return temp;
			} catch (NullPointerException n) {
				throw new NoSuchElementException();
			}

//			if (current == front) {
//				removeOK = true;
//				E temp=current.data;
//				current = current.next;
//				return temp;
//			}
//			previous = current;
//			current = current.next;
//			removeOK = true;
//			return previous.data;

		}

		@Override
		public void remove() {
			try {
				if (isRemoveOK()) {
					if (previousPrevious == null) {
						previousPrevious = new LinkedListNode<E>(null);
					}
					previousPrevious.next = getCurrent();
					setPrevious(getPreviousPrevious());
					setRemoveOK(false);
					size--;
				} else
					throw new IllegalStateException();
			} catch (Exception e) {
				throw new IllegalStateException("error");

			}

		}

		public LinkedListNode<E> getCurrent() {
			return current;
		}

		public void setPrevious(LinkedListNode<E> prev) {
			previous = prev;
		}

		public LinkedListNode<E> getPreviousPrevious() {
			return previousPrevious;
		}

		public void setRemoveOK(boolean remove) {
			removeOK = remove;
		}

		public boolean isRemoveOK() {
			return removeOK;
		}
	}

}
