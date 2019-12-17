package dataStructure;


import utils.Point3D;

public class test {


	public static void main(String[] args) 
	{
		graph g=new DGraph();
		for(int i=1;i<1000000;i++)
		{
			Point3D p=new Point3D(i,i,i);
			node_data a=new nodeData(p,i,null,0);
			g.addNode(a);
			if(i>10)
			{
				for(int j=i-3;j<i;j++)
				{
					g.connect(j, i, 1);
				}
				
			}
		}


	}

}
