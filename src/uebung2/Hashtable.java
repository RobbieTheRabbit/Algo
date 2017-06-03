package uebung2;

import java.util.*;

/*********************************************************************
 * Zweite praktische uebung von Algorithmen SS17
 * Die Klasse erzeugt ein Hashtable aus LinkedList Arrays.
 * Als Kollisionsbehandlung: Verkettung ueberlaeufer
 * 
 * @author Sven Böhrnsen
 * @author Oliver Tili 
 *********************************************************************/
public class Hashtable<K, V> implements Map<K, V> {

	private LinkedList<Pair<K, V>>[] table;

	/*********************************************************************
	 * Konstruktor fuer die Hashtable, dass eine LinkedList Array mit
	 * einer beliebigen Groeße erstellt
	 * 
	 * @param length Laenge des zu erzeugenden Arrays
	 *********************************************************************/
	public Hashtable(int length) {
		table = new LinkedList[length];

		for (int i = 0; i < length; i++) {
			table[i] = new LinkedList<Pair<K, V>>();
		}
	}

	/*********************************************************************
	 * Funktion fuer die Berechnung der Indexstelle für das 
	 * LinkedList Array
	 * 
	 * @param key Schluessel
	 * @return Berechnete Indexstelle
	 *********************************************************************/
	public int hashFunction(K key) {
		return key.hashCode() % table.length;
	}

	class Pair<K, V> {

		private K key;
		private V value;

		/*********************************************************************
		 * @param key Der Schluessel
		 * @param value Der Wert
		 *********************************************************************/
		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		/*********************************************************************
		 * @return den Schluessel
		 *********************************************************************/
		public K getKey() {
			return key;
		}

		/*********************************************************************
		 * @param key setzt den Schluessel
		 *********************************************************************/
		public void setKey(K key) {
			this.key = key;
		}

		/*********************************************************************
		 * @return den Wert
		 *********************************************************************/
		public V getValue() {
			return value;
		}

		/*********************************************************************
		 * @param value setzt den Wert
		 *********************************************************************/
		public void setValue(V value) {
			this.value = value;
		}

		public String toString() {
			return "[" + this.key.toString() + ": " + "\"" + this.value.toString() + "\"" + "]";
		}
	}

	@Override
	public V put(K key, V value) {
		int hash = hashFunction(key);
		if (table[hash].isEmpty()) {
			table[hash].add(new Pair<K, V>(key, value));
			return null;
		} else {
			for (int i = 0; i < table[hash].size(); i++) {
				Pair<K, V> create = table[hash].get(i);
				if (create.getKey().equals(key)) { //	Wenn Der Schluessel schon im Array existiert
					V update = create.getValue();
					create.setValue(value);
					return update;
				}
			}
			table[hash].add(new Pair<K, V>(key, value));
		}
		return null;
	}

	@Override
	public V get(K key) {
		int hash = hashFunction(key);
		if (!table[hash].isEmpty()) {
			for (int i = 0; i < table[hash].size(); i++) {
				Pair<K, V> read = table[hash].get(i);
				if (read.getKey().equals(key))
					System.out.println("Der Schluessel " + key + " hat den Wert: " + read.getValue());
			}
		}
		return null;
	}

	@Override
	public V remove(K key) {
		int hash = hashFunction(key);
		if (!table[hash].isEmpty()) {
			for (int i = 0; i < table[hash].size(); i++) {
				Pair<K, V> delete = (Pair<K, V>) table[hash].get(i);
				if (delete.getKey().equals(key)) {
					table[hash].remove(delete);
					System.out.println(key + " samt Wert entfernt!");
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		System.out.println("			    --Hashtable--");
		System.out.println("---------------------------------------------------------------------------");
		for (int i = 0; i < table.length; i++) {
			sb.append("[ " + i + " ]");
			for (int y = 0; y < table[i].size(); y++) {
				sb.append("--->");
				Pair<K, V> output = table[i].get(y);
				sb.append(output.toString());
			}
			sb.append("\n");
		}
		return sb.toString();
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		Hashtable hash = new Hashtable(11);

		hash.put(23, 23); // 23 mod 11 = 1
		hash.put(58, 58); // 58 mod 11 = 3
		hash.put(61, 61); // 61 mod 11 = 6
		hash.put(85, 85); // 85 mod 11 = 8
		hash.put(34, 34); // 34 mod 11 = 1
		hash.put(17, 17); // 17 mod 11 = 6
		hash.put(78, 78); // 78 mod 11 = 1

		hash.put(87, "Sven"); // 87 mod 11 = 10

		System.out.println(hash);
		hash.get(87);
		// hash.remove(34);
		// System.out.println(hash);
	}
}