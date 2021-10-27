package oodesign.movie.reader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 1. Welcome the guest and tell the user which functions we have(coordinate with User Interface)
 * 2. When user made a selection, receive the input, search, return the result they want(coordinate with Search Services
 */
public class UserInterface {
    HashMap<Integer, Movie> mapOfMovies = new HashMap<Integer, Movie>();
    SearchServices search;

    public UserInterface(HashMap<Integer, Movie> mapForMovies) {
        this.mapOfMovies = mapForMovies;
        search = new SearchServices(mapOfMovies);
    }

    /**
     * welcome message
     */
    public void welcome() {
        System.out.println("==================================");
        System.out.println("==  Welcome to Movie Theaters! ==");
        System.out.println("==================================");
    }

    /**
     * goodbye message
     */
    public void goodbye() {
        System.out.println("==================================");
        System.out.println("==     Thank You! Good Bye!     ==");
        System.out.println("==================================");
    }

    /**
     * start the program
     */
    public void startProgram() {
        welcome();
        menu();
        coordinator();
        another();
    }

    /**
     * start another search
     */
    public void another() {
        System.out.println("Do you want to start another search? enter [yes] or [no] :");
        Scanner in = new Scanner(System.in);
        String userChoice = in.nextLine();
        if (userChoice.equals("yes")) {
            startProgram();
        } else {
            goodbye();
        }
    }

    /**
     * menu message
     */
    public void menu() {
        System.out.println("==  In this movie theater, you will be able to search the movies by ID, NAME, and YEAR it produced  ==");
        System.out.println("==  1. Search By ID   ==");
        System.out.println("==  2. Search By Name ==");
        System.out.println("==  3. Search By Year ==");
        System.out.println("Please enter the according number 1/2/3 stands for ID/NAME/YEAR to start your search: ");
    }

    /**
     * take user input; assign task to certain function; print the result
     */
    public void coordinator() {
        Scanner in = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);
        int userChoice = in.nextInt();
        System.out.println("You Entered: " + userChoice);

        switch (userChoice) {
            case 1:
                System.out.println("Please enter movie id: ");
                int id = in.nextInt();
                System.out.println("You Entered: " + id);
                findById(id);
                break;
            case 2:
                System.out.println("Please enter movie name: ");
                String name = inStr.nextLine();
                System.out.println("You Entered: " + name);
                findByName(name);
                break;
            case 3:
                System.out.println("Please enter movie year produced: ");
                String year = inStr.nextLine();
                System.out.println("You Entered: " + year);
                findByYear(year);
                break;
            default:
                System.out.println("Please enter movie id: ");
                int idMovie = in.nextInt();
                System.out.println("You Entered: " + idMovie);
                findById(idMovie);
        }
        goodbye();
    }

    /**
     * find movie by id
     */
    public void findById(int id) {
        System.out.println("==================================");
        System.out.println("Finding movie id: " + id);
        search.printSearchResults(search.searchByID(id));
        System.out.println("==================================");
    }

    /**
     * find movie by name
     */
    public void findByName(String name) {
        System.out.println("==================================");
        System.out.println("Finding movie " + name + " ...");
        search.printSearchResults(search.searchByName(name));
        System.out.println("==================================");
    }

    /**
     * find movie by year
     */
    public void findByYear(String year) {
        System.out.println("==================================");
        System.out.println("Finding movie produced by" + year + " ...");
        search.printSearchResults(search.searchByYear(year));
        System.out.println("==================================");
    }

    public static void main(String[] args) throws IOException {
        MyFileReader fr = new MyFileReader();
        File file = new File("/Users/SerenaPang/Development/Data Structure and Algorithm/Algorithms/src/oodesign/movie/reader/movies.csv");
        List<Movie> movies = fr.extractMovies(file);
        // print(movies);
        MovieMap mm = new MovieMap();
        HashMap<Integer, Movie> mapOfMovies = mm.buildIdAndMovieMap(movies);
        UserInterface ui = new UserInterface(mapOfMovies);
        ui.startProgram();
    }
}
