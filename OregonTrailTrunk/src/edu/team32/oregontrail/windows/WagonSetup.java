package edu.team32.oregontrail.windows;

import edu.team32.oregontrail.interfaces.Frame;
import edu.team32.oregontrail.swing.CustomButton;
import edu.team32.oregontrail.enums.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class WagonSetup extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4062353750032087703L;
	private Frame frame;
	private JButton nextButton;
	private JButton backButton;
	private final ButtonGroup dateButtonGroup = new ButtonGroup();
	private final ButtonGroup rationsButtonGroup = new ButtonGroup();
	private final ButtonGroup paceButtonGroup = new ButtonGroup();
	private JRadioButton rdbtnModerate, rdbtnExhausting, rdbtnSlow,
			rdbtnStopped, rdbtnLudicrous, rdbtnNone, rdbtnMeager,
			rdbtnFeast, rdbtnAverage, rdbtnScraps, rdbtnMarch, rdbtnApril,
			rdbtnMay, rdbtnJune, rdbtnJuly, rdbtnAugust;

	private int dateStr;
	private String rationsStr;
	private String paceStr;
	private JLabel lblPaceDescrip;
	private JLabel lblRationsDescrip;
	private JLabel lblPaceMilesDescrip;
	private JLabel lblRationsFoodDescrip;

	/**
	 * Create the panel.
	 */
	public WagonSetup(Frame frame) {
		dateStr = 3;
		rationsStr = "Meager";
		paceStr = "Moderate";
		this.frame = frame;
		this.setPreferredSize(new Dimension(800, 600));
		setLayout(new BorderLayout(0, 0));

		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(238, 180, 34));
		this.setBackground(new Color(238, 180, 34));
		titlePanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0,
				0, 0)));
		add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblWagonSetup = new JLabel("Wagon Setup");
		lblWagonSetup.setFont(new Font("Tahoma", Font.BOLD, 42));
		titlePanel.add(lblWagonSetup);

		JPanel setupPanel = new JPanel();
		add(setupPanel, BorderLayout.CENTER);
		setupPanel.setLayout(null);

		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(new Color(238, 180, 34));
		rightPanel.setLayout(null);
		rightPanel.setBounds(350, 0, 450, 537);
		setupPanel.add(rightPanel);

		nextButton = new CustomButton("Continue");
		nextButton.setBackground(new Color(204, 153, 102));
		nextButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		nextButton.setBounds(290, 487, 148, 37);
		nextButton.addActionListener(new ButtonListener());
		rightPanel.add(nextButton);

		backButton = new CustomButton("Back");
		backButton.setBackground(new Color(204, 153, 102));
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backButton.setBounds(12, 487, 175, 37);
		backButton.addActionListener(new ButtonListener());
		rightPanel.add(backButton);

		JPanel textPanel = new JPanel();
		textPanel.setBackground(new Color(204, 153, 102));
		textPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textPanel.setLayout(null);
		textPanel.setBounds(12, 13, 426, 456);
		rightPanel.add(textPanel);

		JTextPane txtpnYouHungryYou = new JTextPane();
		txtpnYouHungryYou
				.setText("Before you leave you need to make some decisions. Select which month you want to leave. The time of year can effect the weather during your journey in different ways. Don't forget to choose your starting pace and rations for you and your wagon members. These can also be adjusted once you are on the trail!");
		txtpnYouHungryYou.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnYouHungryYou.setEditable(false);
		txtpnYouHungryYou.setBackground(new Color(204, 153, 102));
		txtpnYouHungryYou.setBounds(12, 13, 402, 176);
		textPanel.add(txtpnYouHungryYou);
		
		JLabel lblPace_1 = new JLabel("Pace:");
		lblPace_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPace_1.setBounds(12, 258, 62, 14);
		textPanel.add(lblPace_1);
		
		lblPaceDescrip = new JLabel(Pace.MODERATE.getDescription());
		lblPaceDescrip.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPaceDescrip.setBounds(12, 283, 402, 14);
		textPanel.add(lblPaceDescrip);
		
		lblPaceMilesDescrip = new JLabel(Pace.MODERATE.getMilesDescription());
		lblPaceMilesDescrip.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPaceMilesDescrip.setBounds(12, 308, 402, 14);
		textPanel.add(lblPaceMilesDescrip);
		
		JLabel lblRations_1 = new JLabel("Rations:");
		lblRations_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRations_1.setBounds(12, 357, 76, 14);
		textPanel.add(lblRations_1);
		
		lblRationsDescrip = new JLabel(Rations.MEAGER.getDescription());
		lblRationsDescrip.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRationsDescrip.setBounds(12, 382, 402, 14);
		textPanel.add(lblRationsDescrip);
				
		lblRationsFoodDescrip = new JLabel(Rations.MEAGER.getFoodDescription());
		lblRationsFoodDescrip.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRationsFoodDescrip.setBounds(12, 407, 402, 14);
		textPanel.add(lblRationsFoodDescrip);

		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(238, 180, 34));
		leftPanel.setBounds(0, 0, 350, 537);
		setupPanel.add(leftPanel);
		leftPanel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 153, 102));
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setLayout(null);
		panel_2.setBounds(12, 242, 326, 226);
		leftPanel.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 153, 102));
		panel_3.setLayout(null);
		panel_3.setBounds(10, 48, 157, 160);
		panel_2.add(panel_3);

		rdbtnModerate = new JRadioButton("Moderate");
		rdbtnModerate.setBackground(new Color(204, 153, 102));
		rdbtnModerate.setSelected(true);
		rdbtnModerate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnModerate.setBounds(0, 69, 151, 27);
		panel_3.add(rdbtnModerate);
		paceButtonGroup.add(rdbtnModerate);
		rdbtnModerate.addActionListener(new RadioListener());

		rdbtnExhausting = new JRadioButton("Exhausting");
		rdbtnExhausting.setBackground(new Color(204, 153, 102));
		rdbtnExhausting.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnExhausting.setBounds(0, 96, 143, 30);
		panel_3.add(rdbtnExhausting);
		paceButtonGroup.add(rdbtnExhausting);
		rdbtnExhausting.addActionListener(new RadioListener());

		rdbtnSlow = new JRadioButton("Slow");
		rdbtnSlow.setBackground(new Color(204, 153, 102));
		rdbtnSlow.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnSlow.setBounds(0, 39, 129, 27);
		panel_3.add(rdbtnSlow);
		paceButtonGroup.add(rdbtnSlow);
		rdbtnSlow.addActionListener(new RadioListener());

		rdbtnLudicrous = new JRadioButton("Ludicrous");
		rdbtnLudicrous.setBackground(new Color(204, 153, 102));
		rdbtnLudicrous.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnLudicrous.setBounds(0, 129, 199, 27);
		panel_3.add(rdbtnLudicrous);
		paceButtonGroup.add(rdbtnLudicrous);
		rdbtnLudicrous.addActionListener(new RadioListener());

		rdbtnStopped = new JRadioButton("Stopped");
		rdbtnStopped.setBackground(new Color(204, 153, 102));
		rdbtnStopped.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnStopped.setBounds(0, 9, 129, 27);
		panel_3.add(rdbtnStopped);
		paceButtonGroup.add(rdbtnStopped);
		rdbtnStopped.addActionListener(new RadioListener());

		JLabel lblPace = new JLabel("Pace");
		lblPace.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblPace.setBounds(33, 13, 67, 34);
		panel_2.add(lblPace);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 153, 102));
		panel_1.setBounds(189, 48, 127, 160);
		panel_2.add(panel_1);
		panel_1.setLayout(null);

		rdbtnMeager = new JRadioButton("Meager");
		rdbtnMeager.setBackground(new Color(204, 153, 102));
		rdbtnMeager.setSelected(true);
		rdbtnMeager.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnMeager.setBounds(0, 69, 151, 27);
		panel_1.add(rdbtnMeager);
		rationsButtonGroup.add(rdbtnMeager);
		rdbtnMeager.addActionListener(new RadioListener());

		rdbtnAverage = new JRadioButton("Average");
		rdbtnAverage.setBackground(new Color(204, 153, 102));
		rdbtnAverage.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnAverage.setBounds(0, 97, 129, 30);
		panel_1.add(rdbtnAverage);
		rationsButtonGroup.add(rdbtnAverage);
		rdbtnAverage.addActionListener(new RadioListener());

		rdbtnScraps = new JRadioButton("Scraps");
		rdbtnScraps.setBackground(new Color(204, 153, 102));
		rdbtnScraps.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnScraps.setBounds(0, 39, 129, 27);
		panel_1.add(rdbtnScraps);
		rationsButtonGroup.add(rdbtnScraps);
		rdbtnScraps.addActionListener(new RadioListener());

		rdbtnFeast = new JRadioButton("Feast");
		rdbtnFeast.setBackground(new Color(204, 153, 102));
		rdbtnFeast.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnFeast.setBounds(0, 129, 129, 27);
		panel_1.add(rdbtnFeast);
		rationsButtonGroup.add(rdbtnFeast);
		rdbtnFeast.addActionListener(new RadioListener());

		rdbtnNone = new JRadioButton("None");
		rdbtnNone.setBackground(new Color(204, 153, 102));
		rdbtnNone.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnNone.setBounds(0, 9, 129, 27);
		panel_1.add(rdbtnNone);
		rationsButtonGroup.add(rdbtnNone);
		rdbtnNone.addActionListener(new RadioListener());

		JLabel lblRations = new JLabel("Rations");
		lblRations.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblRations.setBounds(197, 13, 106, 34);
		panel_2.add(lblRations);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 102));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(12, 33, 326, 162);
		leftPanel.add(panel);
		panel.setLayout(null);

		JLabel lblLeavingDate = new JLabel("Departure Date");
		lblLeavingDate.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblLeavingDate.setBounds(51, 13, 219, 34);
		panel.add(lblLeavingDate);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 153, 102));
		panel_4.setLayout(null);
		panel_4.setBounds(30, 48, 261, 107);
		panel.add(panel_4);

		rdbtnMay = new JRadioButton("May");
		rdbtnMay.setBackground(new Color(204, 153, 102));
		rdbtnMay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnMay.setBounds(28, 69, 73, 27);
		panel_4.add(rdbtnMay);
		dateButtonGroup.add(rdbtnMay);
		rdbtnMay.addActionListener(new RadioListener());

		rdbtnApril = new JRadioButton("April");
		rdbtnApril.setBackground(new Color(204, 153, 102));
		rdbtnApril.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnApril.setBounds(28, 39, 75, 27);
		panel_4.add(rdbtnApril);
		dateButtonGroup.add(rdbtnApril);
		rdbtnApril.addActionListener(new RadioListener());

		rdbtnMarch = new JRadioButton("March");
		rdbtnMarch.setBackground(new Color(204, 153, 102));
		rdbtnMarch.setSelected(true);
		rdbtnMarch.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnMarch.setBounds(28, 9, 93, 27);
		panel_4.add(rdbtnMarch);
		dateButtonGroup.add(rdbtnMarch);
		rdbtnMarch.addActionListener(new RadioListener());

		rdbtnAugust = new JRadioButton("August");
		rdbtnAugust.setBackground(new Color(204, 153, 102));
		rdbtnAugust.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnAugust.setBounds(145, 66, 101, 30);
		panel_4.add(rdbtnAugust);
		dateButtonGroup.add(rdbtnAugust);
		rdbtnAugust.addActionListener(new RadioListener());

		rdbtnJuly = new JRadioButton("July");
		rdbtnJuly.setBackground(new Color(204, 153, 102));
		rdbtnJuly.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnJuly.setBounds(145, 39, 69, 27);
		panel_4.add(rdbtnJuly);
		dateButtonGroup.add(rdbtnJuly);
		rdbtnJuly.addActionListener(new RadioListener());

		rdbtnJune = new JRadioButton("June");
		rdbtnJune.setBackground(new Color(204, 153, 102));
		rdbtnJune.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnJune.setBounds(145, 9, 77, 27);
		panel_4.add(rdbtnJune);
		dateButtonGroup.add(rdbtnJune);
		rdbtnJune.addActionListener(new RadioListener());

	}

	public void reset()
	{
		rdbtnMarch.setSelected(true);
		rdbtnModerate.setSelected(true);
		rdbtnMeager.setSelected(true);
	}
	private class RadioListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO could probably be better

			if (event.getSource().equals(rdbtnNone)) {
				lblRationsDescrip.setText(Rations.NONE.getDescription());
				lblRationsFoodDescrip.setText(Rations.NONE.getFoodDescription());
				rationsStr = Rations.NONE.toString();
			} else if (event.getSource().equals(rdbtnScraps)) {
				lblRationsDescrip.setText(Rations.SCRAPS.getDescription());
				lblRationsFoodDescrip.setText(Rations.SCRAPS.getFoodDescription());
				rationsStr = Rations.SCRAPS.toString();
			} else if (event.getSource().equals(rdbtnMeager)) {
				lblRationsDescrip.setText(Rations.MEAGER.getDescription());
				lblRationsFoodDescrip.setText(Rations.MEAGER.getFoodDescription());
				rationsStr = Rations.MEAGER.toString();
			} else if (event.getSource().equals(rdbtnAverage)) {
				lblRationsDescrip.setText(Rations.AVERAGE.getDescription());
				lblRationsFoodDescrip.setText(Rations.AVERAGE.getFoodDescription());
				rationsStr = Rations.AVERAGE.toString();
			} else if (event.getSource().equals(rdbtnFeast)) {
				lblRationsDescrip.setText(Rations.FEAST.getDescription());
				lblRationsFoodDescrip.setText(Rations.FEAST.getFoodDescription());
				rationsStr = Rations.FEAST.toString();
			}

			if (event.getSource().equals(rdbtnStopped)) {
				lblPaceDescrip.setText(Pace.STOPPED.getDescription());
				lblPaceMilesDescrip.setText(Pace.STOPPED.getMilesDescription());
				paceStr = Pace.STOPPED.toString();
			} else if (event.getSource().equals(rdbtnSlow)) {
				lblPaceDescrip.setText(Pace.SLOW.getDescription());
				lblPaceMilesDescrip.setText(Pace.SLOW.getMilesDescription());
				paceStr = Pace.SLOW.toString();
			} else if (event.getSource().equals(rdbtnModerate)) {
				lblPaceDescrip.setText(Pace.MODERATE.getDescription());
				lblPaceMilesDescrip.setText(Pace.MODERATE.getMilesDescription());
				paceStr = Pace.MODERATE.toString();
			} else if (event.getSource().equals(rdbtnExhausting)) {
				lblPaceDescrip.setText(Pace.EXHAUSTING.getDescription());
				lblPaceMilesDescrip.setText(Pace.EXHAUSTING.getMilesDescription());
				paceStr = Pace.EXHAUSTING.toString();
			} else if (event.getSource().equals(rdbtnLudicrous)) {
				lblPaceDescrip.setText(Pace.LUDICROUS.getDescription());
				lblPaceMilesDescrip.setText(Pace.LUDICROUS.getMilesDescription());
				paceStr = Pace.LUDICROUS.toString();
			}

			if (event.getSource().equals(rdbtnMarch)) {
				dateStr = 3;
			} else if (event.getSource().equals(rdbtnApril)) {
				dateStr = 4;
			} else if (event.getSource().equals(rdbtnMay)) {
				dateStr = 5;
			} else if (event.getSource().equals(rdbtnJune)) {
				dateStr = 6;
			} else if (event.getSource().equals(rdbtnJuly)) {
				dateStr = 7;
			} else if (event.getSource().equals(rdbtnAugust)) {
				dateStr = 8;
			}
		}
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == nextButton) {

				frame.getGameLogic().setPace(paceStr);
				frame.getGameLogic().setRations(rationsStr);
				frame.getGameLogic().setStartMonth(dateStr);

				frame.displayStore();
			} else if (e.getSource() == backButton) {
				frame.playerCreation();
			}
		}
	}
}
