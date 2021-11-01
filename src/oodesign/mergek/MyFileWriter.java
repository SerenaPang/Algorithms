package oodesign.mergek;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

/***
 *writes the result of the merging files to the out put files
 */

public class MyFileWriter {

    public void testWriter(File input, File output) throws IOException {
        //create file reader to read the files
        FileReader in = new FileReader(input);
        BufferedReader br = new BufferedReader(in);
        String line;

        //create file writer to write the files
        FileWriter writer = new FileWriter(output);


        while ((line = br.readLine()) != null) {
            writer.write(line + System.lineSeparator());
        }
        writer.flush();
        writer.close();
    }

    public void writeToFile(Path path ,List<String> result) throws IOException {
        FileWriter writer = new FileWriter(path.toFile());
        for (String aLine : result) {
            //System.out.println(aLine);
           writer.write(aLine + System.lineSeparator());
        }
        writer.close();
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
        MyFileReaderSolutionTwo reader = new MyFileReaderSolutionTwo();

        File filex = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filex");
        File filey = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filey");
        File filez = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filez");
        //merge result
        List<String> result = reader.mergeToList(filex, filey);

        //write list of strings to the output location
      //  File output = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/output");
        Path out = Path.of("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/output");
        MyFileWriter writer = new MyFileWriter();
        writer.writeToFile(out, result);
        File outputFile = out.toFile();
        writer.testWriter(filex, outputFile);

    }
}