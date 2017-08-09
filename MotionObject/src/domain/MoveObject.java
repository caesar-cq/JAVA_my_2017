package domain;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import common.CommonSlider;

public abstract class MoveObject {
	protected double propertya;   //初始量
	protected double propertyb;
	
	protected double adelta;    //改变量
	protected double bdelta;
	
	protected JPanel view;
	
	public double getPropertya() {
		return propertya;
	}
	public void setView(JPanel view) {
		this.view = view;
	}
	public double getPropertyb() {
		return propertyb;
	}
	public double getAdelta() {
		return adelta;
	}
	public double getBdelta() {
		return bdelta;
	}
	public void setPropertya(double propertya) {
		this.propertya = propertya;
		view.repaint();
	}
	public void setPropertyb(double propertyb) {
		this.propertyb = propertyb;
		view.repaint();
	}
	public void setAdelta(double adelta) {
			this.adelta = adelta;
			view.repaint();
	}
	public void setBdelta(double bdelta) {
			this.bdelta = bdelta;
			view.repaint();
	}
	
	/*public MoveObject(JPanel v){
		this.view = v;
	}*/
	public abstract void draw(Graphics2D g);
	public abstract void move();
		// TODO Auto-generated method stub
		
}
	
