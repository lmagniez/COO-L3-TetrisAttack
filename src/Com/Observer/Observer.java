package Com.Observer;

public interface Observer {
	
	
	void swaphorizontal(int x1,int x2,int y);
	void swapvertical(int x,int y1,int y2);
	void updateJoueur(int j, int x1, int x2, int y);
	void updateCase(int j, int y, int x, int val);
}
