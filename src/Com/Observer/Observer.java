package Com.Observer;

import Com.Model.ValeurCase;

public interface Observer {
	void updateJoueur(int j, int x1, int x2, int y);
	void updateCase(int j, int y, int x, ValeurCase val);
	
	void swaphorizontal(int j, int x1, int x2, int y);
	void swapvertical(int j, int x, int y1, int y2);
	void score(int id, int score);
	void updateTimer(String sminute, String sseconde);
	void bougeJoueurGraphique(int id);
	void bougerGrilleGraphique(int id);
	void reinitgrilleAnimation(int id);
}
