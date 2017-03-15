
package com.Controller;

import com.Model.AbstractModel;

/**
 * Controler abstrait
 * @author loick
 *
 */
public abstract class AbstractControler {

	// on ajoute le model au controler
	protected AbstractModel calc;

	public AbstractControler(AbstractModel cal) {
		calc = cal;
	}
}
