package assignment1;

//	Assignment 1
//	Group 6
//	Oct. 05, 2025

//	Driver class executes the methods from MovieManager class based on user input.

public class Driver {

	public static void main(String[] args) {
		// Load movies from file
		MovieManager.loadMovieList();
		
		// User interaction
		boolean run = true;
		while(run == true) {
			int input = MovieManager.displayMenu();
			switch(input) {
			case 1:
				MovieManager.addMovie();
				break;
			case 2:
				MovieManager.generateMovieListInYear();
				break;
			case 3:
				MovieManager.generateRandomMovieList();
				break;
			case 4:
				run = false;
				break;
			default:
				System.out.println("Invalid option!");
			}
		}
	}
}

