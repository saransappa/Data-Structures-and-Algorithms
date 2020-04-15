
public class AVL_Node {
	int data;
	AVL_Node left;
	AVL_Node right;
	int balanceFactor;
	
	AVL_Node(int d){
		data = d;
		left = null;
		right = null;
		balanceFactor = 0;
	}
	
	public boolean search(int d) {
		if(data == d) {
			return true;
		}
		else if(data > d && left!=null) {
			return left.search(d);
		}
		else if(data < d && right!=null){
			return right.search(d);
		}
		else {
			return false;
		}
	}
	
	public void inorder() {
		if(left != null) {
			left.inorder();
		}
		System.out.println(data);
		if(right!=null) {
			right.inorder();
		}
	}
	
	public void preorder() {
		System.out.println(data);
		if(left!=null) {
			left.inorder();
		}
		if(right!=null) {
			right.inorder();
		}
	}
	
	public void postorder() {
		if(left!=null) {
			left.postorder();
		}
		if(right!=null) {
			right.postorder();
		}
		System.out.println(data);
	}
	
	public int max(int a,int b) {
		if(a>b) {
			return a;
		}
		else {
			return b;
		}
	}
	
	public int height(){
		if(left==null && right == null) {
			return 1;
		}
		else if(right == null) {
			return left.height()+1;
		}
		else if(left==null) {
			return right.height()+1;
		}
		else {
			return max(left.height(),right.height())+1;
		}
	}
	
	public int computeBalance() {
		if(left == null && right == null) {
			return 0;
		}
		else if(left == null) {
			return -1*(right.height());
		}
		else if(right == null) {
			return left.height();
		}
		else {
			return left.height()-right.height();
		}
	}
	
	public AVL_Node rotateWithLeft() {
		AVL_Node lc = left;
		left = lc.right;
		lc.right = this;
		balanceFactor = computeBalance();
		lc.balanceFactor = lc.computeBalance();
		return lc;
	}
	
	public AVL_Node rotateWithRight() {
		AVL_Node rc = right;
		right = rc.left;
		rc.left = this;
		balanceFactor = computeBalance();
		rc.balanceFactor = rc.computeBalance();
		return rc;
	}
	
	public AVL_Node insert(int d) {
		if(d<data) {
			if(left == null) {
				left = new AVL_Node(d);
			}
			else {
				left=left.insert(d);
			}
		}
		else {
			if(right == null) {
				right = new AVL_Node(d);
			}
			else {
				right=right.insert(d);
			}
		}
		this.balanceFactor =this.computeBalance();
		switch(balanceFactor) {
			case 2:
				if(left.computeBalance()>= 0) {
					return rotateWithLeft();
				}
				else {
					left = left.rotateWithRight();
					return rotateWithLeft();
				}
			case -2:
				if(right.computeBalance()<0) {
					return rotateWithRight();
				}
				else {
					right = right.rotateWithLeft();
					return rotateWithRight();
				}
		}
		return this;
	}
}
