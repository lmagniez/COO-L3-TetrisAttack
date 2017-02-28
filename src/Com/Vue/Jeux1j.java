package Com.Vue;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

import Com.Controller.GrilleControler;
import Com.Controller.JoueurController;
import Com.Model.GrilleModel;
import Com.Model.JoueurModel;
import Com.Observer.Observer;
import Constante.ConstanteDimension;
import Constante.ConstanteGraphique;
import Constante.ConstanteJeux;
import Gestion.Joueur;
import JComponent.Grille;
import KeyAdaptateur.MyKeyAdapter;
import KeyAdaptateur.ThreadJ1;
import Run.Fenetre;

public class Jeux1j extends JPanel implements ConstanteDimension, ConstanteJeux, ConstanteGraphique, Observer {

	private Fenetre fen;
	private Grille g;
	private Joueur j;

	private GrilleModel modelGrille;
	private GrilleControler controlerGrille;

	private JoueurModel modelJoueur;
	private JoueurController controlerJoueur;

	private Thread GestionClavier;
	protected boolean deplacementJoueur = true;
	private MyKeyAdapter adapt = new MyKeyAdapter();

	public Jeux1j(Fenetre f) {
		fen = f;

		modelGrille = new GrilleModel(1);
		controlerGrille = new GrilleControler(modelGrille);
		g = new Grille(controlerGrille, PositionGrille1JX, PositionGrille1JY);
		modelGrille.add(this);

		modelJoueur = new JoueurModel(1);
		controlerJoueur = new JoueurController(modelJoueur, controlerGrille);
		j = new Joueur(PositionGrille1JX, PositionGrille1JY, controlerJoueur, g.tailleX(), g.tailleY(), 1);
		modelJoueur.add(this);

		this.addKeyListener(adapt);

		g.init();

		creerlayout();
	}

	public void lancementAnimation() {
		animation();
	}

	public void animation() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				int taille = 0;
				int i = 0;
				while (g.isAnimationHaut()) {
					try {
						Jeux1j.this.controlerJoueur.verifUp(Jeux1j.this.j.getY1());
						Jeux1j.this.controlerGrille.ajoutLigne();
						Thread.sleep(2500);
					} catch (InterruptedException e) {
					}

				}
			}
		});
		thread.start();
	}

	public void threadClavier() {
		GestionClavier = new Thread(new Runnable() {
			public void run() {
				ThreadJ1 tA = new ThreadJ1(adapt.isZPressed(), adapt.isSPressed(), adapt.isQPressed(),
						adapt.isDPressed(), adapt.isFPressed(), Jeux1j.this.controlerJoueur);
				tA.start();
				while (Jeux1j.this.deplacementJoueur) {
					try {
						tA.setZPressed(adapt.isZPressed());
						tA.setSPressed(adapt.isSPressed());
						tA.setQPressed(adapt.isQPressed());
						tA.setDPressed(adapt.isDPressed());
						tA.setFPressed(adapt.isFPressed());
						tA.run(Jeux1j.this.j.getX1(), Jeux1j.this.j.getX2(), Jeux1j.this.j.getY1());
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
					Toolkit.getDefaultToolkit().sync();
				}
			}
		});
		GestionClavier.start();
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
		(this.g).dessinerGrille(g);
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
	public void updateCase(int j, int y, int x, int val) {
		this.g.updateCase(y, x, val);
		repaint();
	}

	@Override
	public void score(int id, int score) {
		this.j.setScore(score);
	}

}
