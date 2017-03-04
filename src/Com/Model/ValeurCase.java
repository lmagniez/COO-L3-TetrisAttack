package Com.Model;

public enum ValeurCase {
	VIDE,CYAN,ROUGE,JAUNE,VERT,VIOLET,BLEU,GRIS;
	
	
	/**
	 * Accéder à la BoxValue en fonction d'un entier
	 * @param x entier 
	 * @return BoxValues associé à l'entier
	 */
	public static ValeurCase fromInteger(int x) {
        switch(x) {
        case 0:
            return VIDE;
        case 1:
            return CYAN;
        case 2:
        	return ROUGE;
        case 3:
        	return JAUNE;
        case 4:
        	return VERT;
        case 5:
        	return VIOLET;
        case 6:
        	return BLEU;
        case 7:
        	return GRIS;
        }
        return null;
    }
	
}