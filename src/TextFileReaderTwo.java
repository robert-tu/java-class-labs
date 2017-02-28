// ReadTextFile.java

import java.io.*;
import java.util.*;

/**
 * The purpose of this class is to read data
 * (line-by-line) from a file.
 */
public class TextFileReaderTwo {

  	private static List list=new ArrayList(50);
  	private static int min=999;
  	private static int max=0;
  	private static String minLine=null;
  	private static String maxLine=null;

	/**
	 *  reads data from a given file line by line, processes
	 *  and then prints it out
	 *  @param fileName the name of the file to be processed
	 *  @return none
	 */
  	public static void processFile(String fileName) throws IOException{
            System.out.println("file name: " + fileName);
            BufferedReader in
       		= new BufferedReader(new FileReader(fileName));//read text file

            String line;
            while ( (line = in.readLine()) != null) // reads every line
                getTokens(line);

            //getResult();
        }

	/**
	 *  split a given line into several token
	 *
	 *  @param line the line to be split
	 *  @return none
	 */
	public static void getTokens(String line){
           StringTokenizer st = new StringTokenizer(line);
           int count = st.countTokens();//get total tokens in this line

           String firstToken=st.nextToken();
           for(int i=0; i < firstToken.length(); i++){
               char ch=firstToken.charAt(i);
               if(Character.isDigit(ch)){
                  list.add(line);
                  return;
               }
           }

 	   // code to process and print out the result
        }

        // other methods ...

}
