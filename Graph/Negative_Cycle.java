import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

class GraphNode{
	int label;
	ArrayList <GraphNode> adjlist;
	boolean visited;
	int dist;
	Dictionary<Integer,Integer> dict = new Hashtable<Integer, Integer>();
	GraphNode prev;
	GraphNode(int l){
		label = l;
		visited = false;
		dist= 10000;
		prev = null;
		adjlist = new ArrayList <GraphNode> ();
	}
	
	public void print() {
		for(int i=0;i<adjlist.size();i++) {
			System.out.print(adjlist.get(i).label + "->");
		}
	}
	
	public void dfs() {
		System.out.print(label + " ");
		visited = true;
		
		for(int i=0;i<adjlist.size();i++) {
			if(!adjlist.get(i).visited) {
				adjlist.get(i).dfs();
			}
		}
	}
}

class Graph{
	GraphNode [] node;
	int size;
	
	Graph(int s){
		size = s;
		node = new GraphNode [s];
		for(int i=0;i<size;i++) {
			node [i] = new GraphNode(i);
		}
	}
	
	public void addEdge(int from,int to, int d) {
		node[from].adjlist.add(node[to]);
		node[from].dict.put(to, d);
	}
	
	public void print() {
		for(int i=0;i<size;i++) {
			System.out.print("\n"+i+": ");
			node[i].print();
		}
		System.out.println();
	}
	
	public void dfs() {
		for(int i=0;i<size;i++) {
			if(!node[i].visited) {
				node[i].dfs();
			}
		}
	}
	
	public void print_dist() {
		for(int i=0;i<size;i++) {
			System.out.print(node[i].dist+" ");
		}
		System.out.println();
	}
	
	
	
	public int neg_cycle() {
		node[0].dist = 0;
		int p = size-1;
		while(p>0) {
		for(int k=0;k<size;k++) {
			GraphNode n = node[k];
			for(int i=0;i<n.adjlist.size();i++) {
				//System.out.println(n.label + " -> "+ n.adjlist.get(i).label);
				if(n.adjlist.get(i).dist > n.dist + n.dict.get(n.adjlist.get(i).label)) {
					n.adjlist.get(i).dist = n.dist + n.dict.get(n.adjlist.get(i).label);
					n.adjlist.get(i).prev = n;
					//print_dist();
				}
			}
		}
			p--;
		}
		String str1="";
		for(int i=0;i<size;i++) {
			str1+=node[i].dist;
		}
		for(int k=0;k<size;k++) {
			GraphNode n = node[k];
			for(int i=0;i<n.adjlist.size();i++) {
				//System.out.println(n.label + " -> "+ n.adjlist.get(i).label);
				if(n.adjlist.get(i).dist > n.dist + n.dict.get(n.adjlist.get(i).label)) {
					n.adjlist.get(i).dist = n.dist + n.dict.get(n.adjlist.get(i).label);
					n.adjlist.get(i).prev = n;
					//print_dist();
				}
			}
		}
		String str2="";
		for(int i=0;i<size;i++) {
			str2+=node[i].dist;
		}
		if(str1.equals(str2)) {
			return 0;
		}
		else {
			return 1;
		}
	}
}

public class Negative_Cycle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		Graph g = new Graph(n);
		for(int i=0;i<m;i++) {
			int a = scan.nextInt()-1;
			int b = scan.nextInt()-1;
			int c = scan.nextInt();
			g.addEdge(a, b, c);
		}
		// Prints 1 if negative cycle exists else it prints 1.
		System.out.println(g.neg_cycle());
		scan.close();
	}

}
