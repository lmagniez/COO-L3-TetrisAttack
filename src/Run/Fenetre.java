package Run;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Constante.ConstanteDimension;
import Ecran.Jeux1j;
import Ecran.menu.EcranMenu;
import Ecran.titre.EcranTitre;

public class Fenetre extends JFrame implements ConstanteDimension {

	private Jeux1j j1 = new Jeux1j(this);
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

		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				Fenetre.this.j1.getG().keyPressed(e);
			}
		});

		j1.focus();

		this.add(j1);

		// this.add(title);
		// this.add(credit);
		this.setVisible(true);
		// title.requestFocus();
		// this.afficherPanneau(m);
		// m.requestFocusInWindow();
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

	public void afficheJeu1J() {
		swapEcran(j1);
	}

	public void swapEcran(JPanel j) {
		getContentPane().removeAll();
		getContentPane().repaint();
		this.add(j);
		validate();
	}

	public EcranMenu getM() {
		return m;
	}

}
