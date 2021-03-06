package Run;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.ArrayList;

import Constante.ConstanteParametres;

/**
 * Classe du son
 * @author loick
 *
 */
public class Sound {
	public static ArrayList<AudioClip> musics = new ArrayList<AudioClip>();
	public static ArrayList<AudioClip> sounds = new ArrayList<AudioClip>();

	
	public static final Sound accueil = new Sound("/Ressource/Son/audioAccueil.wav",SoundType.MUSIQUE);
	public static final Sound menu = new Sound("/Ressource/Son/audioMenu.wav",SoundType.MUSIQUE);
	public static final Sound game = new Sound("/Ressource/Son/audioJeu.wav",SoundType.MUSIQUE);

	public static final Sound press_start = new Sound("/Ressource/Son/audioSelectAccueil.wav",SoundType.SON);
	public static final Sound press_button = new Sound("/Ressource/Son/audioDeplacement.wav",SoundType.SON);
	
	
	private int indice = 0;

	/**
	 * Constructeur
	 * @param fichier fichier
	 * @param type type du son
	 */
	public Sound(String fichier, SoundType type) {
		
		URL url=Sound.class.getResource(fichier);
		try {
			if(type==SoundType.MUSIQUE)
				musics.add(Applet.newAudioClip(url));
			if(type==SoundType.SON)
				sounds.add(Applet.newAudioClip(url));
			indice++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Jouer un son
	 * @param idSon
	 */
	public static void jouerSon(int idSon){
		sounds.get(idSon).play();
	}
	
	/**
	 * Changer les paramètres de son (activé/désactivé)
	 */
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
	
	/**
	 * Changer la musique
	 * @param idMusique id de la musique
	 */
	public static void changerMusique(int idMusique){
		Sound.stop();
		ConstanteParametres.ID_MUSIQUE=idMusique;
		Sound.loop();
	}
	
	/**
	 * Boucler sur une musique
	 */
	public static void loop() {
		if(ConstanteParametres.SOUND_ENABLED){
			try {
				new Thread() {
					public void run() {
						musics.get(ConstanteParametres.ID_MUSIQUE).loop();
					}
				}.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Stopper une musique
	 */
	public static void stop() {
		musics.get(ConstanteParametres.ID_MUSIQUE).stop();
	}
	
	
	
}