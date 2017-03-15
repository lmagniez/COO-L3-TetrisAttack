package com.Controller;

import com.Model.AbstractModel;
import com.Model.CaseModel;
import com.Model.GrilleModel;
import com.Model.JoueurModel;

public class GrilleControler {

	private GrilleModel grilleModel;
	
	public CaseModel[][] recupGrille(){
		return grilleModel.recupMaGrille();
	}
	
	
	public GrilleControler(GrilleModel cal) {
		grilleModel=cal;
	}

	public void initGrille() {
		grilleModel.recupGrille();
	}
	
	public void ajoutLigne() {
		grilleModel.ajoutLigneGrille();
	}

	public void swap(int x1, int x2, int y1) {
		grilleModel.swap(x1, x2, y1);
	}

	public void montegrilleGraphique() {
		grilleModel.monteGrilleGraphique();
	}

	public boolean gameOver() {
		return grilleModel.Gameover();
	}
	
	public void reinitGrille1J(){
		grilleModel.reinit(true);
	}
	
	public void reinitGrille2J(){
		grilleModel.reinit(false);
	}
	
}
