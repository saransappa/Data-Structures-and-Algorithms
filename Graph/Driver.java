public class Driver{
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,4);
		g.addEdge(2,1);
		g.addEdge(2,3);
		g.addEdge(3,0);
		g.addEdge(3,2);
		g.addEdge(3,4);
		g.print();
		System.out.println("------BFS---------");
		g.bfs();
		
		System.out.println("\n"+"------DFS---------");
		g.dfs();
	}
}