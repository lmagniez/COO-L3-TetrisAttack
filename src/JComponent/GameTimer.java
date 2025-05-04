package JComponent;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Constante.ConstanteDimension;
import Ecran.Animation;

/**
 * Timer dans la vue
 * @author loick
 *
 */
public class GameTimer {

	protected String minutes;
	protected String secondes;
	protected JPanel vue;
	
	protected Animation chiffres[]=new Animation[5];
	
	private Image chiffreImg;
	private Image virguleImg;
	
	private static int NB_CHIFFRE=10;
	private static int NB_VIRGULE=1;
	
	private int[] cptchiffre={0,0,0,0,0}; 
	private int widthChiffre=8, heightChiffre=13,
	screenwidthchiffre=widthChiffre*2, screenheightchiffre=heightChiffre*2;
	private int posChiffreX[]=new int[5],
			posChiffreY[]=new int[5];
	
	/**
	 * Constructeur
	 * @param vue vue
	 * @param posX position X
	 * @param posY position Y
	 */
	public GameTimer(JPanel vue, int posX, int posY ){
		
		this.vue=vue;
		
		chiffreImg=new ImageIcon(getClass().getResource("/Ressource/Game/Chiffres/chiffresRouge.png")).getImage();
		virguleImg=new ImageIcon(getClass().getResource("/Ressource/Game/Chiffres/virgule.png")).getImage();
		
		
		this.minutes="00";
		this.secondes="00";
		for(int i=0; i<5; i++){
			
			posChiffreX[i]=posX+15*i;
			posChiffreY[i]=posY;
			this.chiffres[i]=new Animation(chiffreImg, posChiffreX[i], posChiffreY[i], widthChiffre, heightChiffre, screenwidthchiffre,
					screenheightchiffre, cptchiffre[0], NB_CHIFFRE, vue);
		
		}
		chiffres[2].setNbImage(NB_VIRGULE);
		chiffres[2].setImg(virguleImg);
				
	}
	
	/**
	 * Mettre à jour le timer
	 * @param minutes minute
	 * @param secondes seconde
	 */
	public void setTime(String minutes, String secondes){
		this.minutes=minutes;
		this.secondes=secondes;
		
		chiffres[0].setCpt(Integer.parseInt(""+minutes.charAt(0)));
		chiffres[1].setCpt(Integer.parseInt(""+minutes.charAt(1)));
		chiffres[3].setCpt(Integer.parseInt(""+secondes.charAt(0)));
		chiffres[4].setCpt(Integer.parseInt(""+secondes.charAt(1)));
		
	}
	
	public void draw(Graphics g){
		for(int i=0; i<5; i++){
			chiffres[i].draw(g);
		}
	}
	
	
}
