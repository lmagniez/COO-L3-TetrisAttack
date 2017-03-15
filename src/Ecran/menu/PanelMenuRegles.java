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
import Constante.ConstanteImage;
import Run.Fenetre;

/**
 * Panel des regles
 * @author loick
 */

public class PanelMenuRegles extends PanelMenu implements ActionListener{
	
	
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
	
	private int sizex=450;
	private int sizey=400;
	
	private int sizexRegle=sizex-20;
	private int sizeyRegle=sizey-20;
    
	
	/**
	 * Constructeur
	 * @param f fenetre
	 * @param ecran ecranMenu
	 */
	public PanelMenuRegles(Fenetre f, EcranMenu ecran) throws java.text.ParseException{
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
		
		this.setBounds(ConstanteDimension.DimensionFenetrex/30, ConstanteDimension.DimensionFenetrey/4,sizex, sizey);
		
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.setVisible(true);
		this.requestFocusInWindow();
		this.setMaximumSize(new Dimension(sizex,sizey));
		this.setOpaque(false);

		this.setLayout(null);
		
		cardPanel=new JPanel();
		cardPanel.setBounds(10, 10, sizexRegle, sizeyRegle);
		cardPanel.setOpaque(false);
		cardPanel.setLayout(new CardLayout());
		reglePanels=new JPanel[3];
		
		Icon img[]=new ImageIcon[3];
		img[0]=ConstanteImage.scaledButton("/Ressource/Regle/rules1.png",sizexRegle,sizeyRegle);
		img[1]=ConstanteImage.scaledButton("/Ressource/Regle/rules2.png",sizexRegle,sizeyRegle);
		img[2]=ConstanteImage.scaledButton("/Ressource/Regle/rules3.png",sizexRegle,sizeyRegle);
		
		JLabel labels[]=new JLabel[3];
		
		for(int i=0; i<NB_ECRANS; i++)
		{
			labels[i]=new JLabel(img[i]);
			labels[i].setBounds(0, 0, sizexRegle, sizeyRegle);
			reglePanels[i]=new JPanel();
			reglePanels[i].setOpaque(false);
			reglePanels[i].setLayout(null);
			reglePanels[i].setBounds(0, 0, sizexRegle, sizeyRegle);
			reglePanels[i].add(labels[i]);
			cardPanel.add(reglePanels[i], ECRANS[i]);
		}
		
		this.add(cardPanel);
		
		this.setFocusable(true);
		
		this.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				System.out.println("pressed! ");
				PanelMenuRegles.this.gestion(e);
			}
		});
		this.requestFocus();
		
		
		//this.ajout();
	}
	
	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		
	}
	

	/**
	 * Initie un JTextAera pour une chaine et le retourne
	 * @param s chaine
	 * @return JTextArea généré
	 */
	public JTextArea initTextArea(String s)
	{
		
		JTextArea textArea = new JTextArea();
        textArea.setRows(20);
        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setBackground(Color.lightGray);
		textArea.append(s);
		textArea.setEditable(false);
		return textArea;

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
