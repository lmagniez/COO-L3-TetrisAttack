package Ecran.titre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Constante.ConstanteDimension;
import Constante.ConstanteMusique;
import Constante.ConstanteParametres;
import Constante.ConstanteSon;
import Ecran.Animation;
import Ecran.Ecran;
import Run.Fenetre;
import Run.Sound;

/**
 * Panel de l'écran titre.
 * Gère une animation.
 * @author loick
 *
 */
public class EcranTitre extends Ecran implements ActionListener, KeyListener{
	
	private Fenetre f;
	private Image fond;
	
	private Image titleImg;
	private int widthtitle=669, heighttitle=366,
			screenwidthtitle=widthtitle*3, screenheighttitle=heighttitle*3;
	private int postitleY=ConstanteDimension.DimensionFenetrey,
			postitleX=ConstanteDimension.DimensionFenetrex/2+screenwidthtitle/2;

	
	private Timer timer;
	
	
	private Animation yoshi1;
	private Image yoshi1Img;
	private int cptyoshi1=0, widthyoshi1=92, heightyoshi1=131, 
			screenwidthyoshi1=widthyoshi1*3, screenheightyoshi1=heightyoshi1*3;
	private int posyoshi1Y=ConstanteDimension.DimensionFenetrey,
				posyoshi1X=ConstanteDimension.DimensionFenetrex/2+screenwidthyoshi1/2;
	
	private Animation yoshi2;	
	private Image yoshi2Img;
	private int cptyoshi2=0, widthyoshi2=40, heightyoshi2=77,
			screenwidthyoshi2=widthyoshi2*3, screenheightyoshi2=heightyoshi2*3;
	private int posyoshi2Y=(int)(ConstanteDimension.DimensionFenetrey*2/3),
			posyoshi2X=ConstanteDimension.DimensionFenetrex*2/3+screenwidthyoshi2/2;

	private Animation yoshi3;
	private Image yoshi3Img;
	private int cptyoshi3=0, widthyoshi3=38, heightyoshi3=76,
			screenwidthyoshi3=widthyoshi3*3, screenheightyoshi3=heightyoshi3*3;
	private int posyoshi3Y=(int)(ConstanteDimension.DimensionFenetrey*2/3),
			posyoshi3X=ConstanteDimension.DimensionFenetrex*1/3+screenwidthyoshi3/2;
	
	
	private Animation yoshi4;
	private Image yoshi4Img;
	private int cptyoshi4=0, widthyoshi4=44, heightyoshi4=96,
	screenwidthyoshi4=widthyoshi4*3, screenheightyoshi4=heightyoshi4*3;
	private int posyoshi4Y=(int)(ConstanteDimension.DimensionFenetrey),
			posyoshi4X=ConstanteDimension.DimensionFenetrex*21/28+screenwidthyoshi4/2;
	
	
	private Animation yoshi5;
	private Image yoshi5Img;
	private int cptyoshi5=0, widthyoshi5=44, heightyoshi5=96,
	screenwidthyoshi5=widthyoshi5*3, screenheightyoshi5=heightyoshi5*3;
	private int posyoshi5Y=(int)(ConstanteDimension.DimensionFenetrey),
			posyoshi5X=ConstanteDimension.DimensionFenetrex*7/28+screenwidthyoshi5/2;
	
	public static final int NB_FLEUR=3;
	private Animation fleur[]= new Animation[NB_FLEUR];
	private Image fleurImg[]=new Image[NB_FLEUR];
	private int fleurx[]={150,140,700};
	private int fleury[]={400,550,550};
	private int cptfleur[]={0,1,1}, widthfleur=50, heightfleur=50;
	
	
	private Image press;
	private int widthPress=79, heightPress=7;
	private int screenwidthpress=widthPress*4, screenheightpress=heightPress*4;
	private int pospressY=ConstanteDimension.DimensionFenetrey*4/5-screenheightpress/2;
	private int pospressX=ConstanteDimension.DimensionFenetrex*1/2-screenwidthpress/2;
	
	
	
	public static final int NB_BULLE=5;
	private Animation bulle[]=new Animation[NB_BULLE];
	private Image bulleImg[]=new Image[NB_BULLE];
	private int bullex[]={300,400,450,600,700};
	private int bulley[]={300,200,650,700,350};
	
	private int cptbulle[]={0,1,1,0,0}, widthbulle=35, heightbulle=33;
	
	
	
	
	public static final int NB_IMAGE=5;
	public static final int NB_IMAGE2=6;
	public static final int NB_IMAGE3=6;
	public static final int NB_IMAGE4=5;
	public static final int NB_IMAGE5=5;
	
	public static final int NB_IMAGEFLEUR=2;
	public static final int NB_IMAGEBULLE=2;
	
	/**
	 * Constructeur
	 * @param f fenetre
	 */
	public EcranTitre(Fenetre f)
	{
		
		this.vue=f;
		
		Toolkit.getDefaultToolkit().sync();
		//fond= Toolkit.getDefaultToolkit().createImage("r")
		fond=new ImageIcon(getClass().getResource("/Ressource/Accueil/accueil.png")).getImage();
		titleImg=new ImageIcon(getClass().getResource("/Ressource/Accueil/title.png")).getImage();
		
		yoshi1Img=new ImageIcon(getClass().getResource("/Ressource/Accueil/Yoshi1/feuille.png")).getImage();
		
		yoshi2Img=new ImageIcon(getClass().getResource("/Ressource/Accueil/Yoshi2/spriteSheet.png")).getImage();
		yoshi3Img=new ImageIcon(getClass().getResource("/Ressource/Accueil/Yoshi3/spriteSheet.png")).getImage();
		yoshi4Img=new ImageIcon(getClass().getResource("/Ressource/Accueil/Yoshi4/spriteSheet.png")).getImage();
		yoshi5Img=new ImageIcon(getClass().getResource("/Ressource/Accueil/Yoshi4/spriteSheet2.png")).getImage();
		
		
		
		//press=new ImageIcon(getClass().getResource("/Ressource/Accueil/pushKey.gif").getImage();
		
		press = new ImageIcon(getClass().getResource("/Ressource/Accueil/pushKey.gif")).getImage();
	    
		
		for(int i=0; i<NB_FLEUR;i++){
			fleurImg[i]=new ImageIcon(getClass().getResource("/Ressource/Accueil/fleur.png")).getImage();
			fleur[i]=new Animation(fleurImg[i], fleurx[i], fleury[i], widthfleur, heightfleur,
					widthfleur, heightfleur, cptfleur[i], NB_IMAGEFLEUR,this);
		}
		for(int i=0; i<NB_BULLE;i++){
			bulleImg[i]=new ImageIcon(getClass().getResource("/Ressource/Accueil/bulle.png")).getImage();
			bulle[i]=new Animation(bulleImg[i],bullex[i],bulley[i],widthbulle,heightbulle,
					widthbulle*2,heightbulle*2,cptbulle[i], NB_IMAGEBULLE, this);
		}
		
		yoshi1= new Animation(yoshi1Img,posyoshi1X,posyoshi1Y,widthyoshi1,heightyoshi1,
				screenwidthyoshi1,screenheightyoshi1,cptyoshi1, NB_IMAGE, this);
		yoshi2= new Animation(yoshi2Img,posyoshi2X,posyoshi2Y,widthyoshi2,heightyoshi2,
				screenwidthyoshi2,screenheightyoshi2,cptyoshi2, NB_IMAGE2, this);
		yoshi3= new Animation(yoshi3Img,posyoshi3X,posyoshi3Y,widthyoshi3,heightyoshi3,
				screenwidthyoshi3,screenheightyoshi3,cptyoshi3, NB_IMAGE3, this);
		yoshi4= new Animation(yoshi4Img,posyoshi4X,posyoshi4Y,widthyoshi4,heightyoshi4,
				screenwidthyoshi4,screenheightyoshi4,cptyoshi4, NB_IMAGE4, this);
		yoshi5= new Animation(yoshi5Img,posyoshi5X,posyoshi5Y,widthyoshi5,heightyoshi5,
				screenwidthyoshi5,screenheightyoshi5,cptyoshi5, NB_IMAGE5, this);
		
		
		
		this.setLayout(new FlowLayout());
		timer = new Timer(100, this);
		timer.start();

        
		this.revalidate();
		this.repaint();
		
		this.addKeyListener(this);
		
		
    }
		
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == timer){
			repaint();
			yoshi1.updateCpt();
			yoshi2.updateCpt();
			yoshi3.updateCpt();
			yoshi4.updateCpt();
			yoshi5.updateCpt();
			
			
			for(int i=0; i<NB_FLEUR; i++)
				fleur[i].updateCpt();
			
			for(int i=0; i<NB_BULLE; i++){
				bulle[i].updateCpt();
				bulle[i].setPosX((bulle[i].getPosX() - 3));
				
				if(bulle[i].getPosX()<0)
					bulle[i].setPosX(bulle[i].getPosX() + getWidth());
				bulle[i].setPosY((bulle[i].getPosY() - 3));
				if(bulle[i].getPosY()<0)
					bulle[i].setPosY(bulle[i].getPosY() + getHeight());
			}
			
		}
		else if (e.getActionCommand().equals("arreter")) timer.stop();
		else if (e.getActionCommand().equals("reprendre")) timer.restart();
		
	}


	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(titleImg, (ConstanteDimension.DimensionFenetrex)/2-widthtitle*1/3, 
				ConstanteDimension.DimensionFenetrey*1/5-heighttitle*1/3, widthtitle*2/3, heighttitle*2/3, this);
		
		//cropped.getGraphics()
	    
		for(int i=0; i<NB_FLEUR; i++){
	    	fleur[i].draw(g);
	    }
		
		yoshi2.draw(g);
		yoshi3.draw(g);
		yoshi4.draw(g);
		yoshi5.draw(g);
		yoshi1.draw(g);
	    
	    
	    for(int i=0; i<NB_BULLE; i++){
	    	bulle[i].draw(g);
	    }
	    
	    g.drawImage(press, this.pospressX, this.pospressY, this.screenwidthpress,this.screenheightpress, this);
	    
	   
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		switch (e.getKeyCode()) {
        	case KeyEvent.VK_M:
        		Sound.changerParam();
        	break;
        	default:
        		Sound.jouerSon(ConstanteSon.PRESS_START);
        		try {
					Thread.sleep(1000);
				} 		catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        		
        		this.focusNouvelEcran(vue.getM());
        		Sound.changerMusique(ConstanteMusique.MUSIQUE_MENU);
        	break;
		}
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}