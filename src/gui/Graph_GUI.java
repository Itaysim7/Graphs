package gui;



import java.util.Iterator;

import dataStructure.DGraph;
import dataStructure.graph;
import dataStructure.nodeData;
import dataStructure.node_data;
import utils.Point3D;
import utils.StdDraw;

public class Graph_GUI implements Runnable  
{
	private graph g;
	private int mc;
	public Graph_GUI( graph gr) 
	{
		this.g=gr;
		this.mc=g.getMC();
		StdDraw.setGraph(g);
		Thread change=new Thread(this);
		change.start();
		StdDraw.paint();
	}
	
	public static void main(String[] args) 
	{
		graph g;
		node_data v0,v1,v2,v3,v4,v5,v6;
		g=new DGraph();
		v0=new nodeData(new Point3D(1,0,0),0,null,0);
		v1=new nodeData(new Point3D(0,10,10),0,null,0);
		v2=new nodeData(new Point3D(20,0,-1),0,null,0);
		v3=new nodeData(new Point3D(30,30,0),0,null,0);
		v4=new nodeData(new Point3D(82,10,0),0,null,0);
		v5=new nodeData(new Point3D(50,50,0),0,null,0);
		v6=new nodeData(new Point3D(1,12,0),0,null,0);
		g.addNode(v0);g.addNode(v1);g.addNode(v2);g.addNode(v3);g.addNode(v4);g.addNode(v5);g.addNode(v6);
		g.connect(v0.getKey(),v2.getKey(),1);g.connect(v3.getKey(),v4.getKey(),2);g.connect(v4.getKey(),v5.getKey(),3);
		g.connect(v2.getKey(),v3.getKey(),4);g.connect(v5.getKey(),v6.getKey(),5);g.connect(v6.getKey(),v1.getKey(),6);g.connect(v1.getKey(),v0.getKey(),7);
		Graph_GUI windoww1 = new Graph_GUI(g);
	}

	@Override
	public void run() 
	{
		while(true)
		{
				synchronized(this) 
				{
					if(mc!=g.getMC())
					{
						mc=g.getMC();
						StdDraw.paint();
					}
				}
				try
				{
					Thread.sleep(500);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
		}

	}
	
	
	
}
