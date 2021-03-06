package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import	domain.Ball;
import  domain.MoveObject;

public class MotionObjectView extends JPanel {
	private MoveObject moveObject;
	
	public void setMoveObject(MoveObject moveObject){
		this.moveObject = moveObject;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING
				, RenderingHints.VALUE_ANTIALIAS_ON);
		if(moveObject != null){
			moveObject.draw(g2);
		}
	}
	
}
