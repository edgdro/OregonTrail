package edu.team32.oregontrail.windows;

import edu.team32.oregontrail.game.frame.GameFrame;
import edu.team32.oregontrail.interfaces.Frame;
import edu.team32.oregontrail.swing.CustomButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
/**
 * This class represents the player creation screen for the GUI.
 * 
 * @author Team 32
 *
 */
public class PlayerCreation extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1169374751523012513L;
	private JTextField nameField, comp1Field, comp4Field, comp3Field, comp2Field;
	private JButton nextButton, mainMenuButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Frame frame;
	private JRadioButton selFarm, selDoc, selCarp, selTeach, selBank;
	private String professionStr;
	boolean everythingSet = true, nameClicked = false, comp1Clicked = false, comp2Clicked = false, comp3Clicked = false, comp4Clicked = false;
	private String[] bankerInfo = {"Banker: Your wealth and status was acquired through means which many frown upon. " +
									"As a result of your wealth you have grown tired of your life in the east and wish to " +
									"travel west upon the Oregon Trail to find new riches and people to exploit." , "$1600\nx1 Score", "None"};
	private String[] doctorInfo = {"Doctor: When you were young you decided that you wanted to make a difference in life, " +
									"coming from a wealthy family you were able to attend the top school of your choosing. " +
									"Graduating top of your class you are one of the most renown practicing physicians in the world. " +
									"Growing tired of your normal patients you decided to travel the Oregon Trail to see the other side." , "$1300" +
									"\nx1.25 Score", "You and your companions are less likely to get sick during your travels."}	;
	private String[] carpenterInfo = {"Carpenter: Having no formal education you decided to make something with what you know how to " +
									"use, your hands. Helping others around the town with small projects and investing your time on improving " +
									"your home you soon grow bored of your stagnant living conditions and the people around you.  Deciding enough " +
									"is enough you decide to leave it all behind and set due west for the Oregon Trail.","$1000\nx1.5 Score","You " +
											"are less likely to have a wagon part break, and repair attempts are more likely to succeed."};
	private String[] farmerInfo = {"Farmer: Coming from a long family of farmers, your family came to America to grow the new types of food " +
									"discovered here, growing depressed of your current living conditions and a lack of rain which results" +
									" in the death of mainy of your crops you decide to follow others and explore the Oregon Trail.","$700\nx1.75 Score"
									,"You can now find berries along the trail to feed you and your companions\nOxen are less likely to die"};
	private String[] teacherInfo = {"Teacher: You have always had a dream of helping others, however, this dream has not always allowed" +
									" you to do as well in life as you had hoped, the sacrifices you have made to help others has affected " +
									"your life drastically. You soon decide to change your life and set out as a pioneer, having almost " +
									"nothing you pack your bags and leave. ","$400\nx3 Score","None"};
	private JLabel professionText;
	private JTextPane professionDescrip, statsDescrip, bonusDescrip;
	private JLabel txtStats;
	private JLabel txtBonuses;
	
	/**
	 * Create the panel.
	 */
	public PlayerCreation(Frame frame) {
		this.frame = frame;
		professionStr = "Banker";
		
		this.setLayout(new BorderLayout(0, 0));
		this.setPreferredSize(new Dimension(800,600));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(238, 180, 34));
		this.setBackground(new Color(238, 180, 34));
		titlePanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		this.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("And So It Begins...");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 42));
		titlePanel.add(lblNewLabel_1);
		
		JPanel creationPanel = new JPanel();
		this.add(creationPanel, BorderLayout.CENTER);
		creationPanel.setLayout(null);
		
		JPanel profPanel = new JPanel();
		profPanel.setBackground(new Color(238, 180, 34));
		profPanel.setBounds(0, 0, 350, 537);
		creationPanel.add(profPanel);
		profPanel.setLayout(null);
		
		JPanel companionPanel = new JPanel();
		companionPanel.setBackground(new Color(204, 153, 102));
		companionPanel.setBounds(52, 83, 245, 242);
		profPanel.add(companionPanel);
		companionPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		companionPanel.setLayout(null);
		
		comp1Field = new JTextField();
		comp1Field.setForeground(Color.GRAY);
		comp1Field.setBackground(new Color(210, 180, 140));
		comp1Field.setBounds(19, 60, 206, 28);
		companionPanel.add(comp1Field);
		comp1Field.setText("Best Friend");
		comp1Field.setFont(new Font("Dialog", Font.PLAIN, 22));
		comp1Field.setColumns(10);
		comp1Field.addFocusListener(new TextListener());
		
		comp2Field = new JTextField();
		comp2Field.setForeground(Color.GRAY);
		comp2Field.setBackground(new Color(210, 180, 140));
		comp2Field.setText("2nd Best Friend");
		comp2Field.setBounds(19, 105, 206, 28);
		companionPanel.add(comp2Field);
		comp2Field.setFont(new Font("Dialog", Font.PLAIN, 22));
		comp2Field.setColumns(10);
		comp2Field.addFocusListener(new TextListener());
		
		comp3Field = new JTextField();
		comp3Field.setForeground(Color.GRAY);
		comp3Field.setBackground(new Color(210, 180, 140));
		comp3Field.setText("Fbook Friend");
		comp3Field.setBounds(19, 150, 206, 28);
		companionPanel.add(comp3Field);
		comp3Field.setFont(new Font("Dialog", Font.PLAIN, 22));
		comp3Field.setColumns(10);
		comp3Field.addFocusListener(new TextListener());
		
		comp4Field = new JTextField();
		comp4Field.setForeground(Color.GRAY);
		comp4Field.setBackground(new Color(210, 180, 140));
		comp4Field.setText("Frenemy");
		comp4Field.setBounds(19, 195, 206, 28);
		companionPanel.add(comp4Field);
		comp4Field.setFont(new Font("Dialog", Font.PLAIN, 22));
		comp4Field.setColumns(10);
		comp4Field.addFocusListener(new TextListener());
		
		JLabel lblNewLabel_3 = new JLabel("Friend's Names");
		lblNewLabel_3.setBackground(new Color(204, 153, 102));
		lblNewLabel_3.setBounds(12, 13, 222, 40);
		companionPanel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBackground(new Color(204, 153, 102));
		playerPanel.setBounds(52, 0, 245, 84);
		profPanel.add(playerPanel);
		playerPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		playerPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Player Name");
		lblNewLabel_2.setBounds(33, 5, 180, 36);
		playerPanel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		nameField = new JTextField();
		nameField.setForeground(Color.GRAY);
		nameField.setBackground(new Color(210, 180, 140));
		nameField.setText("Enter Your Name...");
		nameField.setFont(new Font("Dialog", Font.PLAIN, 22));
		nameField.setBounds(20, 45, 206, 28);
		playerPanel.add(nameField);
		nameField.setColumns(25);
		
		JPanel professionPanel = new JPanel();
		professionPanel.setBounds(52, 323, 245, 213);
		profPanel.add(professionPanel);
		professionPanel.setBackground(new Color(204, 153, 102));
		professionPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		professionPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 102));
		panel.setBounds(53, 49, 140, 160);
		professionPanel.add(panel);
		panel.setLayout(null);
		
		selCarp = new JRadioButton("Carpenter");
		selCarp.setBackground(new Color(204, 153, 102));
		selCarp.setBounds(0, 65, 151, 27);
		panel.add(selCarp);
		selCarp.setFont(new Font("Tahoma", Font.PLAIN, 24));
		buttonGroup.add(selCarp);
		selCarp.addActionListener(new RadioListener());
		
		selFarm = new JRadioButton("Farmer");
		selFarm.setBackground(new Color(204, 153, 102));
		selFarm.setBounds(0, 98, 129, 20);
		panel.add(selFarm);
		selFarm.setFont(new Font("Tahoma", Font.PLAIN, 24));
		buttonGroup.add(selFarm);
		selFarm.addActionListener(new RadioListener());
		
		selDoc = new JRadioButton("Doctor");
		selDoc.setBackground(new Color(204, 153, 102));
		selDoc.setBounds(0, 39, 129, 20);
		panel.add(selDoc);
		selDoc.setFont(new Font("Tahoma", Font.PLAIN, 24));
		buttonGroup.add(selDoc);
		selDoc.addActionListener(new RadioListener());
		
		selTeach = new JRadioButton("Teacher");
		selTeach.setBackground(new Color(204, 153, 102));
		selTeach.setBounds(0, 129, 129, 20);
		panel.add(selTeach);
		selTeach.setFont(new Font("Tahoma", Font.PLAIN, 24));
		buttonGroup.add(selTeach);
		selTeach.addActionListener(new RadioListener());
		
		selBank = new JRadioButton("Banker");
		selBank.setBackground(new Color(204, 153, 102));
		selBank.setSelected(true);
		selBank.setBounds(0, 9, 129, 20);
		panel.add(selBank);
		selBank.setFont(new Font("Tahoma", Font.PLAIN, 24));
		buttonGroup.add(selBank);
		selBank.addActionListener(new RadioListener());
		
		JLabel lblNewLabel = new JLabel("Profession");
		lblNewLabel.setBounds(48, 13, 150, 40);
		professionPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		nameField.addFocusListener(new TextListener());

		
		JPanel compPanel = new JPanel();
		compPanel.setBackground(new Color(238, 180, 34));
		compPanel.setBounds(350, 0, 450, 537);
		creationPanel.add(compPanel);
		compPanel.setLayout(null);
		
		nextButton = new CustomButton("Continue");
		nextButton.setBackground(new Color(204, 153, 102));
		nextButton.setBounds(290, 487, 148, 37);
		compPanel.add(nextButton);
		nextButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		nextButton.addActionListener(new ButtonListener());
		
		mainMenuButton = new CustomButton("Main Menu");
		mainMenuButton.setBackground(new Color(204, 153, 102));
		mainMenuButton.setBounds(12, 487, 175, 37);
		compPanel.add(mainMenuButton);
		mainMenuButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		mainMenuButton.addActionListener(new ButtonListener());
		
		JPanel descriptionPanel = new JPanel();
		descriptionPanel.setBackground(new Color(204, 153, 102));
		descriptionPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		descriptionPanel.setBounds(12, 13, 426, 456);
		compPanel.add(descriptionPanel);
		descriptionPanel.setLayout(null);
		
		professionText = new JLabel();
		professionText.setBackground(new Color(204, 153, 102));
		professionText.setFont(new Font("Tahoma", Font.BOLD, 16));
		professionText.setText("Profession");
		professionText.setBounds(12, 142, 92, 26);
		descriptionPanel.add(professionText);
		
		txtBonuses = new JLabel();
		txtBonuses.setText("Bonuses:");
		txtBonuses.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtBonuses.setBackground(new Color(204, 153, 102));
		txtBonuses.setBounds(226, 323, 84, 26);
		descriptionPanel.add(txtBonuses);
		
		txtStats = new JLabel();
		txtStats.setText("Stats:");
		txtStats.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtStats.setBackground(new Color(204, 153, 102));
		txtStats.setBounds(12, 323, 61, 26);
		descriptionPanel.add(txtStats);
		
		bonusDescrip = new JTextPane();
		bonusDescrip.setForeground(Color.RED);
		bonusDescrip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bonusDescrip.setEditable(false);
		bonusDescrip.setBackground(new Color(204, 153, 102));
		bonusDescrip.setBounds(226, 360, 188, 85);
		descriptionPanel.add(bonusDescrip);
		
		statsDescrip = new JTextPane();
		statsDescrip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		statsDescrip.setEditable(false);
		statsDescrip.setBackground(new Color(204, 153, 102));
		statsDescrip.setBounds(10, 360, 188, 85);
		descriptionPanel.add(statsDescrip);
		
		
		
		professionDescrip = new JTextPane();
		professionDescrip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		professionDescrip.setBackground(new Color(204, 153, 102));
		professionDescrip.setEditable(false);
		professionDescrip.setBounds(10, 179, 404, 133);
		descriptionPanel.add(professionDescrip);
		
		professionDescrip.setText(bankerInfo[0]);
		statsDescrip.setText(bankerInfo[1]);
		bonusDescrip.setText(bankerInfo[2]);
		
		JTextPane textBox = new JTextPane();
		textBox.setBackground(new Color(204, 153, 102));
		textBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textBox.setText("You and your friends are about to set out on the Oregon Trail to pursue a new life out west! Enter your name and select your profession. Nobody wants to be alone so give us some of your friend's names, or if you are spiteful those of your enemies.");
		textBox.setEditable(false);
		textBox.setBounds(12, 13, 402, 133);
		descriptionPanel.add(textBox);		
	}
	/**
	 * Resets the player creation screen to its default values.
	 */
	private void reset(){
		nameField.setText("Enter your name...");
		comp1Field.setText("Best Friend");
		comp2Field.setText("2nd Best Friend");
		comp3Field.setText("Fbook friend");
		comp4Field.setText("Frenemy");
		nameField.setForeground(Color.GRAY);
		comp1Field.setForeground(Color.GRAY);
		comp2Field.setForeground(Color.GRAY);
		comp3Field.setForeground(Color.GRAY);
		comp4Field.setForeground(Color.GRAY);
		selBank.setSelected(true);
		professionStr = "Banker";
		professionDescrip.setText(bankerInfo[0]);
		statsDescrip.setText(bankerInfo[1]);
		bonusDescrip.setText(bankerInfo[2]);
		bonusDescrip.setForeground(Color.RED);
		frame.resetWagonSetup();
		nameClicked = false;
		comp1Clicked = false;
		comp2Clicked = false;
		comp3Clicked = false;
		comp4Clicked = false;
		
		
	}
	private class ButtonListener implements ActionListener{
		
		
		@Override
		public void actionPerformed(ActionEvent event) {
			everythingSet = true;
			// TODO Auto-generated method stub
			if(event.getSource().equals(nextButton)){
				if(nameField.getText().length()==0){
					//No name for Main character
					JOptionPane.showMessageDialog(PlayerCreation.this, "Player Name Missing", "No Name Error", JOptionPane.ERROR_MESSAGE);
					everythingSet = false;
				}
				if((comp1Field.getText().length()==0)){
					//No name for 1st companion
					JOptionPane.showMessageDialog(PlayerCreation.this, "First Companion Name Missing", "No Name Error", JOptionPane.ERROR_MESSAGE);
					everythingSet = false;
				}
				if((comp2Field.getText().length()==0)){
					//No name for 2nd companion
					JOptionPane.showMessageDialog(PlayerCreation.this, "Second Companion Name Missing", "No Name Error", JOptionPane.ERROR_MESSAGE);
					everythingSet = false;
				}
				if((comp3Field.getText().length()==0)){
					//No name for 3rd companion
					JOptionPane.showMessageDialog(PlayerCreation.this, "Third Companion Name Missing", "No Name Error", JOptionPane.ERROR_MESSAGE);
					everythingSet = false;
				}
				if((comp4Field.getText().length()==0)){
					//No name for 4th companion
					JOptionPane.showMessageDialog(PlayerCreation.this, "Fourth Companion Name Missing", "No Name Error", JOptionPane.ERROR_MESSAGE);
					everythingSet = false;
				}
				if(buttonGroup.getSelection()== null)
				{
					everythingSet = false;
				}
				//At this point all information is valid, now pass it to the backend through game logic
				
				
				if(everythingSet)
				{
					
					String[] friends = {
							comp1Field.getText(),
							comp4Field.getText(),
							comp3Field.getText(),
							comp2Field.getText()
					};
						
					frame.getGameLogic().setFriends(friends);
					frame.getGameLogic().setPlayer(nameField.getText(),professionStr);
					frame.setupWagon();
				}
			}
			else if (event.getSource() == mainMenuButton)	{
				reset();
				frame.mainMenu();
			}
		}
	}
	
	private class TextListener implements FocusListener{
		@Override
		public void focusGained(FocusEvent event) {
			if(event.getSource().equals(nameField)&& !nameClicked)
			{
				((JTextField)event.getSource()).setText("");
				nameField.setForeground(Color.BLACK);
				nameClicked = true;
			}
			else if(event.getSource().equals(comp1Field)&& !comp1Clicked)
			{
				((JTextField)event.getSource()).setText("");
				comp1Field.setForeground(Color.BLACK);
				comp1Clicked = true;
			}
			else if(event.getSource().equals(comp2Field)&& !comp2Clicked)
			{
				((JTextField)event.getSource()).setText("");
				comp2Field.setForeground(Color.BLACK);
				comp2Clicked = true;
			}
			else if(event.getSource().equals(comp3Field)&& !comp3Clicked)
			{
				((JTextField)event.getSource()).setText("");
				comp3Field.setForeground(Color.BLACK);
				comp3Clicked = true;
			}
			else if(event.getSource().equals(comp4Field)&& !comp4Clicked)
			{
				((JTextField)event.getSource()).setText("");
				comp4Field.setForeground(Color.BLACK);
				comp4Clicked = true;
			} 
		}

		@Override
		public void focusLost(FocusEvent event) {
		
		}
		
	}
	private class RadioListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource().equals(selBank)) {
				professionStr = "Banker";
				professionDescrip.setText(bankerInfo[0]);
				statsDescrip.setText(bankerInfo[1]);
				bonusDescrip.setText(bankerInfo[2]);
				bonusDescrip.setForeground(Color.RED);
			}
			else if(event.getSource().equals(selDoc)) {
				professionStr = "Doctor";
				professionDescrip.setText(doctorInfo[0]);
				statsDescrip.setText(doctorInfo[1]);
				bonusDescrip.setText(doctorInfo[2]);
				bonusDescrip.setForeground(new Color(153, 255, 102));
			}
			else if(event.getSource().equals(selCarp)) {
				professionStr = "Carpenter";
				professionDescrip.setText(carpenterInfo[0]);
				statsDescrip.setText(carpenterInfo[1]);
				bonusDescrip.setText(carpenterInfo[2]);
				bonusDescrip.setForeground(new Color(153, 255, 102));
			}
			else if(event.getSource().equals(selFarm)) {
				professionStr = "Farmer";
				professionDescrip.setText(farmerInfo[0]);
				statsDescrip.setText(farmerInfo[1]);
				bonusDescrip.setText(farmerInfo[2]);
				bonusDescrip.setForeground(new Color(153, 255, 102));
			}
			else {
				professionStr = "Teacher";
				professionDescrip.setText(teacherInfo[0]);
				statsDescrip.setText(teacherInfo[1]);
				bonusDescrip.setText(teacherInfo[2]);
				bonusDescrip.setForeground(Color.RED);
			}
		}
	}
}
