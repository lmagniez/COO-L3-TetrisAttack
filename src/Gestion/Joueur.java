package Gestion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Com.Controller.JoueurControler;
import Constante.ConstanteGraphique;
import Constante.ConstanteImage;
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

	private int posXG, posYG;
	
	private JLabel score=new JLabel();

	private JoueurControler controlerJoueur;

	public Joueur(int x, int y, JoueurControler controler, int sizex, int sizey, int indice) {
		this.x1 = 5;
		this.x2 = 6;
		this.y1 = 9;
		this.posXG = x;
		this.posYG = y;
		this.indice = indice;

		this.x1Grille = posXG + x1 * sizex;
		this.x2Grille = posXG + x2 * sizex;
		this.yGrille = posYG + y1 * sizey;

		this.sizex = sizex;
		this.sizey = sizey;

		controlerJoueur = controler;
		
		creerlayout();
	}

	private void creerlayout() {
		score.setText(Integer.toString(0));
		if(indice==1)
			score.setBounds( 180 , 9 , 100, 100);
		else{
			score.setBounds( 620 , 9, 100, 100);
		}
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
		this.x1Grille = posXG + x1 * sizex;
	}

	public void setX2(int x2) {
		this.x2 = x2;
		this.x2Grille = posXG + x2 * sizex;
	}

	public void setY1(int y1) {
		if(y1<this.y1) {this.yGrille = yGrille - sizey;}
		if(y1>this.y1) {this.yGrille = yGrille + sizey;}
		this.y1 = y1;
	}

	public int getyGrille() {
		return yGrille;
	}

	public void setyGrille(int yGrille) {
		this.yGrille = yGrille;
	}

	public void dessinerJoueur(Graphics g,JPanel p) {
		g.setColor(Color.white);
		g.drawImage(ConstanteImage.curseurgauche, x1Grille-2, yGrille, sizex+2, sizey, p);
		g.drawImage(ConstanteImage.curseurdroit, x2Grille-2, yGrille, sizex+2, sizey, p);
	}

	public void setScore(int score) {
		this.score.setText(Integer.toString(score));
		this.score.repaint();
	}

	public JLabel getScore() {
		return score;
	}

	public void reinitgrilleEmplacement() {
		this.yGrille =  posYG + y1*sizey;
		
	}
	
	
}
