
package Com.Controller;

import Com.Model.AbstractModel;

public abstract class AbstractControler {

	// on ajoute le model au controler
	protected AbstractModel calc;

	public AbstractControler(AbstractModel cal) {
		calc = cal;
	}
}
