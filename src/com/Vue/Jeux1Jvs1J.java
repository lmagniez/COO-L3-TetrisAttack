package com.Vue;

import java.awt.event.KeyEvent;

import com.Controller.GrilleControler;
import com.Controller.JeuxControler;
import com.Controller.JoueurControler;
import com.Controller.JoueurControlerIA;
import com.Model.GrilleModel;
import com.Model.JoueurModel;
import com.Model.JeuxModel;

import Gestion.Joueur;
import JComponent.Grille;
import Run.Fenetre;

/**
 * Vue du Joueur contre joueur
 * @author loick
 *
 */
public class Jeux1Jvs1J extends Jeux2j {

	/**
	 * Constructeur
	 * @param f fenetre
	 * @param option options
	 * @param idJ1 id joueur 1
	 * @param idJ2 id joueur 2
	 */
	public Jeux1Jvs1J(Fenetre f, int[] option, int idJ1, int idJ2) {
		super(f, option, idJ1, idJ2);
	}

	/**
	 * Gestion du clavier
	 */
	public void GestionClavier(KeyEvent e) {
		if (!pause) {
			if (e.getKeyCode() == KeyEvent.VK_Z) {
				controlerJoueur1.verifUp(j1.getY1());
			} else if (e.getKeyCode() == KeyEvent.VK_S) {
				controlerJoueur1.verifDown(j1.getY1());
			} else if (e.getKeyCode() == KeyEvent.VK_Q) {
				controlerJoueur1.verifLeft(j1.getX1());
			} else if (e.getKeyCode() == KeyEvent.VK_D) {
				controlerJoueur1.verifRight(j1.getX2());
			} else if (e.getKeyCode() == KeyEvent.VK_F) {
				controlerGrille1.swap(j1.getX1(), j1.getX2(), j1.getY1());
			} else if (e.getKeyCode() == KeyEvent.VK_O) {
				controlerJoueur2.verifUp(j2.getY1());
			} else if (e.getKeyCode() == KeyEvent.VK_L) {
				controlerJoueur2.verifDown(j2.getY1());
			} else if (e.getKeyCode() == KeyEvent.VK_K) {
				controlerJoueur2.verifLeft(j2.getX1());
			} else if (e.getKeyCode() == KeyEvent.VK_M) {
				controlerJoueur2.verifRight(j2.getX2());
			} else if (e.getKeyCode() == KeyEvent.VK_J) {
				controlerGrille2.swap(j2.getX1(), j2.getX2(), j2.getY1());
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			pause = true;
			controlerJeu.pause();
			controlerJoueur1.pause();
			controlerJoueur2.pause();

			this.pausePanel.setVisible(true);
			this.pausePanel.requestFocus();
			this.pausePanel.getButtons()[0][0].requestFocusInWindow();
			this.pausePanel.repaint();
		}
	}

	@Override
	public void arretThread(int id) {
		super.arretThread(id);
		controlerJeu.arreterThread();
		controlerJoueur1.arreterThread();
		controlerJoueur2.arreterThread();
	}

	@Override
	public void affiche() {
		// TODO Auto-generated method stub
		
	}

}
