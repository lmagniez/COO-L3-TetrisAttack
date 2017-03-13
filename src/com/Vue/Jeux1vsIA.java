package com.Vue;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import com.Model.ValeurCase;
import com.Observer.Observer;

import Constante.ConstanteDimension;
import Constante.ConstanteGraphique;
import Constante.ConstanteJeux;
import Run.Fenetre;

public class Jeux1vsIA  extends Jeux2j {

	public Jeux1vsIA(Fenetre f, int[] option, int idJ1, int idJ2) {
		super(f, option, idJ1, idJ2);
		
	}

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
			} 
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (pause) {
				controlerJoueur1.reprendre();
				controlerJoueur2.reprendre();
				controlerJeu.reprendre();
				pause = false;
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

}
