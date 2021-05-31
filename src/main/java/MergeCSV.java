import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dewan M F Kabir
 * Class: CS 622 O1
 * College: BU MET
 * Assignment: 02 Part_02
 * Concept: Exceptions and Basic I/O
 * Date: 05/23/2021
 *
 */

/***
 *
 * This is the second part of the assignment, where we will merge two .csv files
 * to have all the contents in one .txt file.

 * The new Merge.txt file will be used for the third part of the assignment, where we will search for
 * a keyword and print corresponding values from the Merge.txt file.
 *
 */


public class MergeCSV {



    public static void main(String[] args) throws IOException {
        /** We added the two .csv files into the project, and also an empty Merge.txt file which will contain the results
         * of the merge of the two .csv files. **/
        List<Path> paths = Arrays.asList(Paths.get("indiegogo001.csv"), Paths.get("indiegogo002.csv"));
        List<String> mergedLines = getMergedLines(paths);
        /** Specifying the target file where the merged contents will reside **/
        Path target = Paths.get("Merge.txt");
        Files.write(target, mergedLines, Charset.forName("UTF-8"));
    }

    private static List<String> getMergedLines(List<Path> paths) throws IOException {
        List<String> mergedLines = new ArrayList<>();
        /** Using an enhanced for loop **/
        for (Path p : paths){
            List<String> lines = Files.readAllLines(p, Charset.forName("UTF-8"));
            if (!lines.isEmpty()) {
                if (mergedLines.isEmpty()) {
                    /** Adding header only once, to prevent adding it twice **/
                    mergedLines.add(lines.get(0));
                }
                mergedLines.addAll(lines.subList(1, lines.size()));
            }
        }
        return mergedLines;
    }




}
