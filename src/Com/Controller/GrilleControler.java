package Com.Controller;

import Com.Model.AbstractModel;
import Com.Model.GrilleModel;

public class GrilleControler extends AbstractControler {

	public GrilleControler(GrilleModel cal) {
		super(cal);
	}

	public void swap(int x1, int x2, int y1) {

	}

	public void initGrille() {
		((GrilleModel) this.calc).recupGrille();
	}

}
