package oodesign.movie.reader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
/**
 * takes in the list of movies and built a map with id as the key and movie as its values
 */
public class MovieMap {
    HashMap<Integer, Movie> mapOfMovies = new HashMap<Integer, Movie>();

    /**
     * takes in the list of movies and put the info to a map for easy accessing info
     * */
    public HashMap<Integer, Movie> buildIdAndMovieMap(List<Movie> movies) {
        for (Movie aMovie : movies) {
            mapOfMovies.put(aMovie.id, aMovie);
            // System.out.println(aMovie.ID + " " + aMovie.NAME + " " + aMovie.YEAR);
        }
        return mapOfMovies;
    }

    public static void printMap(HashMap<Integer, Movie> mapOfMovies) {
        System.out.println("Printing map: ");
        for (Integer aMovie : mapOfMovies.keySet()) {
            System.out.println("ID: " + mapOfMovies.get(aMovie).id
                    + " Name: " + mapOfMovies.get(aMovie).name + " Year: " + mapOfMovies.get(aMovie).year);
        }
    }

    public static void print(List<Movie> movies) {
        for (Movie aMovie : movies) {
            System.out.println(aMovie.id + " " + aMovie.name + " " + aMovie.year);
        }
    }

    public static void main(String[] args) throws IOException {
        MyFileReader fr = new MyFileReader();
        File file = new File("/Users/SerenaPang/Development/Data Structure and Algorithm/Algorithms/src/oodesign/movie/reader/movies.csv");
        List<Movie> movies = fr.extractMovies(file);
        // print(movies);
        MovieMap mm = new MovieMap();
        HashMap<Integer, Movie> mapOfMovies = mm.buildIdAndMovieMap(movies);
        printMap(mapOfMovies);
    }

}
