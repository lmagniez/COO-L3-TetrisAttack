package Constante;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class ConstanceImage {
	// Grille
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

	public static ImageIcon scaled(String imageName,int n) {
		try {
			return new ImageIcon(ImageIO.read(ConstanceImage.class.getResource(imageName)).getScaledInstance(n, n,
					Image.SCALE_DEFAULT));
		} catch (IOException e) {
			return new ImageIcon();
		}
	}
}
