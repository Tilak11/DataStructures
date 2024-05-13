package edu.ncsu.csc316.dsa.tree;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for LinkedBinaryTree Checks the expected outputs of the BinaryTree
 * abstract data type behaviors when using a linked data structure to store
 * elements
 *
 * @author Dr. King
 *
 */
public class LinkedBinaryTreeTest {

	/** Instance of LinkedBinaryTree */
	private LinkedBinaryTree<String> tree;
	/** Test Position */
	private Position<String> one;
	/** Test Position */
	private Position<String> two;
	/** Test Position */
	private Position<String> three;
	/** Test Position */
	private Position<String> four;
	/** Test Position */
	private Position<String> five;
	/** Test Position */
	private Position<String> six;
	/** Test Position */
	private Position<String> seven;
	/** Test Position */
	private Position<String> eight;
	/** Test Position */
	private Position<String> nine;
	/** Test Position */
	private Position<String> ten;

	/**
	 * Helper class to create an invalid position to help test validate(p)
	 */
//	private class InvalidPosition<E> implements Position<E> {
//
//		@Override
//		public E getElement() {
//			return null;
//		}
//
//	}

	/**
	 * Create a new instance of a linked binary tree before each test case executes
	 */
	@Before
	public void setUp() {
		tree = new LinkedBinaryTree<String>();
	}

	/**
	 * Sample tree to help with testing
	 *
	 * One -> Two -> Six -> Ten -> Seven -> Five -> Three -> Four -> Eight -> Nine
	 * 
	 * Or, visually: one / \ two three / \ / six ten four / \ / \ seven five eight
	 * nine
	 */
	private void createTree() {
		one = tree.addRoot("one");
		two = tree.addLeft(one, "two");
		three = tree.addRight(one, "three");
		six = tree.addLeft(two, "six");
		ten = tree.addRight(two, "ten");
		four = tree.addLeft(three, "four");
		seven = tree.addLeft(ten, "seven");
		five = tree.addRight(ten, "five");
		eight = tree.addLeft(four, "eight");
		nine = tree.addRight(four, "nine");
	}

	/**
	 * Test the output of the set(p,e) behavior
	 */
	@Test
	public void testSet() {
		createTree();
		assertEquals(one, tree.root());
		assertEquals(two, tree.setRoot(two));
		assertEquals(two, tree.root());

		assertEquals("five", tree.right(ten).getElement());
		tree.set(five, "five-replaced");
		assertEquals("five-replaced", tree.right(ten).getElement());

	}

	/**
	 * Test the output of the size() behavior
	 */
	@Test
	public void testSize() {
		assertTrue(tree.isEmpty());
		createTree();
		assertEquals(10, tree.size());
		try {
			tree.remove(one);
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
			assertEquals(10, tree.size());

		}
		tree.remove(eight);
		assertEquals(9, tree.size());
		tree.remove(nine);
		assertEquals(8, tree.size());

	}

	/**
	 * Test the output of the numChildren(p) behavior
	 */
	@Test
	public void testNumChildren() {
		createTree();
		assertEquals(2, tree.numChildren(one));
		assertEquals(2, tree.numChildren(two));

		assertEquals(1, tree.numChildren(three));

		assertEquals(2, tree.numChildren(four));

		assertEquals(2, tree.numChildren(ten));
		assertEquals(0, tree.numChildren(nine));
		assertEquals(0, tree.numChildren(seven));

	}

	/**
	 * Test the output of the parent(p) behavior
	 */
	@Test
	public void testParent() {
		createTree();
		assertNull(tree.parent(one));
		assertEquals(one, tree.parent(two));
		assertEquals(one, tree.parent(three));
		assertEquals(two, tree.parent(ten));
		assertEquals(two, tree.parent(six));
		assertEquals(three, tree.parent(four));
		assertEquals(four, tree.parent(eight));
		assertEquals(four, tree.parent(nine));
		assertEquals(ten, tree.parent(five));
		assertEquals(ten, tree.parent(seven));

	}

	/**
	 * Test the output of the sibling behavior
	 */
	@Test
	public void testSibling() {
		createTree();
		assertNull(tree.sibling(one));
		assertEquals(three, tree.sibling(two));
		assertEquals(two, tree.sibling(three));
		assertEquals(ten, tree.sibling(six));
		assertEquals(six, tree.sibling(ten));
		assertEquals(seven, tree.sibling(five));
		assertEquals(five, tree.sibling(seven));
		assertEquals(eight, tree.sibling(nine));
		assertEquals(nine, tree.sibling(eight));

	}

	/**
	 * Test the output of the isInternal behavior
	 */
	@Test
	public void testIsInternal() {
		createTree();
		assertTrue(tree.isInternal(one));
		assertTrue(tree.isInternal(two));
		assertTrue(tree.isInternal(three));
		assertTrue(tree.isInternal(ten));
		assertTrue(tree.isInternal(four));
		assertFalse(tree.isInternal(six));
		assertFalse(tree.isInternal(seven));
		assertFalse(tree.isInternal(five));
		assertFalse(tree.isInternal(eight));
		assertFalse(tree.isInternal(nine));
	}

	/**
	 * Test the output of the isLeaf behavior
	 */
	@Test
	public void isLeaf() {
		createTree();
		assertFalse(tree.isLeaf(one));
		assertFalse(tree.isLeaf(two));
		assertFalse(tree.isLeaf(three));
		assertFalse(tree.isLeaf(ten));
		assertFalse(tree.isLeaf(four));
		assertTrue(tree.isLeaf(six));
		assertTrue(tree.isLeaf(seven));
		assertTrue(tree.isLeaf(five));
		assertTrue(tree.isLeaf(eight));
		assertTrue(tree.isLeaf(nine));
	}

	/**
	 * Test the output of the isRoot(p)
	 */
	@Test
	public void isRoot() {
		createTree();
		assertTrue(tree.isRoot(one));
		assertFalse(tree.isRoot(two));
		assertFalse(tree.isRoot(three));
		assertFalse(tree.isRoot(ten));
		assertFalse(tree.isRoot(four));
		assertFalse(tree.isRoot(six));
		assertFalse(tree.isRoot(seven));
		assertFalse(tree.isRoot(five));
		assertFalse(tree.isRoot(eight));
		assertFalse(tree.isRoot(nine));
	}

	/**
	 * Test the output of the preOrder traversal behavior
	 */
	@Test
	public void testPreOrder() {
		createTree();

		Iterator<Position<String>> it = tree.preOrder().iterator();
		assertTrue(it.hasNext());
		assertEquals("one", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("two", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("six", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("ten", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("seven", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("five", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("three", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("four", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("eight", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("nine", it.next().getElement());
		assertFalse(it.hasNext());
	}

	/**
	 * Test the output of the postOrder traversal behavior
	 */
	@Test
	public void testPostOrder() {
		createTree();

		Iterator<Position<String>> it = tree.postOrder().iterator();
		assertTrue(it.hasNext());
		assertEquals("six", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("seven", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("five", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("ten", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("two", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("eight", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("nine", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("four", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("three", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("one", it.next().getElement());
		assertFalse(it.hasNext());
	}

	/**
	 * Test the output of the inOrder traversal behavior
	 */
	@Test
	public void testInOrder() {
		createTree();

		Iterator<Position<String>> it = tree.inOrder().iterator();
		assertTrue(it.hasNext());
		assertEquals("six", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("two", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("seven", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("ten", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("five", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("one", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("eight", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("four", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("nine", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("three", it.next().getElement());
		assertFalse(it.hasNext());
		try {
			it.remove();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof UnsupportedOperationException);

		}

	}

	/**
	 * Test the output of the Binary Tree ADT behaviors on an empty tree
	 */
	@Test
	public void testEmptyTree() {
		assertTrue(tree.isEmpty());
		createTree();
		assertFalse(tree.isEmpty());
	}

	/**
	 * Test the output of the LevelOrder traversal behavior
	 */
	@Test
	public void testLevelOrder() {
		createTree();

		Iterator<Position<String>> it = tree.levelOrder().iterator();
		assertTrue(it.hasNext());
		assertEquals("one", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("two", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("three", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("six", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("ten", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("four", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("seven", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("five", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("eight", it.next().getElement());
		assertTrue(it.hasNext());
		assertEquals("nine", it.next().getElement());
		assertFalse(it.hasNext());

	}

	/**
	 * Test the output of the addLeft(p,e) behavior, including expected exceptions
	 */
	@Test
	public void testAddLeft() {
		assertTrue(tree.isEmpty());
		createTree();
		assertFalse(tree.isEmpty());
		try {
			tree.addLeft(one, "one-left");
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
			assertEquals(10, tree.size());

		}
		assertEquals(0, tree.numChildren(nine));
		assertNull(tree.left(nine));
		Position<String> nineLeft = tree.addLeft(nine, "nineLeft");
		assertEquals(1, tree.numChildren(nine));
		assertNotNull(tree.left(nine));
		assertEquals(nineLeft, tree.left(nine));
		assertEquals(nine, tree.parent(nineLeft));

	}

	/**
	 * Test the output of the addRight(p,e) behavior, including expected exceptions
	 */
	@Test
	public void testAddRight() {
		assertTrue(tree.isEmpty());
		createTree();
		assertFalse(tree.isEmpty());
		try {
			tree.addRight(one, "one-right");
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
			assertEquals(10, tree.size());

		}
		assertEquals(0, tree.numChildren(nine));
		assertNull(tree.left(nine));
		Position<String> nineRight = tree.addRight(nine, "nineRight");
		assertEquals(1, tree.numChildren(nine));
		assertNotNull(tree.right(nine));
		assertEquals(nineRight, tree.right(nine));
		assertEquals(nine, tree.parent(nineRight));
	}

	/**
	 * Test the output of the remove(p) behavior, including expected exceptions
	 */
	@Test
	public void testRemove() {
		createTree();
		try {
			tree.remove(one);
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
			assertEquals(10, tree.size());

		}
		assertEquals(four, tree.left(three));
		assertEquals(three, tree.right(one));
		assertEquals(three, tree.parent(four));
		assertEquals(one, tree.parent(three));
		assertEquals(10, tree.size());

		assertEquals("three", tree.remove(three));

		assertEquals(four, tree.right(one));
		assertEquals(one, tree.parent(four));
		assertEquals(9, tree.size());

	}

	/**
	 * Test the output of the toString()
	 */
	@Test
	public void testToString() {
		createTree();
		String str = "LinkedBinaryTree[\n" + "one\n" + " two\n" + "  six\n" + "  ten\n" + "   seven\n" + "   five\n"
				+ " three\n" + "  four\n" + "   eight\n" + "   nine\n" + "]";
		assertEquals(str, tree.toString());
		assertEquals("five", tree.right(ten).getElement());
		tree.set(five, "five-replaced");
		assertEquals("five-replaced", tree.right(ten).getElement());
		str = "LinkedBinaryTree[\n" + "one\n" + " two\n" + "  six\n" + "  ten\n" + "   seven\n" + "   five-replaced\n"
				+ " three\n" + "  four\n" + "   eight\n" + "   nine\n" + "]";
		assertEquals(str, tree.toString());
	}
}
