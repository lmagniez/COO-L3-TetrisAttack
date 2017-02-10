package Run;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.*;

public class Sound {
	
	public static Sound accueil=new Sound("/Ressource/son/audioAccueil.wav");
			
	private AudioClip audio;
	
	public Sound(String fichier){
		try{
			audio= Applet.newAudioClip(Sound.class.getResource(fichier));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void loop(){
		try{
			new Thread(){
				public void run(){
					audio.loop();
				}
			}.start();	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}