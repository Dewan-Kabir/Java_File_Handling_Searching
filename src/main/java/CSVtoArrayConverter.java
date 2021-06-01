import java.util.ArrayList;


/**
 * @author Dewan M F Kabir
 * Class: CS 622 O1
 * College: BU MET
 * Assignment: 03
 * Concept: Exceptions and Basic I/O
 * Date: 05/28/2021
 *
 */

/** This code block has been extracted from the CsvKeywordSearcher class, and was one of the main logic components
 * for Assignment 02  **/

public class CSVtoArrayConverter {


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
