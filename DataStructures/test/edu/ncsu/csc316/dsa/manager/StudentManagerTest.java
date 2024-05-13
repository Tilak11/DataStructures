package edu.ncsu.csc316.dsa.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentGPAComparator;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;
import edu.ncsu.csc316.dsa.sorter.CountingSorter;
import edu.ncsu.csc316.dsa.sorter.InsertionSorter;
import edu.ncsu.csc316.dsa.sorter.MergeSorter;
import edu.ncsu.csc316.dsa.sorter.QuickSorter;
import edu.ncsu.csc316.dsa.sorter.RadixSorter;
import edu.ncsu.csc316.dsa.sorter.SelectionSorter;
import edu.ncsu.csc316.dsa.sorter.Sorter;

/**
 * Tests StudentManager
 * 
 * @author Tilak
 *
 */
public class StudentManagerTest {

	/** Test StudentManager instance */
	private StudentManager sm;
	/** Test StudentManager instance */
	private StudentManager sm2;
	/** Test StudentManager instance */
	private StudentManager sm3;
	/** Test StudentManager instance */
	private StudentManager sm4;
	/** Test StudentManager instance */
	private StudentManager sm5;
	/** Test StudentManager instance */
	private StudentManager sm6;
	/** Test StudentManager instance */
	private StudentManager sm7;


	/**
	 * Setup to be done before test
	 */
	@Before
	public void setUp() {
		sm = new StudentManager("input/student_ascendingID.csv");
		StudentGPAComparator comp1 = new StudentGPAComparator();
		Sorter<Student> customSorter = new InsertionSorter<Student>(comp1);
		sm2 = new StudentManager("input/student_ascendingID.csv", customSorter);
		StudentIDComparator comp2 = new StudentIDComparator();
		Sorter<Student> customSorter2 = new SelectionSorter<Student>(comp2);
		sm3 = new StudentManager("input/student_descendingID.csv", customSorter2);
		Sorter<Student> customSorter3 = new RadixSorter();
		sm4 = new StudentManager("input/student_descendingID.csv", customSorter3);
		Sorter<Student> customSorter4 = new CountingSorter();
		sm5 = new StudentManager("input/student_descendingID.csv", customSorter4);
		Sorter<Student> customSorter5 = new MergeSorter<Student>(comp2);
		sm6 = new StudentManager("input/student_descendingID.csv", customSorter5);
		Sorter<Student> customSorter6 = new QuickSorter<Student>(comp2);
		sm7 = new StudentManager("input/student_descendingID.csv", customSorter6);
	}

	/**
	 * Test sort() method of StudentManager
	 */
	@Test
	public void testSort() {
		// Tests default StudentManager() so will be sorted by natural order i.e lastname
		Student[] sorted = sm.sort();
		assertEquals("Tanner", sorted[0].getFirst());
		assertEquals("Roxann", sorted[1].getFirst());
		assertEquals("Shanti", sorted[2].getFirst());
		assertEquals("Dante", sorted[3].getFirst());
		assertEquals("Cristine", sorted[4].getFirst());
		assertEquals("Ara", sorted[5].getFirst());
		assertEquals("Lewis", sorted[6].getFirst());
		assertEquals("Charlene", sorted[7].getFirst());
		assertEquals("Amber", sorted[8].getFirst());
		assertEquals("Lacie", sorted[9].getFirst());
		assertEquals("Idalia", sorted[10].getFirst());
		assertEquals("Tyree", sorted[11].getFirst());
		assertEquals("Evelin", sorted[12].getFirst());
		assertEquals("Alicia", sorted[13].getFirst());
		assertEquals("Loise", sorted[14].getFirst());
		assertEquals("Nichole", sorted[15].getFirst());

		// Tested using StudentGPAComparator
		Student[] customSorted = sm2.sort();
		assertEquals("Nichole", customSorted[0].getFirst());
		assertEquals("Alicia", customSorted[1].getFirst());
		assertEquals("Charlene", customSorted[2].getFirst());
		assertEquals("Cristine", customSorted[3].getFirst());
		assertEquals("Dante", customSorted[4].getFirst());
		assertEquals("Tyree", customSorted[12].getFirst());
		assertEquals("Evelin", customSorted[13].getFirst());
		assertEquals("Shanti", customSorted[14].getFirst());
		assertEquals("Lewis", customSorted[15].getFirst());

		// Tested using StudentIDComparator
		Student[] customSorted2 = sm3.sort();
		assertEquals("Amber", customSorted2[0].getFirst());
		assertEquals("Ara", customSorted2[1].getFirst());
		assertEquals("Lacie", customSorted2[2].getFirst());
		assertEquals("Idalia", customSorted2[3].getFirst());
		assertEquals("Evelin", customSorted2[4].getFirst());
		assertEquals("Shanti", customSorted2[12].getFirst());
		assertEquals("Cristine", customSorted2[13].getFirst());
		assertEquals("Tanner", customSorted2[14].getFirst());
		assertEquals("Dante", customSorted2[15].getFirst());

		// Tested using RadixSorter
		Student[] customSorted3 = sm4.sort();
		
		assertEquals("Amber", customSorted3[0].getFirst());
		assertEquals("Ara", customSorted3[1].getFirst());
		assertEquals("Lacie", customSorted3[2].getFirst());
		assertEquals("Idalia", customSorted3[3].getFirst());
		assertEquals("Evelin", customSorted3[4].getFirst());
		assertEquals("Shanti", customSorted3[12].getFirst());
		assertEquals("Cristine", customSorted3[13].getFirst());
		assertEquals("Tanner", customSorted3[14].getFirst());
		assertEquals("Dante", customSorted3[15].getFirst());


		// Tested using CountingSorter
		Student[] customSorted4 = sm5.sort();
		assertEquals("Amber", customSorted4[0].getFirst());
		assertEquals("Ara", customSorted4[1].getFirst());
		assertEquals("Lacie", customSorted4[2].getFirst());
		assertEquals("Idalia", customSorted4[3].getFirst());
		assertEquals("Evelin", customSorted4[4].getFirst());
		assertEquals("Shanti", customSorted4[12].getFirst());
		assertEquals("Cristine", customSorted4[13].getFirst());
		assertEquals("Tanner", customSorted4[14].getFirst());
		assertEquals("Dante", customSorted4[15].getFirst());
		
		//Tested using MergeSorter
		Student[] customSorted5 = sm6.sort();
		assertEquals("Amber", customSorted5[0].getFirst());
		assertEquals("Ara", customSorted5[1].getFirst());
		assertEquals("Lacie", customSorted5[2].getFirst());
		assertEquals("Idalia", customSorted5[3].getFirst());
		assertEquals("Evelin", customSorted5[4].getFirst());
		assertEquals("Shanti", customSorted5[12].getFirst());
		assertEquals("Cristine", customSorted5[13].getFirst());
		assertEquals("Tanner", customSorted5[14].getFirst());
		assertEquals("Dante", customSorted5[15].getFirst());
		
		//Tested using QuickSorter
		Student[] customSorted6 = sm7.sort();
		assertEquals("Amber", customSorted6[0].getFirst());
		assertEquals("Ara", customSorted6[1].getFirst());
		assertEquals("Lacie", customSorted6[2].getFirst());
		assertEquals("Idalia", customSorted6[3].getFirst());
		assertEquals("Evelin", customSorted6[4].getFirst());
		assertEquals("Shanti", customSorted6[12].getFirst());
		assertEquals("Cristine", customSorted6[13].getFirst());
		assertEquals("Tanner", customSorted6[14].getFirst());
		assertEquals("Dante", customSorted6[15].getFirst());

	}

}
