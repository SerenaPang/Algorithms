package oodesign.mergek;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

/***
 *writes the result of the merging files to the out put files
 */

public class MyFileWriter {


    public void writeLine(Path path, String content) throws IOException {
        FileWriter writer = new FileWriter(path.toFile());
        System.out.println("writing " + content);
        writer.write(content + System.lineSeparator());
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
        List<String> result = reader.merge(filex, filey);

        //write files to the output location
      //  File output = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/output");
        Path out = Path.of("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/output");
        MyFileWriter writer = new MyFileWriter();
        writer.writeToFile(out, result);
    }
}