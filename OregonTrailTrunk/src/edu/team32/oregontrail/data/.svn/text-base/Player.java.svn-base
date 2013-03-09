package edu.team32.oregontrail.data;

import edu.team32.oregontrail.enums.*;

import java.io.Serializable;

/**
 * Represents the main player.
 * 
 * @author Team 32
 * 
 */
public class Player extends Companion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5381405574050169080L;

	private Profession profession = null;
	private static final int PLAYER_MAX_VITALS = 300;

	/**
	 * Initializes the player to the inputed parameters. Default status of the
	 * player is HEALTHY.
	 * 
	 * @param name
	 *            The name of the player
	 * @param profession
	 *            The profession of the player
	 */
	public Player(String name, Profession profession) {
		super(name);
		this.profession = profession;
		super.setMaxVitals(PLAYER_MAX_VITALS);
	}

	/**
	 * Gets the profession associated with the player.
	 * 
	 * @return The profession of the player
	 */
	public Profession getProfession() {
		return profession;
	}

}
