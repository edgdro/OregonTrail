package edu.team32.oregontrail.hunt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class PanelUpdater {
	private HuntPanel panelToUpdate;
	private Timer timer;
	
	/**
	 * Constructor for PanelUpdater. Takes in the panel it calls repaint on
	 * and the time interval in seconds that it operates on.
	 * @param panelToUpdate
	 * @param secondsInterval
	 */
	public PanelUpdater(HuntPanel panelToUpdate, float secondsInterval) {
		this.panelToUpdate = panelToUpdate;
		
		//Converts float seconds interval given into milliseconds 
		int interval = (int)secondsInterval;
		timer = new Timer(interval, new Listener());
	}
	
	/**
	 * Starts the timer
	 */
	public void start() {
		timer.start();
	}
	
	/**
	 * Stops the timer
	 */
	public void stop() {
		timer.stop();
	}
	
	public void setEndGame() {
		timer.setDelay(100);
	}
	
	/**
	 * Updates the panel everytime the timer ticks
	 */
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			panelToUpdate.updateTargets();
			panelToUpdate.repaint();
	
		}
	}
}
