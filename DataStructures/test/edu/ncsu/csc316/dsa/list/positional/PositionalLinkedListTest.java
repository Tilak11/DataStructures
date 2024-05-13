package edu.ncsu.csc316.dsa.list.positional;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for PositionalLinkedList. Checks the expected outputs of the
 * Positional List abstract data type behaviors when using an doubly-linked
 * positional list data structure
 *
 * @author Dr. King
 *
 */
public class PositionalLinkedListTest {

	/** Instance of Positional list */
	private PositionalList<String> list;

	/**
	 * Create a new instance of an positional linked list before each test case
	 * executes
	 */
	@Before
	public void setUp() {
		list = new PositionalLinkedList<String>();
	}

	/**
	 * Test the output of the first() behavior, including expected exceptions
	 */
	@Test
	public void testFirst() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		assertNull(list.first());

		Position<String> first = list.addFirst("one");
		assertEquals(1, list.size());
		assertEquals(first, list.first());
		assertEquals("one", list.first().getElement());
		Position<String> first2 = list.addFirst("one-update1");
		assertEquals(2, list.size());
		assertEquals(first2, list.first());
		assertEquals("one-update1", list.first().getElement());
		Position<String> first3 = list.addFirst("one-update2");
		assertEquals(3, list.size());
		assertEquals(first3, list.first());
		assertEquals("one-update2", list.first().getElement());

	}

	/**
	 * Test the output of the last() behavior, including expected exceptions
	 */
	@Test
	public void testLast() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		assertNull(list.last());

		Position<String> last = list.addLast("first and last");
		assertEquals(1, list.size());
		assertEquals(last, list.last());
		assertEquals("first and last", list.last().getElement());
		Position<String> first2 = list.addLast("one-update1");
		assertEquals(2, list.size());
		assertEquals(first2, list.last());
		assertEquals("one-update1", list.last().getElement());
		Position<String> first3 = list.addLast("one-update2");
		assertEquals(3, list.size());
		assertEquals(first3, list.last());
		assertEquals("one-update2", list.last().getElement());

	}

	/**
	 * Test the output of the addFirst(element) behavior
	 */
	@Test
	public void testAddFirst() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		assertNull(list.first());

		Position<String> first = list.addFirst("one");
		assertEquals(1, list.size());
		assertEquals(first, list.first());
		assertEquals("one", list.first().getElement());
		Position<String> first2 = list.addFirst("one-update1");
		assertEquals(2, list.size());
		assertEquals(first2, list.first());
		assertEquals("one-update1", list.first().getElement());
		Position<String> first3 = list.addFirst("one-update2");
		assertEquals(3, list.size());
		assertEquals(first3, list.first());
		assertEquals("one-update2", list.first().getElement());

	}

	/**
	 * Test the output of the addLast(element) behavior
	 */
	@Test
	public void testAddLast() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		assertNull(list.last());

		Position<String> last = list.addLast("first and last");
		assertEquals(1, list.size());
		assertEquals(last, list.last());
		assertEquals("first and last", list.last().getElement());
		Position<String> first2 = list.addLast("one-update1");
		assertEquals(2, list.size());
		assertEquals(first2, list.last());
		assertEquals("one-update1", list.last().getElement());
		Position<String> first3 = list.addLast("one-update2");
		assertEquals(3, list.size());
		assertEquals(first3, list.last());
		assertEquals("one-update2", list.last().getElement());
	}

	/**
	 * Test the output of the before(position) behavior, including expected
	 * exceptions
	 */
	@Test
	public void testBefore() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		Position<String> first = list.addFirst("one");
		Position<String> sec = list.addLast("two");
		Position<String> third = list.addLast("three");
		Position<String> four = list.addLast("four");
		assertEquals(third, list.before(four));
		assertEquals(sec, list.before(third));
		assertEquals(first, list.before(sec));
		assertNull(list.before(first));

	}

	/**
	 * Test the output of the after(position) behavior, including expected
	 * exceptions
	 */
	@Test
	public void testAfter() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addFirst("one");
		Position<String> sec = list.addLast("two");
		Position<String> third = list.addLast("three");
		Position<String> four = list.addLast("four");
		assertEquals(sec, list.after(first));
		assertEquals(third, list.after(sec));
		assertEquals(four, list.after(third));
		assertNull(list.after(four));

	}

	/**
	 * Test the output of the addBefore(position, element) behavior, including
	 * expected exceptions
	 */
	@Test
	public void testAddBefore() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addFirst("one");
		Position<String> sec = list.addLast("two");
		Position<String> third = list.addLast("three");
		Position<String> four = list.addLast("four");
		Position<String> test = list.addBefore(four, "test");
		assertNull(list.before(first));
		Position<String> test2 = list.addBefore(first, "test2");
		assertEquals(test2, list.before(first));
		Position<String> test3 = list.addBefore(third, "before three");
		assertEquals(test3, list.before(third));
		assertEquals(test3, list.after(sec));

		assertEquals(test, list.after(third));
		assertEquals(test, list.before(four));

	}

	/**
	 * Test the output of the addAfter(position, element) behavior, including
	 * expected exceptions
	 */
	@Test
	public void testAddAfter() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addFirst("one");
		Position<String> sec = list.addLast("two");
		Position<String> third = list.addLast("three");
		assertEquals(3, list.size());

		Position<String> four = list.addLast("four");
		Position<String> test = list.addAfter(third, "test");
		Position<String> test2 = list.addAfter(first, "test2");
		Position<String> test3 = list.addAfter(sec, "before three");
		assertEquals(7, list.size());


		assertEquals(test, list.after(third));
		assertEquals(test, list.before(four));
		assertEquals(test2, list.after(first));
		assertEquals(test2, list.before(sec));
		assertEquals(test3, list.after(sec));
		assertEquals(test3, list.before(third));
	}

	/**
	 * Test the output of the set(position, element) behavior, including expected
	 * exceptions
	 */
	@Test
	public void testSet() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addFirst("one");
		Position<String> sec = list.addLast("two");
		Position<String> third = list.addLast("three");
		Position<String> four = list.addLast("four");
		assertEquals("three", list.set(third, "three-updated"));
		assertEquals("three-updated", list.after(sec).getElement());
		assertEquals("three-updated", list.before(four).getElement());
		
		
		assertEquals("one", list.set(first, "first-updated"));
		assertEquals("first-updated", list.first().getElement());
		assertEquals("first-updated", list.before(sec).getElement());
		
		assertEquals("two", list.set(sec, "two-updated"));
		assertEquals("two-updated", list.after(first).getElement());
		assertEquals("two-updated", list.before(third).getElement());
	}

	/**
	 * Test the output of the remove(position) behavior, including expected
	 * exceptions
	 */
	@Test
	public void testRemove() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addFirst("one");
		Position<String> sec = list.addLast("two");
		Position<String> third = list.addLast("three");
		Position<String> four = list.addLast("four");
		Position<String> five = list.addLast("five");
		assertEquals(5, list.size());
		assertEquals("three", list.remove(third));
		assertEquals(four, list.after(sec));
		assertEquals(sec, list.before(four));
		assertEquals(4, list.size());
		assertEquals("four", list.remove(four));
		assertEquals(3, list.size());
		assertEquals("one", list.remove(first));
		assertEquals(2, list.size());
		assertEquals("two", list.remove(sec));
		assertEquals(1, list.size());
		assertEquals("five", list.remove(five));
		assertEquals(0, list.size());

	}

	/**
	 * Test the output of the iterator behavior for elements in the list, including
	 * expected exceptions
	 */
	@Test
	public void testIterator() {
		// Use your ArrayBasedList and SinglyLinkedList test cases as a guide
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		// Create an iterator for the empty list
		Iterator<String> it = list.iterator();

		// Try different operations to make sure they work
		// as expected for an empty list (at this point)
		try {
			it.remove();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		assertFalse(it.hasNext());
		list.addLast("one");
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		assertEquals("one", list.last().getElement());
		list.addLast("two");
		assertEquals(2, list.size());
		assertEquals("two", list.last().getElement());
		assertFalse(list.isEmpty());
		list.addLast("three");
		assertEquals(3, list.size());
		assertEquals("three", list.last().getElement());
		list.addLast("four");
		assertEquals("four", list.last().getElement());

		it = list.iterator();

		// Try different iterator operations to make sure they work
		// as expected for a list that contains 1 element (at this point)
		assertTrue(it.hasNext());
		assertEquals("one", it.next());
		assertTrue(it.hasNext());
		assertEquals("two", it.next());
		it.remove();
		assertTrue(it.hasNext());
		assertEquals("three", it.next());
		assertTrue(it.hasNext());
		assertEquals("four", it.next());
		assertFalse(it.hasNext());

		try {
			it.remove();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}

		try {
			it.next();
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}

	}

	/**
	 * Test the output of the positions() behavior to iterate through positions in
	 * the list, including expected exceptions
	 */
	@Test
	public void testPositions() {
		assertEquals(0, list.size());

		Position<String> first = list.addFirst("one");
		Position<String> sec = list.addLast("two");
		Position<String> third = list.addLast("three");
		Position<String> four = list.addLast("four");
		Position<String> five = list.addLast("five");
		assertEquals(5, list.size());

		Iterator<Position<String>> it = list.positions().iterator();

		try {
			it.remove();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}

		assertTrue(it.hasNext());
		assertEquals(first, it.next());
		assertTrue(it.hasNext());
		assertEquals(sec, it.next());
		assertTrue(it.hasNext());
		assertEquals(third, it.next());
		assertTrue(it.hasNext());
		assertEquals(four, it.next());
		assertTrue(it.hasNext());
		assertEquals(five, it.next());
		it.remove();
		assertEquals(4, list.size());

		try {
			it.remove();
			fail();

		} catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);

		}

		assertFalse(it.hasNext());
		try {
			it.next();
			fail();

		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);

		}

	}

}
