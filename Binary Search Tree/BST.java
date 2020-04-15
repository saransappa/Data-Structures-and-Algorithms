
public class BST {
	BSTNode root = null;
	
	public void insert(int d) {
		if(root==null) {
			root= new BSTNode(d);
		}
		else {
			root.insert(d);
		}
	}
	
	public void inorder() {
		if(root == null) {
			return;
		}
		else {
			root.inorder();
		}
	}
	
	public void preorder() {
		if(root == null) {
			return;
		}
		else {
			root.preorder();
		}
	}
	
	public void postorder() {
		if(root == null) {
			return;
		}
		else {
			root.postorder();
		}
	}
	
	public boolean search(int k) {
		if(root == null) {
			return false;
		}
		else {
			return root.search(k);
		}
	}
	
	public int minimum() {
		if(root == null) {
			return -99999999;
		}
		else {
			return root.minimum();
		}
	}
	
	public int maximum() {
		if(root == null) {
			return 99999999;
		}
		else {
			return root.maximum();
		}
	}
	
	public int height() {
		if(root == null) {
			return 0;
		}
		else {
			return root.height();
		}
	}
	
	public int predecessor(int d) {
		if(root == null) {
			return -99999999;
		}
		else {
			if(root.search(d)) {
				return root.predecessor(d);
			}
			else {
				return -99999999;
			}
		}
	}
	
	public int successor(int d) {
		if(root == null) {
			return -99999999;
		}
		else {
			if(root.search(d)) {
				return root.successor(d);
			}
			else {
				return -99999999;
			}
		}
	}
	
	public boolean delete(int d) {
		if(root == null) {
			return false;
		}
		else {
			return root.delete(d);
		}
	}
	
}
