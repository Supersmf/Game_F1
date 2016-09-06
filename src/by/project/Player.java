package by.project;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {

	Image img = new ImageIcon("resources/car_1.png").getImage();

	int v = 4;
	int d = 0;
	int s = 0;
	
	int x = 30;
	int y = 80;
	
	int layer1 = 0;
	
	public void move(){
		s += v;
		layer1 -= v;
	}
}
