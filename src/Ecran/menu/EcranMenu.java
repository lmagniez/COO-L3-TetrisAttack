package Ecran.menu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import Constante.ConstanteDimension;
import Ecran.Animation;
import Ecran.Ecran;
import Ecran.GestionBouton;
import Run.Fenetre;

public class EcranMenu extends Ecran implements ActionListener {

	// Joueur joueur1 = new Joueur(this, 1);
	// Joueur joueur2 = new Joueur(this, 2);
	// JButton joueur1 = new Commande(this, "1 Player");

	protected PanelMenuPrincipal p1;
	protected PanelMenu1J p2;
	protected PanelMenu2J p3;
	protected PanelMenuControle p4;
	protected PanelMenuCredits p5;
	protected PanelMenuRegles p6;
	protected PanelMenu1JPerso p7;
	protected PanelMenu2JPerso p8;

	private Timer timer;

	private Image fond;
	private Image shadow;
	private Image buttonLabel, selectLabel;
	private int widthbutton = 349, heightbutton = 50;
	private int widthselect = 389, heightselect = 77;
	public static boolean cursor_actif = true;

	// yoshi
	private Animation yoshi;
	private Image yoshiImg;
	private int cptyoshi = 0, widthyoshi = 68, heightyoshi = 96, screenwidthyoshi = widthyoshi * 3,
			screenheightyoshi = heightyoshi * 3;
	private int posyoshiY = ConstanteDimension.DimensionFenetrey / 2 + screenheightyoshi / 2,
			posyoshiX = ConstanteDimension.DimensionFenetrex - screenwidthyoshi / 2;
	public static final int NB_IMAGE = 5;

	// curseur
	protected Image cursor;
	protected int widthcursor = 5, heightcursor = 7;
	protected int screenwidthcursor = widthcursor * 5, screenheightcursor = heightcursor * 5;

	public EcranMenu(Fenetre f) throws ParseException {
		this.vue = f;
		this.setLayout(null);

		p1 = new PanelMenuPrincipal(f, this);
		p2 = new PanelMenu1J(f, this);
		p3 = new PanelMenu2J(f, this);
		p4 = new PanelMenuControle(f, this);
		p5 = new PanelMenuCredits(f, this);
		p6 = new PanelMenuRegles(f, this);
		p7 = new PanelMenu1JPerso(f, this);
		p8 = new PanelMenu2JPerso(f, this);

		changeMenuBox(this, p1);

		// ANIMATIONS
		timer = new Timer(200, this);
		timer.start();
		fond = new ImageIcon("./ressources/Menu/menu.png").getImage();
		shadow = new ImageIcon("./ressources/Accueil/shadow.png").getImage();
		yoshiImg = new ImageIcon("./ressources/Accueil/YoshiMenu/spriteSheet.png").getImage();
		yoshi = new Animation(yoshiImg, posyoshiX, posyoshiY, widthyoshi, heightyoshi, screenwidthyoshi,
				screenheightyoshi, cptyoshi, NB_IMAGE, this);

		buttonLabel = new ImageIcon("./ressources/Menu/buttonlabel.png").getImage();
		selectLabel = new ImageIcon("./ressources/Menu/selectlabel.png").getImage();
		cursor = new ImageIcon("./ressources/Menu/cursor.png").getImage();
		animation();
	}

	public static void changeMenuBox(EcranMenu m, PanelMenu p) {

		p.setVisible(true);
		m.removeAll();
		m.repaint();
		m.add(p);
		m.validate();

		m.buttons = p.buttons;
		m.posButtonX = p.posButtonX;
		m.posButtonY = p.posButtonY;
		EcranMenu.cursor_actif = p.has_cursor;

		/*
		 * for(int i=0; i<p.buttons.length; i++) for(int j=0;
		 * j<p.buttons[0].length;j++) buttons[0][0].setForeground(Color.black);
		 * p.buttons[0][0].setForeground(Color.GREEN);
		 */
		if (m.buttons.length != 0) {
			p.buttons[0][0].requestFocus();
			GestionBouton.current_col = 0;
			GestionBouton.current_row = 0;
		} else {
			p.requestFocus();
		}
		GestionBouton.pred_panel = p.pred_panel;

	}

	/*
	 * private void creerLayout() { joueur1.setBounds(20, 100, 200, 50);
	 * joueur2.setBounds(20, 170, 200, 50); Option.setBounds(20, 240, 200, 50);
	 * HowToImprove.setBounds(20, 310, 300, 50); HowToPlay.setBounds(20, 370,
	 * 200, 50); }
	 */

	public Fenetre getFen() {
		return vue;
	}

	public void setFen(Fenetre fen) {
		this.vue = fen;
	}

	public void animation() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				boolean run = true;
				while (true) {
					try {
						if (cursor == null)
							cursor = new ImageIcon("./ressources/Menu/cursor.png").getImage();
						else {
							cursor = null;
						}
						EcranMenu.this.repaint();
						Thread.sleep(400);
					} catch (InterruptedException e) {
					}
				}
			}
		});
		thread.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(shadow, ConstanteDimension.DimensionFenetrex - screenwidthyoshi * 4 / 3,
				ConstanteDimension.DimensionFenetrey - screenheightyoshi * 3 / 4, 56 * 3, 72 * 3, this);
		yoshi.draw(g);
		g.drawImage(selectLabel, ConstanteDimension.DimensionFenetrex / 9, heightselect * 3 / 4, widthselect * 3 / 4,
				heightselect * 3 / 4, this);
		g.drawImage(buttonLabel, ConstanteDimension.DimensionFenetrex - widthbutton, heightbutton * 3 / 4, widthbutton,
				heightbutton, this);
		
		if (EcranMenu.cursor_actif) {
			g.drawImage(cursor, this.posButtonX[GestionBouton.current_row][GestionBouton.current_col]+20,
					this.posButtonY[GestionBouton.current_row][GestionBouton.current_col]+10, this.screenwidthcursor,
					this.screenheightcursor, this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == timer) {
			repaint();
			yoshi.updateCpt();
		}
	}

}