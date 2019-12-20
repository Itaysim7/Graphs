package algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms
{
	private graph g;
	@Override
	public void init(graph g) 
	{
		this.g=g;
	}

	@Override
	public void init(String file_name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(String file_name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isConnected()
	{
		int first=0;//if its the first iteration
		int src=0,dest;
		for(Iterator<node_data> verIter=g.getV().iterator();verIter.hasNext();)
		{
			if(first==0) //check if the first vertex is reachable to the other
			{
				first++;
				src=verIter.next().getKey();
				int count=countReachableVer(src);
				if(count!=g.nodeSize()-1)
					return false;	
				resetTag();
			}
			else //check if every vertex has a path to src
			{
				dest=verIter.next().getKey();
				if(!isPath(dest,src))
					return false;
				resetTag();
			}
		}
		return true;
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() 
	{
		
		graph copy=new DGraph();		
		for(Iterator<node_data> verIter=g.getV().iterator();verIter.hasNext();)
		{
			node_data v=verIter.next();
			copy.addNode(v);
		}
		for(Iterator<node_data> verIter=g.getV().iterator();verIter.hasNext();)
		{
			node_data v=verIter.next();
			int key=v.getKey();
			try 
			{
				for(Iterator<edge_data> edgeIter=g.getE(key).iterator();edgeIter.hasNext();)
				{
	
						edge_data e=edgeIter.next();
						copy.connect(e.getSrc(),e.getDest(),e.getWeight());
				}
			}
			catch(NullPointerException e)
			{
				
			}
		}
		return g;
	}
	
	private void resetTag()
	{
		for(Iterator<node_data> verIter=g.getV().iterator();verIter.hasNext();)
		{
			verIter.next().setTag(0);;
		}
	}
	private int countReachableVer(int key)
	{
		g.getNode(key).setTag(1);
		int count=0;
		try 
		{
			for(Iterator<edge_data> edgeIter=g.getE(key).iterator();edgeIter.hasNext();)
			{
					int dest =edgeIter.next().getDest();
					if(g.getNode(dest).getTag()==0)
					{
						count++;
						count=count+countReachableVer(dest);
					}
			}
			return count;
		}
		catch(NullPointerException e)
		{
			return 0;
		}
	}
	private boolean isPath(int src,int dest)
	{
		boolean path=false;
		g.getNode(src).setTag(1);
		try 
		{
			for(Iterator<edge_data> edgeIter=g.getE(src).iterator();edgeIter.hasNext();)
			{
				
					int verPath =edgeIter.next().getDest();
					if(g.getNode(verPath).getTag()==0)
					{
						if(verPath==dest)
						{
							return true;
						}
						else
						{
							if(!path&&isPath(verPath,dest))
							{
								path=true;
							}
						}
					}
			}
			return path;
		}
		catch(NullPointerException e)
		{
			return false;
		}
	}

}
