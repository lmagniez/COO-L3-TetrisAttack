package Ecran;

import java.util.ArrayList;

public class AnimationThread extends Thread{

	private ArrayList<Animation> animations;
	protected boolean running;
	
	public AnimationThread(){
		this.running=true;
		this.setAnimations(new ArrayList<Animation>());
		
		
		
	}
	
	
	public void run(){
		
		for(int i=0; i<getAnimations().size(); i++){
			Animation a = getAnimations().get(i);
			
			a.setPosXGrille(a.grillePosX, a.grilleX, a.grilleTailleEltX);
			a.setPosYGrille(a.grillePosY, a.grilleY, a.grilleTailleEltY);
		}
		
		while(running){
			try {
				Thread.sleep(100);
				for(int i=0; i<getAnimations().size(); i++){
					
					Animation a = getAnimations().get(i);
					a.updateCpt();
					//a.setPosXGrille(a.grillePosX, a.grilleX, a.grilleTailleEltX);
					//a.setPosYGrille(a.grillePosY, a.grilleY, a.grilleTailleEltY);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	public void stopper(){
		this.running=false;
	}
	public void reprendre(){
		this.running=true;
	}


	public ArrayList<Animation> getAnimations() {
		return animations;
	}


	public void setAnimations(ArrayList<Animation> animations) {
		this.animations = animations;
	}
	
}
