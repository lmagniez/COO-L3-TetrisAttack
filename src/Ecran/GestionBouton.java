package Ecran;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import Constante.ConstanteParametres;
import Constante.ConstanteSon;
import Ecran.menu.EcranMenu;
import Ecran.menu.PanelMenu;
import Run.Sound;

/**
 * Classe abstraite gérant les boutons dans un panel
 * @author loick
 *
 */
public abstract class GestionBouton {
	
	public static boolean is_busy=false;
	public static int current_row;
	public static int current_col;
	public static PanelMenu pred_panel;
	
	
	private static KeyListener enter = new KeyAdapter() {
	      @Override
	      public void keyTyped(KeyEvent e) {
	         if (e.getKeyChar() == KeyEvent.VK_ENTER) {
	        	 Sound.jouerSon(ConstanteSon.PRESS_START);
	        	 System.out.println("enter");
	        	if(e.getComponent() instanceof JButton)
	        		((JButton) e.getComponent()).doClick();
	        	if(e.getComponent() instanceof JComboBox){
	        		System.out.println("comboBox");
	        		if(((JComboBox) e.getComponent()).isPopupVisible())
	        		{
	        			System.out.println("ok!");
	        			((JComboBox) e.getComponent()).setPopupVisible(false);
	        			is_busy=false;
	        		}
	        		else
	        		{
	        			System.out.println("else");
	        			((JComboBox) e.getComponent()).setPopupVisible(true);
	        			is_busy=true;
	        		}
	        	}
	         }
	      }
	};
	
	/**
	 * Ajouter les listeners aux boutons
	 * @param buttons Ensemble des composants
	 */
	public static void ajoutListenerBouton(JComponent[][] buttons)
	{
		
		for(int i=0; i<buttons.length; i++)
		{
			for(int j=0; j<buttons[i].length; j++)
			{	
				
				//System.out.println(curRow);
				final int curRow=i;
				final int curCol=j;
				
				
				buttons[i][j].addKeyListener(enter);	
				buttons[i][j].addKeyListener(new KeyAdapter(){
					public void keyPressed(KeyEvent e) {
						//if(!is_busy){
						System.out.println("key pressed");
		                  switch (e.getKeyCode()) {
		                  case KeyEvent.VK_UP:
		                     if (curRow > 0)
		                     {
		                    	Sound.jouerSon(ConstanteSon.PRESS_BOUTON);
		                        buttons[curRow - 1][curCol].requestFocus();
		                     	//buttons[curRow - 1][curCol].setForeground(Color.GREEN);
		                     	//buttons[curRow][curCol].setForeground(Color.BLACK);
		                     	GestionBouton.current_row=curRow-1;
		                     	GestionBouton.current_col=curCol;
		                     	
		                     }
		                     break;
		                  case KeyEvent.VK_DOWN:
		                     if (curRow < buttons.length - 1)
		                     {  
		                    	 Sound.jouerSon(ConstanteSon.PRESS_BOUTON);
		                    	buttons[curRow + 1][curCol].requestFocus();
		                     	//buttons[curRow + 1][curCol].setForeground(Color.GREEN);
		                     	//buttons[curRow][curCol].setForeground(Color.BLACK);
		                    	GestionBouton.current_row=curRow+1;
		                     	GestionBouton.current_col=curCol;
		                     }
		                     
		                     break;
		                  case KeyEvent.VK_LEFT:
		                      if (curCol > 0)
		                      {
		                         buttons[curRow][curCol - 1].requestFocus();
		                         //buttons[curRow][curCol - 1].setForeground(Color.GREEN);
			                     //buttons[curRow][curCol].setForeground(Color.BLACK);
			                     GestionBouton.current_row=curRow;
			                     GestionBouton.current_col=curCol-1;
		                      }
		                      break;
		                  case KeyEvent.VK_RIGHT:
		                      if (curCol < buttons[curRow].length - 1)
		                      {
		                         buttons[curRow][curCol + 1].requestFocus();
		                         //buttons[curRow][curCol + 1].setForeground(Color.GREEN);
			                     //buttons[curRow][curCol].setForeground(Color.BLACK);
			                     GestionBouton.current_row=curRow;
			                     GestionBouton.current_col=curCol+1;
		                      }
		                      break;
		                  case KeyEvent.VK_M:
		                	  Sound.changerParam();
		                  break;
		                  
		                  case KeyEvent.VK_ESCAPE:
		                	  EcranMenu.changeMenuBox(pred_panel.getEcran(), pred_panel);
		                	  
		                	  
		                  break;
		                  
		                  default:
		                     break;
		                  }//switch
		                 
						//}//is busy
					}//key pressed
			
					}				
				);
			}//for
		}//for
	   
	}
}
