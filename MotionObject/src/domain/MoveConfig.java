package domain;

public class MoveConfig {
	private String name;
	private String classname;
	private MoveData[] moveDatas = new MoveData[2];
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public MoveData[] getMoveDatas() {
		return moveDatas;
	}
	public void setMoveDatas(MoveData[] moveDatas) {
		this.moveDatas = moveDatas;
	}
	
	public MoveData getMoveData(int index){
		return moveDatas[index];
	}
	
	public void setMoveData(int index,MoveData data){
		this.moveDatas[index] = data;
	}
}
