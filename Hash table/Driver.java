// Testing HashTable.java
public class Driver {
	public static void main(String [] args) {
		HashTable ht = new HashTable();
		ht.put(36,36);
		ht.put(72,72);
		ht.put(18,18);
		ht.put(6,6);
		ht.put(42, 42);
		ht.print();
		ht.remove(36);
		ht.print();
		System.out.println(ht.get(42));
		System.out.println(ht.contains(72));
	}
}
