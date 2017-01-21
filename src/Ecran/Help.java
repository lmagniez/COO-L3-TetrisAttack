package Ecran;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constante.ConstanteImage;

public class Help implements ConstanteImage {
	private JPanel help;
	private JLabel helpRegle;
	Help(){
		help=new JPanel();
		helpRegle = new JLabel(AideJeu);
		help.add(helpRegle);
		
	}
	public void Visible() {
		// TODO Auto-generated method stub
		
	}
}
