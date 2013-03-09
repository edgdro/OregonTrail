package edu.team32.oregontrail.windows;

import edu.team32.oregontrail.interfaces.Frame;
import edu.team32.oregontrail.swing.CustomButton;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverPanel extends JPanel {

	/**
	 * 
	 */
	private Frame frame;
	private static final long serialVersionUID = -6452390870320181377L;

	/**
	 * Create the panel.
	 */
	public GameOverPanel(Frame frame, String reason) {
		this.frame = frame;
		setBackground(new Color(238, 180, 34));
		setSize(new Dimension(800, 600));
		setLayout(null);
		
		JLabel lblGameOver = new JLabel("GAME OVER\r\n");
		lblGameOver.setFont(new Font("Tahoma", Font.PLAIN, 95));
		lblGameOver.setBounds(144, 77, 512, 115);
		add(lblGameOver);
		
		JLabel lblNewLabel = new JLabel("TRY AGAIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 95));
		lblNewLabel.setBounds(163, 203, 474, 115);
		add(lblNewLabel);
		
		JTextPane reasonLost = new JTextPane();
		reasonLost.setEditable(false);
		reasonLost.setText(reason);
		reasonLost.setBounds(275, 375, 250, 138);
		add(reasonLost);
		
		JButton btnLoadGame = new CustomButton("Load Old Game");
		btnLoadGame.setBounds(300, 524, 200, 40);
		btnLoadGame.addActionListener(new LoadListener());
		add(btnLoadGame);
	}
	
	private class LoadListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame.loadGame();
		}
		
	}
}
