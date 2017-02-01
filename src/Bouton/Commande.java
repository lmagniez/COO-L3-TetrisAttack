package Bouton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.sun.prism.Graphics;

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
	}

	public void paintComponent(Graphics g) {

	}
}
