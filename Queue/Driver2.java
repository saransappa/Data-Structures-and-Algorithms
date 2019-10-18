import java.util.*;
public class Driver2 {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		int k =scan.nextInt();
		CircularQueue q = new CircularQueue(k);
		//System.out.println(q.dequeue());

		System.out.println(q.isEmpty());
		q.enqueue(5);
		System.out.println(q.isEmpty());
		//System.out.println(q.dequeue());
		q.enqueue(50000);
		System.out.println(q.isEmpty());
		System.out.println(q.dequeue());

		scan.close();
	}
}
