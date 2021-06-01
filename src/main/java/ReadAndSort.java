import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadAndSort {


    public static void main(String[] args) throws IOException {



        /** This code block below will print the search history for the program,
         * which was saved after the last record deletion
         * The history is updated after each time the main (CsvKeywordSearcher) program is executed**/
        Scanner scan = new Scanner(new File("Data.txt"));
        ArrayList<String[]> records = new ArrayList<String[]>();
        String[] record = new String[2];
        while(scan.hasNext())
        {
            record = scan.nextLine().split("\\s*,\\s*");
            records.add(record);
        }
        System.out.println("<-----------Updated Search History------------->");
        System.out.print("\n");
        //now records has your records.
        //here is a way to loop through the records (process)
        for(int i = 0; i < records.size(); i++)
        {
            for(int j = 0; j < records.get(i).length; j++)
            {
                System.out.print(records.get(i)[j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.println("<-----------End of Search History------------->");




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

            System.out.print("\n");
            System.out.println("This is the frequency of searches for each keyword:  " + result);
            System.out.print("\n");

           /** This is getting the most frequently searched keyword  **/
            System.out.println("Most frequently searched keyword: "+ Collections.max(result.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey()) ;
            System.out.print("\n");
           // result.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();



        } catch (IOException e) {

            e.printStackTrace();
        }


        System.out.println("These are the most up to date searches: " + lines);
        System.out.print("\n");



    }




}


