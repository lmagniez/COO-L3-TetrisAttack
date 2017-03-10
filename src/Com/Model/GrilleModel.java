package Com.Model;

import java.util.Random;

import Com.Observer.Observer;
import Constante.ConstanteDimension;
import Constante.ConstanteJeux;

public class GrilleModel implements ConstanteJeux, ConstanteDimension {

	private Observer joueurVue;

	public CaseModel[][] tab = new CaseModel[nombredecase][nombredeLigne];
	public int score = 0;
	private int id;

	private final Random RND = new Random();

	public GrilleModel(int id) {
		this.id = id;
		for(int i=0; i<nombredecase; i++){
			for(int j=0; j<nombredeLigne; j++){
				tab[i][j]=new CaseModel(i,j);
			}
				
		}
		initGrille();
	}

	public void initGrille() {
		for (int a = 0; a < nombredecase; a++) {
			creercolonne(a);
		}
	}

	/**
	 * Initialisation? Création de colonne
	 * @param a abscisse
	 */
	public void creercolonne(int a) {
		int val, nombrelignedessin = 2 + RND.nextInt(5 - 0);
		;
		for (int i = 0; i < nombredeLigne; i++) {
			if (nombrelignedessin >= nombredeLigne - i) {
				val = 1 + RND.nextInt(5 - 0);
				tab[a][i].v = ValeurCase.fromInteger(val);
			} else {
				tab[a][i].v = ValeurCase.VIDE;
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
			tab[i][nombredeLigne - 1].v = ValeurCase.fromInteger(val);
		}
	}

	/**
	 * Envoi la grille du modèle à la vue
	 */
	public void recupGrille() {
		for (int i = 0; i < nombredeLigne; i++) {
			for (int a = 0; a < nombredecase; a++) {
				this.UpdateCase(i, a, tab[a][i].v);
			}
		}
	}

	/**
	 * Faire descendre les blocs (/!\ cas des blocs gris)
	 */
	public void descendreCube() {
		ValeurCase tmp;
		for (int i = 0; i < nombredeLigne - 1; i++) {
			for (int a = 0; a < nombredecase; a++) {
				if (tab[a][i + 1].v == ValeurCase.VIDE && tab[a][i].v != ValeurCase.VIDE) {
					tmp = tab[a][i].v;
					tab[a][i].v = tab[a][i + 1].v;
					tab[a][i + 1].v = tmp;
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
				tmp = tab[a][i + 1].v;
				tab[a][i + 1].v = tab[a][i].v;
				tab[a][i].v = tmp;
			}
		}
		generationLigne();
		recupGrille();
	}

	/**
	 * Execute l'ensemble des suppressions en colonne et calcule les combos
	 * @return vrai si changement
	 */
	public boolean comboColonne() {
		int nb = 1;
		ValeurCase prec;
		boolean changement = false;
		for (int a = 0; a < nombredecase; a++) {
			prec = tab[a][0].v;
			for (int i = 1; i <= nombredeLigne - reserve ; i++) {
				if (prec != ValeurCase.VIDE && prec == tab[a][i].v) { //changemement
					nb++;
				}
				if(prec != tab[a][i].v || i==(nombredeLigne - reserve)){
					if(i==(nombredeLigne - reserve - 1) && nb>=nbCaseCombo){
						
						changement=true;
						//ici
						supprimerCaseColonne(a,nb,i); //derniere case soit la case ou on est 
					}
					else if(nb>=nbCaseCombo){
						changement=true;
						supprimerCaseColonne(a,nb,i-1); //case d'avant pour les cases du mileu
					}
					prec = tab[a][i].v;
					nb=1;
				}
			}
		}
		joueurVue.score(id,score);
		return changement;
	}

	
	/**
	 * Supprimer les cases d'une colonne (bas vers haut)
	 * @param colonne id de la colonne
	 * @param nbblock nombre de cases a supprimer
	 * @param indicefin indice de départ (bas)
	 */
	public void supprimerCaseColonne(int colonne, int nbbloc, int indicefin) {
		for (int i = indicefin; i > (indicefin-nbbloc); i--) {
			tab[colonne][i].v = ValeurCase.VIDE;
			this.UpdateCase(i, colonne, tab[colonne][i].v);
		}
		descendreCube();
	}

	/**
	 * Supprimer les cases d'une ligne (droite vers gauche)
	 * @param ligne id de la ligne
	 * @param nbblock nombre de cases a supprimer
	 * @param indicefin indice de départ (droite)
	 */
	public void supprimerCasesLigne(int ligne, int nbblock, int indicefin) {
		for (int i = indicefin; i > (indicefin-nbblock); i--) {
			tab[i][ligne].v = ValeurCase.VIDE;
			this.UpdateCase(ligne, i, tab[i][ligne].v);
		}
		this.descendreCube();
	}

	/**
	 * Execute l'ensemble des suppressions en ligne et calcule les combos
	 * @return vrai si changement
	 */
	public boolean comboLigne() {
		int nb = 1;
		ValeurCase prec;
		boolean changement = false;
		for (int i = 1; i <= nombredeLigne - reserve - 2 ; i++) {
			prec = tab[0][i].v;
			for (int a = 1; a < nombredecase; a++) {
				if (prec != ValeurCase.VIDE && prec == tab[a][i].v) { //changemement
					nb++;
				}
				if(prec != tab[a][i].v || a==nombredecase-1){
					if(a==nombredecase-1 && nb>=nbCaseCombo){
						changement=true;
						supprimerCasesLigne(i,nb,a); //derniere case soit la case ou on est 
					}
					else if(nb>=nbCaseCombo){
						changement=true;
						supprimerCasesLigne(i,nb,a-1); //case d'avant pour les cases du mileu
					}
					prec = tab[a][i].v;
					nb=1;
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
		boolean chang=true;
		this.comboColonne(); this.comboLigne();
		
	}
	
	/**
	 * Swap entre deux cases adjacentes horizontalement
	 * @param x1
	 * @param x2
	 * @param y1
	 */
	public void swapCase(int x1, int x2, int y1) {
		ValeurCase tmp = tab[x1][y1].v;
		tab[x1][y1].v = tab[x2][y1].v;
		tab[x2][y1].v = tmp;
		this.UpdateSwapHorizontal(x1, x2, y1);
		this.descendreCube();
	}

	public void monteGrilleGraphique() {
		joueurVue.bougerGrilleGraphique();
	}
}
