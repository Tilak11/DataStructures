package edu.ncsu.csc316.dsa.set;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for TreeSet Checks the expected outputs of the Set abstract data
 * type behaviors when using a balanced search tree data structure
 *
 * @author Dr. King
 *
 */
public class TreeSetTest {

	private Set<Integer> set;

	/**
	 * Create a new instance of a tree-based set before each test case executes
	 */
	@Before
	public void setUp() {
		set = new TreeSet<Integer>();
	}

	/**
	 * Test the output of the add behavior
	 */
	@Test
	public void testAdd() {
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());

		set.add(5);
		assertEquals(1, set.size());
		assertFalse(set.isEmpty());
		set.add(6);
		assertEquals(2, set.size());
		assertFalse(set.isEmpty());
		set.add(7);
		assertEquals(3, set.size());
		assertFalse(set.isEmpty());
		set.add(8);
		assertEquals(4, set.size());
		assertFalse(set.isEmpty());
		set.add(9);
		assertEquals(5, set.size());
		assertFalse(set.isEmpty());

	}

	/**
	 * Test the output of the contains behavior
	 */
	@Test
	public void testContains() {
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());
		set.add(5);
		set.add(10);
		set.add(15);
		set.add(20);
		set.add(25);
		assertEquals(5, set.size());
		assertTrue(set.contains(5));
		assertTrue(set.contains(10));
		assertTrue(set.contains(15));
		assertTrue(set.contains(20));
		assertTrue(set.contains(25));
		assertFalse(set.contains(50));
		assertFalse(set.contains(1000));

	}

	/**
	 * Test the output of the remove behavior
	 */
	@Test
	public void testRemove() {
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());
		set.add(5);
		set.add(10);
		set.add(15);
		set.add(20);
		set.add(25);
		assertEquals(5, set.size());
		assertTrue(set.contains(5));
		set.remove(5);
		assertFalse(set.contains(5));
		assertEquals(4, set.size());
		assertTrue(set.contains(10));
		set.remove(10);
		assertFalse(set.contains(10));
		assertEquals(3, set.size());
		assertTrue(set.contains(15));
		set.remove(15);
		assertFalse(set.contains(15));
		assertEquals(2, set.size());
		assertTrue(set.contains(20));
		set.remove(20);
		assertFalse(set.contains(20));
		assertEquals(1, set.size());
		assertTrue(set.contains(25));
		set.remove(25);
		assertFalse(set.contains(25));
		assertEquals(0, set.size());

	}

	/**
	 * Test the output of the retainAll behavior
	 */
	@Test
	public void testRetainAll() {
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());
		set.add(5);
		set.add(10);
		set.add(15);
		set.add(20);
		set.add(25);
		assertEquals(5, set.size());

		Set<Integer> other = new TreeSet<Integer>();
		other.add(10);
		other.add(20);
		other.add(30);

		assertTrue(set.contains(5));
		assertTrue(set.contains(15));
		assertTrue(set.contains(25));
		set.retainAll(other);
		assertEquals(2, set.size());
		assertFalse(set.contains(5));
		assertFalse(set.contains(15));
		assertFalse(set.contains(25));

	}

	/**
	 * Test the output of the removeAll behavior
	 */
	@Test
	public void testRemoveAll() {
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());
		set.add(5);
		set.add(10);
		set.add(15);
		set.add(20);
		set.add(25);
		assertEquals(5, set.size());

		Set<Integer> other = new TreeSet<Integer>();
		other.add(10);
		other.add(20);
		other.add(30);

		set.removeAll(other);
		assertEquals(3, set.size());
		assertFalse(set.contains(10));
		assertFalse(set.contains(20));

	}

	/**
	 * Test the output of the addAll behavior
	 */
	@Test
	public void testAddAll() {
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());
		set.add(5);
		set.add(10);
		set.add(15);
		set.add(20);
		set.add(25);
		assertEquals(5, set.size());

		Set<Integer> other = new TreeSet<Integer>();
		other.add(30);
		other.add(40);
		other.add(50);

		assertFalse(set.contains(30));
		assertFalse(set.contains(40));
		assertFalse(set.contains(50));
		set.addAll(other);
		assertEquals(8, set.size());
		assertTrue(set.contains(30));
		assertTrue(set.contains(40));
		assertTrue(set.contains(50));

	}

	/**
	 * Test the output of the iterator behavior
	 */
	@Test
	public void testIterator() {
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());
		set.add(5);
		set.add(10);
		set.add(15);
		set.add(20);
		set.add(25);
		assertEquals(5, set.size());

		Iterator<Integer> it = set.iterator();
		assertTrue(it.hasNext());
		assertEquals(5, (int) it.next());
		assertTrue(it.hasNext());
		assertEquals(10, (int) it.next());
		assertTrue(it.hasNext());
		assertEquals(15, (int) it.next());
		assertTrue(it.hasNext());
		assertEquals(20, (int) it.next());
		assertTrue(it.hasNext());
		assertEquals(25, (int) it.next());
		assertFalse(it.hasNext());
	}
}
