package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Tests Student object
 * @author Tilak
 *
 */
public class StudentTest {

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
	}

	/**
	 * Testing setters
	 */
	@Test
	public void testSetFirst() {
		sOne.setFirst("newOne");
		assertEquals("newOne", sOne.getFirst());
	}

	/**
	 * Testing setters
	 */
	@Test
	public void testSetLast() {
		sOne.setLast("newOne");
		assertEquals("newOne", sOne.getLast());
	}

	/**
	 * Testing setters
	 */
	@Test
	public void testSetId() {
		sOne.setId(100);
		assertEquals(100, sOne.getId());
	}

	/**
	 * Testing setters
	 */
	@Test
	public void testSetGpa() {
		sOne.setGpa(3.51);
		assertEquals(3.51, sOne.getGpa(), 0.001);
	}
	
	/**
	 * Testing setters
	 */
	@Test
	public void testSetUnityID() {
		sOne.setUnityID("oneUnity");
		assertEquals("oneUnity", sOne.getUnityID());
	}
	/**
	 * Testing compareTo()
	 */
	@Test
	public void testCompareTo() {
		assertTrue(sOne.compareTo(sTwo) < 0);
		assertTrue(sTwo.compareTo(sOne) > 0);
		assertTrue(sOne.compareTo(sOne) == 0);
		assertTrue(sTwo.compareTo(sTwo) == 0);
	}
	
	/**
	 * Testing equals()
	 */
	@Test
	public void testEquals() {
		Student stud1 = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		Student stud2 = new Student("OneFirst", "Onelast", 1, 2, 2.0, "twoUnityID");
		Student stud3 = new Student("TwoFirst", "Twolast", 3, 2, 2.0, "twoUnityID");
		Student stud4 = new Student("TwoFirst", "Threelast", 4, 2, 2.0, "twoUnityID");
		assertTrue(stud1.equals(stud2));
		assertFalse(stud1.equals(stud3));
		assertFalse(stud2.equals(stud3));
		assertFalse(stud4.equals(stud3));
		assertFalse(sFour.equals(sFive));
		
		
	}
	
	/**
	 * Testing toString()
	 */
	@Test
	public void testToString() {
		assertEquals("OneFirst,OneLast,1,1,1.0,oneUnityID", sOne.toString());
		assertEquals("TwoFirst,TwoLast,2,2,2.0,twoUnityID", sTwo.toString());
		assertEquals("ThreeFirst,ThreeLast,3,3,3.0,threeUnityID", sThree.toString());

	}
	
	/**
	 * Testing hashCode()
	 */
	@Test
	public void testHashCode() {
		Student stud1 = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		Student stud2 = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		Student stud3 = new Student("TwoFirst", "Twolast", 3, 2, 2.0, "twoUnityID");
		Student stud4 = new Student("TwoFirst", "Threelast", 4, 2, 2.0, "twoUnityID");
		assertEquals(stud1.hashCode(), stud2.hashCode());
		assertNotEquals(stud1.hashCode(), stud3.hashCode());
		assertNotEquals(stud3.hashCode(), stud4.hashCode());
		
	}
	
}
