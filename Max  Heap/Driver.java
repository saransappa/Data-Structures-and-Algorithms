
public class Driver {
	public static void main(String args[]) {
		maxHeap m1 = new maxHeap(5);
		m1.insert(10);
		m1.insert(20);
		m1.insert(500);
		m1.print();
		System.out.println("MAX --> "+m1.extractMax());
		m1.delete(1);
		m1.print();
		System.out.println("MAX --> "+m1.extractMax());
	}
}
