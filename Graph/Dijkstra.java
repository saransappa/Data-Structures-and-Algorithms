import java.util.*;
class The_Comparator implements Comparator<GraphNode> { 
    public int compare(GraphNode a, GraphNode b) 
    { 
    	if(a.dist > b.dist) {
    		return 1;
    	}
    	else return -1;
    } 
} 
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
	
	
	
	public int djk(int a, int b) {
		node[a].dist = 0;
		PriorityQueue <GraphNode> q= new PriorityQueue<GraphNode>(new The_Comparator());
		for(int i=0;i<size;i++) {
			q.add(node[i]);
		}
		while(!q.isEmpty()) {
			GraphNode n = q.poll();
			for(int i=0;i<n.adjlist.size();i++) {
				//System.out.println(n.label + " -> "+ n.adjlist.get(i).label);
				if(n.adjlist.get(i).dist > n.dist + n.dict.get(n.adjlist.get(i).label)) {
					q.remove(n.adjlist.get(i));
					n.adjlist.get(i).dist = n.dist + n.dict.get(n.adjlist.get(i).label);
					n.adjlist.get(i).prev = n;
					q.add(n.adjlist.get(i));
					//print_dist();
				}
			}
			//System.out.println("Size = "+q.size());
		}
		return node[b].dist;
	}
}

public class Dijkstra {
	public static void main(String [] args) {
		// 10000 is considered as infinity
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
		int u = scan.nextInt()-1;
		int v = scan.nextInt()-1;
		//g.print_dist();
		int k = g.djk(u, v);
		if(k>=0 && k!=10000) {
			System.out.println(k);
		}
		else {
			System.out.println(-1);
		}
		//g.print_dist();
		scan.close();
	}
}
