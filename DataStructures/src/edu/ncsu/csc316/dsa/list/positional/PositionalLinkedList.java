package edu.ncsu.csc316.dsa.list.positional;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ncsu.csc316.dsa.Position;

/* Citing Help from the Textbooks
 * The code for this class is based on the LinkedPositionalList code PositionIterator code given on pages 277-280 and page 287 in the course textbook
 * "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
 */

/**
 * The Positional Linked List is implemented as a doubly-linked list data
 * structure to support efficient, O(1) worst-case Positional List abstract data
 * type behaviors.
 * 
 * Size is maintained as a global field to ensure O(1) worst-case runtime of
 * size() and isEmpty().
 * 
 * The PositionalLinkedList class is based on the implementation developed for
 * use with the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley & Sons, 2014
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the positional list
 */
public class PositionalLinkedList<E> implements PositionalList<E> {

	/** A dummy/sentinel node representing at the front of the list **/
	private PositionalNode<E> front;

	/** A dummy/sentinel node representing at the end/tail of the list **/
	private PositionalNode<E> tail;

	/** The number of elements in the list **/
	private int size;

	/*
	 * Citing Help from the Course Textbook
	 * The code for this constructor is based on the
	 * LinkedPositionalList code given on page 277 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	/**
	 * Constructs an empty positional linked list
	 */
	public PositionalLinkedList() {
		front = new PositionalNode<E>(null);
		tail = new PositionalNode<E>(null, null, front);
		front.setNext(tail);
		size = 0;
	}
 
	/*
	 * Citing Help from the Course Textbook
	 * The code for this inner class and its methods is based on the
	 * LinkedPositionalList code given on pages 277 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	private static class PositionalNode<E> implements Position<E> {

		/** data of type E */
		private E element;
		/** Reference to next node */
		private PositionalNode<E> next;
		/** Reference to previous node */
		private PositionalNode<E> previous;

		public PositionalNode(E value) {
			this(value, null);
		}

		public PositionalNode(E value, PositionalNode<E> next) {
			this(value, next, null);
		}

		public PositionalNode(E value, PositionalNode<E> next, PositionalNode<E> prev) {
			setElement(value);
			setNext(next);
			setPrevious(prev);
		}

		public void setPrevious(PositionalNode<E> prev) {
			previous = prev;
		}

		public PositionalNode<E> getPrevious() {
			return previous;
		}

		public void setNext(PositionalNode<E> next) {
			this.next = next;
		}

		public PositionalNode<E> getNext() {
			return next;
		}

		@Override
		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}
	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this method is based on the
	 * LinkedPositionalList code given on page 278 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	/**
	 * Safely casts a Position, p, to be a PositionalNode.
	 * 
	 * @param p the position to cast to a PositionalNode
	 * @return a reference to the PositionalNode
	 * @throws IllegalArgumentException if p is null, or if p is not a valid
	 *                                  PositionalNode
	 */
	private PositionalNode<E> validate(Position<E> p) {
		if (p instanceof PositionalNode) {
			return (PositionalNode<E>) p;
		}
		throw new IllegalArgumentException("Position is not a valid positional list node."); 
	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this method is based on the
	 * LinkedPositionalList code given on page 279 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	private Position<E> addBetween(E element, PositionalNode<E> next, PositionalNode<E> prev) {
		PositionalNode<E> node = new PositionalNode<>(element, next, prev);
		prev.setNext(node);
		next.setPrevious(node);
		size++;
		return node;
	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this method is based on the
	 * LinkedPositionalList code given on page 278 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public Position<E> first() {
		return position(front.getNext());

	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this method is based on the
	 * LinkedPositionalList code given on page 278 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	private Position<E> position(PositionalNode<E> node) {
		if (node == front || node == tail)
			return null;
		return node;
	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this method is based on the
	 * LinkedPositionalList code given on page 278 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public Position<E> last() {
		return position(tail.getPrevious());

	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this method is based on the
	 * LinkedPositionalList code given on page 278 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public Position<E> before(Position<E> pos) {
		PositionalNode<E> node = validate(pos);
		return position(node.getPrevious());

	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this method is based on the
	 * LinkedPositionalList code given on page 278 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public Position<E> after(Position<E> pos) {
		PositionalNode<E> node = validate(pos);
		return position(node.getNext());
	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this method is based on the
	 * LinkedPositionalList code given on page 279 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public Position<E> addFirst(E e) {
		return addBetween(e, front.getNext(), front);
	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this method is based on the
	 * LinkedPositionalList code given on page 279 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public Position<E> addLast(E e) {
		return addBetween(e, tail, tail.getPrevious());

	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this method is based on the
	 * LinkedPositionalList code given on page 279 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public Position<E> addBefore(Position<E> pos, E e) {
		PositionalNode<E> node = validate(pos);
		return addBetween(e, node, node.getPrevious());

	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this method is based on the
	 * LinkedPositionalList code given on page 279 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public Position<E> addAfter(Position<E> pos, E e) {
		PositionalNode<E> node = validate(pos);
		return addBetween(e, node.getNext(), node);
	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this method is based on the
	 * LinkedPositionalList code given on page 279 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public E set(Position<E> pos, E e) {
		PositionalNode<E> node = validate(pos);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this method is based on the
	 * LinkedPositionalList code given on page 280 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public E remove(Position<E> pos) {
		PositionalNode<E> node = validate(pos);
		PositionalNode<E> prev = node.getPrevious();
		PositionalNode<E> next = node.getNext();
		prev.setNext(next);
		next.setPrevious(prev);
		size--;
		E temp = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrevious(null);
		return temp;

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this method is based on the
	 * PositionIterator code given on page 287 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public Iterable<Position<E>> positions() {
		return new PositionIterable();
	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this method is based on the
	 * PositionIterator code given on page 287 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this innerclass is based on the
	 * PositionIterator code given on page 287 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	private class PositionIterator implements Iterator<Position<E>> {

		/** Position of current element */
		private Position<E> current;
		/** Position of last reported element */
		private Position<E> recent = null;

//		private boolean removeOK;

		public PositionIterator() {
			current = first();

		}

		@Override
		public boolean hasNext() {
			if (current != null) {
				return true;
			}
			return false;
		}

		@Override
		public Position<E> next() {
			if (current == null) {
				throw new NoSuchElementException();

			}
			recent = current;
			current = after(current);
			return recent;

		}

		@Override
		public void remove() {

			try {
				if (recent != null) {
					PositionalLinkedList.this.remove(recent);
				} else
					throw new IllegalStateException();
			} catch (Exception e) {
				throw new IllegalStateException();

			}
		}
	}

	private class ElementIterator implements Iterator<E> {

		/** Instance of Position Iterator */
		private Iterator<Position<E>> it;

		public ElementIterator() {
			it = new PositionIterator();
		}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public E next() {
			return it.next().getElement();
		}

		@Override
		public void remove() {
			it.remove();

		}
	}

	/*
	 * Citing Help from the Course Textbook
	 * The code for this innerclass is based on the
	 * PositionIterator code given on page 287 in the course
	 * textbook "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser (6th Edition).
	 */
	private class PositionIterable implements Iterable<Position<E>> {

		@Override
		public Iterator<Position<E>> iterator() {
			return new PositionIterator();
		}

	}
}
