package Com.Vue;

import java.awt.Graphics;

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

	public Jeux2j(Fenetre f) {
		fen = f;

		modelGrille1 = new GrilleModel(1);
		controlerGrille1 = new GrilleControler(modelGrille1);
		g1 = new Grille(controlerGrille1,PositionGrille2JX1,PositionGrille2JY1);
		modelGrille1.add(this);

		modelJoueur1 = new JoueurModel(1);
		controlerJoueur1 = new JoueurController(modelJoueur1,controlerGrille1);
		j1 = new Joueur(PositionGrille2JX1,PositionGrille2JY1,controlerJoueur1, g1.tailleX(), g1.tailleY(),1);
		modelJoueur1.add(this);
		
		modelGrille2 = new GrilleModel(2);
		controlerGrille2 = new GrilleControler(modelGrille2);
		g2 = new Grille(controlerGrille2,PositionGrille2JX2,PositionGrille2JY2);
		modelGrille2.add(this);

		modelJoueur2 = new JoueurModel(2);
		controlerJoueur2 = new JoueurController(modelJoueur2,controlerGrille2);
		j2 = new Joueur(PositionGrille2JX2,PositionGrille2JY2,controlerJoueur2, g2.tailleX(), g2.tailleY(),2);
		modelJoueur2.add(this);

		g1.init();
		g2.init();
		
		this.addKeyListener(new MyKeyAdapter());

		creerlayout();
		
	}

	public void lancementAnimation(){
		animation(controlerGrille1, controlerJoueur1,g1,j1);
		animation(controlerGrille2, controlerJoueur2,g2,j2);
	}
	
	public void animation(GrilleControler controlerGrille,JoueurController controlerJoueur,Grille g,Joueur j) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				Joueur myj=j;
				GrilleControler controlGrille=controlerGrille;
				JoueurController controlJoueur=controlerJoueur;
				int taille = 0;
				int i=0;
				while (g.isAnimationHaut()) {
					try {
						controlJoueur.verifUp(myj.getY1());
						controlGrille.ajoutLigne();
						Thread.sleep(2500);
					} catch (InterruptedException e) {
					}
					
				}
			}
		});
		thread.start();
	}

	private void creerlayout() {
		this.setLayout(null);
		this.add(g1);
		this.add(g2);
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
	public void swaphorizontal(int x1, int x2, int y) {
		this.g1.swaphorizontal(x1, x2, y);
		this.repaint();
	}

	@Override
	public void swapvertical(int x, int y1, int y2) {
		this.g1.swapvertical(x, y1, y2);
		this.repaint();
	}

	@Override
	public void updateJoueur(int j,int x1, int x2, int y) {
		if(j==1){
			this.j1.setX1(x1);
			this.j1.setX2(x2);
			this.j1.setY1(y);
			repaint();
		}
		else{
			this.j2.setX1(x1);
			this.j2.setX2(x2);
			this.j2.setY1(y);
			repaint();
		}
	}

	@Override
	public void updateCase(int j,int y, int x, int val) {
		if(j==1)
			this.g1.updateCase(y, x, val);
		else
			this.g2.updateCase(y, x, val);
		repaint();
	}

}
