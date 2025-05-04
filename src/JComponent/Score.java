package JComponent;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Constante.ConstanteDimension;
import Constante.ConstanteJeux;
import Ecran.Animation;

/**
 * Afficher une suite de nombres dans la vue
 * @author loick
 *
 */
public class Score {

	protected int score;
	protected JPanel vue;
	
	protected Animation chiffres[]=new Animation[6];
	
	private Image chiffreImg;
	
	private static int NB_CHIFFRE=10;
	
	private int[] cptchiffre={0,0,0,0,0,0}; 
	private int widthChiffre=8, heightChiffre=13,
	screenwidthchiffre=widthChiffre*2, screenheightchiffre=heightChiffre*2;
	private int posChiffreX[], posChiffreY[];
	int nbChiffresScore;
	
	/**
	 * Constructer
	 * @param vue vue
	 * @param posX position X 
	 * @param posY position Y
	 * @param highScore couleur rouge si true
	 * @param nbChiffresScore nombre de chiffres
	 */
	public Score(JPanel vue, int posX, int posY, boolean highScore, int nbChiffresScore){
		
		this.vue=vue;
		
		this.nbChiffresScore=nbChiffresScore;
		
		posChiffreX=new int[nbChiffresScore];
		posChiffreY=new int[nbChiffresScore];
		
		
		if(highScore) chiffreImg=new ImageIcon(getClass().getResource("/Ressource/Game/Chiffres/chiffresRouge.png")).getImage();
		else chiffreImg=new ImageIcon(getClass().getResource("/Ressource/Game/Chiffres/chiffresBleu.png")).getImage();
			
			
		this.score=0;
		for(int i=0; i<nbChiffresScore; i++){
			
			posChiffreX[i]=posX+15*i;
			posChiffreY[i]=posY;
			this.chiffres[i]=new Animation(chiffreImg, posChiffreX[i], posChiffreY[i], widthChiffre, heightChiffre, screenwidthchiffre,
					screenheightchiffre, cptchiffre[0], NB_CHIFFRE, vue);
		
		}
				
	}
	
	/**
	 * Modifier le score
	 * @param score valeur du score
	 */
	public void setScore(int score){
		this.score=score;
		
		for(int i=0; i<nbChiffresScore; i++){
			chiffres[i].setCpt(0);
		}
		
		String scr=score+"";
		
		int cpt=nbChiffresScore-1;
		for(int i=scr.length()-1;i>=0;i--){
			chiffres[cpt--].setCpt(Integer.parseInt(""+scr.charAt(i)));
		}
		this.vue.repaint();
		
	}
	
	public void draw(Graphics g){
		for(int i=0; i<nbChiffresScore; i++){
			chiffres[i].draw(g);
		}
	}
	
	
}
