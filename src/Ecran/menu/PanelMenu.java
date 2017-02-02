package Ecran.menu;

import java.awt.Image;

import javax.swing.JComponent;
import javax.swing.JPanel;

import Ecran.Ecran;
import Run.Fenetre;

public abstract class PanelMenu extends JPanel {

	protected Fenetre vue;
	protected Image fond;
	protected EcranMenu ecran;
	protected JComponent[][] buttons;
	
	public static int NB_BUTTONS_Y;
	public static int NB_BUTTONS_X;
}
