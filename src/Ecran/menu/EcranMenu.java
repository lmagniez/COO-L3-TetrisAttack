package Ecran.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

import Bouton.Commande;
import Bouton.Joueur;
import Constante.ConstanteDimension;
import Ecran.Animation;
import Ecran.Ecran;
import Run.Fenetre;

public class EcranMenu extends Ecran implements ActionListener{

	
	//Joueur joueur1 = new Joueur(this, 1);
	//Joueur joueur2 = new Joueur(this, 2);
	//JButton joueur1 = new Commande(this, "1 Player");
	
	protected PanelMenu1 p1;
	protected PanelMenu2 p2;
	protected PanelMenu3 p3;
	protected PanelMenu4 p4;
	protected PanelMenu5 p5;
	protected PanelMenu6 p6;
	protected PanelMenu7 p7;
	protected PanelMenu8 p8;
	
	
	public int boutonCourant = 0;
	
	
	
	private Timer timer;
	
	private Image fond;
	private Image shadow;
	private Image buttonLabel,selectLabel;
	private int widthbutton=349, heightbutton=50;
	private int widthselect=389, heightselect=77;
	
	
	private Animation yoshi;
	
	private Image yoshiImg;
	private int cptyoshi=0, widthyoshi=68, heightyoshi=96, 
			screenwidthyoshi=widthyoshi*3, screenheightyoshi=heightyoshi*3;
	private int posyoshiY=ConstanteDimension.DimensionFenetrey/2+screenheightyoshi/2,
				posyoshiX=ConstanteDimension.DimensionFenetrex-screenwidthyoshi/2;
	public static final int NB_IMAGE=5;
	

	public EcranMenu(Fenetre f) throws ParseException {
		this.vue = f;
		this.setLayout(null);
		
		
		p1=new PanelMenu1(f,this);
		p2=new PanelMenu2(f,this);
		p3=new PanelMenu3(f,this);
		p4=new PanelMenu4(f,this);
		p5=new PanelMenu5(f,this);
		p6=new PanelMenu6(f,this);
		p7=new PanelMenu7(f,this);
		p8=new PanelMenu8(f,this);
		
		changeMenuBox(p1);
		
		//ANIMATIONS
		timer = new Timer(200, this);
		timer.start();
		fond=new ImageIcon("./ressources/Menu/menu.png").getImage();
		shadow=new ImageIcon("./ressources/Accueil/shadow.png").getImage();
		yoshiImg=new ImageIcon("./ressources/Accueil/YoshiMenu/spriteSheet.png").getImage();
		yoshi= new Animation(yoshiImg,posyoshiX,posyoshiY,widthyoshi,heightyoshi,
				screenwidthyoshi,screenheightyoshi,cptyoshi, NB_IMAGE, this);
		
		buttonLabel=new ImageIcon("./ressources/Menu/buttonlabel.png").getImage();
		selectLabel=new ImageIcon("./ressources/Menu/selectlabel.png").getImage();
		
	}
	
	public void changeMenuBox(PanelMenu p)
	{

		p.setVisible(true);
		this.removeAll();
		this.repaint();
		this.add(p);
		this.validate();
		
		buttons=p.buttons;
		
		/*
		for(int i=0; i<p.buttons.length; i++)
			for(int j=0; j<p.buttons[0].length;j++)
				buttons[0][0].setForeground(Color.black);
		p.buttons[0][0].setForeground(Color.GREEN);
		*/
		p.buttons[0][0].requestFocus();
		
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

	

	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(shadow, ConstanteDimension.DimensionFenetrex-screenwidthyoshi*4/3, 
				ConstanteDimension.DimensionFenetrey-screenheightyoshi*3/4, 56*3, 72*3, this);
		yoshi.draw(g);
	    g.drawImage(selectLabel,ConstanteDimension.DimensionFenetrex/9, 
				heightselect*3/4,widthselect*3/4, heightselect*3/4,this);
	    g.drawImage(buttonLabel,ConstanteDimension.DimensionFenetrex-widthbutton, 
				heightbutton*3/4,widthbutton, heightbutton,this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == timer){
			repaint();
			yoshi.updateCpt();	
		}
	}
	
}