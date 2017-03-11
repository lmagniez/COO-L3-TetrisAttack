package Ecran;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Animation {

	private JPanel p;

	private Image img;
	private int posX;
	private int posY;

	private int imgWidth, imgHeight;
	private int screenWidth, screenHeight;
	private int cpt;
	private int cptArret;
	private int nbImage;

	
	protected boolean moving;
	
	protected int grilleX,grilleY,grillePosX,grillePosY,grilleTailleEltX,grilleTailleEltY;
	
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
		this.nbImage=nbImage;
		this.p=p;
		this.moving=true;
	}
	
	public void addInfosGrille(int grilleX, int grilleY, int grillePosX, int grillePosY, int grilleTailleEltX, int grilleTailleEltY){
		this.grilleX=grilleX;
		this.grilleY=grilleY;
		this.grilleTailleEltX=grilleTailleEltX;
		this.grilleTailleEltY=grilleTailleEltY;
		this.grillePosX=grillePosX;
		this.grillePosY=grillePosY;
	}


	public void updateCpt() {
		
		cpt = (cpt + 1) % nbImage;
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
		this.posY = posGrilleY+ (y+1) * tailleEltY;
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

}
