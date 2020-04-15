
public class AVL_Tree {
	AVL_Node root =null;
	public boolean search(int d) {
		if(root ==null) {
			return false;
		}
		else {
			return root.search(d);
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
	
	public void insert(int d) {
		if(root ==null) {
			root = new AVL_Node(d);
		}
		else {
			root = root.insert(d);
		}
		
	}
	public int height() {
		return root.height();
	}
}
