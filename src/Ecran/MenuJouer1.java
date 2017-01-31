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

import Constante.ConstanteButton;
import Run.Fenetre;
import Variable.VariableJeu;

public class MenuJouer1 extends JPanel {
	
	private JSlider sliderLevel;
	private Menu menu;
	private ConstanteButton Cb;
	private JLabel labelTaille;
	private JLabel labelBox;
	private JComboBox perso;
	MenuJouer1(Menu m){
		Cb = new ConstanteButton();
		labelBox = new JLabel();
		perso = new JComboBox();
		
		menu=m;
		this.setLayout(null);
		initSlide();
		
		this.add(sliderLevel);
	}
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public void initSlide(){
		this.setBackground(new Color(90,90,90));
		sliderLevel = new JSlider();
		labelTaille = new JLabel("Difficulte = ");
		
		perso.setPreferredSize(new Dimension(100,20));
		perso.addItem("Yoshi vert");
		perso.addItem("Yoshi rose");
		
		sliderLevel.setMaximum(4);
	    sliderLevel.setMinimum(1);
	    
	    sliderLevel.setPaintTicks(true);
	    sliderLevel.setPaintLabels(true);
	    sliderLevel.setMajorTickSpacing(1);
	    
	    sliderLevel.addChangeListener(new ChangeListener(){
	        public void stateChanged(ChangeEvent event){
	          labelTaille.setText("Difficulte = " + ((JSlider)event.getSource()).getValue());
	          VariableJeu.level = ((int) ((JSlider)event.getSource()).getValue());
	        }
	      });
	    
	    sliderLevel.setBounds(300,150,200,60);
	    labelTaille.setBounds(300,215,100,90);
	    perso.setBounds(350, 350, 100, 20);
	    Cb.getBoutonRetour().setBounds(50,400,100,80);
	    Cb.getBoutonRetour().addActionListener(new actionRetour(this));
	    this.add(sliderLevel);
	    this.add(labelTaille);
	    this.add(perso);
	    this.add(Cb.getBoutonRetour());
	    
	    
	    
	}

	public void ajoute(Fenetre fen) {
		// TODO Auto-generated method stub
		//fen.setVisible(false);
		fen.getContentPane().add(this);
	}
	
	class actionRetour implements ActionListener {
		
		MenuJouer1 mj1;
		public actionRetour(MenuJouer1 m) {
			mj1 = m;
		}
		public void actionPerformed(ActionEvent e) {
			mj1.setVisible(false);
			mj1.getMenu().setVisible(true);
			retour();
		}

		
	}
	
	private void retour() {
		// TODO Auto-generated method stub
		//.setVisible(false);
		menu.fen.setContentPane(this.menu);
		System.out.println("c bonnnn");
	}

	/*public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Retour Jouer")){
			
		}
	}
	
	public void retour(Fenetre fen){
		
	}*/
	
}
