package com.Model;

/**
 * Modèle des cases
 * @author loick
 *
 */
public class CaseModel {
	
	protected boolean swappable;
	protected boolean isBloc;
	public ValeurCase v;
	protected int x,y;
	
	/**
	 * Constructeur
	 * @param x abscisse
	 * @param y ordonnée
	 */
	public CaseModel(int x, int y){
		this.v=ValeurCase.VIDE;
		this.x=x;
		this.y=y;
		this.swappable=true;
		this.isBloc=false;
	}
	
	
	
}
