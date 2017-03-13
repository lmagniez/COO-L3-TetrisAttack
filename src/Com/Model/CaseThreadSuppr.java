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
				m.updateStartCase(c.y,c.x);
				
				c.v = ValeurCase.VIDE;
				m.UpdateCase(c.y, c.x, ValeurCase.VIDE);
				
				c.swappable=true;
			}
			
			this.m.getControlerJoueur().activerAjoutLigne();
			
			m.descendreCube();
			
			//this.m.listeThreadSuppr.remove(this);
			//this.m.controlerJoueur.activerAjoutLigne();
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		
	}
	
	
}
