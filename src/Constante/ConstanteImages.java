package Constante;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ConstanteImages {
	public ImageIcon Jouer;
	public ImageIcon Aide;
	public ImageIcon Credit;
	public ImageIcon AideJeu;
	public ImageIcon Quitter;
	public ImageIcon Joueur1;
	public ImageIcon Joueur2;
		public ConstanteImages(){
			Jouer = new ImageIcon(getClass().getResource("/Images/jouer.png" ));
			Aide = new ImageIcon(getClass().getResource("/Images/aide.png" ));
			Credit = new ImageIcon(getClass().getResource("/Images/Credit.png" ));
			AideJeu = new ImageIcon(getClass().getResource("/Images/AideJeu.png" ));
			Quitter =new ImageIcon(getClass().getResource(("/Images/quitter.png" )));
			Joueur1 =new ImageIcon(getClass().getResource(("/Images/joueur1.png" )));
			Joueur2 =new ImageIcon(getClass().getResource(("/Images/joueur2.png" )));
		}
		public ImageIcon getJoueur1() {
			return Joueur1;
		}
		public ImageIcon getJoueur2() {
			return Joueur2;
		}

		public ImageIcon getJouer() {
			return Jouer;
		}

		public ImageIcon getAide() {
			return Aide;
		}

		public ImageIcon getCredit() {
			return Credit;
		}

		public ImageIcon getAideJeu() {
			return AideJeu;
		}

		public ImageIcon getBoutonQuitter() {
			return Quitter;
		}

		
}
