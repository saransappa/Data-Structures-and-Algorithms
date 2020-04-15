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
	
	public void dfs() {
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
		node[to].adjlist.add(node[from]);
	}
	
	public void print() {
		for(int i=0;i<size;i++) {
			System.out.print("\n"+i+": ");
			node[i].print();
		}
		System.out.println();
	}
	
	public int dfs() {
		int count = 0;
        for(int i=0;i<size;i++) {
			if(node[i].visited == true) {
				node[i].visited = false;
			}
		}
        for(int i=0;i<size;i++) {
        	if(node[i].visited == false) {
        		node[i].dfs();
        	}
        	else {
        		continue;
        	}
        	count++;
        }
        return count;
	}
}
public class Connected_components {
	public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        
        Graph g = new Graph(n);
        for(int i=0;i<m;i++){
            g.addEdge(scan.nextInt()-1,scan.nextInt()-1);    
        }
        System.out.println(g.dfs());
        scan.close();
    }
}
