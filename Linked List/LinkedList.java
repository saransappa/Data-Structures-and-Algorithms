package linked_list_saran;

public class LinkedList {
	public Node head=null;
	public void insertAtHead(int x) {
		Node newnode = new Node(x);
		newnode.next=head;
		head=newnode;
	}
	public void insertAtTail(int x) {
		if(head==null) {
			Node newnode = new Node(x);
			head=newnode;
		}
		else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			Node newnode= new Node(x);
			temp.next=newnode;
		}
	}
	public void insertAtK(int x,int pos) {
		Node temp=head;
		int k=0;
		while(k<pos-1) {
			temp=temp.next;
			k=k+1;
		}
		Node newnode=new Node(x);
		newnode.next=temp.next;
		temp.next=newnode;
	}
	
	public void traversal() {
		if(head==null){
			System.out.println("List is empty!");
		}
		else {
			Node temp=head;
			while(temp!=null) {
				System.out.println(temp.data);
				temp=temp.next;       
			}
		}
	}
	public void search(int x) {
		Node temp=head;
		int k=0;
		while(temp!=null) {
			if(temp.data==x) {
				System.out.println("The element "+x+" is found at the position "+k);
				return;
			}
			temp=temp.next;
			k++;
		}
		System.out.println("The element "+x+" is not found."); 	
	}
	public void countNodes() {
		Node temp=head;
		int k=0;
		while(temp!=null) {
			temp=temp.next;
			k++;
		}
		System.out.println("There are "+k+" nodes in this linked list.");
	}
	public void evenData() {
		Node temp=head;
		while(temp!=null) {
			if(temp.data%2==0) {
				System.out.print(temp.data+" ");
			}
			temp=temp.next;
		}	
	}
	public void middleElementDoubleIteration() {
		Node temp=head;
		int k=0;
		while(temp!=null) {
			temp=temp.next;
			k++;
		}
		//System.out.println(k);
		if(k%2!=0) {
			Node temp2=head;
			int s=0;
			while(temp2!=null) {
				if(s==k/2) {
					System.out.println(temp2.data);
				}
				s++;
				temp2=temp2.next;       
			}
		}
		else {
			Node temp3=head;
			int s=0;
			while(temp3!=null) {
				if(s==(k/2)-1) {
					System.out.println(temp3.data);
				}
				if(s==k/2) {
					System.out.println(temp3.data);
				}
				s++;
				temp3=temp3.next;       
			}
		}
	}
	public void insertSorted(int x) {
		Node temp=head;
		while(temp!=null) {
			if(temp.data>x) {
				Node newnode= new Node(x);
				newnode.next=temp;
				temp=newnode;
				return;
			}
			temp=temp.next;
		}
	}
	public void deleteAtK(int k) {
		if(head==null) {
			System.out.println("Empty list!!!");
		}
		if(k==0) {
			head=head.next;}
		else {
			Node temp=head;
			int pos=0;
			while(pos<k-1){
				temp=temp.next;
				pos++;
			}
			temp.next=temp.next.next;
		}
	}
	public void middleElementSingleIteration() {
		Node prev=head;
		Node slow=head;
		Node fast=head;
		while(fast!=null && fast.next!=null  ) {
			prev=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		if(fast==null){ // Works in case of even sized linked list
			System.out.println("The middle element is: "+prev.data);
		}
		System.out.println("The middle element is: "+slow.data);
	}
	public void sort(){
		Node temp1=head;
		Node temp2=head;
		for(;temp1!=null;temp1=temp1.next)
		{
			for(temp2=temp1.next;temp2!=null;temp2=temp2.next)
			{
				if(temp2.data < temp1.data) {
					int t=temp1.data;
					temp1.data=temp2.data;
					temp2.data=t;
				}
			}
		}
	}
	public void rotateKTimes(int k) {
		for(int i=0;i<k;i++) {
			Node temp=head;
			Node prev=head;
			while(temp.next!=null) {
				prev=temp; 
				temp=temp.next;
			}
			temp.next=head;
			prev.next=null;
			head=temp;
			
		}
	}
	public void removeDuplicates() {
		Node temp1=head;
		Node temp2=temp1.next;
		while(temp1!=null) {
			Node prev=temp2;
			while(temp2!=null) {
				if(temp1.data==temp2.data) {
					prev.next=temp2.next;
				}
				prev=temp2;
				temp2=temp2.next;
			}
			temp2=temp1.next;
			temp1=temp1.next;
		}
	}
	

}
