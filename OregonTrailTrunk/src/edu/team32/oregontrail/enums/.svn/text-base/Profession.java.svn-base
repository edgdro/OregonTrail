package edu.team32.oregontrail.enums;

import java.io.Serializable;

/**
 * Represents a player's profession.
 * 
 * @author Team 32
 * 
 */
public enum Profession implements Serializable {

	BANKER("Banker", 1600, 1), DOCTOR("Doctor", 1300, 1.25), CARPENTER(
			"Carpenter", 1000, 1.5), FARMER("Farmer", 700, 1.75), TEACHER(
			"Teacher", 400, 3);

	private int startingMoney;
	private String name;
	private double scoreModifier;

	/**
	 * Initializes the profession to the inputed parameters.
	 * 
	 * @param name
	 *            The name of the profession
	 * @param startingMoney
	 *            The profession's starting money
	 * @param scoreModifier
	 *            The profession's score modifier
	 */
	private Profession(String name, int startingMoney, double scoreModifier) {
		this.name = name;
		this.startingMoney = startingMoney;
		this.scoreModifier = scoreModifier;
	}

	public double scoreModifier() {
		return scoreModifier;
	}

	public String toString() {
		return name;
	}

	public int startingMoney() {
		return startingMoney;
	}

	/**
	 * Determines the player's profession based on its string representation.
	 * 
	 * @param profession
	 *            The profession
	 * 
	 * @return The player's profession
	 */
	public static Profession parseString(String profession) {
		if (profession.equals(Profession.BANKER.toString())) {
			return Profession.BANKER;
		} else if (profession.equals(Profession.DOCTOR.toString())) {
			return Profession.DOCTOR;
		} else if (profession.equals(Profession.CARPENTER.toString())) {
			return Profession.CARPENTER;
		} else if (profession.equals(Profession.FARMER.toString())) {
			return Profession.FARMER;
		} else if (profession.equals(Profession.TEACHER.toString())) {
			return Profession.TEACHER;
		}
		return null;
	}
}
