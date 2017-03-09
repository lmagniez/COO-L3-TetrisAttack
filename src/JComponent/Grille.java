package JComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import Com.Controller.GrilleControler;
import Com.Model.ValeurCase;
import Com.Observer.Observer;
import Constante.ConstanteDimension;
import Constante.ConstanteGraphique;
import Constante.ConstanteJeux;

public class Grille extends JPanel implements ConstanteDimension, ConstanteGraphique, ConstanteJeux, ActionListener {

	private boolean animationHaut = true;
	private boolean gameOver = false;

	private JPanel jeu;
	private int posGx,posGy;
	private Case[][] tab = new Case[nombredecase][nombredeLigne];

	private GrilleControler controlerGrille;
	//public static ValeurCase[] couleurs=new ValeurCase[ConstanteJeux.nombreCouleur];
	private Timer timer;
	
	private int y;
	private int tailleny, taillenx;

	
	/**
	 * Constructeur
	 * @param jeu JPanel intégrant la grille
	 * @param controler controler
	 * @param x abscisse grille
	 * @param y ordonnée grille
	 */
	public Grille(JPanel jeu, GrilleControler controler,int x,int y) {
		this.jeu=jeu;
		controlerGrille = controler;
		posGx=x;
		posGy=y;
		tailleny = DimensionGrilley / (nombredeLigne - 2 * reserve);
		taillenx = DimensionGrillex / nombredecase;

		this.setPreferredSize(new Dimension(DimensionGrillex, DimensionGrilley));
		setBackground(new Color(0, 0, 0, 90));
		
		//pour faciliter dessin grille
		/*
		for(int i=0; i<ConstanteJeux.nombreCouleur; i++){
			couleurs[i]=ValeurCase.fromInteger(i);
		}*/
		
		timer = new Timer(100, this);
		timer.start();
		
		
	}

	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == timer){
			for (int a = 0; a < nombredeLigne - reserve - 1; a++) {
				for (int i = 0; i < nombredecase; i++) {
					tab[i][a].animBloc.updateCpt();
					tab[i][a].animBloc.setPosX(posGx+ (i+1) * taillenx);
					tab[i][a].animBloc.setPosY(posGy+ (a+1) * tailleny);
				}
			}
			jeu.repaint();	
		}
		else if (e.getActionCommand().equals("arreter")) timer.stop();
		else if (e.getActionCommand().equals("reprendre")) timer.restart();
		
	}
	
	public void init() {controlerGrille.initGrille();}

	public void swaphorizontal(int x1, int x2, int y) {
		ValeurCase value = tab[x1][y].getValeur();
		this.tab[x1][y].setValeur(this.tab[x2][y].getValeur());
		this.tab[x2][y].setValeur(value);
	}

	public void swapvertical(int x, int y1, int y2) {
		ValeurCase value = tab[x][y2].getValeur();
		this.tab[x][y2].setValeur(this.tab[x][y1].getValeur());
		this.tab[x][y1].setValeur(value);
	}
	
	public void affiche(){
		for (int a = 0; a < nombredeLigne - reserve; a++) {
			for (int i = 0; i < nombredecase; i++) {
				 System.out.print(tab[i][a].getValeur()+"  ");
			}
			System.out.println();
		}
	}
	
	public void paintComponent(Graphics g){
		for (int a = 0; a < nombredeLigne - reserve - 1; a++) {
			for (int i = 0; i < nombredecase; i++) {
				tab[i][a].animBloc.draw(g);
			}
		}
	}	

	public int tailleX() {
		return taillenx;
	}

	public int tailleY() {
		return tailleny;
	}

	public void updateCase(int y, int x, ValeurCase val) {
		tab[x][y] = new Case(this, x * taillenx, y * tailleny, taillenx, tailleny, val);
	}
}
