package edu.team32.oregontrail.rivercrossinggame;


import edu.team32.oregontrail.interfaces.Frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RCMain{
	private Frame frame;
	private RCGrid grid;
	
	public RCMain(Frame frame){
		this.frame = frame;
		run();
	}
	
	public static void main(String[] args)
	{
		runGame();
	}

	private static void runGame()
	{
		
		RCGrid grid = new RCGrid(null);
		JPanel parent = new JPanel();
		parent.setLayout(new BorderLayout());
		parent.add(grid, BorderLayout.CENTER);	
		JFrame frame = new JFrame("River Crossing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(parent);
		frame.pack();
		frame.setVisible(true);
		
		grid.start();
		
		
	}
	private void run() {
		grid = new RCGrid(frame);
		//this.parent = new JPanel();
		//this.parent.setLayout(new BorderLayout());
		//this.parent.add(grid, BorderLayout.CENTER);	
		grid.start();
		grid.requestFocus();
	}
	
	public JPanel getParent()
	{
		return grid;
	}

}
