package domain;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class BallView extends JPanel {

	
	
	private Ball ball[] = new Ball[10000];
	private int index = 0;
	

	public void setBall(Ball ball)
	{
		this.ball[index] = ball;
		index ++;
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//System.out.println("sdfsdf");
		for(int i = 0;i < index ; i++)
			if(ball[i] != null)
				ball[i].drawBall(g2);
			else
				System.out.println("sdfsdf");
		
		
		
	}

	
	
}
