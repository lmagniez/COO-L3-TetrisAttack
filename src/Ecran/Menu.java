package Ecran;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Constante.ConstanteImage;

public class Menu implements ConstanteImage{
	private GridLayout grille;
	JFrame fen;
	Help h;
	private JPanel menu;
	private JButton Jouer;
	private JButton boutonAide;
	private JButton boutonCredit;
	private JButton boutonQuit;
	
	public Menu(){
		fen = new JFrame();
		h=new Help();
		fen.setTitle("Tetris Attack");
		fen.setLocation(0, 0);
		fen.setSize(600,600);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setLocationRelativeTo(null);
		fen.setBackground(Color.BLACK);
		fen.setResizable(false);
		
		fen.setVisible(true);
		
		
		class Aide implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				h.Visible();
				//Help h=new Help();
				//fen.setContentPane(h);
			}

		}
		
		
		grille = new GridLayout(4, 1);
		menu=new JPanel(grille);
		
		Jouer = new JButton();
		Jouer.setIcon(BoutonJouer);
		Jouer.setBorderPainted(false);
		Jouer.setFocusPainted(false);
		Jouer.setOpaque(true);
		Jouer.setContentAreaFilled(false);
		
		
		boutonAide = new JButton();
		boutonAide.setIcon(BoutonAide);
		boutonAide.setBorderPainted(false);
		boutonAide.setFocusPainted(false);
		boutonAide.setContentAreaFilled(false);
		boutonAide.addActionListener(new Aide());
		
		boutonCredit = new JButton();
		boutonCredit.setIcon(BoutonCredit);
		boutonCredit.setBorderPainted(false);
		boutonCredit.setFocusPainted(false);
		boutonCredit.setContentAreaFilled(false);
		//boutonCredit.addActionListener(null);

		boutonQuit = new JButton();
		boutonQuit.setIcon(BoutonQuitter);
		boutonQuit.setBorderPainted(false);
		boutonQuit.setFocusPainted(false);
		boutonQuit.setContentAreaFilled(false);
		//boutonQuit.addActionListener(null);
		
		menu.add(Jouer);
		menu.add(boutonAide);
		menu.add(boutonCredit);
		menu.add(boutonQuit);
		menu.setOpaque(true);
		menu.setBackground(Color.BLACK);
		fen.setContentPane(menu);
		
		
		
	}

	public JPanel getMenu() {
		return menu;
	}

	public void setMenu(JPanel menu) {
		this.menu = menu;
	}
	
}