package edu.team32.oregontrail.events;

import edu.team32.oregontrail.data.Companion;
import edu.team32.oregontrail.data.Map;
import edu.team32.oregontrail.datahandler.Wagon;
import edu.team32.oregontrail.inventory.Inventory;
import edu.team32.oregontrail.enums.*;

import java.util.ArrayList;
import java.util.Random;
/**
 * Represents a random event in the game.
 * 
 * @author Team 32
 *
 */

public class RandomEvent {
	// percentages that people get sick
	private static int PERSON_SICK = 6;
	private static int OXEN_SICK = 4;
	private static int FIND_FOOD = 7;
	private static int WAGON_BREAKS = 3;
	private static int THIEVES = 3;
	private static int LOST = 6;
	private static int FOOD_SPOILS = 6;
	private static int WAGON_FIRE = 6;
	private static int PITY_FOOD = 5;
	private static int OXEN_HEALTHY = 4;
	
	//Chance that an ox will die if they are sick
	private static  int OXEN_DEATH_RATE = 60;
	// max amount of food that can be found when a farmer finds food
	private static final int MAX_AMOUNT_OF_FOOD_FOUND = 100;
	// max amount of food that can be spoiled during food spoiled event
	private static final int MAX_AMOUNT_OF_FOOD_SPOILED = 100;
	// max items that can be stolen during a thief event
	private static final int MAX_QUANTITY_STOLEN = 2;
	// percent chance that carpenter dodges event
	private static final int CARPENTER_ANTI_WAGON_BREAK = 50;
	
	// percent chance that you fix wagon break down
	private static final int WAGON_FIX_RATE = 95;
	private static final int MIN_PITY_FOOD = 10;
	private static final int RAND_PITY_FOOD = 90; // MIN+ RAND = 10 < x < 100
													// range

	// the chance that nothing happens is the remaining percentage
	/**
	 * Rolls a random event based on the many factors determined by decisions
	 * that the player makes.
	 * 
	 * @param wagon
	 *            The wagon altered by the random event
	 * 
	 * @return A string representing the repercussions of the event
	 */
	public static String rollEvent(Wagon wagon) {
		generateVariables(wagon);
		Random random = new Random(); // random object to use for generating
										// random chances
		int roll = (int) (Math.random() * 100);
		int totalPercentage = 0;
		if (roll < PERSON_SICK) {
			// list off all the indices of players who are healthy, 0 represents
			// the player
			ArrayList<Integer> healthyIndices = new ArrayList<Integer>();
			if (!wagon.getPlayer().hasStatus(Status.SICK)) {
				healthyIndices.add(0);
			}
			// start at 0 but add 1 because player gets the 0 index
			for (int x = 0; x < wagon.MAX_COMPANIONS; x++) {
				if (!wagon.getCompanions()[x].hasStatus(Status.SICK) && !wagon.getCompanions()[x].isDead()) {
					healthyIndices.add(x + 1);
				}
			}
			{
				if (healthyIndices.size() > 0) {
					int indexOfPersonToGetSick = random.nextInt(healthyIndices
							.size());
					if (indexOfPersonToGetSick == 0) { // index is 0 so player
														// gets sick
						wagon.getPlayer().canMakeSick();
						return wagon.getPlayer().getName() + " got sick."; // TODO
																			// add
																			// random
																			// sicknesses
					} else { // index is greater than 0 so the companion who
								// gets sick
								// is index - 1
						Companion sickPerson = wagon.getCompanions()[indexOfPersonToGetSick - 1];
						sickPerson.canMakeSick();
						return sickPerson.getName() + " got sick."; // TODO add
																	// random
																	// sickness
					}
				}
				return "Nothing exciting happens...";
			}
		}
		// checks if roll is less than the running total plus event percentage
		// the += inside the if updates totalPercentage and checks the new
		// needed value
		else if (roll < (totalPercentage += OXEN_SICK)) {
			if (!wagon.hasOxenStatus(Status.SICK)) {
				wagon.setOxenStatus(Status.SICK);
				return "Your oxen are sick.";
			}
			else if(random.nextInt(100)<OXEN_DEATH_RATE && wagon.hasOxenStatus(Status.SICK))
			{
				wagon.getWagonInventory().removeItem(Inventory.OXEN, 1);
				wagon.setOxenStatus(Status.HEALTHY);
				return "One of your ox has died";
			}
			return "Nothing exciting happened..."; // TODO maybe kill an oxen?
		}
		else if(roll < (totalPercentage += OXEN_HEALTHY))
		{
			if(wagon.hasOxenStatus(Status.SICK))
			{
				wagon.setOxenStatus(Status.HEALTHY);
				return "Your oxen's conditions have improved";
			}
		}
		else if (roll < (totalPercentage += FIND_FOOD)) {
			if (wagon.getPlayer().getProfession().equals(Profession.FARMER)) {
				int amountOfFood = random.nextInt(MAX_AMOUNT_OF_FOOD_FOUND);
				amountOfFood = wagon.getWagonInventory().addFood(amountOfFood);
				return "You found some edible shrooms. (+" + amountOfFood
						+ "lbs. of food)";
			}
			return "You ate some shrooms and now the world is spinning...";
		} else if (roll < (totalPercentage += FOOD_SPOILS)) {
			int amountOfFood = random.nextInt(MAX_AMOUNT_OF_FOOD_SPOILED);
			int foodLost = wagon.getWagonInventory().removeItem(Inventory.FOOD,
					amountOfFood);
			return "Some of your food got spoiled. (-" + foodLost
					+ "lbs. of food)";
		} else if (roll < (totalPercentage += LOST)) {
			// moves wagon back by its pace
			Map.getInstance().setMilesToNextMilestone(
					Map.getInstance().getMilesToNextMilestone()
							+ wagon.getPace().getMilesMovedPerTurn());
			Map.getInstance().setMilesTraveled(
					Map.getInstance().getMilesTraveled()
							- wagon.getPace().getMilesMovedPerTurn());
			return "You got lost and made no progress today";
		} else if (roll < (totalPercentage += THIEVES)) {
			int itemToLose = random.nextInt(7);
			if (itemToLose == Inventory.FOOD || itemToLose == Inventory.OXEN) // cant lose food or Oxen
			{
				return "Thieves came but didn't take anything important";
			} else {
				// TODO need to bounds check for removeItems and going negative?
				// removeItem() should do that
				int amountStolen = random.nextInt(MAX_QUANTITY_STOLEN);
				if (wagon.getWagonInventory().hasItem(itemToLose)
						&& amountStolen > 0) {
					amountStolen = wagon.getWagonInventory().removeItem(
							itemToLose, amountStolen);
					return "Thieves came and robbed you of "
							+ Inventory.toString(itemToLose, amountStolen)
							+ " during the night";
				} else
					return "Thieves came in the night and attempted to rob you but failed.";
				// TODO tell them what they are missing... how we gonna do
				// that...
			}
		} else if (roll < (totalPercentage += WAGON_BREAKS)) {
			// random percent that carpenter dodges event
			if (random.nextInt(100) < CARPENTER_ANTI_WAGON_BREAK
					&& wagon.getPlayer().getProfession()
							.equals(Profession.CARPENTER)) {
				return "Your wagon hits a bump that would have splintered a "
						+ "poorly made axle, but your carpentry skills save you... this time.";
			} else {
				// TODO make wagon fixing code more realistic
				String eventString = "Your wagon hits a bump and breaks down.\n";
				if (random.nextInt(100) < WAGON_FIX_RATE) {
					// 0-2 + 1 gives 1-3 which are the inventory slots for the
					// parts
					int partNeededToFix = random.nextInt(3) + 1;
					if (!wagon.getWagonInventory().hasItem(partNeededToFix)) {
						eventString += "You try to fix the wagon but you don't have the parts"
								+ " required to make the repairs. Without a working wagon you"
								+ " can't make it to Oregon... Game Over";
					} else {
						wagon.getWagonInventory()
								.removeItem(partNeededToFix, 1);
						String partUsed = Inventory
								.toString(partNeededToFix, 1);
						eventString += "You fix the wagon with " + partUsed;
					}
					return eventString;
				} else {
					eventString += "You attempt to fix your wagon, but it beyond repair... Game Over";
					return eventString;
				}
			}
		} else if (roll < (totalPercentage += WAGON_FIRE)) {
			int itemToLose = random.nextInt(7);
			// removeItem() should do that
			int amountStolen = random.nextInt(MAX_QUANTITY_STOLEN);
			if(itemToLose == Inventory.FOOD)
				amountStolen = random.nextInt(MAX_AMOUNT_OF_FOOD_SPOILED);
			//Can't lose Oxen as they are not inside the wagon
			if (wagon.getWagonInventory().hasItem(itemToLose)
					&& amountStolen > 0 && itemToLose!= Inventory.OXEN) {
				// Represents the actual amount of items you lose
				amountStolen = wagon.getWagonInventory().removeItem(itemToLose,
						amountStolen);
				return "There was a wagon fire and you lost "
						+ Inventory.toString(itemToLose, amountStolen);
			} else
				return "There was a wagon fire but you managed to put it out before anything became unsalvagable";
		} else if (roll < (totalPercentage += PITY_FOOD)) {
			int pityFood = random.nextInt(RAND_PITY_FOOD) + MIN_PITY_FOOD;
			pityFood = wagon.getWagonInventory().addFood(pityFood);
			return "Some hunters feel sorry for you and give you " + pityFood
					+ " pounds of meat.";
		}  // nothing happens
			return "Nothing exciting happens...";
	}
	/**
	 * Generates the random event variables for the current turn based
	 * on the player's profession.
	 * 
	 * @param wagon
	 * 				The player's wagon
	 */
	private static void generateVariables(Wagon wagon) {
		// TODO Auto-generated method stub
		Profession playerProf = wagon.getPlayer().getProfession();
		if (playerProf == Profession.BANKER) {
			THIEVES = 10;
			LOST = 10;
		} else if (playerProf == Profession.CARPENTER) {
			WAGON_BREAKS = 3;
			WAGON_FIRE = 3;
		} else if (playerProf == Profession.DOCTOR) {
			PERSON_SICK = 3;
			FOOD_SPOILS = 3;
		} else if (playerProf == Profession.FARMER) {
			OXEN_SICK = 2;
			OXEN_DEATH_RATE = 30;
			OXEN_HEALTHY = 8;
			FIND_FOOD = 10;
			FOOD_SPOILS = 3;
		} else if (playerProf == Profession.TEACHER) {
			LOST = 2;
		}
	}
}
