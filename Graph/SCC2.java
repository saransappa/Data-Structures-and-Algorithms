import java.util.*;

class GraphNode{
	int label;
	ArrayList <GraphNode> adjlist;
	boolean visited;
	
	GraphNode(int l){
		label = l;
		visited = false;
		adjlist = new ArrayList <GraphNode> ();
	}
	
	public void print() {
		for(int i=0;i<adjlist.size();i++) {
			System.out.print(adjlist.get(i).label + "->");
		}
	}
	
	public ArrayList<Integer> r_dfs(ArrayList <Integer> a) {
		
		visited = true;
		
		for(int i=0;i<adjlist.size();i++) {
			if(!adjlist.get(i).visited) {
				a = adjlist.get(i).r_dfs(a);
			}
		}
		//System.out.print(label + " ");
		a.add(label);
		return a;
	}
	
	public void dfs() {
		//System.out.print(label + " ");
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
	
	public void reverse() {
		GraphNode [] node1;
		node1 = new GraphNode[size];
		for(int i=0;i<size;i++) {
			node1 [i] = new GraphNode(i);
		}
		for(int i=0;i<size;i++) {
			for(int j=0;j<node[i].adjlist.size();j++) {
				node1[node[i].adjlist.get(j).label].adjlist.add(node1[i]);
			}
		}
		node = node1;
	}
	
	public ArrayList<Integer> r_dfs() {
		ArrayList <Integer> a = new ArrayList<Integer>();
		for(int i=0;i<size;i++) {
			if(!node[i].visited) {
				a = node[i].r_dfs(a);
			}
		}
		return a;
	}
	
	public void dfs(ArrayList<Integer> list) {
		for(int i=0;i<size;i++) {
			if(node[i].visited == true) {
				node[i].visited = false;
			}
		}
		int c=0;
		for(int i=list.size()-1;i>=0;i--) {
			if(!node[list.get(i)].visited) {
				node[list.get(i)].dfs();
				c++;
			}
		}
		System.out.println(c);
	}
}

public class SCC2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Graph g = new Graph(n);
		int m = scan.nextInt();
		for(int i=0;i<m;i++) {
			int a = scan.nextInt()-1;
			int b = scan.nextInt()-1;
			g.addEdge(a, b);
		}
		ArrayList<Integer> list = g.r_dfs();
		g.reverse();
		g.dfs(list);
		scan.close();
	}
}

