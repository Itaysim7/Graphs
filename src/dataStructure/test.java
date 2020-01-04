package dataStructure;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import gui.Graph_GUI;
import utils.Point3D;

public class test {


	public static void main(String[] args) throws InterruptedException 
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
		graph g;
		Point3D p0,p1,p2,p3,p4,p5,p6;
		node_data v0,v1,v2,v3,v4,v5,v6;
		g=new DGraph();
		p0=new Point3D(1,0,0);
		p1=new Point3D(0,10,10);
		p2=new Point3D(20,0,-1);
		p3=new Point3D(30,30,0);
		p4=new Point3D(82,10,0);
		p5=new Point3D(50,50,0);
		p6=new Point3D(1,12,0);
		v0=new nodeData(p0,0,null,0);
		v1=new nodeData(p1,0,null,0);
		v2=new nodeData(p2,0,null,0);
		v3=new nodeData(p3,0,null,0);
		v4=new nodeData(p4,0,null,0);
		v5=new nodeData(p5,0,null,0);
		v6=new nodeData(p6,0,null,0);
		g.addNode(v0);
		g.addNode(v1);
		g.addNode(v2);
		g.addNode(v3);
		g.addNode(v4);
		g.addNode(v5);
		g.addNode(v6);
		g.connect(v0.getKey(),v2.getKey(),1);
		g.connect(v3.getKey(),v4.getKey(),2);
		g.connect(v4.getKey(),v5.getKey(),3);
		g.connect(v2.getKey(),v3.getKey(),4);
		g.connect(v5.getKey(),v6.getKey(),5);
		g.connect(v6.getKey(),v1.getKey(),6);
		g.connect(v1.getKey(),v0.getKey(),7);
		Graph_GUI windoww1 = new Graph_GUI(g);
        Thread.sleep(10000);
		g.addNode(new nodeData(new Point3D(6,6),0,null,0));
		g.addNode(new nodeData(new Point3D(15,15),0,null,0));
		g.addNode(new nodeData(new Point3D(18,18),0,null,0));
	}




}
