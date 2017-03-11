package Ecran.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		this.fond = new ImageIcon("./ressources/Menu/menuframe.png").getImage();
		this.setBounds(ConstanteDimension.DimensionFenetrex / 5, ConstanteDimension.DimensionFenetrey / 4, 300, 300);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.requestFocusInWindow();

		creationIcon();
		ajout();
	}

	private void creationIcon() {
		for (int i = 0; i < 6; i++) {
			icon[i] = new JoueurIcon(this, i);
		}
	}

	private void ajout() {

		for (int i = 0; i < 3; i++) {
			buttons[cptButton][i] = icon[i];
		}
		
		cptButton++;
		
		for (int i = 0; i < 3; i++) {
			buttons[cptButton][i] = icon[i + 3];
		}

		this.add(Box.createRigidArea(new Dimension(0,60)));
		Box rowOne=Box.createHorizontalBox();
		for (int i = 0; i < 3; i++) {
			rowOne.add(icon[i]);
			rowOne.add(Box.createRigidArea(new Dimension(10,0)));
			this.add(rowOne);
		}
		
		this.add(Box.createRigidArea(new Dimension(10,20)));
		
		Box rowtwo=Box.createHorizontalBox();
		for (int i = 0; i < 3; i++) {
			rowtwo.add(icon[i+3]);
			rowtwo.add(Box.createRigidArea(new Dimension(10,0)));
			this.add(rowtwo);
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
		for(int i=0;i<buttons.length;i++){
			for(int a=0;a<buttons[0].length;a++){
				if(buttons[i][a].hasFocus()){
					buttons[i][a].setBorder(BorderFactory.createLineBorder(Color.blue,5));
				}
				else{
					buttons[i][a].setBorder(null);
				}
			}
		}
		// posyoshiY=ConstanteDimension.DimensionFenetrey/2+screenheightyoshi/2,
		// posyoshiX=ConstanteDimension.DimensionFenetrex-screenwidthyoshi/2;

	}
}
