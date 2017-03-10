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
	
	private JLabel labelBox,labelBox2;
	private SliderDifficulte sliderLevel1= new SliderDifficulte(this,0);
	private JButton retour=new Commande(this,"Retour",1);
	private JButton start=new Commande(this,"Démarrer",6);
	
	private int cptButton=0;
	
	public PanelMenu3(Fenetre vue, EcranMenu e)
	{
		this.setOpaque(false);
		this.ecran=e;
		this.vue=vue;
		this.pred_panel=this.ecran.p1;
		this.has_cursor=true; 
		NB_BUTTONS_Y=1;
		NB_BUTTONS_X=3;
		buttons=new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonX=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonY=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		
		for(int i=0; i<NB_BUTTONS_X; i++){
			posButtonX[i][0]=ConstanteDimension.DimensionFenetrex*1/7;
			posButtonY[i][0]=180+50*i;
		}
		
		
		this.fond=new ImageIcon("./ressources/Menu/menuframe.png").getImage();
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

		buttons[cptButton++][0]=retour;
		buttons[cptButton++][0]=start;
		
		
		this.add(Box.createRigidArea(new Dimension(10,30)));
		this.add(sliderLevel1);
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
				EcranMenu.changeMenuBox(ecran,ecran.p1);
			}
			if (e.getActionCommand().equals("Démarrer")){
				EcranMenu.changeMenuBox(ecran,ecran.p8);
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

	}
	

}
