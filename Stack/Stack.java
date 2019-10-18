
public class Stack {
	Node top=null;
	public void push(char x) {
		Node newnode = new Node();
		newnode.data=x;
		newnode.next=top;
		top=newnode;
	}
	public void pop() {
		if(top==null) {
			System.out.println("Undeflow Occured!!!");
		}
		else {
			top=top.next;
		}
	}
	public char top() {
		if(top!=null) {
			return top.data;
		}
		else {
			System.out.println("Empty Stack!!!");
			return 'o';
		}
	}
	public boolean isEmpty() {
		if(top==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
