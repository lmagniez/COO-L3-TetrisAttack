package com.Controller;

import com.Model.AbstractModel;
import com.Model.CaseModel;
import com.Model.GrilleModel;
import com.Model.JoueurModel;

/**
 * Controler de la grille
 * Demande l'ajout de ligne, l'initialisation, le swap...
 * @author loick
 *
 */
public class GrilleControler {

	private GrilleModel grilleModel;
	
	/**
	 * Demander la grille au modele
	 * @return l'ensemble des cases
	 */
	public CaseModel[][] recupGrille(){
		return grilleModel.recupMaGrille();
	}
	
	
	/**
	 * Constructeur
	 * @param cal modele de la grille
	 */
	public GrilleControler(GrilleModel cal) {
		grilleModel=cal;
	}

	/**
	 * Initialiser la grille
	 */
	public void initGrille() {
		grilleModel.recupGrille();
	}
	
	/**
	 * Ajouter une ligne au modele
	 */
	public void ajoutLigne() {
		grilleModel.ajoutLigneGrille();
	}

	/**
	 * Swapper deux cases du modele
	 * @param x1 abscisse1
	 * @param x2 abscisse2
	 * @param y1 ordonnée
	 */
	public void swap(int x1, int x2, int y1) {
		grilleModel.swap(x1, x2, y1);
	}

	/**
	 * Faire monter la grille dans le modèle
	 */
	public void montegrilleGraphique() {
		grilleModel.monteGrilleGraphique();
	}

	/**
	 * Tester le game over
	 * @return game over ou non
	 */
	public boolean gameOver() {
		return grilleModel.Gameover();
	}
	
	/**
	 * Réinitialiser la grille pour le mode 1 joueur
	 */
	public void reinitGrille1J(){
		grilleModel.reinit(true);
	}
	
	/**
	 * Réinitialiser la grille pour le mode 2 joueurs
	 */
	public void reinitGrille2J(){
		grilleModel.reinit(false);
	}
	
}
