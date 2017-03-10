package Com.Model;

import Com.Observer.Observer;

public class JoueurModel {

	private Observer joueurVue;
	
	private int id;
	private int x1=5;
	private int x2=6;
	private int y1=9;
			
	public JoueurModel(int id) {
		super();
		this.id = id;
	}

	public void changeHaut() {
		y1=y1-1;
		this.updateJoueur(x1,x2,y1);
	}

	public void changeGauche() {
		x2=x2-1;
		x1=x1-1;
		this.updateJoueur(x1,x2,y1);
	}

	public void changeBas() {
		y1=y1+1;
		this.updateJoueur(x1,x2,y1);
	}

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

	public void monteJoueurGraphique() {
		joueurVue.bougeJoueurGraphique();
	}
	
	
	
}
