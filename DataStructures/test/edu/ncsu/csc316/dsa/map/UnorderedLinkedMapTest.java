package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.map.Map.Entry;

/**
 * Test class for UnorderedLinkedMap Checks the expected outputs of the Map
 * abstract data type behaviors when using an unordered link-based list data
 * structure that uses the move-to-front heuristic for self-organizing entries
 * based on access frequency
 *
 * @author Dr. King
 *
 */
public class UnorderedLinkedMapTest {

	/** Instance of UnorderedLinkedMap */
	private Map<Integer, String> map;

	/**
	 * Create a new instance of an unordered link-based map before each test case
	 * executes
	 */
	@Before
	public void setUp() {
		map = new UnorderedLinkedMap<Integer, String>();
	}

	/**
	 * Test the output of the put(k,v) behavior
	 */
	@Test
	public void testPut() {
		assertEquals(0, map.size());
		assertTrue(map.isEmpty());
		assertNull(map.put(3, "string3"));
		assertEquals("UnorderedLinkedMap[3]", map.toString());
		assertEquals(1, map.size());
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));
		assertFalse(map.isEmpty());
		assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
		assertEquals("string2", map.put(2, "string2-updated"));
		assertEquals("string1", map.put(1, "string1-updated"));
		assertEquals("string3", map.put(3, "string3-updated"));

	}

	/**
	 * Test the output of the get(k) behavior
	 */
	@Test
	public void testGet() {
		assertTrue(map.isEmpty());
		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));
		assertFalse(map.isEmpty());
		assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());

		assertEquals("string1", map.get(1));
		assertEquals("string2", map.get(2));
		assertEquals("string3", map.get(3));
		assertEquals("string4", map.get(4));
		assertEquals("string5", map.get(5));
		assertEquals("string2", map.put(2, "string2-updated"));
		assertEquals("string1", map.put(1, "string1-updated"));
		assertEquals("string3", map.put(3, "string3-updated"));
		assertEquals("string1-updated", map.get(1));
		assertEquals("string2-updated", map.get(2));
		assertEquals("string3-updated", map.get(3));

		assertEquals("UnorderedLinkedMap[3, 2, 1, 5, 4]", map.toString());

	}

	/**
	 * Test the output of the remove(k) behavior
	 */
	@Test
	public void testRemove() {
		assertTrue(map.isEmpty());
		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));
		assertFalse(map.isEmpty());
		assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
		assertNull(map.remove(6));
		assertEquals("string2", map.remove(2));
		assertEquals("UnorderedLinkedMap[1, 4, 5, 3]", map.toString());

	}

	/**
	 * Test the output of the iterator behavior, including expected exceptions
	 */
	@Test
	public void testIterator() {
		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));
		Iterator it = map.iterator();
		assertTrue(it.hasNext());
		assertEquals(1, it.next());
		assertTrue(it.hasNext());
		assertEquals(4, it.next());
		assertTrue(it.hasNext());
		assertEquals(2, it.next());
		assertTrue(it.hasNext());
		assertEquals(5, it.next());
		assertTrue(it.hasNext());
		assertEquals(3, it.next());
		assertFalse(it.hasNext());
		try {
			it.remove();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof UnsupportedOperationException);
		}

	}

	/**
	 * Test the output of the entrySet() behavior, including expected exceptions
	 */
	@Test
	public void testEntrySet() {
		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));
		Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
//		for(int i=1; i<=5; i++)
//		{System.out.println("k: "+it.next().getKey()+" v: "+it.next().getValue());
//		System.out.println("k: "+i+" v: "+map.get(i));
//
//		}
		assertTrue(it.hasNext());
		Entry<Integer, String> temp = it.next();
		assertEquals(Integer.valueOf(1), temp.getKey());
		assertEquals("string1", temp.getValue());

		assertTrue(it.hasNext());
		temp = it.next();
		assertEquals(Integer.valueOf(4), temp.getKey());
		assertEquals("string4", temp.getValue());

		assertTrue(it.hasNext());
		temp = it.next();
		assertEquals(Integer.valueOf(2), temp.getKey());
		assertEquals("string2", temp.getValue());

		assertTrue(it.hasNext());
		temp = it.next();
		assertEquals(Integer.valueOf(5), temp.getKey());
		assertEquals("string5", temp.getValue());

		assertTrue(it.hasNext());
		temp = it.next();
		assertEquals(Integer.valueOf(3), temp.getKey());
		assertEquals("string3", temp.getValue());

		try {
			it.remove();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof UnsupportedOperationException);
		}

	}

	/**
	 * Test the output of the values() behavior, including expected exceptions
	 */
	@Test
	public void testValues() {
		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));
		Iterator it = map.values().iterator();
		assertTrue(it.hasNext());
		assertEquals("string1", it.next());
		assertTrue(it.hasNext());
		assertEquals("string4", it.next());
		assertTrue(it.hasNext());
		assertEquals("string2", it.next());
		assertTrue(it.hasNext());
		assertEquals("string5", it.next());
		assertTrue(it.hasNext());
		assertEquals("string3", it.next());
		assertFalse(it.hasNext());
		try {
			it.remove();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof UnsupportedOperationException);
		}

	}
}
