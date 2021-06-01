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



//    String inputByUser = "This input was given by a user";
//    public static PrintStream out = new PrintStream(System.out);
//
//    public static void start() {
//        Scanner in = new Scanner(System.in);
//        String savedInput = (in.nextLine()).toString();
//        out.println(savedInput);
//    }










    public static void main(String[] args) throws IOException {

        FileWriter fwOb = new FileWriter("DataThree.txt", false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();

        //            new CsvKeywordSearcher().start();
        /** Backup  **/
//        ArrayList<String> keyword5 = new ArrayList<String>();
//        Scanner myObj = new Scanner(System.in);
//        System.out.println("Enter search keyword:");
//
//        // String input
//        String fitnessS = "fitness";
//        String robotS = "robot";
//        String name = (myObj.nextLine()).toString();
//        keyword5.add(name);
        /** Backup end  **/

        ArrayList<String> keyword5 = new ArrayList<String>();
        ArrayList<String> keyword6 = new ArrayList<String>();


        Scanner myObj = new Scanner(System.in);


        System.out.println("<----------------------Initiating Search Program-------------->");
        System.out.print("\n");
        System.out.println("To exit the Search Program please type in:" + " terminate");
        System.out.print("\n");
        System.out.println("Enter search keyword:");




        // String input


        String fitnessS = "fitness";
        String robotS = "robot";
        String werableS = "wearable";
        String terminateS = "terminate";
        String educationS = "education";


        /** This is used to save the current time of the execution of the main method  **/
        DateTimeFormatter dtfo = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");
        LocalDateTime now2 = LocalDateTime.now();
        String saveTimeNow2 = (dtfo.format(now2)).toString();
        System.out.println(saveTimeNow2);


        while (myObj.hasNext()) {

            String name = (myObj.nextLine()).toString();





//            if((name.equals(fitnessS))  || (name.equals(werableS))      ){

            if((!name.equals(terminateS))       ){

                keyword5.add(name);
                keyword6.add(saveTimeNow2);
















//
//            ListIterator<String> iter = keyword5.listIterator();
//            while(iter.hasNext()){
//                if(iter.next().equals().name)){
//                    iter.add(new Book(...));
//                }
//            }



//
//            // Creating an Arraylist
//            List<String> myList = new ArrayList<String>();
//
//            // Adding elements to the List
//            // Custom inputs
//            myList.add(name);









//            List<String> xxx = new ArrayList<>();
//            ListIterator<String> iterator = xxx.listIterator();
//            while (iterator.hasNext()) {
//                String s = iterator.next();
//                for (String zzz : name) {
//                    if (!zzz.equals(s)) {
//                        iterator.add(zzz); //<-- Adding is done through the iterator
//                    }
//                }
//            }




//            if ((name != null) && (name.equals(fitnessS))) {


                //String[] keyword2 = null;




//        List<String> numbers = Arrays.asList(keywordSelection);
//
//        // For Loop for iterating ArrayList
//        for (int i = 0; i < numbers.size(); i++) {
//            System.out.print(numbers.get(i) + " ");
//        }


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
                System.out.println("The frequency of the keyword is: " +
                        Collections.frequency(x, "robot"));


//        String saveCurrentKeyword = keywordSelection.toString();

                String saveCurrentKeyword = name.toString();


                /** This is used to save the current time of the execution of the main method  **/
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String saveTimeNow = (dtf.format(now)).toString();
                System.out.println(saveTimeNow);


//                 ArrayList<String, String> students = new ArrayList<String, String>();
//
//                String[] names = {saveCurrentKeyword};
//                String[] ids = {saveTimeNow};
//
//                students.put(names , ids);







//                String names = saveCurrentKeyword;
//                String ids = saveTimeNow;
//
//                Map<String, String> IDMap = new HashMap<String, String>();
//
//                IDMap.put(names, ids);
//
////                for (int i = 0; i < names.length; i++) {
////                    IDMap.put(ids[i], names[i]);
////                }
//
//                System.out.println(IDMap.size() + " Students entered: ");
//                System.out.println(IDMap);






                /** This was map implementation  **/
//            PopulateMap map = new PopulateMap();
//            map.addModel(saveCurrentKeyword , saveTimeNow);
//            System.out.println(map.getCurrentMap());


//        myMap.put(saveCurrentKeyword,saveTimeNow);
//        System.out.println("This is the content of the Map" + myMap);


                /** Map End **/


//        List<Pair<String, String>> data = new ArrayList();
//        Pair<String, String> item = new Pair(saveCurrentKeyword, saveTimeNow);
//        data.add(item);
//
//        System.out.println("This is the item list: " + item);


//        Map<String, List<String>> map = new LinkedHashMap<>();
//        PopulateMap.put(map, saveCurrentKeyword, saveTimeNow);
//
//
//        System.out.println(map.entrySet()); // prints {R1=[Data1, Data3], R2=[Data2, Data4]}

//        ArrayList<String, String> arraylist = new ArrayList<String, String>();
////String value is stored in array list
//        arraylist.add("Test String");


                /***/

//        ArrayList<LinkedHashMap<String,String>> list = new ArrayList<LinkedHashMap<String, String>>();
//
//        LinkedHashMap<String, String> test = new LinkedHashMap<String, String>();
//        test.put(saveCurrentKeyword, saveTimeNow);
//
//
//        list.add(test);
//
//        for(Map<String, String> map : list){
//            for(String key : map.keySet()){
//                System.out.println("key: " + key + " value " + map.get(key));
//            }
//        }

                /***/


//
//        ArrayList<String> keywordSearch = new ArrayList<String>();
//
//        keywordSearch.add(saveCurrentKeyword);
//
//
//        Set<String> s = new HashSet<>();
//
//        for(String name: keywordSearch){
//
//            if(s.add(name) == false){
//                System.out.println("uuuy"  + name);
//
//        } else{
//
//                System.out.println("ok");
//            }
//
//        }


//        checker() stat = new checker();
//        emplist.add(saveCurrentKeyword);


//


//
////        Map<List<String>, List<String>> nomap = new HashMap<List<String>, List<String>>();
//        PopulateMap mapper = new PopulateMap();
//
                //PopulateMap.getResults(saveCurrentKeyword, saveTimeNow);
//


//        ArrayList<String> roster = new ArrayList<String>();
//
////    roster.add(keywordSearch);
//
//        List<String> list = new ArrayList<String>();
//
//        list.add(saveCurrentKeyword);
//
//        roster.addAll(list);
//        System.out.println("Updated ArrayList Elements: "+roster);


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
//                writerTwo.write(",");
//                writerTwo.write(saveTimeNow.toString());

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
//                writerTwo.write(",");
//                writerTwo.write(saveTimeNow.toString());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }



              /****************************************************************************************************/



                BufferedReader br3 = new BufferedReader(new FileReader("DataThree.txt"));
                if (br3.readLine() == null) {
                    System.out.println("No errors, and file empty");

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

                else {

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


              /*****************************************************************************************************/











//                Scanner scan = new Scanner(new File("Data.txt"));
//        ArrayList<String[]> records = new ArrayList<String[]>();
//        String[] record = new String[2];
//        while(scan.hasNext())
//        {
//            record = scan.nextLine().split("\\s*,\\s*");
//            records.add(record);
//        }
//        //now records has your records.
//        //here is a way to loop through the records (process)
//        for(int i = 0; i < records.size(); i++)
//        {
//            for(int j = 0; j < records.get(i).length; j++)
//            {
//                System.out.print(records.get(i)[j] + " ");
//            }
//            System.out.print("\n");
//        }


//       ArrayList<String> name = new ArrayList<String>();
//        System.out.println(name.size());
//
//        //Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println("Please enter search keyword: ");
//            name.add(saveCurrentKeyword);
//
//
//
//        }



//                // Using enhanced for loop(for-each) for iteration
//                for (String i : myList) {
//
//                    // Print all elements of ArrayList
//                    System.out.println(i);
//                }




            }  else if (name.equals(terminateS)){
                System.out.print("\n");
                System.out.println("You have entered an invalid search keyword");
                System.out.print("\n");
                System.out.println("<-----------------------------Terminating Search Program----------------------------->");
                System.out.print("\n");



                /*****************************************************************************************************/




                /*****************************************************************************************************/

                System.out.println("<---------------Search History From Java Collection------------->");
                System.out.print("\n");

                int length = keyword5.size();
                if (length != keyword6.size()) { // Too many names, or too many numbers
                    // Fail
                }
                ArrayList<String> array3 = new ArrayList<String>(length); // Make a new list
                for (int i = 0; i < length; i++) { // Loop through every name/phone number combo
                    array3.add(keyword5.get(i) + " " + keyword6.get(i)); // Concat the two, and add it
                }

                System.out.println(array3);
                System.out.print("\n");
                System.out.println("<-----------End of Search History From Java Collection------------>");
                System.out.print("\n");




                /*********************************************************************************************************/



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



                /*****************************************************************************************************/














//                List<String> placeHolderList = keyword5;
//                List<String> valueList = keyword6;
//
//                Map<String, String> result2 = IntStream.range(0, placeHolderList.size())
//                        .collect(HashMap::new,
//                                (map, i) -> map.put(placeHolderList.get(i), valueList.get(i)),
//                                Map::putAll);
//
//                System.out.println(result2);




                // reading text file into List in Java 7
                List<String> lines = Collections.emptyList();
                /** This is where we are calling the arraylist located in the current memroy of the program, stored in a collection  **/
                lines = keyword5;

//                    lines = Files.readAllLines(Paths.get("DataTwo.txt"), StandardCharsets.UTF_8);
//            System.out.println("The frequency of the word code is: "+
//                    Collections.contains("fitness");


                Map<String, Integer> result = lines.parallelStream().
                        flatMap(s -> Arrays.asList(s.split(",")).stream()).
                        collect(Collectors.toConcurrentMap(
                                w -> w.toLowerCase(), w -> 1, Integer::sum));

                System.out.print("\n");
                System.out.print("The number of searches you have executed: " + keyword5.size());
                System.out.print("\n");
                System.out.println("This is the frequency of searches for each keyword:  " + result);
                System.out.print("\n");

                /** This is getting the most frequently searched keyword  **/
                System.out.println("Most frequently searched keyword: "+ Collections.max(result.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey()) ;
                System.out.print("\n");
                // result.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

                /** Printing out the Arraylist from memory , once program is terminated, data is cleared **/
                System.out.println("These are the most up to date searches from Java Collection: " + lines);
                System.out.print("\n");











                break;
            }









        }






        System.out.println(keyword5);




















        /**This is the last pne **/
    }




//public void checker {
//
//
//    List<String> emplist = new ArrayList<>();
//
//
//
//
//
//    System.out.println(emplist);
//
//    List<String> newList = new ArrayList<>();
//
//    for(String emp: emplist){
//        if(!newList.contains(emp)){
//            newList.add(emp);
//        }
//    }
//
//
//
//
//}










}
