package Run;

import javax.swing.JFrame;

import Constante.ConstanteDimension;
import Ecran.Jeux1j;

public class Fenetre extends JFrame implements ConstanteDimension{
	
	Jeux1j j1;
	
	public Fenetre(){
			j1=new Jeux1j();
		    this.setTitle("Tetris Attack");
		    this.setSize(DimensionFenetrex,DimensionFenetrey);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			this.setResizable(false);
			this.setFocusable(false);
			
		    //this.add(j1);
		    //
			
		    this.setVisible(true);
	}

}

