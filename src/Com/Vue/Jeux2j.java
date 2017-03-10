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

public class Jeux2j extends JPanel implements ConstanteDimension, ConstanteJeux, ConstanteGraphique, Observer {

	private Fenetre fen;
	private Grille g1;
	private Grille g2;

	private Joueur j1;
	private Joueur j2;

	private GrilleModel modelGrille1;
	private GrilleControler controlerGrille1;

	private JoueurModel modelJoueur1;
	private JoueurController controlerJoueur1;

	private GrilleModel modelGrille2;
	private GrilleControler controlerGrille2;

	private JoueurModel modelJoueur2;
	private JoueurController controlerJoueur2;

	private JeuxControler controlerJeu;
	private ModelJeux modelJeux;

	private boolean drawOnce = true;

	private boolean pause=false;
	
	public Jeux2j(Fenetre f, int[] option) {  //Option =  0 -> vitesse J1 1->idtheme j1 2 -> vitesse J2 3 -> idtheme j2
		fen = f;

		modelJeux = new ModelJeux(this);
		controlerJeu=new JeuxControler(modelJeux);
		
		modelGrille1 = new GrilleModel(1);
		controlerGrille1 = new GrilleControler(modelGrille1);
		g1 = new Grille(this, controlerGrille1, PositionGrille2JX1, PositionGrille2JY1);
		modelGrille1.add(this);

		modelJoueur1 = new JoueurModel(1);
		controlerJoueur1 = new JoueurController(modelJoueur1, controlerGrille1,option[0]);
		j1 = new Joueur(PositionGrille2JX1, PositionGrille2JY1, controlerJoueur1, g1.tailleX(), g1.tailleY(), 1);
		modelJoueur1.add(this);

		modelGrille2 = new GrilleModel(2);
		controlerGrille2 = new GrilleControler(modelGrille2);
		g2 = new Grille(this, controlerGrille2, PositionGrille2JX2, PositionGrille2JY2);
		modelGrille2.add(this);

		modelJoueur2 = new JoueurModel(2);
		controlerJoueur2 = new JoueurController(modelJoueur2, controlerGrille2,option[2]);
		j2 = new Joueur(PositionGrille2JX2, PositionGrille2JY2, controlerJoueur2, g2.tailleX(), g2.tailleY(), 2);
		modelJoueur2.add(this);

		g1.init();
		g2.init();
		creerlayout();
	}

	public void GestionClavier(KeyEvent e) {
		if(!pause){
			if (e.getKeyCode() == KeyEvent.VK_Z) {
				controlerJoueur1.verifUp(j1.getY1());
			}
			else if (e.getKeyCode() == KeyEvent.VK_S) {
				controlerJoueur1.verifDown(j1.getY1());
			}
			else  if (e.getKeyCode() == KeyEvent.VK_Q) {
				controlerJoueur1.verifLeft(j1.getX1());
			}
			else if (e.getKeyCode() == KeyEvent.VK_D) {
				controlerJoueur1.verifRigth(j1.getX2());
			}
			else if (e.getKeyCode() == KeyEvent.VK_F) {
				controlerGrille1.swap(j1.getX1(), j1.getX2(), j1.getY1());
			}
			else if (e.getKeyCode() == KeyEvent.VK_O) {
				controlerJoueur2.verifUp(j2.getY1());
			}
			else if (e.getKeyCode() == KeyEvent.VK_L) {
				controlerJoueur2.verifDown(j2.getY1());
			}
			else if (e.getKeyCode() == KeyEvent.VK_K) {
				controlerJoueur2.verifLeft(j2.getX1());
			}
			else if (e.getKeyCode() == KeyEvent.VK_M) {
				controlerJoueur2.verifRigth(j2.getX2());
			}
			else if (e.getKeyCode() == KeyEvent.VK_J) {
				controlerGrille2.swap(j2.getX1(), j2.getX2(), j2.getY1());
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(pause){
				controlerJoueur1.reprendre();
				controlerJoueur2.reprendre();
				controlerJeu.reprendre();
				pause=false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			pause=true;
			controlerJeu.pause();
			controlerJoueur1.pause();
			controlerJoueur2.pause();
		}
		
	}

	public void lancementAnimation() {
		controlerJoueur1.animation();
		controlerJoueur2.animation();
		controlerJeu.timer();
	}

	private void creerlayout() {
		this.setLayout(null);
		this.add(g1);
		this.add(g2);
		this.add(j1.getScore());
		this.add(j2.getScore());
	}

	public void focus() {
		this.setFocusable(true);
		this.requestFocus();
	}

	public void paintComponent(Graphics g) {

		this.removeAll();
		this.revalidate();
		this.validate();

		if (this.drawOnce) {
			Color c = Color.black;
			g.fillRect(0, 0, ConstanteDimension.DimensionFenetrex, ConstanteDimension.DimensionFenetrey);
			// drawOnce=false;
		}

		(this.g1).paintComponent(g);
		// (this.g1).dessinerGrille(g);
		(this.j1).dessinerJoueur(g);
		(this.g2).paintComponent(g);
		// (this.g2).dessinerGrille(g);
		(this.j2).dessinerJoueur(g);
	}

	@Override
	public void swaphorizontal(int j, int x1, int x2, int y) {
		if (j == 1) {
			this.g1.swaphorizontal(x1, x2, y);
		} else {
			this.g2.swaphorizontal(x1, x2, y);
		}
		this.repaint();
	}

	@Override
	public void swapvertical(int j, int x, int y1, int y2) {
		if (j == 1) {
			this.g1.swapvertical(x, y1, y2);
		} else {
			this.g2.swapvertical(x, y1, y2);
		}

		this.repaint();
	}

	@Override
	public void updateJoueur(int j, int x1, int x2, int y) {
		if (j == 1) {
			this.j1.setX1(x1);
			this.j1.setX2(x2);
			this.j1.setY1(y);
			repaint();
		} else {
			this.j2.setX1(x1);
			this.j2.setX2(x2);
			this.j2.setY1(y);
			repaint();
		}
	}

	@Override
	public void updateCase(int j, int y, int x, ValeurCase val) {
		if (j == 1)
			this.g1.updateCase(y, x, val);
		else
			this.g2.updateCase(y, x, val);
		repaint();
	}

	@Override
	public void score(int id, int score) {
		if (id == 1)
			this.j1.setScore(score);
		else
			this.j2.setScore(score);
		repaint();
	}

	@Override
	public void updateTimer(String minute, String seconde) {
		System.out.println("Temps: "+ minute+" : "+seconde);
	}

	@Override
	public void bougeJoueurGraphique(int id) {
		if (id == 1)
			this.j1.setyGrille(j1.getyGrille()-1);
		else
			this.j2.setyGrille(j2.getyGrille()-1);
	}

	@Override
	public void bougerGrilleGraphique(int id) {
		if (id == 1)
			this.g1.monterGrille();
		else
			this.g2.monterGrille();
		repaint();
	}

	@Override
	public void reinitgrilleAnimation(int id) {
		if (id == 1){
			j1.reinitgrilleEmplacement();
			g1.reinitgrilleAnimation();
		}
		else{
			j2.reinitgrilleEmplacement();
			g2.reinitgrilleAnimation();
		}
		
		
	}

}
