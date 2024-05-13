package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;
import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;

/**
 * An unordered link-based map is an unordered (meaning keys are not used to
 * order entries) linked-memory representation of the Map abstract data type.
 * This link-based map delegates to an existing doubly-linked positional list.
 * To help self-organizing entries to improve efficiency of lookUps, the
 * unordered link-based map implements the move-to-front heuristic: each time an
 * entry is accessed, it is shifted to the front of the internal list.
 * 
 * @author Dr. King
 *
 * @param <K> the type of keys stored in the map
 * @param <V> the type of values that are associated with keys in the map
 */
public class UnorderedLinkedMap<K, V> extends AbstractMap<K, V> {

	/** Instance of PositionalList */
	private PositionalList<Entry<K, V>> list;

	/**
	 * Constructor
	 */
	public UnorderedLinkedMap() {
		this.list = new PositionalLinkedList<Entry<K, V>>();
	}

	private Position<Entry<K, V>> lookUp(K key) {
		Iterator<Position<Entry<K, V>>> it = list.positions().iterator();
//    	MapEntry<String, String> x= new MapEntry("key","r");
//    	Position<MapEntry<String, String>> temp= list.addFirst(x);
		for (Entry<K, V> t : list) {
			if (t.getKey().equals(key))
				return it.next();
			it.next();
		}
		return null;

	}

	@Override
	public V get(K key) {
		Position<Entry<K, V>> p = lookUp(key);
		if (p != null) {
			moveToFront(p);
			return list.first().getElement().getValue();
		}
		return null;

	}

	private void moveToFront(Position<Entry<K, V>> position) {
		list.addFirst(list.remove(position));
	}

	@Override
	public V put(K key, V value) {
		Position<Entry<K, V>> p = lookUp(key);
		if (p != null) {
			V original = list.remove(p).getValue();
			Entry<K, V> temp = new MapEntry(key, value);
			list.addFirst(temp);
			return original;
		}
		Entry<K, V> temp = new MapEntry(key, value);
		list.addFirst(temp);
		return null;
	}

	@Override
	public V remove(K key) {
		Position<Entry<K, V>> p = lookUp(key);
		Entry<K, V> temp;
		if (p == null)
			return null;
		temp = list.remove(p);
		return temp.getValue();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		EntryCollection collection = new EntryCollection();
		for (Entry<K, V> entry : list) {
			collection.add(entry);
//	           System.out.println("k: "+entry.getKey()+" v: "+entry.getValue());
		}
		return collection;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("UnorderedLinkedMap[");
		Iterator<Entry<K, V>> it = list.iterator();
		while (it.hasNext()) {
			sb.append(it.next().getKey());
			if (it.hasNext()) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
