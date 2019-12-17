package dataStructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

public class DGraph implements graph
{
    HashMap<Integer,node_data> vertices; 
    HashMap<Integer, HashMap<Integer,edge_data> > edges; //integer is the vertices and the arraylist save his edge
    int count;

    public DGraph() 
	{
    	vertices=new HashMap<Integer,node_data>();
    	edges=new HashMap<Integer, HashMap<Integer,edge_data> > ();
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
	}

	@Override
	public void connect(int src, int dest, double w)
	{
		if(!edges.containsKey(src))
		{
			HashMap<Integer, edge_data> edgesVer=new HashMap<Integer,edge_data> ();
			edges.put(src, edgesVer);
		}
		if(!edges.get(src).containsKey(dest))
			count++;
		edge_data temp=new edgeData(src,dest,w,null,0);
		this.edges.get(src).put(dest, temp);
	}

	@Override
	public Collection<node_data> getV()
	{
		return this.vertices.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) 
	{
		return this.edges.get(node_id).values();
	}

	@Override
	public node_data removeNode(int key) 
	{
		int keyTemp;
		for (Entry<Integer, HashMap<Integer, edge_data>> entry : edges.entrySet())
		{
			keyTemp=entry.getKey();
			if(keyTemp!=key&&edges.get(keyTemp).containsKey(key))
			{
				edges.get(keyTemp).remove(key);
				count--;
			}
			if(keyTemp==key)
			{
				count=count-edges.get(key).size();
				edges.remove(key);
			}
		}
		return vertices.remove(key);
	}

	@Override
	public edge_data removeEdge(int src, int dest) 
	{
		if(edges.get(src).containsKey(dest))
		{
			count--;
			return edges.get(src).remove(dest);
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
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}

}
