package Constante;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ConstanteButton extends ConstanteImages {
	ConstanteImages Ci;
	private JButton BoutonJoueur1 = new JButton();
	private JButton BoutonJoueur2 = new JButton();
	private JButton boutonAide = new JButton();
	private JButton boutonCredit = new JButton();
	private JButton boutonQuit = new JButton();
	private JButton boutonControles = new JButton();
	
	public ConstanteButton(){
		Ci=new ConstanteImages();
		BoutonJoueur1.setIcon(Ci.getJoueur1());
		BoutonJoueur2.setIcon(Ci.getJoueur2());
		boutonAide.setIcon(Ci.getAide());
		boutonCredit.setIcon(Ci.getCredit());
		boutonQuit.setIcon(Ci.getBoutonQuitter());
		
	}

	public JButton getBJoueur1() {
		return BoutonJoueur1;
	}


	public JButton getBJoueur2() {
		return BoutonJoueur2;
	}


	public JButton getBoutonAide() {
		return boutonAide;
	}


	public JButton getBoutonCredit() {
		return boutonCredit;
	}


	public JButton getBoutonQuit() {
		return boutonQuit;
	}

	public JButton getBoutonControles(){
		return boutonControles;
	}
	
}