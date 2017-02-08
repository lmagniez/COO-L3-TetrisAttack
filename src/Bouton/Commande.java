package Bouton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Commande extends JButton {

	public Commande(JPanel j, String Commande) {

		this.setFont(new Font("Verdana", Font.BOLD, 20));
		setBorderPainted(false);
		setOpaque(true);
		this.setBackground(Color.WHITE);
		this.setForeground(Color.BLACK);
		this.setText(Commande);
		this.setActionCommand(Commande);
		this.addActionListener((ActionListener) j);
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
}
