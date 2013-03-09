package edu.team32.oregontrail.enums;
/**
 * Represents the rations the user will distribute to himself
 * and his companions
 * 
 * @author Team 32
 *
 */
public enum Rations {
	/**
	 * There are no rations being distributed. Chances of 
	 * starvation are certain.
	 */
	NONE ("None", "You have a death wish, you will die very quickly now.", 0),
	/**
	 * There are only scraps being distributed. Chances of 
	 * starvation are very high.
	 */
	SCRAPS ("Scraps", "Why do you hate you and your friends?", 1),
	/**
	 * There are only meager rations being distributed. Chances of
	 * starvation are high.
	 */
	MEAGER ("Meager", "Oliver Twist would get more food per meal than you and your companions.", 2),
	/**
	 * There are average rations being distributed. Chances of starvation
	 * are small.
	 */
	AVERAGE ("Average", "Enough for every man.", 4),
	/**
	 * There are ample rations being distributed. Chances of starvation
	 * are zero. 
	 */
	FEAST ("Feast", "You will almost never get sick however your gluttony may come back to haunt you later on down the road.", 7);
	private String name;
	private String description;
	private int pounds;
	Rations(String name, String description, int pounds)
	{
		this.name = name;
		this.description = description;
		this.pounds = pounds;
	}
	public String toString()
	{
		return name;
	}
	public String getDescription()
	{
		return description;
	}
	public int getFoodConsumedPerTurn()
	{
		return pounds;
	}
	public String getFoodDescription()
	{
		return "You will consume " + pounds + " lbs of food per person per day.";
	}
	public static Rations parseString(String rations)
	{
		if(rations.equals(Rations.NONE.toString()))
		{
			return Rations.NONE;
		}
		else if(rations.equals(Rations.SCRAPS.toString()))
		{
			return Rations.SCRAPS;
		}
		else if(rations.equals(Rations.MEAGER.toString()))
		{
			return Rations.MEAGER;
		}
		else if(rations.equals(Rations.AVERAGE.toString()))
		{
			return Rations.AVERAGE;
		}
		else if(rations.equals(Rations.FEAST.toString()))
		{
			return Rations.FEAST;
		}
		return null;
	}
}
