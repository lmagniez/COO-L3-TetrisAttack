package Com.Model;

import java.util.Random;

import Constante.ConstanteDimension;
import Constante.ConstanteJeux;
import JComponent.Case;

public class GrilleModel extends JeuxModel implements ConstanteJeux,ConstanteDimension {

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
		int val, nblignedessiner = 2 + RND.nextInt(8 - 2);
		for (int i = 0; i < nombredeLigne; i++) {
			val = (i < (nombredeLigne - (reserve + nblignedessiner))) ? 0 : 1 + RND.nextInt(5 - 1);
			tab[a][i] = val;
		}
	}

	private void generationLigne() {
		int val;
		for (int i = 0; i < nombredecase; i++) {
			val = 1 + RND.nextInt(5 - 1);
			tab[i][nombredeLigne - 1] = val;
		}
	}

	public void recupGrille() {
		for (int i = 0; i < nombredeLigne; i++) {
			for (int a = 0; a < nombredecase; a++) {
				this.UpdateCase(i,a,tab[a][i]);
			}
		}
	}

	public static void swapCase(int x1, int x2, int y1) {
		int tmp=tab[x1][y1];
		tab[x1][y1]=tab[x2][y1];
		tab[x2][y1]=tmp;
		JeuxModel.UpdateSwapHorizontal(x1,x2,y1);
	}


}
