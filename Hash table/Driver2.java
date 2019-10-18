// Testing HashTable2.java
public class Driver2 {
	public static void main(String [] args) {
		HashTable2 h = new HashTable2();
		h.put(100, 20);
		h.put(24, 10);
		h.put(12, 5);
		h.put(20, 3);
		h.put(30, 8);
		h.put(4, 29);
		h.put(40, 7);
		h.put(18, 13);
		h.print();
		System.out.println(h.get(11));
		System.out.println(h.contains(31));
		h.remove(11);
		h.print();
	}
}
