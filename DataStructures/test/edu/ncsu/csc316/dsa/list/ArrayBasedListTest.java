package edu.ncsu.csc316.dsa.list;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for ArrayBasedList. Checks the expected outputs of the List
 * abstract data type behaviors when using an array-based list data structure
 *
 * @author Dr. King
 *
 */
public class ArrayBasedListTest {

	/**Instance of ArrayBasedList*/
	private List<String> list;

	/**
	 * Create a new instance of an array-based list before each test case executes
	 */
	@Before
	public void setUp() {
		list = new ArrayBasedList<String>();
	}

	/**
	 * Test the output of the add(index, e) behavior, including expected exceptions
	 */
	@Test
	public void testAddIndex() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		list.add(0, "one");
		assertEquals(1, list.size());
		assertEquals("one", list.get(0));
		assertFalse(list.isEmpty());
		list.add(1, "two");
		assertEquals(2, list.size());
		assertEquals("two", list.get(1));
		assertFalse(list.isEmpty());
		list.add(2, "three");
		assertEquals(3, list.size());
		assertEquals("three", list.get(2));
		assertFalse(list.isEmpty());
		list.add(2, "three-replaced");
		assertEquals(4, list.size());
		assertEquals("three-replaced", list.get(2));
		assertEquals("three", list.get(3));
		assertFalse(list.isEmpty());

		list = new ArrayBasedList<String>(5);
		list.add(0, "one");
		assertEquals(1, list.size());
		assertEquals("one", list.get(0));
		assertFalse(list.isEmpty());
		list.add(1, "two");
		assertEquals(2, list.size());
		assertEquals("two", list.get(1));
		assertFalse(list.isEmpty());
		list.add(2, "three");
		assertEquals(3, list.size());
		assertEquals("three", list.get(2));
		assertFalse(list.isEmpty());
		list.add(2, "three-replaced");
		assertEquals(4, list.size());
		assertEquals("three-replaced", list.get(2));
		try {
			list.add(6, "six");
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
		assertEquals("three", list.get(3));
		assertFalse(list.isEmpty());
		list.add(4, "four");
		assertEquals(5, list.size());
		assertEquals("four", list.get(4));
		list.add(5, "five");
		assertEquals(6, list.size());
		assertEquals("five", list.get(5));
		try {
			list.add(6, "six");
			assertEquals(7, list.size());
			assertEquals("six", list.get(6));
		} catch (Exception e) {
			fail();
		}

		// Use the statements above to help guide your test cases
		// for data structures: Start with an empty data structure, then
		// add an element and check the accessor method return values.
		// Then add another element and check again. Continue to keep checking
		// for special cases. For example, for an array-based list, you should
		// continue adding until you trigger a resize operation to make sure
		// the resize operation worked as expected.

		try {
			list.add(15, "fifteen");
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}

	}

	/**
	 * Test the output of the addLast behavior
	 */
	@Test
	public void testAddLast() {
		list.add(0, "one");
		assertEquals(1, list.size());
		assertEquals("one", list.get(0));
		assertFalse(list.isEmpty());
		list.add(1, "two");
		assertEquals(2, list.size());
		assertEquals("two", list.get(1));
		assertFalse(list.isEmpty());
		list.add(2, "three");
		assertEquals(3, list.size());
		assertEquals("three", list.get(2));
		list.add(3, "four");
		assertEquals("four", list.get(3));
		assertEquals(4, list.size());

		list.addLast("four-test");
		assertEquals("four-test", list.get(4));
		list.addLast("five-test");
		assertEquals("five-test", list.get(5));
		assertEquals(6, list.size());
	}

	/**
	 * Test the output of the last() behavior, including expected exceptions
	 */
	@Test
	public void testLast() {
		list.add(0, "one");
		assertEquals(1, list.size());
		assertEquals("one", list.get(0));
		assertFalse(list.isEmpty());
		list.add(1, "two");
		assertEquals(2, list.size());
		assertEquals("two", list.get(1));
		assertFalse(list.isEmpty());
		list.add(2, "three");
		assertEquals(3, list.size());
		assertEquals("three", list.get(2));
		list.add(3, "four");
		assertEquals("four", list.get(3));

		assertEquals("four", list.removeLast());
		assertEquals("three", list.last());
		assertEquals("three", list.removeLast());
		assertEquals("two", list.last());
		assertEquals("two", list.removeLast());
		assertEquals("one", list.last());
		assertEquals("one", list.removeLast());
		assertEquals(0, list.size());
	}

	/**
	 * Test the output of the addFirst behavior
	 */
	@Test
	public void testAddFirst() {
		list.add(0, "one");
		assertEquals(1, list.size());
		assertEquals("one", list.get(0));
		assertFalse(list.isEmpty());
		list.add(1, "two");
		assertEquals(2, list.size());
		assertEquals("two", list.get(1));
		assertFalse(list.isEmpty());
		list.add(2, "three");
		assertEquals(3, list.size());
		assertEquals("three", list.get(2));
		list.add(3, "four");
		assertEquals("four", list.get(3));
		assertEquals(4, list.size());
		list.addFirst("one-test");
		assertEquals("one-test", list.get(0));
		assertEquals("one", list.get(1));
		list.addFirst("two-test");
		assertEquals("two-test", list.get(0));
		assertEquals("one-test", list.get(1));
		assertEquals(6, list.size());

	}

	/**
	 * Test the output of the first() behavior, including expected exceptions
	 */
	@Test
	public void testFirst() {
		list.add(0, "one");
		assertEquals(1, list.size());
		assertEquals("one", list.get(0));
		assertFalse(list.isEmpty());
		list.add(1, "two");
		assertEquals(2, list.size());
		assertEquals("two", list.get(1));
		assertFalse(list.isEmpty());
		list.add(2, "three");
		assertEquals(3, list.size());
		assertEquals("three", list.get(2));
		list.add(3, "four");
		assertEquals("four", list.get(3));

		assertEquals("one", list.removeFirst());
		assertEquals("two", list.first());
		assertEquals("two", list.removeFirst());
		assertEquals("three", list.first());
		assertEquals("three", list.removeFirst());
		assertEquals("four", list.first());
		assertEquals("four", list.removeFirst());
		assertEquals(0, list.size());
	}

	/**
	 * Test the iterator behaviors, including expected exceptions
	 */
	@Test
	public void testIterator() {
		// Start with an empty list
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

		// Now add an element
		list.addLast("one");

		// Use accessor methods to check that the list is correct
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		assertEquals("one", list.get(0));
		list.add(1, "two");
		assertEquals(2, list.size());
		assertEquals("two", list.get(1));
		assertFalse(list.isEmpty());
		list.add(2, "three");
		assertEquals(3, list.size());
		assertEquals("three", list.get(2));
		list.add(3, "four");
		assertEquals("four", list.get(3));

		// Create an iterator for the list that has 1 element
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
	 * Test the output of the remove(index) behavior, including expected exceptions
	 */
	@Test
	public void testRemoveIndex() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		list.add(0, "one");
		assertEquals(1, list.size());
		assertEquals("one", list.get(0));
		assertFalse(list.isEmpty());
		list.add(1, "two");
		assertEquals(2, list.size());
		assertEquals("two", list.get(1));
		assertFalse(list.isEmpty());
		list.add(2, "three");
		assertEquals(3, list.size());
		assertEquals("three", list.get(2));
		list.add(2, "three-replaced");
		assertEquals(4, list.size());
		assertEquals("three-replaced", list.get(2));
		assertEquals("three", list.get(3));
		assertEquals(4, list.size());
		assertEquals("three-replaced", list.remove(2));
		assertEquals(3, list.size());
		assertEquals("one", list.remove(0));
		assertEquals("two", list.get(0));

		try {
			list.remove(6);
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}

	}

	/**
	 * Test the output of the removeFirst() behavior, including expected exceptions
	 */
	@Test
	public void testRemoveFirst() {
		list.add(0, "one");
		assertEquals(1, list.size());
		assertEquals("one", list.get(0));
		assertFalse(list.isEmpty());
		list.add(1, "two");
		assertEquals(2, list.size());
		assertEquals("two", list.get(1));
		assertFalse(list.isEmpty());
		list.add(2, "three");
		assertEquals(3, list.size());
		assertEquals("three", list.get(2));
		list.add(3, "four");
		assertEquals("four", list.get(3));

		assertEquals("one", list.removeFirst());
		assertEquals("two", list.get(0));
		assertEquals("two", list.removeFirst());
		assertEquals("three", list.get(0));
		assertEquals("three", list.removeFirst());
		assertEquals("four", list.get(0));
		assertEquals("four", list.removeFirst());
		assertEquals(0, list.size());

	}

	/**
	 * Test the output of the removeLast() behavior, including expected exceptions
	 */
	@Test
	public void testRemoveLast() {
		list.add(0, "one");
		assertEquals(1, list.size());
		assertEquals("one", list.get(0));
		assertFalse(list.isEmpty());
		list.add(1, "two");
		assertEquals(2, list.size());
		assertEquals("two", list.get(1));
		assertFalse(list.isEmpty());
		list.add(2, "three");
		assertEquals(3, list.size());
		assertEquals("three", list.get(2));
		list.add(3, "four");
		assertEquals("four", list.get(3));

		assertEquals("four", list.removeLast());
		assertEquals("three", list.get(2));
		assertEquals("three", list.removeLast());
		assertEquals("two", list.get(1));
		assertEquals("two", list.removeLast());
		assertEquals("one", list.get(0));
		assertEquals("one", list.removeLast());
		assertEquals(0, list.size());
	}

	/**
	 * Test the output of the set(index, e) behavior, including expected exceptions
	 */
	@Test
	public void testSet() {
		list.add(0, "one");
		assertEquals(1, list.size());
		assertEquals("one", list.get(0));
		assertFalse(list.isEmpty());
		list.add(1, "two");
		assertEquals(2, list.size());
		assertEquals("two", list.get(1));
		assertFalse(list.isEmpty());
		list.add(2, "three");
		assertEquals(3, list.size());
		assertEquals("three", list.get(2));
		list.add(3, "four");
		assertEquals("four", list.get(3));

		assertEquals("one", list.set(0, "one-replaced"));
		assertEquals("one-replaced", list.get(0));
		assertEquals("two", list.set(1, "two-replaced"));
		assertEquals("two-replaced", list.get(1));
		assertEquals("three", list.set(2, "three-replaced"));
		assertEquals("three-replaced", list.get(2));
		assertEquals("four", list.set(3, "four-replaced"));
		assertEquals("four-replaced", list.get(3));

		try {
			list.set(5, "five");
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}

	}
}
