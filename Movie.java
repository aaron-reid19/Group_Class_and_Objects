package assignment1;

//	Assignment 1
//	Group 6
//	Oct. 05, 2025

//	Movie class constructs objects based on the variables: duration, title, and year.
//	Getters and toString are implemented based off of these variables.

public class Movie {
	// Data fields
	int duration;
	String title;
	int year;
	
	// Constructor
	public Movie(int duration, String title, int year) {
		super();
		this.duration = duration;
		this.title = title;
		this.year = year;
	}

	// Getters
	public int getDuration() {
		return duration;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	// toString() method
	@Override
	public String toString() {
		return duration + "," + title + "," + year;
	}
}

