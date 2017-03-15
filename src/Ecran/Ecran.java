package Ecran;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;

import Run.Fenetre;

/**
 * Classe abstraite d'un écran.
 * Dispose d'une grille de boutons et sont gérés depuis la classe GestionBouton
 * @author loick
 *
 */
public abstract class Ecran extends JPanel {

	protected int NB_BUTTONS_X;
	protected int NB_BUTTONS_Y;
	protected JComponent buttons[][];
	protected int[][] posButtonX;
	protected int[][] posButtonY;
	protected Fenetre vue;

	/**
	 * Ajouter les listeners aux boutons
	 */
	public void addListener() {
		for (int i = 0; i < NB_BUTTONS_X; i++) {
			for (int j = 0; j < NB_BUTTONS_Y; j++) {
				if (getButtons()[i][j] instanceof JButton)
					((AbstractButton) getButtons()[i][j]).addActionListener(new ButtonListener());
				if (getButtons()[i][j] instanceof JComboBox)
					((JComboBox) getButtons()[i][j]).addActionListener(new ComboBoxListener());

			}
		}
		GestionBouton.ajoutListenerBouton(getButtons());

	}

	/**
	 * Changer d'écran
	 * @param c nouvel écran
	 */
	public void focusNouvelEcran(Ecran c) {

		for (int i = 0; i < NB_BUTTONS_X; i++) {
			for (int j = 0; j < NB_BUTTONS_Y; j++) {
				getButtons()[i][j].setEnabled(false);
				getButtons()[i][j].setForeground(Color.BLACK);
			}
		}

		for (int i = 0; i < c.NB_BUTTONS_X; i++) {
			for (int j = 0; j < c.NB_BUTTONS_Y; j++) {
				c.getButtons()[i][j].setEnabled(true);
				c.getButtons()[i][j].setForeground(Color.BLACK);
			}
		}

		vue.afficherPanneau(c);

		this.setVisible(false);
		c.setVisible(true);

		c.getButtons()[0][0].requestFocus();
		c.getButtons()[0][0].setForeground(Color.GREEN);

	}

	public JComponent[][] getButtons() {
		return buttons;
	}

	public void setButtons(JComponent buttons[][]) {
		this.buttons = buttons;
	}

	/**
	 * Listener pour un bouton
	 * @author loick
	 *
	 */
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < NB_BUTTONS_X; i++)
				for (int j = 0; j < NB_BUTTONS_Y; j++)
					getButtons()[i][j].setForeground(Color.BLACK);

			JButton b = ((JButton) e.getSource());
			b.setForeground(Color.GREEN);
			b.requestFocus();	
		}
	}

	/**
	 * Listener pour une comboBox
	 * @author loick
	 *
	 */
	class ComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			repaint();

			for (int i = 0; i < NB_BUTTONS_X; i++)
				for (int j = 0; j < NB_BUTTONS_Y; j++)
					getButtons()[i][j].setForeground(Color.BLACK);

			JComboBox b = ((JComboBox) e.getSource());
			b.setForeground(Color.GREEN);
			b.requestFocus();

		}
	}

}
