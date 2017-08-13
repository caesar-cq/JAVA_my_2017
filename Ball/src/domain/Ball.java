package domain;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Ball {
	
	private double centerx=500;
	private double centery=400;
	
	
	private double radius=35;
	private double deltax=0;
	private double deltay=0;
	private JPanel view;
	
	public void setXY(double X , double Y)
	{
		this.centerx = X;
		this.centery = Y;
	}
	
	public void setView(JPanel view)
	{
		this.view = view;
	}
	
	
	public Ball()
	{
		
		deltax=(int)(Math.random()*20);
		deltay=(int)(Math.random()*20);
		int rsgnx=(int)(Math.random()*2);
		int rsgny=(int)(Math.random()*2);
		if(rsgnx==0)
		{
			deltax=-deltax;
		}
		if(rsgny==0)
		{
			deltay=-deltay;
		}
		
	}
	
	public void move(){
		//System.out.println(centerx+" "+centery);
		centerx+=deltax;
		centery+=deltay;
		while(centerx<radius||centerx>view.getWidth()-radius||centery>view.getHeight()-radius||centery<radius)
		{
			if(centerx<=radius){
				centerx=radius;
				deltax=-deltax;
			}
			if(centerx>=view.getWidth()-radius)
			{
				centerx=view.getWidth()-radius;
				deltax=-deltax;
			}
			if(centery<=radius)
			{
				centery=radius;
				deltay=-deltay;
			}
			if(centery>=view.getHeight()-radius)
			{
				centery=view.getHeight()-radius;
				deltay=-deltay;
			}
		}
	//	System.out.println(centerx+" "+centery);
		view.repaint();
	}
	public void drawBall(Graphics2D g)
	{
		//System.out.println("sdfsdf");
		g.fill(new Ellipse2D.Double(centerx-radius, centery-radius, 2*radius, 2*radius));
	}
}

