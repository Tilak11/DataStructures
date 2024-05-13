package edu.ncsu.csc316.dsa.map.hashing;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for SeparateChainingHashMap Checks the expected outputs of the Map
 * abstract data type behaviors when using a separate chaining hash map data
 * structure
 *
 * @author Dr. King
 *
 */
public class SeparateChainingHashMapTest {

	private Map<Integer, String> map1;
	private Map<Integer, String> map2;
	private Map<Integer, String> map;

	/**
	 * Create a new instance of a separate chaining hash map before each test case
	 * executes
	 */
	@Before
	public void setUp() {
		// Use the "true" flag to indicate we are TESTING.
		// Remember that (when testing) alpha = 1, beta = 1, and prime = 7
		// based on our AbstractHashMap constructor.
		// That means you can draw the hash table by hand
		// if you use integer keys, since Integer.hashCode() = the integer value, itself
		// Finally, apply compression. For example:
		// for key = 1: h(1) = ( (1 * 1 + 1) % 7) % 7 = 2
		// for key = 2: h(2) = ( (1 * 2 + 1) % 7) % 7 = 3
		// for key = 3: h(3) = ( (1 * 3 + 1) % 7) % 7 = 4
		// for key = 4: h(4) = ( (1 * 4 + 1) % 7) % 7 = 5
		// for key = 5: h(5) = ( (1 * 5 + 1) % 7) % 7 = 6
		// for key = 6: h(6) = ( (1 * 6 + 1) % 7) % 7 = 0
		// etc.
		// Remember that our secondary map (an AVL tree) is a search
		// tree, which means the entries should be sorted in order within
		// that tree
		map1 = new SeparateChainingHashMap<Integer, String>();		
		map2 = new SeparateChainingHashMap<Integer, String>(7);
		map = new SeparateChainingHashMap<Integer, String>(7, true);
	}

	/**
	 * Test the output of the put(k,v) behavior
	 */
	@Test
	public void testPut() {
		// Testing map1 (default constructor)
		assertEquals(0, map.size());
		assertTrue(map1.isEmpty());
		assertNull(map1.put(1, "string1"));
		
		// Testing map2 (constructor with only capacity)
		assertEquals(0, map.size());
		assertTrue(map2.isEmpty());
		assertNull(map2.put(1, "string1"));
		
		// Testing map (Constructor for testing)
		assertEquals(0, map.size());
		assertTrue(map.isEmpty());
		assertNull(map.put(3, "string3"));

		// Since our entrySet method returns the entries in the table
		// from left to right, we can use the entrySet to check
		// that our values are in the correct order in the hash table.
		// Alternatively, you could implement a toString() method if you
		// want to check that the exact index/map of each bucket is correct
		Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
		assertEquals(3, (int) it.next().getKey()); // should be in a map in index 4

		assertNull(map.put(4, "string4"));
		assertEquals(2, map.size());
		assertFalse(map.isEmpty());
		it = map.entrySet().iterator();
		assertEquals(3, (int) it.next().getKey()); // should be in a map in index 4
		assertEquals(4, (int) it.next().getKey()); // should be in a map in index 5

		map = new SeparateChainingHashMap<Integer, String>(7, true);
		map.put(1, "s1");
		map.put(2, "s2");
		map.put(3, "s3");
		map.put(4, "s4");
		map.put(5, "s5");
		map.put(6, "s6");
		map.put(7, "s7");
		map.put(8, "s8");
		map.put(9, "s9");
		assertEquals(9, map.size());
		it = map.entrySet().iterator();
		assertTrue(it.hasNext());
		assertEquals("s6", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s7", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s1", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s8", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s2", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s9", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s3", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s4", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s5", it.next().getValue());
		assertFalse(it.hasNext());
		
		map = new SeparateChainingHashMap<Integer, String>(true);
		map.put(1, "s1");
		map.put(2, "s2");
		map.put(3, "s3");
		map.put(4, "s4");
		map.put(5, "s5");
		map.put(6, "s6");
		map.put(7, "s7");
		map.put(8, "s8");
		map.put(9, "s9");
		assertEquals(9, map.size());
		it = map.entrySet().iterator();
		assertTrue(it.hasNext());
		assertEquals("s6", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s7", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s1", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s8", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s2", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s9", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s3", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s4", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s5", it.next().getValue());
		assertFalse(it.hasNext());

	}

	/**
	 * Test the output of the get(k) behavior
	 */
	@Test
	public void testGet() {
		assertTrue(map.isEmpty());
		map.put(1, "s1");
		map.put(2, "s2");
		map.put(3, "s3");
		map.put(4, "s4");
		map.put(5, "s5");
		map.put(6, "s6");
		map.put(7, "s7");
		map.put(8, "s8");
		map.put(9, "s9");
		assertEquals(9, map.size());
		assertEquals("s1", map.get(1));
		assertEquals("s2", map.get(2));
		assertEquals("s3", map.get(3));
		assertEquals("s4", map.get(4));
		assertEquals("s5", map.get(5));
		assertEquals("s6", map.get(6));
		assertEquals("s7", map.get(7));
		assertEquals("s8", map.get(8));
		assertEquals("s9", map.get(9));
		assertNull(map.get(10));
		assertEquals("s7", map.put(7, "s7-update"));
		assertEquals("s7-update", map.get(7));

	}

	/**
	 * Test the output of the remove(k) behavior
	 */
	@Test
	public void testRemove() {
		assertTrue(map.isEmpty());
		map.put(1, "s1");
		map.put(2, "s2");
		map.put(3, "s3");
		map.put(4, "s4");
		map.put(5, "s5");
		map.put(6, "s6");
		map.put(7, "s7");
		assertEquals(7, map.size());
		
		assertNull(map.remove(9));
		assertEquals("s1", map.get(1));
		assertEquals("s1", map.remove(1));
		assertNull(map.get(1));
		assertEquals("s2", map.get(2));
		assertEquals("s2", map.remove(2));
		assertNull(map.get(2));
		assertEquals("s3", map.get(3));
		assertEquals("s3", map.remove(3));
		assertNull(map.get(3));
		assertEquals("s4", map.get(4));
		assertEquals("s4", map.remove(4));
		assertNull(map.get(4));
		assertEquals("s5", map.get(5));
		assertEquals("s5", map.remove(5));
		assertNull(map.get(5));
		assertEquals("s6", map.get(6));
		assertEquals("s6", map.remove(6));
		assertNull(map.get(6));
		assertEquals("s7", map.get(7));
		assertEquals("s7", map.remove(7));
		assertNull(map.get(7));
	}

	/**
	 * Test the output of the iterator() behavior, including expected exceptions
	 */
	@Test
	public void testIterator() {
		assertTrue(map.isEmpty());
		map.put(1, "s1");
		map.put(2, "s2");
		map.put(3, "s3");
		map.put(4, "s4");
		map.put(5, "s5");
		map.put(6, "s6");
		assertEquals(6, map.size());

		Iterator<Integer> it = map.iterator();
		assertTrue(it.hasNext());
		assertEquals(6, (int)it.next());
		assertTrue(it.hasNext());
		assertEquals(1, (int)it.next());
		assertTrue(it.hasNext());
		assertEquals(2, (int)it.next());
		assertTrue(it.hasNext());
		assertEquals(3, (int)it.next());
		assertTrue(it.hasNext());
		assertEquals(4, (int)it.next());
		assertTrue(it.hasNext());
		assertEquals(5, (int)it.next());
		assertFalse(it.hasNext());

	}

	/**
	 * Test the output of the entrySet() behavior
	 */
	@Test
	public void testEntrySet() {
		

		map.put(1, "s1");
		map.put(2, "s2");
		map.put(3, "s3");
		map.put(4, "s4");
		map.put(5, "s5");
		map.put(6, "s6");
		map.put(7, "s7");
		map.put(8, "s8");
		map.put(9, "s9");
		assertEquals(9, map.size());
		Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
		assertTrue(it.hasNext());
		assertEquals("s6", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s7", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s1", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s8", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s2", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s9", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s3", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s4", it.next().getValue());
		assertTrue(it.hasNext());
		assertEquals("s5", it.next().getValue());
		assertFalse(it.hasNext());
		
	}

	/**
	 * Test the output of the values() behavior
	 */
	@Test
	public void testValues() {
		assertTrue(map.isEmpty());
		map.put(1, "s1");
		map.put(2, "s2");
		map.put(3, "s3");
		map.put(4, "s4");
		map.put(5, "s5");
		map.put(6, "s6");
		assertEquals(6, map.size());

		Iterator<String> it = map.values().iterator();
		assertTrue(it.hasNext());
		assertEquals("s6", it.next());
		assertTrue(it.hasNext());
		assertEquals("s1", it.next());
		assertTrue(it.hasNext());
		assertEquals("s2", it.next());
		assertTrue(it.hasNext());
		assertEquals("s3", it.next());
		assertTrue(it.hasNext());
		assertEquals("s4", it.next());
		assertTrue(it.hasNext());
		assertEquals("s5", it.next());
		assertFalse(it.hasNext());

	
	}
}
