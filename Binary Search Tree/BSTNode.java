
public class BSTNode {
	int data;
	BSTNode left;
	BSTNode right;
	BSTNode parent;
	
	BSTNode(int d){
		data = d;
		left = null;
		right = null;
		parent = null;
	}
	
	public void insert(int d) {
		if(data < d) {
			if(right == null) {
				right = new BSTNode(d);
				right.parent = this;
			}
			else {
				right.insert(d);
			}
		}
		else {
			if(left == null) {
				left = new BSTNode(d);
				left.parent = this;
			}
			else {
				left.insert(d);
			}
		}
	}
	
	public void inorder() {
		if(left!=null) {
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
			left.preorder();
		}
		if(right!=null) {
			right.preorder();
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
	
	public boolean search(int k) {
		if(data == k) {
			return true;
		}
		else if(data > k) {
			if(left!=null) {
				return left.search(k);
			}
			else {
				return false;
			}
		}
		else {
			if(right!=null) {
				return right.search(k);
			}
			else {
				return false;
			}
		}
	}
	
	public int minimum() {
		if(left!=null) {
			return left.minimum();
		}
		else {
			return data;
		}
	}
	
	public int maximum() {
		if(right!=null) {
			return right.maximum();
		}
		else {
			return data;
		}
	}
	
	public int max(int a,int b) {
		if(a>b) {
			return a;
		}
		else {
			return b;
		}
	}
	
	public int height() {
		if(left == null && right == null) {
			return 1;
		}
		else if(left!=null && right == null) {
			return left.height()+1;
		}
		else if(right!=null && left == null) {
			return right.height()+1;
		}
		else {
			return max(right.height(),left.height())+1;
		}
	}
	
	public int predecessor(int d) {
		if(data == d) {
			if(left!=null) {
				return left.maximum();
			}
			else {
				BSTNode t = this.parent;
				BSTNode p = this;
				while(t!=null && t.right != p) {
					p = t;
					t = t.parent;
				}
				int k = -99999999;
				try {
					if(t==null) {
						throw new NullPointerException("No predecessor for the node "+d);
					}
					else {
						k=t.data;
					}
				}
				catch(NullPointerException e) {
					System.out.println(e.getMessage());
				}
				
				return k;
			}
		}
		else if(data < d && right!=null) {
			return right.predecessor(d);
		}
		else if(data > d && left!=null){
			return left.predecessor(d);
		}
		else {
			return -99999999;
		}
	}
	
	public int successor(int d) throws NullPointerException{
		if(data == d) {
			if(right!=null) {
				return right.minimum();
			}
			else {
				BSTNode t= this.parent;
				BSTNode p = this;
				while(t!=null && t.left!=p) {
					p = t;
					t = t.parent;
				}
				int k = -99999999;
				try {
					if(t==null) {
						throw new NullPointerException("No successor for the node "+d);
					}
					else {
						k=t.data;
					}
				}
				catch(NullPointerException e) {
					System.out.println(e.getMessage());
				}
				
				return k;
			}
		}
		else if(data > d && left!=null) {
			return left.successor(d);
		}
		else if(data < d && right!=null){
			return right.successor(d);
		}
		else {
			return -99999999;
		}
	}
	
	public boolean delete(int d) {
		if(data == d) {
			if(left==null && right == null) {
				BSTNode k = this.parent;
				if(k.left == this) {
					k.left = null;
					return true;
				}
				else {
					k.right = null;
					return true;
				}
			}
			else if(left!=null && right == null) {
				BSTNode k = this.parent;
				if(k.left == this) {
					k.left = this.left;
					return true;
				}
				else {
					k.right = this.left;
					return true;
				}
			}
			else if(left == null && right!=null) {
				BSTNode k = this.parent;
				if(k.left == this) {
					k.left = this.right;
					return true;
				}
				else {
					k.right = this.right;
					return true;
				}
			}
			else {
				int k = this.predecessor(data);
				this.delete(this.predecessor(data));
				data = k;
				return true;
			}
		}
		else if(data > d && left!=null) {
			return left.delete(d);
		}
		else if(data < d && right!=null){
			return right.delete(d);
		}
		else {
			return false;
		}
	}
}
