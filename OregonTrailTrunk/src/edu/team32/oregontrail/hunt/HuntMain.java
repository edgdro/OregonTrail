package edu.team32.oregontrail.hunt;

import javax.swing.JFrame;

/*
* DuckHuntMain.java
* This class contains the main method, which creates and sets up the frame for the GUI.
* @ Rebecca Hamm
* @ version 1.0
*/
public class HuntMain{
	public static void main (String[] args){
		JFrame frame = new JFrame(); //added parens after JFrame because it is constructor
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HuntPanel panel = new HuntPanel(null, null);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}