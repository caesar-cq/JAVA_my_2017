package domain;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	private Ball ball;
	MainFrame()
	{
		
		BallView ballView=new BallView();
		
		ballView.addMouseListener((new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				double X = e.getX();
				double Y = e.getY();
				ball = new Ball();
				ball.setView(ballView);
				ball.setXY(X, Y);
				BallThread bT = new BallThread();
				bT.setBall(ball);
				ballView.setBall(ball);
				//ballView.add(ball);
				//System.out.println(X+" "+Y);
				bT.start();
			}
		}));
		/*Ball ball = new Ball(ballView);
		ballView.setBall(ball);*/
		
		this.getContentPane().add(ballView);
		this.setSize(900,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame m=new MainFrame();
	}

}