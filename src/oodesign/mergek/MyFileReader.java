package oodesign.mergek;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;
/**
 * read the input file and store the file input to a Hashmap of time and messages
 */
public class MyFileReader {
   // public static HashMap<Integer, String> mapOfMessages = new HashMap<Integer, String>();

    public void readFile(File inputFile) throws IOException {
        FileReader in = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(in);
        System.out.println("Reading " + inputFile.getName().toString());
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    /**
     * split the line into array and use integer parse int
     */
    public HashMap<Integer, List<String>> extractMessageAndTime(File inputFile) throws IOException {
        HashMap<Integer, List<String>> mapOfMessages = new HashMap<Integer, List<String>>();
        FileReader in = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(in);

        System.out.println("Reading " + inputFile.getName().toString() + "... ...");
        String line;
        while ((line = br.readLine()) != null) {
            List<String> listMessages = new ArrayList<>();
            //for each line, we extract the id, name and year
            String[] movieArray = line.split(":");
            String timeStr = movieArray[0];
            int time = Integer.parseInt(timeStr);
            String message = movieArray[1];


            if (!mapOfMessages.containsKey(time)) {
                List<String> listMessagesFromSameTime = new ArrayList<>();
                listMessagesFromSameTime.add(message);
                mapOfMessages.put(time, listMessagesFromSameTime);
            } else {
                List<String> listMessagesFromSameTime = mapOfMessages.get(time);
                listMessagesFromSameTime.add(message);
            }
        }
        return mapOfMessages;
    }

    public static void print(List<String> messages) {
        for (String aMessage : messages) {
            System.out.println(aMessage);
        }
    }

    public static void print(HashMap<Integer, List<String>> messageMap) {
        System.out.println("Printing map: ");
        for (Integer key : messageMap.keySet()) {
            for (int i = 0; i < messageMap.get(key).size(); i++) {
                System.out.println("Time: " + key.toString() + " Message: " + messageMap.get(key).get(i));
            }
        }
        System.out.println("Done");
    }


    public static void main(String[] args) throws IOException {
        MyFileReader fr = new MyFileReader();

        File filex = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filex");
        File filey = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filey");
        File filez = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filez");
//        fr.readFile(filex);
//        fr.readFile(filey);
//        fr.readFile(filez);
        HashMap<Integer, List<String>>  filexMapOfMessages = fr.extractMessageAndTime(filex);
        print(filexMapOfMessages);

        HashMap<Integer, List<String>>  fileyMapOfMessages = fr.extractMessageAndTime(filex);
        print(fileyMapOfMessages);

        HashMap<Integer, List<String>>  filezMapOfMessages = fr.extractMessageAndTime(filex);
        print(filexMapOfMessages);
    }
}

