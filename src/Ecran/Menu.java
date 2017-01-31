package Ecran;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Constante.ConstanteButton;
import Constante.ConstanteImages;
import Run.Fenetre;
public class Menu extends JPanel{
	private GridLayout grille;
	Fenetre fen;
	Help h;
	Credit c;
	ConstanteButton Cb;
	MenuJouer1 mj1;
	Controles ctrls;
	
	public Menu(Fenetre f) throws ParseException{
		fen = f;
		h=new Help();
		c=new Credit();
		mj1 = new MenuJouer1(this);
		Cb= new ConstanteButton();
		ctrls= new Controles();
		
		/*class Credit implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				.setVisible(false);
				c.setVisible(true);
				fen.setContentPane(c);
			}
		
		}*/
	
		
		
		grille = new GridLayout(6, 1);
		this.setLayout(grille);
		
		
		Cb.getBJoueur1().setBorderPainted(false);
		Cb.getBJoueur1().setFocusPainted(false);
		Cb.getBJoueur1().setContentAreaFilled(false);
		Cb.getBJoueur1().addActionListener(new Joueur1());
		
		Cb.getBJoueur2().setBorderPainted(false);
		Cb.getBJoueur2().setFocusPainted(false);
		Cb.getBJoueur2().setContentAreaFilled(false);
		//Cb.getBJoueur2().addActionListener(new Aide());
		
		Cb.getBoutonControles().setBorderPainted(false);
		Cb.getBoutonControles().setFocusPainted(false);
		Cb.getBoutonControles().setContentAreaFilled(false);
		Cb.getBoutonControles().setText("CONTROLES");//replace by "Control" image
		Cb.getBoutonControles().addActionListener(new Controls());
		
		Cb.getBoutonCredit().setBorderPainted(false);
		Cb.getBoutonCredit().setFocusPainted(false);
		Cb.getBoutonCredit().setContentAreaFilled(false);
		
		Cb.getBoutonAide().setBorderPainted(false);
		Cb.getBoutonAide().setFocusPainted(false);
		Cb.getBoutonAide().setContentAreaFilled(false);
		Cb.getBoutonAide().addActionListener(new Aide());
		
		
		Cb.getBoutonQuit().setBorderPainted(false);
		Cb.getBoutonQuit().setFocusPainted(false);
		Cb.getBoutonQuit().setContentAreaFilled(false);
		Cb.getBoutonQuit().addActionListener(new Quitter());
		
		
	    //Cb.getBoutonRetour().setActionCommand("Retour Jouer");
		
		this.add(Cb.getBJoueur1());
		this.add(Cb.getBJoueur2());
		this.add(Cb.getBoutonControles());
		this.add(Cb.getBoutonAide());
		this.add(Cb.getBoutonCredit());
		this.add(Cb.getBoutonQuit());
		this.setBackground(new Color(90,90,90));
		//fen.add(menu);
		
	}
	
	public Fenetre getFen() {
		return fen;
	}

	public void setFen(Fenetre fen) {
		this.fen = fen;
	}

	class Aide implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			//h.setVisible(true);
			ajoute(h);
		}
	}
	
	class Joueur1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			ajouteJ(mj1);
		}

		
	}
	
	
	

	
	public void ajoute(Help h){
		this.setVisible(false);
		fen.setContentPane(h);
	}
	
	private void ajouteJ(MenuJouer1 mj1) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		fen.setContentPane(mj1);
	}
	
	class Quitter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fen.dispose();
			System.exit(0);
		}
	}

	public class Controls extends JPanel implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			collerAFenetre(ctrls);			
		}
	}
	
	public void collerAFenetre(Controles c){
		this.setVisible(false);
		fen.setContentPane(c);
	}
	
}