package Ecran;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constante.ConstanteImages;

public class Help extends JPanel {
	private ConstanteImages i;
	private JLabel helpRegle;
	public Help(){
		i= new ConstanteImages();
		helpRegle = new JLabel(i.getAideJeu());
		
		this.add(helpRegle);
		this.setBackground(new Color(90,90,90));
		
	}
}
