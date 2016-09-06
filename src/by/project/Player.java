package by.project;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {

	public static final int MAX_V = 50;
	public static final int MAX_TOP = 40;
	public static final int MAX_BOTTOM = 320;
	
	Image img = new ImageIcon("resources/car.png").getImage();

	int v = 0;
	int d = 0;
	int s = 0;
	int dv = 0;

	int x = 30;
	int y = 80;
	int dy = 0;

	int layer1 = 0;
	int layer2 = 910;

	public void move() {
		s += v;
		v += dv;
		if (v <= 0) v = 0;
		if (v >= MAX_V) v = MAX_V;
		y -= dy;
		if (y <= MAX_TOP) y = MAX_TOP;
		if (y >= MAX_BOTTOM) y = MAX_BOTTOM;
		if (layer2 - v <= 0) {
			layer1 = 0;
			layer2 = 910;
		} else {
			layer1 -= v;
			layer2 -= v;
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT){
			dv = 1;
		}
		if (key == KeyEvent.VK_LEFT){
			dv = -1;
		}
		if (key == KeyEvent.VK_UP){
			dy = 10;
		}
		if (key == KeyEvent.VK_DOWN){
			dy = -10;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT){
			dv = 0;
		}
		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN){
			dy = 0;
		}
	}
}
