package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopoLogicalSorting {
	static class Edge {
		int source,dest;
		
		Edge (int source,int dest)
		{
			this.source=source;
			this.dest=dest;
		}
	}
	List<List<Integer>>adjList=null;
	TopoLogicalSorting (List<Edge>edges,int N)
	{
		adjList=new ArrayList<>();
		for(int i=0;i<N;i++)
		{
			adjList.add(new ArrayList<>());
		}
		for(Edge edge:edges)
		{
			adjList.get(edge.source).add(edge.dest);
		}
	}
	
	public static int DFS(TopoLogicalSorting graph,int v, boolean[]discovered,int []departure,int time)
	{
		discovered[v]=true;
		time++;
		
		for(int u:graph.adjList.get(v))
		{
			if(!discovered[u])
			{
				time=DFS(graph,u,discovered,departure,time);
			}
		}
		departure[time]=v;
		time++;
		return time;
		
	}
	static void doTopoLogicalSorting(TopoLogicalSorting graph,int N)
	{
		int depart[]=new int[2*N];
		Arrays.fill(depart,-1);
		
		boolean visited[]=new boolean[N];
		int time=0;
		
		for(int i=0;i<N;i++)
		{
			if(!visited[i])
			{
				time=DFS(graph,i,visited,depart,time);
			}
		}
		
		for(int i=2*N-1;i>=0;i--)
		{
			if(depart[i]!=-1)
			{
				System.out.print(depart[i]+"  ");
			}
		}
	}
	
	public static void main(String[] args) {
		List<Edge>edges=Arrays.asList(
			     new Edge(0, 6), new Edge(1, 2), new Edge(1, 4),
                 new Edge(1, 6), new Edge(3, 0), new Edge(3, 4),
                 new Edge(5, 1), new Edge(7, 0), new Edge(7, 1)
				);
		final int N=8;
		TopoLogicalSorting graph=new TopoLogicalSorting(edges,N);
		
		doTopoLogicalSorting(graph,N);

	}

}
