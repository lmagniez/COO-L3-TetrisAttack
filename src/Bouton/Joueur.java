package Bouton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * JButton Joueur
 * @author loick
 *
 */
public class Joueur extends JButton{
	
	/**
	 * Constructeur
	 * @param j panel
	 * @param i id du joueur
	 */
	public Joueur(JPanel j, int i){
		
		this.setFont(new Font("Verdana", Font.BOLD, 20));
		setBorderPainted(false);
		setOpaque(true);
		
		this.setBackground(Color.WHITE);
		this.setForeground(Color.BLACK);
		this.setText("Joueur"+i);
		this.setActionCommand("Joueur"+i);
		this.addActionListener((ActionListener) j);
	}


	public void paintComponent(Graphics g){
		
	}
}
