package Ecran;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constante.ConstanteImages;

public class Credit extends JPanel{
	private JLabel AffCredit;
	private ConstanteImages i;
	public Credit(){
		AffCredit = new JLabel(new ImageIcon("Images/pageCredit.png"));
		this.add(AffCredit);
	}
}