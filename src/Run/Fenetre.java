package Run;

import javax.swing.JFrame;

import Constante.ConstanteDimension;
import Ecran.EcranTitre;
import Ecran.Jeux1j;

public class Fenetre extends JFrame implements ConstanteDimension{
	
	Jeux1j j1;
	EcranTitre title;
	
	public Fenetre(){
		
			j1=new Jeux1j();
		    title=new EcranTitre();
			
			this.setTitle("Tetris Attack");
		    this.setSize(DimensionFenetrex,DimensionFenetrey);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			this.setResizable(false);
			this.setFocusable(false);
			
			
			
		    this.add(j1);
		    //this.add(title);
			
		    this.setVisible(true);
	}

}

