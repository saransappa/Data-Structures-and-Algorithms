
public class Driver {
	public static void main(String[] args) {
		Queue q = new Queue();
		System.out.println(q.isEmpty());
		System.out.println(q.dequeue());
		System.out.println(q.isEmpty());

		q.enqueue(10);
		System.out.println(q.dequeue());
		q.enqueue(1000);
		q.enqueue(50);
		q.enqueue(560);
		System.out.println(q.dequeue());

		q.enqueue(789);
		System.out.println(q.isEmpty());
		q.enqueue(105);
		System.out.println(q.dequeue());

		q.enqueue(210);
		System.out.println(q.isEmpty());

	}
}
