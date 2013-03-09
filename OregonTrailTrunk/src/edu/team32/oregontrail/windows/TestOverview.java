package edu.team32.oregontrail.windows;

import edu.team32.oregontrail.game.frame.GameFrame;
import edu.team32.oregontrail.interfaces.Frame;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TestOverview extends JPanel {

	JLabel playerNameLabel, professionLabel, paceLabel, rationsLabel, startDateLabel;
	JTextArea companionsLabel;
	Frame frame;
	private JTextPane txtpnForTheNext;
	
	/**
	 * Create the panel.
	 */
	public TestOverview(Frame frame) {
		this.frame = frame;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblOverview = new JLabel("Wagon Overview");
		lblOverview.setFont(new Font("Tahoma", Font.BOLD, 42));
		panel.add(lblOverview);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		playerNameLabel = new JLabel(frame.getGameLogic().getPlayerName());
		playerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		playerNameLabel.setBounds(285, 137, 230, 29);
		panel_1.add(playerNameLabel);
		
		professionLabel = new JLabel(frame.getGameLogic().getProfession());
		professionLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		professionLabel.setBounds(339, 179, 121, 29);
		panel_1.add(professionLabel);
		
		companionsLabel = new JTextArea(frame.getGameLogic().getFriends());
		companionsLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		companionsLabel.setBounds(312, 305, 176, 141);
		panel_1.add(companionsLabel);
		
		paceLabel = new JLabel(frame.getGameLogic().getPace());
		paceLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		paceLabel.setBounds(339, 263, 230, 29);
		panel_1.add(paceLabel);
		
		startDateLabel = new JLabel(frame.getGameLogic().getStartDate());
		startDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		startDateLabel.setBounds(339, 459, 121, 29);
		panel_1.add(startDateLabel);
		
		rationsLabel = new JLabel(frame.getGameLogic().getRations());
		rationsLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rationsLabel.setBounds(339, 221, 121, 29);
		panel_1.add(rationsLabel);
		
		txtpnForTheNext = new JTextPane();
		txtpnForTheNext.setBackground(SystemColor.controlHighlight);
		txtpnForTheNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnForTheNext.setText("For the next part of the game please purchase the Store DLC or for the entire game now purchase the Complete DLC");
		txtpnForTheNext.setBounds(257, 25, 294, 82);
		panel_1.add(txtpnForTheNext);
		
		JButton btnNewButton = new JButton("DON'T CLICK");
		btnNewButton.setBounds(634, 492, 141, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ButtonListener());

	}
private class ButtonListener implements ActionListener{
		
		boolean everythingSet = true;
		@Override
		public void actionPerformed(ActionEvent event) {
			frame.displayStore();
		}
}
}
