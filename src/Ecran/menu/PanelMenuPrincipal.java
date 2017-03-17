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

/**
 * Panel du menu principal
 * @author loick
 *
 */
public class PanelMenuPrincipal extends PanelMenu implements ActionListener{
	
	protected JButton joueur1 = new Commande (this, "1 Player",0);
	protected JButton joueur2 = new Commande(this, "2 Players",1);
	protected JButton option = new Commande(this, "Option",4);
	protected JButton howToPlay = new Commande(this, "How To Play",3);
	protected JButton howToImprove = new Commande(this, "How To Improve",2);
	
	private int cptButton=0;
	
	
	/**
	 * Constructeur
	 * @param vue fenetre
	 * @param e ecranMenu
	 */
	public PanelMenuPrincipal(Fenetre vue, EcranMenu e)
	{
		this.has_cursor=true;
		this.pred_panel=this;
		NB_BUTTONS_Y=1;
		NB_BUTTONS_X=5;
		buttons=new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonX=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonY=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		
		for(int i=0; i<NB_BUTTONS_X; i++){
			posButtonX[i][0]=ConstanteDimension.DimensionFenetrex*1/7;
			posButtonY[i][0]=180+50*i;
		}
		
		this.setOpaque(false);
		this.ecran=e;
		this.fond=new ImageIcon("./ressources/Menu/menuframe.png").getImage();
		this.vue=vue;
		this.setBounds(ConstanteDimension.DimensionFenetrex/5, ConstanteDimension.DimensionFenetrey/4, 300, 300);
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setMaximumSize(new Dimension(300,500));
		
		ajout();
	}
	
	/**
	 * Ajouter les éléments au panel
	 */
	private void ajout() {
		buttons[cptButton++][0]=joueur1;
		buttons[cptButton++][0]=joueur2;
		buttons[cptButton++][0]=option;
		buttons[cptButton++][0]=howToPlay;
		buttons[cptButton++][0]=howToImprove;
		
		this.add(Box.createRigidArea(new Dimension(10,30)));
		this.add(joueur1);
		this.add(joueur2);
		this.add(option);
		this.add(howToPlay);
		this.add(howToImprove);
		
		this.joueur2.setRequestFocusEnabled(true);
		
		ecran.setButtons(buttons);
		ecran.addListener();
		
		
		
	}
	
	public void actionPerformed(ActionEvent e){
		
			if (e.getActionCommand().equals("Option")){
				EcranMenu.changeMenuBox(ecran,ecran.p4);
				EcranMenu.setCurseur(null);
			}
			if (e.getActionCommand().equals("How To Play")){
				EcranMenu.changeMenuBox(ecran,ecran.p6);
			}
			if (e.getActionCommand().equals("1 Player")){
				EcranMenu.changeMenuBox(ecran,ecran.p2);
			}
			if (e.getActionCommand().equals("2 Players")){
				EcranMenu.changeMenuBox(ecran,ecran.p3);
			}
			if (e.getActionCommand().equals("How To Improve")){
				EcranMenu.changeMenuBox(ecran,ecran.p5);
			}
		
	}
	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		
		//posyoshiY=ConstanteDimension.DimensionFenetrey/2+screenheightyoshi/2,
		//		posyoshiX=ConstanteDimension.DimensionFenetrex-screenwidthyoshi/2;
	   
		
	}
	

}
