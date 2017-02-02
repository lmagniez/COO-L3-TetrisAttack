package Run;

import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Constante.ConstanteDimension;
import Ecran.Help;
import Ecran.HowToImprove;
import Ecran.HowToPlay;
import Ecran.Controles;
import Ecran.Credit;
import Ecran.Jeux1j;
import Ecran.MenuJouer1;
import Ecran.menu.EcranMenu;
import Ecran.titre.EcranTitre;

public class Fenetre extends JFrame implements ConstanteDimension{
	
	private Jeux1j j1=new Jeux1j(this);
	protected EcranMenu m;
	private Controles c=new Controles(this);
	private Credit credit=new Credit(this);
	private Help help=new Help(this);
	private	MenuJouer1 menuj1=new MenuJouer1(this);
	private HowToPlay howtoPlay=new HowToPlay(this);
	private HowToImprove howtoImprove=new HowToImprove(this);
	
	
	
	protected EcranTitre title=new EcranTitre(this);
	
	public Fenetre() throws ParseException{

			this.setTitle("Tetris Attack");
		    this.setSize(DimensionFenetrex,DimensionFenetrey);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			this.setResizable(false);
			this.setFocusable(true);

			this.m= new EcranMenu(this);
			
			
		    //this.add(j1);
		    this.add(title);
			//this.add(m);
		    this.setVisible(true);
		    title.requestFocus();
		    //this.afficherPanneau(m);
		    //m.requestFocusInWindow();
	}

	
	/**
	 * Méthode générique affichant un panneau sur la fenêtre
	 * @param p
	 */
	public void afficherPanneau(JPanel p)
	{
		getContentPane().removeAll();
		getContentPane().repaint();
		getContentPane().add(p);
		getContentPane().validate();
		
		p.setVisible(true);
		this.repaint();
		
		
	}
	
	public void afficheMenu() {
		swapEcran(getM());
	}
	
	public void afficheJeuxJ1() {
		swapEcran(menuj1);
	}
	
	public void afficheControles() {
		swapEcran(c);
	}
	
	public void affichecredit() {
		swapEcran(credit);
	}
	
	public void affichehelp() {
		swapEcran(help);
	}
	
	public void afficheHowToPlay() {
		swapEcran(howtoPlay);
	}
	
	public void swapEcran(JPanel j) {
		getContentPane().removeAll();
		getContentPane().repaint();
		this.add(j);
		validate();
	}

	public void afficheHowToImprove() {
		swapEcran(howtoImprove);
	}


	public EcranMenu getM() {
		return m;
	}


	

}

