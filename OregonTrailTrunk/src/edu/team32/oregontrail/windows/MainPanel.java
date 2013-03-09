package edu.team32.oregontrail.windows;

import edu.team32.oregontrail.data.Map;
import edu.team32.oregontrail.game.frame.GameFrame;
import edu.team32.oregontrail.interfaces.Frame;
import edu.team32.oregontrail.inventory.Inventory;
import edu.team32.oregontrail.swing.CustomButton;
import edu.team32.oregontrail.enums.*;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;



import java.awt.Dimension;
import javax.swing.border.LineBorder;
import edu.team32.oregontrail.swing.ImagePanel;
import javax.swing.ImageIcon;

public class MainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7123864343111295863L;
	private Frame frame;
	private final JPanel mainPanel = new JPanel();
	private final ButtonGroup buttonGroupPace = new ButtonGroup();
	private final ButtonGroup buttonGroupRations = new ButtonGroup();
	private CardLayout cardLayout = new CardLayout(0, 0);
	private JButton btnStatus, btnRations, btnShop, btnTrade, btnStart, btnPace,
		btnHunt, btnMap, btnRiverAccept, btnLoadGame;
	private JButton btnAcceptPace;
	private JRadioButton rdbtnStopped, rdbtnSlow, rdbtnModerate, rdbtnExhausting,
	rdbtnLudicrous, rdbtnNone, rdbtnScraps, rdbtnMeager, rdbtnAverage, rdbtnFeast;
	private JButton btnAcceptRations;
	private String rationsStr;
	private String paceStr;
	private JLabel lblCompstat4, lblCompstat3, lblPlayerstat, lblComp1stat, lblCompstat2,
		lblPaceVar, lblRationVar, lblFoodVar, lblCurMonVar, lblCurWeightVar, lblDistanceTraveled,
		lblDistanceToMilestone, lblDisTrav, lblDisMile, lblDate, lblCurrentLocation, lblInventory, 
		lblOxen, lblAxles, lblTongues, lblWheels, lblClothes, lblFood, lblBoxesOfBullets, lblOxenVar, 
		lblAxleVar, lblTongueVar, lblWheelVar, lblClothesVar, lblFoodInvVar, lblBoxBulletsVar;
	private JTextPane textPanePaceDescrip, textPanePaceDescrip2, textPaneRationsDescrip, textPaneRationsDescrip2;
	private JTextArea textArea;
	private boolean isStarted = false;
	
	private Timer turnTimer;
	private JPanel riverPanel;
	private JLabel lblTimeCross;
	private JRadioButton rdbtnFordTheRiver, rdbtnCaulkTheWagon, rdbtnAskForHelp;
	private final ButtonGroup buttonGroupRiver = new ButtonGroup();
	private JButton btnInventory;
	private JPanel inventoryPanel;
	private JButton btnContinue;
	private JTextPane textPaneRiverDescrip;
	private ImagePanel animationPanel;
	private JButton btnSaveGame;
	private boolean altOptionPaneTriggered;
	private JLabel lblMap;
 
	/**
	 * Create the panel.
	 */
	public MainPanel(Frame frame) {
		setBackground(new Color(204, 153, 51));
		setPreferredSize(new Dimension(800, 600));
		this.frame = frame;
		turnTimer = new Timer(1000, new NextTurnTicker());
		rationsStr = frame.getGameLogic().getRations();
		paceStr = frame.getGameLogic().getPace();
		setLayout(null);
		
		btnMap = new CustomButton("Map");
		btnMap.setBackground(new Color(204, 153, 102));
		btnMap.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnMap.setBounds(0, 5, 148, 70);
		btnMap.addActionListener(new ButtonListener());
		add(btnMap);
		
		btnStatus = new CustomButton("Status");
		btnStatus.setBackground(new Color(204, 153, 102));
		btnStatus.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnStatus.setBounds(0, 85, 148, 70);
		btnStatus.addActionListener(new ButtonListener());
		add(btnStatus);
		
		btnRations = new CustomButton("Rations");
		btnRations.setBackground(new Color(204, 153, 102));
		btnRations.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnRations.setBounds(0, 165, 148, 70);
		btnRations.addActionListener(new ButtonListener());
		add(btnRations);
		
		btnShop = new CustomButton("Shop");
		btnShop.setBackground(new Color(204, 153, 102));
		btnShop.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnShop.setBounds(651, 5, 149, 70);
		btnShop.addActionListener(new ButtonListener());
		add(btnShop);
		
		btnTrade = new CustomButton("Trade");
		btnTrade.setBackground(new Color(204, 153, 102));
		btnTrade.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnTrade.setBounds(651, 85, 149, 70);
		btnTrade.addActionListener(new ButtonListener());
		add(btnTrade);
		
		btnStart = new CustomButton("Start");
		btnStart.setBackground(new Color(204, 153, 102));
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnStart.setBounds(651, 245, 149, 70);
		btnStart.addActionListener(new ButtonListener());
		add(btnStart);
		
		btnPace = new CustomButton("Pace");
		btnPace.setBackground(new Color(204, 153, 102));
		btnPace.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnPace.setBounds(0, 245, 148, 70);
		btnPace.addActionListener(new ButtonListener());
		add(btnPace);
		
		btnHunt = new CustomButton("Hunt");
		btnHunt.setBackground(new Color(204, 153, 102));
		btnHunt.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnHunt.setBounds(651, 165, 149, 70);
		btnHunt.addActionListener(new ButtonListener());
		add(btnHunt);
		
		animationPanel = new ImagePanel();
		animationPanel.changeImage(frame.getGameLogic().getImage());
		animationPanel.setBackground(Color.ORANGE);
		animationPanel.setBounds(340, 320, 460, 280);
		add(animationPanel);
		
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		infoPanel.setBackground(new Color(255, 204, 51));
		infoPanel.setLayout(null);
		infoPanel.setBounds(0, 320, 340, 280);
		add(infoPanel);
		
		JLabel lblPastEvents = new JLabel("Past Events");
		lblPastEvents.setBackground(new Color(255, 204, 102));
		lblPastEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblPastEvents.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPastEvents.setBounds(0, 0, 340, 40);
		infoPanel.add(lblPastEvents);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 40, 341, 241);
		infoPanel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setBorder(null);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		textArea.setBackground(new Color(255, 204, 100));
		mainPanel.setBorder(new MatteBorder(2, 4, 2, 4, (Color) new Color(0, 0, 0)));
		mainPanel.setBounds(148, 0, 503, 320);
		add(mainPanel);
		mainPanel.setLayout(cardLayout);
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(new Color(204, 153, 51));
		mainPanel.add(statusPanel, "name_111193933058323");
		statusPanel.setLayout(null);
		
		btnSaveGame = new CustomButton("Save Game");
		btnSaveGame.setBackground(new Color(204, 153, 102));
		btnSaveGame.setBounds(379, 285, 106, 23);
		btnSaveGame.addActionListener(new ButtonListener());
		statusPanel.add(btnSaveGame);
		
		JLabel lblCondition = new JLabel("Distance:");
		lblCondition.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCondition.setBounds(10, 11, 89, 23);
		statusPanel.add(lblCondition);
		
		lblDistanceTraveled = new JLabel("Distance Travelled:");
		lblDistanceTraveled.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDistanceTraveled.setBounds(10, 34, 110, 20);
		statusPanel.add(lblDistanceTraveled);
		
		lblDistanceToMilestone = new JLabel("Distance to Next Milestone:");
		lblDistanceToMilestone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDistanceToMilestone.setBounds(10, 65, 167, 20);
		statusPanel.add(lblDistanceToMilestone);
		
		JLabel lblWagon = new JLabel("Wagon:");
		lblWagon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWagon.setBounds(10, 96, 89, 23);
		statusPanel.add(lblWagon);
		
		JLabel lblRations = new JLabel("Rations:");
		lblRations.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRations.setBounds(10, 160, 70, 20);
		statusPanel.add(lblRations);
		
		JLabel lblHealth = new JLabel("Current Money:");
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHealth.setBounds(10, 220, 89, 20);
		statusPanel.add(lblHealth);
		
		lblDate = new JLabel(frame.getGameLogic().getDate());
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBounds(333, 34, 70, 20);
		statusPanel.add(lblDate);
		
		lblCurrentLocation = new JLabel(frame.getGameLogic().currentLocation());
		lblCurrentLocation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurrentLocation.setBounds(333, 65, 116, 20);
		statusPanel.add(lblCurrentLocation);
		
		JLabel lblPace = new JLabel("Pace:");
		lblPace.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPace.setBounds(10, 130, 70, 20);
		statusPanel.add(lblPace);
		
		JLabel lblFoodLeft = new JLabel("Food Left: ");
		lblFoodLeft.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFoodLeft.setBounds(10, 190, 70, 20);
		statusPanel.add(lblFoodLeft);
		
		lblPaceVar = new JLabel(frame.getGameLogic().getPace());
		lblPaceVar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPaceVar.setBounds(107, 130, 70, 20);
		statusPanel.add(lblPaceVar);
		
		lblRationVar = new JLabel(frame.getGameLogic().getRations());
		lblRationVar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRationVar.setBounds(107, 160, 70, 20);
		statusPanel.add(lblRationVar);
		
		lblFoodVar = new JLabel(frame.getGameLogic().calcInventory(Inventory.FOOD, false)+" lbs");
		lblFoodVar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFoodVar.setBounds(107, 190, 70, 20);
		statusPanel.add(lblFoodVar);
		
		JLabel lblHealthVar = new JLabel("Party:");
		lblHealthVar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHealthVar.setBounds(217, 98, 70, 20);
		statusPanel.add(lblHealthVar);
		
		JLabel lblPlayer = new JLabel(frame.getGameLogic().getPlayerName());
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPlayer.setBounds(217, 130, 120, 20);
		statusPanel.add(lblPlayer);
		
		JLabel lblComp1 = new JLabel(frame.getGameLogic().getCompanionName(0));
		lblComp1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblComp1.setBounds(217, 160, 120, 20);
		statusPanel.add(lblComp1);
		
		JLabel lblComp2 = new JLabel(frame.getGameLogic().getCompanionName(1));
		lblComp2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblComp2.setBounds(217, 190, 120, 20);
		statusPanel.add(lblComp2);
		
		JLabel lblComp3 = new JLabel(frame.getGameLogic().getCompanionName(2));
		lblComp3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblComp3.setBounds(217, 220, 120, 20);
		statusPanel.add(lblComp3);
		
		JLabel lblComp4 = new JLabel(frame.getGameLogic().getCompanionName(3));
		lblComp4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblComp4.setBounds(217, 250, 120, 20);
		statusPanel.add(lblComp4);
		
		lblPlayerstat = new JLabel(frame.getGameLogic().getPlayerStatus());
		lblPlayerstat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPlayerstat.setBounds(347, 130, 138, 20);
		statusPanel.add(lblPlayerstat);
		
		lblComp1stat = new JLabel(frame.getGameLogic().getCompanionStatus(0));
		lblComp1stat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblComp1stat.setBounds(347, 160, 138, 20);
		statusPanel.add(lblComp1stat);
		
		lblCompstat2 = new JLabel(frame.getGameLogic().getCompanionStatus(1));
		lblCompstat2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCompstat2.setBounds(347, 190, 138, 20);
		statusPanel.add(lblCompstat2);
		
		lblCompstat3 = new JLabel(frame.getGameLogic().getCompanionStatus(2));
		lblCompstat3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCompstat3.setBounds(347, 220, 138, 20);
		statusPanel.add(lblCompstat3);
		
		lblCompstat4 = new JLabel(frame.getGameLogic().getCompanionStatus(3));
		lblCompstat4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCompstat4.setBounds(347, 250, 138, 20);
		statusPanel.add(lblCompstat4);
		
		lblDisMile = new JLabel(frame.getGameLogic().getDistanceToNextMilestone());
		lblDisMile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDisMile.setBounds(169, 65, 28, 20);
		statusPanel.add(lblDisMile);
		
		lblDisTrav = new JLabel(frame.getGameLogic().getTotalTraveled());
		lblDisTrav.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDisTrav.setBounds(169, 34, 28, 20);
		statusPanel.add(lblDisTrav);
		
		JLabel lblCurrentWeight = new JLabel("Current Weight:");
		lblCurrentWeight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurrentWeight.setBounds(10, 250, 89, 20);
		statusPanel.add(lblCurrentWeight);
		
		lblCurMonVar = new JLabel("$"+frame.getGameLogic().getPlayerMoney());
		lblCurMonVar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurMonVar.setBounds(107, 220, 70, 20);
		statusPanel.add(lblCurMonVar);
		
		lblCurWeightVar = new JLabel(frame.getGameLogic().totalWeight()+" lbs");
		lblCurWeightVar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurWeightVar.setBounds(107, 250, 70, 20);
		statusPanel.add(lblCurWeightVar);
		
		JLabel lblCurLoc = new JLabel("Current Location:");
		lblCurLoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurLoc.setBounds(217, 65, 110, 20);
		statusPanel.add(lblCurLoc);
		
		JLabel lblCurrentDate = new JLabel("Current Date:");
		lblCurrentDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurrentDate.setBounds(217, 34, 110, 20);
		statusPanel.add(lblCurrentDate);
		
		btnInventory = new CustomButton("Inventory");
		btnInventory.setBackground(new Color(204, 153, 102));
		btnInventory.setBounds(10, 285, 91, 23);
		btnInventory.addActionListener(new ButtonListener());
		statusPanel.add(btnInventory);
		
		btnLoadGame = new CustomButton("Save Game");
		btnLoadGame.setText("Load Game");
		btnLoadGame.setBackground(new Color(204, 153, 102));
		btnLoadGame.setBounds(181, 285, 106, 23);
		btnLoadGame.addActionListener(new ButtonListener());
		statusPanel.add(btnLoadGame);
		
		JPanel rationsPanel = new JPanel();
		rationsPanel.setBackground(new Color(204, 153, 51));
		mainPanel.add(rationsPanel, "name_111214532705471");
		rationsPanel.setLayout(null);
		
		JLabel lblChooseYourRations = new JLabel("Choose Your Rations:");
		lblChooseYourRations.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblChooseYourRations.setBounds(10, 11, 267, 35);
		rationsPanel.add(lblChooseYourRations);
		
		rdbtnNone = new JRadioButton("None");
		rdbtnNone.setBackground(new Color(204, 153, 51));
		buttonGroupRations.add(rdbtnNone);
		rdbtnNone.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnNone.setBounds(10, 60, 109, 23);
		rdbtnNone.addActionListener(new RadioButtonListener());
		rationsPanel.add(rdbtnNone);
		
		rdbtnScraps = new JRadioButton("Scraps");
		rdbtnScraps.setBackground(new Color(204, 153, 51));
		buttonGroupRations.add(rdbtnScraps);
		rdbtnScraps.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnScraps.setBounds(10, 100, 109, 23);
		rdbtnScraps.addActionListener(new RadioButtonListener());
		rationsPanel.add(rdbtnScraps);
		
		rdbtnMeager = new JRadioButton("Meager");
		rdbtnMeager.setBackground(new Color(204, 153, 51));
		buttonGroupRations.add(rdbtnMeager);
		rdbtnMeager.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnMeager.setBounds(10, 140, 154, 23);
		rdbtnMeager.addActionListener(new RadioButtonListener());
		rationsPanel.add(rdbtnMeager);
		
		rdbtnAverage = new JRadioButton("Average");
		rdbtnAverage.setBackground(new Color(204, 153, 51));
		buttonGroupRations.add(rdbtnAverage);
		rdbtnAverage.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnAverage.setBounds(10, 180, 140, 23);
		rdbtnAverage.addActionListener(new RadioButtonListener());
		rationsPanel.add(rdbtnAverage);
		
		rdbtnFeast = new JRadioButton("Feast");
		rdbtnFeast.setBackground(new Color(204, 153, 51));
		buttonGroupRations.add(rdbtnFeast);
		rdbtnFeast.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnFeast.setBounds(10, 220, 140, 23);
		rdbtnFeast.addActionListener(new RadioButtonListener());
		rationsPanel.add(rdbtnFeast);
		
		textPaneRationsDescrip = new JTextPane();
		textPaneRationsDescrip.setBackground(new Color(204, 153, 102));
		textPaneRationsDescrip.setBounds(249, 62, 206, 101);
		rationsPanel.add(textPaneRationsDescrip);
		
		btnAcceptRations = new CustomButton("Accept");
		btnAcceptRations.setBackground(new Color(204, 153, 102));
		btnAcceptRations.setBounds(407, 285, 78, 23);
		btnAcceptRations.addActionListener(new ButtonListener());
		rationsPanel.add(btnAcceptRations);
		
		textPaneRationsDescrip2 = new JTextPane();
		textPaneRationsDescrip2.setBackground(new Color(204, 153, 102));
		textPaneRationsDescrip2.setBounds(249, 180, 206, 101);
		rationsPanel.add(textPaneRationsDescrip2);
		
		JPanel pacePanel = new JPanel();
		pacePanel.setBackground(new Color(204, 153, 51));
		mainPanel.add(pacePanel, "name_111220744712682");
		pacePanel.setLayout(null);
		
		JLabel lblChoosePace = new JLabel("Choose Your Pace:");
		lblChoosePace.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblChoosePace.setBounds(10, 11, 240, 35);
		pacePanel.add(lblChoosePace);
		
		rdbtnStopped = new JRadioButton("Stopped");
		rdbtnStopped.setBackground(new Color(204, 153, 51));
		buttonGroupPace.add(rdbtnStopped);
		rdbtnStopped.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnStopped.setBounds(10, 60, 109, 23);
		rdbtnStopped.addActionListener(new RadioButtonListener());
		pacePanel.add(rdbtnStopped);
		
		rdbtnSlow = new JRadioButton("Slow");
		rdbtnSlow.setBackground(new Color(204, 153, 51));
		buttonGroupPace.add(rdbtnSlow);
		rdbtnSlow.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnSlow.setBounds(10, 100, 109, 23);
		rdbtnSlow.addActionListener(new RadioButtonListener());
		pacePanel.add(rdbtnSlow);
		
		rdbtnModerate = new JRadioButton("Moderate");
		rdbtnModerate.setBackground(new Color(204, 153, 51));
		buttonGroupPace.add(rdbtnModerate);
		rdbtnModerate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnModerate.setBounds(10, 140, 154, 23);
		rdbtnModerate.addActionListener(new RadioButtonListener());
		pacePanel.add(rdbtnModerate);
		
		rdbtnExhausting = new JRadioButton("Exhausting");
		rdbtnExhausting.setBackground(new Color(204, 153, 51));
		buttonGroupPace.add(rdbtnExhausting);
		rdbtnExhausting.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnExhausting.setBounds(10, 180, 140, 23);
		rdbtnExhausting.addActionListener(new RadioButtonListener());
		pacePanel.add(rdbtnExhausting);
		
		rdbtnLudicrous = new JRadioButton("Ludicrous");
		rdbtnLudicrous.setBackground(new Color(204, 153, 51));
		buttonGroupPace.add(rdbtnLudicrous);
		rdbtnLudicrous.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnLudicrous.setBounds(10, 220, 140, 23);
		rdbtnLudicrous.addActionListener(new RadioButtonListener());
		pacePanel.add(rdbtnLudicrous);
		
		textPanePaceDescrip = new JTextPane();
		textPanePaceDescrip.setBackground(new Color(204, 153, 102));
		textPanePaceDescrip.setBounds(249, 62, 206, 101);
		pacePanel.add(textPanePaceDescrip);
		
		btnAcceptPace = new CustomButton("Accept");
		btnAcceptPace.setBackground(new Color(204, 153, 102));
		btnAcceptPace.setBounds(407, 285, 78, 23);
		btnAcceptPace.addActionListener(new ButtonListener());
		pacePanel.add(btnAcceptPace);
		
		textPanePaceDescrip2 = new JTextPane();
		textPanePaceDescrip2.setBackground(new Color(204, 153, 102));
		textPanePaceDescrip2.setBounds(249, 180, 206, 101);
		pacePanel.add(textPanePaceDescrip2);
		
		JPanel mapPanel = new JPanel();
		mainPanel.add(mapPanel, "name_111224416295317");
		mapPanel.setLayout(null);
		
		lblMap = new JLabel("");
		lblMap.setIcon(new ImageIcon(MainPanel.class.getResource("/images/trailmap1.jpg")));
		lblMap.setBounds(0, 0, 495, 316);
		mapPanel.add(lblMap);
		
		riverPanel = new JPanel();
		riverPanel.setBackground(new Color(204, 153, 51));
		mainPanel.add(riverPanel, "name_113343683034906");
		riverPanel.setLayout(null);
		
		lblTimeCross = new JLabel("Time to Cross!");
		lblTimeCross.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTimeCross.setBounds(152, 11, 200, 34);
		riverPanel.add(lblTimeCross);
		
		rdbtnFordTheRiver = new JRadioButton("Ford the river");
		rdbtnFordTheRiver.setBackground(new Color(204, 153, 51));
		rdbtnFordTheRiver.setSelected(true);
		buttonGroupRiver.add(rdbtnFordTheRiver);
		rdbtnFordTheRiver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnFordTheRiver.setBounds(10, 160, 149, 33);
		rdbtnFordTheRiver.addActionListener(new RadioButtonListener());
		riverPanel.add(rdbtnFordTheRiver);
		
		rdbtnCaulkTheWagon = new JRadioButton("Caulk the wagon and float");
		rdbtnCaulkTheWagon.setBackground(new Color(204, 153, 51));
		buttonGroupRiver.add(rdbtnCaulkTheWagon);
		rdbtnCaulkTheWagon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnCaulkTheWagon.setBounds(10, 200, 263, 33);
		rdbtnCaulkTheWagon.addActionListener(new RadioButtonListener());
		riverPanel.add(rdbtnCaulkTheWagon);
		
		rdbtnAskForHelp = new JRadioButton("Ask for help crossing($10)");
		rdbtnAskForHelp.setBackground(new Color(204, 153, 51));
		buttonGroupRiver.add(rdbtnAskForHelp);
		rdbtnAskForHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnAskForHelp.setBounds(10, 240, 261, 33);
		rdbtnAskForHelp.addActionListener(new RadioButtonListener());
		riverPanel.add(rdbtnAskForHelp);
		
		btnRiverAccept = new CustomButton("Accept");
		btnRiverAccept.setBackground(new Color(204, 153, 102));
		btnRiverAccept.setBounds(396, 285, 89, 23);
		riverPanel.add(btnRiverAccept);
		btnRiverAccept.addActionListener(new ButtonListener());
		
		textPaneRiverDescrip = new JTextPane();
		textPaneRiverDescrip.setBackground(new Color(204, 153, 51));
		textPaneRiverDescrip.setBounds(279, 171, 206, 90);
		textPaneRiverDescrip.setText("You will try to ford across the river, however, if the river is too deep there is a high chance that your wagon will flip over and you may lose items.");
		riverPanel.add(textPaneRiverDescrip);
		
		JLabel lblCrossingWarning = new JLabel("You are at a river crossing its time to make a decision on how to cross. ");
		lblCrossingWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrossingWarning.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrossingWarning.setBounds(10, 56, 475, 17);
		riverPanel.add(lblCrossingWarning);
		
		JLabel lblChooseWisely = new JLabel("Choose Wisely");
		lblChooseWisely.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblChooseWisely.setBounds(156, 84, 188, 32);
		riverPanel.add(lblChooseWisely);
		
		inventoryPanel = new JPanel();
		inventoryPanel.setBackground(new Color(204, 153, 51));
		mainPanel.add(inventoryPanel, "name_265723889968115");
		inventoryPanel.setLayout(null);
		
		lblInventory = new JLabel("Your Inventory");
		lblInventory.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblInventory.setBounds(160, 11, 182, 29);
		inventoryPanel.add(lblInventory);
		
		lblOxen = new JLabel("Oxen:");
		lblOxen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOxen.setBounds(10, 50, 47, 22);
		inventoryPanel.add(lblOxen);
		
		lblAxles = new JLabel("Axles:");
		lblAxles.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAxles.setBounds(10, 90, 47, 22);
		inventoryPanel.add(lblAxles);
		
		lblTongues = new JLabel("Tongues:");
		lblTongues.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTongues.setBounds(10, 130, 74, 22);
		inventoryPanel.add(lblTongues);
		
		lblWheels = new JLabel("Wheels:");
		lblWheels.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWheels.setBounds(10, 170, 62, 22);
		inventoryPanel.add(lblWheels);
		
		lblClothes = new JLabel("Clothes:");
		lblClothes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClothes.setBounds(10, 210, 64, 22);
		inventoryPanel.add(lblClothes);
		
		lblFood = new JLabel("Food:");
		lblFood.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFood.setBounds(10, 250, 45, 22);
		inventoryPanel.add(lblFood);
		
		lblBoxesOfBullets = new JLabel("Boxes of Bullets:");
		lblBoxesOfBullets.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBoxesOfBullets.setBounds(10, 290, 133, 22);
		inventoryPanel.add(lblBoxesOfBullets);
		
		lblOxenVar = new JLabel(Integer.toString(frame.getGameLogic().calcInventory(Inventory.OXEN, false)));
		lblOxenVar.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOxenVar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOxenVar.setBounds(406, 50, 79, 22);
		inventoryPanel.add(lblOxenVar);
		
		lblAxleVar = new JLabel(Integer.toString(frame.getGameLogic().calcInventory(Inventory.AXLES, false)));
		lblAxleVar.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAxleVar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAxleVar.setBounds(406, 90, 79, 22);
		inventoryPanel.add(lblAxleVar);
		
		lblTongueVar = new JLabel(Integer.toString(frame.getGameLogic().calcInventory(Inventory.TONGUES, false)));
		lblTongueVar.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTongueVar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTongueVar.setBounds(406, 130, 79, 22);
		inventoryPanel.add(lblTongueVar);
		
		lblWheelVar = new JLabel(Integer.toString(frame.getGameLogic().calcInventory(Inventory.WHEELS, false)));
		lblWheelVar.setHorizontalAlignment(SwingConstants.TRAILING);
		lblWheelVar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWheelVar.setBounds(406, 170, 79, 22);
		inventoryPanel.add(lblWheelVar);
		
		lblClothesVar = new JLabel(Integer.toString(frame.getGameLogic().calcInventory(Inventory.CLOTHES, false)));
		lblClothesVar.setHorizontalAlignment(SwingConstants.TRAILING);
		lblClothesVar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClothesVar.setBounds(406, 210, 79, 22);
		inventoryPanel.add(lblClothesVar);
		
		lblFoodInvVar = new JLabel(Integer.toString(frame.getGameLogic().calcInventory(Inventory.FOOD, false)) + " lbs");
		lblFoodInvVar.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFoodInvVar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFoodInvVar.setBounds(406, 250, 79, 22);
		inventoryPanel.add(lblFoodInvVar);
		
		lblBoxBulletsVar = new JLabel(Integer.toString(frame.getGameLogic().calcInventory(Inventory.BULLETBOXES, false)));
		lblBoxBulletsVar.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBoxBulletsVar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBoxBulletsVar.setBounds(406, 290, 79, 22);
		inventoryPanel.add(lblBoxBulletsVar);
		
		btnContinue = new CustomButton("Continue");
		btnContinue.setBackground(new Color(204, 153, 102));
		btnContinue.setBounds(396, 11, 89, 23);
		btnContinue.addActionListener(new ButtonListener());
		inventoryPanel.add(btnContinue);
	}
	public void loadEvents(String events)
	{
		textArea.append(events);
	}
	private String saveEvents()
	{
		return textArea.getText();
	}
	private void setPaceButton(){
		String pace = frame.getGameLogic().getPace();
		if(pace.equals(Pace.STOPPED.toString()))
		{
			rdbtnStopped.setSelected(true);
			textPanePaceDescrip.setText(Pace.STOPPED.getDescription());
			textPanePaceDescrip2.setText("You will travel " + Pace.STOPPED.getMilesMovedPerTurn() + " miles per day.");
		}
		else if(pace.equals(Pace.SLOW.toString()))
		{
			rdbtnSlow.setSelected(true);
			textPanePaceDescrip.setText(Pace.SLOW.getDescription());
			textPanePaceDescrip2.setText("You will travel " + Pace.SLOW.getMilesMovedPerTurn() + " miles per day.");
		}
		else if(pace.equals(Pace.MODERATE.toString()))
		{
			rdbtnModerate.setSelected(true);
			textPanePaceDescrip.setText(Pace.MODERATE.getDescription());
			textPanePaceDescrip2.setText("You will travel " + Pace.MODERATE.getMilesMovedPerTurn() + " miles per day.");
		}
		else if(pace.equals(Pace.EXHAUSTING.toString()))
		{
			rdbtnExhausting.setSelected(true);
			textPanePaceDescrip.setText(Pace.EXHAUSTING.getDescription());
			textPanePaceDescrip2.setText("You will travel " + Pace.EXHAUSTING.getMilesMovedPerTurn() + " miles per day.");		
		}
		else if(pace.equals(Pace.LUDICROUS.toString()))
		{
			rdbtnLudicrous.setSelected(true);
			textPanePaceDescrip.setText(Pace.LUDICROUS.getDescription());
			textPanePaceDescrip2.setText("You will travel " + Pace.LUDICROUS.getMilesMovedPerTurn() + " miles per day.");
		}	

	}
	
	private void updateInventoryPanel(){
		lblOxenVar.setText(Integer.toString(frame.getGameLogic().calcInventory(Inventory.OXEN, false)));
		lblAxleVar.setText(Integer.toString(frame.getGameLogic().calcInventory(Inventory.AXLES, false)));
		lblTongueVar.setText(Integer.toString(frame.getGameLogic().calcInventory(Inventory.TONGUES, false)));
		lblWheelVar.setText(Integer.toString(frame.getGameLogic().calcInventory(Inventory.WHEELS, false)));
		lblClothesVar.setText(Integer.toString(frame.getGameLogic().calcInventory(Inventory.CLOTHES, false)));
		lblFoodInvVar.setText(Integer.toString(frame.getGameLogic().calcInventory(Inventory.FOOD, false))+ " lbs");
		lblBoxBulletsVar.setText(Integer.toString(frame.getGameLogic().calcInventory(Inventory.BULLETBOXES, false)));
	}
	
	private void setRationsButton(){
		String rations = frame.getGameLogic().getRations();
		if(rations.equals(Rations.NONE.toString()))
		{
			rdbtnNone.setSelected(true);
			textPaneRationsDescrip.setText(Rations.NONE.getDescription());
			textPaneRationsDescrip2.setText(Rations.NONE.getFoodDescription());
		}
		else if(rations.equals(Rations.SCRAPS.toString()))
		{
			rdbtnScraps.setSelected(true);
			textPaneRationsDescrip.setText(Rations.MEAGER.getDescription());
			textPaneRationsDescrip2.setText(Rations.MEAGER.getFoodDescription());
		}
		else if(rations.equals(Rations.MEAGER.toString()))
		{
			rdbtnMeager.setSelected(true);
			textPaneRationsDescrip.setText(Rations.SCRAPS.getDescription());
			textPaneRationsDescrip2.setText(Rations.SCRAPS.getFoodDescription());
		}
		else if(rations.equals(Rations.AVERAGE.toString()))
		{
			rdbtnAverage.setSelected(true);
			textPaneRationsDescrip.setText(Rations.AVERAGE.getDescription());
			textPaneRationsDescrip2.setText(Rations.AVERAGE.getFoodDescription());
		}
		else if(rations.equals(Rations.FEAST.toString()))
		{
			rdbtnFeast.setSelected(true);
			textPaneRationsDescrip.setText(Rations.FEAST.getDescription());
			textPaneRationsDescrip2.setText(Rations.FEAST.getFoodDescription());
		}
	}
	
	public void update()
	{
		lblPaceVar.setText(frame.getGameLogic().getPace());
		lblRationVar.setText(frame.getGameLogic().getRations());
		lblFoodVar.setText(frame.getGameLogic().calcInventory(Inventory.FOOD, false)+" lbs");
		lblPlayerstat.setText(frame.getGameLogic().getPlayerStatus());
		lblComp1stat.setText(frame.getGameLogic().getCompanionStatus(0));
		lblCompstat2.setText(frame.getGameLogic().getCompanionStatus(1));
		lblCompstat3.setText(frame.getGameLogic().getCompanionStatus(2));
		lblCompstat4.setText(frame.getGameLogic().getCompanionStatus(3));
		lblCurWeightVar.setText(frame.getGameLogic().totalWeight()+" lbs");
		lblCurMonVar.setText("$"+frame.getGameLogic().getPlayerMoney());
		lblDisTrav.setText(frame.getGameLogic().getTotalTraveled());
		lblDisMile.setText(frame.getGameLogic().getDistanceToNextMilestone());
		lblCurrentLocation.setText(frame.getGameLogic().currentLocation());
		lblDate.setText(frame.getGameLogic().getDate());
		animationPanel.changeImage(frame.getGameLogic().getImage());
	}
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnStatus))
			{
				cardLayout.show(mainPanel, "name_111193933058323");
			}
			if(e.getSource().equals(btnMap))
			{
				turnTimer.stop();
				btnStart.setText("Start");
				cardLayout.show(mainPanel, "name_111224416295317");
				int mapIndex = (frame.getGameLogic().getCurrentMilestoneIndex()+1);
				if(mapIndex > 17)
				{
					mapIndex = 17;
				}
				lblMap.setIcon(new ImageIcon(MainPanel.class.getResource("/images/trailmap"+mapIndex+".jpg")));
			}
			else if(e.getSource().equals(btnHunt))
			{
				if(frame.getGameLogic().hasBullets() && !frame.getGameLogic().isAtMilestone())
				{
				turnTimer.stop();
				btnStart.setText("Start");
				frame.startHunting();
				}
				else if(frame.getGameLogic().isAtMilestone())
				{
					JOptionPane.showMessageDialog(MainPanel.this, "You are at a milestone you are unable to hunt.", "Milestone Warning", JOptionPane.WARNING_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(MainPanel.this, "You have no ammo to go hunting with.", "No Bullets Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
			else if(e.getSource().equals(btnPace))
			{
				turnTimer.stop();
				btnStart.setEnabled(false);
				btnMap.setEnabled(false);
				btnStatus.setEnabled(false);
				btnRations.setEnabled(false);
				btnTrade.setEnabled(false);
				btnHunt.setEnabled(false);
				btnShop.setEnabled(false);
				
				setPaceButton();
				cardLayout.show(mainPanel, "name_111220744712682");
			}
			else if(e.getSource().equals(btnRations))
			{
				turnTimer.stop();

				btnStart.setEnabled(false);
				btnMap.setEnabled(false);
				btnStatus.setEnabled(false);
				btnPace.setEnabled(false);
				btnTrade.setEnabled(false);
				btnHunt.setEnabled(false);
				btnShop.setEnabled(false);
				setRationsButton();
				cardLayout.show(mainPanel, "name_111214532705471");
			}
			else if(e.getSource().equals(btnMap))
			{
				//turnTimer.stop();
				//btnStart.setEnabled(false);
				//frame.displayFinal();
				//cardLayout.show(mainPanel, "name_111193933058323");
			}	
			else if(e.getSource().equals(btnAcceptRations))
			{
				if(isStarted)
				{
				turnTimer.start();
				}
				btnStart.setEnabled(true);
				btnMap.setEnabled(true);
				btnStatus.setEnabled(true);
				btnPace.setEnabled(true);
				btnTrade.setEnabled(true);
				btnHunt.setEnabled(true);
				btnShop.setEnabled(true);
				frame.getGameLogic().setRations(rationsStr);
				update();
				cardLayout.show(mainPanel, "name_111193933058323");
			}
			else if(e.getSource().equals(btnAcceptPace))
			{
				if(isStarted)
				{
				turnTimer.start();
				}
				btnStart.setEnabled(true);
				btnMap.setEnabled(true);
				btnStatus.setEnabled(true);
				btnRations.setEnabled(true);
				btnTrade.setEnabled(true);
				btnHunt.setEnabled(true);
				btnShop.setEnabled(true);
				frame.getGameLogic().setPace(paceStr);
				update();
				cardLayout.show(mainPanel, "name_111193933058323");
			}
			else if(e.getSource().equals(btnShop))
			{
				if(frame.getGameLogic().milestoneHasShop() == Map.SHOP_EXISTS)
				{
					turnTimer.stop();
					btnStart.setText("Start");
					cardLayout.show(mainPanel, "name_111193933058323");
					frame.displayStore();
				}
				else if(frame.getGameLogic().milestoneHasShop() == Map.NO_SHOP)
					JOptionPane.showMessageDialog(MainPanel.this, "This milestone has no shop.", "No Shop Warning", JOptionPane.WARNING_MESSAGE);
				else 
					JOptionPane.showMessageDialog(MainPanel.this, "You are in motion, you are unable to shop now.", "In Motion Warning", JOptionPane.WARNING_MESSAGE);
			}
			else if(e.getSource().equals(btnHunt)) {
				//Gives you more food, temporary fix before hunting game is actually added
				frame.getGameLogic().simulateHunt();
				update();
			}
			else if(e.getSource().equals(btnStart))
			{
				if(turnTimer.isRunning()) {
					btnStart.setText("Start");
					isStarted = false;
					turnTimer.stop();
				}
				else {
					btnStart.setText("Stop");
					isStarted = true;
					turnTimer.start();
				}
				if(frame.getGameLogic().getCurrentMilestone().hasAlternativePath() && !altOptionPaneTriggered)
				{
					turnTimer.stop();
					btnStart.setText("Start");
					int option = JOptionPane.showConfirmDialog(MainPanel.this, "You are at a fork in the roads, would you like to take the South Route to resupply?", "I know you love this Bowden", JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION)
					{
						frame.getGameLogic().takeAlternativePath();
					}
					altOptionPaneTriggered = true;
					btnStart.setText("Stop");
					turnTimer.start();
					
				}
			}
			else if(e.getSource().equals(btnLoadGame))
			{
				frame.loadGame();
			}
			else if(e.getSource().equals(btnRiverAccept)) {
				
				String resultString = "";
				if(rdbtnAskForHelp.isSelected()) {
					resultString = frame.getGameLogic().crossRiver(CrossingType.HELP);
				}
				else if(rdbtnCaulkTheWagon.isSelected()) {
					resultString = frame.getGameLogic().crossRiver(CrossingType.CAULK);
				}
				else if(rdbtnFordTheRiver.isSelected()) {
					resultString = frame.getGameLogic().crossRiver(CrossingType.FORD);
				}
				update();
				turnTimer.start();
				btnStart.setText("Stop");
				textArea.append(resultString);
				btnStart.setEnabled(true);
				btnRations.setEnabled(true);
				btnMap.setEnabled(true);
				btnStatus.setEnabled(true);
				btnPace.setEnabled(true);
				btnTrade.setEnabled(true);
				btnHunt.setEnabled(true);
				btnShop.setEnabled(true);
				textPaneRiverDescrip.setText(CrossingType.FORD.getDescription());
				cardLayout.show(mainPanel,"name_111193933058323");
				
			}
			else if(e.getSource().equals(btnInventory))
			{
				turnTimer.stop();
				btnStart.setEnabled(false);
				btnMap.setEnabled(false);
				btnStatus.setEnabled(false);
				btnPace.setEnabled(false);
				btnTrade.setEnabled(false);
				btnHunt.setEnabled(false);
				btnShop.setEnabled(false);
				btnRations.setEnabled(false);
				updateInventoryPanel();
				cardLayout.show(mainPanel, "name_265723889968115");
			}
			else if(e.getSource().equals(btnContinue))
			{
				if(isStarted)
				{
				turnTimer.start();
				}
				btnStart.setEnabled(true);
				btnStart.setEnabled(true);
				btnMap.setEnabled(true);
				btnStatus.setEnabled(true);
				btnRations.setEnabled(true);
				btnTrade.setEnabled(true);
				btnHunt.setEnabled(true);
				btnShop.setEnabled(true);
				btnPace.setEnabled(true);
				cardLayout.show(mainPanel, "name_111193933058323");
			}
			else if(e.getSource().equals(btnSaveGame))
			{
				String customName = "";
				turnTimer.stop();
				
				customName = JOptionPane.showInputDialog(MainPanel.this, "Enter a name for your save game", "Save Game", JOptionPane.DEFAULT_OPTION);
				if(customName != null && customName.length() > 0)
				{
				frame.getGameLogic().saveEvents(saveEvents());
				frame.saveGame(customName);
				textArea.append("Game has been saved as " + customName + ".ser\n");
				}
				if(isStarted)
				{
					btnStart.setText("Stop");
					turnTimer.start();
				}
			}
		}
	}
	private class RadioButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(rdbtnStopped))
			{
				paceStr = Pace.STOPPED.toString();
				textPanePaceDescrip.setText(Pace.STOPPED.getDescription());
				textPanePaceDescrip2.setText(Pace.STOPPED.getMilesDescription());
			}
			else if(e.getSource().equals(rdbtnSlow))
			{
				paceStr = Pace.SLOW.toString();
				textPanePaceDescrip.setText(Pace.SLOW.getDescription());
				textPanePaceDescrip2.setText(Pace.SLOW.getMilesDescription());
			}
			else if(e.getSource().equals(rdbtnModerate))
			{
				paceStr = Pace.MODERATE.toString();
				textPanePaceDescrip.setText(Pace.MODERATE.getDescription());
				textPanePaceDescrip2.setText(Pace.MODERATE.getMilesDescription());
			}
			else if(e.getSource().equals(rdbtnExhausting))
			{
				paceStr = Pace.EXHAUSTING.toString();
				textPanePaceDescrip.setText(Pace.EXHAUSTING.getDescription());
				textPanePaceDescrip2.setText(Pace.EXHAUSTING.getMilesDescription());
			}
			else if(e.getSource().equals(rdbtnLudicrous))
			{
				paceStr = Pace.LUDICROUS.toString();
				textPanePaceDescrip.setText(Pace.LUDICROUS.getDescription());
				textPanePaceDescrip2.setText(Pace.LUDICROUS.getMilesDescription());
			}
			else if(e.getSource().equals(rdbtnNone))
			{
				rationsStr = Rations.NONE.toString();
				textPaneRationsDescrip.setText(Rations.NONE.getDescription());
				textPaneRationsDescrip2.setText(Rations.NONE.getFoodDescription());
			}
			else if(e.getSource().equals(rdbtnMeager))
			{
				rationsStr = Rations.MEAGER.toString();
				textPaneRationsDescrip.setText(Rations.MEAGER.getDescription());
				textPaneRationsDescrip2.setText(Rations.MEAGER.getFoodDescription());
			}
			else if(e.getSource().equals(rdbtnScraps))
			{
				rationsStr = Rations.SCRAPS.toString();
				textPaneRationsDescrip.setText(Rations.SCRAPS.getDescription());
				textPaneRationsDescrip2.setText(Rations.SCRAPS.getFoodDescription());
			}
			else if(e.getSource().equals(rdbtnAverage))
			{
				rationsStr = Rations.AVERAGE.toString();
				textPaneRationsDescrip.setText(Rations.AVERAGE.getDescription());
				textPaneRationsDescrip2.setText(Rations.AVERAGE.getFoodDescription());
			}
			else if(e.getSource().equals(rdbtnFeast))
			{
				rationsStr = Rations.FEAST.toString();
				textPaneRationsDescrip.setText(Rations.FEAST.getDescription());
				textPaneRationsDescrip2.setText(Rations.FEAST.getFoodDescription());
			}
			else if(e.getSource().equals(rdbtnAskForHelp))
			{
				textPaneRiverDescrip.setText(CrossingType.HELP.getDescription());
			}
			else if(e.getSource().equals(rdbtnFordTheRiver))
			{
				textPaneRiverDescrip.setText(CrossingType.FORD.getDescription());
			}
			else if(e.getSource().equals(rdbtnCaulkTheWagon))
			{
				textPaneRiverDescrip.setText(CrossingType.CAULK.getDescription());
			}
		}
		
	}
	
	private class NextTurnTicker implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String toAppend = frame.getGameLogic().nextTurn();
			
			if(toAppend.substring(toAppend.length()-10,toAppend.length()).trim().toLowerCase().equals("game over"))
			{
				turnTimer.stop();
				frame.gameOver(toAppend.substring(0, toAppend.length()-10));
			}
			else if(frame.getGameLogic().isAtMilestone()) {
				btnStart.setText("Start");
				isStarted = false;
				turnTimer.stop();
				if(frame.getGameLogic().getCurrentMilestone().getType().equals(MilestoneType.OREGON))
				{
					
					int option = JOptionPane.showConfirmDialog(MainPanel.this, "You are at the final river, would you like to play the game or take your chances", "I know you love this Bowden", JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION)
					{
						frame.playRiverCrossing();
					}
					else
					{
						//Take your chances can lose things four times
						frame.getGameLogic().removeRandomItem();
						frame.getGameLogic().removeRandomItem();
						frame.getGameLogic().removeRandomItem();
						frame.getGameLogic().removeRandomItem();
						frame.displayFinal();
					}
				}
				else if(frame.getGameLogic().getCurrentMilestone().getType().equals(MilestoneType.RIVER)) {
					if(frame.getGameLogic().getCurrentMilestone().hasFerry() == true) {
						rdbtnAskForHelp.setVisible(true);
					}
					else {
						rdbtnAskForHelp.setVisible(false);
					}
					btnStart.setEnabled(false);
					btnRations.setEnabled(false);
					btnMap.setEnabled(false);
					btnStatus.setEnabled(false);
					btnPace.setEnabled(false);
					btnTrade.setEnabled(false);
					btnHunt.setEnabled(false);
					btnShop.setEnabled(false);
					rdbtnFordTheRiver.setSelected(true);
					cardLayout.show(mainPanel,"name_113343683034906");
				}
			}
			textArea.append(toAppend);
			update();
		}
	}
}