import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;


/**
 * @author Dewan M F Kabir
 * Class: CS 622 O1
 * College: BU MET
 * Assignment: 02 Part_03
 * Concept: Exceptions and Basic I/O
 * Date: 05/23/2021
 *
 */


public class CsvKeywordSearcher {




    public static String[] keyword = {"fitness", "robot" , "wearables"} ;
    public static String keywordSelection = keyword[1];

//    public static ArrayList<String> printCollection(){
//
//
//        return x;
//
//
//    }





    public static void main(String[] args) throws IOException {

        ArrayList<String> x = new ArrayList<String>();
        x.add((keywordSelection.toString()));





        //String keyword = "robot";
        String keyword2 = "wearable";




        /** Setting the BufferedReader Instance to null **/
        BufferedReader indigogoBuffer = null;


        try {
            String indigogoLine;
            /** Initializing the BufferedReader to tread the file defined in the Path parameter.
             * We got this file form the second part of the assignment **/
            indigogoBuffer = new BufferedReader(new FileReader("Merge.txt"));

            /** Reading the array list line by line up until the list is completed, and appending a statement to each line  **/
            while ((indigogoLine = indigogoBuffer.readLine()) != null) {

               System.out.println("Requested Data for matching Keywords: " + indigogoCSVtoArrayList(indigogoLine , keywordSelection) + "\n");








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

//        ArrayList<String> list =
//                new ArrayList<String>();
//        if (keyword != null){
//            list.add(keyword);
//        }
//
//
//        // count the frequency of the word "code"
//        System.out.println("The frequency of the word code is: "+
//                Collections.frequency(list, keyword));



        System.out.println(x);
        System.out.println("The frequency of the keyword is: "+
                Collections.frequency(x, "robot"));


        String saveCurrentKeyword = keywordSelection.toString();



        /** This is used to save the current time of the execution of the main method  **/
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String saveTimeNow = (dtf.format(now)).toString();
        System.out.println(saveTimeNow);


//        try {
//            FileOutputStream outputStream = new FileOutputStream("Data.txt" , true);
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
//            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
//
//            bufferedWriter.write(saveCurrentKeyword.toString());
//            bufferedWriter.write(",");
//            bufferedWriter.write(saveTimeNow.toString());
//            bufferedWriter.newLine();
//
//
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }




        Path path1 = Paths.get("Data.txt");

        FileWriter fw = new FileWriter("Data.txt",true);

        try (BufferedWriter writer = Files.newBufferedWriter(path1, StandardCharsets.UTF_8, StandardOpenOption.APPEND )) {

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
            FileWriter fwTwo = new FileWriter("DataTwo.txt",true);
            try(BufferedWriter writerTwo = Files.newBufferedWriter(path2, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {


                writerTwo.write(saveCurrentKeyword.toString());
//                writerTwo.write(",");
//                writerTwo.write(saveTimeNow.toString());

            }
            catch (IOException e) {
                e.printStackTrace();
            }





        }
        else {

            br.close();

            Path path2 = Paths.get("DataTwo.txt");
            FileWriter fwTwo = new FileWriter("DataTwo.txt",true);
            try(BufferedWriter writerTwo = Files.newBufferedWriter(path2, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {

                writerTwo.write(",");
                writerTwo.write(saveCurrentKeyword.toString());
//                writerTwo.write(",");
//                writerTwo.write(saveTimeNow.toString());

            }
            catch (IOException e) {
                e.printStackTrace();
            }


        }















//        try {
//            File file = new File("Data.txt" );
//            FileWriter fileReader = new FileWriter(file , true); // A stream that connects to the text file
//            BufferedWriter bufferedWriter = new BufferedWriter(fileReader ); // Connect the FileWriter to the BufferedWriter
//
//            bufferedWriter.write(saveCurrentKeyword);
//            bufferedWriter.write(",");
//            bufferedWriter.write(saveTimeNow);
//            bufferedWriter.newLine();
//
//
//            bufferedWriter.close (); // Close the stream
//        } catch (Exception e) {
//            e.printStackTrace();
//        }




















    }







    public static ArrayList<String> indigogoCSVtoArrayList(String indigogoCSV , String keyword) {
        /**We are first defining the keywords for which the program will search for in the list of arrays*/

        ArrayList<String> indigogoResult = new ArrayList<String>();

        if (indigogoCSV != null) {
            /** We are implementing Regex concepts, where the csv are being separated at every (,) and any white spaces,
             * before and after it, are being removed , including the (,) itself. This ensures,that all elements are stored correctly in the array **/
            String[] splitData = indigogoCSV.split("\\s*,\\s*");
            for (int i = 0; i < splitData.length; i++) {

                /** The below code block will implement certain  conditions, and if either of the keywords are present in the array ,
                 * it will print the category, close_date, funds_raised_percent and the tag_line. The category and Tag_line, were added to better
                 * identify what type of product was being selected based on the keywords. **/
                if ((!(splitData[i] == null) || !(splitData[i].length() == 0)) && (   (splitData[i].contains(keyword))
                          )) {
                    //  ||  (splitData[i].contains(keyword2))  || (splitData[i].contains(keyword3))
                    indigogoResult.add(splitData[1]); // Adding the Category
                    indigogoResult.add(splitData[4]); // Adding the close_date
                    indigogoResult.add(splitData[7]); // Adding the funds_raised_percent
                    indigogoResult.add(splitData[24]); // Adding the tagline


                    /** The else condition states that if neither of the keywords are present in the array , to clear the contents of the array and return them. **/
                }else if (  !((splitData[i].contains(keyword))  )) {
                    if (indigogoResult != null) {
                        indigogoResult.clear();
                    }
                }
            }
        }

        return indigogoResult;

        // ||  !(splitData[i].contains(keyword2))  || !(splitData[i].contains(keyword3)))

    }




}
