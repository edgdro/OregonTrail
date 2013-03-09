package edu.team32.oregontrail.inventory;

import edu.team32.oregontrail.enums.Rations;

import java.io.Serializable;

/**
 * This class represents the wagon's inventory for the current game's session.
 * 
 * @author Team 32
 * 
 */
public class WagonInventory extends Inventory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6737067124748737776L;
	private int money;
	public static final int MAX_WEIGHT = 3500;
	public static final int MAX_CARRY_BACK_WEIGHT = 1500;

	/**
	 * Constructor for the wagon's inventory initializes the starting money to
	 * the inputed parameter.
	 * 
	 * @param startingMoney
	 *            The money the wagon will start with
	 */
	public WagonInventory(int startingMoney) {
		this.money = startingMoney;
	}

	/**
	 * Accesses the current weight of the wagon.
	 * 
	 * @return The wagon's current weight
	 */
	public int getWeight() {
		return getInventoryWeight();
	}

	/**
	 * Accesses the current money for the wagon.
	 * 
	 * @return The wagon's current money
	 */
	public int getMoney() {
		return this.money;
	}

	/**
	 * Updates the wagon's money by adding the inputed parameter.
	 * 
	 * @param money
	 *            The amount of money to add
	 */
	public void addMoney(int money) {
		this.money = (this.money + money);
	}

	/**
	 * Updates the wagon's money by subtracting the inputed parameter.
	 * 
	 * @param money
	 *            The amount of money to subtract
	 */
	public void removeMoney(int money) {
		this.money = (this.money - money);
	}

	/**
	 * Determines if the wagon has enough money to make a purchase.
	 * 
	 * @param money
	 *            The amount of money used for the comparison
	 * 
	 * @return true if the wagon has enough money to make a purchase false
	 *         otherwise
	 */
	public boolean hasSufficientMoney(int money) {
		if (this.money < money)
			return false;
		return true;
	}

	/**
	 * Determines if the wagon has enough items to proceed.
	 * 
	 * @param type
	 *            The type of item to check
	 * @param quantity
	 *            The number used for comparison
	 * 
	 * @return true if the wagon has enough items to proceed false otherwise
	 */
	public boolean hasSufficientItems(int type, int quantity) {
		switch (type) {
		case OXEN: {
			if (this.getOxenNumber() < quantity)
				return false;
		}
			break;
		case AXLES: {
			if (this.getAxlesNumber() < quantity)
				return false;
		}
			break;
		case TONGUES: {
			if (this.getTonguesNumber() < quantity)
				return false;
		}
			break;
		case WHEELS: {
			if (this.getWheelsNumber() < quantity)
				return false;
		}
			break;
		case CLOTHES: {
			if (this.getClothesNumber() < quantity)
				return false;
		}
			break;
		case FOOD: {
			if (this.getPoundsFood() < (quantity * 5))
				return false;
		}
			break;
		case BULLETBOXES: {
			if (this.getBulletBoxesNumber() < quantity)
				return false;
		}
			break;
		}
		return true;
	}

	public int removeItem(int type, int quantity) {
		switch (type) {
		case OXEN: {
			if (quantity > this.getOxenNumber()) {
				quantity = this.getOxenNumber();
				this.setOxenNumber(0);
				return quantity;
			}
			break;
		}
		case AXLES: {
			if (quantity > this.getAxlesNumber()) {
				quantity = this.getAxlesNumber();
				this.setAxlesNumber(0);
				return quantity;
			}
			break;
		}
		case TONGUES: {
			if (quantity > this.getTonguesNumber()) {
				quantity = this.getTonguesNumber();
				this.setTonguesNumber(0);
				return quantity;
			}
			break;
		}
		case WHEELS: {
			if (quantity > this.getWheelsNumber()) {
				quantity = this.getWheelsNumber();
				this.setWheelsNumber(0);
				return quantity;
			}
			break;
		}
		case CLOTHES: {
			if (quantity > this.getClothesNumber()) {
				quantity = this.getClothesNumber();
				this.setClothesNumber(0);
				return quantity;
			}
			break;
		}
		case FOOD: {
			if (quantity > this.getPoundsFood()) {
				quantity = this.getPoundsFood();
				this.setPoundsFood(0);
				return quantity;
			}
			break;
		}
		case BULLETBOXES: {
			if (quantity > this.getBulletBoxesNumber()) {
				quantity = this.getBulletBoxesNumber();
				this.setBulletBoxesNumber(0);
				return quantity;
			}
		}
		break;
		}
		return super.removeItem(type, quantity);
	}

	public boolean hasItem(int type) {
		switch (type) {
		case OXEN:
			if (getOxenNumber() > 0)
				return true;
		case AXLES:
			if (getAxlesNumber() > 0)
				return true;
		case TONGUES:
			if (getTonguesNumber() > 0)
				return true;
		case WHEELS:
			if (getWheelsNumber() > 0)
				return true;
		case CLOTHES:
			if (getClothesNumber() > 0)
				return true;
		case FOOD:
			if (getPoundsFood() > 0)
				return true;
		case BULLETBOXES:
			if (getBulletBoxesNumber() > 0)
				return true;
		}
		return false;
	}

	public String eatFood(int numPeople, Rations rations) {
		String noFood = "You have no food, you will die soon.";
		// Tells whether there was no food
		int poundsConsumed = numPeople * rations.getFoodConsumedPerTurn();
		if (items[Inventory.FOOD] == 0)
			return noFood;
		if (poundsConsumed > items[Inventory.FOOD]) {
			items[Inventory.FOOD] = 0;
			return "You are now out of food.";
		} else {
			items[Inventory.FOOD] -= numPeople
					* rations.getFoodConsumedPerTurn();
			return "";
		}
	}
	
	public int addFood(int pounds)
	{
		if((getWeight()+pounds)>MAX_WEIGHT)
		{
			int foodAdded =  MAX_WEIGHT-getWeight();
			this.setPoundsFood(this.getPoundsFood()+foodAdded);
			return foodAdded;
		}
		this.setPoundsFood(this.getPoundsFood()+pounds);
		return pounds;
	}

}
