package oodesign.movie.reader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class MovieMap {


    public static void printMap(HashMap<Integer, Movie> mapOfMovies) {
        System.out.println("Printing map: ");
        for (Integer aMovie : mapOfMovies.keySet()) {
            System.out.println("ID: " + mapOfMovies.get(aMovie).ID
                    + " Name: " + mapOfMovies.get(aMovie).NAME + " Year: " + mapOfMovies.get(aMovie).YEAR);
        }
    }

    public static void print(HashMap<Integer, String> map) {
        System.out.println("Printing map: ");
        for (Integer anElement : map.keySet()) {
            System.out.println("ID: " + map.get(anElement));
        }
    }

    public HashMap<Integer, String> testMap() {
        HashMap<Integer, String> myMap = new HashMap<>();
        int i = 10;
        while (i > 0) {
            myMap.put(i, "hi");
            i--;
        }
        return myMap;
    }

    public static void print(List<Movie> movies) {
        for (Movie aMovie : movies) {
            System.out.println(aMovie.ID + " " + aMovie.NAME + " " + aMovie.YEAR);
        }
    }

    public static void main(String[] args) throws IOException {
        MyFileReader fr = new MyFileReader();
        File file = new File("/Users/SerenaPang/Development/Data Structure and Algorithm/Algorithms/src/oodesign/movie/reader/movies.csv");


    }

}
