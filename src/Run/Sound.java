package Run;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.sound.sampled.*;

public class Sound {
	public static ArrayList<AudioClip> audio=new ArrayList<AudioClip>();
	
	public static Sound accueil=new Sound("/Ressource/son/audioAccueil.wav");
	public static Sound menu=new Sound("/Ressource/son/audioMenu.wav");
	public static Sound game=new Sound("/Ressource/son/audioJeu.wav");
	
	private int indice=0;
	
	public Sound(String fichier){
		try{
			audio.add(Applet.newAudioClip(Sound.class.getResource(fichier)));
			indice++;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void loop(int i){
		try{
			new Thread(){
				public void run(){
					audio.get(i).loop();
				}
			}.start();	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void stop(int i) {
		audio.get(i).stop();
	}
}