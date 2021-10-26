package oodesign.movie.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class MyFileReader {
    public static HashMap<Integer, Movie> mapOfMovies = new HashMap<Integer, Movie>();

    public void readFile(File inputFile) throws IOException {
        FileReader in = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(in);
        System.out.println("Reading " + inputFile.getName().toString());
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    public List<Movie> extractMovies(File inputFile) throws IOException {
        List<Movie> listOfMovies = new ArrayList<>();
        FileReader in = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(in);
        StringToNumberConverter converter = new StringToNumberConverter();
        System.out.println("Reading " + inputFile.getName().toString() + "... ...");
        String line;
        while ((line = br.readLine()) != null) {
            //System.out.println(line);
            //for each line, we extract the id, name and year
            ArrayList<String> movie = new ArrayList<>(Arrays.asList(line.split(",")));
            String idStr = movie.get(0);
            //  int id = Integer.parseInt(idStr);
            int id = converter.convert(idStr);
            String name = movie.get(1);
            String year = movie.get(2);
            // System.out.println("id: " + id + " name: " + name + " year: " + year);
            Movie aMovie = new Movie(id, name, year);
            listOfMovies.add(aMovie);
        }
        return listOfMovies;
    }

    public List<Movie> extractMovies2() throws IOException {
        List<Movie> listOfMovies = new ArrayList<>();
        Movie aMovie = new Movie(1, "a", "10");
        listOfMovies.add(aMovie);
        Movie aMovie1 = new Movie(2, "b", "20");
        listOfMovies.add(aMovie1);
        Movie aMovie2 = new Movie(3, "c", "30");
        listOfMovies.add(aMovie2);

        return listOfMovies;
    }

    public static void print(List<Movie> movies) {
        for (Movie aMovie : movies) {
            System.out.println(aMovie.ID + " " + aMovie.NAME + " " + aMovie.YEAR);
        }
    }


    public static void main(String[] args) throws IOException {
        MyFileReader fr = new MyFileReader();
        File file = new File("/Users/SerenaPang/Development/Data Structure and Algorithm/Algorithms/src/oodesign/movie/reader/movies.csv");
        List<Movie> movies = fr.extractMovies(file);
        print(movies);
    }
}
