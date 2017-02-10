package Com.Model;

import java.util.Random;

import Constante.ConstanteDimension;
import Constante.ConstanteJeux;
import JComponent.Case;

public class GrilleModel extends JeuxModel implements ConstanteJeux, ConstanteDimension {

	public static int[][] tab = new int[nombredecase][nombredeLigne];

	private final static Random RND = new Random();

	public GrilleModel() {
		initGrille();
	}

	private void initGrille() {
		for (int a = 0; a < nombredecase; a++) {
			creercolonne(a);
		}
	}

	private void creercolonne(int a) {
		int val, nombrelignedessin = 2 + RND.nextInt(5 - 0);
		;
		for (int i = 0; i < nombredeLigne; i++) {
			if (nombrelignedessin >= nombredeLigne - i) {
				val = 1 + RND.nextInt(5 - 0);
				tab[a][i] = val;
			} else {
				tab[a][i] = 0;
			}

		}
	}

	private void generationLigne() {
		int val;
		for (int i = 0; i < nombredecase; i++) {
			val = 1 + RND.nextInt(6 - 1);
			tab[i][nombredeLigne - 1] = val;
		}
	}

	public void recupGrille() {
		for (int i = 0; i < nombredeLigne; i++) {
			for (int a = 0; a < nombredecase; a++) {
				this.UpdateCase(i, a, tab[a][i]);
			}
		}
	}

	public static void swapCase(int x1, int x2, int y1) {
		int tmp = tab[x1][y1];
		tab[x1][y1] = tab[x2][y1];
		tab[x2][y1] = tmp;
		JeuxModel.UpdateSwapHorizontal(x1, x2, y1);
		decendreCube();
	}

	private static void decendreCube() {
		int tmp;
		for (int i = 0; i < nombredeLigne - 1; i++) {
			for (int a = 0; a < nombredecase; a++) {
				if (tab[a][i + 1] == 0 && tab[a][i] != 0) {
					tmp = tab[a][i];
					tab[a][i] = tab[a][i + 1];
					tab[a][i + 1] = tmp;
					JeuxModel.UpdateSwapVertical(a, i, i + 1);
					i = 0;
				}
			}
		}
	}

	static void affiche() {
		for (int i = 0; i < nombredeLigne; i++) {
			for (int a = 0; a < nombredecase; a++) {
				System.out.print(tab[a][i] + " ");
			}
			System.out.println();
		}
	}

	public void ajoutGrille() {
		int tmp;
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

	public static boolean comboColonne() {
		affiche();
		int nb = 1;
		int prec;
		boolean changement = false;
		System.out.println(nombredeLigne - 1 - reserve);
		for (int a = 0; a < nombredecase; a++) {
			prec = tab[a][0];
			nb = 1;
			for (int i = 1; i <= nombredeLigne - 1 - reserve; i++) {
				if (prec != 0 && prec == tab[a][i]) {
					nb++;
				} 
				if(nb >=4 && a == (nombredecase-1) ){
					supprimerCaseColonne(a, (i - nb), i);
					changement = true;
				}
				if(prec != tab[a][i]) {
					if (nb >= 4) {
						supprimerCaseColonne(a, (i - nb), i);
						changement = true;
					}
					prec = tab[a][i];
					nb = 1;
				}
			}
		}
		return changement;
	}

	private static void supprimerCaseColonne(int colonne, int indicedepart, int indicefin) {
		for (int i = indicedepart; i < indicefin; i++) {
			tab[colonne][i] = 0;
			JeuxModel.UpdateCase(i, colonne, tab[colonne][i]);
		}
		decendreCube();
		decendreCube();
	}
	
	private static void supprimerCaseLigne(int ligne, int indicedepart, int indicefin) {
		for (int i = indicedepart; i < indicefin; i++) {
			tab[i][ligne] = 0;
			JeuxModel.UpdateCase(ligne,i,tab[i][ligne]);
		}
		decendreCube();
		decendreCube();
	}

	public static boolean comboLigne() {
		System.out.println("ligne >>>>>>>>>>>>>><");
		int nb = 1;
		int prec;
		boolean changement = false;
		for (int i = 1; i <= nombredeLigne - 1 - reserve; i++) {
			prec = tab[0][i];
			nb = 1;
			for (int a = 0; a < nombredecase; a++) {
				if (prec != 0 && prec == tab[a][i]) {
					nb++;
				} 
				if(nb >=4 && a == (nombredecase-1) ){
					supprimerCaseLigne(i, (a - (nb-1)), a);
					changement = true;
					System.out.println("coucou2");
				}
				if(prec != tab[a][i]) {
					if (nb >=4) {
						supprimerCaseLigne(i, (a - (nb-1)), a);
						changement = true;
						System.out.println("coucou");
					}
					prec = tab[a][i];
					nb = 1;
				}
			}
		}
		return changement;
	}

}
