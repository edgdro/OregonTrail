package edu.team32.oregontrail.windows;

import edu.team32.oregontrail.interfaces.Frame;
import edu.team32.oregontrail.swing.CustomButton;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.Color;
import java.awt.Cursor;

public class TitlePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3790962525368583100L;
	JButton btnNew;
	JButton btnLoad;
	JButton btnQuit;
	Frame frame;
	
	/**
	 * Create the panel.
	 */
	public TitlePanel(Frame frame) {
		this.frame = frame;
		setLayout(null);
		this.setPreferredSize(new Dimension(800,600));
		this.setBackground(new Color(204, 153, 102));
		btnNew = new CustomButton("New Game");
		btnNew.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNew.setBackground(new Color(204, 153, 102));
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNew.addActionListener(new ButtonListener());
		btnNew.setBounds(315, 544, 170, 37);
		add(btnNew);
		
		btnLoad = new CustomButton("Load Game");
		btnLoad.setBackground(new Color(204, 153, 102));
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLoad.addActionListener(new ButtonListener());
		btnLoad.setBounds(50, 544, 170, 37);
		add(btnLoad);
		
		btnQuit = new CustomButton("Quit Game");
		btnQuit.setBackground(new Color(204, 153, 102));
		btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnQuit.addActionListener(new ButtonListener());
		btnQuit.setBounds(580, 544, 170, 37);
		add(btnQuit);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 800, 600);
		background.setIcon(new ImageIcon(TitlePanel.class.getResource("/images/titleBackground.jpg")));
		add(background);

	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnQuit) {
				System.exit(0);
			}
			else if(e.getSource() == btnNew) {
				frame.playerCreation();
			}
			else if(e.getSource() == btnLoad)
			{
				frame.loadGame();
			}
			else {
				//TODO Run LoadGame code
			}
		}
		
	}
}
