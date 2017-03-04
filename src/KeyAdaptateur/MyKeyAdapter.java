package KeyAdaptateur;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyAdapter extends KeyAdapter {

	private boolean isOPressed = false;
	private boolean isLPressed = false;
	private boolean isKPressed = false;
	private boolean isMPressed = false;
	private boolean isJPressed = false;

	private boolean isZPressed = false;
	private boolean isSPressed = false;
	private boolean isQPressed = false;
	private boolean isDPressed = false;
	private boolean isFPressed = false;

	private boolean isSpacePressed = false;

	private boolean presser = false;

	public void keyPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_O) {
			isOPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_L) {
			isLPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_K) {
			isKPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_M) {
			isMPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_J) {
			isJPressed = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_Z) {
			isZPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			isSPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			isQPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			isDPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_F) {
			isFPressed = true;
		}

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_O) {
			isOPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_L) {
			isLPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_K) {
			isKPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_M) {
			isMPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_J) {
			isJPressed = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_Z) {
			isZPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			isSPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			isQPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			isDPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_F) {
			isFPressed = false;
		}
	}

	public boolean isOPressed() {
		return isOPressed;
	}

	public boolean isLPressed() {
		return isLPressed;
	}

	public boolean isKPressed() {
		return isKPressed;
	}

	public boolean isMPressed() {
		return isMPressed;
	}

	public boolean isJPressed() {
		return isJPressed;
	}

	public boolean isZPressed() {
		return isZPressed;
	}

	public boolean isSPressed() {
		return isSPressed;
	}

	public boolean isQPressed() {
		return isQPressed;
	}

	public boolean isDPressed() {
		return isDPressed;
	}

	public boolean isFPressed() {
		return isFPressed;
	}

	public boolean isSpacePressed() {
		return isSpacePressed;
	}

	public boolean isPresser() {
		return presser;
	}

	public void doActionD() {
		
	}
}