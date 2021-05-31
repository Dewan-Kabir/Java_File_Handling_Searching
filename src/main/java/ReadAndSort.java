import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadAndSort {


    public static void main(String[] args) throws IOException {


        // reading text file into List in Java 7
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get("DataTwo.txt"), StandardCharsets.UTF_8);
//            System.out.println("The frequency of the word code is: "+
//                    Collections.contains("fitness");


            Map<String, Integer> result = lines.parallelStream().
                    flatMap(s -> Arrays.asList(s.split(",")).stream()).
                    collect(Collectors.toConcurrentMap(
                            w -> w.toLowerCase(), w -> 1, Integer::sum));
            System.out.println("This is the frequency of searches for each keyword:  " + result);

           System.out.println(Collections.max(result.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey()) ;

           // result.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();



        } catch (IOException e) {

            e.printStackTrace();
        }

        System.out.println("These are the most up to date searches: " + lines);



    }




}


