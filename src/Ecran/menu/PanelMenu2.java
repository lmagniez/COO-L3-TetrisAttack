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
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Bouton.Commande;
import Constante.ConstanteDimension;
import Ecran.Ecran;
import Run.Fenetre;
import Variable.VariableJeu;

public class PanelMenu2 extends PanelMenu implements ActionListener{
	
	/*
	protected JButton joueur1 = new Commande (this, "11 Player");
	protected JButton joueur2 = new Commande(this, "22 Players");
	protected JButton option = new Commande(this, "Option");
	protected JButton howToPlay = new Commande(this, "How To Play");
	*/
	
	private JLabel labelTaille;
	private JLabel labelBox;
	private JComboBox perso;
	private JSlider sliderLevel;
	private JButton retour;
	
	
	private int cptButton=0;
	
	public PanelMenu2(Fenetre vue, EcranMenu e)
	{
		NB_BUTTONS_Y=1;
		NB_BUTTONS_X=4;
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
		
		
		
		labelBox = new JLabel();
		perso = new JComboBox();
		
		initSlide();

		
		
		ajout();
	}

	public void initSlide() {
		
		sliderLevel = new JSlider();
		labelTaille = new JLabel("Difficulte = ");
		retour=new JButton("Retour");
		
		perso.setPreferredSize(new Dimension(100, 20));
		perso.addItem("Yoshi vert");
		perso.addItem("Yoshi rose");

		sliderLevel.setMaximum(4);
		sliderLevel.setMinimum(1);

		sliderLevel.setPaintTicks(true);
		sliderLevel.setPaintLabels(true);
		sliderLevel.setMajorTickSpacing(1);

		sliderLevel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				labelTaille.setText("Difficulte = " + ((JSlider) event.getSource()).getValue());
				VariableJeu.level = ((int) ((JSlider) event.getSource()).getValue());
			}
		});

		sliderLevel.setBounds(300, 150, 200, 60);
		labelTaille.setBounds(300, 215, 100, 90);
		perso.setBounds(350, 350, 100, 20);

	}
	
	private void ajout() {
		
		buttons[cptButton++][0]=sliderLevel;
		buttons[cptButton++][0]=labelTaille;
		buttons[cptButton++][0]=perso;
		buttons[cptButton++][0]=retour;
		
		this.add(Box.createRigidArea(new Dimension(10,30)));
		this.add(sliderLevel);
		this.add(Box.createRigidArea(new Dimension(10,20)));
		this.add(labelTaille);
		this.add(Box.createRigidArea(new Dimension(10,20)));
		this.add(perso);
		this.add(Box.createRigidArea(new Dimension(10,20)));
		this.add(retour);
		
		/*
		System.out.println(this.joueur2.isRequestFocusEnabled());
		this.joueur2.setRequestFocusEnabled(true);
		
		System.out.println(this.joueur2.isFocusable());
		*/
		
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
			if (e.getActionCommand().equals("11 Player")){
				vue.afficheJeuxJ1();
			}
			if (e.getActionCommand().equals("22 Players")){
				System.out.println("okay!!");
				vue.afficheJeuxJ1();
			}
		
	}
	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		
		//posyoshiY=ConstanteDimension.DimensionFenetrey/2+screenheightyoshi/2,
		//		posyoshiX=ConstanteDimension.DimensionFenetrex-screenwidthyoshi/2;
	   
		
	}
	

}
