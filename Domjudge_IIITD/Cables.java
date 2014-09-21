import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;





class Vertex implements Iterable<Edge> 
{
	List<Edge> adj ;
	public Vertex () {
		adj = new ArrayList<Edge>();
	}
	public void add (Edge e ) {
		adj.add ( e ) ;
	}
	public Iterator <Edge> iterator ( ) {
		return adj.iterator ( ) ;
	}
}

class Edge implements Comparable<Edge> {
	public int from , to , weight ;
	public Edge ( int f , int t , int w) {
		from = f ;
		to = t ;
		weight = w;
	}
	@Override
	public int compareTo(Edge arg0) {
		return this.weight - arg0.weight ;
	}
}

public class Cables {
	
	static int distance ( Vertex [ ] graph , int source , int destination) {
		int [] sp = new int [graph.length];
		Queue<Vertex> q = new LinkedList<Vertex >() ;
		Arrays.fill(sp , -1) ;
		sp [ source ] = 0 ;
		q . add ( graph [ source ] ) ;
		while ( ! q . isEmpty ( ) ) {
			Vertex v = q.poll( ) ;
			for (Edge e : v ) {
				if ( sp[e.to ] == -1) {
					sp [e.to ] = sp [ e.from ] + e.weight ;
					q.add ( graph [ e.to ] ) ;
				}
			}
		}
		return sp[destination];
	}
	
	static List<Edge> prim_mst ( Vertex [ ] graph , int source) {
		List<Edge> mst = new ArrayList<Edge>() ;
		boolean [ ] v = new boolean [ graph . length ] ;
		PriorityQueue<Edge> q = new PriorityQueue<Edge>() ;
		v [ source ] = true ;
		for (Edge e : graph [ source ] ) q . add ( e ) ;
		while ( ! q . isEmpty ( ) ) {
			Edge e = q . poll ( ) ;
			if ( v [ e . to ] ) continue ;
			v [ e . to ] = true ;
			mst . add ( e ) ;
			for (Edge adj : graph [ e . to ] ) q . add ( adj ) ;
		}
		return mst ;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int noCases = Integer.parseInt(rd.readLine());
		
		for(int z=0; z<noCases; z++)
		{
			String[] inp = rd.readLine().split(" ");
			int N = Integer.parseInt(inp[0]); int K = Integer.parseInt(inp[1]);
			
			Vertex[] Graph = new Vertex[N];
			for(int i=0; i<Graph.length; i++)
			{
				Graph[i] = new Vertex();
			}
			
			for(int i=0; i<K; i++)
			{
				inp = rd.readLine().split(" ");
				int u = Integer.parseInt(inp[0]); int v = Integer.parseInt(inp[1]); int w = Integer.parseInt(inp[2]);
				
				Graph[u].add(new Edge(u, v, w));
				Graph[v].add(new Edge(v, u, w));
			}
			
			List<Edge> MST = prim_mst(Graph, 0);
//			int sumEdges = 0;
//			int ctr = 0;
//			for(Edge e: MST)
//			{
//				sumEdges += e.weight;
//				ctr++;
//			}
			
			Graph = new Vertex[N];
			for(int i=0; i<N; i++)
			{
				Graph[i] = new Vertex();
			}
			
//			System.out.println("Edges in MST: ");
			
			for(Edge e: MST)
			{
				Graph[e.from].add(e);
				Graph[e.to].add(new Edge(e.to, e.from, e.weight));
//				System.out.println(e.from + " " + e.to + " " + e.weight);
			}
			
			
			int Q = Integer.parseInt(rd.readLine());
			for(int i=0; i<Q; i++)
			{
				inp = rd.readLine().split(" ");
				int u = Integer.parseInt(inp[0]);
				int v = Integer.parseInt(inp[1]);
				
				System.out.println(distance(Graph, u, v));
			}
			
			//System.out.println("Weight of MST: " + sumEdges + "; Edges: " + ctr + "; N: " + N);
		}
	}

}
