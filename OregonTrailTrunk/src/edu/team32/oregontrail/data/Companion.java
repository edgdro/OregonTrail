package edu.team32.oregontrail.data;

import edu.team32.oregontrail.enums.Status;

import java.io.Serializable;
import java.util.Stack;

/**
 * Represents the companions of the player.
 * 
 * @author Team 32
 * 
 */
public class Companion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8680999270841790397L;

	private final Stack<Status> status;

	private String name;

	private int vitals;

	private static final int STANDARD_MAX_VITALS = 100;
	
	private int maxVitals = STANDARD_MAX_VITALS;

	/**
	 * Constructor for the Companion initializes the companion's name to the
	 * inputed parameter.
	 * 
	 * @param name
	 *            The name of the Companion
	 */
	public Companion(String name) {
		this.status = new Stack<Status>();
		this.status.push(Status.HEALTHY);
		this.name = name;
		this.vitals = maxVitals;
	}

	/**
	 * Gets the Enum Status of the Companion
	 * 
	 * @return the status of the companion
	 */
	public Status getStatus() {
		return status.peek();
	}


	/**
	 * Gets the name of the companion
	 * 
	 * @return The name of the companion
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the companion to the inputed parameter.
	 * 
	 * @param name
	 *            The name of the companion
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Decreases the vitals of the corresponding companion/player
	 * 
	 * @param vitals
	 *            The amount of vitals to remove from the corresponding
	 *            companion/player
	 * 
	 * @return true if the companion/player was made sick false otherwise
	 */
	public boolean canRemoveVitals(int vitals) {
		if (!status.contains(Status.DEAD)) {
			if (vitals >= this.vitals) {
				this.vitals = 0;
			} else {
				this.vitals = (this.vitals - vitals);
			}
			if (this.vitals == 0) {
				status.clear();
				status.push(Status.DEAD);
			} else if (this.vitals < (maxVitals >> 1)
					&& !status.contains(Status.SICK)) {
				status.push(Status.SICK);
				status.remove(Status.HEALTHY);
				return true;
			}
		}
		return false;
	}

	/**
	 * Increases the vitals of the corresponding companion/player
	 * 
	 * @param vitals
	 *            The amount of vitals to remove from the corresponding
	 *            companion/player
	 * @return true if the companion/player was made healthy false otherwise
	 */
	public boolean canAddVitals(int vitals) {
		if (!status.contains(Status.DEAD)) {
			this.vitals = this.vitals + vitals;
			if ((this.vitals) > maxVitals) {
				// Vitals can never be more than the maxVitals;
				this.vitals = maxVitals;
			}
			if (this.vitals > (maxVitals - (maxVitals / STANDARD_MAX_VITALS) * 20)
					&& !status.contains(Status.HEALTHY)
					&& !status.contains(Status.TIRED)
					&& !status.contains(Status.HUNGRY)) {
				status.clear();
				status.push(Status.HEALTHY);
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds a Tired status to the companion/player
	 * 
	 * @param status the Status to add
	 * 
	 * @return true if the companion/player was not already tired, false
	 *         otherwise
	 */
	public boolean canAddStatus(Status status) {
		if (!this.status.contains(status) && !this.status.contains(Status.DEAD)) {
			this.status.push(status);
			this.status.remove(Status.HEALTHY);
			if (vitals > (maxVitals >> 1)) {
				canRemoveVitals(30);
			}
			return true;
		}
		return false;
	}

	/**
	 * Returns whether the companion/player can be made sick and if so they are made sick
	 * 
	 * @return Whether the companion/player can be made sick.
	 */
	public boolean canMakeSick() {
		if (!status.contains(Status.SICK) && !status.contains(Status.DEAD)) {
			this.vitals = this.vitals - (maxVitals >> 1);
			if (vitals > 0) {
				this.vitals = this.vitals - vitals;
				status.remove(Status.HEALTHY);
				status.push(Status.SICK);
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes a hungry status from the companion/player
	 * 
	 * @param status the Status to remove
	 * 
	 * @return true if the companion/player was Hungry, false otherwise
	 */
	public boolean canRemoveStatus(Status status) {
		if (this.status.contains(status) && !this.status.contains(Status.DEAD)) {
			this.status.remove(status);
			if (vitals < (maxVitals >> 1)) {
				canAddVitals(30);
			}
			if (this.status.empty()) {
				this.status.push(Status.HEALTHY);
			}
			return true;
		}
		return false;
	}

	/**
	 * Returns true if the companion/player is dead, false otherwise
	 * 
	 * @return true if the companion/player is dead, false otherwise
	 */
	public boolean isDead() {
		return (status.contains(Status.DEAD));
	}

	/**
	 * Returns the vitals of the companion/player
	 * 
	 * @return the vitals of the companion/player
	 */
	public int getVitals() {
		return vitals;
	}

	/**
	 * Sets the max vitals of the companion/player, only used for player as he
	 * has higher vitality
	 * 
	 * @param maxVitals
	 *            The max vitals of the companion/player
	 */
	public void setMaxVitals(int maxVitals) {
		this.maxVitals = maxVitals;
		this.vitals = maxVitals;
	}

	@Override
	/**
	 * Returns a list of all the statuses currently on the stack, if dead is 
	 * on the stack then only that is returned
	 * @return a list of all the statuses currently on the stack, if dead is 
	 * on the stack then only that is returned
	 */
	public String toString() {
		if (status.contains(Status.DEAD)) {
			return (Status.DEAD.toString());
		}
		return status.toString().substring(1, status.toString().length() - 1);
	}

	/**
	 * Used to determine whether the companion/player has a specific status
	 * @param status The status to check
	 * @return True if the companion/player has the status, false otherwise
	 */
	public boolean hasStatus(Status status) {
		return this.status.contains(status);
	}

	// TODO remove after testing
	public String tempToString() {
		return name + " " + this.vitals + " " + status.toString();
	}
}
