package Ecran;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Bouton.Commande;
import Constante.ConstanteImages;
import Run.Fenetre;

public class Help extends JPanel implements ActionListener {
	private ConstanteImages i;
	private JLabel helpRegle;
	private Commande retour = new Commande(this, "Retour");
	private Fenetre fen;

	public Help(Fenetre f) {
		fen = f;
		i = new ConstanteImages();
		helpRegle = new JLabel(i.getAideJeu());

		retour.setBounds(50, 400, 200, 50);

		this.add(retour);

		this.add(helpRegle);
		this.setBackground(new Color(90, 90, 90));

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Retour")){
			fen.afficheMenu();
		}
		
	}
}
