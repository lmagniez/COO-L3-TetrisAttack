package Run;

import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Constante.ConstanteDimension;
import Ecran.Help;
import Ecran.Controles;
import Ecran.Credit;
import Ecran.EcranTitre;
import Ecran.Jeux1j;
import Ecran.Menu;
import Ecran.MenuJouer1;

public class Fenetre extends JFrame implements ConstanteDimension{
	
	Jeux1j j1=new Jeux1j(this);
	Menu m=new Menu(this);;
	Controles c=new Controles(this);
	Credit credit=new Credit(this);
	Help help=new Help(this);
	MenuJouer1 menuj1=new MenuJouer1(this);
	
	
	
	EcranTitre title=new EcranTitre();
	
	public Fenetre() throws ParseException{

			this.setTitle("Tetris Attack");
		    this.setSize(DimensionFenetrex,DimensionFenetrey);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			this.setResizable(false);
			this.setFocusable(false);

			this.add(m);
		    //this.add(j1);
		   //this.add(title);
			
		    this.setVisible(true);
	}

	public void afficheMenu() {
		swapEcran(m);
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
	
	public void swapEcran(JPanel j) {
		getContentPane().removeAll();
		getContentPane().repaint();
		this.add(j);
		validate();
	}

	

}

