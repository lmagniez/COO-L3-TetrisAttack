package Gestion;

import JComponent.Grille;
import JComponent.Score;

public class Joueur {

	private Grille g;
	private Score sco;
	
	public Joueur(){
		g=new Grille();
		
	}

	public Grille getG() {
		return g;
	}

	public Score getSco() {
		return sco;
	}

	public void setG(Grille g) {
		this.g = g;
	}

	public void setSco(Score sco) {
		this.sco = sco;
	}
	
	
}
