package oodesign.mergek;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * merge all maps into one large map
 *
 * This solution is not so good because if the memory is only 16 GB, then when we are loading a file which is 100 GB,
 * then it could not fit in the memory
 *
 * if 1 file has the size of r, another has the size of t then the time complexity is going to be t + r
 */
public class MergeKSortedMaps {

    /**
     * function that merge 2 maps together
     * */
    public HashMap<Integer, List<String>> mergeTwoMaps(HashMap<Integer, List<String>> firstMap, HashMap<Integer, List<String>> secondMap) {
        HashMap<Integer, List<String>> result = firstMap;

            for (Integer time : secondMap.keySet()) {
                List<String> messages = secondMap.get(time);
                //adding all messages to the map
                if (result.containsKey(time)) {
                    for (int i =0 ;i < messages.size(); i++) {
                        result.get(time).add(messages.get(i));
                    }
                } else {
                        result.put(time, messages);
                }
            }
        return result;
    }

    /**
     * function that merges a list of maps together
     * */
    public HashMap<Integer, List<String>> mergeLisOfMaps(List<HashMap<Integer, List<String>>> maps) {
        if (maps.size() == 1) {
            return maps.get(0);
        }
        HashMap<Integer, List<String>> result = maps.get(0);

        for (int numberOfMaps = 1; numberOfMaps < maps.size(); numberOfMaps++) {
            for (Integer time : maps.get(numberOfMaps).keySet()) {
                List<String> messages =  maps.get(numberOfMaps).get(time);
                //adding all messages to the map
                if (result.containsKey(time)) {
                    for (int i =0 ;i < messages.size(); i++) {
                        result.get(time).add(messages.get(i));
                    }
                } else {
                    result.put(time, messages);
                }
            }
        }
        return result;
    }

    /**
     * takes in a list of  HashMap<Integer, List<String>> and using the merge function to merge all the maps
     * */
    public List<HashMap<Integer, List<String>>> addMap(HashMap<Integer, List<String>> aMap){
        List<HashMap<Integer, List<String>>> mapsToBeMerged = new ArrayList<>();
        mapsToBeMerged.add(aMap);
        mergeLisOfMaps(mapsToBeMerged);
        return mapsToBeMerged;
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

        HashMap<Integer, List<String>> filexMapOfMessages = fr.extractMessageAndTime(filex);
     //   print(filexMapOfMessages);

        HashMap<Integer, List<String>> fileyMapOfMessages = fr.extractMessageAndTime(filey);
      //  print(fileyMapOfMessages);

        HashMap<Integer, List<String>> filezMapOfMessages = fr.extractMessageAndTime(filez);
    //  print(filexMapOfMessages);

        MergeKSortedMaps merge = new MergeKSortedMaps();
        //HashMap<Integer, List<String>> result = merge.mergeTwoMaps(filexMapOfMessages, fileyMapOfMessages);
        //add all maps we want to merge to the list
        List<HashMap<Integer, List<String>>> mapsToBeMerged = merge.addMap(filexMapOfMessages);
        mapsToBeMerged.add(fileyMapOfMessages);
        mapsToBeMerged.add(filezMapOfMessages);

        //start merging the maps
        HashMap<Integer, List<String>> result = merge.mergeLisOfMaps(mapsToBeMerged);
        print(result);

    }
}
