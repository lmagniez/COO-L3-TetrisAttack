package Ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bouton.Commande;
import Constante.ConstanteImages;
import Run.Fenetre;

public class HowToPlay extends JPanel implements ActionListener{
	
	private Fenetre fen;

	private Commande retour=new Commande(this,"Retour");
	
	public HowToPlay(Fenetre f){
		fen=f;
	
		retour.setBounds(50, 400, 200, 50);
		
		this.add(retour);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Retour")){
			fen.afficheMenu();
		}
		
	}
}