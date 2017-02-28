import java.io.*;
import java.util.*;
import java.util.stream.Collector;

/**
 * Class: CIS35A Java Programming
 * Instructor: Victor Yu
 * Description: The purpose of this class is to read data (line-by-line) from a file.
 * Due: 2/23/2017, 8:00 PM PST
 * I pledge by honor that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Sign here: Tsao-Hsiang (Robert) Tu
 */

public class TxtFileReader {

    // Initialize
    private static List list=new ArrayList(50);
    private static List list2=new ArrayList(50);
    private static List list3=new ArrayList(50);
    private static List list4=new ArrayList(50);
    private static List list5=new ArrayList(50);
    private static int min=999;
    private static int max=0;
    private static String minLine=null;
    private static String maxLine=null;
    private static String filePath = ".\\src\\students.txt";

    /**
     * Main method
     */

    public static void main(String[] args) {
        try {
            processFile(filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void processFile(String fileName) throws IOException {
        System.out.println("file name: " + fileName);
        // Create FileReader to read text file
        FileReader fileReader = new FileReader(fileName);
        // BufferedReader for FileReader
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        int start = 0;
        int end = 1;
        int end2 = 1;
        // Loop through the text file while there is content
        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
            //List<String> newList = list2.subList(start, end);
            System.out.println("sublist:" + start + list.subList(start, end) );
            ArrayList<String> sl = new ArrayList<String>(list.subList(start,end));
            System.out.println("sl " + start + sl);

            start++;
            end++;
            getLine(line);
            getGrades(line);
            System.out.println(list2);
            System.out.println(list3);
            System.out.println(list4);
            System.out.println(list5);
            //getTokens(line);
        }
        System.out.println(list2.get(0));
        getGrades((String) list2.get(0));

        // bufferedreader reads in line
        // compute average then store into list


        System.out.println("full list: " + list + " / list size: " + list.size());

        System.out.println("string split list: " + list2 + " / list size: " + list2.size());
        System.out.println("exclusion list: " + list4 + " / list size: " + list4.size());
        System.out.println("exclusion list: " + list5 + " / list size: " + list5.size());

        System.out.println("grades list: " + list3 + " / list size: " + list3.size());


        bufferedReader.close();

    }

    public static void getLine(String line) {
        String[] words = line.split("\n");
        for (String w : words) {
            if (Character.isLetter(w.charAt(0))) {
                list2.add(w);
            } else {
                list4.add(w);
            }
        }
    }

    public static void getGrades(String line) {
        String[] grade = line.split("\\s");
        for (String g:grade) {
                list5.add(g);
            }
        }

    public static int getSum(ArrayList<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum = num + sum;
        }
        return sum;
    }

    public static double getAverage(ArrayList<Integer> list) {
        double average = (double)getSum(list) / list.size();
        return average;
    }



    public static void getTokens(String line) {
        StringTokenizer st = new StringTokenizer(line);
        int count = st.countTokens();//get total tokens in this line

        String firstToken = st.nextToken();
        for (int i = 0; i < firstToken.length(); i++) {
            char ch = firstToken.charAt(i);
            if (Character.isAlphabetic(ch)) {
                list3.add(line);
                return;
            }
        }
    }


}
