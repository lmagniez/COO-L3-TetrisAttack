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
				public void run() {
					int seconde=0;
					int minute=0;
					while (tourne) {
						try {
							seconde++;
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
			timer.start();
	}
	
	/**
	 * Démarrer
	 */
	public void start() {
		timer.start();
	}
	
	public void reprendre() {
		timer.resume();
	}

	public void pause() {
		timer.suspend();
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
		tourne=false;
	}
	
}
