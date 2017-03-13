package com.Model;

import java.util.ArrayList;

import com.Observer.Observable;
import com.Observer.Observer;

public abstract class AbstractModel implements Observable {

	protected ArrayList<Observer> listObserver = new ArrayList<Observer>();

	
	public void addObserver(Observer obs) {
		this.listObserver.add(obs);
	}


	@Override
	public void removeObserver() {
		listObserver = new ArrayList<Observer>();
	}


}