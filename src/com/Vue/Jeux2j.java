package com.Vue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.Controller.GrilleControler;
import com.Controller.JeuxControler;
import com.Controller.JoueurControler;
import com.Model.GrilleModel;
import com.Model.JoueurModel;
import com.Model.JeuxModel;
import com.Model.ValeurCase;
import com.Observer.Observer;

import Constante.ConstanteDimension;
import Constante.ConstanteGraphique;
import Constante.ConstanteImage;
import Constante.ConstanteJeux;
import Ecran.Animation;
import Gestion.Joueur;
import JComponent.GameTimer;
import JComponent.Grille;
import JComponent.Pause;
import JComponent.Score;
import JComponent.WinJ1;
import JComponent.WinJ2;
import Run.Fenetre;

/**
 * Classe abstraite représentant un jeu 2 joueurs (Joueur contre joueur, ou
 * Joueur contre IA)
 * 
 * @author loick
 *
 */
public abstract class Jeux2j extends JPanel
		implements ActionListener, ConstanteDimension, ConstanteJeux, ConstanteGraphique, Observer {

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
	protected JeuxModel modelJeux;

	protected boolean pause = false;

	protected int idJ1, idJ2;

	protected Score scoreJ1, lvlJ1;
	protected Score scoreJ2, lvlJ2;
	protected GameTimer timer;
	protected Pause pausePanel;
	protected int nbWinJ1, nbWinJ2;

	protected WinJ2 win;

	// fond
	protected Image fondYoshi = new ImageIcon("./ressources/Game/Fond2J/fond2.png").getImage();
	protected Image fondFrog = new ImageIcon("./ressources/Game/Fond2J/fond5.png").getImage();
	protected Image fondChien = new ImageIcon("./ressources/Game/Fond2J/fond1.png").getImage();
	protected Image fondLakitu = new ImageIcon("./ressources/Game/Fond2J/fond3.png").getImage();
	protected Image fondMaskass = new ImageIcon("./ressources/Game/Fond2J/fond6.png").getImage();
	protected Image fondMonstre = new ImageIcon("./ressources/Game/Fond2J/fond4.png").getImage();
	protected Image fond[] = { fondYoshi, fondLakitu, fondChien, fondMonstre, fondFrog, fondMaskass };

	protected Image star1 = new ImageIcon("./ressources/Game/Interface/blueStar.gif").getImage();
	protected Image star2 = new ImageIcon("./ressources/Game/Interface/blueStar.gif").getImage();
	protected Image star3 = new ImageIcon("./ressources/Game/Interface/redStart.gif").getImage();
	protected Image star4 = new ImageIcon("./ressources/Game/Interface/redStart.gif").getImage();

	// fond grille
	// fond
	protected Image yoshi = new ImageIcon("./ressources/Game/Fond2J/yoshi.png").getImage();
	protected Image frog = new ImageIcon("./ressources/Game/Fond2J/frog.png").getImage();
	protected Image chien = new ImageIcon("./ressources/Game/Fond2J/dog.png").getImage();
	protected Image lakitu = new ImageIcon("./ressources/Game/Fond2J/lakitu.png").getImage();
	protected Image maskass = new ImageIcon("./ressources/Game/Fond2J/penguin.png").getImage();
	protected Image monstre = new ImageIcon("./ressources/Game/Fond2J/monster.png").getImage();
	protected Image fondGrille[] = { yoshi, lakitu, chien, monstre, frog, maskass };

	// interface
	protected Image interf = new ImageIcon("./ressources/Game/Interface/interface.png").getImage();

	// ANIMATIONS
	private int posAnimJ1Y = (int) (ConstanteDimension.DimensionFenetrey) * 1 / 3,
			posAnimJ1X = ConstanteDimension.DimensionFenetrex / 2;
	private int posAnimJ2Y = (int) (ConstanteDimension.DimensionFenetrey) * 1 / 3,
			posAnimJ2X = ConstanteDimension.DimensionFenetrex / 2 + 50;
	private int cpt = 0;

	private Image yoshiImg = new ImageIcon("./ressources/Game/WalkingCharacters/yoshi.png").getImage();
	private int cptyoshi = 0, widthyoshi = 18, heightyoshi = 30, screenwidthyoshi = widthyoshi * 2,
			screenheightyoshi = heightyoshi * 2;
	private int yoshiCptImg = 3;
	private Animation yoshiAnim = new Animation(yoshiImg, posAnimJ1X, posAnimJ1Y, widthyoshi, heightyoshi,
			screenwidthyoshi, screenheightyoshi, cptyoshi, yoshiCptImg, this);
	private Animation yoshiAnim2 = new Animation(yoshiImg, posAnimJ2X, posAnimJ2Y, widthyoshi, heightyoshi,
			screenwidthyoshi, screenheightyoshi, cptyoshi, yoshiCptImg, this);

	private Image dogImg = new ImageIcon("./ressources/Game/WalkingCharacters/dog.png").getImage();
	private int cptdog = 0, widthdog = 25, heightdog = 30, screenwidthdog = widthdog * 2,
			screenheightdog = heightdog * 2;
	private int dogCptImg = 3;
	private Animation dogAnim = new Animation(dogImg, posAnimJ1X, posAnimJ1Y, widthdog, heightdog, screenwidthdog,
			screenheightdog, cptdog, dogCptImg, this);
	private Animation dogAnim2 = new Animation(dogImg, posAnimJ2X, posAnimJ2Y, widthdog, heightdog, screenwidthdog,
			screenheightdog, cptdog, dogCptImg, this);

	private Image frogImg = new ImageIcon("./ressources/Game/WalkingCharacters/frog.png").getImage();
	private int cptfrog = 0, widthfrog = 24, heightfrog = 23, screenwidthfrog = widthfrog * 2,
			screenheightfrog = heightfrog * 2;
	private int frogCptImg = 2;
	private Animation frogAnim = new Animation(frogImg, posAnimJ1X, posAnimJ1Y, widthfrog, heightfrog, screenwidthfrog,
			screenheightfrog, cptfrog, frogCptImg, this);
	private Animation frogAnim2 = new Animation(frogImg, posAnimJ2X, posAnimJ2Y, widthfrog, heightfrog, screenwidthfrog,
			screenheightfrog, cptfrog, frogCptImg, this);

	private Image lakituImg = new ImageIcon("./ressources/Game/WalkingCharacters/lakitu.png").getImage();
	private int cptlakitu = 0, widthlakitu = 18, heightlakitu = 33, screenwidthlakitu = widthlakitu * 2,
			screenheightlakitu = heightlakitu * 2;
	private int lakituCptImg = 3;
	private Animation lakituAnim = new Animation(lakituImg, posAnimJ1X, posAnimJ1Y, widthlakitu, heightlakitu,
			screenwidthlakitu, screenheightlakitu, cptlakitu, lakituCptImg, this);
	private Animation lakituAnim2 = new Animation(lakituImg, posAnimJ2X, posAnimJ2Y, widthlakitu, heightlakitu,
			screenwidthlakitu, screenheightlakitu, cptlakitu, lakituCptImg, this);

	private Image monsterImg = new ImageIcon("./ressources/Game/WalkingCharacters/monster.png").getImage();
	private int cptmonster = 0, widthmonster = 20, heightmonster = 27, screenwidthmonster = widthmonster * 2,
			screenheightmonster = heightmonster * 2;
	private int monsterCptImg = 3;
	private Animation monsterAnim = new Animation(monsterImg, posAnimJ1X, posAnimJ1Y, widthmonster, heightmonster,
			screenwidthmonster, screenheightmonster, cptmonster, monsterCptImg, this);
	private Animation monsterAnim2 = new Animation(monsterImg, posAnimJ2X, posAnimJ2Y, widthmonster, heightmonster,
			screenwidthmonster, screenheightmonster, cptmonster, monsterCptImg, this);

	private Image penguinImg = new ImageIcon("./ressources/Game/WalkingCharacters/penguin.png").getImage();
	private int cptpenguin = 0, widthpenguin = 18, heightpenguin = 23, screenwidthpenguin = widthpenguin * 2,
			screenheightpenguin = heightpenguin * 2;
	private int penguinCptImg = 2;
	private Animation penguinAnim = new Animation(penguinImg, posAnimJ1X, posAnimJ1Y, widthpenguin, heightpenguin,
			screenwidthpenguin, screenheightpenguin, cptpenguin, penguinCptImg, this);
	private Animation penguinAnim2 = new Animation(penguinImg, posAnimJ2X, posAnimJ2Y, widthpenguin, heightpenguin,
			screenwidthpenguin, screenheightpenguin, cptpenguin, penguinCptImg, this);

	protected Animation animations[] = { yoshiAnim, lakituAnim, dogAnim, monsterAnim, frogAnim, penguinAnim };
	protected Animation animations2[] = { yoshiAnim2, lakituAnim2, dogAnim2, monsterAnim2, frogAnim2, penguinAnim2 };

	private Timer timerAnim;

	/**
	 * Constructeur
	 * 
	 * @param f
	 *            fenetre
	 * @param option
	 *            options
	 * @param idJ1
	 *            id du joueur 1
	 * @param idJ2
	 *            id du joueur 2
	 */
	public Jeux2j(Fenetre f, int[] option, int idJ1, int idJ2) {
		// 0 -> vitesse J1
		// 1 -> idtheme j1
		// 2 -> vitesse J2
		// 3 -> idtheme j2
		// 4 -> IA -> 1 | 0

		fen = f;
		this.idJ1 = idJ1;
		this.idJ2 = idJ2;

		this.lvlJ1 = new Score(this, 378, 112, false, 2);
		this.lvlJ2 = new Score(this, 428, 112, true, 2);
		this.scoreJ1 = new Score(this, 385, 320, false, 4);
		this.scoreJ2 = new Score(this, 385, 405, true, 4);
		this.timer = new GameTimer(this, 380, 485);

		this.nbWinJ1 = 0;
		this.nbWinJ2 = 0;

		this.lvlJ1.setScore(option[0]);
		this.lvlJ2.setScore(option[2]);

		modelJeux = new JeuxModel(this);
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

		this.pausePanel = new Pause(this.fen, this);
		this.add(pausePanel);
		pausePanel.setVisible(false);

		this.win = new WinJ2(this.fen, this);
		this.add(win);
		win.setVisible(false);

		timerAnim = new Timer(100, this);
		timerAnim.start();

	}

	/**
	 * Timer de l'animation des 2 joueurs (petites icones)
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timerAnim) {
			// cptyoshi1 = (cptyoshi1 + 1) % NB_IMAGE;
			// yoshiAnim.updateCpt();

			cpt++;
			if (cpt == 10) {
				this.animations[this.idJ1].updateCpt();
				this.animations2[this.idJ2].updateCpt();
				cpt = 0;
			}
			repaint();

		}
	}

	public abstract void GestionClavier(KeyEvent e);

	/**
	 * Lancer l'animation des deux joueurs (grille + curseur) et du jeu (timer)
	 */
	public void lancementAnimation() {
		controlerJoueur1.animation();
		controlerJoueur2.animation();
		controlerJeu.timer();
		controlerJeu.start();
	}

	/**
	 * Initialiser le layout
	 */
	public void creerlayout() {
		this.setLayout(null);
		this.add(g1);
		this.add(g2);
	}

	/**
	 * Demander le focus
	 */
	public void focus() {
		this.setFocusable(true);
		this.requestFocus();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(fond[this.idJ1], 0, 0, getWidth(), getHeight(), this);
		g.drawImage(fondGrille[this.idJ1], ConstanteJeux.PositionGrille2JX1, ConstanteJeux.PositionGrille2JY1 + 30,
				ConstanteDimension.DimensionGrillex,
				ConstanteDimension.DimensionFenetrey - ConstanteJeux.PositionGrille2JY1 + 15, this);
		g.drawImage(ConstanteImage.filtre,ConstanteJeux.PositionGrille2JX1, ConstanteJeux.PositionGrille2JY1 + 30,
				ConstanteDimension.DimensionGrillex,
				ConstanteDimension.DimensionFenetrey - ConstanteJeux.PositionGrille2JY1 + 15, this);
		
		g.drawImage(fondGrille[this.idJ2], ConstanteJeux.PositionGrille2JX2, ConstanteJeux.PositionGrille2JY2 + 30,
				ConstanteDimension.DimensionGrillex,
				ConstanteDimension.DimensionFenetrey - ConstanteJeux.PositionGrille2JY1 + 15, this);
		g.drawImage(ConstanteImage.filtre, ConstanteJeux.PositionGrille2JX2, ConstanteJeux.PositionGrille2JY2 + 30,
				ConstanteDimension.DimensionGrillex,
				ConstanteDimension.DimensionFenetrey - ConstanteJeux.PositionGrille2JY1 + 15, this);

		(this.g1).paintComponent(g);
		(this.j1).dessinerJoueur(g, this);
		(this.g2).paintComponent(g);

		(this.j2).dessinerJoueur(g, this);
		g.drawImage(this.interf, ConstanteJeux.PositionGrille2JX1 - 5, ConstanteJeux.PositionGrille2JY1 + 30,
				ConstanteDimension.DimensionFenetrex - ConstanteJeux.PositionGrille2JX1 * 2 + 15,
				ConstanteDimension.DimensionFenetrey - ConstanteJeux.PositionGrille2JY1 - 30, this);

		(this.timer).draw(g);
		(this.scoreJ1).draw(g);
		(this.lvlJ1).draw(g);
		(this.scoreJ2).draw(g);
		(this.lvlJ2).draw(g);

		if (this.nbWinJ1 > 0)
			g.drawImage(this.star1, 347, 490, 16 * 3, 15 * 3, this);
		if (this.nbWinJ1 > 1)
			g.drawImage(this.star2, 347, 530, 16 * 3, 15 * 3, this);
		if (this.nbWinJ2 > 0)
			g.drawImage(this.star3, 410, 490, 16 * 3, 15 * 3, this);
		if (this.nbWinJ2 > 1)
			g.drawImage(this.star4, 410, 530, 16 * 3, 15 * 3, this);

		this.animations[this.idJ1].draw(g);
		this.animations2[this.idJ2].draw(g);

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
		if (id == 1) {
			this.j1.setScore(score);
			this.scoreJ1.setScore(score);
		} else {
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
		g1.monterGrille();
		g2.monterGrille();
		repaint();
	}

	/**
	 * Arrete les threads et indique le joueur gagnant
	 */
	public void arretThread(int id) {

		controlerJoueur1.reinit();
		controlerJoueur2.reinit();

		getControlerJeu().arreterThread();
		
		if (id == 2) {
			this.nbWinJ1++;
		}
		if (id == 1) {
			this.nbWinJ2++;
		}

		this.win.setIdWinner(id);
		this.win.setVisible(true);
		this.win.requestFocus();
		this.win.getButtons()[0][0].requestFocusInWindow();
		
		
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

	public GrilleControler getControlerGrille1() {
		return controlerGrille1;
	}

	public void setControlerGrille1(GrilleControler controlerGrille1) {
		this.controlerGrille1 = controlerGrille1;
	}

	public GrilleControler getControlerGrille2() {
		return controlerGrille2;
	}

	public void setControlerGrille2(GrilleControler controlerGrille2) {
		this.controlerGrille2 = controlerGrille2;
	}

	public int getNbWinJ1() {
		return nbWinJ1;
	}

	public void setNbWinJ1(int nbWinJ1) {
		this.nbWinJ1 = nbWinJ1;
	}

	public int getNbWinJ2() {
		return nbWinJ2;
	}

	public void setNbWinJ2(int nbWinJ2) {
		this.nbWinJ2 = nbWinJ2;
	}

	public void accelere() {
		controlerJoueur1.accelere();
		controlerJoueur2.accelere();
	}

}
