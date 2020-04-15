import java.util.*;

class GraphNode{
	int label;
	ArrayList <GraphNode> adjlist;
	int visited;
	
	GraphNode(int l){
		label = l;
		visited = 0;
		adjlist = new ArrayList <GraphNode> ();
	}
	
	public void print() {
		for(int i=0;i<adjlist.size();i++) {
			System.out.print(adjlist.get(i).label + "->");
		}
	}
	
	public int dfs() {
		//System.out.print(label + " ");
		visited = 1;
		
		for(int i=0;i<adjlist.size();i++) {
			if(adjlist.get(i).visited ==0) {
				adjlist.get(i).dfs();
			}
			else if(adjlist.get(i).visited ==1) {
				return 1;
			}
		}
		visited = 2;
		return 0;
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
	
	public void addEdge(int from,int to) {
		node[from].adjlist.add(node[to]);
	}
	
	public void print() {
		for(int i=0;i<size;i++) {
			System.out.print("\n"+i+": ");
			node[i].print();
		}
		System.out.println();
	}
	
	public int dfs() {
		int k = -1;
		for(int i=0;i<size;i++) {
			if(node[i].visited==0) {
				k=node[i].dfs();
			}
			else if(node[i].visited==1) {
				return 1;
			}
			if(k==1) {
				return 1;
			}
		}
		return 0;
	}
}

public class Acyclicity {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Graph g = new Graph(n);
		int m = scan.nextInt();
		for(int i=0;i<m;i++) {
			g.addEdge(scan.nextInt()-1, scan.nextInt()-1);
		}
		//g.print();
		System.out.println(g.dfs());
		scan.close();
	}
}
