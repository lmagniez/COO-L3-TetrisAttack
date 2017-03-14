package Bouton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.event.ChangeListener;

public class SliderDifficulte extends JProgressBar implements KeyListener {

	private int x = 10;
	private int y = 300;
	private int sizex = 240;
	private int sizey = 50;

	public SliderDifficulte(JPanel j) {
		this.setPreferredSize(new Dimension(280,50 ));
		this.addChangeListener((ChangeListener) j);
		this.setBounds(x, y, sizex, sizey);
		this.setMinimum(0);
		this.setMaximum(99);
		this.addKeyListener(this);
		UIManager.put("ProgressBar.foreground", Color.GREEN);
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.setValue(this.getValue()+2);
			repaint();
			System.out.println(this.getValue());
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.setValue(this.getValue()-2);
			repaint();
			System.out.println(this.getValue());
		}
		if( this.getValue() > 30 ){UIManager.put("ProgressBar.foreground", Color.ORANGE);}
		if( this.getValue() > 70 ){UIManager.put("ProgressBar.foreground", Color.RED);}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
