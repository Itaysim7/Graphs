package dataStructure;


import java.util.ArrayList;
import java.util.List;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import utils.Point3D;

public class test {


	public static void main(String[] args) 
	{
		//check copy
//		graph g=new DGraph();
//		for(int i=0;i<10;i++)
//		{
//			Point3D p=new Point3D(i,i,i);
//			node_data a=new nodeData(p,i,null,0);
//			g.addNode(a);
//		}
//		g.connect(1, 2, 0);
//		g.connect(2, 3, 0);
//		g.connect(3, 4, 0);
//		graph_algorithms al=new Graph_Algo();
//		al.init(g);
//		graph copy=al.copy();
//		for(int i=0;i<10;i++)
//		{
//			System.out.println(copy.getNode(i).getWeight());
//		}
//		System.out.println(copy.getEdge(1, 2).getSrc());
//		System.out.println(copy.getEdge(1, 2).getDest());
//		System.out.println(copy.getEdge(2, 3).getDest());
//		System.out.println(copy.getEdge(2, 3).getSrc());
//		System.out.println(copy.getEdge(3, 4).getSrc());
//		System.out.println(copy.getEdge(3, 4).getDest());
//		System.out.println(copy.getEdge(3, 5).getDest());
		//check reachable
//		graph g=new DGraph();
//		for(int i=0;i<4;i++)
//		{
//			Point3D p=new Point3D(i,i,i);
//			node_data a=new nodeData(p,i,null,0);
//			g.addNode(a);
//		}
//		g.connect(0, 1, 0);
//		g.connect(1, 2, 0);
//		g.connect(1, 3, 0);
//		g.connect(2, 0, 0);
//		g.connect(2, 1, 0);
//		Graph_Algo al=new Graph_Algo();
//		al.init(g);
//		System.out.println(al.countReachableVer(0));
		//check ispath
//		graph g=new DGraph();
//		for(int i=0;i<4;i++)
//		{
//			Point3D p=new Point3D(i,i,i);
//			node_data a=new nodeData(p,i,null,0);
//			g.addNode(a);
//		}
//		g.connect(0, 1, 0);
//		g.connect(1, 0, 0);
//
//		g.connect(3,1, 0);
//		g.connect(3,2, 0);
//		g.connect(2, 1, 0);
//		Graph_Algo al=new Graph_Algo();
//		al.init(g);
//		System.out.println(al.isPath(0,3));
		
		//check isConnected
//		graph g=new DGraph();
//		for(int i=0;i<4;i++)
//		{
//			Point3D p=new Point3D(i,i,i);
//			node_data a=new nodeData(p,i,null,0);
//			g.addNode(a);
//		}
//		g.connect(0, 1, 0);
//		g.connect(1, 0, 0);
//		g.connect(3,1, 0);
//		g.connect(1,3, 0);
//		g.connect(3,2, 0);
//		g.connect(2, 1, 0);
//		Graph_Algo al=new Graph_Algo();
//		al.init(g);
//		System.out.println(al.isConnected());
		
		//check shortestPath	
//		graph g=new DGraph();
//		for(int i=0;i<5;i++)
//		{
//			Point3D p=new Point3D(i,i,i);
//			node_data a=new nodeData(p,0,null,0);
//			g.addNode(a);
//		}
//		g.connect(0,1,2);
//		g.connect(1,0,2);
//		g.connect(0,3,12);
//		g.connect(1,2,7);
//		g.connect(1,4,5);
//		g.connect(2,4,1);
//		g.connect(4,3,3);
//		g.connect(2,3,3);
//		Graph_Algo al=new Graph_Algo();
//		al.init(g);
//		System.out.println(al.shortestPathDist(3, 0));

		//check mix array	
//		graph g=new DGraph();
//		Graph_Algo al=new Graph_Algo();
//		List<Integer> mix=new ArrayList<Integer>();
//		mix.add(1);mix.add(2);	mix.add(3);mix.add(4);mix.add(5);mix.add(6);mix.add(7);	mix.add(8);mix.add(9);mix.add(10);
//		al.mixArray(mix);
//		al.mixArray(mix);
//		al.mixArray(mix);
//		al.mixArray(mix);
//		al.mixArray(mix);
		
//		check tsp
		graph g=new DGraph();
		for(int i=0;i<7;i++)
		{
			Point3D p=new Point3D(i,i,i);
			node_data a=new nodeData(p,0,null,0);
			g.addNode(a);
		}
		g.connect(0,1,2);
		g.connect(1,2,2);
		g.connect(2,3,2);
		g.connect(3,4,2);
		g.connect(4,3,2);
		g.connect(4,5,2);

		g.connect(3,5,2);
		g.connect(5,6,2);
	//	g.connect(4,3,3);
//		g.connect(2,3,3);
		Graph_Algo al=new Graph_Algo();
		al.init(g);
		List<Integer> mix=new ArrayList<Integer>();
		mix.add(1);mix.add(0);mix.add(3);mix.add(2);mix.add(6);mix.add(4);mix.add(5);
		List<node_data> test=al.TSP(mix);
		for(int i=0;i<test.size();i++)
		{
			System.out.println(test.get(i).getKey());

		}



//		for(int i=0;i<100000;i++)
//		{
//			Point3D p=new Point3D(i,i,i);
//			node_data a=new nodeData(p,i,null,0);
//			g.addNode(a);
//			if(i>10)
//			{
//				for(int j=i-3;j<i;j++)
//				{
//					g.connect(j, i, 1);
//				}
//				if(i==5000)
//				{
//					System.out.println(g.nodeSize());
//					System.out.println(g.edgeSize());
//
//				}
//				
//			}
//		}


	}

}
