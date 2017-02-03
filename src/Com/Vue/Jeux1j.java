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
import Run.Fenetre;

public class Jeux1j extends JPanel implements ConstanteDimension, ConstanteJeux, ConstanteGraphique,Observer{

	private Fenetre fen;
	private Grille g;
	private Joueur j;
	
	private GrilleModel modelGrille;
	private GrilleControler controlerGrille;
	
	private JoueurModel modelJoueur;
	private JoueurController controlerJoueur;

	public Jeux1j(Fenetre f) {
		fen = f;
		
		modelGrille=new GrilleModel();
		controlerGrille=new GrilleControler(modelGrille);
		g = new Grille(controlerGrille);
		
		modelJoueur=new JoueurModel();
		controlerJoueur=new JoueurController(modelJoueur);
		j = new Joueur(controlerJoueur);
		modelJoueur.addObserverJeux(this);
		
		g.init();
	
		creerlayout();
	}

	private void creerlayout() {
		this.setLayout(null);
		g.setBounds(250, 100, DimensionGrillex, DimensionGrilley);
		this.add(g);
	}

	public void focus() {
		g.setFocusable(true);
		g.requestFocus();
	}

	public Grille getG() {
		return g;
	}
	
	public void paintComponent(Graphics g){
		(this.g).dessinerGrille(g);
		(this.j).dessinerJoueur(g,(this.g).tailleX(),(this.g).tailleY());
	}

	public Joueur getJ() {
		return j;
	}

	@Override
	public void swaphorizontal(int x1, int x2, int y) {
		this.g.swaphorizontal(x1, x2, y);
		this.repaint();
	}

	@Override
	public void swapvertical(int x, int y1, int y2) {
		this.g.swapvertical(x, y1, y2);
		this.repaint();
	}

	@Override
	public void updateJoueur(int x1, int x2, int y) {
		this.j.setX1(x1);
		this.j.setX2(x2);
		this.j.setY1(y);
		repaint();
	}

	@Override
	public void updateCase(int y, int x, int val) {
		this.g.updateCase(y,x,val);
	}
	
}
