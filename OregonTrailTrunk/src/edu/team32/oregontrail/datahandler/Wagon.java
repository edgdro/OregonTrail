package edu.team32.oregontrail.datahandler;

import java.io.Serializable;
import java.util.Random;
import java.util.Stack;

import edu.team32.oregontrail.data.*;
import edu.team32.oregontrail.events.*;
import edu.team32.oregontrail.inventory.Inventory;
import edu.team32.oregontrail.inventory.WagonInventory;
import edu.team32.oregontrail.enums.*;

/**
 * Represents the wagon for the current game.
 * 
 * @author Team 32
 * 
 */
public class Wagon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4884074959155984395L;
	private WagonInventory wagonInventory = null;
	private Pace pace;
	private Rations rations;
	private Stack<Status> oxenStatus = new Stack<Status>();
	private Companion[] companions;
	private int daysExhausting = 0;
	private int daysScraps = 0;
	public final int MAX_COMPANIONS = 4;
	private Player player;
	private boolean atMilestone;
	private final int PARTY_TIRED = 16;
	private final int PARTY_HUNGRY = 17;
	private final int PARTY_WELL_RESTED = 18;
	private final int PARTY_WELLFED = 19;
	private final int SICK_OFFSET = 6;
	private final int HEALTHY_OFFSET = 11;
	public static final int MIN_OXEN = 2;
	private Random r = new Random();
	private static final Wagon WAGON_SINGLETON = new Wagon();

	/**
	 * This is a default constructor that creates a wagon and fills it with
	 * bogus data. It will all be written over before the user ever has a chance
	 * to see it.
	 */
	private Wagon() {
		oxenStatus.push(Status.HEALTHY);
		pace = Pace.MODERATE;
		rations = Rations.MEAGER;
		companions = new Companion[MAX_COMPANIONS];
		player = new Player("", Profession.BANKER); // Place holder
		atMilestone = true;
	}
	
	public static Wagon getInstance(){
		return WAGON_SINGLETON;
	}

	/**
	 * Initializes the Wagon given the name of companions, the player and the
	 * initial wagonInventory
	 * 
	 * @param companions
	 *            The names of the four companions to be tagging along with you
	 * @param player
	 *            The name and profession of the main player
	 * @param wagonInventory
	 *            The initial inventory of the player.
	 */
	public Wagon(Companion[] companions, Player player,
			WagonInventory wagonInventory) {
		if (companions.length == MAX_COMPANIONS) {
			this.companions = companions;
		}
		this.player = player;
		this.wagonInventory = wagonInventory;
		initializeWagonInventory();
		atMilestone = true;
	}

	/**
	 * Initializes the wagon's inventory based on the player's profession.
	 */
	private void initializeWagonInventory() {
		wagonInventory = new WagonInventory(player.getProfession()
				.startingMoney());
	}

	public void shop() {

	}

	public WagonInventory getWagonInventory() {
		return wagonInventory;
	}

	public void setWagonInventory(WagonInventory wagonInventory) {
		this.wagonInventory = wagonInventory;
	}

	/**
	 * Returns the pace currently being used
	 * 
	 * @return The pace currently being used
	 */
	public Pace getPace() {
		return pace;
	}

	/**
	 * Sets the pace type to be used
	 * 
	 * @param pace
	 *            The pace type to be used
	 */
	public void setPace(Pace pace) {
		this.pace = pace;
	}

	/**
	 * Returns the ration currently being used
	 * 
	 * @return The ration currently being used
	 */
	public Rations getRations() {
		return rations;
	}

	/**
	 * Sets the ration type to be used
	 * 
	 * @param rations
	 *            The ration type to be used
	 */
	public void setRations(Rations rations) {
		this.rations = rations;
	}



	/**
	 * Accesses the status of the wagon's oxen.
	 * 
	 * @return The oxen's status
	 */
	public boolean hasOxenStatus(Status oxenStatus) {
		return this.oxenStatus.contains(oxenStatus);
	}

	/**
	 * Initializes the status of the wagon's oxen to the inputed parameter.
	 * 
	 * @param oxenStatus
	 *            The new status for the oxen
	 */
	public void setOxenStatus(Status oxenStatus) {
		if (oxenStatus.equals(Status.HEALTHY)) {
			this.oxenStatus.clear();
			this.oxenStatus.push(oxenStatus);
		} else if (!this.oxenStatus.contains(oxenStatus)) {
			this.oxenStatus.push(oxenStatus);
		}
	}

	/**
	 * Accesses the list of companions associated with the wagon.
	 * 
	 * @return The list of the wagon's companions
	 */
	public Companion[] getCompanions() {
		return companions;
	}

	/**
	 * Initializes the list of the companions associated with the wagon to the
	 * inputed parameter.
	 * 
	 * @param companions
	 *            The new list of companions for the wagon
	 */
	public void setCompanions(Companion[] companions) {
		this.companions = companions;
	}

	/**
	 * Accesses the main player associated with the wagon.
	 * 
	 * @return The player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Initializes the main player associated with the wagon to the inputed
	 * parameter.
	 * 
	 * @param player
	 *            The new player to be associated with the wagon
	 */
	public void setPlayer(Player player) {
		this.player = player;
		initializeWagonInventory();
	}

	/**
	 * Accesses the current total weight of the wagon.
	 * 
	 * @return The total weight of the wagon
	 */
	public int getWeight() {
		return this.wagonInventory.getWeight();
	}

	// Maybe return the String of what happens on the event?
	/**
	 * Represents and simulates a day for the wagon. This is called for every
	 * turn taken in the game.
	 * 
	 * @return A string representing the day's events
	 */
	public String simulateDay() {
		String event;
		if (Map.getInstance().getCurrentMilestone().getMilesFromStart() == 0 && atMilestone) {
			event = "Leaving Independence... there is no turning back...";
			atMilestone = false;
			// Just to avoid having it say "Arriving at Independence when you
			// start
		} else if (Map.getInstance().travel(pace, oxenStatus)) { // if true then we arrived in
													// a town
			atMilestone = true;
			// getNetMilestone()-1 because we want the current, not next
			// milestone
			event = "Arriving at " + Map.getInstance().getCurrentMilestone().getName();
		} else { // only random event if not entering a town
			atMilestone = false;
			event = RandomEvent.rollEvent(this);
		}
		int vitalCheck = checkVitals();
		printStatus();
		// Returns whether the companion/player has died
		System.out.println("vitalCheck " + vitalCheck);
		if (vitalCheck > 1 && vitalCheck <= 6 && getLivingPlayers() > 0) {
			return companions[vitalCheck - 2].getName() + " has died.\n";
		}

		// Returns whether the companion/player has gotten sick
		if (vitalCheck > (SICK_OFFSET) && vitalCheck <= (SICK_OFFSET + 4)) {
			return companions[vitalCheck - SICK_OFFSET - 1].getName()
					+ " has become sick.\n";
		}

		// Returns whether the companion/player has gotten better
		if (vitalCheck > (HEALTHY_OFFSET) && vitalCheck <= (HEALTHY_OFFSET + 4)) {
			return companions[vitalCheck - HEALTHY_OFFSET - 1].getName()
					+ " condition has improved.\n";
		}
		if (vitalCheck == PARTY_HUNGRY) {
			event += "\nAfter days of not eating enough your entire party feels the effects\n";
		} else if (vitalCheck == PARTY_TIRED) {
			event += "\nAfter days of moving at ridiculous speeds your entire party feels the effects, you will also experience a slowdown of 1-3 miles each day.\n";
		} else if (vitalCheck == PARTY_WELL_RESTED) {
			event += "\nYour entire party and oxen now feels better after having slown down for a while to rest.\n";
		} else if (vitalCheck == PARTY_WELLFED) {
			event += "\nAfter days of eating enough your entire party no longer feels hungry.\n";
		}
		if (getLivingPlayers() == 0) {
			return "You and everybody in your party are now dead. Game Over";
		} else if (player.isDead()) {
			return "The player is dead, without a leader all your companions will now die. Game Over";
		}
		// simulate wagon members eating food
		String noFood = wagonInventory.eatFood(getLivingPlayers(), rations);
		setProperRations();
		// moves the wagon
		if (noFood.length() > 1) {
			noFood += "\n";
		}
		if (!getWagonInventory().hasItem(Inventory.OXEN))
			return "You have no more oxen and are now stuck and will eventually die. Game Over";
		return noFood + event + "\n"; // puts each event on new line in GUI
	}

	/**
	 * Determines if the wagon is currently at a milestone.
	 * 
	 * @return true if the wagon is at a milestone, false otherwise
	 */
	public boolean isAtMilestone() {
		return atMilestone;
	}

	/**
	 * Initializes the atMilestone field to the inputed parameter.
	 * 
	 * @param atMilestone
	 *            boolean representing whether the wagon is at a milestone
	 */
	public void setAtMilestone(boolean atMilestone) {
		this.atMilestone = atMilestone;
	}

	/**
	 * Determines the health of everyone in the wagon and returns a given number
	 * representing the result.
	 * 
	 * @return An integer representing the health of the wagon's party
	 */
	private int checkVitals() {
		// Returns 0 for no one died, 1 for player, 2 for first companion, 3 for
		// second
		// Returns 6 for player got sick, 7 for first companion, 8 for second,
		// 9, 10
		// Returns 11 for player got better, 12 for first companion, 13, 14, 15
		// Returns 16 for Tired
		// Returns 17 for Hungry
		// Returns 18 for WellFed
		// Returns 19 for WellRested
		// second, etc
		int toReturn = 0;
		boolean gotSick = false;
		boolean gotBetter = false;

		// Stops multiple people from dying in same turn
		// If no food players slow wither until dead

		// Players become tired after 10 days of ludicrous speed
		if (pace == Pace.LUDICROUS) {
			daysExhausting++;
			daysExhausting++;
			if (daysExhausting > 10) {
				daysExhausting = 10;
			}
		} else if (pace == Pace.EXHAUSTING) {
			daysExhausting++;
			if (daysExhausting > 10) {
				daysExhausting = 10;
			}
		} else if (pace == Pace.STOPPED) {
			daysExhausting--;
			daysExhausting--;
			daysExhausting--;
			daysExhausting--;
			if (daysExhausting < 0) {
				daysExhausting = 0;
			}
		} else if (pace == Pace.SLOW) {
			daysExhausting--;
			daysExhausting--;
			if (daysExhausting < 0) {
				daysExhausting = 0;
			}

		} else if (pace == Pace.MODERATE) {
			daysExhausting--;
			if (daysExhausting < 0) {
				daysExhausting = 0;
			}
		}
		// Players become hungry after 10 days of scraps
		if (rations == Rations.SCRAPS) {
			if (daysScraps < 10)
				daysScraps++;
		} else if (rations != Rations.NONE) {
			if (daysScraps > 0)
				daysScraps--;
		}
		if (!getWagonInventory().hasItem(Inventory.FOOD)
				|| rations.equals(Rations.NONE)) {
			if (!player.isDead()) {
				gotSick = player.canRemoveVitals(r.nextInt(5) + 5);
				if (player.isDead()) {
					return 1;
				}
				if (gotSick) {
					// Player got Sick
					return SICK_OFFSET;
				}
			}
			int companionNum = 2;
			for (Companion companion : companions) {
				if (!companion.isDead()) {
					gotSick = companion.canRemoveVitals(r.nextInt(5) + 5);
					if (companion.isDead()) {
						return companionNum;
					}
					if (gotSick) {
						// Companion got Sick
						return companionNum + SICK_OFFSET - 1;
					}
				}
				companionNum++;
			}
		}
		// If rations set to Feast then players vitality increases by 5 to 10
		// each
		// turn
		else if (rations == Rations.FEAST) {
			gotBetter = player.canAddVitals(r.nextInt(5) + 5);
			if (gotBetter) {
				return HEALTHY_OFFSET;
			}
			int companionNum = 2;
			for (Companion companion : companions) {
				gotBetter = companion.canAddVitals(r.nextInt(5) + 5);
				if (gotBetter) {
					return companionNum + HEALTHY_OFFSET;
				}
				companionNum++;
			}
		}
		// If rations set to Average then players vitality increases by 1 to 4
		// each
		// turn
		else if (rations == Rations.AVERAGE) {
			player.canAddVitals(r.nextInt(4) + 1);
			for (Companion companion : companions) {
				companion.canAddVitals(r.nextInt(4) + 1);
			}
		} else if (rations == Rations.MEAGER) {
			if (player.getVitals() < 50) {
				player.canAddVitals(r.nextInt(4) + 1);
			}
			for (Companion companion : companions) {
				if (companion.getVitals() < 50) {
					companion.canAddVitals(r.nextInt(4) + 1);
				}
			}
		}

		// Checks whether to make user tired or hungry
		if (daysExhausting >= 10) {
			player.canAddStatus(Status.TIRED);
			if (!oxenStatus.contains(Status.TIRED))
				oxenStatus.push(Status.TIRED);
			for (Companion companion : companions) {
				boolean notAlreadyTired = companion.canAddStatus(Status.TIRED);
				if (notAlreadyTired) {
					System.out.println("TIRED");
					toReturn = PARTY_TIRED;
				}
			}
		} else if (daysExhausting <= 5) {
			player.canRemoveStatus(Status.TIRED);
			oxenStatus.remove(Status.TIRED);
			for (Companion companion : companions) {
				boolean notAlreadyWellRested = companion
						.canRemoveStatus(Status.TIRED);
				if (notAlreadyWellRested) {
					toReturn = PARTY_WELL_RESTED;
				}
			}
		}
		System.out.println("DaysLudicrious " + daysExhausting);
		if (daysScraps >= 10) {
			player.canAddStatus(Status.HUNGRY);
			for (Companion companion : companions) {
				boolean notAlreadyHungry = companion
						.canAddStatus(Status.HUNGRY);
				if (notAlreadyHungry) {
					toReturn = PARTY_HUNGRY;
				}
			}
		} else if (daysScraps <= 5) {
			player.canRemoveStatus(Status.HUNGRY);
			for (Companion companion : companions) {
				boolean notAlreadyWellfed = companion
						.canRemoveStatus(Status.HUNGRY);
				if (notAlreadyWellfed) {
					toReturn = PARTY_WELLFED;
				}
			}
		}
		return toReturn;
	}

	/**
	 * Based on certain conditions within the game, this checks to see if the
	 * player has enough food to set the rations.
	 */
	public void setProperRations() {
		// Checks for each rations type
		for (int x = 0; x < 5; x++)
			if ((getLivingPlayers() * wagonInventory.getPoundsFood()) < (rations
					.getFoodConsumedPerTurn() * getLivingPlayers())) {
				if (rations == Rations.FEAST) {
					rations = Rations.AVERAGE;
				} else if (rations == Rations.AVERAGE) {
					rations = Rations.MEAGER;
				} else if (rations == Rations.MEAGER) {
					rations = Rations.SCRAPS;
				} else if (rations == Rations.SCRAPS) {
					rations = Rations.NONE;
				}
			}
		if ((getLivingPlayers() * wagonInventory.getPoundsFood()) >= (Rations.MEAGER
				.getFoodConsumedPerTurn() * getLivingPlayers())
				&& rations.equals(Rations.NONE)) {
			rations = Rations.MEAGER;
		}
	}

	/**
	 * Determines the number of living players in the wagon.
	 * 
	 * @return The number of living players
	 */
	public int getLivingPlayers() {
		int livingPlayers = 0;
		if (!player.isDead())
			livingPlayers++;
		for (Companion companion : companions) {
			if (!companion.isDead())
				livingPlayers++;
		}
		return livingPlayers;
	}

	// TODO remove after testing
	public void printStatus() {
		System.out.println(player.tempToString());
		for (int x = 0; x < companions.length; x++) {
			System.out.println(companions[x].tempToString());
		}
	}

	public int addPoundsShot(int pounds) {
		int poundsReturned = 0;
		if (pounds <= WagonInventory.MAX_CARRY_BACK_WEIGHT) {
			if ((pounds + getWagonInventory().getWeight()) < WagonInventory.MAX_WEIGHT) {

				poundsReturned = pounds;
			} else {
				poundsReturned = WagonInventory.MAX_WEIGHT
						- getWagonInventory().getWeight();
			}
		} else if (pounds > WagonInventory.MAX_CARRY_BACK_WEIGHT) {
			if ((WagonInventory.MAX_CARRY_BACK_WEIGHT + getWagonInventory()
					.getWeight()) <= WagonInventory.MAX_WEIGHT) {
				poundsReturned = WagonInventory.MAX_CARRY_BACK_WEIGHT;
			} else {
				poundsReturned = WagonInventory.MAX_WEIGHT
						- getWagonInventory().getWeight();
			}
		}
		getWagonInventory().addFood(poundsReturned);
		return poundsReturned;
	}
}
