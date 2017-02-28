import java.util.Scanner;

/**
 * Class: CIS35A Java Programming
 * Instructor: Victor Yu
 * Description: Write a program that converts temperature from Celsius to Fahrenheit or vice versa, depending on user's input.
 * Due: 1/24/2017, 8:00 PM PST
 * I pledge by honor that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Sign here: Tsao-Hsiang (Robert) Tu
 */
public class TemperatureConverter {

    // Main method
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter \"F\" to convert from Celsius to Fahrenheit or enter \"C\" to convert from Fahrenheit to Celsius");
        String input = reader.nextLine();
        if (input.equals("F")) {
            Scanner readerF = new Scanner(System.in);
            System.out.println("Enter the temperature in Celsius");
            double temp = readerF.nextDouble();
            celsiusToFarenheit(temp);
        } else if (input.equals("C")) {
            Scanner readerC = new Scanner(System.in);
            System.out.println("Enter the temperature in Fahrenheit");
            double temp = readerC.nextDouble();
            fahrenheitToCelsius(temp);
        } else {
            System.out.println("Invalid input.");
        }
        System.out.println("Below are some temperature conversions: ");
        fahrenheitToCelsius(75);
        celsiusToFarenheit(20.9);
        fahrenheitToCelsius(40);
        celsiusToFarenheit(40);
        fahrenheitToCelsius(0);
        celsiusToFarenheit(0);
        fahrenheitToCelsius(-23);
    }

    public static double celsiusToFarenheit(double temp) {
        temp = 9.0 / 5.0 * temp + 32.0;
        System.out.printf("Temperature in Fahrenheit is: %.2f\n", temp);
        return temp;
    }

    public static double fahrenheitToCelsius(double temp) {
        temp = 5.0 / 9.0 * (temp - 32);
        System.out.printf("Temperature in Celsius is: %.2f\n", temp);
        return temp;
    }

}
