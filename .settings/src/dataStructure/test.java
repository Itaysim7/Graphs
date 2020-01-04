package dataStructure;


import java.util.ArrayList;
import java.util.List;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import gui.Graph_GUI;
import utils.Point3D;

public class test {


	public static void main(String[] args) 
	{

//		graph g=new DGraph();
//		for(int i=0;i<1000000;i++)
//		{
//			Point3D p=new Point3D(i,i,i);
//			node_data a=new nodeData(p,i,null,0);
//			g.addNode(a);
//			if(i>10)
//			{
//				for(int j=i-9;j<i;j++)
//				{
//					g.connect(j, i, 1);
//				}
//				
//			}
//		}
		graph g=new DGraph();
		node_data a=new nodeData(new Point3D(1,1,1),1,null,0);
		node_data b=new nodeData(new Point3D(1,1,1),1,null,0);
		g.addNode(a);
		g.addNode(b);
		g.connect(0,1, 1);
		graph_algorithms ga=new Graph_Algo();
		ga.init(g);
		System.out.println(ga.shortestPathDist(0,1));
		List <node_data> path=new ArrayList <node_data>();
		path=ga.shortestPath(1,1);
		for(int i=0;i<path.size();i++)
		{
			System.out.println(path.get(i).getKey());
		}




	}

}
