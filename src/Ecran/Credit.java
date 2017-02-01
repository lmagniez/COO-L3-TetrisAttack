package Ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bouton.Commande;
import Constante.ConstanteImages;
import Run.Fenetre;

public class Credit extends JPanel implements ActionListener{
	
	private Fenetre fen;
	
	private JLabel AffCredit;
	private ConstanteImages i;
	private Commande retour=new Commande(this,"Retour");
	
	public Credit(Fenetre f){
		fen=f;
		AffCredit = new JLabel(new ImageIcon("Images/pageCredit.png"));
		
		retour.setBounds(50, 400, 200, 50);
		
		this.add(retour);
		this.add(AffCredit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Retour")){
			fen.afficheMenu();
		}
		
	}
}