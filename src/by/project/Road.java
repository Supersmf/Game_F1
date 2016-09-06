package by.project;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Road extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public Road(){
		mainTimer.start();
	}
	
	Timer mainTimer = new Timer(20, this);
	
	Image img = new ImageIcon("resources/Road.jpg").getImage();
	
	Player p = new Player();
	
	public void paint(Graphics g){
		
		g = (Graphics2D) g;
		g.drawImage(img, p.layer1, 0, null);
		g.drawImage(p.img, p.x, p.y, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		p.move();
		repaint();
		
	}
		
}
