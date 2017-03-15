package Ecran.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Bouton.Commande;
import Bouton.SliderDifficulte;
import Constante.ConstanteDimension;
import Run.Fenetre;

/**
 * Sous menu 1 joueur
 * @author loick
 *
 */
public class PanelMenu1J extends PanelMenu implements ActionListener, ChangeListener, ItemListener {


	private SliderDifficulte sliderLevel;
	private JButton jeuxIa = new Commande(this, "IA", 7);
	private JButton start = new Commande(this, "Démarrer", 6);

	private JLabel difficulte= new JLabel("Difficulté: "+0);
	
	private int cptButton = 0;
	
	/**
	 * Constructeur
	 * @param vue fenetre
	 * @param e ecranMenu
	 */
	public PanelMenu1J(Fenetre vue, EcranMenu e) {
		this.ecran = e;
		this.vue = vue;
		this.setOpaque(false);
		this.has_cursor=true; 
		this.pred_panel=this.ecran.p1;
		NB_BUTTONS_Y = 1;
		NB_BUTTONS_X = 3;
		buttons = new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonX=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonY=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		
		for(int i=0; i<NB_BUTTONS_X; i++){
			posButtonX[i][0]=ConstanteDimension.DimensionFenetrex*1/7;
			posButtonY[i][0]=180+70*i;
			
		}
		
		this.fond = new ImageIcon("./ressources/Menu/menuframe.png").getImage();
		this.setBounds(ConstanteDimension.DimensionFenetrex / 5, ConstanteDimension.DimensionFenetrey / 4, 300, 300);
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		sliderLevel = new SliderDifficulte(this);

		ajout();
	}


	/**
	 * Ajouter les éléments au panel
	 */
	private void ajout() {
		this.setLayout(null);
		
		
		sliderLevel.setBounds(140, 40, 130, 30);
		difficulte.setBounds(30, 30, 100,50);
		
		jeuxIa.setBounds(10, 100, 280, 50);
		start.setBounds(10, 170, 280, 50);
		
		buttons[cptButton++][0] = sliderLevel;
		buttons[cptButton++][0] = jeuxIa;
		buttons[cptButton++][0] = start;
		
		this.add(sliderLevel);
		this.add(jeuxIa);
		this.add(start);
		this.add(difficulte);


		ecran.setButtons(buttons);
		ecran.addListener();

	}
	
	/**
	 * Gestion des événements
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("IA")) {
			EcranMenu.changeMenuBox(ecran,ecran.p8);
			EcranMenu.getOption()[0]=sliderLevel.getValue();
			EcranMenu.getOption()[4]=1;
		}
		if (e.getActionCommand().equals("Démarrer")) {
			EcranMenu.changeMenuBox(ecran,ecran.p7);
			EcranMenu.getOption()[0]=sliderLevel.getValue();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		g.setFont(new Font("Verdana",Font.BOLD,20));
		//g.drawString("Difficulte", 60, 100);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() instanceof SliderDifficulte){
			SliderDifficulte s=(SliderDifficulte) e.getSource();
			int res= s.getValue();
			this.difficulte.setText("Difficulté: "+res);
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}

}
