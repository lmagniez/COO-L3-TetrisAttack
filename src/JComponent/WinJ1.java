package JComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import com.Vue.Jeux1j;
import com.Vue.Jeux2j;

import Bouton.Commande;
import Bouton.SliderDifficulte;
import Constante.ConstanteDimension;
import Ecran.Ecran;
import Ecran.menu.EcranMenu;
import Run.Fenetre;

/**
 * Ecran de victoire 1 joueur
 * @author loick
 *
 */
public class WinJ1 extends Ecran implements ActionListener{

	
	private JButton yes = new JButton("yes");
	private JButton no = new JButton("no");
	protected EcranMenu ecran;
	protected Image gameOver, yesImg, noImg, cursor, tryAgain;
	protected Jeux1j panel1J;
	
	private int cptButton = 0;
	
	/**
	 * Constructeur 
	 * @param vue fenetre
	 * @param panel1J vue 1 joueur
	 */
	public WinJ1(Fenetre vue, Jeux1j panel1J) {
		this.panel1J=panel1J;
		this.vue = vue;
		this.setOpaque(false);
		
		NB_BUTTONS_Y = 2;
		NB_BUTTONS_X = 1;
		buttons = new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonX=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonY=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		
		buttons[0][0]=yes;
		buttons[0][1]=no;
								
		
		for(int i=0; i<NB_BUTTONS_Y; i++){
			posButtonX[0][i]=300;
			posButtonY[0][i]=50*i;
		}
		
		this.cursor = new ImageIcon(getClass().getResource("/Ressource/Game/Pause/cursor.png")).getImage();
		this.yesImg = new ImageIcon(getClass().getResource("/Ressource/Game/GameOver/yes.png")).getImage();
		this.noImg = new ImageIcon(getClass().getResource("/Ressource/Game/GameOver/no.png")).getImage();
		this.gameOver = new ImageIcon(getClass().getResource("/Ressource/Game/GameOver/gameOver.png")).getImage();
		this.tryAgain = new ImageIcon(getClass().getResource("/Ressource/Game/GameOver/tryAgain.png")).getImage();
		
		
		this.setBounds(ConstanteDimension.DimensionFenetrex / 2-165, 100, 400, 450);
		
		//this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setLayout(null);
		
		addListener();
		
		this.add(Box.createRigidArea(new Dimension(5,30)));
		this.add(yes);
		this.add(Box.createRigidArea(new Dimension(5,30)));
		this.add(no);
		
		
		yes.setSize(new Dimension(1,40));
		yes.setPreferredSize(new Dimension(1,40));
		yes.setMaximumSize(new Dimension(1,40));
		yes.setBounds(0,350,1,1);
		no.setSize(new Dimension(1,40));
		no.setPreferredSize(new Dimension(1,40));
		no.setMaximumSize(new Dimension(1,40));
		no.setBounds(200,350,1,1);
		
		yes.addActionListener(this);
		no.addActionListener(this);
		
		
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(gameOver, 0, 0, 368, 328, this);
		g.drawImage(yesImg, 50, 350, 115, 42, this);
		g.drawImage(noImg, 250, 350, 115, 42, this);
		g.drawImage(tryAgain, 0, 300, 314, 41, this);
		
		
		if(buttons[0][0].hasFocus()){
			Point p=buttons[0][0].getLocation();
			g.drawImage(cursor, p.x+20, p.y, 13*2, 19*2, this);
		}
		if(buttons[0][1].hasFocus()){
			Point p=buttons[0][1].getLocation();
			g.drawImage(cursor, p.x+20, p.y, 13*2, 19*2, this);
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getActionCommand().equals("yes")) {
			
			this.panel1J.getControlerGrille().reinitGrille1J();
			this.panel1J.getControlerGrille().initGrille();
			
			
			this.panel1J.getControlerJoueur().animation();
			//this.panel1J.getControlerJoueur().start();
			this.panel1J.getControlerJoueur().reprendreThread();
			//this.panel1J.getControlerJoueur().reprendre();
			
			//this.panel1J.getControlerJeu().pause();
			
			this.panel1J.getControlerJeu().timer();
			this.panel1J.getControlerJeu().start();
			
			this.panel1J.getControlerJeu().reprendreThread();
			//this.panel1J.getControlerJeu().reinit();
			
			
			//this.panel1J.getControlerJeu().reprendre();
			
			
			
			this.panel1J.setPause(false);
			this.setVisible(false);
			this.panel1J.requestFocus();
			
			
		}
		if (e.getActionCommand().equals("no")) {
				
				this.focusNouvelEcran(vue.getM());
				
		}
	}
	
	
}
