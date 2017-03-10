package Com.Model;

public class CaseModel extends Thread{
	
	protected boolean swappable;
	protected boolean isBloc;
	protected ValeurCase v;
	protected int x,y;
	
	public CaseModel(int x, int y){
		this.v=ValeurCase.VIDE;
		this.x=x;
		this.y=y;
	}
	
	public void run(){
		//this.notify();
		//Thread.sleep(1000);
		
	}
	
}
