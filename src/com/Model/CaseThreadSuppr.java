package com.Model;

import java.util.ArrayList;

import Ecran.Animation;

/**
 * Lorsqu'un pattern est détecté, on passe les cases concernées dans un état de suppression, 
 * puis on les supprime après un timer
 * @author loick
 *
 */
public class CaseThreadSuppr extends Thread{

	protected GrilleModel m;
	protected ArrayList<CaseModel> casesSuppr;
	protected int id;
	
	/**
	 * Constructeur 
	 * @param m modèle de la grille
	 * @param casesSuppr ensemble des cases à supprimer
	 */
	public CaseThreadSuppr(GrilleModel m,ArrayList<CaseModel> casesSuppr){
		this.casesSuppr=casesSuppr;
		//this.id=id;
		for(int i=0; i<casesSuppr.size(); i++){
			casesSuppr.get(i).swappable=false;
		}
		this.m=m;
	}
	
	/*public void monterLigne(){
		for(int i=0; i<casesSuppr.size(); i++){
			this.C
		}
	}*/
	
	/**
	 * Thread de la suppression
	 */
	public void run(){
		
		try {
			
			for(int i=0; i<casesSuppr.size(); i++){
				CaseModel c=casesSuppr.get(i);
				m.updateStopCase(c.y,c.x);
			}
			
			this.m.getControlerJoueur().stopperAjoutLigne();
			
			
			Thread.sleep(1000);
			for(int i=0; i<casesSuppr.size(); i++){
				CaseModel c=casesSuppr.get(i);
				c.v = ValeurCase.VIDE;
				m.UpdateCase(c.y, c.x, ValeurCase.VIDE);
				m.updateStartCase(c.y,c.x);
				
				c.swappable=true;
			}
			
			this.m.getControlerJoueur().activerAjoutLigne();
			
			m.score+=casesSuppr.size()*10;
			m.combo();
			m.getJoueurVue().score(id,m.score);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		
	}
	
	
}
