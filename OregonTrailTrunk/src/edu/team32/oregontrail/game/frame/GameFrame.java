package edu.team32.oregontrail.game.frame;

import edu.team32.oregontrail.interfaces.Frame;
import edu.team32.oregontrail.interfaces.Logic;
import edu.team32.oregontrail.rivercrossinggame.RCMain;
import edu.team32.oregontrail.windows.*;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1776351663001975265L;
	private final static String TITLE_PANEL = "1";
	private final static String PLAYER_CREATION_PANEL = "2";
	private final static String SETUP_WAGON_PANEL = "3";
	private final static String STORE_PANEL = "4";
	private final static String MAIN_PANEL = "5";
	private final static String FINAL_SCORE_PANEL = "6";
	private final static String GAME_OVER = "7";
	private final static String RIVER_GAME = "8";
	private final static String HUNTING_GAME = "9";
	private final static String CHAT_PANEL = "10";
	private final static String CLOSED_PANEL = "11";
	
	private TitlePanel titlePanel;
	private GameOverPanel gameOver;
	private PlayerCreation playerCreationPanel;
	private WagonSetup wagonSetupPanel;
	private MainPanel mainPanel;
	private StorePanel storePanel;
	private RCMain riverGame;
	private FinalScorePanel finalScorePanel;
	private HuntingPanel huntingGame;
	private JPanel cardPanel, chatPanel, closedPanel, chatCardPanel;
	private CardLayout cardLayout, chatCardLayout;
	private boolean mainCreated = false;

	private Logic gameLogic;

	/**
	 * Default constructor for the game's main frame initializes the game's
	 * logic to the inputed parameter.
	 * 
	 * @param gameLogic
	 *            The game's logic
	 */
	public GameFrame(Logic gameLogic) {
		this.gameLogic = gameLogic;
		wagonSetupPanel = new WagonSetup(this);
		playerCreationPanel = new PlayerCreation(this);
		titlePanel = new TitlePanel(this);

		closedPanel = new ClosedPanel(this);
		chatPanel = new ChatPanel(this);
		
	
		cardPanel = new JPanel();
		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cardPanel.add(titlePanel, TITLE_PANEL);
		cardPanel.add(playerCreationPanel, PLAYER_CREATION_PANEL);
		cardPanel.add(wagonSetupPanel, SETUP_WAGON_PANEL);

		this.setTitle("The Oregon Trail by Team Thirty-Two");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				GameFrame.class.getResource("/images/OregonTrailIcon.gif")));
		getContentPane().add(cardPanel);
		
		chatCardLayout = new CardLayout();
		chatCardPanel = new JPanel();
		chatCardPanel.setLayout(chatCardLayout);
		chatCardPanel.add(chatPanel, CHAT_PANEL);
		chatCardPanel.add(closedPanel, CLOSED_PANEL);
		
		this.add(cardPanel, BorderLayout.CENTER);
		this.add(chatCardPanel, BorderLayout.EAST);
		
		this.setResizable(false);
		this.pack();
		this.setVisible(true);

	}

	/**
	 * Starts the game by displaying the player creation screen.
	 */
	public void playerCreation() {
		cardLayout.show(cardPanel, PLAYER_CREATION_PANEL);
		chatPanel.setBackground(playerCreationPanel.getBackground());
		closedPanel.setBackground(playerCreationPanel.getBackground());
	}

	/**
	 * Displays the title screen to the user with options to start a new game,
	 * load a previous game or quit.
	 */
	public void mainMenu() {
		cardLayout.show(cardPanel, TITLE_PANEL);
		chatPanel.setBackground(titlePanel.getBackground());
		closedPanel.setBackground(titlePanel.getBackground());
	}

	/**
	 * Displays the wagon setup screen to the user allowing them to select all
	 * the starting conditions for their journey.
	 */
	public void setupWagon() {
		cardLayout.show(cardPanel, SETUP_WAGON_PANEL);
		chatPanel.setBackground(wagonSetupPanel.getBackground());
		closedPanel.setBackground(wagonSetupPanel.getBackground());
	}

	/**
	 * Displays the store screen which allows the user to shop.
	 */
	public void displayStore() {
		storePanel = new StorePanel(this);
		cardPanel.add(storePanel, STORE_PANEL);
		cardLayout.show(cardPanel, STORE_PANEL);
		chatPanel.setBackground(storePanel.getBackground());
		closedPanel.setBackground(storePanel.getBackground());
	}
	

	// Must be called first after this use mainCreated() and displayMain()
	public void createMain() {
		mainPanel = new MainPanel(this);
		cardPanel.add(mainPanel, MAIN_PANEL);
		cardLayout.show(cardPanel, MAIN_PANEL);
		chatPanel.setBackground(mainPanel.getBackground());
		closedPanel.setBackground(mainPanel.getBackground());
		mainCreated = true;
	}

	public void gameOver(String reason) {
		gameOver = new GameOverPanel(this, reason);
		cardPanel.add(gameOver, GAME_OVER);
		cardLayout.show(cardPanel, GAME_OVER);
		chatPanel.setBackground(gameOver.getBackground());
		closedPanel.setBackground(gameOver.getBackground());
	}

	public boolean mainCreated() {
		return mainCreated;
	}

	public void displayMain() {
		cardLayout.show(cardPanel, MAIN_PANEL);
		chatPanel.setBackground(mainPanel.getBackground());
		closedPanel.setBackground(mainPanel.getBackground());
	}

	public void playRiverCrossing(){
		riverGame = new RCMain(this);
		cardPanel.add(riverGame.getParent(), RIVER_GAME);
		cardLayout.show(cardPanel, RIVER_GAME);
		riverGame.getParent().requestFocus();
	}

	/**
	 * 
	 */
	public void resetWagonSetup() {
		wagonSetupPanel.reset();
	}

	public void updateMain() {
		mainPanel.update();
	}

	/**
	 * Accesses the instance of game logic associated with this game.
	 * 
	 * @return The game's logic
	 */
	public Logic getGameLogic() {
		return gameLogic;
	}

	public void displayFinal() {
		finalScorePanel = new FinalScorePanel(this);
		cardPanel.add(finalScorePanel, FINAL_SCORE_PANEL);
		cardLayout.show(cardPanel, FINAL_SCORE_PANEL);
		chatPanel.setBackground(finalScorePanel.getBackground());
		closedPanel.setBackground(finalScorePanel.getBackground());
	}

	public void loadGame() {
		Logic gameLogic = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		JFileChooser chooser = new JFileChooser(new File("./savedGame"));
		String filename = "";
		int res = chooser.showOpenDialog(null);
		if (res == JFileChooser.APPROVE_OPTION) {
			try {
				filename = chooser.getSelectedFile().getCanonicalPath();
				if(filename.toString().length() > 4 && filename.toString().substring(filename.toString().length()-4, filename.toString().length()).equals(".ser"))
				{
				fis = new FileInputStream(filename);
				in = new ObjectInputStream(fis);
				gameLogic = (Logic) in.readObject();
				in.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(filename.toString().length() > 4 && filename.toString().substring(filename.toString().length()-4, filename.toString().length()).equals(".ser"))
		{
		this.gameLogic = gameLogic;
		this.createMain();
		this.mainPanel.loadEvents(this.gameLogic.loadEvents());
		}
	}

	public void saveGame(String customName) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		//Saves in savedGame folder in the baseDirectory
		File saveGame = new File("./savedGame",customName + ".ser");

		try {
			saveGame.createNewFile();
			fos = new FileOutputStream(saveGame);
			out = new ObjectOutputStream(fos);
			out.writeObject(gameLogic);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void playerWins() {
		this.displayFinal();
	}

	@Override
	public void startHunting() {
		huntingGame = new HuntingPanel(this);
		cardPanel.add(huntingGame, HUNTING_GAME);
		cardLayout.show(cardPanel, HUNTING_GAME);
	}

	public void closeChatPanel(){
		int height = this.getHeight();
		chatCardLayout.show(chatCardPanel, CLOSED_PANEL);
		chatCardPanel.setPreferredSize(closedPanel.getPreferredSize());
		chatCardPanel.setSize(20, height);
		this.setSize(827, height);
		this.pack();

		this.setVisible(true);
	}

	public void openChatPanel()
	{
		int height = this.getHeight();
		chatCardLayout.show(chatCardPanel, CHAT_PANEL);
		chatCardPanel.setPreferredSize(chatPanel.getPreferredSize());
		this.setSize(1137, height);
		this.pack();
		this.setVisible(true);
	}
}
