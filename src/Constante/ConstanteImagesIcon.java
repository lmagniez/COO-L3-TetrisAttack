package Constante;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ConstanteImagesIcon {
	public ImageIcon Jouer;
	public ImageIcon Aide;
	public ImageIcon Credit;
	public ImageIcon AideJeu;
	public ImageIcon Quitter;
	public ImageIcon Joueur1;
	public ImageIcon Joueur2;
	public ImageIcon Controles;
	public ImageIcon retour;
		public ConstanteImagesIcon(){
			Jouer = new ImageIcon(getClass().getResource("/Images/unJoueur.png" ));
			Aide = new ImageIcon(getClass().getResource("/Images/aide.png" ));
			//Controles = new ImageIcon(getClass().getResource("/Images/controles.png"));
			Credit = new ImageIcon(getClass().getResource("/Images/Credit.png" ));
			AideJeu = new ImageIcon(getClass().getResource("/Images/AideJeu.png" ));
			Quitter =new ImageIcon(getClass().getResource("/Images/quitter.png" ));
			Joueur1 =new ImageIcon(getClass().getResource("/Images/joueur1.png" ));
			Joueur2 =new ImageIcon(getClass().getResource("/Images/joueur2.png" ));
			retour = new ImageIcon(getClass().getResource("/Images/retour.png" ));
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

		public ImageIcon getQuitter() {
			return Quitter;
		}
		
		public ImageIcon getControles(){
			return Controles;
		}
		
		public ImageIcon getRetour(){
			return retour;
		}
		
}
