package Bouton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import Constante.ConstanteGraphique;

public class SliderDifficulte extends JSlider {
	
	private static final int nb_min = 1;
	private static final int nb_max = 3;
	private static final int init = 2;
	
	private int x = 10;
	private int y = 300;
	private int sizex = 240;
	private int sizey = 50;

	public SliderDifficulte(JPanel j) {
		super(JSlider.HORIZONTAL, nb_min, nb_max, init);
		this.setBounds(30, 50, 40, 20);
		this.addChangeListener((ChangeListener) j);
		this.setOpaque(false);
		this.setBounds(x, y, sizex, sizey);
		this.setMajorTickSpacing(1);
		this.setMinorTickSpacing(1);
		this.setSnapToTicks(true);
	}
	
	public SliderDifficulte(JPanel j,int i) {
		this(j);
		this.setBounds(30, 50*i, 40, 20);
	}

}
