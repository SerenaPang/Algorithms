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
        if (filesToBeMerged.size() <= 1) {
            System.out.println("No files needs to be merged");
            return;
        }
        //merge the first 2 files so that we have a file to be merged at start, it won't start copying the first file to the output, and then start the merge
        reader.mergeFilesToAFile(filesToBeMerged.get(0), filesToBeMerged.get(1),output);
        //if there are just 2 files to be merged, it won't enter to this loop, so it will merged 2 files to ouput, else itwill merge all the files
        for (int i = 2; i < filesToBeMerged.size(); i++) {
            reader.mergeFilesToAFile(filesToBeMerged.get(i), output, output);
        }
    }

    public static void main(String[] args) throws IOException {
        //input files to be merged
        File filex = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filex");
        File filey = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filey");
        File filez = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filez");
        File filerandom = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filerandom");
        File filerupikaur = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filerupikaur");
        File fileselflove = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/fileselflove");

        //group it to a list of files
        List<File> filesToBeMerged = new ArrayList<>();
        filesToBeMerged.add(filex);
        filesToBeMerged.add(filey);

        filesToBeMerged.add(filez);
        filesToBeMerged.add(filerandom);
        filesToBeMerged.add(filerupikaur);
        filesToBeMerged.add(fileselflove);

        //output file
        File fileoutput= new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/output");
        startMerging(filesToBeMerged, fileoutput);
    }
}
