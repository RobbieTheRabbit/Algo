package uebung2;

import java.util.LinkedList;

/*********************************************************************
 * Zweite praktische Übung von Algorithmen SS17 Hashtabelle
 * 
 * @author Sven Böhrnsen
 * @author Oliver Tili
 *********************************************************************/
public class Hashtable implements Map {

	LinkedList[] table;
	int arraySize;
	int items = 0;

	public Hashtable(int arraySize) {
		table = new LinkedList[arraySize];
		for (int i = 0; i < arraySize; i++) {
			table[i] = new LinkedList();
		}

	}

	class Pair {

		private int key;
		private String value;

		public Pair(int key, String value) {
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uebung2.Map#put(int, java.lang.String)
	 */
	@Override
	public Object put(int key, String value) {
		int hash = key & arraySize;
		while (table[hash] != null) {
			table[hash] = new LinkedList();

		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uebung2.Map#get(int)
	 */
	@Override
	public Object get(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uebung2.Map#remove(int)
	 */
	@Override
	public Object remove(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {

		Hashtable hash = new Hashtable(11);

		hash.put(1, "Sven");
		System.out.println(hash.arraySize);

	}
}
