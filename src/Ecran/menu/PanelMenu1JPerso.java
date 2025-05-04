package Ecran.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToggleButton;

import Bouton.Commande;
import Bouton.JoueurIcon;
import Constante.ConstanteDimension;
import Constante.ConstanteParametres;
import Run.Fenetre;
import Run.Sound;


/**
 * CHOIX DES PERSOS J1
 * @author loick
 *
 */
public class PanelMenu1JPerso extends PanelMenu implements ActionListener {

	private JButton[] icon = new JoueurIcon[6];
	private int cptButton = 0;

	/**
	 * Constructeur
	 * @param vue fenetre
	 * @param e ecranMenu
	 */
	public PanelMenu1JPerso(Fenetre vue, EcranMenu e) {
		this.ecran=e;
		this.vue=vue;
		this.pred_panel=this.ecran.p2;
		
		this.has_cursor=false; 
		NB_BUTTONS_Y = 3;
		NB_BUTTONS_X = 2;
		buttons = new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];

		posButtonX=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonY=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		
		for(int i=0; i<NB_BUTTONS_X; i++){
			posButtonX[i][0]=ConstanteDimension.DimensionFenetrex*1/7;
			posButtonY[i][0]=180+50*i;
		}
		
		this.fond = new ImageIcon(getClass().getResource("/Ressource/Menu/menuframe.png")).getImage();
		this.setBounds(ConstanteDimension.DimensionFenetrex / 5, ConstanteDimension.DimensionFenetrey / 4, 300, 300);
		this.setLayout(null);
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.requestFocusInWindow();

		creationIcon();
		ajout();
	}

	/**
	 * Création des icones du joueur
	 */
	private void creationIcon() {
		for (int i = 0; i < 6; i++) {
			icon[i] = new JoueurIcon(this, i);
		}
	}
	
	/**
	 * Ajouter les éléments au panel
	 */
	private void ajout() {

		for (int i = 0; i < 3; i++) {
			buttons[cptButton][i] = icon[i];
		}
		
		cptButton++;
		
		for (int i = 0; i < 3; i++) {
			buttons[cptButton][i] = icon[i + 3];
		}
		
		for (int i = 0; i < 3; i++) {
			icon[i].setBounds((50 + 20)* i + 50, 90, 60, 60);
			this.add(icon[i]);
		}

		for (int i = 0; i < 3; i++) {
			icon[i+3].setBounds((50 + 20)* i + 50, 170, 60, 60);
			this.add(icon[i+3]);
		}

		ecran.setButtons(buttons);
		ecran.addListener();

	}

	/**
	 * ActionPerformed démarrant le jeu
	 */
	public void actionPerformed(ActionEvent e) {
		
		int indiceT = ((JoueurIcon) e.getSource()).getIconId();
		EcranMenu.getOption()[1]=indiceT;
		vue.afficheJeu1J(EcranMenu.getOption());

		Sound.stop();
		ConstanteParametres.ID_MUSIQUE=2;
		Sound.loop();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		g.setColor(Color.ORANGE);
		g.setFont(new Font("verdana",Font.BOLD,20));
		g.drawString("Selection Personnage", 30, 50);
		for (int i = 0; i < this.getComponentCount(); i++) {
			if (this.getComponent(i).hasFocus() && this.getComponent(i) instanceof JoueurIcon) {
				g.setColor(Color.white);
				g.fillRect(this.getComponent(i).getX()-5, this.getComponent(i).getY()-5, 70, 70);
			} 
		}
	}
}
