package Ecran;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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

import Run.Fenetre;

public class Controles extends JPanel implements ActionListener{
	
	
	private Fenetre fen;
	JButton boutonValider = new JButton("Retour");
	
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
	
	public Controles(Fenetre f) throws java.text.ParseException{
		
		fen=f;
		this.setBackground(new Color(90,90,90));
		this.setLayout(new GridLayout(7,2));
		
		
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
		
		boutonValider.addActionListener(this);
		this.add(boutonValider);
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
		if (e.getSource()==boutonValider){
			recupDonnees();
			fen.afficheMenu();
		}
	}
}
