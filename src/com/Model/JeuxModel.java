package com.Model;

import com.Observer.Observer;

/**
 * Modèle du jeu (Gestion du temps)
 * @author loick
 *
 */
public class JeuxModel extends AbstractModel{

	private Observer jeux1j;
	
	/**
	 * Constructeur
	 * @param j
	 */
	public JeuxModel(Observer j) {
		jeux1j=j;
	}
	
	/**
	 * Mettre à jour le temps
	 * @param minute minute 
	 * @param seconde seconde
	 */
	public void updateTime(int minute, int seconde) {
		String Sminute,Sseconde;
		
		if(minute==0)Sminute="00";
		else if(minute<10)Sminute="0"+minute;
		else Sminute=Integer.toString(minute);
		
		if(seconde==0)Sseconde="00";
		else if(seconde<10)Sseconde="0"+seconde;
		else Sseconde=Integer.toString(seconde);
		
		jeux1j.updateTimer(Sminute,Sseconde);
	}

	public void accelere() {
		jeux1j.accelere();
	}
	


}
