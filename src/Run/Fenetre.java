package Run;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
	
	public Fenetre(){
		
		    this.setTitle("Tetris Attack");
		    this.setSize(1000,1000);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			this.setResizable(false);
			this.setFocusable(false);
			
		    //this.add();
		    //
			
		    this.setVisible(true);
	}

}

