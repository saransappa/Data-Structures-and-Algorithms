// This code can't handle collisions
public class HashTable {
	int size = 997;
	HashNode [] harr = new HashNode[size];
	
	public int hash(int k) {
		return k%size;
	}
	
	public void put(int k,int v) {
		HashNode hn = new HashNode(k,v);
		int index = hash(k);
		harr[index] = hn;
	}
	
	public int get(int k) {
		int index = hash(k);
		if(harr[index]!=null) {
			return harr[index].value;
		}
		else {
			System.out.println("The key provided is invalid!!!");
			return Integer.MAX_VALUE;
		}
	}
	
	public boolean contains(int k) {
		int index = hash(k);
		if(harr[index]!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void remove(int k) {
		int index = hash(k);
		if(harr[index]!=null) {
			System.out.println("<"+harr[index].key+","+harr[index].value+"> is removed");
			harr[index] = null;
		}
	}
	
	public void print() {
		for(int i=0;i<harr.length;i++) {
			if(harr[i]!=null) {
				System.out.println("<"+harr[i].key+","+harr[i].value+">");
			}
		}
	}
}
