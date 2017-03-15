package Ecran.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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

import Constante.ConstanteDimension;
import Constante.ConstanteImage;
import Run.Fenetre;

/**
 * Ecran de Credit
 */
public class PanelMenuCredits extends PanelMenu implements ActionListener {

	int cptButton = 0;

	protected Image fond;

	private Color[] tabCouleur={Color.blue,Color.ORANGE,Color.green,Color.WHITE};
	
	private String[] nomTab={"<html>LOICK MAGNIEZ","<html>VINCENT VALEMBOIS","MOHAMED AYAD ","KEVIN DELABROYE"};

	private String[] tache={"<br/>Animations,Menu,Jeu </html>","<br/> Jeu,Menu,Animations </html>","",""};
	
	
	/**
	 * Constructeur
	 * @param f fenetre
	 * @param ecran ecranMenu
	 */
	public PanelMenuCredits(Fenetre f, EcranMenu ecran) throws java.text.ParseException {

		this.ecran = ecran;
		this.vue = f;
		this.pred_panel = this.ecran.p1;

		this.has_cursor = false;
		NB_BUTTONS_Y = 0;
		NB_BUTTONS_X = 0;
		buttons = new JComponent[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonX = new int[NB_BUTTONS_X][NB_BUTTONS_Y];
		posButtonY = new int[NB_BUTTONS_X][NB_BUTTONS_Y];

		this.fond = new ImageIcon("./ressources/Menu/menuframe.png").getImage();

		this.setBounds(ConstanteDimension.DimensionFenetrex / 10, ConstanteDimension.DimensionFenetrey / 4, 400, 400);
		this.setOpaque(false);
		this.setBackground(new Color(90, 90, 90));
		this.setFocusable(true);
		this.setVisible(true);
		this.requestFocusInWindow();
		this.setMaximumSize(new Dimension(300, 300));
		this.setLayout(null);

		for (int i = 0; i < 4; i++) {
			JPanel j=personne(i);
			j.setBounds(10, 10+(90*i), 400, 400);
			this.add(j);
		}

		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				PanelMenuCredits.this.gestion(e);
			}
		});

	}

	/**
	 * Panel pour une personne des crédits
	 * @param i id de la personne
	 * @return retour le panel
	 */
	private JPanel personne(int i){
		JPanel pers=new JPanel();
		pers.setLayout(null);
		pers.setOpaque(false);
		
		JLabel photo=new JLabel(ConstanteImage.icon[i]);
		photo.setBounds(5, 5, 400/4, 400/4);
		pers.add(photo);
		
		JLabel nom=new JLabel(nomTab[i]+tache[i]);
		nom.setBounds(110,5 , 300,100);
		nom.setForeground(tabCouleur[i]);
		nom.setFont(new Font("verdana",Font.BOLD,20));
		pers.add(nom);
		
		return pers;
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
	}

	/**
	 * Ok: quitte l'écran d'aide et revient au jeu
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String command = ((JButton) e.getSource()).getActionCommand();

		if (command == "Ok") {
			EcranMenu.changeMenuBox(ecran, ecran.p1);

		}
		if (e.getActionCommand().equals("Retour")) {
			EcranMenu.changeMenuBox(ecran, ecran.p1);
		}

	}

	/**
	 * Gestion clavier des directions et des touches quitter(ESC) aide(H) et
	 * recommencer(J)
	 * 
	 * @param e
	 */
	public void gestion(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_ESCAPE:
			EcranMenu.changeMenuBox(ecran, ecran.p1);
			break;
		}
	}

}
