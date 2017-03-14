package com.Controller;

import com.Model.AbstractModel;
import com.Model.ModelJeux;

public class JeuxControler extends AbstractControler {

	private Thread timer;
	private boolean tourne=true;
	
	public JeuxControler(AbstractModel modelJeux) {
		super(modelJeux);
	}

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
							((ModelJeux) JeuxControler.this.calc).updateTime(minute,seconde);
							Thread.sleep(1000);
						} catch (InterruptedException e) {
						}

					}
				}
			});
			timer.start();
	}
	
	public void start() {
		timer.start();
	}
	
	public void reprendre() {
		timer.resume();
	}

	public void pause() {
		timer.suspend();
	}

	public void arreterThread() {
		tourne=false;
	}
	public void reprendreThread() {
		tourne=false;
	}
	
}
