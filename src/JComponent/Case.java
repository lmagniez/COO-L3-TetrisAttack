package JComponent;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import com.Model.ValeurCase;
import Constante.ConstanteDimension;
import Constante.ConstanteJeux;
import Ecran.Animation;

/**
 * Case dans la vue 
 * @author loick
 *
 */
public class Case {
	protected Grille g;
	
	private int x;
	private int y;
	private int tailleX;
	private  int tailleY;
	private ValeurCase valeur;
	
	public Animation animBloc;
	
	private Image blocImg;
	private int cptbloc=0, widthbloc=16, heightbloc=16, 
			screenwidthbloc, screenheightbloc;
	private int posblocY=ConstanteDimension.DimensionFenetrey,
				posblocX=ConstanteDimension.DimensionFenetrex/2+screenwidthbloc/2;
	
	//protected Image[] blocsImg;
	public static int NB_IMAGE=4;
	//blocsImg=new Image[ConstanteJeux.nombreCouleur];

	protected Image vide=new ImageIcon(getClass().getResource("/Ressource/Game/Blocks/vide.png")).getImage();
	protected Image cyan=new ImageIcon(getClass().getResource("/Ressource/Game/Blocks/cyan.png")).getImage();
	protected Image rouge=new ImageIcon(getClass().getResource("/Ressource/Game/Blocks/rouge.png")).getImage();
	protected Image jaune=new ImageIcon(getClass().getResource("/Ressource/Game/Blocks/jaune.png")).getImage();
	protected Image vert=new ImageIcon(getClass().getResource("/Ressource/Game/Blocks/vert.png")).getImage();
	protected Image violet=new ImageIcon(getClass().getResource("/Ressource/Game/Blocks/violet.png")).getImage();
	protected Image bleu=new ImageIcon(getClass().getResource("/Ressource/Game/Blocks/bleu.png")).getImage();
	protected Image gris=new ImageIcon(getClass().getResource("/Ressource/Game/Blocks/grey.png")).getImage();

	protected Image[] blocsImg={vide,cyan,rouge,jaune,vert,violet,bleu,gris};
	
	/**
	 * Constructeur
	 * @param g Grille 
	 * @param a abscisse
	 * @param b ordonnée
	 * @param dimx tailleX
	 * @param dimy tailleY
	 * @param v valeur de la case
	 */
	public Case(Grille g,int a,int b,int dimx,int dimy,ValeurCase v){
		this.g=g;
		screenwidthbloc=g.tailleX(); screenheightbloc=g.tailleY();
		
		x=a;
		y=b;
		tailleX=dimx;
		tailleY=dimy;
		valeur=v;

		blocImg=blocsImg[v.ordinal()];

		setAnimBloc(new Animation(blocImg,0,0,widthbloc,heightbloc,screenwidthbloc,screenheightbloc,cptbloc, NB_IMAGE, g));	
	}

	/**
	 * Constructeur d'une case (clone)
	 * @param case1 case
	 */
	public Case(Case case1) {
		x=case1.x;
		y=case1.y;
		tailleX=case1.tailleX;
		tailleY=case1.tailleY;
		valeur=case1.valeur;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getTailleX() {
		return tailleX;
	}

	public int getTailleY() {
		return tailleY;
	}

	public ValeurCase getValeur() {
		return valeur;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setTailleX(int tailleX) {
		this.tailleX = tailleX;
	}

	public void setTailleY(int tailleY) {
		this.tailleY = tailleY;
	}

	public void setValeur(ValeurCase valeur) {
		this.valeur = valeur;
		blocImg=blocsImg[valeur.ordinal()];
		getAnimBloc().setImg(blocImg);	
	}

	public Animation getAnimBloc() {
		return animBloc;
	}

	public void setAnimBloc(Animation animBloc) {
		this.animBloc = animBloc;

	}
}
