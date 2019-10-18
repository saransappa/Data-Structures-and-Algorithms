import java.util.*;

public class GraphNode{
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