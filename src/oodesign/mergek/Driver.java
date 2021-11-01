package oodesign.mergek;

import java.io.File;
import java.io.IOException;

/**
 * This class provides the file path, and the files needs to be merged.
 * and then writes the merge result to the output file
 * */
public class Driver {
    public static void main(String[] args) throws IOException {
        MyFileReaderSolutionTwo reader = new MyFileReaderSolutionTwo();

        File filex = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filex");
        File filey = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filey");
        File filez = new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/filez");

        //read file x and file y, output to file xy
        File filexy= new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/outputxy");
        reader.mergeFilesToAFile(filey,filex, filexy);

        //read output file xy and file z, output it to file xyz
        File filexyz= new File("/Users/serenapang/Development/Algorithms/src/oodesign/mergek/outputxyz");
        reader.mergeFilesToAFile(filexy,filez, filexyz);
    }
}
