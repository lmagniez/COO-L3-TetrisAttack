package com.Controller;

import com.Model.JoueurModel;
import com.Vue.Jeux1j;
import Constante.ConstanteDimension;
import Constante.ConstanteJeux;

/**
 * Controler du joueur
 * @author loick
 *
 */
public class JoueurControler implements ConstanteJeux,ConstanteDimension {

	protected JoueurModel joueurModel;
	protected GrilleControler grilleCont;
	protected int zzz=5000;
	private int zzzdep=0;
	protected Thread thread;
	private int monte;
	
	private volatile boolean monteActif;
	protected boolean tourne=true;
	
	/**
	 * Constructeur
	 * @param cal modèle du joueur
	 * @param grilleCont controler de la grille
	 * @param lvl niveau de la partie
	 */
	public JoueurControler(JoueurModel cal,GrilleControler grilleCont,int lvl) {
		this.joueurModel=cal;
		this.grilleCont=grilleCont;
		this.zzzdep=this.zzz=this.zzz-(lvl*40);
		this.monteActif=true;
	}

	/**
	 * Demander un swap dans la grille
	 * @param x1 abscisse1
	 * @param x2 abscisse2
	 * @param y1 ordonnée
	 */
	public void actionswap(int x1, int x2, int y1) {
		this.grilleCont.swap(x1,x2,y1);
	}

	/**
	 * Vérifier si le joueur peut aller en haut
	 * @param y1 ordonnée
	 */
	public void verifUp(int y1) {
		if (y1 != 0) {
			this.joueurModel.changeHaut();
		}
		else{
			return;
		}
	}
	
	/**
	 * Vérifier si le joueur peut aller en haut (graphique)
	 * @param y1 ordonnée
	 */
	public void verifUpGraphique(int y1){
		if (y1 != 0) {
			this.joueurModel.monteJoueurGraphique();
		}
	}

	/**
	 * Vérifier si le joueur peut aller en bas
	 * @param y1 ordonnée
	 */
	public void verifDown(int y1) {
		if (y1 != nombredeLigneTeste) {
			this.joueurModel.changeBas();
		}
	}

	/**
	 * Vérifier si le joueur peut aller à gauche
	 * @param x1 abscisse
	 */
	public void verifLeft(int x1) {
		if (x1 != 0) {
			this.joueurModel.changeGauche();
		}

	}

	/**
	 * Vérifier si le joueur peut aller à droite
	 * @param x2 abscisse
	 */
	public void verifRight(int x2) {
		if (x2 != nombredecase - 1) {
			this.joueurModel.changeDroit();
		}
	}

	/**
	 * Stopper l'ajout de ligne
	 */
	public void stopperAjoutLigne(){
		this.monteActif=false;
	}
	
	/**
	 * Activer l'ajout de ligne
	 */
	public void activerAjoutLigne(){
		this.monteActif=true;
	}
	
	/**
	 * Thread faisant monter la grille et le joueur
	 */
	public void animation() {
		thread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (tourne) {
					try {
						Thread.sleep(1);
						monte=JoueurControler.this.zzz / (DimensionGrilley / (nombredeLigne - 2 * reserve) );
						if(monteActif){
							i++;
						}
						if(i==JoueurControler.this.zzz){
							JoueurControler.this.verifUp(JoueurControler.this.joueurModel.getY1());
							JoueurControler.this.grilleCont.ajoutLigne();
							if(JoueurControler.this.grilleCont.gameOver())System.out.println("GameOver");
							i=0;
						}
					
						if(monteActif&& i % monte ==0 ){
							verifUpGraphique(JoueurControler.this.joueurModel.getY1());
							JoueurControler.this.grilleCont.montegrilleGraphique();
						}
						
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}
	
	public void start() {
		thread.start();
	}
	
	public void reprendre() {
		thread.resume();
	}

	public void pause() {
		thread.suspend();
	}

	
	/**
	 * Fin du jeu
	 */
	public void arreterThread() {
		tourne=false;
		//grilleCont.winner()
	}
	
	/**
	 * Reprendre le jeu
	 */
	public void reprendreThread() {
		tourne=true;
		//grilleCont.winner()
	}

	public void accelere() {
		this.zzz=this.zzz-50;
		System.out.println(zzz);
	}
	
	public void reinit() {
		this.zzz=this.zzzdep;
	}
}
