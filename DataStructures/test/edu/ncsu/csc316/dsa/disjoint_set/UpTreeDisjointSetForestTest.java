package edu.ncsu.csc316.dsa.disjoint_set;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for UpTreeDisjointSetForest Checks the expected outputs of the
 * Disjoint Set abstract data type behaviors when using an up-tree data
 * structure
 *
 * @author Dr. King
 *
 */
public class UpTreeDisjointSetForestTest {

	private DisjointSetForest<String> set;

	/**
	 * Create a new instance of a up-tree forest before each test case executes
	 */
	@Before
	public void setUp() {
		set = new UpTreeDisjointSetForest<>();
	}

	/**
	 * Test the output of the makeSet behavior
	 */
	@Test
	public void testMakeSet() {
		Position<String> one = set.makeSet("one");
		assertEquals("one", one.getElement());
		Position<String> two = set.makeSet("two");
		assertEquals("two", two.getElement());
		Position<String> three = set.makeSet("three");
		assertEquals("three", three.getElement());
		Position<String> four = set.makeSet("four");
		assertEquals("four", four.getElement());
		Position<String> five = set.makeSet("five");
		assertEquals("five", five.getElement());

	}

	/**
	 * Test the output of the union-find behaviors
	 */
	@Test
	public void testUnionFind() {
		Position<String> one = set.makeSet("one");
		Position<String> two = set.makeSet("two");
		Position<String> three = set.makeSet("three");
		Position<String> four = set.makeSet("four");
		Position<String> five = set.makeSet("five");
		Position<String> six = set.makeSet("six");
		Position<String> seven = set.makeSet("seven");
		Position<String> eight = set.makeSet("eight");
		Position<String> nine = set.makeSet("nine");
		Position<String> ten = set.makeSet("ten");

		assertEquals(one, set.find("one"));
		assertEquals(two, set.find("two"));
		assertEquals(three, set.find("three"));
		assertEquals(four, set.find("four"));
		assertEquals(five, set.find("five"));

		set.union(one, two);
		assertEquals("two", set.find("one").getElement());
		set.union(three, four);
		assertEquals("four", set.find("three").getElement());
		set.union(five, six);
		assertEquals("six", set.find("five").getElement());
		set.union(seven, eight);
		assertEquals("eight", set.find("seven").getElement());
		set.union(nine, ten);
		assertEquals("ten", set.find("nine").getElement());

	}
}
