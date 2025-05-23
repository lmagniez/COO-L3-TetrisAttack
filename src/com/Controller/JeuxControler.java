package com.Controller;

import com.Model.AbstractModel;
import com.Model.JeuxModel;

/**
 * Controler du jeux, gère le timer du 
 * @author loick
 *
 */
public class JeuxControler extends AbstractControler {

	
	private Thread timer;
	private boolean tourne=true;
	//protected int seconde=0;
	//protected int minute=0;
	
	/**
	 * Constructeur
	 * @param modelJeux modèle du jeu
	 */
	public JeuxControler(AbstractModel modelJeux) {
		super(modelJeux);
	}

	/**
	 * Démarre le timer et met à jour le timer dans le modèle
	 */
	public void timer() {
			timer = new Thread(new Runnable() {
				int seconde=0;
				int minute=0;
				
				public void run() {
					while (tourne) {
						try {
							seconde++;
							if(seconde%30==0){
								((JeuxModel) calc).accelere();
							}
							if(seconde%60==0){
								minute++;
								seconde=0;
							}
							((JeuxModel) JeuxControler.this.calc).updateTime(minute,seconde);
							Thread.sleep(1000);
						} catch (InterruptedException e) {
						}

					}
				}
			});
	}
	
	/**
	 * Démarrer
	 */
	public void start() {
		timer.start();
	}
	
	public void reprendre() {
		// TODO: resume is deprecated
		//timer.resume();
	}

	public void pause() {
		// TODO: interrupt is deprecated
		//timer.interrupt();
	}

	
	/**
	 * Arreter le thread
	 */
	public void arreterThread() {
		tourne=false;
	}
	
	/**
	 * Reprendre le thread
	 */

	public void reprendreThread() {
		tourne=true;
	}

	public void reinitialisation() {
		tourne=true;
		timer();
	}
	
}
