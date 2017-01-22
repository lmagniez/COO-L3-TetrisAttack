package Ecran;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import Run.Fenetre;

public class EcranTitre extends JPanel implements ActionListener{
	
	private Fenetre f;
	private Image fond;
	
	private Image title;
	private int titlehx=669, titlehy=366;
	
	private Timer timer;
	
	private Image yoshi1;
	private int cptyoshi1=0, widthyoshi1=92, heightyoshi1=131;
	
	private Image yoshi2;
	private int cptyoshi2=0, widthyoshi2=40, heightyoshi2=77;
	
	private Image yoshi3;
	private int cptyoshi3=0, widthyoshi3=38, heightyoshi3=76;
	
	private Image yoshi4;
	private int cptyoshi4=0, widthyoshi4=44, heightyoshi4=96;
	
	private Image yoshi5;
	private int cptyoshi5=0, widthyoshi5=44, heightyoshi5=96;
	
	private Image fleur;
	private int cptfleur=0, widthfleur=50, heightfleur=50;
	
	private Image bulle;
	private int cptbulle=0, widthbulle=35, heightbulle=33, bullex=300, bulley=300;
	
	
	
	
	public static final int NB_IMAGE=5;
	public static final int NB_IMAGE2=6;
	public static final int NB_IMAGE3=6;
	public static final int NB_IMAGE4=5;
	public static final int NB_IMAGE5=5;
	
	public static final int NB_IMAGEFLEUR=2;
	public static final int NB_IMAGEBULLE=2;
	
	
	
	
	
	public EcranTitre()
	{
		Toolkit.getDefaultToolkit().sync();
		//fond= Toolkit.getDefaultToolkit().createImage("r")
		fond=new ImageIcon("./ressources/Accueil/accueil.png").getImage();
		title=new ImageIcon("./ressources/Accueil/title.png").getImage();
		
		yoshi1=new ImageIcon("./ressources/Accueil/Yoshi1/feuille.png").getImage();
		yoshi2=new ImageIcon("./ressources/Accueil/Yoshi2/spriteSheet.png").getImage();
		yoshi3=new ImageIcon("./ressources/Accueil/Yoshi3/spriteSheet.png").getImage();
		yoshi4=new ImageIcon("./ressources/Accueil/Yoshi4/spriteSheet.png").getImage();
		yoshi5=new ImageIcon("./ressources/Accueil/Yoshi4/spriteSheet2.png").getImage();
		
		fleur=new ImageIcon("./ressources/Accueil/fleur.png").getImage();
		bulle=new ImageIcon("./ressources/Accueil/bulle.png").getImage();
		
		
		
		this.setLayout(new FlowLayout());
		timer = new Timer(100, this);
		timer.start();
	
        
		this.revalidate();
		this.repaint();
		
		
    }
		
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == timer){
			repaint();
			cptyoshi1 = (cptyoshi1 + 1) % NB_IMAGE;
			cptyoshi2 = (cptyoshi2 + 1) % NB_IMAGE2;
			cptyoshi3 = (cptyoshi3 + 1) % NB_IMAGE3;
			cptyoshi4 = (cptyoshi4 + 1) % NB_IMAGE4;
			cptyoshi5 = (cptyoshi5 + 1) % NB_IMAGE5;
			
			cptfleur = (cptfleur + 1) % NB_IMAGEFLEUR;
			cptbulle = (cptbulle + 1) % NB_IMAGEBULLE;
			bullex = (bullex - 3);
			if(bullex<0)
				bullex+=getWidth();
			bulley = (bulley - 3);
			if(bulley<0)
				bulley+=getHeight();
			
		}
		else if (e.getActionCommand().equals("arreter")) timer.stop();
		else if (e.getActionCommand().equals("reprendre")) timer.restart();
	}


	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(title, 100, 100, titlehx/2, titlehy/2, this);
		//cropped.getGraphics()
	    
		g.drawImage(yoshi1, 500, 500, 500-widthyoshi1, 500-heightyoshi1,
	    		widthyoshi1*(cptyoshi1+1), heightyoshi1, 
	    		widthyoshi1*(cptyoshi1), 0, this);
	    
	    g.drawImage(yoshi2, 100, 200, 100-widthyoshi2, 200-heightyoshi2,
	    		widthyoshi2*(cptyoshi2+1), heightyoshi2, 
	    		widthyoshi2*(cptyoshi2), 0, this);
	    
	    g.drawImage(yoshi3, 300, 300, 300-widthyoshi3, 300-heightyoshi3,
	    		widthyoshi3*(cptyoshi3+1), heightyoshi3, 
	    		widthyoshi3*(cptyoshi3), 0, this);
	    
	    g.drawImage(yoshi4, 500, 300, 500-widthyoshi4, 300-heightyoshi4,
	    		widthyoshi4*(cptyoshi4+1), heightyoshi4, 
	    		widthyoshi4*(cptyoshi4), 0, this);
	    
	    g.drawImage(yoshi5, 300, 500, 300-widthyoshi5, 500-heightyoshi5,
	    		widthyoshi5*(cptyoshi5+1), heightyoshi5, 
	    		widthyoshi5*(cptyoshi5), 0, this);
	    
	    g.drawImage(fleur, 150, 500, 150-(widthfleur*2), 500-(heightfleur*2),
	    		widthfleur*(cptfleur+1), heightfleur, 
	    		widthfleur*(cptfleur), 0, this);
	    
	    g.drawImage(bulle, bullex, bulley, bullex-(widthbulle*2), bulley-(heightbulle*2),
	    		widthbulle*(cptbulle+1), heightbulle, 
	    		widthbulle*(cptbulle), 0, this);
	    
	    
	   
		
	}
}