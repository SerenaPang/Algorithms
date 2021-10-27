package oodesign.movie.reader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * This Driver class provides the file to be processed and
 * starts the program
 */
public class Driver {
    public static void main(String[] args) throws IOException {
        //provide file path
        MyFileReader fr = new MyFileReader();
        File file = new File("/Users/SerenaPang/Development/Data Structure and Algorithm/Algorithms/src/oodesign/movie/reader/movies.csv");
        //populating map for movies
        MovieMap map = new MovieMap();
        HashMap<Integer, Movie> mapOfMovies = map.buildIdAndMovieMap(fr.extractMovies(file));
        //start the search
        UserInterface ui = new UserInterface(mapOfMovies);
        ui.startProgram();
    }
}
