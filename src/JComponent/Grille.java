package JComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import Com.Controller.GrilleControler;
import Com.Observer.Observer;
import Constante.ConstanteDimension;
import Constante.ConstanteGraphique;
import Constante.ConstanteJeux;

public class Grille extends JPanel implements ConstanteDimension, ConstanteGraphique, ConstanteJeux {

	private boolean animationHaut = false;
	private boolean gameOver = false;

	public Case[][] tab = new Case[nombredecase][nombredeLigne];

	private GrilleControler controlerGrille;

	private int y;
	private int tailleny, taillenx;

	public Grille(GrilleControler controler) {
		controlerGrille = controler;
		tailleny = DimensionGrilley / (nombredeLigne - 2 * reserve);
		taillenx = DimensionGrillex / nombredecase;

		this.setPreferredSize(new Dimension(DimensionGrillex, DimensionGrilley));
		setBackground(new Color(0, 0, 0, 90));
	}

	public void init() {controlerGrille.initGrille();affiche();}

	/*public void animation() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				int taille = 0;
				while (animationHaut) {
					try {
						for (int a = 0; a < nombredeLigne; a++) {
							for (int i = 0; i < nombredecase; i++) {
								tab[i][a].setY(tab[i][a].getY() - 1);
							}
						}

						if (tab[5][9].getY() % tailleny == 0) {
							//Grille.this.decalagetab();
						}
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					Grille.this.repaint();
				}
			}
		});
		thread.start();
	}*/

	/*
	 * protected void decalagetab() { for (int a = 0; a < nombredeLigne - 1;
	 * a++) { for (int i = 0; i < nombredecase; i++) {
	 * tab[i][a].setValeur(tab[i][a + 1].getValeur()); tab[i][a].setX(tab[i][a +
	 * 1].getX()); tab[i][a].setY(tab[i][a + 1].getY()); if
	 * (((tab[i][a].getValeur() != 0) && (a == 0)) == true) { animationHaut =
	 * false; gameOver = true; break; } } if (gameOver) break; } if (!gameOver)
	 * generationLigne(); }
	 */

	public void swaphorizontal(int x1, int x2, int y) {
		int value = tab[x1][y].getValeur();
		this.tab[x1][y].setValeur(this.tab[x2][y].getValeur());
		this.tab[x2][y].setValeur(value);
	}

	public void swapvertical(int x, int y1, int y2) {
		int value = tab[x][y2].getValeur();
		this.tab[x][y2].setValeur(this.tab[x][y1].getValeur());
		this.tab[x][y1].setValeur(value);
	}
	
	public void affiche(){
		for (int a = 0; a < nombredeLigne - reserve; a++) {
			for (int i = 0; i < nombredecase; i++) {
				 System.out.print(tab[i][a].getValeur()+"  ");
			}
			System.out.println();
		}
	}
	
	
	
	public void dessinerGrille(Graphics g) {
		for (int a = 0; a < nombredeLigne - reserve; a++) {
			for (int i = 0; i < nombredecase; i++) {
				switch (tab[i][a].getValeur()) {
				case 0:
					g.setColor(transparent);
					break;
				case 1:
					g.setColor(couleur1);
					break;
				case 2:
					g.setColor(couleur2);
					break;
				case 3:
					g.setColor(couleur3);
					break;
				case 4:
					g.setColor(couleur4);
					break;

				}
				g.fillRect(PositionGrille1JX+ i * taillenx, PositionGrille1JY +a * tailleny, taillenx, tailleny);
			}
		}
	}

	public int tailleX() {
		return taillenx;
	}

	public int tailleY() {
		return tailleny;
	}

	public void updateCase(int y, int x, int val) {
		tab[x][y] = new Case(x * taillenx, y * tailleny, taillenx, tailleny, val);
	}
}
