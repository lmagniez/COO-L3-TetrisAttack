package com.Controller;

import java.util.Random;

import com.Model.CaseModel;
import com.Model.JoueurModel;
import com.Model.ValeurCase;

/**
 * Controler du joueur de l'IA, extension du joueurControler
 * @author loick
 *
 */
public class JoueurControlerIA extends JoueurControler {

	public Random RND = new Random();
	private Thread ia;
	private boolean iatourne = true;

	/**
	 * Constructeur
	 * @param cal modèle du joueur
	 * @param grilleCont controler de la grille
	 * @param lvl niveau du joueur
	 */
	public JoueurControlerIA(JoueurModel cal, GrilleControler grilleCont, int lvl) {
		super(cal, grilleCont, lvl);
	}

	public void reprendre() {
		super.reprendre();
		ia.resume();
	}

	public void pause() {
		super.pause();
		ia.suspend();
	}

	/**
	 * Thread de l'IA
	 */
	public void ia() {
		ia = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (tourne) {
					int dir = RND.nextInt(4);
					dir=reflexion(dir);
					System.out.println(dir);
					switch (dir) {
					case 0:
						verifUp(joueurModel.getY1());
						break;
					case 1:
						verifDown(joueurModel.getY1());
						break;
					case 2:
						verifLeft(joueurModel.getX1());
						break;
					case 3:
						verifRight(joueurModel.getX2());
						break;
					}
					int swap = RND.nextInt(10);
					if (swap <= 7)
						actionswap(joueurModel.getX1(), joueurModel.getX2(), joueurModel.getY1());

					try {
						Thread.sleep((zzz * 1000) / 5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			/**
			 * Teste si il y a au moins une case sur la ligne où l'ia compte se déplacer
			 * @param dir direction empruntée
			 * @return -1 si impossible
			 */
			private int reflexion(int dir) {
				int res=-1;
				switch (dir) {
				case 0:
					if(caseHaut(joueurModel.getY1(),joueurModel.getX1(), joueurModel.getX2(),grilleCont.recupGrille()))
						return dir;
					break;
				case 1:
					if(caseBas(joueurModel.getY1(),joueurModel.getX1(), joueurModel.getX2(),grilleCont.recupGrille()))
						return dir;
					break;
				case 2:
					if(caseGauche(joueurModel.getY1(),joueurModel.getX1(), joueurModel.getX2(),grilleCont.recupGrille()))
						return dir;
					break;
				case 3:
					if(caseDroit(joueurModel.getY1(),joueurModel.getX1(), joueurModel.getX2(),grilleCont.recupGrille()))
						return dir;
					break;
				}
				
				return reflexion(RND.nextInt(4));
			}

		});
		ia.start();
	}

	/**
	 * L'IA peut-elle se déplacer vers le bas?
	 * @param y1 ordonnée
	 * @param x1 abscisse1
	 * @param x2 abscisse2
	 * @param recupGrille ensemble des cases
	 * @return peut se déplacer ou non
	 */
	public boolean caseBas(int y1, int x1, int x2, CaseModel[][] recupGrille) {
		return (y1 != nombredeLigneTeste);
	}

	/**
	 * L'IA peut-elle se déplacer vers le haut? (ligne vide?)
	 * @param y1 ordonnée
	 * @param x1 abscisse1
	 * @param x2 abscisse2
	 * @param recupGrille ensemble des cases
	 * @return peut se déplacer ou non
	 */
	public boolean caseHaut(int y1, int x1, int x2, CaseModel[][] recupGrille) {
		if (y1 == 0 || (recupGrille[x1][y1 - 1].v == ValeurCase.VIDE && recupGrille[x2][y1 - 1].v == ValeurCase.VIDE))
			return false;
		return true;
	}

	/**
	 * L'IA peut-elle se déplacer vers la gauche? 
	 * @param y1 ordonnée
	 * @param x1 abscisse1
	 * @param x2 abscisse2
	 * @param recupGrille ensemble des cases
	 * @return peut se déplacer ou non
	 */
	public boolean caseDroit(int y1, int x1, int x2, CaseModel[][] recupGrille) {
		return x2 != (nombredecase-1);
	}

	/**
	 * L'IA peut-elle se déplacer vers la droite? 
	 * @param y1 ordonnée
	 * @param x1 abscisse1
	 * @param x2 abscisse2
	 * @param recupGrille ensemble des cases
	 * @return peut se déplacer ou non
	 */
	public boolean caseGauche(int y1, int x1, int x2, CaseModel[][] recupGrille) {
			return x1 != 0;
	}

	/**
	 * Fin du jeu
	 */
	public void arreterThread() {
		super.arreterThread();
		iatourne = false;
	}

	/**
	 * Reprendre le jeu
	 */
	public void reprendreThread() {
		super.reprendreThread();
		iatourne = true;
		ia();
	}
	
	
}
