package edu.team32.oregontrail.game.logic;

import edu.team32.oregontrail.data.*;
import edu.team32.oregontrail.datahandler.Turn;
import edu.team32.oregontrail.datahandler.Wagon;
import edu.team32.oregontrail.interfaces.Logic;
import edu.team32.oregontrail.inventory.Inventory;
import edu.team32.oregontrail.inventory.WagonInventory;
import edu.team32.oregontrail.enums.*;

import java.io.Serializable;
import java.util.Random;

import javax.swing.ImageIcon;


/**
 * Handles all of the logic for the current game.
 * 
 * @author Team 32
 * 
 */
public class GameLogic implements Logic, Serializable {

	private static final long serialVersionUID = 7388180719570574024L;


	// chance that wagon will flip while trying to ford a river under 4 feet
	private static final int WAGON_FORD_FLIP_CHANCE = 60;
	private static final int WAGON_CAULK_FLIP_CHANCE = 80;

	private String events;
	private Turn turn;
	private Milestone currentMilestone;

	// if we decide to do multiple wagons we can turn this into "WagonTrain"
	// which might just be a list of wagons

	// variables that hold the information coming from the GUI
	/**
	 * Default constructor for the game's logic.
	 */
	public GameLogic() {
		turn = new Turn();
		currentMilestone = Map.getInstance().getMilestone(0); // starting milestone
															// is index 0
	}

	/**
	 * Accesses the player's name.
	 * 
	 * @return The player's name
	 */
	@Override
	public String getPlayerName() {
		return Wagon.getInstance().getPlayer().getName();
	}

	/**
	 * Accesses the player's profession.
	 * 
	 * @return The player's profession
	 */
	@Override
	public String getProfession() {
		return Wagon.getInstance().getPlayer().getProfession().toString();
	}

	/**
	 * Accesses the wagon's rations.
	 * 
	 * @return The wagon's rations
	 */
	@Override
	public String getRations() {

		return Wagon.getInstance().getRations().toString();
	}

	/**
	 * Accesses the wagon's pace.
	 * 
	 * @return The wagon's pace
	 */
	@Override
	public String getPace() {
		return Wagon.getInstance().getPace().toString();
	}

	/**
	 * Accesses the friends/companions associated with the wagon.
	 * 
	 * @return The companions
	 */
	@Override
	public String getFriends() {
		String friendString = "";
		for (int i = 0; i < Wagon.getInstance().getCompanions().length; i++) {
			friendString += Wagon.getInstance().getCompanions()[i].getName() + "\n";
		}
		return friendString;
	}

	/**
	 * Used for creating a new player for the wagon. Player Name will never be
	 * changed once the game starts.
	 * 
	 * @param name
	 *            name of the new Player
	 * @param profession
	 *            The profession of the new Player
	 */
	@Override
	public void setPlayer(String name, String profession) {
		Profession p = Profession.parseString(profession);
		Wagon.getInstance().setPlayer(new Player(name, p));
	}

	/**
	 * Initializes the wagon's friends to the inputed parameter.
	 * 
	 * @param friends
	 *            The list of friends in the wagon
	 */
	@Override
	public void setFriends(String[] friends) {
		Companion[] companions = new Companion[friends.length];
		for (int i = 0; i < friends.length; i++) {
			companions[i] = new Companion(friends[i]);
		}
		Wagon.getInstance().setCompanions(companions);
	}

	/**
	 * Initializes the start month to the inputed parameter.
	 * 
	 * @param month
	 *            The start month
	 */
	@Override
	public void setStartMonth(int month) {
		turn.setTurn(new Date(month));
	}

	/**
	 * Accesses the start date.
	 * 
	 * @return The start date
	 */
	@Override
	public String getStartDate() {
		return turn.getDate().toString();
	}

	/**
	 * Initializes the pace of the wagon to the inputed parameter based on what
	 * the pace field currently holds.
	 * 
	 * @param pace
	 *            The pace of the current game's wagon
	 */
	@Override
	public void setPace(String pace) {
		Wagon.getInstance().setPace(Pace.parseString(pace));
	}

	/**
	 * Initializes the rations of the wagon to the inputed parameter based on
	 * what the rations field currently holds.
	 * 
	 * @param rations
	 *            The rations associated with the game's wagon
	 */
	@Override
	public void setRations(String rations) {
		Wagon.getInstance().setRations(Rations.parseString(rations));
	}

	/**
	 * Calculates the current money available to the player.
	 * 
	 * @return The player's current money
	 */
	public int getPlayerMoney() {
		return Wagon.getInstance().getWagonInventory().getMoney();
	}

	/**
	 * Calculates the purchase cost of a certain type of item.
	 * 
	 * @param type
	 *            The type of item
	 * 
	 * @return The purchase cost of the item(s)
	 */
	public int calcBuyPrice(int type) {
		updateCurrentMilestone();
		if (this.currentMilestone.getShopInventory() != null)
			return this.currentMilestone.getShopInventory().getBuyPrice(type);
		return 0;
	}

	/**
	 * Calculates the selling value of a certain type of item.
	 * 
	 * @param type
	 *            The type of item
	 * 
	 * @return The selling value of the item(s)
	 */
	public int calcSellPrice(int type) {
		updateCurrentMilestone();
		if (this.currentMilestone.getShopInventory() != null)
			return this.currentMilestone.getShopInventory().getSellPrice(type);

		return 0;
	}

	/**
	 * Gets the weight of a certain type of item.
	 * 
	 * @param type
	 *            The type of item
	 * 
	 * @return The weight of the item(s)
	 */
	public int getWeight(int type) {
		return Inventory.getWeight(type);
	}

	/**
	 * Calculates the quantity of a given item that is currently in the wagon
	 * inventory.
	 * 
	 * @param type
	 *            The type of item
	 * 
	 * @return The quantity of that item.
	 */
	public int calcInventory(int type, boolean store) {

		int quantity = Wagon.getInstance().getWagonInventory().getQuantity(type);
		if (type == Inventory.FOOD && store) {
			return quantity / Inventory.FOOD_WEIGHT;
		}
		return quantity;
	}

	/**
	 * Calculates the quantity of a given item that is currently in a store's
	 * inventory.
	 * 
	 * @param type
	 *            The type of item
	 * 
	 * @return The quantity of that item
	 */
	public int calcStoreQuantity(int type) {
		updateCurrentMilestone();
		return this.currentMilestone.getShopInventory().getQuantity(type);
	}

	/**
	 * Calculates the total weight of the wagon.
	 * 
	 * @return The wagon's total weight
	 */
	public int totalWeight() {
		return Wagon.getInstance().getWeight();
	}

	/**
	 * Calculates the total money the wagon possesses.
	 * 
	 * @return The total money the wagon has
	 */
	public int totalMoney() {
		return Wagon.getInstance().getWagonInventory().getMoney();
	}

	/**
	 * Purchases a given quantity and type of item(s) from the current
	 * milestone's shop inventory.
	 * 
	 * @param items
	 *            The list of items to purchase
	 */
	public void purchaseItems(int[] items) {
		currentMilestone.getShopInventory().purchaseItems(
				Wagon.getInstance().getWagonInventory(), items);
	}

	/**
	 * Sells a given quantity and type of item(s) to the current milestone's
	 * shop inventory.
	 * 
	 * @param items
	 *            The list of items to sell
	 */
	public void sellItems(int[] items) {
		currentMilestone.getShopInventory().sellItems(
				Wagon.getInstance().getWagonInventory(), items);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDate() {
		return turn.getDate().toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCompanionName(int comp) {
		return Wagon.getInstance().getCompanions()[comp].getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCompanionStatus(int comp) {
		return Wagon.getInstance().getCompanions()[comp].toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPlayerStatus() {
		return Wagon.getInstance().getPlayer().toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String nextTurn() {
		return turn.nextTurn(Wagon.getInstance());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDistanceToNextMilestone() {
		return Integer.toString(Map.getInstance().getMilesToNextMilestone());

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTotalTraveled() {
		return Integer.toString(Map.getInstance().getMilesTraveled());
	}

	/**
	 * Determines whether or not the wagon is at a milestone.
	 * 
	 * @return true if the wagon is at a milestone, false otherwise
	 */
	@Override
	public boolean isAtMilestone() {
		return Wagon.getInstance().isAtMilestone();
	}

	// Temporary will be removed when hunting game is actually added
	// Gives user 150 lbs of food, like if they had hunted
	public void simulateHunt() {
		if (Wagon.getInstance().getWeight() + 150 <= WagonInventory.MAX_WEIGHT)
			Wagon.getInstance().getWagonInventory().addItem(Inventory.FOOD, 30);
	}

	/**
	 * Updates the current milestone based on where the wagon is currently
	 * located on the map.
	 */
	public void updateCurrentMilestone() {
		currentMilestone =Map.getInstance().getCurrentMilestone();
	}

	/**
	 * Gets a string representation of the wagon's current location.
	 * 
	 * @return A string representing the wagon's current location
	 */
	public String currentLocation() {
		updateCurrentMilestone();
		String curLoc = Map.getInstance().getCurrentLocation();
		return curLoc;
	}

	/**
	 * Determines whether or not the milestone has a shop or not.
	 * 
	 * @return an integer representing if there is a shop, 0 if there is no
	 *         shop, 1 if the wagon is in motion or 2 if there is a shop
	 */
	public int milestoneHasShop() {
		updateCurrentMilestone();
		if (currentMilestone.getShopInventory() == null)
			return Map.NO_SHOP;
		else if (Map.getInstance().isInMotion())
			return Map.IN_MOTION;
		return Map.SHOP_EXISTS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getProfessionModifier() {
		return Wagon.getInstance().getPlayer().getProfession().scoreModifier();
	}

	/**
	 * {@inheritDoc}
	 */
	public int getLivingPlayers() {
		return Wagon.getInstance().getLivingPlayers();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Milestone getCurrentMilestone() {
		return Map.getInstance().getCurrentMilestone();
	}

	/**
	 * Flips the wagon while the player attempts to cross the river. A random
	 * number of items will be lost or stolen.
	 * 
	 * @return A string representing what happened during the wagon flip
	 */
	private String wagonFlip() {
		Random random = new Random();
		int itemToLose = random.nextInt(7);
		int amountStolen = random.nextInt(5);
		if (Wagon.getInstance().getWagonInventory().hasItem(itemToLose) && amountStolen > 0) {
			amountStolen = Wagon.getInstance().getWagonInventory().removeItem(itemToLose,
					amountStolen);
			return "Your wagon flipped while crossing the river and lost "
					+ Inventory.toString(itemToLose, amountStolen) + "\n";
		} else
			return "Your wagon flipped while crossing the river, but you managed to retrieve all your items\n";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String crossRiver(CrossingType type) {
		int waterDepth = currentMilestone.getRiverDepth();
		if (type == CrossingType.FORD) {
			if (waterDepth > 3) {
				return wagonFlip();
			} else {
				if (Math.random() * 100 < WAGON_FORD_FLIP_CHANCE) {
					return wagonFlip();
				} else {
					return "You safely forded the river!\n";
				}
			}
		} else if (type == CrossingType.CAULK) {
			if (Math.random() * 100 < WAGON_CAULK_FLIP_CHANCE) {
				return wagonFlip();
			} else {
				return "You safely floated across the river!\n";
			}
		} else if (type == CrossingType.HELP) {
			Wagon.getInstance().getWagonInventory().removeMoney(10);
			return "You were safely guided across the river!\n";
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void loadedWagon(Wagon newWagon) {
		//wagon = newWagon;
	}

	/**
	 * {@inheritDoc}
	 */
	public void saveEvents(String events) {
		this.events = events;
	}

	/**
	 * {@inheritDoc}
	 */
	public String loadEvents() {
		return events;
	}

	/**
	 * {@inheritDoc}
	 */
	public Wagon getWagon() {
		return Wagon.getInstance();
	}

	@Override
	public void takeAlternativePath() {
		Map.getInstance().setAlternativePath(true);
	}

	@Override
	public void removeRandomItem() {
		Random rand = new Random(System.nanoTime());
		int type = rand.nextInt(7);
		if(type == Inventory.FOOD){
			type++;
		}
		int quantity = rand.nextInt(3)+1;
		Wagon.getInstance().getWagonInventory().removeItem(type, quantity);			
		System.out.println(Inventory.toString(type, quantity));
	}

	public void playerWins() {
		// TODO YOU WESTLEY MAKE IT SO THIS CHANGES TO ANOTHER TILE FOR SOME REASON AND SOME SHIT.
		
	}

	@Override
	public void consumeAmmo() {
		Wagon.getInstance().getWagonInventory().removeItem(Inventory.BULLETBOXES, 1);
	}

	@Override
	public int addPoundsShot(int pounds) {
		return Wagon.getInstance().addPoundsShot(pounds);
	}
	
	public boolean hasBullets()
	{
		if(Wagon.getInstance().getWagonInventory().getBulletBoxesNumber()>0)
		{
			return true;
		}
		return false;
	}

	@Override
	public ImageIcon getImage() {
		return Map.getInstance().getImage();
	}
	
	public int getCurrentMilestoneIndex()
	{
		return Map.getInstance().getCurrentMilestoneIndex();
	}
}
