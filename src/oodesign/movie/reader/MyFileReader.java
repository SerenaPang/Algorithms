package oodesign.movie.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class MyFileReader {
    //public static HashMap<Integer, Movie> mapOfMovies = new HashMap<Integer, Movie>();

    public void readFile(File inputFile) throws IOException {
        FileReader in = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(in);
        System.out.println("Reading " + inputFile.getName().toString());
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    public HashMap<Integer, Movie> buildMap(File inputFile) throws IOException {
        HashMap<Integer, Movie> mapOfMovies = new HashMap<Integer, Movie>();
        FileReader in = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(in);
        System.out.println("Reading " + inputFile.getName().toString() + "... ...");
        String line;
        while ((line = br.readLine()) != null) {
            //System.out.println(line);
            //for each line, we extract the id, name and year
            ArrayList<String> movie = new ArrayList<>(Arrays.asList(line.split(",")));
            String idStr = movie.get(0);
            int id = Integer.parseInt(idStr);
            String name = movie.get(1);
            String year = movie.get(2);
            // System.out.println("id: " + id + " name: " + name + " year: " + year);
            //putting the info to a map
            Movie aMovie = new Movie(id, name, year);
            mapOfMovies.put(id, aMovie);
            // printMap(mapOfMovies);
        }
        printMap(mapOfMovies);
        return mapOfMovies;
    }

    public void printMap(HashMap<Integer, Movie> mapOfMovies) {
        System.out.println("Printing map: ");
        for (Integer aMovie : mapOfMovies.keySet()) {
            System.out.println("ID: " + mapOfMovies.get(aMovie).ID
                    + " Name: " + mapOfMovies.get(aMovie).NAME + " Year: " + mapOfMovies.get(aMovie).YEAR);
        }
    }

    public static void main(String[] args) throws IOException {
        MyFileReader fr = new MyFileReader();
        File file = new File("/Users/SerenaPang/Development/Data Structure and Algorithm/Algorithms/src/oodesign/movie/reader/movies.csv");

        fr.buildMap(file);

        //buildMap(file);

    }
}
