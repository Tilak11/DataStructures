package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.map.Map.Entry;

/**
 * Test class for BinarySearchTreeMap Checks the expected outputs of the Map and
 * Tree abstract data type behaviors when using an linked binary tree data
 * structure
 *
 * @author Dr. King
 *
 */
public class BinarySearchTreeMapTest {

	/** Instance of BinarySearchTree */
	private BinarySearchTreeMap<Integer, String> tree;

	/**
	 * Create a new instance of a binary search tree map before each test case
	 * executes
	 */
	@Before
	public void setUp() {
		tree = new BinarySearchTreeMap<Integer, String>();
	}

	/**
	 * Test the output of the put(k,v) behavior
	 */
	@Test
	public void testPut() {
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());
		tree.put(1, "one");
		assertEquals(1, tree.size());
		assertFalse(tree.isEmpty());
		assertEquals(1, (int) tree.root().getElement().getKey());

		// adding to right
		assertNull(tree.right(tree.root()).getElement());
		tree.put(2, "two");
		assertNotNull(tree.right(tree.root()).getElement());
		assertEquals("two", tree.right(tree.root()).getElement().getValue());

		// addding to left
		assertNull(tree.left(tree.root()).getElement());
		tree.put(-1, "minus");
		assertNotNull(tree.left(tree.root()).getElement());
		assertEquals("minus", tree.left(tree.root()).getElement().getValue());

		// adding to right of '2'
		assertNull(tree.right(tree.right(tree.root())).getElement());
		tree.put(4, "four");
		assertNotNull(tree.right(tree.right(tree.root())).getElement());
		assertEquals("four", tree.right(tree.right(tree.root())).getElement().getValue());

	}

	/**
	 * Test the output of the get(k) behavior
	 */
	@Test
	public void testGet() {
		tree.put(1, "one");
		tree.put(2, "two");
		tree.put(3, "three");
		tree.put(4, "four");
		assertEquals(4, tree.size());
		assertEquals("one", tree.get(1));
		assertEquals("two", tree.get(2));
		assertEquals("three", tree.get(3));
		assertEquals("four", tree.get(4));
		assertNull(tree.get(5));

	}

	/**
	 * Test the output of the remove(k) behavior
	 */
	@Test
	public void testRemove() {
		tree.put(1, "one");
		assertEquals(1, tree.size());

		assertNull(tree.remove(10));
		assertEquals(1, tree.size());

		assertEquals("one", tree.remove(1));
		assertEquals(0, tree.size());
		tree.put(50, "50");
		tree.put(0, "0");
		tree.put(100, "100");
		tree.put(25, "25");
		tree.put(75, "75");
		tree.put(125, "125");
		tree.put(40, "40");

		assertEquals(tree.remove(50), "50");
		assertEquals(tree.remove(0), "0");
		assertEquals(tree.remove(100), "100");
		assertEquals(tree.remove(25), "25");
		assertEquals(tree.remove(75), "75");
		assertEquals(tree.remove(125), "125");
		assertEquals(tree.remove(40), "40");

	}

	/**
	 * Tests entrySet()
	 */
	@Test
	public void testEntrySet() {
		assertTrue(tree.isEmpty());
		tree.put(4, "four");
		tree.put(2, "two");
		tree.put(5, "five");
		tree.put(7, "seven");
		tree.put(9, "nine");
		tree.put(10, "ten");
		Iterator<Entry<Integer, String>> it = tree.entrySet().iterator();
		assertTrue(it.hasNext());
		assertEquals(2, (int) it.next().getKey());
		assertTrue(it.hasNext());
		assertEquals(4, (int) it.next().getKey());
		assertTrue(it.hasNext());
		assertEquals(5, (int) it.next().getKey());
		assertTrue(it.hasNext());
		assertEquals(7, (int) it.next().getKey());
		assertTrue(it.hasNext());
		assertEquals(9, (int) it.next().getKey());
		assertTrue(it.hasNext());
		assertEquals(10, (int) it.next().getKey());
		assertFalse(it.hasNext());

	}

	/**
	 * Tests toString()
	 */
	@Test
	public void testToString() {
		assertTrue(tree.isEmpty());
		tree.put(4, "four");
		tree.put(2, "two");
		tree.put(5, "five");
		tree.put(7, "seven");
		tree.put(9, "nine");
		tree.put(10, "ten");
		assertEquals("key: 2 value: two\n" + "key: 4 value: four\n" + "key: 5 value: five\n" + "key: 7 value: seven\n"
				+ "key: 9 value: nine\n" + "key: 10 value: ten\n", tree.toString());

	}
}
