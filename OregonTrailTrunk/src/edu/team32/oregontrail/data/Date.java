package edu.team32.oregontrail.data;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Represents the date in the current game.
 * 
 * @author Team 32
 *
 */
public class Date implements Serializable{
	/**	 * 
	 */
	private static final long serialVersionUID = 1390230804700182271L;

	private int month = 0;

	private int day = 0;

	private int year = 0;

	private static final int STARTING_YEAR = 1848;
	
	private static final int OFFSET = 1;
	
	private static final int START_DAY = 1;
	
	private static final int DAY_THIRTY_ONE = 31;
	
	private static final int DAY_THIRTY = 30;
	
	private static final int DAY_TWENTY_EIGHT = 28;
	/**
	 * Initializes the date to the inputed parameter.
	 * 
	 * @param month
	 * 			The current month
	 */
	public Date(int month) {
		this.month = month;
		year = STARTING_YEAR;
		day = START_DAY;
	}
	
	/**
	 * Initializes the date to the inputed parameter.
	 * 
	 * @param month
	 * 			The current month
	 * @param day
	 * 			The current day
	 * @param year
	 * 			The current year
	 */
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}

	/**
	 * Accesses the month associated with the current date.
	 * 
	 * @return The current month
	 */
	public int getMonth() {
		return month;
	} 

	/**
	 * Accesses the day associated with the current date.
	 * 
	 * @return The current day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Accesses the year associated with the current date.
	 * 
	 * @return The current year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Changes the date to the next day based how many days
	 * there are in each month.
	 */
	public void nextDay() {
		// Months with 31 days 1, 3, 5, 7,8,10,12
		switch (day) {
		case DAY_TWENTY_EIGHT:
			if (month == (Calendar.FEBRUARY+OFFSET)) {
				day = START_DAY;
				month++;
			}
			else day++;
			break;
		case DAY_THIRTY:
			if (month == (Calendar.APRIL+OFFSET) || month == (Calendar.JUNE+OFFSET) || month == (Calendar.SEPTEMBER+OFFSET) || month == (Calendar.NOVEMBER+OFFSET)) {
				day = START_DAY;
				month++;
			}
			else day++;
			break;
		case DAY_THIRTY_ONE:
			if (month == (Calendar.DECEMBER+OFFSET)) {
				month = (Calendar.JANUARY+OFFSET);
				day = START_DAY;
				year++;
			} 
			else if (month == (Calendar.JANUARY+OFFSET) || month == (Calendar.MARCH+OFFSET) || month == (Calendar.MAY+OFFSET) || month == (Calendar.JULY+OFFSET)
					|| month == (Calendar.AUGUST+OFFSET) || month == (Calendar.OCTOBER+OFFSET)) {
				day = START_DAY;
				month++;
			}
			else day++;
			break;
		default: day++;
		}
	}

	/**
	 * String representation of the current date.
	 * 
	 * @return The current date as a String
	 */
	@Override
	public String toString() {
		return Integer.toString(month) + "/" + Integer.toString(day) + 
				"/" + Integer.toString(year);
	}
}