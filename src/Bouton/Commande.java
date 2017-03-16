package Bouton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import Constante.ConstanteImage;

/**
 * Boutons stylisés pour le menu
 * @author loick
 *
 */
public class Commande extends JButton {

	/**
	 * Constructeur
	 * @param j panel du bouton
	 * @param Commande commande a effectuer
	 * @param i image du bouton
	 */
	public Commande(JPanel j, String Commande,int i) {
		super(ConstanteImage.iconbouton[i]);
		setBorderPainted(false);
		setOpaque(false);
		this.setBackground(new Color(0,0,0,0));
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setActionCommand(Commande);
		this.addActionListener((ActionListener) j);
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
