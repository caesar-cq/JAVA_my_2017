package domain;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class CircleMotion extends MoveObject {
	//private double r = 300;      //�˶��켣
		/*private double x;
		private double y;*/
		
		private double radius = 25;   //�˶�����
		/*private double alpha = -Math.PI/2;    //����x,y��ĽǶ���ȷ��λ�ã�һ��ʼ��λ��ΪԲ�ĵ����Ϸ���
		private double delta = 0.05;  //ÿ���˶��Ļ���
	*/	
		//private JPanel view;
		public CircleMotion(){
			this.adelta = 280;
			this.propertyb = -Math.PI / 2;
		}

		public void draw(Graphics2D g){
			double x = (double)view.getWidth() / 2;
			double y = (double)view.getHeight() / 2;
			g.fill(new Ellipse2D.Double(x + this.adelta*Math.cos(this.propertyb)-radius, y + adelta*Math.sin(propertyb)-radius, 2*radius, 2*radius));   //���˶�����
			g.draw(new Ellipse2D.Double(x-adelta, y-adelta, 2*adelta, 2*adelta));       //���˶��켣      
			g.fill(new Ellipse2D.Double(x-5 , y-5, 10, 10));
			g.draw(new Line2D.Double(x, y, x + this.adelta*Math.cos(this.propertyb), y + adelta*Math.sin(propertyb)));
		}
		
		public void move(){
			this.propertyb = this.propertyb + bdelta;  //ͨ���Ƕȵĸı����������˶�
			view.repaint();
		}

}
