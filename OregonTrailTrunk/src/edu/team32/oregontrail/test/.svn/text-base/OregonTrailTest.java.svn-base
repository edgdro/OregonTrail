package edu.team32.oregontrail.test;
import edu.team32.oregontrail.data.Milestone;
import edu.team32.oregontrail.game.logic.GameLogic;
import edu.team32.oregontrail.inventory.Inventory;
import edu.team32.oregontrail.inventory.ShopInventory;
import edu.team32.oregontrail.inventory.WagonInventory;
import junit.framework.TestCase;


public class OregonTrailTest extends TestCase {
	GameLogic testLogic = new GameLogic();
	WagonInventory testWagonInv = new WagonInventory(500000);
	ShopInventory testInv = new ShopInventory(0);
	
	public void setUp(){
		
	}
	
	public void testAddItem(){
		
		testWagonInv.addFood(50);
		//Make sure food works
		assertEquals(50, testWagonInv.getPoundsFood());
		
		testWagonInv.addItem(Inventory.AXLES, 2);
		assertEquals(2, testWagonInv.getAxlesNumber());
		
		testWagonInv.addItem(Inventory.CLOTHES, 20);
		assertEquals(20, testWagonInv.getClothesNumber());
		
		testWagonInv.addItem(Inventory.FOOD, 2);
		assertEquals(60, testWagonInv.getPoundsFood());
		
		testWagonInv.addItem(Inventory.OXEN, 4);
		assertEquals(4, testWagonInv.getOxenNumber());
		
		testWagonInv.addItem(Inventory.TONGUES, 0);
		assertEquals(0, testWagonInv.getTonguesNumber());
		
		testWagonInv.addItem(Inventory.WHEELS, 7);
		assertEquals(7, testWagonInv.getWheelsNumber());
		
		testWagonInv.addItem(Inventory.BULLETBOXES, 10);
		assertEquals(10, testWagonInv.getBulletBoxesNumber());

		
	}
	
	public void testRemoveItem(){
		
		testWagonInv.addFood(50);
		testWagonInv.addItem(Inventory.AXLES, 2);
		testWagonInv.addItem(Inventory.CLOTHES, 20);
		testWagonInv.addItem(Inventory.FOOD, 2);
		testWagonInv.addItem(Inventory.OXEN, 4);
		testWagonInv.addItem(Inventory.TONGUES, 0);
		testWagonInv.addItem(Inventory.WHEELS, 7);
		testWagonInv.addItem(Inventory.BULLETBOXES, 10);
	
		testWagonInv.removeItem(Inventory.AXLES, 2);
		assertEquals(0, testWagonInv.getAxlesNumber());
		
		testWagonInv.removeItem(Inventory.CLOTHES, 20);
		assertEquals(0, testWagonInv.getClothesNumber());
		
		testWagonInv.removeItem(Inventory.FOOD, 2);
		assertEquals(58, testWagonInv.getPoundsFood());
		
		testWagonInv.removeItem(Inventory.OXEN, 4);
		assertEquals(0, testWagonInv.getOxenNumber());
		
		testWagonInv.removeItem(Inventory.TONGUES, 5);
		assertEquals(0, testWagonInv.getTonguesNumber());
		
		testWagonInv.removeItem(Inventory.WHEELS, 7);
		assertEquals(0, testWagonInv.getWheelsNumber());
		
		testWagonInv.removeItem(Inventory.BULLETBOXES, 5);
		assertEquals(5, testWagonInv.getBulletBoxesNumber());
		
	}
	
	
	public void testCalcInventory(){
		testWagonInv.addFood(50);
		testWagonInv.addItem(Inventory.AXLES, 2);
		testWagonInv.addItem(Inventory.CLOTHES, 20);
		testWagonInv.addItem(Inventory.FOOD, 2);
		testWagonInv.addItem(Inventory.OXEN, 4);
		testWagonInv.addItem(Inventory.TONGUES, 0);
		testWagonInv.addItem(Inventory.WHEELS, 7);
		testWagonInv.addItem(Inventory.BULLETBOXES, 10);
		
		testLogic.getWagon().setWagonInventory(testWagonInv);
		
		assertEquals(2, testLogic.calcInventory(Inventory.AXLES, false));
		assertEquals(20, testLogic.calcInventory(Inventory.CLOTHES, false));
		assertEquals(60, testLogic.calcInventory(Inventory.FOOD, false));
		assertEquals(4, testLogic.calcInventory(Inventory.OXEN, false));
		assertEquals(0, testLogic.calcInventory(Inventory.TONGUES, false));
		assertEquals(7, testLogic.calcInventory(Inventory.WHEELS, false));
		assertEquals(10, testLogic.calcInventory(Inventory.BULLETBOXES, false));
	}
	
	
	public void testSellItems(){
		int[] testItems = {4,2,5,7,4,0,2};
		
		
		testWagonInv.addFood(50);
		testWagonInv.addItem(Inventory.AXLES, 20);
		testWagonInv.addItem(Inventory.CLOTHES, 20);
		testWagonInv.addItem(Inventory.FOOD, 2);
		testWagonInv.addItem(Inventory.OXEN, 40);
		testWagonInv.addItem(Inventory.TONGUES, 30);
		testWagonInv.addItem(Inventory.WHEELS, 7);
		testWagonInv.addItem(Inventory.BULLETBOXES, 10);
		
		testLogic.getWagon().setWagonInventory(testWagonInv);
		testLogic.getCurrentMilestone().setShopInventory(testInv);
		
		testLogic.sellItems(testItems);
		
		assertEquals(18, testLogic.calcInventory(Inventory.AXLES, false));
		assertEquals(16, testLogic.calcInventory(Inventory.CLOTHES, false));
		assertEquals(60, testLogic.calcInventory(Inventory.FOOD, false));
		assertEquals(36, testLogic.calcInventory(Inventory.OXEN, false));
		assertEquals(25, testLogic.calcInventory(Inventory.TONGUES, false));
		assertEquals(0, testLogic.calcInventory(Inventory.WHEELS, false));
		assertEquals(8, testLogic.calcInventory(Inventory.BULLETBOXES, false));
		
		
	}
	
	
	public void testPurchaseItems(){
		int[] testItems = {4,2,5,7,4,0,2};
		
		
		testWagonInv.addFood(50);
		testWagonInv.addItem(Inventory.AXLES, 20);
		testWagonInv.addItem(Inventory.CLOTHES, 20);
		testWagonInv.addItem(Inventory.FOOD, 2);
		testWagonInv.addItem(Inventory.OXEN, 40);
		testWagonInv.addItem(Inventory.TONGUES, 30);
		testWagonInv.addItem(Inventory.WHEELS, 7);
		testWagonInv.addItem(Inventory.BULLETBOXES, 10);
		
		testLogic.getWagon().setWagonInventory(testWagonInv);
		testLogic.getCurrentMilestone().setShopInventory(testInv);
		
		testLogic.purchaseItems(testItems);
		
		assertEquals(22, testLogic.calcInventory(Inventory.AXLES, false));
		assertEquals(24, testLogic.calcInventory(Inventory.CLOTHES, false));
		assertEquals(60, testLogic.calcInventory(Inventory.FOOD, false));
		assertEquals(44, testLogic.calcInventory(Inventory.OXEN, false));
		assertEquals(35, testLogic.calcInventory(Inventory.TONGUES, false));
		assertEquals(14, testLogic.calcInventory(Inventory.WHEELS, false));
		assertEquals(12, testLogic.calcInventory(Inventory.BULLETBOXES, false));
		
		
	}	
	

}
