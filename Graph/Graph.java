import java.util.LinkedList;
import java.util.Queue;

public class Graph{
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
	
	public void dfs() {
		for(int i=0;i<size;i++) {
			if(!node[i].visited) {
				node[i].dfs();
			}
		}
	}
	
	Queue <GraphNode> q = new LinkedList <GraphNode>();

	public void bfs() {
		System.out.print(node[0].label + " ");
		//node[0].visited = true;
		while(!q.isEmpty()) {
			q.poll();
		}
		q.add(node[0]);
		while(!q.isEmpty()) {
			GraphNode n = q.poll();
			for(int i=0;i<n.adjlist.size();i++) {
				if(!n.adjlist.get(i).visited) {
					System.out.print(n.adjlist.get(i).label + " ");
					q.add(n.adjlist.get(i));
				}
			}
			n.visited = true;
		}
		for(int i=0;i<size;i++) {
			if(node[i].visited == true) {
				node[i].visited = false;
			}
		}
	}
}