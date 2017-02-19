package Run;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.ArrayList;

import Constante.ConstanteParametres;

public class Sound {
	public static ArrayList<AudioClip> audio = new ArrayList<AudioClip>();

	public static final Sound accueil = new Sound("/Ressource/Son/audioAccueil.wav");
	public static final Sound menu = new Sound("/Ressource/Son/audioMenu.wav");
	public static final Sound game = new Sound("/Ressource/Son/audioJeu.wav");

	private int indice = 0;

	public Sound(String fichier) {
		try {
			audio.add(Applet.newAudioClip(Sound.class.getResource(fichier)));
			indice++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void changerParam(){
	  if(ConstanteParametres.SOUND_ENABLED){
  		  ConstanteParametres.SOUND_ENABLED=false;
  	  	  Sound.stop();
  	  }
  	  else
  	  {
  		  ConstanteParametres.SOUND_ENABLED=true;
  		  Sound.loop();
  	  }
	}
	
	public static void changerMusique(int idMusique){
		Sound.stop();
		ConstanteParametres.ID_MUSIQUE=idMusique;
		Sound.loop();
	}
	
	public static void loop() {
		if(ConstanteParametres.SOUND_ENABLED){
			try {
				new Thread() {
					public void run() {
						audio.get(ConstanteParametres.ID_MUSIQUE).loop();
					}
				}.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void stop() {
		audio.get(ConstanteParametres.ID_MUSIQUE).stop();
	}
	
	
	
}