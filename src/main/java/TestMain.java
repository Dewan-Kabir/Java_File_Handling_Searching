import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {


    /**
     * @author Dewan M F Kabir
     * Class: CS 622 O1
     * College: BU MET
     * Assignment: 03
     * Concept: Exceptions and Basic I/O
     * Date: 05/28/2021
     *
     */

    /** This is a test code block , used  to test the main while loop
     * which we will be using in the CsvKeywordSearcher class , to execute the main program
     * It is kept for references only**/

    public static void main(String[] args) throws IOException {



        ArrayList<String> keyword5 = new ArrayList<String>();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter search keyword:");
        // String input
        String fitnessS = "fitness";
        String robotS = "robot";
        String werableS = "wearable";
        String terminateS = "terminate";
        String educationS = "education";

        while (myObj.hasNext()) {

            String name = (myObj.nextLine()).toString();

            if((!name.equals(robotS))       ){

                keyword5.add(name);

            }  else if (name.equals(robotS)){

                System.out.println("You have entered an invalid search keyword");


                break;
            }

        }

        System.out.println(keyword5);

    }






}
