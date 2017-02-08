package Bouton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import Constante.ConstanceImage;

public class JoueurIcon extends JButton{

	private int icon;
	public JoueurIcon(JPanel p,int s){
		super(ConstanceImage.icon[s]);
		this.icon=s;
		this.setPreferredSize(new Dimension(50,50));
		this.setFont(new Font("Verdana", Font.BOLD, 20));
		setBorderPainted(false);
		setOpaque(true);
		this.setBackground(Color.WHITE);
		this.setForeground(Color.BLACK);
		this.setVisible(true);
		this.setActionCommand("j"+icon);
		this.addActionListener((ActionListener) p);
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
	
}
