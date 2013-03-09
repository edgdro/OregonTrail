package edu.team32.oregontrail.data;

import edu.team32.oregontrail.interfaces.Logic;
import edu.team32.oregontrail.windows.TitlePanel;
import edu.team32.oregontrail.datahandler.Wagon;
import edu.team32.oregontrail.enums.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import javax.swing.ImageIcon;
/**
 * This class represents the map for the game.
 * 
 * @author Team 32
 *
 */
public class Map implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8102228394055407756L;
	private List<Milestone> milestones;
	private int milesTraveled;
	private int nextMilestone;
	private int currentMilestone;
	private String currentLocation;
	private int milesToNextMilestone;
	private boolean pathNotTaken = true;
	private boolean takeAlternativePath = false;
	private final int fortBridgerDifference = 125;
	private final String TRAVELLING = "Travelling...";
	public static final int NO_SHOP = 0;
	public static final int IN_MOTION = 1;
	public static final int SHOP_EXISTS = 2;
	
	public final int ON_ROAD = 0;
	public final int AT_MILESTONE = 1;
	public final int AT_BRANCH = 2;
	private static final Map MAP_SINGLETON = new Map();
	
	/**
	 * Default constructor for the map.
	 */
	private Map() {
		milestones = new ArrayList<Milestone>();
		generateMilestones();
		milesTraveled = 0;
		nextMilestone = 1;
		milesToNextMilestone = milestones.get(nextMilestone).getMilesToMilestoneFromPrevious();
		currentMilestone = 0;
		currentLocation = milestones.get(currentMilestone).getName();
	}
	
	public static Map getInstance(){
		return MAP_SINGLETON;
	}
	
	/**
	 * This method adds several milestones to the list of milestones that the
	 * map contains. The information about each milestone is listed in the
	 * parameters.
	 */
	private void generateMilestones() {
		Random random = new Random();
		milestones.add(new Milestone("Independence",MilestoneType.START_TOWN, 0,0));
		int riverHeight = random.nextInt(5) + 6;
		milestones.add(new Milestone("Kansas River", MilestoneType.RIVER,102,102,riverHeight,true));
		riverHeight = random.nextInt(3) + 2;
		milestones.add(new Milestone("Big Blue", MilestoneType.RIVER,83,185,riverHeight,false));
		milestones.add(new Milestone("Fort Kearny", MilestoneType.FORT,119,304));
		milestones.add(new Milestone("Chimney Rock", MilestoneType.LANDMARK,250,554));
		milestones.add(new Milestone("Fort Laramie", MilestoneType.FORT,86,640));
		milestones.add(new Milestone("Independence Rock", MilestoneType.LANDMARK,190,830));
		milestones.add(new Milestone("South Pass", MilestoneType.LANDMARK,102,934,true));
		//Fort Bridger is a detour you can take
		milestones.add(new Milestone("Fort Bridger", MilestoneType.FORT,125,1059));
		//Extra Credit south route, not sure how to do this yet
		milestones.add(new Milestone("Soda Springs", MilestoneType.LANDMARK,162,1096));
		milestones.add(new Milestone("Fort Hall", MilestoneType.FORT,57,1153));
		riverHeight = random.nextInt(5) + 4;
		milestones.add(new Milestone("Snake River", MilestoneType.RIVER,182,1330,riverHeight,false));
		milestones.add(new Milestone("Fort Boise", MilestoneType.FORT,114,1444));
		milestones.add(new Milestone("Blue Mountains", MilestoneType.LANDMARK,162,1606));
		milestones.add(new Milestone("Fort Walla Walla", MilestoneType.FORT,55,1661));
		milestones.add(new Milestone("Dalles", MilestoneType.LANDMARK,120,1781));
		//temporary final milestone
		milestones.add(new Milestone("Oregon", MilestoneType.OREGON,100,1881));
		//Float Columbia River
		//Barlow Toll Road
		//Extra Cred
	}
	
	/**
	 * Moves the wagon a certain number of miles based on the current
	 * pace.
	 * 
	 * @param p
	 * 		the wagon's current pace
	 * 
	 * @return true if the wagon reaches a milestone, false otherwise
	 */
	public boolean travel(Pace p, Stack<Status> oxenStatus) {
		Random random = new Random();
		//If oxen are tired you will lose 1-3 miles per day
		int slowdown = (oxenStatus.contains(Status.TIRED) ? (random.nextInt(2)+1) : 0);
		if(p.equals(Pace.STOPPED))
				slowdown = 0;
		milesTraveled += (p.getMilesMovedPerTurn() - slowdown);
		milesToNextMilestone-=(p.getMilesMovedPerTurn() - slowdown);
		//if arrived at next milestone
		if(milesToNextMilestone <= 0) {
			//if stopped before a full days travel, only add the partial miles to total distance
			if(milestones.get(currentMilestone).hasAlternativePath() && this.takeAlternativePath && pathNotTaken)
			{
				alternatePathTaken();
				pathNotTaken = false;
			}
			if(milestones.get(currentMilestone).hasAlternativePath() && !this.takeAlternativePath && pathNotTaken)
			{
				currentMilestone++;
				currentMilestone++;
				nextMilestone++;
				nextMilestone++;
				pathNotTaken = false;
			}
			else
			{
			currentMilestone++;
			nextMilestone++;
			}

			currentLocation = milestones.get(currentMilestone).getName();
			milesTraveled += milesToNextMilestone;
			if(!(milestones.get(currentMilestone).getType() == MilestoneType.OREGON))
			milesToNextMilestone = milestones.get(nextMilestone).getMilesToMilestoneFromPrevious();
			return true;
		}
		currentLocation = TRAVELLING;
		return false; //didn't reach another milestone, keep on keepin on...
	}
	
	/**
	 * Changes the miles from start for each of the milestones if the alternate path is taken
	 */
	public void alternatePathTaken()
	{
		milestones.get(9).setMilesFromStart(milestones.get(9).getMilesFromStart() + fortBridgerDifference);
		milestones.get(10).setMilesFromStart(milestones.get(10).getMilesFromStart() + fortBridgerDifference);
		milestones.get(11).setMilesFromStart(milestones.get(11).getMilesFromStart() + fortBridgerDifference);
		milestones.get(12).setMilesFromStart(milestones.get(12).getMilesFromStart() + fortBridgerDifference);
		milestones.get(13).setMilesFromStart(milestones.get(13).getMilesFromStart() + fortBridgerDifference);
		milestones.get(14).setMilesFromStart(milestones.get(14).getMilesFromStart() + fortBridgerDifference);
		milestones.get(15).setMilesFromStart(milestones.get(15).getMilesFromStart() + fortBridgerDifference);
		milestones.get(16).setMilesFromStart(milestones.get(16).getMilesFromStart() + fortBridgerDifference);

	}
	
	/**
	 * Returns a specific milestone at a specific location.
	 * 
	 * @param index
	 * 			The index of the milestone in the list
	 * 
	 * @return The corresponding milestone
	 */
	public Milestone getMilestone(int index) {
		return milestones.get(index);
	}
	/**
	 * Accesses the current milestone.
	 * 
	 * @return The current milestone
	 */
	public Milestone getCurrentMilestone()
	{
		return milestones.get(currentMilestone);
	}
	
	public int getCurrentMilestoneIndex()
	{
		return currentMilestone;
	}
	/**
	 * Accesses the list of milestones.
	 * 
	 * @return The list of milestones
	 */
	public List<Milestone> getMilestones() {
		return milestones;
	}
	/**
	 * Initializes the list of milestones to the inputed parameters.
	 * 
	 * @param milestones
	 * 			The new list of milestones
	 */
	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}
	/**
	 * Accesses the distance traveled by the wagon.
	 * 
	 * @return The amount of miles traveled
	 */
	public int getMilesTraveled() {
		return milesTraveled;
	}
	/**
	 * Initializes the current location to the inputed parameter.
	 * 
	 * @param currentLocation
	 * 				The new current location
	 */
	private void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	/**
	 * Accesses the current location of the wagon.
	 * 
	 * @return The wagon's current location
	 */
	public String getCurrentLocation() {
		return currentLocation;
	}
	/**
	 * Initializes the miles travled to the inputed parameter.
	 * 
	 * @param milesTraveled
	 * 				The miles traveled
	 */
	public void setMilesTraveled(int milesTraveled) {
		this.milesTraveled = milesTraveled;
	}
	/**
	 * Accesses the next milestone based on where the wagon currently is.
	 * 
	 * @return The next milestone
	 */
	public int getNextMilestone() {
		return nextMilestone;
	}
	/**
	 * Initializes the next milestone to the inputed parameter.
	 * 
	 * @param nextMilestone
	 * 				The new next milestone
	 */
	public void setNextMilestone(int nextMilestone) {
		this.nextMilestone = nextMilestone;
	}
	/**
	 * Accesses the number of miles to the next milestone.
	 * 
	 * @return The number of miles to the next milestone
	 */
	public int getMilesToNextMilestone() {
		return milesToNextMilestone;
	}
	/**
	 * Checks to see if the wagon is currently moving
	 * 
	 * @return true if the wagon is moving, false otherwise
	 */
	public boolean isInMotion()
	{
		if(currentLocation.equals(TRAVELLING)) {
			return true;
		}
		return false;
	}
	/**
	 * Initializes the miles to the next milestone to the inputed
	 * parameter.
	 * 
	 * @param milesToNextMilestone
	 * 				distance to the next milestone
	 */
	public void setMilesToNextMilestone(int milesToNextMilestone) {
		this.milesToNextMilestone = milesToNextMilestone;
	}
	
	public boolean setAlternativePath(boolean takeAlternativePath){
		return this.takeAlternativePath = takeAlternativePath;
	}
	
	public ImageIcon getImage()
	{
		if(currentLocation.equals(TRAVELLING))
		{
			return new ImageIcon(Map.class.getResource("/images/TrailResize.jpg"));
		}
		switch(milestones.get(currentMilestone).getType())
		{
		case FORT: return new ImageIcon(Map.class.getResource("/images/StoreResize.jpg"));
		case START_TOWN: return new ImageIcon(Map.class.getResource("/images/StoreResize.jpg"));
		case RIVER:  return new ImageIcon(Map.class.getResource("/images/River.jpg"));
		case LANDMARK: return new ImageIcon(Map.class.getResource("/images/LandmarkResize.jpg"));
		default: return new ImageIcon(Map.class.getResource("/images/LandmarkResize.jpg"));
		}
	}
	
}
