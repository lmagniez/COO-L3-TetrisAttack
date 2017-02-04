package Com.Controller;

import Com.Model.JoueurModel;
import Constante.ConstanteJeux;

public class JoueurController extends AbstractControler implements ConstanteJeux {

	public JoueurController(JoueurModel cal) {
		super(cal);
	}

	public void actionswap(int x1, int x2, int y1) {
		this.calc.swap(x1,x2,y1);
	}

	public void verifUp(int y1) {
		if (y1 != 0) {
			((JoueurModel) this.calc).changeHaut();
		}
		else{
			return;
		}
	}

	public void verifDown(int y1) {
		if (y1 != nombredeLigne - reserve-1) {
			((JoueurModel) this.calc).changeBas();
		}
	}

	public void verifLeft(int x1) {
		if (x1 != 0) {
			((JoueurModel) this.calc).changeGauche();
		}

	}

	public void verifRigth(int x2) {
		if (x2 != nombredecase - 1) {
			((JoueurModel) this.calc).changeDroit();
		}
	}

}
