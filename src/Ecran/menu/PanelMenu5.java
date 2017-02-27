package Ecran.menu;



import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Constante.ConstanteDimension;
import Run.Fenetre;




public class PanelMenu5 extends PanelMenu implements ActionListener{
	
	
	private Fenetre fen;
    int cptButton=0;
    
    
    private final static String ECRANS[] = {"Ecran1","Ecran2","Ecran3"};
	private final static int NB_ECRANS=3;
	private int ecranActuel;
	
	private JButton b1,b2,b3;
	private JPanel cardPanel;
	private JPanel reglePanels[];
	
	private JLabel regleLabel0;
	private JTextArea regleLabels[];
	
	protected Image fond;
	
    
	public PanelMenu5(Fenetre f, EcranMenu ecran) throws java.text.ParseException{
		
		this.ecran=ecran;
		this.vue=f;
		this.pred_panel=this.ecran.p1;
		
		this.has_cursor=false; 
		NB_BUTTONS_Y=0;
		NB_BUTTONS_X=0;
		buttons=new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonX=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonY=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		
		this.fond=new ImageIcon("./ressources/Menu/menuframe.png").getImage();
		
		this.setBounds(ConstanteDimension.DimensionFenetrex/10, ConstanteDimension.DimensionFenetrey/10,
				300, 300);
		this.setOpaque(false);
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.setVisible(true);
		this.requestFocusInWindow();
		this.setMaximumSize(new Dimension(300,500));
		

		cardPanel=new JPanel();
		cardPanel.setLayout(new CardLayout());		
		reglePanels=new JPanel[3];
		
		Icon img[]=new ImageIcon[3];
		img[0]=new ImageIcon("./ressources/Menu/rules1.png");
		img[1]=new ImageIcon("./ressources/Menu/rules2.png");
		img[2]=new ImageIcon("./ressources/Menu/rules3.png");
		
		JLabel labels[]=new JLabel[3];
		
		for(int i=0; i<NB_ECRANS; i++)
		{
			labels[i]=new JLabel();
			labels[i].setIcon(img[i]);
			reglePanels[i]=new JPanel();
			reglePanels[i].add(labels[i]);
			
			//reglePanels[i].add(regleLabels[i]);
			
			cardPanel.add(reglePanels[i], ECRANS[i]);
		}
		this.add(cardPanel,BorderLayout.CENTER);
		this.setFocusable(true);
		
		
		this.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				PanelMenu5.this.gestion(e);
			}
		});
		
		//this.ajout();
	}
	
	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
	}
	

	/**
	 * Changer d'écran si possible
	 */
	public void changeScreenRight()
	{
		CardLayout c = (CardLayout) cardPanel.getLayout();
		if(ecranActuel<NB_ECRANS-1)
    	{
    		ecranActuel++;
    		c.show(cardPanel,ECRANS[ecranActuel]);
    	}
	}
	/**
	 * Changer d'écran si possible
	 */
	public void changeScreenLeft()
	{
		CardLayout c = (CardLayout) cardPanel.getLayout();
		if(ecranActuel>0)
    	{
    		ecranActuel--;
    		c.show(cardPanel,ECRANS[ecranActuel]);
    	}
	}
	
	
	/**
	 * Ok: quitte l'écran d'aide et revient au jeu
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = ((JButton) e.getSource()).getActionCommand();
		
		if(command=="Ok")
		{	
			EcranMenu.changeMenuBox(ecran,ecran.p1);
        	
		}
		
		if(command==">")
		{	
			this.changeScreenRight();
		}
		if(command=="<")
		{
			this.changeScreenLeft();
		}
		
		if (e.getActionCommand().equals("Retour")){
			EcranMenu.changeMenuBox(ecran,ecran.p1);
		}
		
	}
	
	
	/**
	 * Gestion clavier des directions et des touches quitter(ESC) aide(H) et recommencer(J)
	 * @param e
	 */
	public void gestion(KeyEvent e){
		int keyCode=e.getKeyCode();
		
    	
	    switch(keyCode) {
	        case KeyEvent.VK_LEFT:
	        	this.changeScreenLeft();
	        	break;
	        case KeyEvent.VK_RIGHT :
	        	this.changeScreenRight();
	        	break;
	        case KeyEvent.VK_ESCAPE:
	        	EcranMenu.changeMenuBox(ecran,ecran.p1);
	        	break;
	        
	        	
	     }
	    
	}
	
	
}
