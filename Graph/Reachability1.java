import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

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
	
	public int dfs(int y) {
		visited = true;
		if(label == y){
            //System.out.println("1");
            return 1;
        }
		for(int i=0;i<adjlist.size();i++) {
			if(!adjlist.get(i).visited) {
				if(adjlist.get(i).dfs(y)==1) {
					return 1;
				}
            }
        }
		//System.out.println("0");
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
		node[to].adjlist.add(node[from]);
	}
	
	public void print() {
		for(int i=0;i<size;i++) {
			System.out.print("\n"+i+": ");
			node[i].print();
		}
		System.out.println();
	}
	
	public void dfs(int x,int y) {
       
        for(int i=0;i<size;i++) {
			if(node[i].visited == true) {
				node[i].visited = false;
			}
		}
        System.out.println(node[x].dfs(y));
	}
}
public class Reachability1 {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        
        Graph g = new Graph(n);
        for(int i=0;i<m;i++){
            g.addEdge(scan.nextInt()-1,scan.nextInt()-1);    
        }
        int x = scan.nextInt()-1;
        int y = scan.nextInt()-1;
        g.dfs(x,y);
        scan.close();
    }
}