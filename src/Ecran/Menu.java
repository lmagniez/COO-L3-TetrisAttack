package Ecran;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Bouton.Commande;
import Bouton.Joueur;
import Run.Fenetre;

public class Menu extends JPanel implements ActionListener {

	Fenetre fen;
	
	Joueur joueur1 = new Joueur(this, 1);
	Joueur joueur2 = new Joueur(this, 2);
	Commande Option = new Commande(this, "Option");
	Commande HowToPlay = new Commande(this, "How To Play");
	Commande HowToImprove = new Commande(this, "How To Improve");

	public JButton[] tabuttons = new JButton[6]; // le tableau de boutons pour
													// le focus
	public int boutonCourant = 0;

	public Menu(Fenetre f) {
		fen = f;
		this.setLayout(null);
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		creerLayout();
		ajout();
	}
	
	private void ajout() {
		this.add(joueur1);
		this.add(joueur2);
		this.add(Option);
		this.add(HowToPlay);
		this.add(HowToImprove);
	}

	private void creerLayout() {
		joueur1.setBounds(20, 100, 200, 50);
		joueur2.setBounds(20, 170, 200, 50);
		Option.setBounds(20, 240, 200, 50);
		HowToImprove.setBounds(20, 310, 300, 50);
		HowToPlay.setBounds(20, 370, 200, 50);
	}

	public Fenetre getFen() {
		return fen;
	}

	public void setFen(Fenetre fen) {
		this.fen = fen;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("Option")){
			fen.afficheControles();
		}
		if (e.getActionCommand().equals("How To Play")){
			fen.afficheHowToPlay();
		}
		if (e.getActionCommand().equals("Joueur1")){
			fen.afficheJeuxJ1();
		}
		if (e.getActionCommand().equals("Joueur2")){
			fen.afficheJeuxJ1();
		}
		if (e.getActionCommand().equals("How To Improve")){
			fen.afficheHowToImprove();
		}
		
	}
	
	/*
	 * 	class MyKeyListener implements KeyListener {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch (keyCode) {
			case KeyEvent.VK_UP:
				System.out.println("up");
				if (boutonCourant < 6) {
					boutonCourant++;
					tabuttons[boutonCourant].requestFocus();
				}
				System.out.println(boutonCourant);

				break;
			case KeyEvent.VK_DOWN:
				System.out.println("down");
				if (boutonCourant >= 0) {
					boutonCourant--;
					tabuttons[boutonCourant].requestFocus();
				}
				System.out.println(boutonCourant);

				break;
			case KeyEvent.VK_ENTER:
				System.out.println("left");

				// handle left
				break;
			}
		}


	}
*/

}