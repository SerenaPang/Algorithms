package oodesign.mergek;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This class reads the input files and merge them into one file
 */
public class MyFileReaderSolutionTwo {

    /**
     *This function merges 2 files and sorted the files base on the time stamp
     * the result are put into a list, and then print to the output file
     *
     * However, if we put everythong into the list, then the memory is going to explode if the data doesn't fit, it's the same problem
     * of reading all data from the files, so it's better to read the data from 2 files, compare 2 lines, and put the result to the outputfile immediately
     **/
    public List<String> merge(File firstInputFile, File secondInputFile) throws IOException {
        MyFileWriter writer = new MyFileWriter();

        FileReader firstFR = new FileReader(firstInputFile);
        BufferedReader br = new BufferedReader(firstFR);

        FileReader secondFR = new FileReader(secondInputFile);
        BufferedReader brSecond = new BufferedReader(secondFR);

        System.out.println("Reading " + firstInputFile.getName().toString() + " and  " + secondInputFile.getName().toString() + "... ...");

        String firstLine = br.readLine();
        String secondLine = brSecond.readLine();
        List<String> listOfSortedResult = new ArrayList<>();

        while (firstLine != null && secondLine != null) {

            //for each line in the first file, we extract the id, name and year
            String[] messageArrayFirst = firstLine.split(":");
            String timeStrFirst = messageArrayFirst[0];
            int timeFirst = Integer.parseInt(timeStrFirst);
            String messageFirst = messageArrayFirst[1];

            //for each line in the second file, we extract the id, name and year
            String[] messageArraySecond = secondLine.split(":");
            String timeStrSecond = messageArraySecond[0];
            int timeSecond = Integer.parseInt(timeStrSecond);
            String messageSecond = messageArraySecond[1];

            //compare the time of the two lines in the file, write the lines to the output file

            if (timeFirst <= timeSecond) {
                listOfSortedResult.add(firstLine);
                firstLine = br.readLine();
            } else {
                listOfSortedResult.add(secondLine);
                secondLine = brSecond.readLine();
            }
        }

        //if file one finished first, then put everything left on file two to the output file
        //be careful about the sequence of putting the current line first and then iterate to the next line
        while (firstLine != null) {
            listOfSortedResult.add(firstLine);
            firstLine = br.readLine();
        }


        //if file two finished first, put everything left on file one to the output file
        while (secondLine != null) {
            listOfSortedResult.add(secondLine);
            secondLine = brSecond.readLine();
        }
       return listOfSortedResult;
    }

    public void mergeFiles(File firstInputFile, File secondInputFile, Path outputFile) throws IOException {
        MyFileWriter writer = new MyFileWriter();

        FileReader firstFR = new FileReader(firstInputFile);
        BufferedReader br = new BufferedReader(firstFR);

        FileReader secondFR = new FileReader(secondInputFile);
        BufferedReader brSecond = new BufferedReader(secondFR);

        System.out.println("Reading " + firstInputFile.getName().toString() + " and  " + secondInputFile.getName().toString() + "... ...");

        String firstLine = br.readLine();
        String secondLine = brSecond.readLine();
        List<String> listOfSortedResult = new ArrayList<>();

        while (firstLine != null && secondLine != null) {

            //for each line in the first file, we extract the id, name and year
            String[] messageArrayFirst = firstLine.split(":");
            String timeStrFirst = messageArrayFirst[0];
            int timeFirst = Integer.parseInt(timeStrFirst);
            String messageFirst = messageArrayFirst[1];

            //for each line in the second file, we extract the id, name and year
            String[] messageArraySecond = secondLine.split(":");
            String timeStrSecond = messageArraySecond[0];
            int timeSecond = Integer.parseInt(timeStrSecond);
            String messageSecond = messageArraySecond[1];

            //compare the time of the two lines in the file, write the lines to the output file

            if (timeFirst <= timeSecond) {
                writer.writeLine(outputFile, firstLine);
                firstLine = br.readLine();
            } else {
                writer.writeLine(outputFile, secondLine);
                secondLine = brSecond.readLine();
            }
        }

        //if file one finished first, then put everything left on file two to the output file
        //be careful about the sequence of putting the current line first and then iterate to the next line
        while (firstLine != null) {
            writer.writeLine(outputFile, firstLine);
            firstLine = br.readLine();
        }


        //if file two finished first, put everything left on file one to the output file
        while (secondLine != null) {
            writer.writeLine(outputFile, secondLine);
            secondLine = brSecond.readLine();
        }
    }


    public void print(List<String> result) {
        for (String line : result) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) throws IOException {
        MyFileReaderSolutionTwo reader = new MyFileReaderSolutionTwo();

        File filex = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filex");
        File filey = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filey");
        File filez = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filez");

        //write files to the output location
        Path output = Path.of("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/output");

        reader.mergeFiles(filex,filey,output);
    }
}
