package Gestion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Com.Controller.JoueurController;
import Constante.ConstanteJeux;
import JComponent.Grille;
import JComponent.Score;
import Run.Sound;

public class Joueur implements ConstanteJeux {
	
	private int x1;
	private int x2;
	
	private int x1Grille;
	private int x2Grille;
	private int yGrille;
	
	private int y1;
	
	 private int sizex;
	 private int sizey;
	 private int indice;
	
	private JoueurController controlerJoueur;
	
	public Joueur(JoueurController controler,int sizex,int sizey,int indice){
		this.x1=5;
		this.x2=6;
		this.y1=9;
		
		this.indice=indice;
		
		this.x1Grille=PositionGrille1JX+x1*sizex;
		this.x2Grille=PositionGrille1JX+x2*sizex;
		this.yGrille=PositionGrille1JY+y1*sizey;	
		
		this.sizex=sizex;
		this.sizey=sizey;

		controlerJoueur=controler;
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY1() {
		return y1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
		this.x1Grille=PositionGrille1JX+x1*sizex;
	}

	public void setX2(int x2) {
		this.x2 = x2;
		this.x2Grille=PositionGrille1JX+x2*sizex;
	}

	public void setY1(int y1) {
		this.y1 = y1;
		this.yGrille=PositionGrille1JY+y1*sizey;	
	}

	public int getyGrille() {
		return yGrille;
	}

	public void setyGrille(int yGrille) {
		this.yGrille = yGrille;
	}

	public void dessinerJoueur(Graphics g) {
		g.setColor(Color.white);
		g.drawRect(x1Grille, yGrille, sizex, sizey);
		g.drawRect(x2Grille, yGrille, sizex, sizey);
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			controlerJoueur.verifUp(y1);
			break;
		case KeyEvent.VK_DOWN:
			controlerJoueur.verifDown(y1);
			break;
		case KeyEvent.VK_LEFT:
			controlerJoueur.verifLeft(x1);
			break;
		case KeyEvent.VK_RIGHT:
			controlerJoueur.verifRigth(x2);
			break;
		case KeyEvent.VK_A:
			controlerJoueur.actionswap(x1,x2,y1);
			break;
		case KeyEvent.VK_M:
      	  Sound.changerParam();
        break;
		case KeyEvent.VK_ESCAPE:
			
		default:
			return;
		}

	}
}
