import javafx.util.Pair;

import java.awt.print.Book;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.RandomAccessFile;


/**
 * @author Dewan M F Kabir
 * Class: CS 622 O1
 * College: BU MET
 * Assignment: 03
 * Concept: Exceptions and Basic I/O
 * Date: 05/29/2021
 *
 */


public class CsvKeywordSearcher {

    public static void main(String[] args) throws IOException {

        /** This code block below is used to erase the contents of DataThree.txt which is used as a backup storage place
         * for the search keywords which are searched for during the execution of the program
         * It is erased every time the program is run, so that new search content can be entered.**/

        FileWriter fwOb = new FileWriter("DataThree.txt", false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();

        /** Here we are creating the Java collections that will store the Search keywords and Timestamps respectively  **/
        ArrayList<String> keyword5 = new ArrayList<String>();
        ArrayList<String> keyword6 = new ArrayList<String>();

        /** This is organizing the console for user inout  **/
        System.out.println("<----------------------Initiating Search Program-------------->");
        System.out.print("\n");
        System.out.println("To exit the Search Program please type in:" + " terminate");
        System.out.print("\n");
        System.out.println("Enter search keyword:");

        /**  The scanner is taking the user input **/

        /** User can Search for :
         * fitness,
         * robot and
         * wearable  **/

        Scanner myObj = new Scanner(System.in);

        String fitnessS = "fitness";
        String robotS = "robot";
        String werableS = "wearable";
        String terminateS = "terminate";


        /** This is used to save the current time of the execution of the main method  **/
        DateTimeFormatter dtfo = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");
        LocalDateTime now2 = LocalDateTime.now();
        String saveTimeNow2 = (dtfo.format(now2)).toString();
        System.out.println(saveTimeNow2);


        /** This is initializing the while loop
         * As long as the condition that there is user input in the console, the while loop while remain
         * active **/
        while (myObj.hasNext()) {

            String name = (myObj.nextLine()).toString();

            String keyword = name ;
             String keywordSelection = keyword;



            /** This conditional block below will be the logic that will allow the while loop to
             * be broken and terminated  so that the user can exit the program **/
            if((!name.equals(terminateS))){

                /** We are here, populating the Java collections for the search keyword and timestamps  **/
                keyword5.add(name);
                keyword6.add(saveTimeNow2);

                ArrayList<String> x = new ArrayList<String>();
                x.add((keywordSelection.toString()));


                /** Setting the BufferedReader Instance to null **/
                BufferedReader indigogoBuffer = null;

                try {
                    String indigogoLine;
                    /** Initializing the BufferedReader to tread the file defined in the Path parameter.
                     * We got this file form the second part of the assignment **/
                    indigogoBuffer = new BufferedReader(new FileReader("Merge.txt"));

                    /** Reading the array list line by line up until the list is completed, and appending a statement to each line  **/
                    while ((indigogoLine = indigogoBuffer.readLine()) != null) {

                        System.out.println("Requested Data for matching Keywords: " + CSVtoArrayConverter.indigogoCSVtoArrayList(indigogoLine, name) + "\n");

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (indigogoBuffer != null) indigogoBuffer.close();
                    } catch (IOException indigogoException) {
                        indigogoException.printStackTrace();
                    }
                }


                String saveCurrentKeyword = name.toString();


                /** This is used to save the current time of the execution of the main method  **/
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String saveTimeNow = (dtf.format(now)).toString();
                System.out.println("Most recent search time: " + saveTimeNow);

                System.out.print("\n");
                System.out.println("To exit the Search Program please type in:" + " terminate");
                System.out.print("\n");
                System.out.println("Enter search keyword:");
                System.out.print("\n");


                Path path1 = Paths.get("Data.txt");

                FileWriter fw = new FileWriter("Data.txt", true);

                try (BufferedWriter writer = Files.newBufferedWriter(path1, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {

                    writer.write(saveCurrentKeyword.toString());
                    writer.write(",");
                    writer.write(saveTimeNow.toString());
                    writer.newLine();


                } catch (IOException e) {
                    e.printStackTrace();
                }


                BufferedReader br = new BufferedReader(new FileReader("DataTwo.txt"));
                if (br.readLine() == null) {
                    System.out.println("No errors, and file empty");

                    br.close();

                    Path path2 = Paths.get("DataTwo.txt");
                    FileWriter fwTwo = new FileWriter("DataTwo.txt", true);
                    try (BufferedWriter writerTwo = Files.newBufferedWriter(path2, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {


                        writerTwo.write(saveCurrentKeyword.toString());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                } else {

                    br.close();

                    Path path2 = Paths.get("DataTwo.txt");
                    FileWriter fwTwo = new FileWriter("DataTwo.txt", true);
                    try (BufferedWriter writerTwo = Files.newBufferedWriter(path2, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {

                        writerTwo.write(",");
                        writerTwo.write(saveCurrentKeyword.toString());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }


              /********************************************** Handling the DataThree.txt file *****************************************************/


                /** This is the new file which was created for Assignment 03, this file is the backup file, which
                 * will store all the keywords and timestamps for the searches which was executed by the user during the run time of the
                 * program **/
                BufferedReader br3 = new BufferedReader(new FileReader("DataThree.txt"));
                if (br3.readLine() == null) {
                    System.out.println("No errors, and file empty");

                    br3.close();

                    Path path2 = Paths.get("DataThree.txt");
                    FileWriter fwTwo = new FileWriter("DataThree.txt", true);
                    try (BufferedWriter writerThree = Files.newBufferedWriter(path2, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {

                        /** Writing the search keyword and timestamp into the file  **/
                        writerThree.write(saveCurrentKeyword.toString());
                        writerThree.write(",");
                        writerThree.write(saveTimeNow.toString());
                        writerThree.newLine();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {

                    br3.close();

                    Path path2 = Paths.get("DataThree.txt");
                    FileWriter fwTwo = new FileWriter("DataThree.txt", true);
                    try (BufferedWriter writerThree = Files.newBufferedWriter(path2, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {

                        writerThree.write(saveCurrentKeyword.toString());
                        writerThree.write(",");
                        writerThree.write(saveTimeNow.toString());
                        writerThree.newLine();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


              /******************************************** End of Handling the DataThree.txt file *********************************************************/


              /** This code block below will be terminating the while loop
               * so that the user can exit the program, once the user exits the program the entire code block below until the
               * end will be executed to display relevant data to the user on the console**/

            }  else if (name.equals(terminateS)){
                System.out.print("\n");
                System.out.println("You have entered an invalid search keyword");
                System.out.print("\n");
                System.out.println("<-----------------------------Terminating Search Program----------------------------->");
                System.out.print("\n");



                /** This code block below will be fetching the data from the Java Collections
                 * and merge both collections to display the data **/

                System.out.println("<---------------Search History From Java Collection------------->");
                System.out.print("\n");

                int length = keyword5.size();
                if (length != keyword6.size()) {
                }
                ArrayList<String> array3 = new ArrayList<String>(length);
                for (int i = 0; i < length; i++) {
                    array3.add(keyword5.get(i) + " " + keyword6.get(i)  + "\n");

                }

                System.out.println(array3);
                System.out.print("\n");
                System.out.println("<-----------End of Search History From Java Collection------------>");
                System.out.print("\n");



                /** The code block below will be initiating to handle the saved content
                 * in the DataThree.txt file and display the data on the console **/

                Scanner scan = new Scanner(new File("DataThree.txt"));
                ArrayList<String[]> records = new ArrayList<String[]>();
                String[] record = new String[2];
                while(scan.hasNext())
                {
                    record = scan.nextLine().split("\\s*,\\s*");
                    records.add(record);
                }
                System.out.println("<-----------Search History From Text File------------->");
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
                System.out.println("<-----------End of Search History From Text File------------->");





                List<String> lines = Collections.emptyList();
                /** This is where we are calling the arraylist located in the current memroy of the program, stored in a collection  **/
                lines = keyword5;

                /** There is more detailed explanation about this isn the attached document,
                 * but its function is to get the frequency of each search keyword, which was
                 * searched for during the run time of the program**/
                Map<String, Integer> result = lines.parallelStream().
                        flatMap(s -> Arrays.asList(s.split(",")).stream()).
                        collect(Collectors.toConcurrentMap(
                                w -> w.toLowerCase(), w -> 1, Integer::sum));

                System.out.print("\n");
                System.out.print("The number of searches you have executed: " + keyword5.size());
                System.out.print("\n");
                System.out.print("\n");
                System.out.println("This is the frequency of searches for each keyword:  " + result);
                System.out.print("\n");

                /** This code block below is getting the most frequent search keyword  **/
                /** This is getting the most frequently searched keyword  **/
                System.out.println("Most frequently searched keyword: "+ Collections.max(result.entrySet(),
                        Comparator.comparingInt(Map.Entry::getValue)).getKey()) ;

                System.out.print("\n");
                // result.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

                /** Printing out the Arraylist from memory , once program is terminated, data is cleared **/
                System.out.println("The sequence of searches from Java Collection: " + lines);
                System.out.print("\n");

                break;
            }

        }
        /**This is the end of the code **/
    }

}
