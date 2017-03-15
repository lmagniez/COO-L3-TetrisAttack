package Ecran;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * Classe générique des animations
 * @author loick
 *
 */
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
	
	/**
	 * Constructeur
	 * @param img Image (feuille de sprite
	 * @param posX position X
	 * @param posY position Y
	 * @param imgWidth largeur d'une image
	 * @param imgHeight hauteur d'une image
	 * @param screenWidth largeur réelle d'une image sur l'écran
	 * @param screenHeight hauteur réelle d'une image sur l'écran
	 * @param cpt compteur de l'image
	 * @param nbImage nombre d'images dans l'animation
	 * @param p panel dans lequel on intègre l'animation
	 */
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


	/**
	 * Mettre à jour le compteur de l'image
	 */
	public void updateCpt() {
		
		cpt = (cpt + 1) % getNbImage();
	}

	/**
	 * Stopper l'animation et définir une image 
	 * @param cpt image 
	 */
	public void stopperAnimation(int cpt){
		this.cptArret=cpt;
		this.moving=false;
	}
	
	/**
	 * Reprendre l'animation
	 */
	public void reprendreAnimation(){
		this.moving=true;
	}
	
	/**
	 * Dessiner l'animation
	 * @param g
	 */
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
