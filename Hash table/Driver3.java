// Testing HashTable3.java
public class Driver3 {

	public static void main(String[] args) {
		HashTable3 h = new HashTable3();
		h.put(100, 20);
		h.put(24, 10);
		h.put(12, 5);
		h.put(20, 3);
		h.put(30, 8);
		h.put(4, 29);
		h.put(40, 7);
		h.put(18, 13);
		h.print();
		h.remove(4);
		h.print();
		System.out.println(h.contains(18));
		System.out.println(h.get(24));
		h.remove(99);
	}

}
