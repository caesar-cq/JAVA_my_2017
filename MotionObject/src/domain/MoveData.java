package domain;

public class MoveData {
	private String title;
	private int min;
	private int max;
	private int cur;
	private double rateFactor;
	public MoveData(String title, int min, int max, int cur ,double rateFactor) {
		super();
		this.title = title;
		this.min = min;
		this.max = max;
		this.cur = cur;
		this.rateFactor = rateFactor;
	}
	public String getTitle() {
		return title;
	}
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public int getCur() {
		return cur;
	}
	public double getRateFactor() {
		return rateFactor;
	}
	
}
