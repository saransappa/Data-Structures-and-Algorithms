package linked_list_saran;

public class Driver {
	public static void main(String[] args) {
		LinkedList ll1=new LinkedList();
		ll1.insertAtTail(1000);
		ll1.insertAtHead(100);
		ll1.insertAtHead(100);
		//ll1.traversal();
		ll1.insertAtTail(1500);
		ll1.insertAtHead(0);
		//ll1.traversal();
		ll1.insertAtK(600,1);
		//ll1.traversal();
		//ll1.search(10);
		//ll1.countNodes();
		//ll1.evenData();
		ll1.insertSorted(600);
		//ll1.traversal();
		//ll1.deleteAtK(2);
		//ll1.traversal();
		//ll1.middleElementSingleIteration();
		
		ll1.insertAtHead(1500);
		ll1.insertAtK(8989,3);
		//ll1.sort();
		//System.out.println("*************");
		//ll1.traversal();
		//ll1.rotateKTimes(3);
		//System.out.println("*************");

		ll1.traversal();
		//System.out.println("*************");

		ll1.removeDuplicates();
		System.out.println("*************");
		ll1.traversal();		
		System.out.println("*************");
		ll1.sort();
		ll1.traversal();
	}
}
