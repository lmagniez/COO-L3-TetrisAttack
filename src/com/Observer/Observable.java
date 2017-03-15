package com.Observer;

/**
 * Observable
 * @author loick
 *
 */
public interface Observable {
	
	public void addObserver(Observer obs);
	public void removeObserver();
}
