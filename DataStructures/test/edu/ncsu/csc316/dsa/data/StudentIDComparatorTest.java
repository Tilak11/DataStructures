package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Tests StudentIDComparator
 * @author Tilak
 *
 */
public class StudentIDComparatorTest {

	/** Test student object */
	private Student sOne;
	/** Test student object */
	private Student sTwo;
	/** Test student object */
	private Student sThree;
	/** Test student object */
	private Student sFour;
	/** Test student object */
	private Student sFive;
	/** Instance of StudentIDComparator */
	private StudentIDComparator comparator;

	/**
	 * Setup to be done before test
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");

		comparator = new StudentIDComparator();
	}
	
	/**
	 * Tests compare method of comparator
	 */
	@Test
	public void testCompare() {
		assertTrue(comparator.compare(sOne, sTwo) < 0);
		assertFalse(comparator.compare(sTwo, sOne) < 0);
		assertTrue(comparator.compare(sOne, sThree) < 0);
		assertTrue(comparator.compare(sOne, sFour) < 0);
		assertTrue(comparator.compare(sFive, sTwo) > 0);
		assertFalse(comparator.compare(sFour, sTwo) < 0);
		
		
	}


}
