// ReadTextFile.java

/**
 * Class: CIS35A Java Programming
 * Instructor: Victor Yu
 * Description: For this lab, you will read a text file (the name of the file will
 * be passed as an argument to the main() method) and then find the
 * name of the person with the maximum and minimum average.
 * The format of the file, which is comprised of many lines, is:  name grade1 grade2
 * Due: 2/23/2017, 8:00 PM PST
 * I pledge by honor that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Sign here: Tsao-Hsiang (Robert) Tu
 */

import java.io.*;
import java.util.*;

/**
 * The purpose of this class is to read data
 * (line-by-line) from a file.
 */
public class TextFileReaderTester {

    private static List list = new ArrayList(50);
    private static int min = 999;
    private static int max = 0;
    private static String minLine = null;
    private static String maxLine = null;

    public static void main(String[] args) {
        String filePath = "F:\\java\\CIS35A\\src\\students.txt";
        try {
            processFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *  reads data from a given file line by line, processes
     *  and then prints it out
     *  @param fileName the name of the file to be processed
     *  @return none
     */
    public static void processFile(String fileName) throws IOException {
        System.out.println("file name: " + fileName);
        BufferedReader in = new BufferedReader(new FileReader(fileName));//read text file

        String line;
        while ((line = in.readLine()) != null) // reads every line
            getTokens(line);

        displayResult();
    }

    /**
     *  split a given line into several token
     *
     *  @param line the line to be split
     *  @return none
     */
    public static void getTokens(String line) {
        StringTokenizer st = new StringTokenizer(line);
        int count = st.countTokens();//get total tokens in this line

        String firstToken = st.nextToken();
        for (int i = 0; i < firstToken.length(); i++) {
            char ch = firstToken.charAt(i);
            if (Character.isAlphabetic(ch)) {
                list.add(line);
                return;
            }
        }

        // code to process and print out the result
    }

    public static void sortResult() {


    }

    // other methods ...
    public static void displayResult() {
        System.out.println(list);
        System.out.println(list.size());
        //displays results
        //MIN: malcom 0
        //MAX: bob 50
        //Excluded Entries:
        //2.4 10 20 george
        //100 jeff


    }

}
