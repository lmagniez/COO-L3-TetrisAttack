package Run;

import java.awt.Toolkit;
import java.text.ParseException;

import Ecran.Menu;

public class Main {
	
	public static void main(String[] args) throws ParseException {
		Toolkit.getDefaultToolkit().sync();
		Fenetre f=new Fenetre();
	}
}
