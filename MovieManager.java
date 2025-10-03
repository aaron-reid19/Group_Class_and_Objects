package assignment1;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class MovieManager {
	static final Path FILE_PATH = Paths.get("src/res/movies.txt");
	static List<Movie> movies = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);
	static Random random = new Random();
	
	public static void loadMovieList() {
		// Validate file path
		if(!Files.exists(FILE_PATH)) {
			System.out.println("No movie file found");
			return;
		}
		
		// Load file, apply to Movie class, and add to movies list
		try {
			List<String> lines = Files.readAllLines(FILE_PATH);
			for (String line : lines) {
				String[] field = line.split(",");
				int duration = Integer.parseInt(field[0]);
				String name = field[1];
				int year = Integer.parseInt(field[2]);
				Movie movie = new Movie(duration, name, year);
				movies.add(movie);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static int displayMenu() {
		// Menu
		System.out.println("Movie Management System");
		System.out.println("1	Add New Movie and Save");
		System.out.println("2	Generate List of Movies Released in a Year");
		System.out.println("3	Generate List of Random Movies");
		System.out.println("4	Exit");
		
		// Menu selection input
		System.out.print("Enter an option: ");
		int input = Integer.parseInt(scanner.nextLine().trim());
		return input;
	}

	public static void addMovie() {
		// User inputs
		System.out.print("Enter duration: ");
		int duration = Integer.parseInt(scanner.nextLine().trim());
		System.out.print("Enter movie title: ");
		String name = scanner.nextLine().trim();
		System.out.print("Enter year: ");
		int year = Integer.parseInt(scanner.nextLine().trim());
		
		// Apply to Movie class, and add to movies list
		System.out.println("Saving movie...");
		Movie movie = new Movie(duration, name, year);
		movies.add(movie);
		saveMovieListToFile();
		System.out.println("Added movie to the data file.");
	}
	
	public static void generateMovieListInYear() {
		// User input
		System.out.print("Enter a year: ");
		int year = Integer.parseInt(scanner.nextLine().trim());
		
		// Print movies from year and total duration
		System.out.println("Movie List");
		System.out.println("Duration		Year	Title");
		int totalDuration = 0;
		for(Movie movie : movies) {
			if(movie.getYear()==year) {
				System.out.println(movie.getDuration() + "		" + movie.getYear() + "	" + movie.getTitle());
				totalDuration += movie.getDuration();
			}
		}
		System.out.println("Total duration: " + totalDuration + " minutes");
	}
	
	public static void generateRandomMovieList() {
		// User input
		System.out.print("Enter number of movies: ");
		int number = Integer.parseInt(scanner.nextLine().trim());
		
		// Print number of random movies and total duration
		System.out.println("Movie List");
		System.out.println("Duration		Year	Title");
		int totalDuration = 0;
		for(int i=1; i <= number; i++) {
			int randomInt = random.nextInt(movies.size());
			Movie movie = movies.get(randomInt);
			System.out.println(movie.getDuration() + "		" + movie.getYear() + "	" + movie.getTitle());
			totalDuration += movie.getDuration();
		}
		System.out.println("Total duration: " + totalDuration + " minutes");
	}
	
	public static void saveMovieListToFile() {
		try {
			List<String> saveMovies = new ArrayList<>();
			for(Movie movie : movies) {
				String line = movie.toString();
				saveMovies.add(line);
			}
			Files.write(FILE_PATH, saveMovies, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
