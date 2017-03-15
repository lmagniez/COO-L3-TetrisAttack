package Ecran.menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import Constante.ConstanteDimension;
import Ecran.Ecran;
import Run.Fenetre;

/**
 * Sous menu
 * @author loick
 *
 */
public abstract class PanelMenu extends JPanel {

	protected Fenetre vue;
	protected Image fond;
	protected EcranMenu ecran;
	protected JComponent[][] buttons;
	protected int[][] posButtonX;
	protected int[][] posButtonY;
	public boolean has_cursor;
	public PanelMenu pred_panel;
	
	public static int NB_BUTTONS_Y;
	public static int NB_BUTTONS_X;
	
	public EcranMenu getEcran(){
		return ecran;
	}

}
