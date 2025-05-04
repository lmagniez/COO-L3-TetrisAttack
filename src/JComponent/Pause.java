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
 * Panel d'une pause
 * @author loick
 *
 */
public class Pause extends Ecran implements ActionListener{

	
	private JButton reprendre = new JButton("reprendre");
	private JButton quitter = new JButton("quitter");
	protected EcranMenu ecran;
	protected Image fond, cursor;
	protected Jeux1j panel1J;
	protected Jeux2j panel2J;
	protected boolean is1J;
	
	private int cptButton = 0;
	
	/**
	 * Pause pour une vue 1 joueur
	 * @param vue fenetre 
	 * @param panel1J vue 1 joueur
	 */
	public Pause(Fenetre vue, Jeux1j panel1J) {
		this(vue);
		this.panel1J=panel1J;
		this.is1J=true;
	}
	
	/**
	 * Pause pour une vue 2 joueurs
	 * @param vue fenetre 
	 * @param panel2J vue 2 joueurs
	 */
	public Pause(Fenetre vue, Jeux2j panel2J) {
		this(vue);
		
		this.panel2J=panel2J;
		this.is1J=false;
	}
	
	
	/**
	 * Constructeur
	 * @param vue fenetre
	 */
	public Pause(Fenetre vue){
		this.vue = vue;
		this.setOpaque(true);
		
		
		NB_BUTTONS_Y = 1;
		NB_BUTTONS_X = 2;
		buttons = new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonX=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonY=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		
		buttons[0][0]=reprendre;
		buttons[1][0]=quitter;
								
		
		for(int i=0; i<NB_BUTTONS_X; i++){
			posButtonX[i][0]=20;
			posButtonY[i][0]=20*i;
		}
		
		this.fond = new ImageIcon(getClass().getResource("/Ressource/Game/Pause/fenetre.png")).getImage();
		this.cursor = new ImageIcon(getClass().getResource("/Ressource/Game/Pause/cursor.png")).getImage();
		
		this.setBounds(ConstanteDimension.DimensionFenetrex / 2-165, ConstanteDimension.DimensionFenetrey / 2, 331, 100);
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		addListener();
		
		this.add(Box.createRigidArea(new Dimension(5,30)));
		this.add(reprendre);
		this.add(quitter);
		
		this.add(Box.createRigidArea(new Dimension(5,30)));
		reprendre.setSize(new Dimension(1,50));
		reprendre.setPreferredSize(new Dimension(1,50));
		reprendre.setMaximumSize(new Dimension(1,50));
		quitter.setSize(new Dimension(1,50));
		quitter.setPreferredSize(new Dimension(1,50));
		quitter.setMaximumSize(new Dimension(1,50));
		
		
		reprendre.addActionListener(this);
		quitter.addActionListener(this);
		
		
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		
		if(buttons[0][0].hasFocus()){
			Point p=buttons[0][0].getLocation();
			g.drawImage(cursor, p.x+20, p.y, 13, 19, this);
		}
		if(buttons[1][0].hasFocus()){
			Point p=buttons[1][0].getLocation();
			g.drawImage(cursor, p.x+20, p.y, 13, 19, this);
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("reprendre")) {
			if(is1J){
				this.panel1J.getControlerJoueur().reprendre();
				this.panel1J.getControlerJeu().reprendre();
				this.panel1J.setPause(false);
				this.setVisible(false);
				this.panel1J.requestFocus();
			}
			else{
				this.panel2J.getControlerJoueur1().reprendre();
				this.panel2J.getControlerJoueur2().reprendre();
				this.panel2J.getControlerJeu().reprendre();
				this.panel2J.setPause(false);
				this.setVisible(false);
				this.panel2J.requestFocus();
			}
			
		}
		if (e.getActionCommand().equals("quitter")) {
				
				this.focusNouvelEcran(vue.getM());
				
		}
	}
	
	
}
