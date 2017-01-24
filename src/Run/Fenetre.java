package Run;

import javax.swing.JFrame;

import Constante.ConstanteDimension;
import Ecran.Help;
import Ecran.Jeux1j;
import Ecran.Menu;

public class Fenetre extends JFrame implements ConstanteDimension{
	
	Jeux1j j1;
	Menu m;
	public Fenetre(){
			m=new Menu(this);
			j1=new Jeux1j();
		    this.setTitle("Tetris Attack");
		    this.setSize(DimensionFenetrex,DimensionFenetrey);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			this.setResizable(false);
			this.setFocusable(false);
			this.add(m);
		    //this.add(j1);
		    //
			
		    this.setVisible(true);
	}
	
	

}

