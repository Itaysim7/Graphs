package dataStructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

public class DGraph implements graph
{
    HashMap<Integer,node_data> vertices; 
    HashMap<Integer, HashMap<Integer,edge_data> > edges; //integer is the vertices and the arraylist save his edge
    int count;
    int mc;

    public DGraph() 
	{
    	vertices=new HashMap<Integer,node_data>();
    	edges=new HashMap<Integer, HashMap<Integer,edge_data> > ();
    	this.count=0;
    	this.mc=0;
	}
	@Override
	public node_data getNode(int key)
	{
		if(vertices.containsKey(key))
		{
			return vertices.get(key);
		}
		else
			return null;
	}

	@Override
	public edge_data getEdge(int src, int dest)
	{
		if(edges.containsKey(src)&&edges.get(src).containsKey(dest))
		{
			return edges.get(src).get(dest);
		}
		else
			return null;
	}

	@Override
	public void addNode(node_data n) 
	{
			this.vertices.put( n.getKey(),n);
			mc++;
	}

	@Override
	public void connect(int src, int dest, double w)
	{
		if(src!=dest&&w>=0)//check if the edge is between different vertices and the weight is positive 
		{
			if(vertices.containsKey(src)&&vertices.containsKey(dest))//check if there is vertices src dest
			{
				if(!edges.containsKey(src)) //check if there is a hashmap for key src
				{
					HashMap<Integer, edge_data> edgesVer=new HashMap<Integer,edge_data> ();
					edges.put(src, edgesVer);
				}
				if(!edges.get(src).containsKey(dest))//check if the edge is already exist
				{
					count++;
					edges.get(src).remove(dest);
				}
				edge_data temp=new edgeData(src,dest,w,null,0);
				this.edges.get(src).put(dest, temp);
				mc++;
			}
		}
	}

	@Override
	public Collection<node_data> getV()
	{
		return this.vertices.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) 
	{
		if(edges.containsKey(node_id))
		{
			return this.edges.get(node_id).values();
		}
		return null;
	}

	@Override
	public node_data removeNode(int key) 
	{
		if(vertices.containsKey(key)) //check if there is such vertex
		{
			int keyTemp;
			for (Entry<Integer, node_data> entry : vertices.entrySet())
			{
				keyTemp=entry.getKey();
				if(keyTemp!=key&&edges.containsKey(keyTemp) &&edges.get(keyTemp).containsKey(key))
				{
					edges.get(keyTemp).remove(key);
					count--;
					mc++;
				}
				if(keyTemp==key&&edges.containsKey(key))
				{
					mc=mc+edges.get(key).size();
					count=count-edges.get(key).size();
					edges.remove(key);
				}
			}
			mc++;
			return vertices.remove(key);
		}
		return null;
		
	}

	@Override
	public edge_data removeEdge(int src, int dest) 
	{
		if(vertices.containsKey(src)&&vertices.containsKey(dest))
		{
			if(edges.containsKey(src)&&edges.get(src).containsKey(dest))
			{
				mc++;
				count--;
				return edges.get(src).remove(dest);
			}
			else 
				return null;
		}
		else
			return null;
	}
	@Override
	public int nodeSize() 
	{
		return vertices.size();
	}

	@Override
	public int edgeSize() 
	{
		return count;
	}

	@Override
	public int getMC() 
	{
		return mc;
	}
}
