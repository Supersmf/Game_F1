package by.project;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame f = new JFrame("F1");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(925, 520);
		f.add(new Road());
		f.setVisible(true);
	}

}
