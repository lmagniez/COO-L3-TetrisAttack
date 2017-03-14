package com.Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.Controller.GrilleControler;
import com.Controller.JeuxControler;
import com.Controller.JoueurControler;
import com.Model.GrilleModel;
import com.Model.JoueurModel;
import com.Model.ModelJeux;
import com.Model.ValeurCase;
import com.Observer.Observer;
import Constante.ConstanteDimension;
import Constante.ConstanteGraphique;
import Constante.ConstanteJeux;
import Ecran.menu.EcranMenu;
import Gestion.Joueur;
import JComponent.GameTimer;
import JComponent.Grille;
import JComponent.Pause;
import JComponent.Score;
import Run.Fenetre;

public abstract class Jeux2j extends JPanel implements ConstanteDimension, ConstanteJeux, ConstanteGraphique, Observer {

	protected Fenetre fen;
	protected Grille g1;
	protected Grille g2;

	protected Joueur j1;
	protected Joueur j2;
	

	protected GrilleModel modelGrille1;
	protected GrilleControler controlerGrille1;

	protected JoueurModel modelJoueur1;
	protected JoueurControler controlerJoueur1;

	protected GrilleModel modelGrille2;
	protected GrilleControler controlerGrille2;

	protected JoueurModel modelJoueur2;
	protected JoueurControler controlerJoueur2;
	
	protected JeuxControler controlerJeu;
	protected ModelJeux modelJeux;

	protected boolean pause = false;

	protected int idJ1, idJ2;

	protected Score scoreJ1,lvlJ1;
	protected Score scoreJ2,lvlJ2;
	protected GameTimer timer;
	protected Pause pausePanel; 
	
	//fond
	protected Image fondYoshi= new ImageIcon("./ressources/Game/Fond2J/fond2.png").getImage();
	protected Image fondFrog= new ImageIcon("./ressources/Game/Fond2J/fond5.png").getImage();
	protected Image fondChien= new ImageIcon("./ressources/Game/Fond2J/fond1.png").getImage();
	protected Image fondLakitu= new ImageIcon("./ressources/Game/Fond2J/fond3.png").getImage();
	protected Image fondMaskass= new ImageIcon("./ressources/Game/Fond2J/fond6.png").getImage();
	protected Image fondMonstre= new ImageIcon("./ressources/Game/Fond2J/fond4.png").getImage();
	protected Image fond[] = {fondYoshi,fondLakitu,fondChien,fondMonstre,fondFrog,fondMaskass};
	
	//fond grille
	//fond
	protected Image yoshi= new ImageIcon("./ressources/Game/Fond2J/yoshi.png").getImage();
	protected Image frog= new ImageIcon("./ressources/Game/Fond2J/frog.png").getImage();
	protected Image chien= new ImageIcon("./ressources/Game/Fond2J/dog.png").getImage();
	protected Image lakitu= new ImageIcon("./ressources/Game/Fond2J/lakitu.png").getImage();
	protected Image maskass= new ImageIcon("./ressources/Game/Fond2J/penguin.png").getImage();
	protected Image monstre= new ImageIcon("./ressources/Game/Fond2J/monster.png").getImage();
	protected Image fondGrille[] = {yoshi,lakitu,chien,monstre,frog,maskass};
	
	//interface
	protected Image interf= new ImageIcon("./ressources/Game/Interface/interface.png").getImage();
	
	public Jeux2j(Fenetre f, int[] option, int idJ1, int idJ2) { 
		// 0 -> vitesse J1 
		// 1 -> idtheme j1 
		// 2 -> vitesse J2 
		// 3 -> idtheme j2 
		// 4 -> IA -> 1 | 0
		
		fen = f;
		this.idJ1 = idJ1;
		this.idJ2 = idJ2;
		
		this.lvlJ1=new Score(this,385,125,false,2);
		this.lvlJ2=new Score(this,435,125,true,2);
		this.scoreJ1=new Score(this,385,320,false,4);
		this.scoreJ2=new Score(this,385,405,true,4);
		this.timer=new GameTimer(this,380,485);
		
		this.pausePanel=new Pause(this.fen, this);
		
		this.add(pausePanel);
		pausePanel.setVisible(false);
		
		this.lvlJ1.setScore(option[0]);
		this.lvlJ2.setScore(option[2]);
		
		modelJeux = new ModelJeux(this);
		controlerJeu = new JeuxControler(modelJeux);
		

		modelGrille1 = new GrilleModel(1);
		controlerGrille1 = new GrilleControler(modelGrille1);
		g1 = new Grille(this, controlerGrille1, PositionGrille2JX1, PositionGrille2JY1);
		modelGrille1.add(this);

		modelJoueur1 = new JoueurModel(1);
		controlerJoueur1 = new JoueurControler(modelJoueur1, controlerGrille1, option[0]);
		j1 = new Joueur(PositionGrille2JX1, PositionGrille2JY1, controlerJoueur1, g1.tailleX(), g1.tailleY(), 1);
		modelJoueur1.add(this);

		modelGrille2 = new GrilleModel(2);
		controlerGrille2 = new GrilleControler(modelGrille2);
		g2 = new Grille(this, controlerGrille2, PositionGrille2JX2, PositionGrille2JY2);
		modelGrille2.add(this);

		modelJoueur2 = new JoueurModel(2);
		controlerJoueur2 = new JoueurControler(modelJoueur2, controlerGrille2, option[2]);
		j2 = new Joueur(PositionGrille2JX2, PositionGrille2JY2, controlerJoueur2, g2.tailleX(), g2.tailleY(), 2);
		modelJoueur2.add(this);

		modelGrille1.setControlerJoueur(controlerJoueur1);
		modelGrille2.setControlerJoueur(controlerJoueur2);
		
		g1.init();
		g2.init();
		creerlayout();
			
	}

	public abstract void GestionClavier(KeyEvent e);

	public void lancementAnimation() {
		controlerJoueur1.animation();
		controlerJoueur2.animation();
		controlerJeu.timer();
	}
	

	public void creerlayout() {
		this.setLayout(null);
		this.add(g1);
		this.add(g2);
	}

	public void focus() {
		this.setFocusable(true);
		this.requestFocus();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(fond[this.idJ1], 0, 0, getWidth(), getHeight(), this);
		
		g.drawImage(fondGrille[this.idJ1], ConstanteJeux.PositionGrille2JX1, ConstanteJeux.PositionGrille2JY1+30, 
				ConstanteDimension.DimensionGrillex, 
				ConstanteDimension.DimensionFenetrey-ConstanteJeux.PositionGrille2JY1+15, this);
		g.drawImage(fondGrille[this.idJ2], ConstanteJeux.PositionGrille2JX2, ConstanteJeux.PositionGrille2JY2+30, 
				ConstanteDimension.DimensionGrillex, 
				ConstanteDimension.DimensionFenetrey-ConstanteJeux.PositionGrille2JY1+15, this);

		(this.g1).paintComponent(g);
		(this.j1).dessinerJoueur(g,this);
		(this.g2).paintComponent(g);
		(this.j2).dessinerJoueur(g,this);
		g.drawImage(this.interf, ConstanteJeux.PositionGrille2JX1-5, ConstanteJeux.PositionGrille2JY1+30, 
				ConstanteDimension.DimensionFenetrex-ConstanteJeux.PositionGrille2JX1*2+15,
				ConstanteDimension.DimensionFenetrey-ConstanteJeux.PositionGrille2JY1-30, this);
		(this.timer).draw(g);
		(this.scoreJ1).draw(g);
		(this.lvlJ1).draw(g);
		(this.scoreJ2).draw(g);
		(this.lvlJ2).draw(g);
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
		if (id == 1){
			this.j1.setScore(score);
			this.scoreJ1.setScore(score);
		}
		else{
			this.j2.setScore(score);
			this.scoreJ2.setScore(score);
		}
		repaint();
	}

	@Override
	public void updateTimer(String minute, String seconde) {
		// System.out.println("Temps: "+ minute+" : "+seconde);
		timer.setTime(minute, seconde);
	}

	@Override
	public void bougeJoueurGraphique(int id) {
		if (id == 1)
			this.j1.setyGrille(j1.getyGrille() - 1);
		else
			this.j2.setyGrille(j2.getyGrille() - 1);
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
		if (id == 1) {
			j1.reinitgrilleEmplacement();
			g1.reinitgrilleAnimation();
		} else {
			j2.reinitgrilleEmplacement();
			g2.reinitgrilleAnimation();
		}

	}

	@Override
	public void stopCase(int id, int y, int x) {
		if (id == 1)
			this.g1.getTab()[x][y].getAnimBloc().stopperAnimation(5);
		else
			this.g2.getTab()[x][y].getAnimBloc().stopperAnimation(5);

	}

	@Override
	public void startCase(int id, int y, int x) {
		if (id == 1)
			this.g1.getTab()[x][y].getAnimBloc().reprendreAnimation();
		else
			this.g2.getTab()[x][y].getAnimBloc().reprendreAnimation();

	}

	@Override
	public void bougeJoueurGraphique() {
		
	}

	@Override
	public void bougerGrilleGraphique() {
		// TODO Auto-generated method stub
		g1.monterGrille();
		g2.monterGrille();
		repaint();
	}

	/**
	 * Arrete les threads et indique le joueur gagnant
	 */
	public void arretThread(int id) {
		controlerJeu.arreterThread();
		controlerJoueur1.arreterThread();
		controlerJoueur2.arreterThread();
	}

	public JoueurControler getControlerJoueur1() {
		return controlerJoueur1;
	}

	public void setControlerJoueur1(JoueurControler controlerJoueur1) {
		this.controlerJoueur1 = controlerJoueur1;
	}

	public JoueurControler getControlerJoueur2() {
		return controlerJoueur2;
	}

	public void setControlerJoueur2(JoueurControler controlerJoueur2) {
		this.controlerJoueur2 = controlerJoueur2;
	}

	public JeuxControler getControlerJeu() {
		return controlerJeu;
	}

	public void setControlerJeu(JeuxControler controlerJeu) {
		this.controlerJeu = controlerJeu;
	}
	
	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}
	
	
	

}
