package gui;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.nodeData;
import dataStructure.node_data;
import utils.Point3D;
import utils.StdDraw;

public class Graph_GUI extends JFrame {

	public Graph_GUI( graph gr) 
	{
		
		double maxX=Double.NEGATIVE_INFINITY;
		double maxY=Double.NEGATIVE_INFINITY;
		double minX=Double.POSITIVE_INFINITY;
		double minY=Double.POSITIVE_INFINITY;

		for(Iterator<node_data> verIter=gr.getV().iterator();verIter.hasNext();) {
			node_data point=verIter.next();
			if(point.getLocation().x()>maxX)
				maxX=point.getLocation().x();
			if(point.getLocation().y()>maxY)
				maxY=point.getLocation().y();
			if(point.getLocation().x()<minX)
				minX=point.getLocation().x();
			if(point.getLocation().y()<minY)
				minY=point.getLocation().y();	
		} 
		double porY=(Math.abs(minY)+Math.abs(maxY))/20;
		double porX=(Math.abs(minX)+Math.abs(maxX))/20;
		StdDraw.setCanvasSize(800,600);
		StdDraw.setXscale(minX-porX,maxX+porX);
		StdDraw.setYscale(minY-porY,maxY+porY);
		StdDraw.setGraph(gr);
		StdDraw.paint();
	}
	
	
	
	public static void main(String[] args) 
	{
		graph g;
		Point3D p0,p1,p2,p3,p4,p5,p6;
		node_data v0,v1,v2,v3,v4,v5,v6;
		g=new DGraph();
		p0=new Point3D(0,0,0);
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

	}
	
	
	
}
