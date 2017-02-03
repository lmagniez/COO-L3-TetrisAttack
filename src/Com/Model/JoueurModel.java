package Com.Model;

public class JoueurModel extends JeuxModel {

	private int x1=5;
	private int x2=6;
	private int y1=9;
			
	public void changeHaut() {
		y1=y1-1;
		this.updateJoueur(x1,x2,y1);
	}

	public void changeGauche() {
		x2=x2-1;
		x1=x1-1;
		this.updateJoueur(x1,x2,y1);
	}

	public void changeBas() {
		y1=y1+1;
		this.updateJoueur(x1,x2,y1);
	}

	public void changeDroit() {
		x2=x2+1;
		x1=x1+1;
		this.updateJoueur(x1,x2,y1);
	}	
}
