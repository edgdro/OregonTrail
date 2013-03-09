package edu.team32.oregontrail.inventory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a shop's inventory at a current milestone in the game.
 * 
 * @author Team 32
 *
 */
public class ShopInventory extends Inventory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4777218581754347257L;
	private double priceModifier = 1;
	private int sellModifier = 2;
	public static final int OXEN_PRICE = 40;
	public static final int AXLE_PRICE = 10;
	public static final int TONGUE_PRICE = 10;
	public static final int WHEEL_PRICE = 10;
	public static final int CLOTHES_PRICE = 10;
	public static final int FOOD_PRICE = 1;
	public static final int BULLET_BOX_PRICE = 2;
	private final static int INITIAL_QUANTITY = 99;
	private final static int INITIAL_FOOD_QUANTITY = 9999;
	
	//the higher the rate, the more likely there will be MORE items in the store
	private static final int ITEM_SCARCITY = 300; 
	//the higher the rate, the more expensive items get the further you travel down the trail
	private static final int PRICE_INFLAMATION_RATE = 500;
	
	/**
	 * Constructor for the shop's inventory defines how far from the
	 * start point it is by initializing it to the inputed parameter.
	 * 
	 * @param milesFromStart
	 * 				The number of miles the shop is from the start
	 */
	public ShopInventory(int milesFromStart)
	{
		if(milesFromStart == 0)
		{
			int[] inventory = {INITIAL_QUANTITY,INITIAL_QUANTITY,INITIAL_QUANTITY,INITIAL_QUANTITY,
					INITIAL_QUANTITY,INITIAL_FOOD_QUANTITY,INITIAL_QUANTITY};
			this.setInventory(inventory);
		}
		else {
			Random random = new Random();
			priceModifier = ((double)milesFromStart /(double)PRICE_INFLAMATION_RATE) + 1; //+1 makes sure its always above 1
			int maxOutOfStockItems = milesFromStart / ITEM_SCARCITY;
			//7 items total so this gurantees there will always be one item in the store
			if(maxOutOfStockItems > 6) {
				maxOutOfStockItems = 6;
			}
			int outOfStockItems = 0;
			if(maxOutOfStockItems != 0) {
				outOfStockItems = random.nextInt(maxOutOfStockItems);
			}
			ArrayList<Integer> stockedItems = new ArrayList<Integer>();
			for(int x = 0; x < 7; x++) { //create list of all possible indexes to lose
				stockedItems.add(x);
			}
			for(int i = 0; i < outOfStockItems; i++) { //removes random shit
				stockedItems.remove(random.nextInt(stockedItems.size()));
			}
			int[] newInventory = new int[7];
			for(int x = 0; x < newInventory.length; x++) {
				for(int y = 0; y < stockedItems.size(); y++) {
					if(x == stockedItems.get(y)) { //is this item in the stockedItems list
						stockedItems.remove(y);
						//TODO algorithm for amount of items in stock
						if(x == Inventory.FOOD) {
							newInventory[x] = random.nextInt(200);
						}
						else {
							newInventory[x] = random.nextInt(10);
						}
						break;
					}
				}
			}
			this.setInventory(newInventory);
		}
	}
	/**
	 * Adds the items to the wagon's inventory if the wagon has sufficient
	 * money to make the purchase.
	 * 
	 * @param wagonInventory
	 * 				The wagon inventory to add the items to
	 * @param items
	 * 				The list of items to add
	 */
	public void purchaseItems(WagonInventory wagonInventory, int[] items) {
		int price = calcBuyPrice(items);
		if (wagonInventory.hasSufficientMoney(price)) {
			wagonInventory.removeMoney(price);
			wagonInventory.addItem(OXEN, items[OXEN]);
			wagonInventory.addItem(AXLES, items[AXLES]);
			wagonInventory.addItem(TONGUES, items[TONGUES]);
			wagonInventory.addItem(WHEELS, items[WHEELS]);
			wagonInventory.addItem(CLOTHES, items[CLOTHES]);
			wagonInventory.addItem(FOOD, items[FOOD]);
			wagonInventory.addItem(BULLETBOXES, items[BULLETBOXES]);
			this.removeItem(OXEN, items[OXEN]);
			this.removeItem(AXLES, items[AXLES]);
			this.removeItem(TONGUES, items[TONGUES]);
			this.removeItem(WHEELS, items[WHEELS]);
			this.removeItem(CLOTHES, items[CLOTHES]);
			this.removeItem(FOOD, items[FOOD]);
			this.removeItem(BULLETBOXES, items[BULLETBOXES]);
		}
	}
	/**
	 * Sells items to the store by removing them from the wagon and adding
	 * them to the store.
	 * 
	 * @param wagonInventory
	 * 				The wagon inventory to remove the items from
	 * @param items
	 * 				The list of items to sell
	 */
	public void sellItems(WagonInventory wagonInventory, int[] items) {
		int price = calcSellPrice(items);
		wagonInventory.addMoney(price);
		wagonInventory.removeItem(OXEN, items[OXEN]);
		wagonInventory.removeItem(AXLES, items[AXLES]);
		wagonInventory.removeItem(TONGUES, items[TONGUES]);
		wagonInventory.removeItem(WHEELS, items[WHEELS]);
		wagonInventory.removeItem(CLOTHES, items[CLOTHES]);
		wagonInventory.removeItem(FOOD, items[FOOD]);
		wagonInventory.removeItem(BULLETBOXES, items[BULLETBOXES]);
		this.addItem(OXEN, items[OXEN]);
		this.addItem(AXLES, items[AXLES]);
		this.addItem(TONGUES, items[TONGUES]);
		this.addItem(WHEELS, items[WHEELS]);
		this.addItem(CLOTHES, items[CLOTHES]);
		this.addItem(FOOD, items[FOOD]);
		this.addItem(BULLETBOXES, items[BULLETBOXES]);
	}
	/**
	 * Calculates the purchase cost of the items.
	 * 
	 * @param items
	 * 			The list of items to calculate the price of
	 * 
	 * @return The total cost of the purchase
	 */
	public int calcBuyPrice(int[] items)
	{
		int buyPrice =0; 
		buyPrice += items[Inventory.OXEN] * this.getOxenBuyPrice();
		buyPrice += items[Inventory.AXLES] * this.getAxleBuyPrice();
		buyPrice += items[Inventory.TONGUES] * this.getTongueBuyPrice();
		buyPrice += items[Inventory.WHEELS] * this.getWheelBuyPrice();
		buyPrice += items[Inventory.CLOTHES] * this.getClothesBuyPrice();
		buyPrice += items[Inventory.FOOD] * this.getFoodBuyPrice();
		buyPrice += items[Inventory.BULLETBOXES] * this.getBulletBoxBuyPrice();
		return buyPrice;
	}
	/**
	 * Calculates the price of items a player wishes to sell.
	 * 
	 * @param items
	 * 			The list of items to sell
	 * 
	 * @return The selling price
	 */
	public int calcSellPrice(int[] items)
	{
		int sellPrice = 0; 
		sellPrice += items[Inventory.OXEN] * this.getOxenSellPrice();
		sellPrice += items[Inventory.AXLES] * this.getAxleSellPrice();
		sellPrice += items[Inventory.TONGUES] * this.getTongueSellPrice();
		sellPrice += items[Inventory.WHEELS] * this.getWheelSellPrice();
		sellPrice += items[Inventory.CLOTHES] * this.getClothesSellPrice();
		sellPrice += items[Inventory.FOOD] * this.getFoodSellPrice();
		sellPrice += items[Inventory.BULLETBOXES] * this.getBulletBoxSellPrice();
		return sellPrice;
	}
	/**
	 * Accesses the selling price of a specific item.
	 * 
	 * @param item
	 * 			The item to get the selling price of
	 * 
	 * @return The selling price of the item
	 */
	public int getSellPrice(int item)
	{
		switch(item)
		{
			case Inventory.OXEN: 
				return getOxenSellPrice();
			case Inventory.AXLES: 
				return getAxleSellPrice();
			case Inventory.TONGUES: 
				return getTongueSellPrice();
			case Inventory.WHEELS: 
				return getWheelSellPrice();
			case Inventory.CLOTHES: 
				return getClothesSellPrice();
			case Inventory.FOOD: 
				return getFoodSellPrice();
			case Inventory.BULLETBOXES: 
				return getBulletBoxSellPrice();
			default: 
				return 0;
		}
	}
	
	/**
	 * Accesses the buying price of a specific item.
	 * 
	 * @param item
	 * 			The type of item
	 * 
	 * @return The buying price of the item
	 */
	public int getBuyPrice(int item)
	{
		switch(item)
		{
			case Inventory.OXEN: 
				return getOxenBuyPrice();
			case Inventory.AXLES: 
				return getAxleBuyPrice();
			case Inventory.TONGUES: 
				return getTongueBuyPrice();
			case Inventory.WHEELS: 
				return getWheelBuyPrice();
			case Inventory.CLOTHES: 
				return getClothesBuyPrice();
			case Inventory.FOOD: 
				return getFoodBuyPrice();
			case Inventory.BULLETBOXES: 
				return getBulletBoxBuyPrice();
			default: 
				return 0;
		}	
	}
	
	/**
	 * Determines the purchase cost of oxen.
	 * 
	 * @return The cost of oxen
	 */
	public int getOxenBuyPrice()
	{
		int price = (int)(this.priceModifier * OXEN_PRICE); 
		return price;
	}
	/**
	 * Determines the purchase cost of wagon axles.
	 * 
	 * @return The cost of wagon axles
	 */
	public int getAxleBuyPrice()
	{
		int price = (int)(this.priceModifier * ShopInventory.AXLE_PRICE); 
		return price;
	}
	/**
	 * Determines the purchase cost of wagon tongues.
	 * 
	 * @return The cost of wagon tongues
	 */
	public int getTongueBuyPrice()
	{
		int price = (int)(this.priceModifier * ShopInventory.TONGUE_PRICE); 
		return price;
	}
	/**
	 * Determines the purchase cost of wagon wheels.
	 * 
	 * @return The cost of wagon wheels
	 */
	public int getWheelBuyPrice()
	{
		int price = (int)(this.priceModifier * ShopInventory.WHEEL_PRICE); 
		return price;
	}
	/**
	 * Determines the purchase cost of clothing.
	 * 
	 * @return The cost of clothing
	 */
	public int getClothesBuyPrice()
	{
		int price = (int)(this.priceModifier * ShopInventory.CLOTHES_PRICE); 
		return price;
	}
	/**
	 * Determines the purchase cost of food.
	 * 
	 * @return The cost of food
	 */
	public int getFoodBuyPrice()
	{
		int price = (int)(this.priceModifier * ShopInventory.FOOD_PRICE); 
		return price;
	}
	/**
	 * Determines the purchase cost of a box of bullets.
	 * 
	 * @return The cost of a box of bullets
	 */
	public int getBulletBoxBuyPrice()
	{
		int price = (int)(this.priceModifier * ShopInventory.BULLET_BOX_PRICE); 
		return price;
	}
	/**
	 * Determines the selling price of oxen based on where the wagon
	 * is on the map.
	 * 
	 * @return The selling price of oxen
	 */
	public int getOxenSellPrice()
	{
		int price = (int)(getSellModifier() * ShopInventory.OXEN_PRICE); 
		return price;
	}
	/**
	 * Determines the selling price of wagon axles based on where the wagon
	 * is on the map.
	 * 
	 * @return The selling price of wagon axles
	 */
	public int getAxleSellPrice()
	{
		int price = (int)(getSellModifier() * ShopInventory.AXLE_PRICE); 
		return price;
	}
	/**
	 * Determines the selling price of wagon tongues based on where the wagon
	 * is on the map.
	 * 
	 * @return The selling price of a wagon tongue
	 */
	public int getTongueSellPrice()
	{
		int price = (int)(getSellModifier() * ShopInventory.TONGUE_PRICE); 
		return price;
	}
	/**
	 * Determines the selling price of wagon wheels based on where the wagon
	 * is on the map.
	 * 
	 * @return The selling price of a wagon wheel
	 */
	public int getWheelSellPrice()
	{
		int price = (int)(getSellModifier() * ShopInventory.WHEEL_PRICE); 
		return price;
	}
	/**
	 * Determines the selling price of clothing based on where the wagon
	 * is on the map.
	 * 
	 * @return The selling price of clothing
	 */
	public int getClothesSellPrice()
	{
		int price = (int)(getSellModifier() * ShopInventory.CLOTHES_PRICE); 
		return price;
	}
	/**
	 * Determines the selling price of food based on where the wagon
	 * is on the map.
	 * 
	 * @return The selling price of food
	 */
	public int getFoodSellPrice()
	{
		int price = (int)(getSellModifier() * ShopInventory.FOOD_PRICE); 
		return price;
	}
	/**
	 * Determines the selling price of a box of bullets based on where the
	 * wagon is on the map.
	 * 
	 * @return The selling price of a box of bullets
	 */
	public int getBulletBoxSellPrice()
	{
		int price = (int)(getSellModifier() * ShopInventory.BULLET_BOX_PRICE); 
		return price;
	}
	/**
	 * Accesses the current prices of items in the store's inventory.
	 * 
	 * @return A list of current item prices for the store
	 */
	public int[] getPrices(){
		int[] inventoryPrice = new int[7];
		inventoryPrice[Inventory.OXEN]=(int)(OXEN_PRICE * this.priceModifier);
		inventoryPrice[Inventory.AXLES]= (int)(AXLE_PRICE * this.priceModifier);
		inventoryPrice[Inventory.TONGUES]=(int)(TONGUE_PRICE * this.priceModifier);
		inventoryPrice[Inventory.WHEELS]=(int)(WHEEL_PRICE * this.priceModifier);
		inventoryPrice[Inventory.CLOTHES]=(int)(CLOTHES_PRICE * this.priceModifier);
		inventoryPrice[Inventory.FOOD]=(int)(FOOD_PRICE * this.priceModifier);
		inventoryPrice[Inventory.BULLETBOXES]=(int)(BULLET_BOX_PRICE * this.priceModifier);
		return inventoryPrice;
	}
	
	private double getSellModifier()
	{
		return (double)this.priceModifier/(double)this.sellModifier;
	}
	
}
