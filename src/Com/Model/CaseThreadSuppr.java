package Com.Model;

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
	
	public CaseThreadSuppr(GrilleModel m,ArrayList<CaseModel> casesSuppr){
		this.casesSuppr=casesSuppr;
		for(int i=0; i<casesSuppr.size(); i++){
			casesSuppr.get(i).swappable=false;
		}
		this.m=m;
	}
	
	public void run(){
		
		try {
			Thread.sleep(1000);
			for(int i=0; i<casesSuppr.size(); i++){
				CaseModel c=casesSuppr.get(i);
				c.v = ValeurCase.VIDE;
				m.UpdateCase(c.x, c.y, ValeurCase.VIDE);
				c.swappable=true;
			}
			m.descendreCube();
				
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		
	}
	
	
}
