package edu.team32.oregontrail.enums;
/**
 * Represents the pace of the wagon which the user will set.
 * 
 * @author Team 32
 *
 */
public enum Pace {
	/**
	 * Represents the pace where the wagon does not move.
	 */
	STOPPED ("Stopped", "You need to take a break, so why don't " +
			"you just wait here a bit, or forever.", 0),
	/**
	 * The wagon moves a very small amount.
	 */
	SLOW ("Slow", "Let's take it real slooowwwwww, try racing " +
			"that turtle near you, too bad you lost.", 3),
	/**
	 * The wagon moves an average amount.
	 */
	MODERATE ("Moderate", "Not too hot and not too cold, " +
			"Goldilocks would approve.", 6),
	/**
	 * The wagon moves at a grueling pace. Chances of
	 * wagon parts breaking are increased.
	 */
	EXHAUSTING ("Exhausting", "Faster than a speeding bullet," +
			" but not faster than death.", 9),
	/**
	 * The wagon moves ridiculously fast. Chances of
	 * wagon parts breaking are almost certain.
	 */
	LUDICROUS ("Ludicrous", "They've gone into plaid.", 100);
	/**
	 * The name of the Pace
	 */
	private final String name;
	/**
	 * The description of the pace
	 */
	private final String description;
	/**
	 * The number of miles traveled per pace
	 */
	private final int miles;

	private Pace(String name, String description, int miles){
		this.name = name;
		this.description = description;
		this.miles = miles;
	}
	
	/**
	 * Returns a toString of the pace
	 * @return a toString of the pace
	 */
	public String toString(){
		return name;
	}

	/**
	 * Returns a description of the pace
	 * @return a description of the pace
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * Returns the amount of miles that you move per turn
	 * @return the amount of miles that you move per turn
	 */
	public int getMilesMovedPerTurn(){
		return miles;
	}

	/**
	 * Returns a description of the amount of miles you move per turn
	 * @return a description of the amount of miles you move per turn
	 */
	public String getMilesDescription(){
		return "You will travel " + miles + " miles per day.";
	}
	
	/**
	 * Parses a string into the corresponding Pace
	 * @param pace A string of the pace
	 * @return The corresponding Pace
	 */
	public static Pace parseString(String pace){
		if(pace.equals(Pace.STOPPED.toString())){
			return Pace.STOPPED;
		}
		else if(pace.equals(Pace.SLOW.toString())){
			return Pace.SLOW;
		}
		else if(pace.equals(Pace.MODERATE.toString())){
			return Pace.MODERATE;
		}
		else if(pace.equals(Pace.EXHAUSTING.toString())){
			return Pace.EXHAUSTING;
		}
		else if(pace.equals(Pace.LUDICROUS.toString())){
			return Pace.LUDICROUS;
		}
		return null;
	}
	
}
