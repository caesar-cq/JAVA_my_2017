package domain;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class CircleMotion extends MoveObject {
	//private double r = 300;      //运动轨迹
		/*private double x;
		private double y;*/
		
		private double radius = 25;   //运动物体
		/*private double alpha = -Math.PI/2;    //用于x,y轴的角度来确定位置（一开始的位置为圆心的正上方）
		private double delta = 0.05;  //每次运动的弧度
	*/	
		//private JPanel view;
		public CircleMotion(){
			this.adelta = 280;
			this.propertyb = -Math.PI / 2;
		}

		public void draw(Graphics2D g){
			double x = (double)view.getWidth() / 2;
			double y = (double)view.getHeight() / 2;
			g.fill(new Ellipse2D.Double(x + this.adelta*Math.cos(this.propertyb)-radius, y + adelta*Math.sin(propertyb)-radius, 2*radius, 2*radius));   //画运动物体
			g.draw(new Ellipse2D.Double(x-adelta, y-adelta, 2*adelta, 2*adelta));       //画运动轨迹      
			g.fill(new Ellipse2D.Double(x-5 , y-5, 10, 10));
			g.draw(new Line2D.Double(x, y, x + this.adelta*Math.cos(this.propertyb), y + adelta*Math.sin(propertyb)));
		}
		
		public void move(){
			this.propertyb = this.propertyb + bdelta;  //通过角度的改变来是物体运动
			view.repaint();
		}

}
