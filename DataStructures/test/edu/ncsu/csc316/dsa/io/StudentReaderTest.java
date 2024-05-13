package edu.ncsu.csc316.dsa.io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
/**
 * Tests StudentReader
 * @author Tilak
 *
 */
public class StudentReaderTest {

	/**
	 * Tests readFile()
	 */
	@Test
	public void testReadFile() {
		Student[] contents = StudentReader.readInputAsArray("input/student_ascendingID.csv");
		
		assertEquals("Amber", contents[0].getFirst());
		assertEquals("Ara", contents[1].getFirst());
		assertEquals("Lacie", contents[2].getFirst());
		assertEquals("Idalia", contents[3].getFirst());
		assertEquals("Evelin", contents[4].getFirst());
		assertEquals("Lewis", contents[5].getFirst());
		assertEquals("Alicia", contents[6].getFirst());
		assertEquals("Tyree", contents[7].getFirst());
		assertEquals("Loise", contents[8].getFirst());
		assertEquals("Roxann", contents[9].getFirst());
		assertEquals("Nichole", contents[10].getFirst());
		assertEquals("Charlene", contents[11].getFirst());
		assertEquals("Shanti", contents[12].getFirst());
		assertEquals("Cristine", contents[13].getFirst());
		assertEquals("Tanner", contents[14].getFirst());
		assertEquals("Dante", contents[15].getFirst());
		
		assertEquals(1, contents[0].getId());
		assertEquals(3, contents[1].getId());
		assertEquals(4, contents[2].getId());
		assertEquals(5, contents[3].getId());
		
		assertEquals("seibere", contents[4].getUnityID());
		assertEquals("mathesl", contents[5].getUnityID());
		assertEquals("terrela", contents[6].getUnityID());
		assertEquals("runyont", contents[7].getUnityID());
		assertEquals("woodbul", contents[8].getUnityID());
		
		assertEquals(13, contents[9].getCreditHours());
		assertEquals(11, contents[10].getCreditHours());
		assertEquals(14, contents[11].getCreditHours());
		assertEquals(17, contents[12].getCreditHours());
		assertEquals(11, contents[13].getCreditHours());
		assertEquals(16, contents[14].getCreditHours());
		assertEquals(16, contents[15].getCreditHours());
	}


}
