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
import java.util.Random;

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

/**
 * Panel du jeu 2 joueur
 * @author loick
 *
 */
public class PanelMenu2J extends PanelMenu implements ActionListener, ChangeListener, ItemListener {
	
	private JLabel labelBox,labelBox2;
	private SliderDifficulte sliderLevel1= new SliderDifficulte(this);
	private SliderDifficulte sliderLevel2= new SliderDifficulte(this);
	private JButton start=new Commande(this,"Démarrer",6);
	
	private JLabel difficulte1= new JLabel("Difficulté J1: "+0);
	private JLabel difficulte2= new JLabel("Difficulté J2: "+0);
	
	private Color[] tabcouleur = {Color.RED,Color.green,Color.ORANGE,Color.MAGENTA};
	
	private Random rnd=new Random();
	
	private int cptButton=0;
	
	/**
	 * Constructeur
	 * @param vue fenetre
	 * @param e ecranMenu
	 */
	public PanelMenu2J(Fenetre vue, EcranMenu e)
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
			posButtonX[i][0]=ConstanteDimension.DimensionFenetrex*1/12;
		}
		posButtonY[0][0]=220;
		posButtonY[1][0]=220+50;
		posButtonY[2][0]=220+50+60;
		
		
		this.fond=new ImageIcon(getClass().getResource("/Ressource/Menu/menuframe.png")).getImage();
		this.setBounds(ConstanteDimension.DimensionFenetrex/7, ConstanteDimension.DimensionFenetrey/3,
				300, 220);
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setMaximumSize(new Dimension(300,300));
		
		
		
		labelBox = new JLabel();
		labelBox2= new JLabel();


		ajout();
	}

	/**
	 * Ajouter les éléments au panel
	 */
	public void ajout() {
		
		buttons[cptButton++][0]=sliderLevel1;
		buttons[cptButton++][0]=sliderLevel2;
		buttons[cptButton++][0]=start;
		
		this.setLayout(null);

		sliderLevel1.setBounds(140, 30, 130, 30);
		
		difficulte1.setBounds(25, 30, 130,30);
		difficulte1.setFont(new Font("verdana",Font.BOLD,12));
		difficulte1.setForeground(tabcouleur[rnd.nextInt(tabcouleur.length)]);
		
		sliderLevel2.setBounds(140, 80, 130, 30);
		
		difficulte2.setBounds(25, 80, 130,30);
		difficulte2.setFont(new Font("verdana",Font.BOLD,12));
		difficulte2.setForeground(tabcouleur[rnd.nextInt(tabcouleur.length)]);
		
		start.setBounds(10, 130, 280, 50);
		
		
		this.add(sliderLevel1);
		this.add(sliderLevel2);
		this.add(this.difficulte1);
		this.add(this.difficulte2);
		this.add(start);
		
		
		ecran.setButtons(buttons);
		ecran.addListener();
	}
	
	public void actionPerformed(ActionEvent e){
		
			if (e.getActionCommand().equals("Retour")){
				EcranMenu.changeMenuBox(ecran,ecran.p1);
			}
			if (e.getActionCommand().equals("Démarrer")){
				EcranMenu.changeMenuBox(ecran,ecran.p8);
				EcranMenu.getOption()[0]=sliderLevel1.getValue();
				EcranMenu.getOption()[2]=sliderLevel2.getValue();
				EcranMenu.getOption()[4]=0;
			}
	}
	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		g.setFont(new Font("Verdana",Font.BOLD,20));
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()== this.sliderLevel1){
			int res= sliderLevel1.getValue();
			this.difficulte1.setText("Difficulté J1: "+res);
		}
		if(e.getSource()== this.sliderLevel2){
			int res= sliderLevel2.getValue();
			this.difficulte2.setText("Difficulté J2: "+res);
		}
	}
	

}
