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
	
	public JoueurControler(JoueurModel cal,GrilleControler grilleCont,int zzz) {
		this.joueurModel=cal;
		this.grilleCont=grilleCont;
		this.zzz=this.zzz-(zzz*20);
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
/*<<<<<<< HEAD:src/Com/Controller/JoueurControler.java
		if (y1 != nombredeLigne-1){
		//if (y1 != nombredeLigne - reserve -2) {
=======*/
		if (y1 != nombredeLigneTeste) {
//>>>>>>> f97c4f5db9b580ce50644c9a7473a5684cb277f6:src/Com/Controller/JoueurController.java
			this.joueurModel.changeBas();
		}
	}

	
	public void verifLeft(int x1) {
		if (x1 != 0) {
			this.joueurModel.changeGauche();
		}

	}

	public void verifRight(int x2) {
		if (x2 != nombredecase - 2) {
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
				while (true) {
					try {
						Thread.sleep(1);
						
						if(monteActif){
							i++;
						}
						if(i==JoueurControler.this.zzz){
						//if(i==JoueurControler.this.zzz&&monteActif){
							System.out.println(">>>>>>>>>>>OKKKK");
							JoueurControler.this.verifUp(JoueurControler.this.joueurModel.getY1());
							JoueurControler.this.grilleCont.ajoutLigne();
							i=0;
						}
						/*
						if(i==JoueurControler.this.zzz&&!monteActif){
							System.out.println(">>>>>NOT OK");
							i=0;
						}*/
						if(monteActif&& i % monte ==0 ){
							verifUpGraphique(JoueurControler.this.joueurModel.getY1());
							JoueurControler.this.grilleCont.montegrilleGraphique();
						}
						
						
					} catch (InterruptedException e) {
							// TODO Auto-generated catch block
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
}
