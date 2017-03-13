package Com.Controller;

import Com.Model.AbstractModel;
import Com.Model.ModelJeux;

public class JeuxControler extends AbstractControler {

	private Thread timer;
	
	public JeuxControler(AbstractModel modelJeux) {
		super(modelJeux);
	}

	public void timer() {
			timer = new Thread(new Runnable() {
				public void run() {
					int seconde=0;
					int minute=0;
					while (true) {
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
	
	public void reprendre() {
		timer.resume();
	}

	public void pause() {
		timer.suspend();
	}
}
