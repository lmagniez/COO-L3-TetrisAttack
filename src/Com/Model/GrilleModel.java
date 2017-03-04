package Com.Model;

import java.util.Random;

import Com.Observer.Observer;
import Constante.ConstanteDimension;
import Constante.ConstanteJeux;

public class GrilleModel implements ConstanteJeux, ConstanteDimension {

	private Observer joueurVue;

	public ValeurCase[][] tab = new ValeurCase[nombredecase][nombredeLigne];
	public int score = 0;
	private int id;

	private final Random RND = new Random();

	public GrilleModel(int i) {
		id = i;
		initGrille();
	}

	private void initGrille() {
		for (int a = 0; a < nombredecase; a++) {
			creercolonne(a);
		}
	}

	/**
	 * Initialisation? Création de colonne
	 * @param a abscisse
	 */
	private void creercolonne(int a) {
		int val, nombrelignedessin = 2 + RND.nextInt(5 - 0);
		;
		for (int i = 0; i < nombredeLigne; i++) {
			if (nombrelignedessin >= nombredeLigne - i) {
				val = 1 + RND.nextInt(5 - 0);
				tab[a][i] = ValeurCase.fromInteger(val);
			} else {
				tab[a][i] = ValeurCase.VIDE;
			}

		}
	}

	/**
	 * Génére une ligne aléatoire et l'ajoute au fond de la grille
	 */
	private void generationLigne() {
		int val;
		for (int i = 0; i < nombredecase; i++) {
			val = 1 + RND.nextInt(6 - 1);
			tab[i][nombredeLigne - 1] = ValeurCase.fromInteger(val);
		}
	}

	/**
	 * Envoi la grille du modèle à la vue
	 */
	public void recupGrille() {
		for (int i = 0; i < nombredeLigne; i++) {
			for (int a = 0; a < nombredecase; a++) {
				this.UpdateCase(i, a, tab[a][i]);
			}
		}
	}

	/**
	 * Swap entre deux cases adjacentes horizontalement
	 * @param x1
	 * @param x2
	 * @param y1
	 */
	public void swapCase(int x1, int x2, int y1) {
		ValeurCase tmp = tab[x1][y1];
		tab[x1][y1] = tab[x2][y1];
		tab[x2][y1] = tmp;
		this.UpdateSwapHorizontal(x1, x2, y1);
		this.decendreCube();
	}

	private void decendreCube() {
		ValeurCase tmp;
		for (int i = 0; i < nombredeLigne - 1; i++) {
			for (int a = 0; a < nombredecase; a++) {
				if (tab[a][i + 1] == ValeurCase.VIDE && tab[a][i] != ValeurCase.VIDE) {
					tmp = tab[a][i];
					tab[a][i] = tab[a][i + 1];
					tab[a][i + 1] = tmp;
					this.UpdateSwapVertical(a, i, i + 1);
					i = 0;
				}
			}
		}
	}

	public void ajoutGrille() {
		ValeurCase tmp;
		for (int i = 0; i < nombredeLigne - 1; i++) {
			for (int a = 0; a < nombredecase; a++) {
				tmp = tab[a][i + 1];
				tab[a][i + 1] = tab[a][i];
				tab[a][i] = tmp;
			}
		}
		generationLigne();
		recupGrille();
	}

	public boolean comboColonne() {
		int nb = 1;
		ValeurCase prec;
		boolean changement = false;
		for (int a = 0; a < nombredecase; a++) {
			prec = tab[a][0];
			nb = 1;
			for (int i = 1; i <= nombredeLigne - reserve; i++) {
				if (prec != ValeurCase.VIDE && prec == tab[a][i]) {
					nb++;
				}
				if (nb >= 3 && a == (nombredecase - 1)) {
					score += nb * scorepoint;
					supprimerCaseColonne(a, (i - nb), i);
					changement = true;
				}
				if (prec != tab[a][i]) {
					if (nb >= 3) {
						score += nb * scorepoint;
						supprimerCaseColonne(a, (i - nb), i);
						changement = true;
					}
					prec = tab[a][i];
					nb = 1;
				}
			}
		}
		joueurVue.score(id,score);
		return changement;
	}

	private void supprimerCaseColonne(int colonne, int indicedepart, int indicefin) {
		for (int i = indicedepart; i < indicefin; i++) {
			tab[colonne][i] = ValeurCase.VIDE;
			this.UpdateCase(i, colonne, tab[colonne][i]);
		}
		decendreCube();
		decendreCube();
	}

	private void supprimerCaseLigne(int ligne, int indicedepart, int indicefin) {
		for (int i = indicedepart; i < indicefin; i++) {
			tab[i][ligne] = ValeurCase.VIDE;
			this.UpdateCase(ligne, i, tab[i][ligne]);
		}
		decendreCube();
		decendreCube();
	}

	public boolean comboLigne() {
		int nb = 1;
		ValeurCase prec;
		boolean changement = false;
		for (int i = 1; i <= nombredeLigne - 1 - reserve; i++) {
			prec = tab[0][i];
			nb = 1;
			for (int a = 0; a < nombredecase; a++) {
				if (prec != ValeurCase.VIDE && prec == tab[a][i]) {
					nb++;
				}
				if (nb >= 3 && a == (nombredecase - 1)) {
					score += nb * scorepoint;
					supprimerCaseLigne(i, (a - (nb - 1)), a);
					changement = true;
				}
				if (prec != tab[a][i]) {
					if (nb >= 3) {
						score += nb * scorepoint;
						supprimerCaseLigne(i, (a - (nb - 1)), a);
						changement = true;
					}
					prec = tab[a][i];
					nb = 1;
				}
			}
		}
		joueurVue.score(id, score);
		return changement;
	}

	public void UpdateCase(int y, int x, ValeurCase tab2) {
		joueurVue.updateCase(id, y, x, tab2);
	}

	public void UpdateSwapHorizontal(int x1, int x2, int y) {
		joueurVue.swaphorizontal(id, x1, x2, y);
	}

	public void UpdateSwapVertical(int x, int y1, int y2) {
		joueurVue.swapvertical(id, x, y1, y2);
	}

	public void add(Observer joueurVue) {
		this.joueurVue = joueurVue;
	}

	public void swap(int x1, int x2, int y1) {
		this.swapCase(x1, x2, y1);
		while (this.comboColonne()) {
		}
		while (this.comboLigne()) {
		}
	}
}
