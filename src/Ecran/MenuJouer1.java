package Ecran;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Bouton.Commande;
import Ecran.menu.EcranMenu;
import Run.Fenetre;
import Variable.VariableJeu;

public class MenuJouer1 extends JPanel implements ActionListener {

	Fenetre fen;
	private JSlider sliderLevel;
	private EcranMenu menu;
	
	private Commande retour = new Commande(this,"Retour");
	
	private JLabel labelTaille;
	private JLabel labelBox;
	private JComboBox perso;

	public MenuJouer1(Fenetre f) {
		fen = f;

		labelBox = new JLabel();
		perso = new JComboBox();

		this.setLayout(null);
		retour.setBounds(50, 400, 200, 50);
		
		initSlide();

		this.add(sliderLevel);
		this.add(retour);
	}

	public void initSlide() {
		this.setBackground(new Color(90, 90, 90));
		sliderLevel = new JSlider();
		labelTaille = new JLabel("Difficulte = ");

		perso.setPreferredSize(new Dimension(100, 20));
		perso.addItem("Yoshi vert");
		perso.addItem("Yoshi rose");

		sliderLevel.setMaximum(4);
		sliderLevel.setMinimum(1);

		sliderLevel.setPaintTicks(true);
		sliderLevel.setPaintLabels(true);
		sliderLevel.setMajorTickSpacing(1);

		sliderLevel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				labelTaille.setText("Difficulte = " + ((JSlider) event.getSource()).getValue());
				VariableJeu.level = ((int) ((JSlider) event.getSource()).getValue());
			}
		});

		sliderLevel.setBounds(300, 150, 200, 60);
		labelTaille.setBounds(300, 215, 100, 90);
		perso.setBounds(350, 350, 100, 20);

		this.add(sliderLevel);
		this.add(labelTaille);
		this.add(perso);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Retour")) {
			fen.afficheMenu();
		}
	}

}
