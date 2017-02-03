package Gestion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Com.Controller.JoueurController;
import JComponent.Grille;
import JComponent.Score;

public class Joueur {
	
	private int x1;
	private int x2;
	private int y1;
	
	private JoueurController controlerJoueur;
	
	public Joueur(JoueurController controler){
		x1=5;
		x2=6;
		y1=9;
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
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public void dessinerJoueur(Graphics g,int sizex,int sizey) {
		g.setColor(Color.white);
		g.drawRect(x1*sizex, y1*sizey, sizex, sizey);
		g.drawRect(x2*sizex, y1*sizey, sizex, sizey);
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
		case KeyEvent.VK_ESCAPE:
			
		default:
			return;
		}

	}
}
