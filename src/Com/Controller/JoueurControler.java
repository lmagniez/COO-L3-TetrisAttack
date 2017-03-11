package Com.Controller;

import Com.Model.JoueurModel;
import Com.Vue.Jeux1j;
import Constante.ConstanteDimension;
import Constante.ConstanteJeux;

public class JoueurController implements ConstanteJeux,ConstanteDimension {

	private JoueurModel joueurModel;
	private GrilleControler grilleCont;
	private int zzz=5000;
	private Thread thread;
	
	public JoueurController(JoueurModel cal,GrilleControler grilleCont,int zzz) {
		this.joueurModel=cal;
		this.grilleCont=grilleCont;
		this.zzz=this.zzz-(zzz*20);
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
	
	public void verifUpGraphique(int y1){
		if (y1 != 0) {
			this.joueurModel.monteJoueurGraphique();
		}
	}

	public void verifDown(int y1) {
		if (y1 != nombredeLigne - reserve -2) {
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

	public void animation() {
		thread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				int monte=JoueurController.this.zzz / (DimensionGrilley / (nombredeLigne - 2 * reserve) );
				while (true) {
					try {
						i++;
						if(i==JoueurController.this.zzz){
							JoueurController.this.verifUp(JoueurController.this.joueurModel.getY1());
							JoueurController.this.grilleCont.ajoutLigne();
							i=0;
						}
						if( i % monte ==0 ){
							verifUpGraphique(JoueurController.this.joueurModel.getY1());
							JoueurController.this.grilleCont.montegrilleGraphique();
						}
						
						Thread.sleep(1);
					} catch (InterruptedException e) {
					}

				}
			}
		});
		thread.start();
	}
	
	public void reprendre() {
		thread.resume();
	}

	public void pause() {
		thread.suspend();
	}
}
