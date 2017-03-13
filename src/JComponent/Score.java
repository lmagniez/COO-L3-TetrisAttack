package JComponent;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Constante.ConstanteDimension;
import Constante.ConstanteJeux;
import Ecran.Animation;

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
	
	
	public Score(JPanel vue, int posX, int posY, boolean highScore, int nbChiffresScore){
		
		this.vue=vue;
		
		this.nbChiffresScore=nbChiffresScore;
		
		posChiffreX=new int[nbChiffresScore];
		posChiffreY=new int[nbChiffresScore];
		
		
		if(highScore) chiffreImg=new ImageIcon("./ressources/Game/Chiffres/chiffresRouge.png").getImage();
		else chiffreImg=new ImageIcon("./ressources/Game/Chiffres/chiffresBleu.png").getImage();
			
			
		this.score=0;
		for(int i=0; i<nbChiffresScore; i++){
			
			posChiffreX[i]=posX+15*i;
			posChiffreY[i]=posY;
			this.chiffres[i]=new Animation(chiffreImg, posChiffreX[i], posChiffreY[i], widthChiffre, heightChiffre, screenwidthchiffre,
					screenheightchiffre, cptchiffre[0], NB_CHIFFRE, vue);
		
		}
				
	}
	
	public void setScore(int score){
		this.score=score;
		
		System.out.println("setScore "+score);
		
		for(int i=0; i<nbChiffresScore; i++){
			chiffres[0].setCpt(0);
		}
		
		String scr=score+"";
		
		int cpt=nbChiffresScore-1;
		for(int i=scr.length()-1;i>=0;i--){
			chiffres[cpt--].setCpt(Integer.parseInt(""+scr.charAt(i)));
			
		}
		
	}
	
	public void draw(Graphics g){
		for(int i=0; i<nbChiffresScore; i++){
			chiffres[i].draw(g);
		}
	}
	
	
}
