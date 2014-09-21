import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author deepanker
 *
 */
class Vertex implements Iterable<Edge>
{
	int index;
	List<Edge> adj;
	public Vertex(int i){
		adj=new ArrayList<Edge>();
		index=i;
	}
	public void add(Edge e){
		adj.add(e);	
	}
	public Iterator<Edge> iterator(){
		return adj.iterator();
	}
}
class Edge{
	public int from,to,weight;
	public Edge(int f,int t,int w)
	{
		from=f;
		to=t;
		weight=w;
	}
}
class BiCon{
	int num;
	int dfn[];
	int low[];
	Vertex[] graph;
	int n;
	boolean visited[];
	Stack<Edge> st;
	int ctr;
	public BiCon(Vertex[] g, int n)
	{
		num=0;
		dfn=new int[n];
		low=new int[n];
		visited=new boolean[n];
		this.n=n;
		graph=g;
		st=new Stack<Edge>();
		ctr=0;
	}
	public int Solve()
	{
		for(int i=0;i<n;i++)
		{
			dfn[i]=low[i]=-1;
			visited[i]=false;
		}
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				st=new Stack<Edge>();
				bicon(i,-1);
			}
		}
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
				ctr++;
		}
		return ctr;
	}
	public void bicon(int ind1,int ind2)
	{
		int u=ind1;
		int v=ind2;
		int x,y;
		int w;
		dfn[u]=low[u]=num++;
		if(graph[u].adj.size()==0)
			ctr++;
		visited[u]=true;
		for(Edge ptr:graph[u])
		{
			w=ptr.to;
			visited[w]=true;
			if(v!=w && dfn[w]<dfn[u])
			{
				st.push(new Edge(u,w,0));
			}
			if(dfn[w]<0)
			{
				bicon(w,u);
				low[u]=Math.min(low[u], low[w]);
				if(low[w]>=dfn[u])
				{
					ctr++;
					do
					{
						Edge temp=st.pop();
						x=temp.from;
						y=temp.to;
					}while(!(x==u && y==w));
				}
			}
			else if(v!=w)
			{
				low[u]=Math.min(low[u],dfn[w]);
			}

		}
	}

}
public class States
{

	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(in.readLine());
		while(t-->0)
		{
			String s[]=in.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int m=Integer.parseInt(s[1]);
			Vertex[] g=new Vertex[n];
			for(int i=0;i<n;i++)
			{
				g[i]=new Vertex(i);
			}
			for(int i=0;i<m;i++)
			{
				s=in.readLine().split(" ");
				int from=Integer.parseInt(s[0])-1;
				int to=Integer.parseInt(s[1])-1;
				g[from].add(new Edge(from,to,0));
				g[to].add(new Edge(to,from,0));
			}
			System.out.println(new BiCon(g,n).Solve());
		}
	}
}