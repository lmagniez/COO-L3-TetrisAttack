package com.Controller;

import java.util.Random;

import com.Model.JoueurModel;

public class JoueurControlerIA extends JoueurControler {

	public Random RND=new Random();
	private Thread ia;
	private boolean iatourne=true;
	
	public JoueurControlerIA(JoueurModel cal, GrilleControler grilleCont, int lvl) {
		super(cal, grilleCont, lvl);
	}
	
	public void reprendre() {
		super.reprendre();
		ia.resume();
	}

	public void pause() {
		super.pause();
		ia.suspend();
	}
	
	
	public void ia() {
		ia = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (tourne) {
					int dir=RND.nextInt(4);
					System.out.println(dir);
					switch(dir){
					case 0:
						verifUp(joueurModel.getY1());
						break;
					case 1:
						verifDown(joueurModel.getY1());
						break;
					case 2:
						verifLeft(joueurModel.getX1());
						break;
					case 3:
						verifRight(joueurModel.getX2());
						break;
					}
					int swap=RND.nextInt(2);
					if(swap==1)
						actionswap(joueurModel.getX1(),joueurModel.getX2(),joueurModel.getY1());
					
					try {Thread.sleep(400);	} catch (InterruptedException e) {e.printStackTrace();}
				}
			}
		});
		ia.start();
	}
	
	/**
	 * Fin du jeu
	 */
	public void arreterThread() {
		super.arreterThread();
		iatourne=false;
	}
	
	
	public void reprendreThread() {
		super.reprendreThread();
		iatourne=true;
	}
}
