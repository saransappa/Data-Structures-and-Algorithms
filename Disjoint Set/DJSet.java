
public class DJSet {
	int size;
	DSNode [] node;
	int [] labels;
	
	DJSet(int s, int[] lab){
		size = s;
		node = new DSNode[s];
		labels = lab;
		for(int i=0;i<size;i++) {
			node[i] = new DSNode(labels[i]);
		}
	}
	
	public DSNode find(int key) {
		DSNode temp=null;
		for(int i=0;i<size;i++) {
			if(node[i].label == key) {
				temp=node[i];
			}
		}
		return temp.getRoot();
	}
	
	public void print() {
		for(int i=0;i<size;i++) {
			System.out.println("("+node[i].label+","+find(node[i].label).label+")");
		}
	}
	
	public void union(int k1,int k2) {
		DSNode root1 = find(k1);
		DSNode root2 = find(k2);
		root2.parent = root1;
	}
	
}
