package algorithms;

import java.util.HashMap;
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
	public void init(graph g) {
		// TODO Auto-generated method stub
		
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
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
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
		
//		graph copy=new DGraph();
//		for (Entry<Integer, node_data> entry : (( HashMap<Integer,node_data>) g.getV()).entrySet())
//		{
//			node_data v=entry.getValue();
//			copy.addNode(v);
//		}
//		for (Entry<Integer, node_data> entry : (( HashMap<Integer,node_data>) g.getV()).entrySet())
//		{
//			int key=entry.getKey();
//			if(g.)
//			{
//				int 
//			}
//			for (Entry<Integer, HashMap<Integer,edge_data> > entry1 : (( HashMap<Integer, HashMap<Integer,edge_data> >) g.getE()).entrySet())
//			{
//				node_data v=entry.getValue();
//				copy.addNode(v);
//			}
//			
//		}
//
//		
//		return g;
		return null;
	}

}
