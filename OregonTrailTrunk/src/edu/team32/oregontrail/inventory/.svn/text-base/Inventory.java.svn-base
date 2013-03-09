package edu.team32.oregontrail.inventory;

import java.io.Serializable;

/**
 * Represents an inventory in the game's current session.
 * 
 * @author Team 32
 * 
 */
public class Inventory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4443900275474528460L;
	/**
	 * The weight of an axle
	 */
	public static final int AXLE_WEIGHT = 125;
	/**
	 * The weight of a tongue
	 */
	public static final int TONGUE_WEIGHT = 100;
	/**
	 * The weight of a wheel
	 */
	public static final int WHEEL_WEIGHT = 75;
	/**
	 * The weight of pair of clothes
	 */
	public static final int CLOTHES_WEIGHT = 2;
	/**
	 * The weight of a set of food, used for Shop
	 */
	public static final int FOOD_WEIGHT = 5;
	/**
	 * The weight of a box of bullets
	 */
	public static final int BULLET_BOX_WEIGHT = 3;

	/**
	 * The number of bullets a box of bullets contains
	 */
	public static final int BULLET_BOX_SIZE = 20;

	public static final int OXEN = 0;
	public static final int AXLES = 1;
	public static final int TONGUES = 2;
	public static final int WHEELS = 3;
	public static final int CLOTHES = 4;
	public static final int FOOD = 5;
	public static final int BULLETBOXES = 6;
	protected int[] items = new int[7];

	/**
	 * Default constructor for the inventory.
	 */
	public Inventory() {

	}

	/**
	 * Initializes the inventory to the inputed parameter.
	 * 
	 * @param inventory
	 *            The inventory to be set
	 */
	public void setInventory(int[] inventory) {
		items[OXEN] = inventory[OXEN];
		items[AXLES] = inventory[AXLES];
		items[TONGUES] = inventory[TONGUES];
		items[WHEELS] = inventory[WHEELS];
		items[CLOTHES] = inventory[CLOTHES];
		items[FOOD] = inventory[FOOD];
		items[BULLETBOXES] = inventory[BULLETBOXES];
	}

	/**
	 * Calculates the weight based on the current items in the inventory.
	 * 
	 * @return The weight of the player's inventory
	 */
	public int getInventoryWeight() {
		int weight = 0;
		weight += items[AXLES] * AXLE_WEIGHT;
		weight += items[TONGUES] * TONGUE_WEIGHT;
		weight += items[WHEELS] * WHEEL_WEIGHT;
		weight += items[CLOTHES] * CLOTHES_WEIGHT;
		weight += items[FOOD]; // You buy food at 5 pounds but food will be
								// stored by the pound
		weight += items[BULLETBOXES] * BULLET_BOX_WEIGHT;
		return weight;
	}

	/**
	 * Returns the quantity of the queried type
	 * 
	 * @param type
	 *            The item to be queried
	 * @return the quantity of the queried type
	 */
	public int getQuantity(int type) {
		if (type == Inventory.OXEN) {
			return this.getOxenNumber();
		} else if (type == Inventory.AXLES) {
			return this.getAxlesNumber();
		} else if (type == Inventory.TONGUES) {
			return this.getTonguesNumber();
		} else if (type == Inventory.WHEELS) {
			return this.getWheelsNumber();
		} else if (type == Inventory.CLOTHES) {
			return this.getClothesNumber();
		} else if (type == Inventory.FOOD) {
			return this.getPoundsFood();
		} else if (type == Inventory.BULLETBOXES) {
			return this.getBulletBoxesNumber();
		}
		return 0;
	}

	/**
	 * Returns the weight of the queried type
	 * 
	 * @param type
	 *            The item to be queried
	 * @return the weight of the queried type
	 */
	public static int getWeight(int type) {
		if (type == Inventory.OXEN) {
			return 0;
		} else if (type == Inventory.AXLES) {
			return Inventory.AXLE_WEIGHT;
		} else if (type == Inventory.TONGUES) {
			return Inventory.TONGUE_WEIGHT;
		} else if (type == Inventory.WHEELS) {
			return Inventory.WHEEL_WEIGHT;
		} else if (type == Inventory.CLOTHES) {
			return Inventory.CLOTHES_WEIGHT;
		} else if (type == Inventory.FOOD) {
			return Inventory.FOOD_WEIGHT;
		} else if (type == Inventory.BULLETBOXES) {
			return Inventory.BULLET_BOX_WEIGHT;
		}
		return 0;
	}

	/**
	 * Gets the number of oxen in the inventory.
	 * 
	 * @return The number of oxen
	 */
	public int getOxenNumber() {
		return items[OXEN];
	}

	/**
	 * Gets the number of axles in the inventory.
	 * 
	 * @return The number of wagon axles
	 */
	public int getAxlesNumber() {
		return items[AXLES];
	}

	/**
	 * Gets the number of wagon tongues in the inventory.
	 * 
	 * @return The number of wagon tongues
	 */
	public int getTonguesNumber() {
		return items[TONGUES];
	}

	/**
	 * Gets the number of wagon wheels in the inventory.
	 * 
	 * @return The number of wagon wheels
	 */
	public int getWheelsNumber() {
		return items[WHEELS];
	}

	/**
	 * Gets the amount of clothes in the inventory.
	 * 
	 * @return The number of clothes
	 */
	public int getClothesNumber() {
		return items[CLOTHES];
	}

	/**
	 * Gets the amount of food in the inventory.
	 * 
	 * @return The amount of food
	 */
	public int getPoundsFood() {
		return items[FOOD];
	}

	/**
	 * Gets the number of bullet boxes in the inventory.
	 * 
	 * @return The number of bullet boxes
	 */
	public int getBulletBoxesNumber() {
		return items[BULLETBOXES];
	}

	/**
	 * Initializes the number of oxen to the inputed parameter.
	 * 
	 * @param number
	 *            The new number of oxen
	 */
	public void setOxenNumber(int number) {
		items[OXEN] = number;
	}

	/**
	 * Initializes the number of wagon axles to the inputed parameter.
	 * 
	 * @param number
	 *            The new number of wagon axles
	 */
	public void setAxlesNumber(int number) {
		items[AXLES] = number;
	}

	/**
	 * Initializes the number of wagon tongues to the inputed parameter.
	 * 
	 * @param number
	 *            The new number of wagon tongues
	 */
	public void setTonguesNumber(int number) {
		items[TONGUES] = number;
	}

	/**
	 * Initializes the number of wagon wheels to the inputed parameter.
	 * 
	 * @param number
	 *            The new number of wagon wheels
	 */
	public void setWheelsNumber(int number) {
		items[WHEELS] = number;
	}

	/**
	 * Initializes the amount of clothes to the inputed parameter.
	 * 
	 * @param number
	 *            The new amount of clothes
	 */
	public void setClothesNumber(int number) {
		items[CLOTHES] = number;
	}

	/**
	 * Initializes the amount of food to the inputed parameter.
	 * 
	 * @param number
	 *            The new amount of food
	 */
	public void setPoundsFood(int number) {
		items[FOOD] = number;
	}

	/**
	 * Initializes the number of bullet boxes to the inputed parameter.
	 * 
	 * @param number
	 *            The new number of bullet boxes
	 */
	public void setBulletBoxesNumber(int number) {
		items[BULLETBOXES] = number;
	}

	/**
	 * Prints out a toString of the number of item plus the item name, singular
	 * or pluralized depending on amount
	 * 
	 * @param type
	 *            The item number
	 * @param quantity
	 *            The amount of the item
	 * @return A toString representing the number plus the item name
	 */
	public static String toString(int type, int quantity) {
		switch (type) {
		case OXEN: {
			if (quantity > 1) {
				return quantity + " Oxen";
			}
			return quantity + " Ox";
		}
		case AXLES: {
			if (quantity > 1) {
				return quantity + " Axles";
			}
			return quantity + " Axle";
		}

		case TONGUES: {
			if (quantity > 1) {
				return quantity + " Tongues";
			}
			return quantity + " Tongue";
		}

		case WHEELS: {
			if (quantity > 1) {
				return quantity + " Wheels";
			}
			return quantity + " Wheel";
		}

		case CLOTHES: {
			if (quantity > 1) {
				return quantity + " Sets of Clothes";
			}
			return quantity + " Set of Clothes";
		}

		case FOOD: {
			if (quantity > 1) {
				return quantity + " Pounds of Food";
			}
			return quantity + " Pound of Food";
		}

		case BULLETBOXES: {
			if (quantity > 1) {
				return quantity + " Boxes of Bullets";
			}
			return quantity + " Box of Bullets";
		}
		}
		return "";
	}

	/**
	 * Returns an array filled with the amount of each item in the appropriate
	 * location
	 * 
	 * @return an array filled with the amount of each item in the appropriate
	 *         location
	 */
	public int[] getItems() {
		return items;
	}

	/**
	 * Adds an item of a specific type and quantity to the wagon's inventory.
	 * 
	 * @param type
	 *            The type of the item to add
	 * @param quantity
	 *            The quantity of the item to add
	 */
	public void addItem(int type, int quantity) {
		switch (type) {
		case OXEN: {
			this.setOxenNumber(this.getOxenNumber() + quantity);
		}
			break;
		case AXLES: {
			this.setAxlesNumber(this.getAxlesNumber() + quantity);
		}
			break;
		case TONGUES: {
			this.setTonguesNumber(this.getTonguesNumber() + quantity);
		}
			break;
		case WHEELS: {
			this.setWheelsNumber(this.getWheelsNumber() + quantity);
		}
			break;
		case CLOTHES: {
			this.setClothesNumber(this.getClothesNumber() + quantity);
		}
			break;
		case FOOD: {
			this.setPoundsFood(this.getPoundsFood()
					+ (quantity * Inventory.FOOD_WEIGHT));
		}
			break;
		case BULLETBOXES: {
			this.setBulletBoxesNumber(this.getBulletBoxesNumber() + quantity);
		}
			break;
		}
	}

	/**
	 * Removes a specific type and quantity of an item from the wagon's
	 * inventory.
	 * 
	 * @param type
	 *            The type of item to remove
	 * @param quantity
	 *            The quantity of the item to remove
	 */
	public int removeItem(int type, int quantity) {
		switch (type) {
		case OXEN: {
			if (this.getOxenNumber() == 0) {
			} else {
				this.setOxenNumber((this.getOxenNumber() - quantity));
				return quantity;
			}
		}
			break;
		case AXLES: {
			if (this.getAxlesNumber() == 0) {
			} else {
				this.setAxlesNumber((this.getAxlesNumber() - quantity));
				return quantity;
			}
		}
			break;
		case TONGUES: {
			if (this.getTonguesNumber() == 0) {
			} else {
				this.setTonguesNumber((this.getTonguesNumber() - quantity));
				return quantity;
			}
		}
			break;
		case WHEELS: {
			if (this.getWheelsNumber() == 0) {
			} else {
				this.setWheelsNumber((this.getWheelsNumber() - quantity));
				return quantity;
			}
		}
			break;
		case CLOTHES: {
			if (this.getClothesNumber() == 0) {
			} else {
				this.setClothesNumber((this.getClothesNumber() - quantity));
				return quantity;
			}
		}
			break;
		case FOOD: {
			if (this.getPoundsFood() == 0) {
			} else {
				this.setPoundsFood((this.getPoundsFood() - quantity));
				return quantity;
			}
		}
			break;
		case BULLETBOXES: {
			if (this.getBulletBoxesNumber() == 0) {
			} else {
				this.setBulletBoxesNumber((this.getBulletBoxesNumber() - quantity));
				return quantity;
			}
		}
			break;
		}
		return 0;
	}

}
