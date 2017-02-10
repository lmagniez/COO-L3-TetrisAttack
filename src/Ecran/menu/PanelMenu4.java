package Ecran.menu;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import Bouton.Commande;
import Constante.ConstanteDimension;
import Run.Fenetre;




public class PanelMenu4 extends PanelMenu implements ActionListener{
	
	
	private Fenetre fen;
	private JButton retour=new Commande(this,"Retour",1);
	private JButton start=new Commande(this,"Valider",6);
	
	MaskFormatter selectj1 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
	JFormattedTextField sel1 = new JFormattedTextField(selectj1);
	
	MaskFormatter gauchej1 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
	JFormattedTextField g1 = new JFormattedTextField(gauchej1);
	
	MaskFormatter droitej1 = new MaskFormatter("U");//recup uni;quement si c'est une lettre, U passe la lettre en maj automatiquement
	JFormattedTextField d1 = new JFormattedTextField(droitej1);
	
	MaskFormatter selectj2 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
	JFormattedTextField sel2= new JFormattedTextField(selectj2);
			
	MaskFormatter gauchej2 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
	JFormattedTextField g2= new JFormattedTextField(gauchej2);

	MaskFormatter droitej2 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
    JFormattedTextField d2 = new JFormattedTextField(droitej2);
	
    
    int cptButton=0;
    
	public PanelMenu4(Fenetre f, EcranMenu ecran) throws java.text.ParseException{
		
		NB_BUTTONS_Y=2;
		NB_BUTTONS_X=1;
		buttons=new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];
		
		this.ecran=ecran;
		this.vue=f;
		this.setLayout(new GridLayout(7,2));
		this.fond=new ImageIcon("./ressources/Menu/menuframe.png").getImage();
		
		this.setBounds(ConstanteDimension.DimensionFenetrex/5, ConstanteDimension.DimensionFenetrey/4,
				300, 300);
		
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.setVisible(true);
		this.requestFocusInWindow();
		this.setMaximumSize(new Dimension(300,500));
		
		this.ajout();
		
	}
	
	public void ajout() {
		
		/*
		buttons[cptButton++][0]=sel1;
		buttons[cptButton++][0]=g1;
		buttons[cptButton++][0]=d1;
		buttons[cptButton++][0]=sel2;
		buttons[cptButton++][0]=g2;
		buttons[cptButton++][0]=d2;
		*/
		buttons[0][cptButton++]=retour;
		buttons[0][cptButton++]=start;
		
		
		this.add(new JLabel("Select J1"));
		try{
			  this.add(sel1);
		}catch(ParseException e){e.printStackTrace();}
		
		this.add(new JLabel("Left J1"));
		try{
			  this.add(g1);
		}catch(ParseException e){e.printStackTrace();}
		
		this.add(new JLabel("Right J1"));
		try{
			  this.add(d1);
		}catch(ParseException e){e.printStackTrace();}
		
		this.add(new JLabel("Select J2"));
		try{
			  this.add(sel2);
		}catch(ParseException e){e.printStackTrace();}	
		
		this.add(new JLabel("Left J2"));
		try{
			  this.add(g2);
		}catch(ParseException e){e.printStackTrace();}
		
		this.add(new JLabel("Right J2"));
		try{
			  this.add(d2);
		}catch(ParseException e){e.printStackTrace();}
		
		
		this.add(retour);
		this.add(start);
		
		
		
		
		/*
		System.out.println(this.joueur2.isRequestFocusEnabled());
		this.joueur2.setRequestFocusEnabled(true);
		
		System.out.println(this.joueur2.isFocusable());
		*/
		
		ecran.setButtons(buttons);
		ecran.addListener();
		
		
		
	}
	
	public void recupDonnees(){
		
		String[] donnees = new String[6];
		
	    donnees[0] = sel1.getText();
		donnees[1] = g1.getText();
		donnees[2] = d1.getText();
		donnees[3] = sel2.getText();
		donnees[4] = g2.getText();
		donnees[5] = d2.getText();
		
		try{
			File f = new File("controles.txt");
			FileOutputStream sortie = new FileOutputStream(f);
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("controles.txt")));
			byte[] b;
		    
		    for(String s: donnees){
		    	b = s.getBytes(Charset.forName("UTF-8")); // les string sont encodés en UTF-16
		    	bos.write(b);
		    }
		    
		    sortie.close();
		    bos.close();
		    
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e1){
			e1.printStackTrace();
		}
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Valider")){
			recupDonnees();
			ecran.changeMenuBox(ecran.p1);
		}
		if (e.getActionCommand().equals("Retour")){
			ecran.changeMenuBox(ecran.p1);
		}
	}

	

	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		
		//posyoshiY=ConstanteDimension.DimensionFenetrey/2+screenheightyoshi/2,
		//		posyoshiX=ConstanteDimension.DimensionFenetrex-screenwidthyoshi/2;
	   
		
	}
	
	
}
