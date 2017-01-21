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
	private Timer timer;
	
	private Image yoshi1;
	private int cptyoshi1=0, widthyoshi1=92, heightyoshi1=131;
	//private BufferedImage cropped = new BufferedImage(widthyoshi1, heightyoshi1, BufferedImage.TYPE_FOO);

	
	private Image yoshi2[]=new Image[NB_IMAGE];
	private int cptyoshi2=2, widthyoshi2=92, heightyoshi2=131;
	
	private Image yoshi3[]=new Image[NB_IMAGE2];
	private int cptyoshi3=2, widthyoshi3=40, heightyoshi3=77;
	
	
	
	public static final int NB_IMAGE=5;
	public static final int NB_IMAGE2=6;
	
	
	
	
	
	public EcranTitre()
	{
		Toolkit.getDefaultToolkit().sync();
		//fond= Toolkit.getDefaultToolkit().createImage("r")
		fond=new ImageIcon("./ressources/Accueil/accueil.png").getImage();
		yoshi1=new ImageIcon("./ressources/Accueil/Yoshi1/feuille.png").getImage();
		
		
		yoshi2[0]=new ImageIcon("./ressources/Accueil/Yoshi1/1.png").getImage();
		yoshi2[1]=new ImageIcon("./ressources/Accueil/Yoshi1/2.png").getImage();
		yoshi2[2]=new ImageIcon("./ressources/Accueil/Yoshi1/3.png").getImage();
		yoshi2[3]=new ImageIcon("./ressources/Accueil/Yoshi1/4.png").getImage();
		yoshi2[4]=new ImageIcon("./ressources/Accueil/Yoshi1/5.png").getImage();
		
		yoshi3[0]=new ImageIcon("./ressources/Accueil/Yoshi2/1.png").getImage();
		yoshi3[1]=new ImageIcon("./ressources/Accueil/Yoshi2/2.png").getImage();
		yoshi3[2]=new ImageIcon("./ressources/Accueil/Yoshi2/3.png").getImage();
		yoshi3[3]=new ImageIcon("./ressources/Accueil/Yoshi2/4.png").getImage();
		yoshi3[4]=new ImageIcon("./ressources/Accueil/Yoshi2/5.png").getImage();
		yoshi3[5]=new ImageIcon("./ressources/Accueil/Yoshi2/6.png").getImage();
		
		
		
		this.setLayout(new FlowLayout());
		timer = new Timer(200, this);
		timer.start();
	
        
		this.revalidate();
		this.repaint();
		
		
    }
		
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == timer){
			repaint();
			cptyoshi1 = (cptyoshi1 + 1) % 5;
			cptyoshi2 = (cptyoshi2 + 1) % 5;
			cptyoshi3 = (cptyoshi3 + 1) % 6;
		}
		else if (e.getActionCommand().equals("arreter")) timer.stop();
		else if (e.getActionCommand().equals("reprendre")) timer.restart();
	}


	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		
	    //cropped.getGraphics()
	    g.drawImage(yoshi1, widthyoshi1+500, heightyoshi1+500, widthyoshi1, heightyoshi1,
	    		widthyoshi1*(cptyoshi1+1), heightyoshi1, 
	    		widthyoshi1*(cptyoshi1), 0, this);
	    g.drawImage(yoshi2[cptyoshi2], 400, 200, widthyoshi2*1, heightyoshi2*1, this);
	    g.drawImage(yoshi3[cptyoshi3], 000, 400, widthyoshi3*1, heightyoshi3*1, this);
		
		
	}
}