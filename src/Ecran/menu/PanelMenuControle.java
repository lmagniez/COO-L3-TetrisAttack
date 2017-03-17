package Ecran.menu;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import Bouton.Commande;
import Constante.ConstanteDimension;
import Run.Fenetre;



/**
 * Panel des controles
 * @author loick
 *
 */
public class PanelMenuControle extends PanelMenu implements ActionListener{
	
	
	private Fenetre fen;
	private JButton valider;
	private JPanel container = new JPanel();
	
	
	MaskFormatter selectj1 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
	private JFormattedTextField sel1 = new JFormattedTextField(selectj1);
	
	MaskFormatter raisej1 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
	JFormattedTextField rai1 = new JFormattedTextField(raisej1);
	
	MaskFormatter gauchej1 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
	JFormattedTextField g1 = new JFormattedTextField(gauchej1);
	
	MaskFormatter droitej1 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
	JFormattedTextField d1 = new JFormattedTextField(droitej1);
	
	MaskFormatter hautj1 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
	JFormattedTextField h1 = new JFormattedTextField(hautj1);
	
	MaskFormatter basj1 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
	JFormattedTextField b1 = new JFormattedTextField(basj1);
	
	MaskFormatter selectj2 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
	JFormattedTextField sel2= new JFormattedTextField(selectj2);
	
	MaskFormatter raisej2 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
	JFormattedTextField rai2 = new JFormattedTextField(raisej2);
	
	MaskFormatter gauchej2 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
	JFormattedTextField g2= new JFormattedTextField(gauchej2);

	MaskFormatter droitej2 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
    JFormattedTextField d2 = new JFormattedTextField(droitej2);
    
    MaskFormatter hautj2 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
	JFormattedTextField h2 = new JFormattedTextField(hautj2);
    
    MaskFormatter basj2 = new MaskFormatter("U");//recup uniquement si c'est une lettre, U passe la lettre en maj automatiquement
	JFormattedTextField b2 = new JFormattedTextField(basj2);
	
	private ImageIcon player1 = new ImageIcon("./ressources/Game/layoutControls/layoutplayer1.png");
	private ImageIcon swimg1 = new ImageIcon("./ressources/Game/layoutControls/switch1.png");
	private ImageIcon raimg1 = new ImageIcon("./ressources/Game/layoutControls/raise1.png");
	private ImageIcon leimg1 = new ImageIcon("./ressources/Game/layoutControls/cursorleft1.png");
	private ImageIcon riimg1 = new ImageIcon("./ressources/Game/layoutControls/cursorright1.png");
	private ImageIcon upimg1 = new ImageIcon("./ressources/Game/layoutControls/cursorup1.png");
	private ImageIcon doimg1 = new ImageIcon("./ressources/Game/layoutControls/cursordown1.png");
	private ImageIcon player2 = new ImageIcon("./ressources/Game/layoutControls/layoutplayer2.png");
	private ImageIcon swimg2 = new ImageIcon("./ressources/Game/layoutControls/switch2.png");
	private ImageIcon raimg2 = new ImageIcon("./ressources/Game/layoutControls/raise2.png");
	private ImageIcon leimg2 = new ImageIcon("./ressources/Game/layoutControls/cursorleft2.png");
	private ImageIcon riimg2 = new ImageIcon("./ressources/Game/layoutControls/cursorright2.png");
	private ImageIcon upimg2 = new ImageIcon("./ressources/Game/layoutControls/cursorup2.png");
	private ImageIcon doimg2 = new ImageIcon("./ressources/Game/layoutControls/cursordown2.png");


    
    int cptButton=0;
    
    
    
    
    protected Image cursor;
    /**
	 * Constructeur
	 * @param f fenetre
	 * @param ecran ecranMenu
	 */
	public PanelMenuControle(Fenetre f, EcranMenu ecran) throws java.text.ParseException{
		
		this.ecran=ecran;
		this.vue=vue;
		this.pred_panel=this.ecran.p1;
		this.has_cursor=true; 
		
		
		NB_BUTTONS_Y=1;
		NB_BUTTONS_X=1;
		buttons=new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonX=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonY=new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		
		for(int i=0; i<NB_BUTTONS_X; i++){
			posButtonX[i][0]=ConstanteDimension.DimensionFenetrex*1/7;
			posButtonY[i][0]=385;
		}		
		
		this.setLayout(null);
		this.fond=new ImageIcon("./ressources/Menu/menuframe.png").getImage();
		
		this.setBounds(ConstanteDimension.DimensionFenetrex/5, ConstanteDimension.DimensionFenetrey/4,300, 300);
		this.setOpaque(false);
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.setVisible(true);
		this.requestFocusInWindow();
		this.setMaximumSize(new Dimension(300,500));
		
		container.setBounds(15, 15,300-30, 250);
		container.setOpaque(false);
		container.setBackground(new Color(90,90,90));
		container.setLayout(new GridLayout(15,2));
		valider= new JButton("Valider");
		valider.addActionListener(this);
		this.add(container);
		this.ajout();
		
		
	}
	
	
	/**
	 * Ajouter les éléments au panel
	 */
	public void ajout() {
		buttons[0][cptButton++]=valider;
		
		JLabel ply1 = new JLabel(player1);
		container.add(ply1);
		JLabel espace1 = new JLabel("");
		container.add(espace1);
		
		JLabel lj1 = new JLabel(leimg1);
		container.add(lj1);
		try{
			g1.setBounds(10,0,5,0);
			container.add(g1);
		}catch(ParseException e){e.printStackTrace();}
		
		JLabel rj1 = new JLabel(riimg1);
		container.add(rj1);
		try{
			  container.add(d1);
		}catch(ParseException e){e.printStackTrace();}
		
		JLabel uj1 = new JLabel(upimg1);
		container.add(uj1);
		try{
			container.add(h1);
		}catch(ParseException e){e.printStackTrace();}
		
		JLabel dj1 = new JLabel(doimg1);
		container.add(dj1);
		try{
			  container.add(b1);
		}catch(ParseException e){e.printStackTrace();}
		
		JLabel swpj1 = new JLabel(swimg1);
		container.add(swpj1);
		try{
			  container.add(sel1);
		}catch(ParseException e){e.printStackTrace();}
		
		JLabel raj1 = new JLabel(raimg1);
		container.add(raj1);
		try{
			  container.add(rai1);
		}catch(ParseException e){e.printStackTrace();}
		
		JLabel ply2 = new JLabel(player2);
		container.add(ply2);
		JLabel espace2 = new JLabel("");
		container.add(espace2);
		
		JLabel lj2 = new JLabel(leimg2);
		container.add(lj2);
		try{
			  container.add(g2);
		}catch(ParseException e){e.printStackTrace();}
		
		JLabel rj2 = new JLabel(riimg2);
		container.add(rj2);
		try{
			  container.add(d2);
		}catch(ParseException e){e.printStackTrace();}
		
		JLabel uj2 = new JLabel(upimg2);
		container.add(uj2);
		try{
			  container.add(h2);
		}catch(ParseException e){e.printStackTrace();}
		
		JLabel dj2 = new JLabel(doimg2);
		container.add(dj2);
		try{
			  container.add(b2);
		}catch(ParseException e){e.printStackTrace();}
		
		JLabel swpj2 = new JLabel(swimg2);
		container.add(swpj2);
		try{
			  container.add(sel2);
		}catch(ParseException e){e.printStackTrace();}	
		
		JLabel raj2 = new JLabel(raimg2);
		container.add(raj2);
		try{
			  container.add(rai2);
		}catch(ParseException e){e.printStackTrace();}
		
		/*JLabel espace3 = new JLabel("");
		container.add(espace3);
		JLabel espace4 = new JLabel("");
		container.add(espace4);*/
		
		valider.setBounds(30, 250, 260, 30);
		this.add(valider);
		
		/*JLabel espace5 = new JLabel("");
		this.add(espace5);
		JLabel espace6 = new JLabel("");
		this.add(espace6);*/
		
		ecran.setButtons(buttons);
		ecran.addListener();
		
	}
	
	/**
	 * Récupérer les données
	 */
	public void recupDonnees(){
		
		String[] donnees = new String[12];
		
		donnees[0] = g1.getText();
		if(donnees[0].length()==0){
	    	donnees[0]="Q";
	    }
		donnees[1] = d1.getText();
		if(donnees[1].length()==0){
	    	donnees[1]="D";
	    }
		donnees[2] = h1.getText();
		if(donnees[2].length()==0){
	    	donnees[2]="Z";
	    }
		donnees[3] = b1.getText();
		if(donnees[3].length()==0){
	    	donnees[3]="S";
	    }
		donnees[4] = sel1.getText();
	    if(donnees[4].length()==0){
	    	donnees[4]="F";
	    }
	    donnees[5] = rai1.getText();
	    if(donnees[5].length()==0){
	    	donnees[5]="E";
	    }
		donnees[6] = g2.getText();
	    if(donnees[6].length()==0){
	    	donnees[6]="J";
	    }
		donnees[7] = d2.getText();
	    if(donnees[7].length()==0){
	    	donnees[7]="L";
	    }
		donnees[8] = h2.getText();
	    if(donnees[8].length()==0){
	    	donnees[8]="I";
	    }
		donnees[9] = b2.getText();
	    if(donnees[9].length()==0){
	    	donnees[9]="K";
	    }
	    donnees[10] = sel2.getText();
	    if(donnees[10].length()==0){
	    	donnees[10]="M";
	    }
		donnees[11] = rai2.getText();
	    if(donnees[11].length()==0){
	    	donnees[11]="O";
	    }
	    
		/*try{
			File f = new File("controles.txt");
			FileOutputStream sortie = new FileOutputStream(f);
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("controles.txt")));
			byte[] b;
		    
		    for(String s: donnees){
		    	bos.write("\n".getBytes());
		    	b = s.getBytes(Charset.forName("UTF-8"));
		    	bos.write(b);
		    }
		    
		    sortie.close();
		    bos.close();
		    
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e1){
			e1.printStackTrace();
		}*/
	    File f = new File("controles.txt");
	    try{
	    	FileWriter fw = new FileWriter(f);
	    	for (String s : donnees){
	    		fw.write(s);
	    		fw.write("\n");
	    	}
	    	fw.close();
	    }catch(IOException e){
	    }
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Valider")){
			recupDonnees();
			EcranMenu.changeMenuBox(ecran,ecran.p1);
		}
		if (e.getActionCommand().equals("Retour")){
			EcranMenu.changeMenuBox(ecran,ecran.p1);
		}
	}

	

	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		
		//posyoshiY=ConstanteDimension.DimensionFenetrey/2+screenheightyoshi/2,
		//		posyoshiX=ConstanteDimension.DimensionFenetrex-screenwidthyoshi/2;
	   
		
	}
	
	
}
