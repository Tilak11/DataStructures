package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;

/**
 * Test class for SkipListMap Checks the expected outputs of the Map abstract
 * data type behaviors when using a sorted array-based data structure that uses
 * binary search to locate entries based on the key of the entry
 *
 * @author Tilak Patel
 *
 */
public class SkipListMapTest {

	/** Instance of SkipListMap*/
	private Map<Integer, String> map;
	/** Instance of SkipListMap*/
	private Map<Student, Integer> studentMap;

	/**
	 * Create a new instance of a search table map before each test case executes
	 */
	@Before
	public void setUp() {
		map = new SkipListMap<Integer, String>();
		studentMap = new SkipListMap<Student, Integer>();
	}

	/**
	 * Test the output of the put(k,v) behavior
	 */
	@Test
	public void testPut() {
		assertEquals(0, map.size());
		assertTrue(map.isEmpty());
		assertNull(map.put(3, "string3"));
		assertEquals("SkipListMap[3]", map.toString());
		assertEquals(1, map.size());
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));
		assertFalse(map.isEmpty());
		assertEquals("SkipListMap[1, 2, 3, 4, 5]", map.toString());
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

		assertEquals("SkipListMap[1, 2, 3, 4, 5]", map.toString());

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
		assertEquals("SkipListMap[1, 2, 3, 4, 5]", map.toString());
		assertNull(map.remove(7));
		assertEquals("string2", map.remove(2));
		assertEquals("SkipListMap[1, 3, 4, 5]", map.toString());

	}

	/**
	 * Tests Map abstract data type behaviors to ensure the behaviors work as
	 * expected when using arbitrary objects as keys
	 */
	@Test
	public void testStudentMap() {
		Student s1 = new Student("J", "K", 31, 0, 0, "jk");
		Student s2 = new Student("J", "S", 12, 0, 0, "js");
		Student s3 = new Student("S", "H", 23, 0, 0, "sh");
		Student s4 = new Student("J", "J", 4, 0, 0, "jj");
		Student s5 = new Student("L", "B", 65, 0, 0, "lb");

		// Suggestions: since search table map keys are Comparable,
		// make sure the search table works with Comparable objects like Students

		StudentIDComparator comp = new StudentIDComparator();
		studentMap = new SkipListMap<Student, Integer>(comp);

		assertNull(studentMap.put(s1, 1));
		assertNull(studentMap.put(s2, 2));
		assertNull(studentMap.put(s3, 3));
		assertNull(studentMap.put(s4, 4));
		assertNull(studentMap.put(s5, 5));

		Iterator<Integer> it = studentMap.values().iterator();
		assertEquals(4, (int) it.next());
		assertEquals(2, (int) it.next());
		assertEquals(3, (int) it.next());
		assertEquals(1, (int) it.next());
		assertEquals(5, (int) it.next());

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
		assertEquals(2, it.next());
		assertTrue(it.hasNext());
		assertEquals(3, it.next());
		assertTrue(it.hasNext());
		assertEquals(4, it.next());
		assertTrue(it.hasNext());
		assertEquals(5, it.next());
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

		Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
		assertTrue(it.hasNext());
		Map.Entry<Integer, String> entry = it.next();
		assertEquals(1, (int) (entry.getKey()));
		assertEquals("string1", (String) (entry.getValue()));
		entry = it.next();
		assertEquals(2, (int) (entry.getKey()));
		assertEquals("string2", (String) (entry.getValue()));
		entry = it.next();
		assertEquals(3, (int) (entry.getKey()));
		assertEquals("string3", (String) (entry.getValue()));
		entry = it.next();
		assertEquals(4, (int) (entry.getKey()));
		assertEquals("string4", (String) (entry.getValue()));
		entry = it.next();
		assertEquals(5, (int) (entry.getKey()));
		assertEquals("string5", (String) (entry.getValue()));
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

		Iterator<String> it = map.values().iterator();
		assertTrue(it.hasNext());
		assertEquals("string1", it.next());
		assertTrue(it.hasNext());
		assertEquals("string2", it.next());
		assertTrue(it.hasNext());
		assertEquals("string3", it.next());
		assertTrue(it.hasNext());
		assertEquals("string4", it.next());
		assertTrue(it.hasNext());
		assertEquals("string5", it.next());
		assertFalse(it.hasNext());
		try {
			it.remove();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof UnsupportedOperationException);
		}

	}
}
