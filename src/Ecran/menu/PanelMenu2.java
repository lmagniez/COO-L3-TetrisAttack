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

public class PanelMenu2 extends PanelMenu implements ActionListener, ChangeListener, ItemListener {

	/*
	 * protected JButton joueur1 = new Commande (this, "11 Player"); protected
	 * JButton joueur2 = new Commande(this, "22 Players"); protected JButton
	 * option = new Commande(this, "Option"); protected JButton howToPlay = new
	 * Commande(this, "How To Play");
	 */

	private SliderDifficulte sliderLevel;
	private JButton start = new Commande(this, "Démarrer", 6);

	private int cptButton = 0;

	
	
	public PanelMenu2(Fenetre vue, EcranMenu e) {
		this.ecran = e;
		this.vue = vue;
		this.setOpaque(false);
		this.has_cursor=true; 
		this.pred_panel=this.ecran.p1;
		NB_BUTTONS_Y = 1;
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

		initSlide();

		ajout();
	}

	public void initSlide() {

		sliderLevel = new SliderDifficulte(this);

		/*
		 * sliderLevel.setBounds(300, 150, 200, 60); labelTaille.setBounds(300,
		 * 215, 100, 90); perso.setBounds(350, 350, 100, 20);
		 */
	}

	private void ajout() {

		buttons[cptButton++][0] = sliderLevel;
		buttons[cptButton++][0] = start;

		this.add(Box.createRigidArea(new Dimension(10, 30)));
		this.add(sliderLevel);

		this.add(Box.createRigidArea(new Dimension(10, 20)));
		this.add(Box.createRigidArea(new Dimension(10, 20)));
		this.add(Box.createRigidArea(new Dimension(10, 20)));
		this.add(Box.createRigidArea(new Dimension(10, 20)));
		this.add(start);

		/*
		 * System.out.println(this.joueur2.isRequestFocusEnabled());
		 * this.joueur2.setRequestFocusEnabled(true);
		 * 
		 * System.out.println(this.joueur2.isFocusable());
		 */

		ecran.setButtons(buttons);
		ecran.addListener();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Retour")) {
			EcranMenu.changeMenuBox(ecran,ecran.p1);
		}
		if (e.getActionCommand().equals("Démarrer")) {
			EcranMenu.changeMenuBox(ecran,ecran.p7);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		g.setFont(new Font("Verdana",Font.BOLD,20));
		g.drawString("Difficulte", 60, 100);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() instanceof SliderDifficulte)
			System.out.println(sliderLevel.getValue());
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}

}
