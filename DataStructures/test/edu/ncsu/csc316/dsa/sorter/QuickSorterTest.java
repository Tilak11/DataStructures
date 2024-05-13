package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.io.StudentReader;

/**
 * Test QuickSorter
 * 
 * @author Tilak
 *
 */
public class QuickSorterTest {

	/** array of ascending integers */
	private Integer[] dataAscending = { 1, 2, 3, 4, 5 };
	/** array of descending integers */
	private Integer[] dataDescending = { 5, 4, 3, 2, 1 };
	/** array of random integers */
	private Integer[] dataRandom = { 4, 1, 5, 3, 2 };
	/** array of ascending integers */
	private Integer[] dataAscending2 = { 1, 2, 3, 4, 5 };
	/** array of descending integers */
	private Integer[] dataDescending2 = { 5, 4, 3, 2, 1 };
	/** array of random integers */
	private Integer[] dataRandom2 = { 4, 1, 5, 3, 2 };
	/** Instance of QuickSorter */
	private QuickSorter<Integer> integerSorter;
	/** Instance of QuickSorter */
	private QuickSorter<Student> studentSorter;
	/** Instance of QuickSorter */
	private QuickSorter<Integer> integerSorter2;
	/** Instance of QuickSorter */
	private QuickSorter<Student> studentSorter2;

	/**
	 * Setup to be done before test
	 */
	@Before
	public void setUp() {
		integerSorter = new QuickSorter<Integer>(QuickSorter.FIRST_ELEMENT_SELECTOR);
		studentSorter = new QuickSorter<Student>(QuickSorter.LAST_ELEMENT_SELECTOR);
		integerSorter2 = new QuickSorter<Integer>(QuickSorter.MIDDLE_ELEMENT_SELECTOR);
		studentSorter2 = new QuickSorter<Student>();
	}

	/**
	 * Test QuickSorter with integers
	 */
	@Test
	public void testSortIntegers() {
		// Tests using FIRST_ELEMENT_SELECTOR
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

		// Tests using MIDDLE_ELEMENT_SELECTOR

		integerSorter2.sort(dataAscending2);
		assertEquals(Integer.valueOf(1), dataAscending[0]);
		assertEquals(Integer.valueOf(2), dataAscending[1]);
		assertEquals(Integer.valueOf(3), dataAscending[2]);
		assertEquals(Integer.valueOf(4), dataAscending[3]);
		assertEquals(Integer.valueOf(5), dataAscending[4]);

		integerSorter2.sort(dataDescending2);
		assertEquals(Integer.valueOf(1), dataDescending[0]);
		assertEquals(Integer.valueOf(2), dataDescending[1]);
		assertEquals(Integer.valueOf(3), dataDescending[2]);
		assertEquals(Integer.valueOf(4), dataDescending[3]);
		assertEquals(Integer.valueOf(5), dataDescending[4]);

		integerSorter2.sort(dataRandom2);
		assertEquals(Integer.valueOf(1), dataRandom[0]);
		assertEquals(Integer.valueOf(2), dataRandom[1]);
		assertEquals(Integer.valueOf(3), dataRandom[2]);
		assertEquals(Integer.valueOf(4), dataRandom[3]);
		assertEquals(Integer.valueOf(5), dataRandom[4]);
	}

	/**
	 * Test QuickSorter with student objects
	 */
	@Test
	public void testSortStudent() {

		Student[] contents = StudentReader.readInputAsArray("input/student_descendingID.csv");

		// Tests using LAST_ELEMENT_SELECTOR

		// Before sort
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

		// after sort
		assertEquals("Bauman", contents[0].getLast());
		assertEquals("Carrion", contents[1].getLast());
		assertEquals("Dick", contents[2].getLast());
		assertEquals("Falcon", contents[3].getLast());
		assertEquals("Greco", contents[4].getLast());
		assertEquals("Seibert", contents[12].getLast());
		assertEquals("Terrell", contents[13].getLast());
		assertEquals("Woodbury", contents[14].getLast());
		assertEquals("Worth", contents[15].getLast());

		// Tests using RANDOM_ELEMENT_SELECTOR

		Student[] content = StudentReader.readInputAsArray("input/student_descendingID.csv");
		// Before sort
		assertEquals("Falcon", content[0].getLast());
		assertEquals("Bauman", content[1].getLast());
		assertEquals("Greco", content[2].getLast());
		assertEquals("Dick", content[3].getLast());
		assertEquals("Mclendon", content[4].getLast());
		assertEquals("Pease", content[12].getLast());
		assertEquals("Mott", content[13].getLast());
		assertEquals("Marsh", content[14].getLast());
		assertEquals("Michael", content[15].getLast());

		studentSorter2.sort(content);

		// after sort
		assertEquals("Bauman", content[0].getLast());
		assertEquals("Carrion", content[1].getLast());
		assertEquals("Dick", content[2].getLast());
		assertEquals("Falcon", content[3].getLast());
		assertEquals("Greco", content[4].getLast());
		assertEquals("Seibert", content[12].getLast());
		assertEquals("Terrell", content[13].getLast());
		assertEquals("Woodbury", content[14].getLast());
		assertEquals("Worth", content[15].getLast());

	}
}
