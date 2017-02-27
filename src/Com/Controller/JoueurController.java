package Com.Controller;

import Com.Model.JoueurModel;
import Constante.ConstanteJeux;

public class JoueurController implements ConstanteJeux {

	private JoueurModel joueurModel;
	private GrilleControler grilleCont; 
	
	public JoueurController(JoueurModel cal,GrilleControler grilleCont) {
		this.joueurModel=cal;
		this.grilleCont=grilleCont;
	}

	public void actionswap(int x1, int x2, int y1) {
		this.grilleCont.swap(x1,x2,y1);
	}

	public void verifUp(int y1) {
		if (y1 != 0) {
			this.joueurModel.changeHaut();
		}
		else{
			return;
		}
	}

	public void verifDown(int y1) {
		if (y1 != nombredeLigne - reserve-1) {
			this.joueurModel.changeBas();
		}
	}

	public void verifLeft(int x1) {
		if (x1 != 0) {
			this.joueurModel.changeGauche();
		}

	}

	public void verifRigth(int x2) {
		if (x2 != nombredecase - 1) {
			this.joueurModel.changeDroit();
		}
	}

}
