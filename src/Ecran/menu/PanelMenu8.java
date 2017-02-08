package Ecran.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToggleButton;

import Bouton.Commande;
import Bouton.JoueurIcon;
import Constante.ConstanteDimension;
import Run.Fenetre;

public class PanelMenu8 extends PanelMenu implements ActionListener {

	private JButton[] icon1 = new JoueurIcon[6];
	private JButton[] icon2 = new JoueurIcon[6];
	
	private int cptButton = 0;

	public PanelMenu8(Fenetre vue, EcranMenu e) {
		NB_BUTTONS_Y = 3;
		NB_BUTTONS_X = 4;
		buttons = new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];

		this.ecran = e;
		this.fond = new ImageIcon("./ressources/Menu/menuframe.png").getImage();
		this.vue = vue;
		this.setBounds(ConstanteDimension.DimensionFenetrex / 5, ConstanteDimension.DimensionFenetrey / 4, 300, 400);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.requestFocusInWindow();

		creationIcon();
		ajout();
	}

	private void creationIcon() {
		for (int i = 0; i < 6; i++) {
			icon1[i] = new JoueurIcon(this, i);
			icon2[i] = new JoueurIcon(this, i);
		}
	}

	private void ajout() {

		for (int i = 0; i < 3; i++) {
			buttons[cptButton][i] = icon1[i];
		}
		
		cptButton++;
		for (int i = 0; i < 3; i++) {
			buttons[cptButton][i] = icon1[i + 3];
		}
		
		cptButton++;
		for (int i = 0; i < 3; i++) {
			buttons[cptButton][i] = icon2[i];
		}
		
		cptButton++;
		for (int i = 0; i < 3; i++) {
			buttons[cptButton][i] = icon2[i + 3];
		}

		//Joueur1
		this.add(Box.createRigidArea(new Dimension(0,50)));
		Box rowOne=Box.createHorizontalBox();
		for (int i = 0; i < 3; i++) {
			rowOne.add(icon1[i]);
			rowOne.add(Box.createRigidArea(new Dimension(10,0)));
			this.add(rowOne);
		}
		
		this.add(Box.createRigidArea(new Dimension(10,10)));
		
		Box rowtwo=Box.createHorizontalBox();
		for (int i = 0; i < 3; i++) {
			rowtwo.add(icon1[i+3]);
			rowtwo.add(Box.createRigidArea(new Dimension(10,0)));
			this.add(rowtwo);
		}
		
		//Joueur 2
		this.add(Box.createRigidArea(new Dimension(0,40)));
		
		Box rowOnebis=Box.createHorizontalBox();
		for (int i = 0; i < 3; i++) {
			rowOnebis.add(icon2[i]);
			rowOnebis.add(Box.createRigidArea(new Dimension(10,0)));
			this.add(rowOnebis);
		}
		
		this.add(Box.createRigidArea(new Dimension(10,20)));
		
		Box rowtwobis=Box.createHorizontalBox();
		for (int i = 0; i < 3; i++) {
			rowtwobis.add(icon2[i+3]);
			rowtwobis.add(Box.createRigidArea(new Dimension(10,0)));
			this.add(rowtwobis);
		}
		
		ecran.setButtons(buttons);
		ecran.addListener();

	}

	public void actionPerformed(ActionEvent e) {

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		g.setColor(Color.white);
		g.setFont(new Font("Verdana",Font.BOLD,20));
		g.drawString("Joueur1",20,45);
		g.drawString("Joueur2",20,220);
		// posyoshiY=ConstanteDimension.DimensionFenetrey/2+screenheightyoshi/2,
		// posyoshiX=ConstanteDimension.DimensionFenetrex-screenwidthyoshi/2;

	}
}
