package com.Controller;

import com.Model.JoueurModel;
import com.Vue.Jeux1j;
import Constante.ConstanteDimension;
import Constante.ConstanteJeux;

public class JoueurControler implements ConstanteJeux,ConstanteDimension {

	private JoueurModel joueurModel;
	private GrilleControler grilleCont;
	private int zzz=5000;
	private Thread thread;
	
	private volatile boolean monteActif;
	private boolean tourne=true;
	
	public JoueurControler(JoueurModel cal,GrilleControler grilleCont,int zzz) {
		this.joueurModel=cal;
		this.grilleCont=grilleCont;
		this.zzz=this.zzz-(zzz*30);
		this.monteActif=true;
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
		if (y1 != nombredeLigneTeste) {
			this.joueurModel.changeBas();
		}
	}

	
	public void verifLeft(int x1) {
		if (x1 != 0) {
			this.joueurModel.changeGauche();
		}

	}

	public void verifRight(int x2) {
		System.out.println(x2);
		if (x2 != nombredecase - 1) {
			this.joueurModel.changeDroit();
		}
	}

	public void stopperAjoutLigne(){
		this.monteActif=false;
	}
	
	public void activerAjoutLigne(){
		this.monteActif=true;
	}
	
	public void animation() {
		thread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				int monte=JoueurControler.this.zzz / (DimensionGrilley / (nombredeLigne - 2 * reserve) );
				while (tourne) {
					try {
						Thread.sleep(1);
						
						if(monteActif){
							i++;
						}
						if(i==JoueurControler.this.zzz){
						
							System.out.println(">>>>>>>>>>>OKKKK");
							JoueurControler.this.verifUp(JoueurControler.this.joueurModel.getY1());
							JoueurControler.this.grilleCont.ajoutLigne();
							if(JoueurControler.this.grilleCont.gameOver())System.out.println("GameOver");
							i=0;
						}
					
						if(monteActif&& i % monte ==0 ){
							verifUpGraphique(JoueurControler.this.joueurModel.getY1());
							JoueurControler.this.grilleCont.montegrilleGraphique();
						}
						
						
					} catch (InterruptedException e) {
						e.printStackTrace();
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

	public void arreterThread() {
		tourne=false;
	}
}
