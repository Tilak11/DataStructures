package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.map.search_tree.*;

/**
 * Test class for SplayTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a splay tree data structure 
 *
 * @author Dr. King
 *
 */
public class SplayTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a splay tree-based map before each test case executes
     */     
    @Before
    public void setUp() {
        tree = new SplayTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
    	assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());
		tree.put(4, "four");
		tree.put(2, "two");
		tree.put(5, "five");
		tree.put(7, "seven");
		tree.put(9, "nine");
		
		assertEquals(5, tree.size());

		assertEquals(9, (int) tree.root().getElement().getKey());
		assertEquals(7, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(5, (int) tree.left( tree.left(tree.root())).getElement().getKey());
		assertEquals(4, (int) tree.left(tree.left( tree.left(tree.root()))).getElement().getKey());
		assertEquals(2, (int) tree.left(tree.left(tree.left( tree.left(tree.root())))).getElement().getKey());		
        
    }
    
    /**
     * Test the output of the get(k) behavior
     */ 
    @Test
    public void testGet() {
    	assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());
		tree.put(4, "four");
		tree.put(2, "two");
		tree.put(5, "five");
		tree.put(7, "seven");
		tree.put(9, "nine");
		tree.put(10, "ten");
		assertEquals(10, (int) tree.root().getElement().getKey());
		assertEquals(9, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals("four", tree.get(4));
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(9, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals("five", tree.get(5));
		assertEquals(5, (int) tree.root().getElement().getKey());
		assertEquals(4, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(9, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals("seven", tree.get(7));
		assertEquals(7, (int) tree.root().getElement().getKey());
		assertEquals(5, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(9, (int) tree.right(tree.root()).getElement().getKey());

		
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
    	assertTrue(tree.isEmpty());
		tree.put(4, "four");
		tree.put(2, "two");
		tree.put(5, "five");
		tree.put(7, "seven");
		tree.put(9, "nine");
		tree.put(10, "ten");
		assertEquals(10, (int) tree.root().getElement().getKey());
		assertEquals(9, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals("four", tree.get(4));
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(9, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals("five", tree.get(5));
		assertEquals(5, (int) tree.root().getElement().getKey());
		assertEquals(4, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(9, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals("seven", tree.get(7));
		assertEquals(7, (int) tree.root().getElement().getKey());
		
		
		assertEquals("two", tree.remove(2));
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertNull( tree.left(tree.root()).getElement());
		assertEquals(5, (int) tree.right(tree.root()).getElement().getKey());

        
              
    }
}
