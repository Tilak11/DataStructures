package edu.ncsu.csc316.dsa.priority_queue;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;

/**
 * Test class for HeapPriorityQueue Checks the expected outputs of the Priorty
 * Queue abstract data type behaviors when using a min-heap data structure
 *
 * @author Dr. King
 *
 */
public class HeapPriorityQueueTest {

	private PriorityQueue<Integer, String> heap;

	/**
	 * Create a new instance of a heap before each test case executes
	 */
	@Before
	public void setUp() {
		heap = new HeapPriorityQueue<Integer, String>();
	}

	/**
	 * Test the output of the insert(k,v) behavior
	 */
	@Test
	public void testInsert() {
		assertTrue(heap.isEmpty());
		assertTrue(heap.size() == 0);

		heap.insert(8, "eight");
		assertTrue(heap.size() == 1);
		heap.insert(9, "nine");
		assertTrue(heap.size() == 2);
		heap.insert(1, "one");
		assertTrue(heap.size() == 3);
		heap.insert(2, "two");
		assertTrue(heap.size() == 4);
		heap.insert(3, "three");
		assertTrue(heap.size() == 5);
		heap.insert(7, "seven");
		assertTrue(heap.size() == 6);
		assertFalse(heap.isEmpty());
		assertEquals(1, (int) heap.min().getKey());
		heap.deleteMin();
		assertEquals(2, (int) heap.min().getKey());

	}

	/**
	 * Test the output of the min behavior
	 */
	@Test
	public void testMin() {
		assertTrue(heap.isEmpty());
		assertTrue(heap.size() == 0);

		assertNull(heap.min());

		heap.insert(8, "eight");
		assertEquals(8, (int) heap.min().getKey());
		heap.insert(9, "nine");
		assertEquals(8, (int) heap.min().getKey());
		heap.insert(1, "one");
		assertEquals(1, (int) heap.min().getKey());
		heap.insert(2, "two");
		assertEquals(1, (int) heap.min().getKey());
		heap.insert(3, "three");
		assertEquals(1, (int) heap.min().getKey());
		heap.insert(7, "seven");
		assertEquals(1, (int) heap.min().getKey());
		heap.insert(0, "zero");
		assertEquals(0, (int) heap.min().getKey());
		assertEquals(7, heap.size());
		assertFalse(heap.isEmpty());

	}

	/**
	 * Test the output of the deleteMin behavior
	 */
	@Test
	public void deleteMin() {
		assertTrue(heap.isEmpty());
		assertEquals(0, heap.size());

		assertNull(heap.deleteMin());

		heap.insert(8, "eight");
		assertEquals(8, (int) heap.min().getKey());
		heap.insert(9, "nine");
		assertEquals(8, (int) heap.min().getKey());
		heap.insert(1, "one");
		assertEquals(1, (int) heap.min().getKey());
		heap.insert(2, "two");
		assertEquals(1, (int) heap.min().getKey());
		heap.insert(3, "three");
		assertEquals(1, (int) heap.min().getKey());
		heap.insert(7, "seven");
		assertEquals(1, (int) heap.min().getKey());
		heap.insert(0, "zero");
		assertEquals(0, (int) heap.min().getKey());
		assertEquals(7, heap.size());

		heap.deleteMin();
		assertEquals(1, (int) heap.min().getKey());
		heap.deleteMin();
		assertEquals(2, (int) heap.min().getKey());
		heap.deleteMin();
		assertEquals(3, (int) heap.min().getKey());
		heap.deleteMin();
		assertEquals(7, (int) heap.min().getKey());
		heap.deleteMin();
		assertEquals(8, (int) heap.min().getKey());
		heap.deleteMin();
		assertEquals(9, (int) heap.min().getKey());
		assertFalse(heap.isEmpty());
	}

	/**
	 * Test the output of the heap behavior when using arbitrary key objects to
	 * represent priorities
	 */
	@Test
	public void testStudentHeap() {
		PriorityQueue<Student, String> sHeap = new HeapPriorityQueue<Student, String>(new StudentIDComparator());
		Student s1 = new Student("J", "K", 1, 1, 1, "jk1");
		Student s2 = new Student("J", "S", 2, 1, 2, "js2");
		Student s3 = new Student("S", "H", 3, 1, 3, "sh3");
		Student s4 = new Student("J", "J", 4, 1, 4, "jj4");
		Student s5 = new Student("L", "B", 5, 1, 5, "lb5");

		assertTrue(sHeap.isEmpty());
		assertEquals(0, sHeap.size());
		sHeap.insert(s5, "lb5");
		assertEquals(1, sHeap.size());
		sHeap.insert(s1, "jk1");
		assertEquals(2, sHeap.size());
		sHeap.insert(s3, "sh3");
		assertEquals(3, sHeap.size());
		sHeap.insert(s2, "js2");
		assertEquals(4, sHeap.size());
		sHeap.insert(s4, "jj4");
		assertEquals(5, sHeap.size());

		assertEquals("jk1", sHeap.min().getKey().getUnityID());
		sHeap.deleteMin();
		assertEquals("js2", sHeap.min().getKey().getUnityID());
		sHeap.deleteMin();
		assertEquals("sh3", sHeap.min().getKey().getUnityID());
		sHeap.deleteMin();
		assertEquals("jj4", sHeap.min().getKey().getUnityID());
		sHeap.deleteMin();
		assertEquals("lb5", sHeap.min().getKey().getUnityID());
		sHeap.deleteMin();

		assertEquals(0, sHeap.size());

	}
}