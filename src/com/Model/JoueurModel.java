package com.Model;

import com.Observer.Observer;

/**
 * Modèle du joueur
 * @author loick
 *
 */
public class JoueurModel {

	private Observer joueurVue;
	
	private int id;
	private int x1=3;
	private int x2=4;
	private int y1=9;
			
	/**
	 * Modèle du joueur
	 * @param id id du joueur
	 */
	public JoueurModel(int id) {
		super();
		this.id = id;
	}

	/**
	 * Monter le curseur
	 */
	public void changeHaut() {
		y1=y1-1;
		this.updateJoueur(x1,x2,y1);
	}

	/**
	 * Déplacer le curseur à gauche
	 */
	public void changeGauche() {
		x2=x2-1;
		x1=x1-1;
		this.updateJoueur(x1,x2,y1);
	}

	/**
	 * Déplacer le curseur vers le bas
	 */
	public void changeBas() {
		y1=y1+1;
		this.updateJoueur(x1,x2,y1);
	}

	/**
	 * Déplacer le curseur à droite
	 */
	public void changeDroit() {
		x2=x2+1;
		x1=x1+1;
		this.updateJoueur(x1,x2,y1);
	}	
	
	protected void updateJoueur(int x1, int x2, int y) {
		joueurVue.updateJoueur(id,x1, x2, y);
	}

	public void add(Observer jeux1j) {
		this.joueurVue=jeux1j;
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY1() {
		return y1;
	}

	/**
	 * Faire monter le curseur dans la vue
	 */
	public void monteJoueurGraphique() {
		joueurVue.bougeJoueurGraphique(id);
		//
	}
	
	
	
}
