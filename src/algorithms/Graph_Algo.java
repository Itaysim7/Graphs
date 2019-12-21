package algorithms;

import java.nio.file.Path;
import java.util.ArrayList;
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
	public double shortestPathDist(int src, int dest) 
	{
		this.weigthInfi();//set all the weight vertices to infinity
		this.resetInfo();// set all "father" vertices to null
		g.getNode(src).setWeight(0);
		g.getNode(src).setTag(1);
		
		try 
		{
			for(Iterator<edge_data> edgeIter=g.getE(src).iterator();edgeIter.hasNext();)
			{
				edge_data e=edgeIter.next();
				if(g.getNode(e.getDest()).getWeight()>g.getNode(src).getWeight()+e.getWeight())
				{
					g.getNode(e.getDest()).setWeight(g.getNode(src).getWeight()+e.getWeight());
					g.getNode(e.getDest()).setInfo(""+src);
				}
			}
			
		}
		catch(NullPointerException e)//if there is not a path
		{
			return Integer.MAX_VALUE;
		}		
		ArrayList<node_data> ver=new ArrayList<node_data>();
		for(Iterator<node_data> verIter=g.getV().iterator();verIter.hasNext();)
		{ //insert all the vertices to array list
			node_data v=verIter.next();
			if(v.getKey()!=src)
			{
				ver.add(v);
			}
		}
		while(ver.size()!=0)
		{
			int minVer=findMinVer(ver);//find the vertex with the minimum weight and delete it from the array
			g.getNode(minVer).setTag(1);
			try 
			{
				for(Iterator<edge_data> edgeIter=g.getE(minVer).iterator();edgeIter.hasNext();)
				{
					edge_data e=edgeIter.next();
					if(g.getNode(e.getDest()).getTag()==0&&g.getNode(e.getDest()).getWeight()>g.getNode(minVer).getWeight()+e.getWeight())
					{
						g.getNode(e.getDest()).setWeight(g.getNode(minVer).getWeight()+e.getWeight());
						g.getNode(e.getDest()).setInfo(""+minVer);
					}
				}	
			}
			catch(NullPointerException e)
			{}
		}
		this.resetTag();
		return g.getNode(dest).getWeight();
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) 
	{
		List <node_data> path=new ArrayList <node_data>();
		double dis=this.shortestPathDist(src,dest);
		if(dis<Integer.MAX_VALUE)//if there is a path
		{
			node_data v=g.getNode(dest);
			path.add(v);
			while(!v.getInfo().isEmpty())
			{
				int father=Integer.parseInt(v.getInfo());
				path.add(g.getNode(father));
				v=g.getNode(father);
			}
			List <node_data> OPath=new ArrayList <node_data>();
			for(int i=path.size()-1;i>=0;i--)
			{
				OPath.add(path.get(i));
			}
			for(int i=0;i<OPath.size();i++)
			{
				System.out.println(OPath.get(i).getKey());
			}
		}
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
			verIter.next().setTag(0);
		}
	}
	private void weigthInfi()
	{
		for(Iterator<node_data> verIter=g.getV().iterator();verIter.hasNext();)
		{
			verIter.next().setWeight(Integer.MAX_VALUE);
		}
	}
	private void resetWeigth()
	{
		for(Iterator<node_data> verIter=g.getV().iterator();verIter.hasNext();)
		{
			verIter.next().setWeight(0);
		}
	}
	private void resetInfo()
	{
		for(Iterator<node_data> verIter=g.getV().iterator();verIter.hasNext();)
		{
			verIter.next().setInfo("");
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
	private int findMinVer(ArrayList <node_data> ver)
	{
		double weigth=Integer.MAX_VALUE;
		int minVer=0;
		int index=0;
		for(int i=0;i<ver.size();i++)
		{
			if(ver.get(i).getWeight()<weigth)
			{
				weigth=ver.get(i).getWeight();
				minVer=ver.get(i).getKey();
				index=i;
			}
		}
		ver.remove(index);
		return minVer;
	}

}
