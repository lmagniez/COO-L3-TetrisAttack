package Constante;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ConstanteButton extends ConstanteImages {
	ConstanteImages Ci;
	
	private JButton boutonAide = new JButton();
	private JButton boutonCredit = new JButton();
	private JButton boutonQuit = new JButton();
	private JButton boutonControles = new JButton();
	private JButton boutonRetour = new JButton();
	
	public ConstanteButton(){
		Ci=new ConstanteImages();
	
		
		boutonAide.setIcon(Ci.getAide());
		boutonCredit.setIcon(Ci.getCredit());
		boutonQuit.setIcon(Ci.getQuitter());
		boutonRetour.setIcon(Ci.getRetour());
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
	
	public JButton getBoutonRetour(){
		return boutonRetour;
	}

	public JButton getBoutonControles(){
		return boutonControles;
	}
	
}