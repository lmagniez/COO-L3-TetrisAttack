package KeyAdaptateur;

import Com.Controller.JoueurController;

public class ThreadJ1 extends Thread {

	private boolean isZPressed = false;
	private boolean isSPressed = false;
	private boolean isQPressed = false;
	private boolean isDPressed = false;
	private boolean isFPressed = false;

	private JoueurController controlerJoueur;

	public ThreadJ1(boolean z, boolean s, boolean q, boolean d, boolean f, JoueurController controlerJ) {
		isZPressed = z;
		isSPressed = s;
		isQPressed = q;
		isDPressed = d;
		isFPressed = f;
		controlerJoueur = controlerJ;
	}

	public void run(int x1, int x2, int y) {
		if (isZPressed) {
			controlerJoueur.verifUp(y);
		}
		if (isSPressed) {
			controlerJoueur.verifDown(y);
		}
		if (isQPressed) {
			controlerJoueur.verifLeft(x1);
		}
		if (isDPressed) {
			controlerJoueur.verifRigth(x2);
		}
		if (isFPressed) {
			controlerJoueur.actionswap(x1, x2, y);
		}
	}

	public void setZPressed(boolean isZPressed) {
		this.isZPressed = isZPressed;
	}

	public void setSPressed(boolean isSPressed) {
		this.isSPressed = isSPressed;
	}

	public void setQPressed(boolean isQPressed) {
		this.isQPressed = isQPressed;
	}

	public void setDPressed(boolean isDPressed) {
		this.isDPressed = isDPressed;
	}

	public void setFPressed(boolean isFPressed) {
		this.isFPressed = isFPressed;
	}
}