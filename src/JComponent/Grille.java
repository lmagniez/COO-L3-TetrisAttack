package JComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import Constante.ConstanteDimension;
import Constante.ConstanteGraphique;
import Constante.ConstanteJeux;

public class Grille extends JPanel implements ConstanteDimension, ConstanteGraphique, ConstanteJeux {

	private boolean animationHaut=true;
	private boolean gameOver=false;
	
	public Case [][] tab=new Case[nombredecase][nombredeLigne];
	private final static Random RND=new Random();
	
	private int y;
	private int tailleny;
	
	public Grille() {
		tailleny=DimensionGrilley/(nombredeLigne-2*reserve);
		initGrille();
		this.setPreferredSize(new Dimension(DimensionGrillex,DimensionGrilley));
		setBackground(new Color(0,0,0,90));
		animation();
	}
	
	private void initGrille(){
		for(int a=0;a<nombredecase;a++){		
			creercolonne(a);
		}
	}
	
	private void creercolonne(int a) {
		int val,nblignedessiner=2+RND.nextInt(8-2);;
		for(int i=0;i<nombredeLigne;i++){
			val= (i<(nombredeLigne-(reserve+nblignedessiner))) ? 0 : 1+RND.nextInt(5-1);
			y=(i*tailleny);
			tab[a][i]=new Case(a*(DimensionGrillex/nombredecase),y,(DimensionGrillex/nombredecase),tailleny,val);
		}
		
	}
	
	public void affiche(){
		for(int a=0;a<nombredeLigne;a++){
			System.out.println("case: "+a);
			for(int i=0;i<nombredecase;i++){
				System.out.print("case: "+i +" " +tab[i][a].getValeur() + " ");
			}
			System.out.println();
		}
	}

	public void animation() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				int taille=0;
				while (animationHaut) {
					try {
						for(int a=0;a<nombredeLigne;a++){
							for(int i=0;i<nombredecase;i++){
								tab[i][a].setY(tab[i][a].getY()-1);
							}
						}
						if(tab[5][9].getY() % tailleny==0){
							Grille.this.decalagetab();
						}
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
					Grille.this.repaint();
				}
			}
		});
		thread.start();
	}
	
	

	protected void decalagetab() {
		for(int a=0;a<nombredeLigne-1;a++){
			for(int i=0;i<nombredecase;i++){
					tab[i][a].setValeur(tab[i][a+1].getValeur());
					tab[i][a].setX(tab[i][a+1].getX());
					tab[i][a].setY(tab[i][a+1].getY());
					if(((tab[i][a].getValeur()!=0) && (a==0))==true){
						animationHaut=false;
						gameOver=true;
						break;
					}
			}
			if(gameOver)
				break;
		}
		if(!gameOver)
			generationLigne();
	}

	public void generationLigne(){
		int val;
		for(int i=0;i<nombredecase;i++){
			val= 1+RND.nextInt(5-1);
			tab[i][nombredeLigne-1]=new Case(i*(DimensionGrillex/nombredecase),y,(DimensionGrillex/nombredecase),tailleny,val);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int a=0;a<nombredeLigne-reserve;a++){
			for(int i=0;i<nombredecase;i++){
				switch(tab[i][a].getValeur()){
					case 0:
						g.setColor(transparent);
					break;
					case 1:
						g.setColor(couleur1);
					break;
					case 2:
						g.setColor(couleur2);
					break;
					case 3:
						g.setColor(couleur3);
					break;
					case 4:
						g.setColor(couleur4);
					break;
					
				}
				g.fillRect(tab[i][a].getX(),tab[i][a].getY(), tab[i][a].getTailleX(), tab[i][a].getTailleY());
			}
		}
	}

}
