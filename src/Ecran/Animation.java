package Ecran;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Animation {

	protected JPanel p;

	protected Image img;
	protected int posX;
	protected int posY;

	protected int imgWidth, imgHeight;
	protected int screenWidth, screenHeight;
	protected int cpt;
	protected int cptArret;
	private int nbImage;

	
	protected boolean moving;
	
	public int grilleX,grilleY,grillePosX,grillePosY;

	public int grilleTailleEltX;

	public int grilleTailleEltY;
	
	public Animation(Image img, int posX, int posY, int imgWidth, int imgHeight, 
			int screenWidth, int screenHeight, int cpt, int nbImage, JPanel p)
	{
		this.img=img;
		this.setPosX(posX);
		this.setPosY(posY);
		this.imgWidth=imgWidth;
		this.imgHeight=imgHeight;
		this.screenWidth=screenWidth;
		this.screenHeight=screenHeight;
		this.cpt=cpt;
		this.setNbImage(nbImage);
		this.p=p;
		this.moving=true;
	}
	
	/**
	 * Utilisé que pour la grille (extension classe)
	 * @param grilleX
	 * @param grilleY
	 * @param grillePosX
	 * @param grillePosY
	 * @param grilleTailleEltX
	 * @param grilleTailleEltY
	 */
	public void addInfosGrille(int grilleX, int grilleY, int grillePosX, int grillePosY, int grilleTailleEltX, int grilleTailleEltY){
		this.grilleX=grilleX;
		this.grilleY=grilleY;
		this.setGrilleTailleEltX(grilleTailleEltX);
		this.grilleTailleEltY=grilleTailleEltY;
		this.grillePosX=grillePosX;
		this.grillePosY=grillePosY;
	}


	public void updateCpt() {
		
		cpt = (cpt + 1) % getNbImage();
	}

	public void stopperAnimation(int cpt){
		this.cptArret=cpt;
		this.moving=false;
	}
	
	public void reprendreAnimation(){
		this.moving=true;
	}
	
	
	public void draw(Graphics g) {
		if(moving)
			g.drawImage(img, getPosX(), getPosY(), getPosX() - screenWidth, getPosY() - screenHeight, imgWidth * (cpt + 1),
				imgHeight, imgWidth * (cpt), 0, p);
		else
			g.drawImage(img, getPosX(), getPosY(), getPosX() - screenWidth, getPosY() - screenHeight, imgWidth * (cptArret + 1),
					imgHeight, imgWidth * (cptArret), 0, p);
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public void setPosXGrille(int posGrilleX, int x, int tailleEltX) {
		this.posX = posGrilleX+ (x+1) * tailleEltX;
	}
	
	public void setPosYGrille(int posGrilleY, int y, int tailleEltY) {
		this.posY = posGrilleY + (y+1) * tailleEltY;
	}
	

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getGrilleTailleEltX() {
		return grilleTailleEltX;
	}

	public void setGrilleTailleEltX(int grilleTailleEltX) {
		this.grilleTailleEltX = grilleTailleEltX;
	}

	public int getNbImage() {
		return nbImage;
	}

	public void setNbImage(int nbImage) {
		this.nbImage = nbImage;
	}

	public int getCpt() {
		return cpt;
	}

	public void setCpt(int cpt) {
		this.cpt = cpt;
	}
	
	

}
