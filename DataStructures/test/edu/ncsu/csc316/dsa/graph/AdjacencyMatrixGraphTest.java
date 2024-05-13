package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;

/**
 * Test class for AdjacencyMatrixGraph Checks the expected outputs of the Graph
 * abstract data type behaviors when using an edge list graph data structure
 *
 * @author Dr. King
 *
 */
public class AdjacencyMatrixGraphTest {

	private Graph<String, Integer> undirectedGraph;
	private Graph<String, Integer> directedGraph;

	/**
	 * Create a new instance of an edge list graph before each test case executes
	 */
	@Before
	public void setUp() {
		undirectedGraph = new AdjacencyMatrixGraph<String, Integer>();
		directedGraph = new AdjacencyMatrixGraph<String, Integer>(true);
	}

	private void buildUndirectedSample() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");

		undirectedGraph.insertEdge(v1, v2, 5);
		undirectedGraph.insertEdge(v1, v3, 10);
		undirectedGraph.insertEdge(v1, v4, 15);
		undirectedGraph.insertEdge(v1, v5, 20);
		undirectedGraph.insertEdge(v2, v3, 25);
		undirectedGraph.insertEdge(v2, v4, 30);
		undirectedGraph.insertEdge(v2, v5, 35);
		undirectedGraph.insertEdge(v3, v4, 40);
		undirectedGraph.insertEdge(v3, v5, 45);
		undirectedGraph.insertEdge(v4, v5, 50);
	}

	private void buildDirectedSample() {
		Vertex<String> v1 = directedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = directedGraph.insertVertex("Asheville");
		Vertex<String> v3 = directedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = directedGraph.insertVertex("Durham");
		Vertex<String> v5 = directedGraph.insertVertex("Greenville");
		Vertex<String> v6 = directedGraph.insertVertex("Boone");

		directedGraph.insertEdge(v1, v2, 5);
		directedGraph.insertEdge(v1, v3, 10);
		directedGraph.insertEdge(v1, v4, 15);
		directedGraph.insertEdge(v1, v5, 20);
		directedGraph.insertEdge(v2, v3, 25);
		directedGraph.insertEdge(v2, v4, 30);
		directedGraph.insertEdge(v2, v5, 35);
		directedGraph.insertEdge(v3, v4, 40);
		directedGraph.insertEdge(v3, v5, 45);
		directedGraph.insertEdge(v4, v5, 50);
		directedGraph.insertEdge(v5, v6, 55);
	}

	/**
	 * Test the output of the numVertices() behavior
	 */
	@Test
	public void testNumVertices() {
		buildUndirectedSample();
		assertEquals(5, undirectedGraph.numVertices());

		buildDirectedSample();
		assertEquals(6, directedGraph.numVertices());
	}

	/**
	 * Test the output of the vertices() behavior
	 */
	@Test
	public void testVertices() {
		// We cannot call buildUndirectedSample() because
		// then we would not be able to reference specific edges
		// or vertices when testing
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		undirectedGraph.insertEdge(v1, v2, 5);
		undirectedGraph.insertEdge(v1, v3, 10);
		undirectedGraph.insertEdge(v1, v4, 15);
		undirectedGraph.insertEdge(v1, v5, 20);
		undirectedGraph.insertEdge(v2, v3, 25);
		undirectedGraph.insertEdge(v2, v4, 30);
		undirectedGraph.insertEdge(v2, v5, 35);
		undirectedGraph.insertEdge(v3, v4, 40);
		undirectedGraph.insertEdge(v3, v5, 45);
		undirectedGraph.insertEdge(v4, v5, 50);

		Iterator<Vertex<String>> it = undirectedGraph.vertices().iterator();
		assertTrue(it.hasNext());
		assertEquals(v1, it.next());
		assertTrue(it.hasNext());
		assertEquals(v2, it.next());
		assertTrue(it.hasNext());
		assertEquals(v3, it.next());
		assertTrue(it.hasNext());
		assertEquals(v4, it.next());
		assertTrue(it.hasNext());
		assertEquals(v5, it.next());
		assertFalse(it.hasNext());

		// DIRECTED
		// We cannot call buildDirectedSample() because
		// then we would not be able to reference specific edges
		// or vertices when testing
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		Vertex<String> v6 = directedGraph.insertVertex("Boone");
		directedGraph.insertEdge(v1, v2, 5);
		directedGraph.insertEdge(v1, v3, 10);
		directedGraph.insertEdge(v1, v4, 15);
		directedGraph.insertEdge(v1, v5, 20);
		directedGraph.insertEdge(v2, v3, 25);
		directedGraph.insertEdge(v2, v4, 30);
		directedGraph.insertEdge(v2, v5, 35);
		directedGraph.insertEdge(v3, v4, 40);
		directedGraph.insertEdge(v3, v5, 45);
		directedGraph.insertEdge(v4, v5, 50);
		directedGraph.insertEdge(v5, v6, 55);

		it = directedGraph.vertices().iterator();
		assertTrue(it.hasNext());
		assertEquals(v1, it.next());
		assertTrue(it.hasNext());
		assertEquals(v2, it.next());
		assertTrue(it.hasNext());
		assertEquals(v3, it.next());
		assertTrue(it.hasNext());
		assertEquals(v4, it.next());
		assertTrue(it.hasNext());
		assertEquals(v5, it.next());
		assertTrue(it.hasNext());
		assertEquals(v6, it.next());
		assertFalse(it.hasNext());
	}

	/**
	 * Test the output of the numEdges() behavior
	 */
	@Test
	public void testNumEdges() {
		buildUndirectedSample();
		assertEquals(10, undirectedGraph.numEdges());

		buildDirectedSample();
		assertEquals(11, directedGraph.numEdges());
	}

	/**
	 * Test the output of the edges() behavior
	 */
	@Test
	public void testEdges() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		Iterator<Edge<Integer>> it = undirectedGraph.edges().iterator();
		assertTrue(it.hasNext());
		assertEquals(e1, it.next());
		assertTrue(it.hasNext());
		assertEquals(e2, it.next());
		assertTrue(it.hasNext());
		assertEquals(e3, it.next());
		assertTrue(it.hasNext());
		assertEquals(e4, it.next());
		assertTrue(it.hasNext());
		assertEquals(e5, it.next());
		assertTrue(it.hasNext());
		assertEquals(e6, it.next());
		assertTrue(it.hasNext());
		assertEquals(e7, it.next());
		assertTrue(it.hasNext());
		assertEquals(e8, it.next());
		assertTrue(it.hasNext());
		assertEquals(e9, it.next());
		assertTrue(it.hasNext());
		assertEquals(e10, it.next());
		assertFalse(it.hasNext());

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		Vertex<String> v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		it = directedGraph.edges().iterator();
		assertTrue(it.hasNext());
		assertEquals(e1, it.next());
		assertTrue(it.hasNext());
		assertEquals(e2, it.next());
		assertTrue(it.hasNext());
		assertEquals(e3, it.next());
		assertTrue(it.hasNext());
		assertEquals(e4, it.next());
		assertTrue(it.hasNext());
		assertEquals(e5, it.next());
		assertTrue(it.hasNext());
		assertEquals(e6, it.next());
		assertTrue(it.hasNext());
		assertEquals(e7, it.next());
		assertTrue(it.hasNext());
		assertEquals(e8, it.next());
		assertTrue(it.hasNext());
		assertEquals(e9, it.next());
		assertTrue(it.hasNext());
		assertEquals(e10, it.next());
		assertTrue(it.hasNext());
		assertEquals(e11, it.next());
		assertFalse(it.hasNext());
	}

	/**
	 * Test the output of the getEdge(v1,v2) behavior
	 */
	@Test
	public void testGetEdge() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals((int) e1.getElement(), (int) undirectedGraph.getEdge(v1, v2).getElement());
		assertEquals((int) e2.getElement(), (int) undirectedGraph.getEdge(v1, v3).getElement());
		assertEquals((int) e3.getElement(), (int) undirectedGraph.getEdge(v1, v4).getElement());
		assertEquals((int) e4.getElement(), (int) undirectedGraph.getEdge(v1, v5).getElement());
		assertEquals((int) e5.getElement(), (int) undirectedGraph.getEdge(v2, v3).getElement());
		assertEquals((int) e6.getElement(), (int) undirectedGraph.getEdge(v2, v4).getElement());
		assertEquals((int) e7.getElement(), (int) undirectedGraph.getEdge(v2, v5).getElement());
		assertEquals((int) e8.getElement(), (int) undirectedGraph.getEdge(v3, v4).getElement());
		assertEquals((int) e9.getElement(), (int) undirectedGraph.getEdge(v3, v5).getElement());
		assertEquals((int) e10.getElement(), (int) undirectedGraph.getEdge(v4, v5).getElement());

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		assertEquals(5, (int) directedGraph.getEdge(v1, v2).getElement());
		assertEquals(10, (int) directedGraph.getEdge(v1, v3).getElement());
		assertEquals(15, (int) directedGraph.getEdge(v1, v4).getElement());
		assertEquals(20, (int) directedGraph.getEdge(v1, v5).getElement());
		assertEquals(25, (int) directedGraph.getEdge(v2, v3).getElement());
		assertEquals(30, (int) directedGraph.getEdge(v2, v4).getElement());
		assertEquals(35, (int) directedGraph.getEdge(v2, v5).getElement());
		assertEquals(40, (int) directedGraph.getEdge(v3, v4).getElement());
		assertEquals(45, (int) directedGraph.getEdge(v3, v5).getElement());
		assertEquals(50, (int) directedGraph.getEdge(v4, v5).getElement());
		assertEquals((int) e11.getElement(), (int) directedGraph.getEdge(v5, v6).getElement());

	}

	/**
	 * Test the output of the endVertices(e) behavior
	 */
	@Test
	public void testEndVertices() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals(v1, undirectedGraph.endVertices(e1)[0]);
		assertEquals(v2, undirectedGraph.endVertices(e1)[1]);
		assertEquals(v1, undirectedGraph.endVertices(e2)[0]);
		assertEquals(v3, undirectedGraph.endVertices(e2)[1]);
		assertEquals(v1, undirectedGraph.endVertices(e3)[0]);
		assertEquals(v4, undirectedGraph.endVertices(e3)[1]);
		assertEquals(v1, undirectedGraph.endVertices(e4)[0]);
		assertEquals(v5, undirectedGraph.endVertices(e4)[1]);
		assertEquals(v2, undirectedGraph.endVertices(e5)[0]);
		assertEquals(v3, undirectedGraph.endVertices(e5)[1]);
		assertEquals(v2, undirectedGraph.endVertices(e6)[0]);
		assertEquals(v4, undirectedGraph.endVertices(e6)[1]);
		assertEquals(v2, undirectedGraph.endVertices(e7)[0]);
		assertEquals(v5, undirectedGraph.endVertices(e7)[1]);
		assertEquals(v3, undirectedGraph.endVertices(e8)[0]);
		assertEquals(v4, undirectedGraph.endVertices(e8)[1]);
		assertEquals(v3, undirectedGraph.endVertices(e9)[0]);
		assertEquals(v5, undirectedGraph.endVertices(e9)[1]);
		assertEquals(v4, undirectedGraph.endVertices(e10)[0]);
		assertEquals(v5, undirectedGraph.endVertices(e10)[1]);

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		assertEquals(v1, directedGraph.endVertices(e1)[0]);
		assertEquals(v2, directedGraph.endVertices(e1)[1]);
		assertEquals(v1, directedGraph.endVertices(e2)[0]);
		assertEquals(v3, directedGraph.endVertices(e2)[1]);
		assertEquals(v1, directedGraph.endVertices(e3)[0]);
		assertEquals(v4, directedGraph.endVertices(e3)[1]);
		assertEquals(v1, directedGraph.endVertices(e4)[0]);
		assertEquals(v5, directedGraph.endVertices(e4)[1]);
		assertEquals(v2, directedGraph.endVertices(e5)[0]);
		assertEquals(v4, directedGraph.endVertices(e8)[1]);
		assertEquals(v5, directedGraph.endVertices(e9)[1]);
		assertEquals(v5, directedGraph.endVertices(e10)[1]);
		assertEquals(v6, directedGraph.endVertices(e11)[1]);
	}

	/**
	 * Test the output of the opposite(v, e) behavior
	 */
	@Test
	public void testOpposite() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals(v1, undirectedGraph.opposite(v2, e1));
		assertEquals(v4, undirectedGraph.opposite(v1, e3));
		assertEquals(v1, undirectedGraph.opposite(v4, e3));
		assertEquals(v5, undirectedGraph.opposite(v1, e4));
		assertEquals(v1, undirectedGraph.opposite(v5, e4));
		assertEquals(v3, undirectedGraph.opposite(v1, e2));
		assertEquals(v1, undirectedGraph.opposite(v3, e2));
		assertEquals(v3, undirectedGraph.opposite(v2, e5));
		assertEquals(v2, undirectedGraph.opposite(v3, e5));
		assertEquals(v3, undirectedGraph.opposite(v4, e8));
		assertEquals(v4, undirectedGraph.opposite(v2, e6));
		assertEquals(v2, undirectedGraph.opposite(v4, e6));
		assertEquals(v4, undirectedGraph.opposite(v5, e10));
		assertEquals(v2, undirectedGraph.opposite(v5, e7));
		assertEquals(v4, undirectedGraph.opposite(v3, e8));
		assertEquals(v3, undirectedGraph.opposite(v5, e9));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);
		e11.getElement();

		assertEquals(v1, directedGraph.opposite(v2, e1));
		assertEquals(v4, directedGraph.opposite(v1, e3));
		assertEquals(v1, directedGraph.opposite(v4, e3));
		assertEquals(v5, directedGraph.opposite(v1, e4));
		assertEquals(v1, directedGraph.opposite(v5, e4));
		assertEquals(v3, directedGraph.opposite(v1, e2));
		assertEquals(v1, directedGraph.opposite(v3, e2));
		assertEquals(v3, directedGraph.opposite(v2, e5));
		assertEquals(v2, directedGraph.opposite(v3, e5));
		assertEquals(v3, directedGraph.opposite(v4, e8));
		assertEquals(v4, directedGraph.opposite(v2, e6));
		assertEquals(v2, directedGraph.opposite(v4, e6));
		assertEquals(v4, directedGraph.opposite(v5, e10));
		assertEquals(v2, directedGraph.opposite(v5, e7));
		assertEquals(v4, directedGraph.opposite(v3, e8));
		assertEquals(v3, directedGraph.opposite(v5, e9));
	}

	/**
	 * Test the output of the outDegree(v) behavior
	 */
	@Test
	public void testOutDegree() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		e1.getElement();
		e2.getElement();
		e3.getElement();
		e4.getElement();
		e5.getElement();
		e6.getElement();
		e7.getElement();
		e8.getElement();
		e9.getElement();
		e10.getElement();

		assertEquals(4, undirectedGraph.outDegree(v1));
		assertEquals(4, undirectedGraph.outDegree(v1));
		assertEquals(4, undirectedGraph.outDegree(v2));
		assertEquals(4, undirectedGraph.outDegree(v3));
		assertEquals(4, undirectedGraph.outDegree(v4));
		assertEquals(4, undirectedGraph.outDegree(v5));
		assertEquals(0, undirectedGraph.outDegree(v6));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);
		e11.getElement();

		assertEquals(4, directedGraph.outDegree(v1));
		assertEquals(3, directedGraph.outDegree(v2));
		assertEquals(2, directedGraph.outDegree(v3));
		assertEquals(1, directedGraph.outDegree(v4));
		assertEquals(1, directedGraph.outDegree(v5));
		assertEquals(0, directedGraph.outDegree(v6));

	}

	/**
	 * Test the output of the inDegree(v) behavior
	 */
	@Test
	public void testInDegree() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		e1.getElement();
		e2.getElement();
		e3.getElement();
		e4.getElement();
		e5.getElement();
		e6.getElement();
		e7.getElement();
		e8.getElement();
		e9.getElement();
		e10.getElement();
		assertEquals(4, undirectedGraph.inDegree(v1));
		assertEquals(4, undirectedGraph.inDegree(v2));
		assertEquals(4, undirectedGraph.inDegree(v3));
		assertEquals(4, undirectedGraph.inDegree(v4));
		assertEquals(4, undirectedGraph.inDegree(v5));
		assertEquals(0, undirectedGraph.inDegree(v6));
		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);
		e11.getElement();

		assertEquals(0, directedGraph.inDegree(v1));
		assertEquals(1, directedGraph.inDegree(v2));
		assertEquals(2, directedGraph.inDegree(v3));
		assertEquals(3, directedGraph.inDegree(v4));
		assertEquals(4, directedGraph.inDegree(v5));
		assertEquals(1, directedGraph.inDegree(v6));

	}

	/**
	 * Test the output of the outgoingEdges(v) behavior
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testOutgoingEdges() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);
		// We can use a custom arrayContains() helper method to check that
		// an array *contains* a certain target edge.
		// This is helpful for testing graph ADT behaviors where an order
		// of edges cannot be guaranteed (such as .outgoingEdges or .incomingEdges
		// in adjacencyMaps, etc.)
		Edge<Integer>[] temp = (Edge<Integer>[]) (new Edge[4]);
		int count = 0;
		Iterator<Edge<Integer>> it = undirectedGraph.outgoingEdges(v1).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e1));
		assertTrue(arrayContains(temp, e2));
		assertTrue(arrayContains(temp, e3));
		assertTrue(arrayContains(temp, e4));

		temp = (Edge<Integer>[]) (new Edge[4]);
		count = 0;
		it = undirectedGraph.outgoingEdges(v2).iterator();
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertTrue(arrayContains(temp, e1));
		assertTrue(arrayContains(temp, e5));
		assertTrue(arrayContains(temp, e6));
		assertTrue(arrayContains(temp, e7));

		temp = (Edge<Integer>[]) (new Edge[4]);
		count = 0;
		it = undirectedGraph.outgoingEdges(v3).iterator();
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertTrue(arrayContains(temp, e2));
		assertTrue(arrayContains(temp, e5));
		assertTrue(arrayContains(temp, e8));
		assertTrue(arrayContains(temp, e9));

		temp = (Edge<Integer>[]) (new Edge[4]);
		count = 0;
		it = undirectedGraph.outgoingEdges(v4).iterator();
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertTrue(arrayContains(temp, e3));
		assertTrue(arrayContains(temp, e6));
		assertTrue(arrayContains(temp, e8));
		assertTrue(arrayContains(temp, e10));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);
		e11.getElement();
		temp = (Edge<Integer>[]) (new Edge[4]);
		count = 0;
		it = directedGraph.outgoingEdges(v1).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e1));
		assertTrue(arrayContains(temp, e2));
		assertTrue(arrayContains(temp, e3));
		assertTrue(arrayContains(temp, e4));
		temp = (Edge<Integer>[]) (new Edge[3]);
		count = 0;
		it = directedGraph.outgoingEdges(v2).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e5));
		assertTrue(arrayContains(temp, e6));
		assertTrue(arrayContains(temp, e7));
		temp = (Edge<Integer>[]) (new Edge[2]);
		count = 0;
		it = directedGraph.outgoingEdges(v3).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e8));
		assertTrue(arrayContains(temp, e9));
		temp = (Edge<Integer>[]) (new Edge[1]);
		count = 0;
		it = directedGraph.outgoingEdges(v4).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e10));

	}

	// Helper method to check that an array contains a certain target.
	// This is helpful for testing graph ADT behaviors where an order
	// of edges cannot be guaranteed (such as .outgoingEdges or .incomingEdges)
	private boolean arrayContains(Edge<Integer>[] temp, Edge<Integer> target) {
		for (Edge<Integer> e : temp) {
			if (e == target) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Test the output of the incomingEdges(v) behavior
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testIncomingEdges() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		Edge<Integer>[] temp = (Edge<Integer>[]) (new Edge[4]);
		int count = 0;
		Iterator<Edge<Integer>> it = undirectedGraph.incomingEdges(v1).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e1));
		assertTrue(arrayContains(temp, e2));
		assertTrue(arrayContains(temp, e3));
		assertTrue(arrayContains(temp, e4));

		temp = (Edge<Integer>[]) (new Edge[4]);
		count = 0;
		it = undirectedGraph.incomingEdges(v2).iterator();
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertTrue(arrayContains(temp, e1));
		assertTrue(arrayContains(temp, e5));
		assertTrue(arrayContains(temp, e6));
		assertTrue(arrayContains(temp, e7));

		temp = (Edge<Integer>[]) (new Edge[4]);
		count = 0;
		it = undirectedGraph.incomingEdges(v3).iterator();
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertTrue(arrayContains(temp, e2));
		assertTrue(arrayContains(temp, e5));
		assertTrue(arrayContains(temp, e8));
		assertTrue(arrayContains(temp, e9));

		temp = (Edge<Integer>[]) (new Edge[4]);
		count = 0;
		it = undirectedGraph.incomingEdges(v4).iterator();
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertTrue(arrayContains(temp, e3));
		assertTrue(arrayContains(temp, e6));
		assertTrue(arrayContains(temp, e8));
		assertTrue(arrayContains(temp, e10));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		temp = (Edge<Integer>[]) (new Edge[1]);
		count = 0;
		it = directedGraph.incomingEdges(v2).iterator();
		temp[count] = it.next();
		count++;
		assertTrue(arrayContains(temp, e1));
		temp = (Edge<Integer>[]) (new Edge[1]);
		count = 0;
		it = directedGraph.incomingEdges(v6).iterator();
		temp[count] = it.next();
		count++;
		assertTrue(arrayContains(temp, e11));
		temp = (Edge<Integer>[]) (new Edge[2]);
		count = 0;
		it = directedGraph.incomingEdges(v3).iterator();
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertTrue(arrayContains(temp, e2));
		assertTrue(arrayContains(temp, e5));
		temp = (Edge<Integer>[]) (new Edge[3]);
		count = 0;
		it = directedGraph.incomingEdges(v4).iterator();
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertTrue(arrayContains(temp, e3));
		assertTrue(arrayContains(temp, e6));
		assertTrue(arrayContains(temp, e8));
		temp = (Edge<Integer>[]) (new Edge[4]);
		count = 0;
		it = directedGraph.incomingEdges(v5).iterator();
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertTrue(arrayContains(temp, e4));
		assertTrue(arrayContains(temp, e7));
		assertTrue(arrayContains(temp, e9));
		assertTrue(arrayContains(temp, e10));

	}

	/**
	 * Test the output of the insertVertex(x) behavior
	 */
	@Test
	public void testInsertVertex() {
		assertEquals(0, undirectedGraph.numVertices());
		Vertex<String> v1 = undirectedGraph.insertVertex("Fayetteville");
		assertEquals(1, undirectedGraph.numVertices());

		Iterator<Vertex<String>> it = undirectedGraph.vertices().iterator();
		assertTrue(it.hasNext());
		assertEquals(v1, it.next());
		assertFalse(it.hasNext());
		assertEquals(0, directedGraph.numVertices());
		v1 = directedGraph.insertVertex("Fayetteville");
		assertEquals(1, directedGraph.numVertices());
		Vertex<String> v2 = directedGraph.insertVertex("Raleigh");
		assertEquals(2, directedGraph.numVertices());
		Vertex<String> v3 = directedGraph.insertVertex("Cary");
		assertEquals(3, directedGraph.numVertices());
		Vertex<String> v4 = directedGraph.insertVertex("Apex");
		assertEquals(4, directedGraph.numVertices());

		it = directedGraph.vertices().iterator();
		assertTrue(it.hasNext());
		assertEquals(v1, it.next());
		assertTrue(it.hasNext());
		assertEquals(v2, it.next());
		assertTrue(it.hasNext());
		assertEquals(v3, it.next());
		assertTrue(it.hasNext());
		assertEquals(v4, it.next());
		assertFalse(it.hasNext());
	}

	/**
	 * Test the output of the insertEdge(v1, v2, x) behavior
	 */
	@Test
	public void testInsertEdge() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Cary");

		assertEquals(0, undirectedGraph.numEdges());
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 99);
		assertEquals(1, undirectedGraph.numEdges());
		Iterator<Edge<Integer>> it = undirectedGraph.edges().iterator();
		assertTrue(it.hasNext());
		assertEquals(e1, it.next());
		assertFalse(it.hasNext());

		undirectedGraph.insertEdge(v1, v3, 1);
		assertEquals(2, undirectedGraph.numEdges());
	}

	/**
	 * Test the output of the removeVertex(v) behavior
	 */
	@Test
	public void testRemoveVertex() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);
		e1.getElement();
		e2.getElement();
		e3.getElement();
		e4.getElement();
		e5.getElement();
		e6.getElement();
		e7.getElement();
		e8.getElement();
		e9.getElement();
		e10.getElement();

		assertEquals(5, undirectedGraph.numVertices());
		assertEquals(10, undirectedGraph.numEdges());
		undirectedGraph.removeVertex(v5);
		assertEquals(4, undirectedGraph.numVertices());
		assertEquals(6, undirectedGraph.numEdges());

		undirectedGraph.removeVertex(v3);
		assertEquals(3, undirectedGraph.numVertices());
		assertEquals(3, undirectedGraph.numEdges());
		undirectedGraph.removeVertex(v2);
		assertEquals(2, undirectedGraph.numVertices());
		assertEquals(1, undirectedGraph.numEdges());

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		Vertex<String> v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);
		e11.getElement();

		assertEquals(6, directedGraph.numVertices());
		assertEquals(11, directedGraph.numEdges());
		v6.getElement();
		directedGraph.removeVertex(v6);
		assertEquals(5, directedGraph.numVertices());
		assertEquals(10, directedGraph.numEdges());
		directedGraph.removeVertex(v3);
		assertEquals(2, undirectedGraph.numVertices());
		assertEquals(1, undirectedGraph.numEdges());
		directedGraph.removeVertex(v2);
		assertEquals(2, undirectedGraph.numVertices());
		assertEquals(1, undirectedGraph.numEdges());
	}

	/**
	 * Test the output of the removeEdge(e) behavior
	 */
	@Test
	public void testRemoveEdge() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(10, undirectedGraph.numEdges());
		undirectedGraph.removeEdge(e1);
		v6.getElement();
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(9, undirectedGraph.numEdges());
		undirectedGraph.removeEdge(e2);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(8, undirectedGraph.numEdges());
		undirectedGraph.removeEdge(e3);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(7, undirectedGraph.numEdges());
		undirectedGraph.removeEdge(e4);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(6, undirectedGraph.numEdges());
		undirectedGraph.removeEdge(e5);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(5, undirectedGraph.numEdges());
		undirectedGraph.removeEdge(e6);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(4, undirectedGraph.numEdges());
		undirectedGraph.removeEdge(e7);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(3, undirectedGraph.numEdges());
		undirectedGraph.removeEdge(e8);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(2, undirectedGraph.numEdges());
		undirectedGraph.removeEdge(e9);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(1, undirectedGraph.numEdges());
		undirectedGraph.removeEdge(e10);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(0, undirectedGraph.numEdges());

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);

		assertEquals(6, directedGraph.numVertices());
		assertEquals(10, directedGraph.numEdges());
		directedGraph.removeEdge(e1);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(9, directedGraph.numEdges());
		directedGraph.removeEdge(e2);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(8, directedGraph.numEdges());
		directedGraph.removeEdge(e3);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(7, directedGraph.numEdges());
		directedGraph.removeEdge(e4);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(6, directedGraph.numEdges());
		directedGraph.removeEdge(e5);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(5, directedGraph.numEdges());
		directedGraph.removeEdge(e6);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(4, directedGraph.numEdges());
		directedGraph.removeEdge(e7);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(3, directedGraph.numEdges());
		directedGraph.removeEdge(e8);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(2, directedGraph.numEdges());
		directedGraph.removeEdge(e9);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(1, directedGraph.numEdges());
		directedGraph.removeEdge(e10);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(0, directedGraph.numEdges());
	}

}
