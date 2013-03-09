package edu.team32.oregontrail.enums;

public enum CrossingType {
	HELP(
			"There is a nearby ferry you and your wagon can take to safely cross the " +
			"river, this will guarantee safe passage, however, it costs $10"), CAULK(
			"You will try to caulk your wagon and attempt to float across the river, " +
			"there is a high chance that your wagon will flip over and " +
			"you may lose items."), 
			FORD("You will try to ford across the river, " +
			"however, if the river is too deep" +
			" there is a high chance that your " +
			"wagon will flip over and you may lose items.");

	private final String description;

	/**
	 * The constructor for the crossing type
	 * @param description The description for each type
	 */
	private CrossingType(String description) {
		this.description = description;
	}

	/**
	 * Returns the description of the choice
	 * @return the description of the choice
	 */
	public String getDescription() {
		return description;
	}
}
