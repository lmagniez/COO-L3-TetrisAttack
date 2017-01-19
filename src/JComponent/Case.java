package JComponent;

public class Case {
	private int x;
	private int y;
	private int tailleX;
	private  int tailleY;
	private int valeur;
	
	public Case(int a,int b,int dimx,int dimy,int v){
		x=a;
		y=b;
		tailleX=dimx;
		tailleY=dimy;
		valeur=v;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getTailleX() {
		return tailleX;
	}

	public int getTailleY() {
		return tailleY;
	}

	public int getValeur() {
		return valeur;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setTailleX(int tailleX) {
		this.tailleX = tailleX;
	}

	public void setTailleY(int tailleY) {
		this.tailleY = tailleY;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	
	
}
