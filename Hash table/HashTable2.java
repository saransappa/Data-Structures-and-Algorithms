// This code handles collisions using separate chaining method
import java.util.*;
public class HashTable2 {
	int size = 997;
	LinkedList <HashNode> harr [];
	
	HashTable2(){
		harr = new LinkedList [size];
		for(int i=0;i<harr.length;i++) {
			harr[i] = new LinkedList<HashNode>();
		}
	}
	
	public int hash(int k) {
		return k%size;
	}
	
	public void put(int k,int v) {
		int index = hash(k);
		HashNode hn = new HashNode(k,v);
		harr[index].add(hn);
	}
	
	public int get(int k) {
		int index = hash(k);
		LinkedList <HashNode> ll= harr[index];
		if(ll!=null) {
			for(int i=0;i<ll.size();i++) {
				if(ll.get(i).key==k) {
					return ll.get(i).value;
				}
			}
		}
		System.out.println("Invalid key");
		return Integer.MAX_VALUE;
	}
	
	public boolean contains(int k) {
		int index = hash(k);
		LinkedList <HashNode> ll = harr[index];
		if(ll!=null) {
			for(int i=0;i<ll.size();i++) {
				if(ll.get(i).key==k) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void remove(int k) {
		int index = hash(k);
		LinkedList <HashNode> ll = harr[index];
		if(ll!=null) {
			for(int i=0;i<ll.size();i++) {
				if(ll.get(i).key==k) {
					System.out.println("<"+ll.get(i).key+","+ll.get(i).value+"> is removed");
					ll.remove(i);
				}
			}
		}
	}
	
	public void print() {
		for(int i=0;i<size;i++) {
			if(harr[i]!=null) {
				for(int j=0;j<harr[i].size();j++) {
					if(harr[i].get(j)!=null) {
						System.out.println("<"+harr[i].get(j).key+","+harr[i].get(j).value+">");
					}
				}
			}
		}
	}
}
