package oodesign.movie.reader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static oodesign.movie.reader.MovieMap.printMap;

/**
 * Search By name, by id, by year produced
 * return the result in a list
 */
public class SearchServices {
    HashMap<Integer, Movie> mapOfMovies = new HashMap<Integer, Movie>();

    SearchServices(HashMap<Integer, Movie> mapForMovies) {
        this.mapOfMovies = mapForMovies;
    }


    public List<Movie> searchByID(int id) {
        List<Movie> result = new ArrayList<>();

        return result;
    }

    public List<Movie> searchByName(String name) {
        List<Movie> result = new ArrayList<>();

        return result;
    }

    public List<Movie> searchByYear(String name) {
        List<Movie> result = new ArrayList<>();

        return result;
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
