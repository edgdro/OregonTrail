package edu.team32.oregontrail.hunt.animal;

import javax.swing.ImageIcon;

public class Squirrel extends Animal{

	private static final int WEIGHT_MIN = 10;
	private static final int WEIGHT_MOD = 7;
	public Squirrel(int animalNumber) {
		super(animalNumber, new ImageIcon(Animal.class
				.getResource("/images/squirrelResize.jpg")), Squirrel.WEIGHT_MIN, Squirrel.WEIGHT_MOD, false);
	}
}
