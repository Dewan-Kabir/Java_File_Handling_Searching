import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadAndSort {


    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(new File("Data.txt"));
//        List<String> lines = new ArrayList<String>();
//        while (sc.hasNextLine()) {
//            lines.add(sc.nextLine());
//        }
//
//        String[] arr = lines.toArray(new String[0]);
//        System.out.println(arr);



//        BufferedReader abc = new BufferedReader(new FileReader("Data.txt"));
//        List<String> lines = new ArrayList<String>();
//        String line ;
//
//        while(( line = abc.readLine()) != null) {
//            lines.add(line);
//
//        }
//        abc.close();
//
//        System.out.println(lines.size());
//
//// If you want to convert to a String[]
//        String[] data = lines.toArray(new String[]{});



        /** This is the preferred one  **/
//        File txt = new File("Data.txt");
//        Scanner scan = new Scanner(txt);
//        ArrayList<String> data = new ArrayList<String>() ;
//        while(scan.hasNextLine()){
//            data.add(scan.nextLine());
//        }
//        System.out.println(data);
//        String[] simpleArray = data.toArray(new String[]{});





//        Scanner scan = new Scanner(new File("Data.txt"));
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
//
//        System.out.println(records.contains("fitness"));


//        String line = "";
//        String splitBy = "\\s*,\\s*";
//        try
//        {
////parsing a CSV file into BufferedReader class constructor
//            BufferedReader br = new BufferedReader(new FileReader("Data.txt"));
//            while ((line = br.readLine()) != null)   //returns a Boolean value
//            {
//                String[] employee = line.split(splitBy);    // use comma as separator
//                System.out.println(employee[0]);
//            }
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }



        //System.out.println("Requested Data for matching Keywords: " + readData() );






//        String fileName = "src/resources/thermopylae.txt";
//
//        try (InputStream fis = new FileInputStream("Data.txt");
//             InputStreamReader isr = new InputStreamReader(fis,
//                     StandardCharsets.UTF_8);
//             BufferedReader br = new BufferedReader(isr)) {
//
//            br.lines().forEach(line -> System.out.println(line));
//        }




//        Scanner scan = new Scanner(new File("DataTwo.txt"));
//        ArrayList<String[]> records = new ArrayList<String[]>();
//        String[] record = new String[2];
//        while(scan.hasNext())
//        {
//            record = scan.nextLine().split(",");
//            records.add(record);
//        }
////now records has your records.
////here is a way to loop through the records (process)
//        for(String[] temp : records)
//        {
//            for(String temp1 : temp)
//            {
//                System.out.print(temp1 + " ");
//            }
//            System.out.print("\n");
//        }



//            String fileName= "DataTwo.txt";
//            File file= new File(fileName);
//
//            // this gives you a 2-dimensional array of strings
//            List<List<String>> lines = new ArrayList<>();
//            Scanner inputStream;
//
//            try{
//                inputStream = new Scanner(file);
//
//                while(inputStream.hasNext()){
//                    String line= inputStream.next();
//                    String[] values = line.split(",");
//                    // this adds the currently parsed line to the 2-dimensional string array
//                    lines.add(Arrays.asList(values));
//
//
//                }
//
//
//
//                inputStream.close();
//            }catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//
//
//
//            // the following code lets you iterate through the 2-dimensional array
//            int lineNo = 1;
//            for(List<String> line: lines) {
//                int columnNo = 1;
//                for (String value: line) {
//                    System.out.println("Line " + lineNo + " Column " + columnNo + ": " + value);
//                    columnNo++;
//                }
//                lineNo++;
//            }




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









































//    public static List<String[]> readData() throws IOException {
//        int count = 0;
//        String file = "Data.txt";
//        List<String[]> content = new ArrayList<>();
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String line = "";
//            while ((line = br.readLine()) != null) {
//                content.add(line.split(","));
//
//
//            }
//
//        } catch (FileNotFoundException e) {
//            //Some error logging
//        }
//        for (String[] item : content) {
//            System.out.println(Arrays.toString(item));
//
//            //String[] both = ArrayUtils.addAll(first, second);
//
//            //content.addAll(String[item] );
//
//
//            if (Arrays.toString(item).contains("fitness")) {
//                System.out.println("OK");
//
//            }
//
//
//        }
//
//        return content;
//    }




//        Arrays.stream(content)
//                .collect(Collectors.groupingBy(s -> s))
//                .forEach((k, v) -> System.out.println(k+" "+v.size()));





//        for (String[] s : content) {
//            Map<String, Integer> wordCounts = new HashMap<String, Integer>();
//
//            for (String word : s) {
//                Integer counter = wordCounts.get(word);
//                if (counter == null) {
//                    counter = 0;
//                }
//                wordCounts.put(word, count + 1);
//            }
//            for (String key : wordCounts.keySet()) {
//                System.out.println(key + ": " + wordCounts.get(key).toString());
//            }
//        }


//        Set<String[]> unique = new HashSet<String[]>(content);
//        for (String[] key : unique) {
//            System.out.println(key + ": " + Collections.frequency(content, key));
//        }

//        System.out.println("The frequency of the word code is: "+
//                Collections.frequency(Arrays.asList(content), "fitness"));

        //System.out.println((Arrays.stream(content.get(1))));
//        List<String[]> s = Arrays.toString(content);




}








//    public static List<String[]> get(String filename) {
//        List<String[]> data = new ArrayList<String[]>();
//        String testRow;
//        try {
//            // Open and read the file
//            BufferedReader br = new BufferedReader(new FileReader(filename));
//            // Read data as long as it's not empty
//            // Parse the data by comma using .split() method
//            // Place into a temporary array, then add to List
//            while ((testRow = br.readLine()) != null) {
//                String[] line = testRow.split(",");
//                data.add(line);
//
//
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("ERROR: File not found " + filename);
//        } catch (IOException e) {
//            System.out.println("ERROR: Could not read " + filename);
//        }
//
//        System.out.println(data.get(0));
//        return data;
//    }
//}






