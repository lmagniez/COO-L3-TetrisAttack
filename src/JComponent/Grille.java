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
import Ecran.AnimationThread;

public class Grille extends JPanel implements ConstanteDimension, ConstanteGraphique, ConstanteJeux, ActionListener {

	private boolean animationHaut = true;
	private boolean gameOver = false;

	private JPanel jeu;
	private int posGx,posGy;
	private Case[][] tab = new Case[nombredecase][nombredeLigne];

	private GrilleControler controlerGrille;
	private Timer timer;
	protected AnimationThread animThread;
	
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
		animThread= new AnimationThread();
		
		
		this.setPreferredSize(new Dimension(DimensionGrillex, DimensionGrilley));
		setBackground(new Color(0, 0, 0, 90));

		timer = new Timer(50, this);
		timer.start();
		
		for(int i=0; i<nombredecase; i++){
			for(int j=0; j<nombredeLigne; j++){
				getTab()[i][j]= new Case(this, x * taillenx, y * tailleny, taillenx, tailleny, ValeurCase.VIDE);
				getTab()[i][j].getAnimBloc().addInfosGrille(i, j, posGx, posGy, taillenx, tailleny);
				animThread.getAnimations().add(getTab()[i][j].getAnimBloc());
			}
				
		}
		animThread.start();
	}

	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == timer){
			jeu.repaint();
		}
		else if (e.getActionCommand().equals("arreter")) timer.stop();
		else if (e.getActionCommand().equals("reprendre")) timer.restart();
	}
	
	public void init() {controlerGrille.initGrille();
	this.afficherGrille();}

	public void swaphorizontal(int x1, int x2, int y) {
		ValeurCase value = getTab()[x1][y].getValeur();
		this.getTab()[x1][y].setValeur(this.getTab()[x2][y].getValeur());
		this.getTab()[x2][y].setValeur(value);
	}

	public void swapvertical(int x, int y1, int y2) {
		ValeurCase value = getTab()[x][y2].getValeur();
		this.getTab()[x][y2].setValeur(this.getTab()[x][y1].getValeur());
		this.getTab()[x][y1].setValeur(value);
	}
	
	public void affiche(){
		for (int a = 0; a < nombredeLigne-1; a++) {
			for (int i = 0; i < nombredecase; i++) {

				 System.out.print(getTab()[i][a].getValeur()+"  ");
				// System.out.print(tab[i][a].animBloc.getPosY()+"  ");
			}
			System.out.println();
		}
	}
	
	public void paintComponent(Graphics g){
		for (int a = 0; a < nombredeLigne; a++) {
			for (int i = 0; i < nombredecase; i++) {
				getTab()[i][a].getAnimBloc().draw(g);
			}
		}
		g.setColor(new Color(0,0,0,110));
		g.fillRect(this.posGx,DimensionGrilley+posGy+tailleny, DimensionGrillex , tailleny);
	}	

	public int tailleX() {
		return taillenx;
	}

	public int tailleY() {
		return tailleny;
	}
	
	public void updateCase(int y, int x, ValeurCase val) {
		getTab()[x][y].setValeur(val);
	}

	public void monterGrille() {
 		for (int a = 0; a < nombredeLigne; a++) {
			for (int i = 0; i < nombredecase; i++) {
				tab[i][a].animBloc.setPosY(tab[i][a].animBloc.getPosY()-1);
			}
		}
	}


	public void reinitgrilleAnimation() {
		for (int a = 0; a < nombredeLigne; a++) {
			for (int i = 0; i < nombredecase; i++) {
				tab[i][a].animBloc.setPosXGrille(tab[i][a].animBloc.grillePosX, tab[i][a].animBloc.grilleX, tab[i][a].animBloc.getGrilleTailleEltX());
				tab[i][a].animBloc.setPosYGrille(tab[i][a].animBloc.grillePosY, tab[i][a].animBloc.grilleY, tab[i][a].animBloc.grilleTailleEltY);
			}
		}
	}
	
	public void afficherGrille(){
		System.out.println("//////--------GRILLEGRAPHIQ---------");
		for(int i=0; i<nombredeLigne; i++){
			for(int j=0; j<nombredecase; j++){
				System.out.print(this.getTab()[j][i].getValeur()+" ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}


	public Case[][] getTab() {
		return tab;
	}


	public void setTab(Case[][] tab) {
		this.tab = tab;
	}
	
}
