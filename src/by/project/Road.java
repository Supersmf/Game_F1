package by.project;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Road extends JPanel implements ActionListener, Runnable {

	private static final long serialVersionUID = 1L;

	Timer mainTimer = new Timer(20, this);

	Image img = new ImageIcon("resources/Road.jpg").getImage();

	Player p = new Player();

	Thread enemiesFactory = new Thread(this);

	List<Enemy> enemies = new ArrayList<>();

	public Road() {
		mainTimer.start();
		enemiesFactory.start();
		addKeyListener(new MyKeyAdapter());
		setFocusable(true);
	}

	public void paint(Graphics g) {

		g = (Graphics2D) g;
		g.drawImage(img, p.layer1, 0, null);
		g.drawImage(img, p.layer2, 0, null);
		g.drawImage(p.img, p.x, p.y, null);

		Iterator<Enemy> i = enemies.iterator();
		while (i.hasNext()) {
			Enemy e = i.next();
			if (e.x >= 2400 || e.x <= -2400) {
				i.remove();
			} else {
				e.move();
				g.drawImage(e.img, e.x, e.y, null);

			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		p.move();
		repaint();

	}

	private class MyKeyAdapter extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			p.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			p.keyReleased(e);
		}
	}

	@Override
	public void run() {
		while (true) {
			Random rand = new Random();
			try {
				Thread.sleep(rand.nextInt(2000));
				enemies.add(new Enemy(925, rand.nextInt(320), rand.nextInt(30), this));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
