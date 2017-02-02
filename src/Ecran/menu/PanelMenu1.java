package Ecran.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import Bouton.Commande;
import Constante.ConstanteDimension;
import Ecran.Ecran;
import Run.Fenetre;

public class PanelMenu1 extends PanelMenu implements ActionListener{
	
	protected JButton joueur1 = new Commande (this, "1 Player");
	protected JButton joueur2 = new Commande(this, "2 Players");
	protected JButton option = new Commande(this, "Option");
	protected JButton howToPlay = new Commande(this, "How To Play");
	protected JButton howToImprove = new Commande(this, "How To Improve");
	
	private int cptButton=0;
	
	public PanelMenu1(Fenetre vue, EcranMenu e)
	{
		NB_BUTTONS_Y=1;
		NB_BUTTONS_X=5;
		buttons=new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];
		
		this.ecran=e;
		this.fond=new ImageIcon("./ressources/Menu/menuframe.png").getImage();
		this.vue=vue;
		this.setBounds(ConstanteDimension.DimensionFenetrex/5, ConstanteDimension.DimensionFenetrey/4,
				300, 300);
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setMaximumSize(new Dimension(300,500));
		
		ajout();
		
		
		
	}
	
	private void ajout() {
		
		buttons[cptButton++][0]=joueur1;
		buttons[cptButton++][0]=joueur2;
		buttons[cptButton++][0]=option;
		buttons[cptButton++][0]=howToPlay;
		buttons[cptButton++][0]=howToImprove;
		
		
		this.add(Box.createRigidArea(new Dimension(10,30)));
		this.add(joueur1);
		this.add(Box.createRigidArea(new Dimension(10,20)));
		this.add(joueur2);
		this.add(Box.createRigidArea(new Dimension(10,20)));
		this.add(option);
		this.add(Box.createRigidArea(new Dimension(10,20)));
		this.add(howToPlay);
		this.add(Box.createRigidArea(new Dimension(10,20)));
		this.add(howToImprove);
		this.add(Box.createRigidArea(new Dimension(10,30)));
		
		
		
		System.out.println(this.joueur2.isRequestFocusEnabled());
		this.joueur2.setRequestFocusEnabled(true);
		
		System.out.println(this.joueur2.isFocusable());
		
		ecran.setButtons(buttons);
		ecran.addListener();
		
		
		
	}
	
	public void actionPerformed(ActionEvent e){
		
			if (e.getActionCommand().equals("Option")){
				vue.afficheControles();
			}
			if (e.getActionCommand().equals("How To Play")){
				vue.afficheHowToPlay();
			}
			if (e.getActionCommand().equals("1 Player")){
				//vue.afficheJeuxJ1();
				ecran.changeMenuBox(ecran.p2);
			}
			if (e.getActionCommand().equals("2 Players")){
				vue.afficheJeuxJ1();
			}
			if (e.getActionCommand().equals("How To Improve")){
				vue.afficheHowToImprove();
			}
		
	}
	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		
		//posyoshiY=ConstanteDimension.DimensionFenetrey/2+screenheightyoshi/2,
		//		posyoshiX=ConstanteDimension.DimensionFenetrex-screenwidthyoshi/2;
	   
		
	}
	

}
