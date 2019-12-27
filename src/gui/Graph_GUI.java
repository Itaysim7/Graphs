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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private graph gr;
	private Graph_Algo ga;
	private double porporY;
	
	
	public Graph_GUI( graph gr) 
	{
		this.gr=gr;
		ga=new Graph_Algo();
		ga.init(gr);
		
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
		porporY=(Math.abs(minY)+Math.abs(maxY))/50;
		StdDraw.setCanvasSize(800,600);
		StdDraw.setXscale(minX-porX,maxX+porX);
		StdDraw.setYscale(minY-porY,maxY+porY);
		StdDraw.setGraph(gr);
		this.paint();
	}
	
	public void paint() {
		
		for(Iterator<node_data> verIter=gr.getV().iterator();verIter.hasNext();) 
		{
			node_data point=verIter.next();

			StdDraw.setPenColor(Color.BLUE);
			StdDraw.setPenRadius(0.020);
			StdDraw.point((int)point.getLocation().x(), (int)point.getLocation().y());
			StdDraw.text(point.getLocation().x(),point.getLocation().y()+porporY, (""+point.getKey()));
			
			try {//in case point does not have edge the function getE return exception, and we do not want exception we just do not want it to paint
				for(Iterator<edge_data> edgeIter=gr.getE(point.getKey()).iterator();edgeIter.hasNext();) 
				{
					edge_data line=edgeIter.next();
					node_data dest=new nodeData();
					node_data src=point;
					for(Iterator<node_data> destIter=gr.getV().iterator();destIter.hasNext();) //find dest node
					{
						node_data temp=destIter.next();
						if(temp.getKey()==line.getDest())
							dest=temp;
					}
					StdDraw.setPenColor(Color.RED);
					StdDraw.setPenRadius(0.005);
					StdDraw.line((int)src.getLocation().x(),(int)src.getLocation().y(), (int)dest.getLocation().x(), (int)dest.getLocation().y());
					StdDraw.text((int)((src.getLocation().x()+dest.getLocation().x())/2),(int)((src.getLocation().y()+dest.getLocation().y())/2),(""+line.getWeight()));
					
					StdDraw.setPenColor(Color.YELLOW);
					StdDraw.setPenRadius(0.015);
					if(src.getLocation().x()<dest.getLocation().x()) {
						if(src.getLocation().y()<dest.getLocation().y())
							StdDraw.point((int)dest.getLocation().x()-0.5,(int)dest.getLocation().y()-0.5);
						else
							StdDraw.point((int)dest.getLocation().x()-0.5,(int)dest.getLocation().y()+0.5);
					}
					else {
						if(src.getLocation().y()<dest.getLocation().y())
							StdDraw.point((int)dest.getLocation().x()+0.5,(int)dest.getLocation().y()-0.5);
						else
							StdDraw.point((int)dest.getLocation().x()+0.5,(int)dest.getLocation().y()-0.5);
					}
					
				}
			}
			catch (Exception e) {}
		}
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
		
		Graph_GUI windoww = new Graph_GUI(g);
	}
	
	
	
}
