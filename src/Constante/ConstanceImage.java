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
			scaled("/iconJoueur/j1.png",50),
			scaled("/iconJoueur/j2.png",50),
			scaled("/iconJoueur/j3.png",50),
			scaled("/iconJoueur/j4.png",50),
			scaled("/iconJoueur/j5.png",50),
			scaled("/iconJoueur/j6.png",50),
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
