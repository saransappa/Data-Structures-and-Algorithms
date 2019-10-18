
public class Driver {
	public static void main(String [] args) {
		AVL_Tree t = new AVL_Tree();
		t.insert(15);
		t.insert(20);
		t.insert(24);
		t.insert(10);
		t.insert(13);
		t.insert(7);
		t.insert(30);
		t.insert(36);
		t.insert(25);
		System.out.println(t.root.right.left.computeBalance());
		System.out.println("---------- PREORDER ---------");
		t.preorder();
		System.out.println("---------- INORDER ---------");
		t.inorder();
		System.out.println("---------- POSTORDER ---------");
		t.postorder();
		System.out.println(t.height());
		System.out.println(t.search(8));
		System.out.println(t.search(7));
	}
}
