package Com.Controller;

import Com.Model.AbstractModel;
import Com.Model.GrilleModel;

public class GrilleControler extends AbstractControler {

	public GrilleControler(GrilleModel cal) {
		super(cal);
	}

	public void initGrille() {
		((GrilleModel) this.calc).recupGrille();
	}

}
