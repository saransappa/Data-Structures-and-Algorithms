// This code handles collisions using linear probing method
public class HashTable3 {
	int size = 997;
	HashNode [] harr;
	
	HashTable3(){
		harr = new HashNode[size];
	}
	
	public int hash(int k) {
		return k%size;
	}
	
	public void put(int k,int v) {
		int index = hash(k);
		HashNode h = new HashNode(k,v);
		if(harr[index]==null) {
			harr[index]= h;
		}
		else {
			while(harr[index]!=null) {
				index=(index+1)%size;
			}
			harr[index]=h;
		}
	}
	
	public int get(int k) {
		int ind = hash(k);
		if(harr[ind]==null) {
			System.out.println("Invalid Key!!!");
			return Integer.MAX_VALUE;
		}
		else if(harr[ind].key == k) {
			return harr[ind].value;
		}
		else {
			int f = ind;
			do {
				ind=(ind+1)%size;
			}
			while((harr[ind]!=null || ind!=f )&& harr[ind].key!=k);
			if(harr[ind]==null) {
				System.out.println("Invalid Key!!!");
				return Integer.MAX_VALUE;
			}
			else {
				return harr[ind].value;
			}
		}
	}
	
	public boolean contains(int k) {
		int ind = hash(k);
		if(harr[ind]==null) {
			System.out.println("Invalid Key!!!");
			return false;
		}
		else if(harr[ind].key == k) {
			return true;
		}
		else {
			int f = ind;
			do {
				ind=(ind+1)%size;
			}
			while((harr[ind]!=null || ind!=f )&& harr[ind].key!=k);
			if(harr[ind]==null) {
				System.out.println("Invalid Key!!!");
				return false;
			}
			else {
				return true;
			}
		}
	}
	
	public void remove(int k) {
		int ind = hash(k);
		if(harr[ind]==null) {
			System.out.println("Invalid Key!!!");
		}
		else if(harr[ind].key == k) {
			System.out.println("<"+harr[ind].key+","+harr[ind].value+"> is removed");
			harr[ind]=null;
		}
		else {
			int f = ind;
			do {
				ind=(ind+1)%size;
			}
			while((harr[ind]!=null || ind!=f )&& harr[ind].key!=k);
			if(harr[ind]==null) {
				System.out.println("Invalid Key!!!");
			}
			else {
				System.out.println("<"+harr[ind].key+","+harr[ind].value+"> is removed");
				harr[ind]=null;
			}
		}
	}
	
	public void print() {
		for(int i=0;i<size;i++) {
			if(harr[i]!=null) {
				System.out.println("<"+harr[i].key+","+harr[i].value+">");
			}
		}
	}
}
