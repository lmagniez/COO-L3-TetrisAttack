package Com.Model;

import java.util.ArrayList;

import Com.Observer.Observer;

public class JeuxModel extends AbstractModel {

	protected static ArrayList<Observer> JeuxObserver = new ArrayList<Observer>();

	protected void updateJoueur(int x1, int x2, int y) {
		for (Observer obs : JeuxObserver) {
			obs.updateJoueur(x1, x2, y);
		}
	}

	protected void UpdateCase(int y, int x, int val) {
		for (Observer obs : JeuxObserver) {
			obs.updateCase(y, x, val);
		}
	}
	
	protected static void UpdateSwapHorizontal(int x1, int x2, int y) {
		for (Observer obs : JeuxObserver) {
			System.out.println("HAHAH");
			obs.swaphorizontal(x1, x2,y);
		}
	}

	public void addObserverJeux(Observer obs) {
		this.listObserver.add(obs);
		this.JeuxObserver.add(obs);
	}

	public void removeObserverJeux() {
		JeuxObserver = new ArrayList<Observer>();
	}


	public void swap(int x1, int x2, int y1){
		GrilleModel.swapCase(x1, x2, y1);
	}

}
