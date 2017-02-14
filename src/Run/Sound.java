package Run;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.ArrayList;

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

	public static void loop(int i) {
		try {
			new Thread() {
				public void run() {
					audio.get(i).loop();
				}
			}.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void stop(int i) {
		audio.get(i).stop();
	}
}