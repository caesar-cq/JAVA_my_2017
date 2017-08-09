package domain;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;


public class Ball extends MoveObject{
	
	private double radius = 15;
	
	public Ball(){
		this.propertya = radius;
		this.propertyb = radius;
	}

	public void move(){
		this.propertya += this.adelta;   //到边界改变deltax\deltay   
		this.propertyb += this.bdelta;
		if(this.propertya <= radius){        
			this.propertya = radius;
			this.adelta = 0 - this.adelta;   //碰壁反射，反射角=入射角
		}
		else if(this.propertyb <= radius ){
			this.propertyb = radius;
			this.bdelta = 0 - this.bdelta;
		}
		else if(this.propertya >= view.getSize().width - radius){
			this.propertya = view.getSize().width - radius;
			this.adelta = 0 - this.adelta;
		}
		else if(this.propertyb >= view.getSize().height - radius){
			this.propertyb = view.getSize().height - radius;
			this.bdelta = 0 - this.bdelta;
		}
	
		view.repaint();   //重画，间接调用BallView中的paintComponent(Graphics g)
	}
	
		public void draw(Graphics2D g){            //画球
			g.fill(new Ellipse2D.Double(this.propertya-radius,this.propertyb-radius,2*radius, 2*radius));   
		}
	@Override
	public void setAdelta(double adelta) {
		// TODO Auto-generated method stub
		if(this.adelta < 0){
			this.adelta = -adelta;
		}else{
			this.adelta = adelta;
		}
		view.repaint();
	}
	@Override
	public void setBdelta(double bdelta) {
		// TODO Auto-generated method stub
		if(this.bdelta < 0){
			this.bdelta = -bdelta;
		}else{
			this.bdelta = bdelta;
		}
		view.repaint();
	}
	
}
