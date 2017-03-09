package Ecran.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

import Bouton.Commande;
import Bouton.JoueurIcon;
import Constante.ConstanteDimension;
import Constante.ConstanteParametres;
import Run.Fenetre;
import Run.Sound;

public class PanelMenu8 extends PanelMenu implements ActionListener {

	private JButton[] icon1 = new JoueurIcon[6];
	private JButton[] icon2 = new JoueurIcon[6];

	private Boolean[] tabIcon = { false, false };
	private int cptButton = 0;

	public PanelMenu8(Fenetre vue, EcranMenu e) {

		this.ecran = e;
		this.vue = vue;
		this.pred_panel = this.ecran.p2;

		this.has_cursor = false;
		NB_BUTTONS_Y = 3;
		NB_BUTTONS_X = 4;
		buttons = new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];

		posButtonX = new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonY = new int[NB_BUTTONS_X][NB_BUTTONS_Y];

		for (int i = 0; i < NB_BUTTONS_X; i++) {
			posButtonX[i][0] = ConstanteDimension.DimensionFenetrex * 1 / 7;
			posButtonY[i][0] = 180 + 50 * i;
		}

		this.fond = new ImageIcon("./ressources/Menu/menuframe.png").getImage();
		this.setBounds(ConstanteDimension.DimensionFenetrex / 5, (ConstanteDimension.DimensionFenetrey / 6) + 20, 300, 430);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setOpaque(false);
		creationIcon();
		ajout();
	}

	private void creationIcon() {
		for (int i = 0; i < 6; i++) {
			icon1[i] = new JoueurIcon(this, i, 1);
			icon2[i] = new JoueurIcon(this, i, 2);
		}
	}

	private void ajout() {

		for (int i = 0; i < 3; i++) {
			buttons[cptButton][i] = icon1[i];
		}

		cptButton++;
		for (int i = 0; i < 3; i++) {
			buttons[cptButton][i] = icon1[i + 3];
		}

		cptButton++;
		for (int i = 0; i < 3; i++) {
			buttons[cptButton][i] = icon2[i];
		}

		cptButton++;
		for (int i = 0; i < 3; i++) {
			buttons[cptButton][i] = icon2[i + 3];
		}

		// Joueur1
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		Box rowOne = Box.createHorizontalBox();
		for (int i = 0; i < 3; i++) {
			rowOne.add(icon1[i]);
			rowOne.add(Box.createRigidArea(new Dimension(10, 0)));
			this.add(rowOne);
		}

		this.add(Box.createRigidArea(new Dimension(10, 20)));

		Box rowtwo = Box.createHorizontalBox();
		for (int i = 0; i < 3; i++) {
			rowtwo.add(icon1[i + 3]);
			rowtwo.add(Box.createRigidArea(new Dimension(10, 0)));
			this.add(rowtwo);
		}

		// Joueur 2
		this.add(Box.createRigidArea(new Dimension(0, 27)));

		Box rowOnebis = Box.createHorizontalBox();
		for (int i = 0; i < 3; i++) {
			rowOnebis.add(icon2[i]);
			rowOnebis.add(Box.createRigidArea(new Dimension(10, 0)));
			this.add(rowOnebis);
		}

		this.add(Box.createRigidArea(new Dimension(10, 10)));

		Box rowtwobis = Box.createHorizontalBox();
		for (int i = 0; i < 3; i++) {
			rowtwobis.add(icon2[i + 3]);
			rowtwobis.add(Box.createRigidArea(new Dimension(10, 0)));
			this.add(rowtwobis);
		}

		ecran.setButtons(buttons);
		ecran.addListener();

	}

	public void actionPerformed(ActionEvent e) {
		vue.afficheJeu2J();
		Sound.stop();
		ConstanteParametres.ID_MUSIQUE = 2;
		Sound.loop();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		g.setColor(Color.white);
		g.setFont(new Font("Verdana", Font.BOLD, 20));
		g.drawString("Joueur1", 20, 45);
		g.drawString("Joueur2", 20, 236);

		for (int i = 0; i < buttons.length; i++) {
			for (int a = 0; a < buttons[0].length; a++) {
				if (buttons[i][a].hasFocus()) {
					buttons[i][a].setBorder(BorderFactory.createLineBorder(Color.blue, 5));
				} else {
					buttons[i][a].setBorder(null);
				}
			}
		}
	}
}
