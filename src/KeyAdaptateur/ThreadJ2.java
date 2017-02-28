package KeyAdaptateur;

import Com.Controller.AbstractControler;
import Com.Controller.JoueurController;

public class ThreadJ2 extends Thread {
	
	private boolean isOPressed = false;
	private boolean isLPressed = false;
	private boolean isKPressed = false;
	private boolean isMPressed = false;
	private boolean isJPressed = false;

	private JoueurController controlerJoueur;

	public ThreadJ2(boolean z, boolean s, boolean q, boolean d, boolean f, JoueurController controlerJ) {
		isOPressed = z;
		isLPressed = s;
		isKPressed = q;
		isMPressed = d;
		isJPressed = f;
		controlerJoueur = controlerJ;
	}

	public void run(int x1, int x2, int y) {
		if (isOPressed) {
			controlerJoueur.verifUp(y);
		}
		if (isLPressed) {
			controlerJoueur.verifDown(y);
		}
		if (isKPressed) {
			controlerJoueur.verifLeft(x1);
		}
		if (isMPressed) {
			controlerJoueur.verifRigth(x2);
		}
		if (isJPressed) {
			controlerJoueur.actionswap(x1, x2, y);
		}
	}

	public void setOPressed(boolean isOPressed) {
		this.isOPressed = isOPressed;
	}

	public void setLPressed(boolean isLPressed) {
		this.isLPressed = isLPressed;
	}

	public void setKPressed(boolean isKPressed) {
		this.isKPressed = isKPressed;
	}

	public void setMPressed(boolean isMPressed) {
		this.isMPressed = isMPressed;
	}

	public void setJPressed(boolean isJPressed) {
		this.isJPressed = isJPressed;
	}
	
}
