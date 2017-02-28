package Com.Vue;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

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
import KeyAdaptateur.ThreadJ2;
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

	private Thread GestionClavier;
	protected boolean deplacementJoueur = true;
	private MyKeyAdapter adapt = new MyKeyAdapter();

	public Jeux2j(Fenetre f) {
		fen = f;

		modelGrille1 = new GrilleModel(1);
		controlerGrille1 = new GrilleControler(modelGrille1);
		g1 = new Grille(controlerGrille1, PositionGrille2JX1, PositionGrille2JY1);
		modelGrille1.add(this);

		modelJoueur1 = new JoueurModel(1);
		controlerJoueur1 = new JoueurController(modelJoueur1, controlerGrille1);
		j1 = new Joueur(PositionGrille2JX1, PositionGrille2JY1, controlerJoueur1, g1.tailleX(), g1.tailleY(), 1);
		modelJoueur1.add(this);

		modelGrille2 = new GrilleModel(2);
		controlerGrille2 = new GrilleControler(modelGrille2);
		g2 = new Grille(controlerGrille2, PositionGrille2JX2, PositionGrille2JY2);
		modelGrille2.add(this);

		modelJoueur2 = new JoueurModel(2);
		controlerJoueur2 = new JoueurController(modelJoueur2, controlerGrille2);
		j2 = new Joueur(PositionGrille2JX2, PositionGrille2JY2, controlerJoueur2, g2.tailleX(), g2.tailleY(), 2);
		modelJoueur2.add(this);

		g1.init();
		g2.init();

		this.addKeyListener(adapt);

		creerlayout();
	}

	public void threadClavier() {
		GestionClavier = new Thread(new Runnable() {
			public void run() {
				ThreadJ1 tA = new ThreadJ1(adapt.isZPressed(), adapt.isSPressed(), adapt.isQPressed(),
						adapt.isDPressed(), adapt.isFPressed(), Jeux2j.this.controlerJoueur1);
				ThreadJ2 tB = new ThreadJ2(adapt.isOPressed(), adapt.isLPressed(), adapt.isKPressed(),
						adapt.isMPressed(), adapt.isJPressed(), Jeux2j.this.controlerJoueur2);
				tA.start();
				tB.start();
				while (Jeux2j.this.deplacementJoueur) {
					try {
						tA.setZPressed(adapt.isZPressed());
						tA.setSPressed(adapt.isSPressed());
						tA.setQPressed(adapt.isQPressed());
						tA.setDPressed(adapt.isDPressed());
						tA.setFPressed(adapt.isFPressed());
						tA.run(Jeux2j.this.j1.getX1(), Jeux2j.this.j1.getX2(), Jeux2j.this.j1.getY1());

						tB.setOPressed(adapt.isOPressed());
						tB.setLPressed(adapt.isLPressed());
						tB.setMPressed(adapt.isMPressed());
						tB.setKPressed(adapt.isKPressed());
						tB.setJPressed(adapt.isJPressed());
						tB.run(Jeux2j.this.j2.getX1(), Jeux2j.this.j2.getX2(), Jeux2j.this.j2.getY1());

						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
					Toolkit.getDefaultToolkit().sync();
				}
			}
		});
		GestionClavier.start();
	}

	public void lancementAnimation() {
		controlerJoueur1.animation();
		controlerJoueur2.animation();
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
		(this.g1).dessinerGrille(g);
		(this.j1).dessinerJoueur(g);
		(this.g2).dessinerGrille(g);
		(this.j2).dessinerJoueur(g);
	}

	@Override
	public void swaphorizontal(int j, int x1, int x2, int y) {
		if (j == 1) {
			this.g1.swaphorizontal(x1, x2, y);
		}
		else{
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
	public void updateCase(int j, int y, int x, int val) {
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

}
