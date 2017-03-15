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
 * Ecran de victoire 2 joueurs
 * @author loick
 *
 */
public class WinJ2 extends Ecran implements ActionListener{

	
	private JButton yes = new JButton("yes");

	protected EcranMenu ecran;
	protected Image lose, win, press1, press2;
	protected Jeux2j panel2J;
	protected int idWinner;
	
	private int cptButton = 0;
	
	/**
	 * Constructeur
	 * @param vue fenetre
	 * @param panel2J vue 2 joueurs
	 */
	public WinJ2(Fenetre vue, Jeux2j panel2J) {
		this.panel2J=panel2J;
		this.vue = vue;
		this.setOpaque(false);
		
		NB_BUTTONS_Y = 1;
		NB_BUTTONS_X = 1;
		buttons = new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonX=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonY=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		
		buttons[0][0]=yes;
								
		
		for(int i=0; i<NB_BUTTONS_Y; i++){
			posButtonX[0][i]=300;
			posButtonY[0][i]=50*i;
		}
		
		this.lose = new ImageIcon("./ressources/Game/GameOver/lose.png").getImage();
		this.win = new ImageIcon("./ressources/Game/GameOver/win.png").getImage();
		this.press1 = new ImageIcon("./ressources/Game/GameOver/pushAnyKey.gif").getImage();
		this.press2 = new ImageIcon("./ressources/Game/GameOver/pushAnyKey.gif").getImage();
		
		
		this.setBounds(0,0,ConstanteDimension.DimensionFenetrex, ConstanteDimension.DimensionFenetrey);
		
		//this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setLayout(null);
		
		addListener();
		
		this.add(Box.createRigidArea(new Dimension(5,30)));
		this.add(yes);
		
		
		yes.setSize(new Dimension(1,40));
		yes.setPreferredSize(new Dimension(1,40));
		yes.setMaximumSize(new Dimension(1,40));
		yes.setBounds(0,350,1,1);
		yes.addActionListener(this);
		
		
		
		
	}
	
	/**
	 * Changer le gagnant
	 * @param idWinner id du gagnant
	 */
	public void setIdWinner(int idWinner){
		this.idWinner=idWinner;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(this.idWinner==1){		
			g.drawImage(lose, 30, 200, 96*3, 45*3, this);
			g.drawImage(win, 480, 200, 96*3, 45*3, this);
		}
		else{
			g.drawImage(win, 30, 200, 96*3, 45*3, this);
			g.drawImage(lose, 480, 200, 96*3, 45*3, this);
		}
			
		g.drawImage(press1, 80, 400, 82*2, 10*2, this);
		g.drawImage(press2, 550, 400, 82*2, 10*2, this);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("yes")) {
			
			if(panel2J.getNbWinJ1()>=2||panel2J.getNbWinJ2()>=2)
				this.focusNouvelEcran(vue.getM());
			
			this.panel2J.getControlerGrille1().reinitGrille2J();
			this.panel2J.getControlerGrille1().initGrille();
			this.panel2J.getControlerJoueur1().animation();
			this.panel2J.getControlerJoueur1().reprendreThread();
			
			this.panel2J.getControlerGrille2().reinitGrille2J();
			this.panel2J.getControlerGrille2().initGrille();
			this.panel2J.getControlerJoueur2().animation();
			this.panel2J.getControlerJoueur2().reprendreThread();
			
			
			this.panel2J.getControlerJeu().timer();
			//this.panel2J.getControlerJeu().reprendreThread();
			
			this.panel2J.getControlerJeu().start();
			
			this.panel2J.getControlerJeu().reprendreThread();
			
			
			this.panel2J.setPause(false);
			this.setVisible(false);
			this.panel2J.requestFocus();
			
			
		}
	}
	
	
}
