package Ecran.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
import Bouton.SliderDifficulte;
import Constante.ConstanteDimension;
import Ecran.Ecran;
import Run.Fenetre;
import Variable.VariableJeu;

public class PanelMenu3 extends PanelMenu implements ActionListener, ChangeListener, ItemListener {
	
	/*
	protected JButton joueur1 = new Commande (this, "11 Player");
	protected JButton joueur2 = new Commande(this, "22 Players");
	protected JButton option = new Commande(this, "Option");
	protected JButton howToPlay = new Commande(this, "How To Play");
	*/
	
	private JLabel labelBox,labelBox2;
	private SliderDifficulte sliderLevel1= new SliderDifficulte(this,0);
	private SliderDifficulte sliderLevel2 = new SliderDifficulte(this,1);
	private JButton retour=new Commande(this,"Retour",1);
	private JButton start=new Commande(this,"Démarrer",6);
	
	
	private int cptButton=0;
	
	public PanelMenu3(Fenetre vue, EcranMenu e)
	{
		NB_BUTTONS_Y=1;
		NB_BUTTONS_X=4;
		buttons=new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];
		
		this.ecran=e;
		this.fond=new ImageIcon("./ressources/Menu/menuframe.png").getImage();
		this.vue=vue;
		this.setBounds(ConstanteDimension.DimensionFenetrex/5, ConstanteDimension.DimensionFenetrey/4,
				500, 400);
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setMaximumSize(new Dimension(300,300));
		
		
		
		labelBox = new JLabel();
		labelBox2= new JLabel();


		ajout();
	}


	public void ajout() {
		
		buttons[cptButton++][0]=sliderLevel1;
	
		buttons[cptButton++][0]=sliderLevel2;

		buttons[cptButton++][0]=retour;
		buttons[cptButton++][0]=start;
		
		
		this.add(Box.createRigidArea(new Dimension(10,30)));
		this.add(sliderLevel1);
		this.add(Box.createRigidArea(new Dimension(10,20)));

		this.add(Box.createRigidArea(new Dimension(10,30)));
		this.add(sliderLevel2);
		this.add(Box.createRigidArea(new Dimension(10,20)));

		this.add(Box.createRigidArea(new Dimension(10,80)));
		this.add(retour);
		this.add(Box.createRigidArea(new Dimension(10,20)));
		this.add(start);
		
		
		/*
		System.out.println(this.joueur2.isRequestFocusEnabled());
		this.joueur2.setRequestFocusEnabled(true);
		
		System.out.println(this.joueur2.isFocusable());
		*/
		
		ecran.setButtons(buttons);
		ecran.addListener();
		
		
		
	}
	
	public void actionPerformed(ActionEvent e){
		
			if (e.getActionCommand().equals("Retour")){
				ecran.changeMenuBox(ecran.p1);
			}
			if (e.getActionCommand().equals("Démarrer")){
				ecran.changeMenuBox(ecran.p8);
			}
		
	}
	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		g.setFont(new Font("Verdana",Font.BOLD,20));
		g.drawString("Difficulte", 60, 90);
		g.drawString("Difficulte", 60, 190);
		//posyoshiY=ConstanteDimension.DimensionFenetrey/2+screenheightyoshi/2,
		//		posyoshiX=ConstanteDimension.DimensionFenetrex-screenwidthyoshi/2;
	   
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() instanceof SliderDifficulte){
			System.out.println(sliderLevel1.getValue());
			System.out.println(sliderLevel2.getValue());
		}
		
	}
	

}
