package Ecran;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Animation {

	private JPanel p;
	
	private Image img;
	protected int posX,posY;
	private int imgWidth, imgHeight;
	private int screenWidth,screenHeight;
	private int cpt;	
	private int nbImage;
	
	public Animation(Image img, int posX, int posY, int imgWidth, int imgHeight, 
			int screenWidth, int screenHeight, int cpt, int nbImage, JPanel p)
	{
		this.img=img;
		this.posX=posX;
		this.posY=posY;
		this.imgWidth=imgWidth;
		this.imgHeight=imgHeight;
		this.screenWidth=screenWidth;
		this.screenHeight=screenHeight;
		this.cpt=cpt;
		this.nbImage=nbImage;
		this.p=p;
	}
	
	public void updateCpt()
	{
		cpt= (cpt + 1) % nbImage;
	}

	public void draw(Graphics g)
	{
		g.drawImage(img, posX, posY, posX-screenWidth, posY-screenHeight,
	    		imgWidth*(cpt+1), imgHeight, 
	    		imgWidth*(cpt), 0, p);
	}

	@Override
	public String toString() {
		return "Animation [p=" + p + ", img=" + img + ", posX=" + posX + ", posY=" + posY + ", imgWidth=" + imgWidth
				+ ", imgHeight=" + imgHeight + ", screenWidth=" + screenWidth + ", screenHeight=" + screenHeight
				+ ", cpt=" + cpt + ", nbImage=" + nbImage + "]";
	}
		
	
	
	

}
