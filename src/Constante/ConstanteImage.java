package Constante;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Constantes des images
 * @author loick
 *
 */
public class ConstanteImage {
	// Grille
	public static Image filtre = Toolkit.getDefaultToolkit().createImage("./ressources/Game/filtre.png");
	public static Image coeur = Toolkit.getDefaultToolkit().createImage("./sprites/coeur.png");
	public static Image etoile = Toolkit.getDefaultToolkit().createImage("./sprites/etoile.png");
	public static Image losange = Toolkit.getDefaultToolkit().createImage("./sprites/losange.png");
	public static Image rond = Toolkit.getDefaultToolkit().createImage("./sprites/rond.png");
	public static Image triangle = Toolkit.getDefaultToolkit().createImage("./sprites/triangle.png");
	public static Image triangleInverse = Toolkit.getDefaultToolkit().createImage("./sprites/triangleInverse.png");

	public static ImageIcon[] icon = { 
			scaled("/Ressource/IconJoueur/j1.png",70),
			scaled("/Ressource/IconJoueur/j2.png",70),
			scaled("/Ressource/IconJoueur/j3.png",70),
			scaled("/Ressource/IconJoueur/j4.png",70),
			scaled("/Ressource/IconJoueur/j5.png",70),
			scaled("/Ressource/IconJoueur/j6.png",70),
	};
	
	public static ImageIcon[] iconbouton = { 
			scaledButton("/Ressource/IconButton/1Player.png",260,50),
			scaledButton("/Ressource/IconButton/2Player.png",260,50),
			scaledButton("/Ressource/IconButton/Credit.png",260,50),
			scaledButton("/Ressource/IconButton/Help.png",260,50),
			scaledButton("/Ressource/IconButton/Option.png",260,50),
			scaledButton("/Ressource/IconButton/Exit.png",260,50),
			scaledButton("/Ressource/IconButton/Play.png",260,50),
			scaledButton("/Ressource/IconButton/2AI.png",260,50)
	};
	
	public static Image curseurgauche=Toolkit.getDefaultToolkit().createImage("./ressources/curseurgauche.png");
	public static Image curseurdroit=Toolkit.getDefaultToolkit().createImage("./ressources/curseurdroit.png");

	public static ImageIcon scaled(String imageName,int n) {
		try {
			return new ImageIcon(ImageIO.read(ConstanteImage.class.getResource(imageName)).getScaledInstance(n, n,
					Image.SCALE_DEFAULT));
		} catch (IOException e) {
			return new ImageIcon();
		}
	}	
	
	public static ImageIcon scaledButton(String imageName,int n,int an) {
		try {
			return new ImageIcon(ImageIO.read(ConstanteImage.class.getResource(imageName)).getScaledInstance(n, an,
					Image.SCALE_DEFAULT));
		} catch (IOException e) {
			return new ImageIcon();
		}
	}
}
