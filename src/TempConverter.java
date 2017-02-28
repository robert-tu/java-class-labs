import java.util.Scanner;

/**
 * Class: CIS35A Java Programming
 * Instructor: Victor Yu
 * Description: Write a program that converts temperature from Celsius to Fahrenheit or vice versa, depending on user's input.
 * Due: 1/26/2017, 8:00 PM PST
 * I pledge by honor that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Sign here: Tsao-Hsiang (Robert) Tu
 */
public class TempConverter {

    /** Main method */
    public static void main(String[] args) {
        Scanner readerF = new Scanner(System.in);
        // Asks user for a temperature to convert from Celsius to Fahrenheit
        System.out.println("Enter a number to convert from Celsius to Fahrenheit:");
        // Reads the next number input by user
        double tempF = readerF.nextDouble();
        // Calculates temperature to Fahrenheit from Celsius
        tempF = 9.0 / 5.0 * tempF + 32.0;
        // Prints the result for the user
        System.out.printf("Temperature: %.2f F%n", tempF);
        Scanner readerC = new Scanner(System.in);
        // Asks user for a temperature to convert from Fahrenheit to Celsius
        System.out.println("Enter a number to convert from Fahrenheit to Celsius:");
        double tempC = readerC.nextDouble();
        // Calculates temperature to Celsius from Fahrenheit
        tempC = 5.0 / 9.0 * (tempC - 32.0);
        // Prints the result for the user
        System.out.printf("Temperature: %.2f C%n ", tempC);
    }
}
