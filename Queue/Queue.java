
public class Queue {
	Node front= null;
	Node rear =null;
	public void enqueue(int value) {
		Node newnode = new Node();
		newnode.data = value;
		if(front==null && rear==null) {
			front=newnode;
			rear=newnode;
		}
		else{
			rear.next=newnode;
			rear = newnode;
		}
	}
	public int dequeue() {
		if(front==null && rear==null) {
			System.out.println("Underflow occured!!!");
			return -1;
		}
		else if(front==rear) {
			int k =front.data;
			front=null;
			rear=null;
			return k;
		}
		else {
			int k =front.data;
			front=front.next;
			return k;
		}
	}
	public boolean isEmpty() {
		if(front==rear) {
			return true;
		}
		else {
			return false;
		}
	}
}
