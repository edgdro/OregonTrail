package edu.team32.oregontrail.hunt.animal;

import javax.swing.ImageIcon;

public class Ox extends Animal {
	private static final int WEIGHT_MIN = 300;
	private static final int WEIGHT_MOD = 200;
	public Ox(int animalNumber) {
		super(animalNumber, new ImageIcon(Animal.class
				.getResource("/images/ox.gif")), Ox.WEIGHT_MIN, Ox.WEIGHT_MOD, true);
	}
}
