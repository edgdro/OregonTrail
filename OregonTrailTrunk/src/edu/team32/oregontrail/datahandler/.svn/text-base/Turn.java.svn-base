package edu.team32.oregontrail.datahandler;

import edu.team32.oregontrail.data.Date;

import java.io.Serializable;


/**
 * Represents a turn in the game.
 * 
 * @author Team 32
 *
 */
public class Turn implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 551441641334622127L;
	private Date date;
	/**
	 * Default constructor for a turn.
	 */
	public Turn() {
		
	}
	/**
	 * Represents everything that happens to the wagon during the current day.
	 * Increments the date.
	 * 
	 * @param wagon
	 * 			The player's wagon
	 * 
	 * @return A string representing the day's events
	 */
	public String nextTurn(Wagon wagon) {
		date.nextDay();
		return wagon.simulateDay();
	}

	public void setTurn(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
}
