package oodesign.mergek;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the file path, and the files needs to be merged.
 * and then writes the merge result to the output file
 * */
public class Driver {

    //This function takes in a list of files needs to be merged, and output the result to the output file
    public static void startMerging(List<File> filesToBeMerged, File output) throws IOException {
        MyFileReaderSolutionTwo reader = new MyFileReaderSolutionTwo();
        for (File aFile : filesToBeMerged) {
            reader.mergeFilesToAFile(aFile, output, output);
        }
    }

    public static void main(String[] args) throws IOException {
        //input files to be merged
        File filex = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filex");
        File filey = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filey");
        File filez = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filez");
        File filerandom = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filerandom");

        //group it to a list of files
        List<File> filesToBeMerged = new ArrayList<>();
        filesToBeMerged.add(filex);
        filesToBeMerged.add(filey);
        filesToBeMerged.add(filez);
        filesToBeMerged.add(filerandom);

        //output file
        File fileoutput= new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/output");
        startMerging(filesToBeMerged, fileoutput);
    }
}
