package edu.team32.oregontrail.interfaces;

import javax.swing.JFrame;


public interface Frame {

	public void playerCreation();
	public void mainMenu();
	public void setupWagon();
	public void displayStore();
	public void createMain();
	public void gameOver(String reason);
	public boolean mainCreated();
	public void displayMain();
	public void playRiverCrossing();
	public void resetWagonSetup();
	public void updateMain();
	public Logic getGameLogic();
	public void displayFinal();
	public void loadGame();
	public void saveGame(String customName);
	public void playerWins();
	public void startHunting();
	public void closeChatPanel();
	public void openChatPanel();
}
