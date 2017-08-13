package domain;

public class BallThread extends Thread{
	
	
	private Ball ball;
	
	public void setBall(Ball ball)
	{
		this.ball = ball;
	}
	
	public void run()
	{
		try{
			while(true)
			{
				ball.move();
				Thread.sleep(100);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}