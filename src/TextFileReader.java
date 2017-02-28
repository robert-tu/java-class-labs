import java.io.*;
import java.util.*;

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

public class TextFileReader {

    // Initialize variables
    private static ArrayList<String> gradesList = new ArrayList<String>();
    private static ArrayList<String> excludedList = new ArrayList<String>();
    private static ArrayList<String> sortedList = new ArrayList<String>();
    private static final String FILE_PATH = ".\\src\\students.txt";

    /**
     * Main method
     */
    public static void main(String[] args) {
        try {
            processFile(FILE_PATH); // Execute processFile method
            sortResult(); // Executes sortResults method
            getResult(); // Executes getResultsMethod

        } catch (IOException e) {
            e.printStackTrace(); // Catch any exceptions and print out
        }
    }

    /**
     * reads data from a given file line by line, processes
     * and then prints it out
     *
     * @param fileName the name of the file to be processed
     * @return none
     */
    public static void processFile(String fileName) throws IOException {
        System.out.println("File Name: " + fileName); // Prints the file name location
        FileReader fileReader = new FileReader(fileName); // Creates FileReader object
        BufferedReader bufferedReader = new BufferedReader(fileReader); // Creates BufferedReader object for FileReader
        String line = null; // Sets the line as null initially
        while ((line = bufferedReader.readLine()) != null) { // Read next line while there are more lines
            getLine(line);
        }
    }

    /**
     * processes the given line and split on each space to save into an ArrayList
     * checks for criteria matches and add to appropriate list
     *
     * @param line the line from the file to be processed
     * @return none
     */
    public static void getLine(String line) {
        String[] names = line.split("\\n"); // Reads the line and split on return, then store into String array
        if (line.matches(".*^[A-Z0-9].*")) { // If line contains special character, it is added to exclusion
            excludedList.add(line);
        } else { // If line does not contain special characters, process the names
            for (String name : names) { // Loop through name in each index of the array
                if (name.isEmpty() || name.matches("^\\s+$")) { // If line ie empty or contains just white spaces
                    // Do nothing if line is empty
                } else if (Character.isLetter(name.charAt(0))) { // Checks to see that the first character of the array is a letter
                    String[] students = line.split("\\s"); // Reads the line and split on space
                    if (students.length > 1) { // Checks to see if the line contains more than just the name by seeing if more than 1 index
                        gradesList.add(getStudentAverage(students)); // Add to Grades List after getting the average grades of the student
                    } else { // If line only has 1 index then also add to Exclusion List
                        excludedList.add(name);
                    }
                } else { // If line does not start with a letter, then also add to exclusion list
                    excludedList.add(name);
                }
            }
        }
    }

    /**
     * calculates student averages from ArrayList if line is in the proper format
     *
     * @param array the line from the text file saved as an array
     * @return the name and average if there are any scores
     */
    public static String getStudentAverage(String[] array) {
        String name = array[0]; // Sets student name as index 0 of the array
        int count = 0; // Start the count as 0 for dividing later, if necessary
        double totalGrade = 0.0; // Initialize grade as 0 for calculation
        for (int x = 1; x < array.length; x++) {
            if (array[x].isEmpty()) {
                // Do nothing if name array has empty string
            } else {
                count++;
                try {
                    totalGrade = totalGrade + Double.parseDouble(array[x]); // Calculate grade by reading from array index 1 and beyond
                } catch (NumberFormatException ne) { // Catch any exceptions if cannot perform grade calculation
                    System.out.println("Warning: Invalid characters for: " + name + ", on grade: " + array[x]);
                }
            }
        }
        if (count != 0) { // As long as there was calculation done, return student's name plus their grade average string
            return name + " " + totalGrade / count;
        } else {
            return name;
        }
    }

    /**
     * compares the averages of each student and place them in correct order in ArrayList
     *
     * @return sorted ArrayList
     */
    public static ArrayList<String> sortResult() {
        for (String grade : gradesList) { // Loop through each grade in the gradeList
            if (sortedList.size() == 0) { // Checks the list to see if any entry, if no entries then add grade as index
                sortedList.add(grade);
            } else { // If already an index in the list, then perform comparison
                // Loop while x as index is less than size of list
                // Each comparison will always reset to 0 in order to compare the first index
                for (int x = 0; x < sortedList.size(); x++) {
                    String gradeList = sortedList.get(x); // set grade as index 0 initially
                    // Since student name and average were stored as 1 String, obtain the number only by splitting on the space between
                    Double currentGrade = Double.valueOf(grade.split("\\s")[1]); // Set current grade by splitting String on space between name and grade
                    Double sortedGrade = Double.valueOf(gradeList.split("\\s")[1]); // Set existing grade by splitting String on space between
                    if (currentGrade >= sortedGrade && x == sortedList.size() - 1) { // Is current grade more than existing grade and are we at the end of the list?
                        sortedList.add(x + 1, grade); // If true, then add the grade behind existing sorted grade
                        break; // Exit the loop
                    } else if (currentGrade <= sortedGrade) { // If the current grade is less than sorted grade, then add in front
                        sortedList.add(x, grade); // Add to start of the array
                        break;
                    }
                }
            }
        }
        return sortedList; // return the final sorted list of students

    }

    /**
     * prints the result from various ArrayLists by calling ArrayList methods
     */
    public static void getResult() {

        // Prints sorted average by looping through the sortedList
        System.out.println("Sorted grade averages:");
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
        }
        System.out.println("\nMIN: " + sortedList.get(0)); // Prints minimum grade by calling the 1st index
        System.out.println("MAX: " + sortedList.get(sortedList.size() - 1)); // Prints maximum grade by calling the last index

        // Prints excluded entries by looping through the excludedList
        System.out.println("\nExcluded Entries:");
        for (int i = 0; i < excludedList.size(); i++) {
            System.out.println(excludedList.get(i));
        }

    }

}
