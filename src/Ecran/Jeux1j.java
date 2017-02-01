package Ecran;


import javax.swing.JPanel;

import Constante.ConstanteDimension;
import Constante.ConstanteGraphique;
import Constante.ConstanteJeux;
import Gestion.Jeux1Joueur;
import Run.Fenetre;

public class Jeux1j extends JPanel implements ConstanteDimension,ConstanteJeux,ConstanteGraphique{
	
	private Fenetre fen;
	private Jeux1Joueur j;
	
	public Jeux1j(Fenetre f){
		fen=f;
		j=new Jeux1Joueur();
		creerlayout();
	}

	private void creerlayout() {
		this.setLayout(null);
		(j.getJ1().getG()).setBounds(250,100, DimensionGrillex, DimensionGrilley);
		this.add(j.getJ1().getG());
	}
}
