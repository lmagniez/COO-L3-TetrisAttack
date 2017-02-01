package Ecran;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import Bouton.Commande;
import Bouton.Joueur;
import Constante.ConstanteDimension;
import Run.Fenetre;

public class EcranMenu extends Ecran implements ActionListener{

	
	//Joueur joueur1 = new Joueur(this, 1);
	//Joueur joueur2 = new Joueur(this, 2);
	//JButton joueur1 = new Commande(this, "1 Player");
	protected JButton joueur1 = new Commande (this, "1 Player");
	protected JButton joueur2 = new Commande(this, "2 Players");
	protected JButton option = new Commande(this, "Option");
	protected JButton howToPlay = new Commande(this, "How To Play");
	protected JButton howToImprove = new Commande(this, "How To Improve");

	protected JPanel p = new JPanel();
	
	public int boutonCourant = 0;
	private int cptButton=0;

	public EcranMenu(Fenetre f) {
		this.vue = f;
		this.setLayout(null);
		
		
		p.setBounds(ConstanteDimension.DimensionFenetrex/4, ConstanteDimension.DimensionFenetrey/4,
				300, 300);
		p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
		p.setBackground(new Color(90, 90, 90));
		p.setFocusable(true);
		p.requestFocusInWindow();
		p.setMaximumSize(new Dimension(300,500));
		
		
		
		NB_BUTTONS_Y=1;
		NB_BUTTONS_X=5;
		buttons=new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];
		
		//creerLayout();
		ajout();
		
		//this.joueur2.requestFocusInWindow();
		
		
		
	}
	
	private void ajout() {
		
		buttons[cptButton++][0]=joueur1;
		buttons[cptButton++][0]=joueur2;
		buttons[cptButton++][0]=option;
		buttons[cptButton++][0]=howToPlay;
		buttons[cptButton++][0]=howToImprove;
		
		this.addListener();
		p.add(Box.createRigidArea(new Dimension(10,30)));
		p.add(joueur1);
		p.add(Box.createRigidArea(new Dimension(10,20)));
		p.add(joueur2);
		p.add(Box.createRigidArea(new Dimension(10,20)));
		p.add(option);
		p.add(Box.createRigidArea(new Dimension(10,20)));
		p.add(howToPlay);
		p.add(Box.createRigidArea(new Dimension(10,20)));
		p.add(howToImprove);
		p.add(Box.createRigidArea(new Dimension(10,30)));
		
		this.add(p);
		
		System.out.println(this.joueur2.isRequestFocusEnabled());
		this.joueur2.setRequestFocusEnabled(true);
		
		System.out.println(this.joueur2.isFocusable());
		
	}

	/*
	private void creerLayout() {
		joueur1.setBounds(20, 100, 200, 50);
		joueur2.setBounds(20, 170, 200, 50);
		Option.setBounds(20, 240, 200, 50);
		HowToImprove.setBounds(20, 310, 300, 50);
		HowToPlay.setBounds(20, 370, 200, 50);
	}*/

	public Fenetre getFen() {
		return vue;
	}

	public void setFen(Fenetre fen) {
		this.vue = fen;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("Option")){
			vue.afficheControles();
		}
		if (e.getActionCommand().equals("How To Play")){
			vue.afficheHowToPlay();
		}
		if (e.getActionCommand().equals("1 Player")){
			vue.afficheJeuxJ1();
		}
		if (e.getActionCommand().equals("2 Players")){
			vue.afficheJeuxJ1();
		}
		if (e.getActionCommand().equals("How To Improve")){
			vue.afficheHowToImprove();
		}
		
	}

}