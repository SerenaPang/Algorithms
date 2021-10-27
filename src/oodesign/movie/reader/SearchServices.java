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

    public static void printMap(HashMap<Integer, Movie> mapOfMovies) {
        System.out.println("Printing map: ");
        for (Integer aMovie : mapOfMovies.keySet()) {
            System.out.println("ID: " + mapOfMovies.get(aMovie).ID
                    + " Name: " + mapOfMovies.get(aMovie).NAME + " Year: " + mapOfMovies.get(aMovie).YEAR);
        }
    }

    /**
     * return a list of result movie ids with the search by id
     */
    public List<Integer> searchByID(int id) {
        List<Integer> result = new ArrayList<>();
        if (mapOfMovies.containsKey(id)) {
            result.add(id);
        }
        return result;
    }

    /**
     * return a list of result movie ids with the search by name
     */
    public List<Integer> searchByName(String name) {
        List<Integer> result = new ArrayList<>();
        for (Integer aMovie : mapOfMovies.keySet()) {
            if (mapOfMovies.get(aMovie).NAME.equals(name)) {
                result.add(mapOfMovies.get(aMovie).ID);
            }
        }
        return result;
    }

    /**
     * return a list of result movie ids with the search by year
     */
    public List<Integer> searchByYear(String year) {
        List<Integer> result = new ArrayList<>();
        for (Integer aMovie : mapOfMovies.keySet()) {
            if (mapOfMovies.get(aMovie).YEAR.equals(year)) {
                result.add(mapOfMovies.get(aMovie).ID);
            }
        }
        return result;
    }

    /**
     * prints the result movies including the id, name, and year
     */
    public void printSearchResults(List<Integer> result) {
        for (Integer id : result) {
            System.out.println("ID: " + id + " Name: " + mapOfMovies.get(id).NAME + " Year: " + mapOfMovies.get(id).YEAR);
        }
    }

    public static void main(String[] args) throws IOException {
        MyFileReader fr = new MyFileReader();
        File file = new File("/Users/SerenaPang/Development/Data Structure and Algorithm/Algorithms/src/oodesign/movie/reader/movies.csv");
        List<Movie> movies = fr.extractMovies(file);
        // print(movies);
        MovieMap mm = new MovieMap();
        HashMap<Integer, Movie> mapOfMovies = mm.buildIdAndMovieMap(movies);
        // printMap(mapOfMovies);
        SearchServices ss = new SearchServices(mapOfMovies);
        //test search by id
        ss.printSearchResults(ss.searchByID(15)); //ID: 15 Name: Casablanca Year: 1942
        //test search by name
        ss.printSearchResults(ss.searchByName("The Godfather"));//ID: 25 Name: The Godfather Year: 1972
        //test search by year
        ss.printSearchResults(ss.searchByYear("1919"));//ID: 27 Name: Broken Blossoms Year: 1919
        ss.printSearchResults(ss.searchByYear("1944"));
    }

}
