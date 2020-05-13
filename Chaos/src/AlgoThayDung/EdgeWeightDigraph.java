package AlgoThayDung;

import java.util.ArrayList;

public class EdgeWeightDigraph {
	private int V;
	private int E;
	private DirectedEdge[] adj;
	
	public EdgeWeightDigraph(int V, int E) {
		this.V = V;
		this.E = E;
		adj = new DirectedEdge[V];
		
		for (int i=0; i< V; i++) {
//			adj[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(DirectedEdge e) {
//		adj[]
	}
}
