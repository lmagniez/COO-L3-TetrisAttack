package com.Controller;

import java.util.Random;

import com.Model.CaseModel;
import com.Model.JoueurModel;
import com.Model.ValeurCase;

public class JoueurControlerIA extends JoueurControler {

	public Random RND = new Random();
	private Thread ia;
	private boolean iatourne = true;

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

	public boolean caseBas(int y1, int x1, int x2, CaseModel[][] recupGrille) {
		return (y1 != nombredeLigneTeste);
	}

	public boolean caseHaut(int y1, int x1, int x2, CaseModel[][] recupGrille) {
		if (y1 == 0 || (recupGrille[x1][y1 - 1].v == ValeurCase.VIDE && recupGrille[x2][y1 - 1].v == ValeurCase.VIDE))
			return false;
		return true;
	}

	public boolean caseDroit(int y1, int x1, int x2, CaseModel[][] recupGrille) {
		return x2 != (nombredecase-1);
	}

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

	public void reprendreThread() {
		super.reprendreThread();
		iatourne = true;
	}
}
