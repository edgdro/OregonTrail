package edu.team32.oregontrail.interfaces;

import javax.swing.ImageIcon;

import edu.team32.oregontrail.data.Milestone;
import edu.team32.oregontrail.datahandler.Wagon;
import edu.team32.oregontrail.enums.*;
/**
 * The logic interface for the Oregon Trail game.
 * 
 * @author Team 32
 *
 */
public interface Logic {
	
	/**
	 * This gets the name of the player given.
	 *  
	 * @return The name of the player
	 */
	public String getPlayerName();
	/**
	 * This gets the profession associated with the player.
	 * 
	 * @return The profession of the player
	 */
	public String getProfession();
	/**
	 * This gets the companions associated with the player.
	 * 
	 * @return The player's companions
	 */
	public String getFriends();
	/**
	 * Initializes the name of the player to the inputed parameter.
	 * 
	 * @param name
	 * 			The name of the player
	 */
	public void setPlayer(String name, String profession);
	/**
	 * Initializes the companions of the player to the inputed parameter.
	 * 
	 * @param friends
	 * 				The friends of the player
	 */
	public void setFriends(String[] friends);
	/**
	 * Initializes the start month to the inputed parameter.
	 * 
	 * @param month
	 * 			The starting month for the game
	 */
	public void setStartMonth(int month);
	/**
	 * This gets the start date associated with the current game.
	 * 
	 * @return The start date
	 */
	public String getStartDate();
	/**
	 * Sets the pace of the wagon to the inputed parameter.
	 * 
	 * @param pace
	 * 			The pace of the wagon
	 */
	public void setPace(String pace);
	/**
	 * Sets the rations to the inputed parameter.
	 * 
	 * @param rations
	 * 			The rations
	 */
	public void setRations(String rations);
	/**
	 * Gets the rations associated with the current game's wagon.
	 * 
	 * @return The rations
	 */
	public String getRations();
	/**
	 * Gets the pace associated with the current game's wagon.
	 * 
	 * @return The wagon's pace
	 */
	public String getPace();
	/**
	 * Purchases the items currently selected.
	 * 
	 * @param items
	 * 			The list of items to purchase
	 */
	public void purchaseItems(int[] items);
	/**
	 * Sells items current selected.
	 * 
	 * @param items
	 * 			The list of items to sell
	 */
	public void sellItems(int[] items);
	/**
	 * Calculates the total weight.
	 * 
	 * @return The total weight
	 */
	public int totalWeight();
	/**
	 * Calculates the total money
	 * 
	 * @return The total money
	 */
	public int totalMoney();
	/**
	 * Determines what the store's inventory will hold based on the type and
	 * if the milestone has a store.
	 * 
	 * @param type
	 * 			The type of item
	 * @param store
	 * 			represents if the milestone has a store or not
	 * 
	 * @return An integer representing the inventory
	 */
	public int calcInventory(int type, boolean store);
	/**
	 * Determines the quantity of an item in a given store.
	 * 
	 * @param type
	 * 			The type of item to calculate the quantity of
	 * 
	 * @return The quantity of the type of item
	 */
	public int calcStoreQuantity(int type);
	/**
	 * Determines the purchase cost of a given type of item.
	 * 
	 * @param type
	 * 			The type of item
	 * 
	 * @return The purchase cost of the item
	 */
	public int calcBuyPrice(int type);
	/**
	 * Calculates the selling value of a certain type of item.
	 * 
	 * @param type
	 * 			The type of item
	 * 
	 * @return The selling value of the item(s)
	 */
	public int calcSellPrice(int type);
	/**
	 * Accesses the player's total money.
	 * 
	 * @return The player's money
	 */
	public int getPlayerMoney();
	/**
	 * Determines the weight of a given type of item.
	 * 
	 * @param type
	 * 			The type of item to get the weight of
	 * 
	 * @return The weight of the item
	 */
	public int getWeight(int type);
	/**
	 * String representation of the current date.
	 * 
	 * @return A string representing the current date
	 */
	public String getDate();
	/**
	 * String representation of a given companion.
	 * 
	 * @param comp
	 * 			The companion
	 * 
	 * @return A string representing the companion
	 */
	public String getCompanionName(int comp);
	/**
	 * String representation of the companion's status.
	 * 
	 * @param comp
	 * 			The companion
	 * 
	 * @return A string representing the companion's status
	 */
	public String getCompanionStatus(int comp);
	/**
	 * Accesses the player's current status.
	 * 
	 * @return A string representing the player's status
	 */
	public String getPlayerStatus();
	/**
	 * A string representation of the next event that will happen.
	 * 
	 * @return The next event that will happen
	 */
	public String nextTurn();
	/**
	 * String representation of the distance to the next milestone.
	 * 
	 * @return A string representing the distance to the next milestone
	 */
	public String getDistanceToNextMilestone();
	/**
	 * String representation of the total distance traveled.
	 * 
	 * @return A string representing total distance traveled
	 */
	public String getTotalTraveled();
	/**
	 * Used to represent if the wagon is at a milestone or not.
	 * 
	 * @return true if the wagon is at a milestone, false otherwise
	 */
	public boolean isAtMilestone();
	/**
	 * Executes the hunting mini game when the user clicks the hunt button
	 * on the main GUI.
	 */
	public void simulateHunt();
	/**
	 * Updates the current milestone.
	 */
	public void updateCurrentMilestone(); 
	/**
	 * String representation of the wagon's current location.
	 * 
	 * @return A string representing the wagon's current location
	 */
	public String currentLocation();
	/**
	 * Determines whether the milestone has a shop or not.
	 * 
	 * @return An integer representing if the milestone has a shop, 
	 * 			there is another integer to represent if the wagon is
	 * 			moving
	 */
	public int milestoneHasShop();
	/**
	 * Accesses the player's profession modifier which will affect their
	 * starting purchases and ability to deal with random events.
	 * 
	 * @return The player's profession modifier
	 */
	public double getProfessionModifier();
	/**
	 * Accesses the number of living players remaining in the wagon.
	 * 
	 * @return The umber of living players
	 */
	public int getLivingPlayers();
	/**
	 * Accesses the current milestone.
	 * 
	 * @return The current milestone
	 */
	public Milestone getCurrentMilestone();
	/**
	 * String representation of what happens when the wagon attempts to cross
	 * a river.
	 * 
	 * @param type
	 * 			The method of crossing the player chooses
	 * 
	 * @return A string representing an attempted river crossing
	 */
	public String crossRiver(CrossingType type);
	/**
	 * Loads a wagon from a saved game.
	 * 
	 * @param newWagon
	 * 				The wagon for the current session
	 */
	public void loadedWagon(Wagon newWagon);
	/**
	 * Accesses the wagon associated with the current game.
	 * 
	 * @return The wagon
	 */
	public Wagon getWagon();
	 /**
	  * Saves the events that have already occurred which are associated
	  * with the current game.
	  * 
	  * @param events
	  * 			The events to save
	  */
	public void saveEvents(String events);
	/**
	 * Loads the string representation of the events that have already occurred.
	 * They will be associated with the game to be loaded.
	 * 
	 * @return A string representing the events
	 */
	public String loadEvents();
	/**
	 * Allows the wagon to take an alternative path as opposed to the default path.
	 * The alternative path will allow the wagon to re-supply.
	 */
	public void takeAlternativePath();
	
	public void removeRandomItem();
	
	public void consumeAmmo();
	
	public int addPoundsShot(int pounds);
	
	public boolean hasBullets();
	
	public ImageIcon getImage();
	
	public int getCurrentMilestoneIndex();
	
	
}
