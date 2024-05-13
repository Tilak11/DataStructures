package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.io.StudentReader;
/**
 * Test InsertionSorter
 * @author Tilak
 *
 */
public class InsertionSorterTest {

	/** array of ascending integers */
	private Integer[] dataAscending = { 1, 2, 3, 4, 5 };
	/** array of descending integers */
	private Integer[] dataDescending = { 5, 4, 3, 2, 1 };
	/** array of random integers */
	private Integer[] dataRandom = { 4, 1, 5, 3, 2 };
	/** Instance of InsertionSorter */
	private InsertionSorter<Integer> integerSorter;
	/** Instance of InsertionSorter */
	private InsertionSorter<Student> studentSorter;

	/**
	 * Setup to be done before test
	 */
	@Before
	public void setUp() {
		integerSorter = new InsertionSorter<Integer>();
		studentSorter = new InsertionSorter<Student>();
	}

	/**
	 * Test InsertionSorter with integers
	 */
	@Test
	public void testSortIntegers() {
		integerSorter.sort(dataAscending);
		assertEquals(Integer.valueOf(1), dataAscending[0]);
		assertEquals(Integer.valueOf(2), dataAscending[1]);
		assertEquals(Integer.valueOf(3), dataAscending[2]);
		assertEquals(Integer.valueOf(4), dataAscending[3]);
		assertEquals(Integer.valueOf(5), dataAscending[4]);

		integerSorter.sort(dataDescending);
		assertEquals(Integer.valueOf(1), dataDescending[0]);
		assertEquals(Integer.valueOf(2), dataDescending[1]);
		assertEquals(Integer.valueOf(3), dataDescending[2]);
		assertEquals(Integer.valueOf(4), dataDescending[3]);
		assertEquals(Integer.valueOf(5), dataDescending[4]);

		integerSorter.sort(dataRandom);
		assertEquals(Integer.valueOf(1), dataRandom[0]);
		assertEquals(Integer.valueOf(2), dataRandom[1]);
		assertEquals(Integer.valueOf(3), dataRandom[2]);
		assertEquals(Integer.valueOf(4), dataRandom[3]);
		assertEquals(Integer.valueOf(5), dataRandom[4]);
	}

	/**
	 * Test InsertionSorter with student objects
	 */
	@Test
	public void testSortStudent() {
		
		Student[] contents = StudentReader.readInputAsArray("input/student_descendingID.csv");
		
		//Before sort
		assertEquals("Falcon", contents[0].getLast());
		assertEquals("Bauman", contents[1].getLast());
		assertEquals("Greco", contents[2].getLast());
		assertEquals("Dick", contents[3].getLast());
		assertEquals("Mclendon", contents[4].getLast());
		assertEquals("Pease", contents[12].getLast());
		assertEquals("Mott", contents[13].getLast());
		assertEquals("Marsh", contents[14].getLast());
		assertEquals("Michael", contents[15].getLast());
		
		studentSorter.sort(contents);
		
		//after sort
		assertEquals("Bauman", contents[0].getLast());
		assertEquals("Carrion", contents[1].getLast());
		assertEquals("Dick", contents[2].getLast());
		assertEquals("Falcon", contents[3].getLast());
		assertEquals("Greco", contents[4].getLast());
		assertEquals("Seibert", contents[12].getLast());
		assertEquals("Terrell", contents[13].getLast());
		assertEquals("Woodbury", contents[14].getLast());
		assertEquals("Worth", contents[15].getLast());
		
	}
}
