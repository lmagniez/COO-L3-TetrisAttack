package com.Observer;

import com.Model.ValeurCase;

/**
 * Observer
 * @author loick
 *
 */
public interface Observer {
	
	/**
	 * Mettre à jour le joueur
	 * @param j id joueur
	 * @param x1 abscisse1
	 * @param x2 abscisse2
	 * @param y ordonnée
	 */
	void updateJoueur(int j, int x1, int x2, int y);
	/**
	 * Mettre à jour la case
	* @param j id joueur
	 * @param y ordonnée
	 * @param x abscisse
	 * @param val valeur de la case
	 */
	void updateCase(int j, int y, int x, ValeurCase val);
	/**
	 * Effectuer un swap horizontal
	 * @param j id joueur
	 * @param x1 abscisse1 
	 * @param x2 abscisse2
	 * @param y ordonnée
	 */
	void swaphorizontal(int j, int x1, int x2, int y);
	/**
	 * Effectuer un swap vertical
	 * @param j id joueur
	 * @param x abscisse1 
	 * @param y1 ordonnée2
	 * @param y2 ordonnée
	 */
	void swapvertical(int j, int x, int y1, int y2);
	/**
	 * Mettre à jour le jour
	 * @param id id joueur
	 * @param score score
	 */
	void score(int id, int score);
	/**
	 * Mettre à jour le timer
	 * @param sminute minute
	 * @param sseconde seconde
	 */
	void updateTimer(String sminute, String sseconde);
	
	/**
	 * Arreter l'animation d'une case
	 * @param id id joueur
	 * @param y ordonnée
	 * @param x abscisse
	 */
	void stopCase(int id, int y, int x);
	/**
	 * Reprendre l'animation d'une case
	 * @param id id joueur
	 * @param y ordonnée
	 * @param x abscisse
	 */
	void startCase(int id, int y, int x);
	
	/**
	 * Changer la position du joueur
	 */
	void bougeJoueurGraphique();
	/**
	 * Changer la position de la grille
	 */
	void bougerGrilleGraphique();
	/**
	 * Changer la position du joueur (2J)
	 * @param id id du joueur
	 */
	void bougeJoueurGraphique(int id);
	/**
	 * Changer la position de la grille (2J)
	 * @param id id du joueur
	 */
	void bougerGrilleGraphique(int id);
	/**
	 * Reinitialiser la position de la grille 
	 * @param id id du joueur
	 */
	void reinitgrilleAnimation(int id);
	/**
	 * Arreter le thread
	 * @param id id du joueur
	 */
	void arretThread(int id);
	void accelere();
	
}
