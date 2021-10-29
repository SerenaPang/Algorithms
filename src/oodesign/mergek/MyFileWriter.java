package oodesign.mergek;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

/***
 *writes the result of the merging files to the out put files
 */

public class MyFileWriter {

    //writing the merging result to the out put file
    public void myFileWriter (Path path, HashMap<Integer, List<String>> result) throws IOException{
        String content = "hello there";
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
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

        //write files to the output location
        File output = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/output");
        MyFileWriter writer = new MyFileWriter();
        writer.myFileWriter(output.toPath(), result);
    }


}
