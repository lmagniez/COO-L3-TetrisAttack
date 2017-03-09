package Run;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Com.Vue.Jeux1j;
import Com.Vue.Jeux2j;
import Constante.ConstanteDimension;
import Constante.ConstanteMusique;
import Constante.ConstanteParametres;
import Ecran.menu.EcranMenu;
import Ecran.titre.EcranTitre;

public class Fenetre extends JFrame implements ConstanteDimension {

	private Jeux1j j1;
	private Jeux2j j2;
	protected EcranMenu m;

	protected EcranTitre title = new EcranTitre(this);

	public Fenetre() throws ParseException {

		this.setTitle("Tetris Attack");
		this.setSize(DimensionFenetrex, DimensionFenetrey);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setFocusable(true);

		this.m = new EcranMenu(this);

		Sound.changerMusique(ConstanteMusique.MUSIQUE_TITRE);
		
		this.add(title);
		this.setVisible(true);
		title.requestFocus();
	}

	/**
	 * Méthode générique affichant un panneau sur la fenêtre
	 * 
	 * @param p
	 */
	public void afficherPanneau(JPanel p) {
		getContentPane().removeAll();
		getContentPane().repaint();
		getContentPane().add(p);
		getContentPane().validate();

		p.setVisible(true);
		this.repaint();

	}

	public void afficheMenu() {
		swapEcran(getM());
	}

	public void afficheJeu1J(int indiceTheme) {
		this.setFocusable(false);
		j1= new Jeux1j(this,indiceTheme);
		swapEcran(j1);
		j1.lancementAnimation();
		j1.focus();
		j1.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				j1.GestionClavier(e);
			}
		});
	}
	
	public void afficheJeu2J() {
		j2= new Jeux2j(this);
		swapEcran(j2);
		this.setFocusable(false);
		j2.lancementAnimation();
		j2.focus();
		j2.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				j2.GestionClavier(e);
			}
		});
	}

	public void swapEcran(JPanel j) {
		//this.removeAll();
		
		getContentPane().removeAll();
		getContentPane().revalidate();
		getContentPane().repaint();
		
		this.add(j);
		
		//this.revalidate();
		//this.repaint();
		
		//validate();
	}

	public EcranMenu getM() {
		return m;
	}

}
