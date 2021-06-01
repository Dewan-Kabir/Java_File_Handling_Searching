import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {

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









//        keyword5.add(name);




        while (myObj.hasNext()) {

            String name = (myObj.nextLine()).toString();





//            if((name.equals(fitnessS))  || (name.equals(werableS))      ){

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
