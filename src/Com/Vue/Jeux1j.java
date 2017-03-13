package Com.Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Com.Controller.GrilleControler;
import Com.Controller.JeuxControler;
import Com.Controller.JoueurControler;
import Com.Model.GrilleModel;
import Com.Model.JoueurModel;
import Com.Model.ModelJeux;
import Com.Model.ValeurCase;
import Com.Observer.Observer;
import Constante.ConstanteDimension;
import Constante.ConstanteGraphique;
import Constante.ConstanteJeux;
import Ecran.menu.EcranMenu;
import Gestion.Joueur;
import JComponent.GameTimer;
import JComponent.Grille;
import JComponent.Score;
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
	private JoueurControler controlerJoueur;
	
	protected GameTimer timer;
	protected Score highScore;
	protected Score score;
	protected Score speedLvl;
	
	
	
	
	protected boolean deplacementJoueur = true;
	private boolean pause=false;
	
	//fond
	protected Image yoshi= new ImageIcon("./ressources/Game/Fond1J/fondYoshi.png").getImage();
	protected Image frog= new ImageIcon("./ressources/Game/Fond1J/fondFrog.png").getImage();
	protected Image chien= new ImageIcon("./ressources/Game/Fond1J/fondChien.png").getImage();
	protected Image lakitu= new ImageIcon("./ressources/Game/Fond1J/fondLakitu.png").getImage();
	protected Image maskass= new ImageIcon("./ressources/Game/Fond1J/fondMaskass.png").getImage();
	protected Image monstre= new ImageIcon("./ressources/Game/Fond1J/fondMonstre.png").getImage();
	protected Image fond[] = {yoshi,lakitu,chien,monstre,frog,maskass};
	
	protected Image yoshiFond= new ImageIcon("./ressources/Game/Fond1J/yoshi.png").getImage();
	protected Image frogFond= new ImageIcon("./ressources/Game/Fond1J/frog.png").getImage();
	protected Image chienFond= new ImageIcon("./ressources/Game/Fond1J/chien.png").getImage();
	protected Image lakituFond= new ImageIcon("./ressources/Game/Fond1J/lakitu.png").getImage();
	protected Image maskassFond= new ImageIcon("./ressources/Game/Fond1J/maskass.png").getImage();
	protected Image monstreFond= new ImageIcon("./ressources/Game/Fond1J/monstre.png").getImage();
	protected Image fond2[] = {yoshiFond,lakituFond,chienFond,monstreFond,frogFond,maskassFond};
	
	
	
	//Time
	protected Image time= new ImageIcon("./ressources/Game/Texte/time.png").getImage();
	protected int timeX=50, timeY=60, widthTime=116, heightTime=22;
	
	protected Image hiScoreTxt= new ImageIcon("./ressources/Game/Texte/hiScore.png").getImage();
	protected int hiScoreTxtX=600, hiScoreTxtY=100, widthHiScoreTxt=147, heightHiScoreTxt=22;
	protected Image scoreTxt= new ImageIcon("./ressources/Game/Texte/score.png").getImage();
	protected int scoreTxtX=600, scoreTxtY=200, widthScoreTxt=140, heightScoreTxt=22;
	protected Image speedLvlTxt= new ImageIcon("./ressources/Game/Texte/speedLvl.png").getImage();
	protected int speedLvlTxtX=600, speedLvlTxtY=300, widthSpeedLvlTxt=170, heightSpeedLvlTxt=25;
	
	
	
	public Jeux1j(Fenetre f, int[] option) {
		fen = f;
		
		modelJeux = new ModelJeux(this);
		controlerJeu=new JeuxControler(modelJeux);
		
		modelGrille = new GrilleModel(1);
		controlerGrille = new GrilleControler(modelGrille);
		g = new Grille(this, controlerGrille, PositionGrille1JX, PositionGrille1JY);
		modelGrille.add(this);
	
		
		modelJoueur = new JoueurModel(1);
		controlerJoueur = new JoueurControler(modelJoueur, controlerGrille,option[0]);
		j = new Joueur(PositionGrille1JX, PositionGrille1JY, controlerJoueur, g.tailleX(), g.tailleY(), 1);
		modelJoueur.add(this);

		modelGrille.setControlerJoueur(controlerJoueur);
		

		
		g.init();

		creerlayout();
		
		this.setOpaque(true);
		this.setBackground(Color.black);
		
		this.timer=new GameTimer(this,70,120);
		this.highScore=new Score(this,650,150,true,6);
		this.score=new Score(this,650,250,false,6);
		this.speedLvl=new Score(this,650,350,false,2);
		
		
		highScore.setScore(20000);
		//score.setScore(1234);
		speedLvl.setScore(12);
		
		
		
		
		
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
				controlerJoueur.verifRight(j.getX1());
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

		
		
		
		
		g.drawImage(fond[EcranMenu.getOption()[1]], this.g.getPosGx(), this.g.getPosGy()-5, this.g.getTaillenx()*nombredecase,this.g.getTailleny()*(nombredeLigne-2)+50, this);
		(this.g).paintComponent(g);
		g.drawImage(fond2[EcranMenu.getOption()[1]], 0, 0, getWidth(), getHeight(), this);
		
		
		
		(this.j).dessinerJoueur(g);
		
		g.drawImage(this.time, this.timeX, this.timeY, this.widthTime, this.heightTime, this);
		g.drawImage(this.scoreTxt, this.scoreTxtX, this.scoreTxtY, this.widthScoreTxt, this.heightScoreTxt, this);
		g.drawImage(this.hiScoreTxt, this.hiScoreTxtX, this.hiScoreTxtY, this.widthHiScoreTxt, this.heightHiScoreTxt, this);
		g.drawImage(this.speedLvlTxt, this.speedLvlTxtX, this.speedLvlTxtY, this.widthSpeedLvlTxt, this.heightSpeedLvlTxt, this);
		
		
		(this.timer).draw(g);
		(this.score).draw(g);
		(this.highScore).draw(g);
		(this.speedLvl).draw(g);
		
		
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
		System.out.println("score");
		this.j.setScore(score);
		this.score.setScore(score);
	}

	@Override
	public void updateTimer(String minute, String seconde) {
		//System.out.println("Temps: "+ minute+" : "+seconde);
		timer.setTime(minute, seconde);
	}

	@Override
	public void bougeJoueurGraphique(int id) {
		j.setyGrille(j.getyGrille()-1);
		repaint();
		
	}

	@Override
	public void bougerGrilleGraphique(int id) {
		g.monterGrille();
		repaint();
	}

	@Override
	public void stopCase(int id, int y, int x) {
		this.g.getTab()[x][y].getAnimBloc().stopperAnimation(5);
	}

	@Override
	public void startCase(int id, int y, int x) {
		this.g.getTab()[x][y].getAnimBloc().reprendreAnimation();
		
	}
	
	public void reinitgrilleAnimation(int id) {
		j.reinitgrilleEmplacement();
		g.reinitgrilleAnimation();
		repaint();
	}

	@Override
	public void bougeJoueurGraphique() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bougerGrilleGraphique() {
		// TODO Auto-generated method stub
		g.monterGrille();
		repaint();
	}
}
