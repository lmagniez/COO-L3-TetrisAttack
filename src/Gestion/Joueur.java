package Gestion;

import JComponent.Grille;
import JComponent.Score;

public class Joueur {

	
	private int x1;
	private int x2;
	private int y1;
	
	public Joueur(){
		x1=5;
		x2=6;
		y1=9;	
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

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}
	
	
	
}
