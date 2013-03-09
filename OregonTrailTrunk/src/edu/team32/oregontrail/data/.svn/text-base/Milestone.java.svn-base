package edu.team32.oregontrail.data;

import edu.team32.oregontrail.inventory.ShopInventory;
import edu.team32.oregontrail.enums.MilestoneType;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a milestone that the wagon will stop at.
 * 
 * @author Team 32
 * 
 */
public class Milestone implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 885795378826770064L;
	private MilestoneType type;
	private String name;
	private int milesFromStart;
	private boolean hasAlternativePath;
	private ShopInventory shopInventory = null;
	private int milesToMilestoneFromPrevious;
	private int riverDepth = 0;
	private boolean hasFerry = false;
	private ArrayList<NPC> npcs = new ArrayList<NPC>();

	/**
	 * Constructor for the milestone initializes the the fields to the inputed
	 * parameters.
	 * 
	 * @param name
	 *            The name of the milestone
	 * @param type
	 *            The type of milestone
	 * @param milesToMilestoneFromPrevious
	 *            Distance from the previous milestone
	 * @param milesFromStart
	 *            Distance from the start
	 */
	public Milestone(String name, MilestoneType type,
			int milesToMilestoneFromPrevious, int milesFromStart,
			int riverDepth, boolean hasFerry) {
		this.name = name;
		this.milesToMilestoneFromPrevious = milesToMilestoneFromPrevious;
		this.milesFromStart = milesFromStart;
		this.type = type;
		if (type == MilestoneType.FORT || type == MilestoneType.START_TOWN) {
			this.shopInventory = new ShopInventory(this.milesFromStart);
		} else if (type == MilestoneType.RIVER) {
			this.riverDepth = riverDepth;
			this.hasFerry = hasFerry;
		}

	}

	/**
	 * Initializes the milestone to the inputed parameters.
	 * 
	 * @param name
	 *            The name of the milestone
	 * @param type
	 *            The type of milestone
	 * @param milesToMilestoneFromPrevious
	 *            The number of miles from the previous milestone
	 * @param milesFromStart
	 *            The number of miles from the start
	 */
	public Milestone(String name, MilestoneType type,
			int milesToMilestoneFromPrevious, int milesFromStart) {
		this.name = name;
		this.milesToMilestoneFromPrevious = milesToMilestoneFromPrevious;
		this.milesFromStart = milesFromStart;
		this.type = type;
		if (type == MilestoneType.FORT || type == MilestoneType.START_TOWN) {
			this.shopInventory = new ShopInventory(this.milesFromStart);
		}
	}

	/**
	 * Initializes the milestone to the inputed parameters.
	 * 
	 * @param name
	 *            The name of the milestone
	 * @param type
	 *            The type of milestone
	 * @param milesToMilestoneFromPrevious
	 *            The number of miles from the previous milestone
	 * @param milesFromStart
	 *            The number of miles from the start
	 * @param hasAlternativePath
	 *            represents if the milestone has an alternate path
	 */
	public Milestone(String name, MilestoneType type,
			int milesToMilestoneFromPrevious, int milesFromStart,
			boolean hasAlternativePath) {
		this.name = name;
		this.milesToMilestoneFromPrevious = milesToMilestoneFromPrevious;
		this.milesFromStart = milesFromStart;
		this.type = type;
		this.hasAlternativePath = hasAlternativePath;
		if (type == MilestoneType.FORT || type == MilestoneType.START_TOWN) {
			this.shopInventory = new ShopInventory(this.milesFromStart);
		}
	}

	/**
	 * Default constructor for the milestone.
	 */
	public Milestone() {
	}

	/**
	 * Returns whether the milestone has an alternative path
	 * @return whether the milestone has an alternative path
	 */
	public boolean hasAlternativePath() {
		return hasAlternativePath;
	}

	/**
	 * Accesses the type of milestone.
	 * 
	 * @return The type of milestone
	 */
	public MilestoneType getType() {
		return type;
	}

	/**
	 * Initializes the type of milestone to the inputed parameter.
	 * 
	 * @param type
	 *            The new type of milestone
	 */
	public void setType(MilestoneType type) {
		this.type = type;
	}

	/**
	 * Accesses the number of miles that the milestone is from the start
	 * 
	 * @return The number of miles the milestone is from the start.
	 */
	public int getMilesFromStart() {
		return milesFromStart;
	}

	/**
	 * Initializes the number of miles from the start the milestone is to the
	 * inputed parameter.
	 * 
	 * @param milesFromStart
	 *            The number of miles from the start the milestone is
	 */
	public void setMilesFromStart(int milesFromStart) {
		this.milesFromStart = milesFromStart;
	}

	/**
	 * Accesses the shop inventory associated with the current milestone.
	 * 
	 * @return The shop's inventory
	 */
	public ShopInventory getShopInventory() {
		return shopInventory;
	}

	/**
	 * Initializes the shop's inventory associated with the current milestone to
	 * the inputed parameter.
	 * 
	 * @param shopInventory
	 *            The shop inventory for the milestone
	 */
	public void setShopInventory(ShopInventory shopInventory) {
		this.shopInventory = shopInventory;
	}

	/**
	 * Accesses the miles from the previous milestone the current milestone is.
	 * 
	 * @return The miles from the previous milestone
	 */
	public int getMilesToMilestoneFromPrevious() {
		return milesToMilestoneFromPrevious;
	}

	/**
	 * Initializes the miles from the previous milestone location to the inputed
	 * parameter.
	 * 
	 * @param milesToMilestoneFromPrevious
	 *            The miles from the previous milestone location
	 */
	public void setMilesToMilestoneFromPrevious(int milesToMilestoneFromPrevious) {
		this.milesToMilestoneFromPrevious = milesToMilestoneFromPrevious;
	}

	/**
	 * Accesses the list of NPCs associated with the current milestone.
	 * 
	 * @return The list of NPCs
	 */
	public ArrayList<NPC> getNpcs() {
		return npcs;
	}

	/**
	 * Initializes the list of NPCs for the current milestone to the inputed
	 * parameter.
	 * 
	 * @param npcs
	 *            The new list of NPCs for the milestone
	 */
	public void setNpcs(ArrayList<NPC> npcs) {
		this.npcs = npcs;
	}

	/**
	 * Accesses the name of the current milestone.
	 * 
	 * @return The String name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name property of a given milestone.
	 * 
	 * @param name
	 *            The new name for the milestone.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Tells whether a milestone has a ferry or not, only used for when the
	 * milestone is a river.
	 * 
	 * @return True if the milestone has a ferry, false otherwise
	 */
	public boolean hasFerry() {
		return hasFerry;
	}

	public int getRiverDepth() {
		return riverDepth;
	}

	public void setRiverDepth(int riverDepth) {
		this.riverDepth = riverDepth;
	}

}
