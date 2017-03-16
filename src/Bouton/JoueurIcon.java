package Bouton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import Constante.ConstanteImage;

/**
 * JButton des differents joueurs
 * @author loick
 *
 */
public class JoueurIcon extends JButton{

	private int icon;
	private int idJ;
	
	/**
	 * Constructeur
	 * @param p panel du button
	 * @param s id de l'icone
	 */
	public JoueurIcon(JPanel p,int s){
		super(ConstanteImage.icon[s]);
		this.icon=s;
		idJ=1;
		this.setPreferredSize(new Dimension(50,50));
		this.setFont(new Font("Verdana", Font.BOLD, 20));
		setBorderPainted(false);
		setOpaque(true);
		this.setForeground(Color.BLACK);
		this.setVisible(true);
		this.setActionCommand("j"+icon);
		this.addActionListener((ActionListener) p);
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
	
	/**
	 * Constructeur pour le choix de 2 joueurs
	 * @param panelMenu8 panel du button
	 * @param i id icone
	 * @param j joueur
	 */
	public JoueurIcon(JPanel panelMenu8, int i, int j) {
		this(panelMenu8,i);
		idJ=j;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public int getIconId() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getIdJ() {
		return idJ;
	}
	
	
}
