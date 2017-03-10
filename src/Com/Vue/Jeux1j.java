package Com.Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import Com.Controller.GrilleControler;
import Com.Controller.JeuxControler;
import Com.Controller.JoueurController;
import Com.Model.GrilleModel;
import Com.Model.JoueurModel;
import Com.Model.ModelJeux;
import Com.Model.ValeurCase;
import Com.Observer.Observer;
import Constante.ConstanteDimension;
import Constante.ConstanteGraphique;
import Constante.ConstanteJeux;
import Gestion.Joueur;
import JComponent.Grille;
import Run.Fenetre;

public class Jeux1j extends JPanel implements ConstanteDimension, ConstanteJeux, ConstanteGraphique, Observer {

	private Fenetre fen;
	private Grille g;
	private Joueur j;

	private JeuxControler controlerJeu;
	private ModelJeux modelJeux;
	
	private GrilleModel modelGrille;
	private GrilleControler controlerGrille;

	private JoueurModel modelJoueur;
	private JoueurController controlerJoueur;
	
	protected boolean deplacementJoueur = true;
	private boolean pause=false;

	
	
	public Jeux1j(Fenetre f, int[] option) {
		fen = f;
		
		modelJeux = new ModelJeux(this);
		controlerJeu=new JeuxControler(modelJeux);
		
		
		modelGrille = new GrilleModel(1);
		controlerGrille = new GrilleControler(modelGrille);
		g = new Grille(this, controlerGrille, PositionGrille1JX, PositionGrille1JY);
		modelGrille.add(this);

		modelJoueur = new JoueurModel(1);
		controlerJoueur = new JoueurController(modelJoueur, controlerGrille,option[0]);
		j = new Joueur(PositionGrille1JX, PositionGrille1JY, controlerJoueur, g.tailleX(), g.tailleY(), 1);
		modelJoueur.add(this);

		g.init();

		creerlayout();
		
		this.setOpaque(true);
		this.setBackground(Color.black);
		
		
	}

	public void animation() {
		controlerJoueur.animation();
		controlerJeu.timer();
	}

	public void GestionClavier(KeyEvent e) {
		if(!pause){
			if (e.getKeyCode() == KeyEvent.VK_Z) {
				controlerJoueur.verifUp(j.getY1());
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				controlerJoueur.verifDown(j.getY1());
			}
			if (e.getKeyCode() == KeyEvent.VK_Q) {
				controlerJoueur.verifLeft(j.getX1());
			}
			if (e.getKeyCode() == KeyEvent.VK_D) {
				controlerJoueur.verifRigth(j.getX1());
			}
			if (e.getKeyCode() == KeyEvent.VK_F) {
				controlerGrille.swap(j.getX1(), j.getX2(), j.getY1());
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(pause){
				controlerJoueur.reprendre();
				controlerJeu.reprendre();
				pause=false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			pause=true;
			controlerJeu.pause();
			controlerJoueur.pause();
		}
	}

	private void creerlayout() {
		this.setLayout(null);
		this.add(g);
		this.add(j.getScore());
	}

	public void focus() {
		this.setFocusable(true);
		this.requestFocus();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Color c = Color.black;
		//g.fillRect(0, 0, ConstanteDimension.DimensionFenetrex, ConstanteDimension.DimensionFenetrey);

		(this.g).paintComponent(g);
		(this.j).dessinerJoueur(g);
	}

	@Override
	public void swaphorizontal(int j, int x1, int x2, int y) {
		this.g.swaphorizontal(x1, x2, y);
		this.repaint();
	}

	@Override
	public void swapvertical(int j, int x, int y1, int y2) {
		this.g.swapvertical(x, y1, y2);
		this.repaint();
	}

	@Override
	public void updateJoueur(int id, int x1, int x2, int y) {
		this.j.setX1(x1);
		this.j.setX2(x2);
		this.j.setY1(y);
		repaint();
	}

	@Override
	public void updateCase(int j, int y, int x, ValeurCase val) {
		this.g.updateCase(y, x, val);
		repaint();
	}

	@Override
	public void score(int id, int score) {
		this.j.setScore(score);
	}

	@Override
	public void updateTimer(String minute, String seconde) {
		System.out.println("Temps: "+ minute+" : "+seconde);
	}

	@Override
	public void bougeJoueurGraphique() {
		j.setyGrille(j.getyGrille()-1);
		repaint();
	}

	@Override
	public void bougerGrilleGraphique() {
		g.monterGrille();
		repaint();
	}
}
