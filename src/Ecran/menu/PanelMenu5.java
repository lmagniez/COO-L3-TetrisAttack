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
		
		NB_BUTTONS_Y=3;
		NB_BUTTONS_X=1;
		buttons=new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];
		
		this.ecran=ecran;
		this.vue=f;
		this.setLayout(new BorderLayout());
		this.fond=new ImageIcon("./ressources/Menu/menuframe.png").getImage();
		
		this.setBounds(ConstanteDimension.DimensionFenetrex/10, ConstanteDimension.DimensionFenetrey/10,
				600, 400);
		
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.setVisible(true);
		this.requestFocusInWindow();
		this.setMaximumSize(new Dimension(300,500));
		

		
		
		cardPanel=new JPanel();
		cardPanel.setLayout(new CardLayout());
		
		
		b1=new JButton("Retour");
		b1.addActionListener(this);
		b2=new JButton("<");
		b2.addActionListener(this);
		b3=new JButton(">");
		b3.addActionListener(this);
		
		
		
		regleLabel0=new JLabel("Les Règles");
		regleLabel0.setHorizontalAlignment(SwingConstants.CENTER);
		regleLabel0.setVerticalAlignment(SwingConstants.CENTER);
		regleLabel0.setMinimumSize(new Dimension(45,45));
		regleLabel0.setPreferredSize(new Dimension(90,90));
		
		String s1="Comment gagner ?\n\n"+

"Il faut être le dernier joueur qui n’ait pas fait faillite.\n"+

"Comment faire : acheter des propriétés et faire payer le plus gros loyer possible aux"+ 
"joueurs qui atterrissent chez vous. Acheter toutes les propriétés d’un même groupe de couleur" +
"pour augmenter les loyers et pouvoir construire des maisons et des hôtels aﬁn d’augmenter le "+
"montant de vos revenus.";
		
		String s2="Quand c'est votre tour\n"+
    "1) Lancez les deux dés blancs.\n"
    +"2) Bougez votre pion d’autant de cases que le nombre de points indiqué sur les dés et dans le sens des aiguilles d’une montre.\n"
    +"3) Case DépartLa case où vous vous arrêterez déterminera ce que vous avez à faire. Voir la rubrique « Types de Cases » ci-dessous.\n"
    +"4) Si vous passez par ou vous arrêtez sur la case DÉPART, vous recevez M200 de la Banque.\n"
    +"5) Si vous faites un double aux dés, effectuez les opérations habituelles sur la case où vous vous arrêtez puis relancez les dés (étapes 1 à 4).\n"
    +"6) Attention ! Si vous faites trois doubles de suite, rendez-vous immédiatement en prison.\n"
    +"7) Lorsque vous avez terminé votre tour, donnez les dés au joueur situé sur votre gauche.\n";


		String s3="Types de cases\n\n"
+"Propriété n'appartenant à personne\n"
+"Il existe trois types de propriétés :\n\n"
+"Terrains, Gares, et Services \n\n"
+"Vous pouvez acheter la propriété sur laquelle vous vous arrêtez en payant à la Banque "
+"le prix indiqué sur la case du plateau de jeu. Vous recevrez en échange, comme preuve "
+"de cette acquisition, une carte de propriété que vous devez garder face visible devant vous.\n\n"
+"Si vous décidez de ne pas l’acheter, le banquier doit immédiatement ouvrir une vente aux enchères.\n"
+"Lorsque vous achetez des propriétés, vous devez penser à acheter, si possible, les autres propriétés "
+"du même groupe de couleur. Par exemple : si vous achetez un terrain vert, vous devez essayer d’acheter" 
+"les 2 autres terrains verts au cours de la partie.\n\n"
+"Posséder un groupe de couleur augmente le montant du loyer que les autres joueurs ont à payer quand ils"
+"atterrissent sur une de ces propriétés et vous permet également de construire des maisons et des hôtels pour encore augmenter vos revenus.";
		
		regleLabels=new JTextArea[3];
		regleLabels[0]=initTextArea(s1);
		regleLabels[1]=initTextArea(s2);
		regleLabels[2]=initTextArea(s3);
		
		reglePanels=new JPanel[3];
		
		
		for(int i=0; i<NB_ECRANS; i++)
		{
			reglePanels[i]=new JPanel();
			reglePanels[i].add(regleLabels[i]);
			cardPanel.add(reglePanels[i], ECRANS[i]);
		}
		
		this.add(regleLabel0,BorderLayout.NORTH);
		this.add(b1,BorderLayout.SOUTH);
		this.add(cardPanel,BorderLayout.CENTER);
		this.add(b2,BorderLayout.WEST);
		this.add(b3,BorderLayout.EAST);
		
		this.setFocusable(true);
		this.requestFocus();
		
		this.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				PanelMenu5.this.gestion(e);
			}
		});
		
		this.ajout();
	}
	
	public void ajout() {
		
		/*
		buttons[cptButton++][0]=sel1;
		buttons[cptButton++][0]=g1;
		buttons[cptButton++][0]=d1;
		buttons[cptButton++][0]=sel2;
		buttons[cptButton++][0]=g2;
		buttons[cptButton++][0]=d2;
		*/
		buttons[0][cptButton++]=b2;
		buttons[0][cptButton++]=b1;
		buttons[0][cptButton++]=b3;
		
		ecran.setButtons(buttons);
		ecran.addListener();
		
		
		
	}


	

	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		
		//posyoshiY=ConstanteDimension.DimensionFenetrey/2+screenheightyoshi/2,
		//		posyoshiX=ConstanteDimension.DimensionFenetrex-screenwidthyoshi/2;
	   
		
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
			ecran.changeMenuBox(ecran.p1);
        	
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
			ecran.changeMenuBox(ecran.p1);
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
	        	ecran.changeMenuBox(ecran.p1);
	        	break;
	        
	        	
	     }
	    
	}
	
	
}
