package Com.Model;

import java.util.ArrayList;

import Com.Observer.Observable;
import Com.Observer.Observer;

public abstract class AbstractModel implements Observable {

	protected ArrayList<Observer> listObserver = new ArrayList<Observer>();

	
	public void addObserver(Observer obs) {
		this.listObserver.add(obs);
	}


	@Override
	public void removeObserver() {
		listObserver = new ArrayList<Observer>();
	}


	public abstract void swap(int x1, int x2, int y1);

}