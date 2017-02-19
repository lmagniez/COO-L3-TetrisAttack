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

public class Commande extends JButton {

	public Commande(JPanel j, String Commande,int i) {
		super(ConstanteImage.iconbouton[i]);
		setBorderPainted(false);
		setOpaque(true);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setActionCommand(Commande);
		this.addActionListener((ActionListener) j);
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
