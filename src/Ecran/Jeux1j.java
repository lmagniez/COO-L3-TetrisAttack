package Ecran;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import Constante.ConstanteDimension;
import Constante.ConstanteGraphique;
import Constante.ConstanteJeux;
import Gestion.Jeux1Joueur;
import JComponent.Grille;
import Run.Fenetre;

public class Jeux1j extends JPanel implements ConstanteDimension,ConstanteJeux,ConstanteGraphique{
	
	private Fenetre fen;

	private Grille g;
	
	public Jeux1j(Fenetre f){
		fen=f;
		g=new Grille();
		
		creerlayout();
	}

	private void creerlayout() {
		this.setLayout(null);
		g.setBounds(250,100, DimensionGrillex, DimensionGrilley);
		this.add(g);
	}

	public void focus() {
		g.setFocusable(true);
		g.requestFocus();
	}

	public Grille getG() {
		return g;
	}
	
	
	
}
