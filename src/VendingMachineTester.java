import java.util.Scanner;

/**
 * Class: CIS35A Java Programming
 * Instructor: Victor Yu
 * Description: Write a program that simulates a vending machine.
 *              Vending machine sells 3 types of food:
 *              1. Chips - $1.25
 *              2. Cookies $0.85
 *              3. Candies $0.95
 *
 * Due: 2/9/2017, 8:00 PM PST
 * I pledge by honor that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Sign here: Tsao-Hsiang (Robert) Tu
 */

public class VendingMachineTester {
    // Initialize different coins
    static int quarter = 25;
    static int dime = 10;
    static int nickel = 5;

    /** Main method */
    public static void main(String[] args) {
        // Initialize quantity of each vending machine items
        int chipsQty = 1;
        int cookiesQty = 1;
        int candiesQty = 1;
        // Initialize price of each vending machine item
        int chipsPrice = 125;
        int cookiesPrice = 85;
        int candiesPrice = 95;
        // Create Scanner object to read user inputs
        Scanner reader = new Scanner(System.in);
        // Prints vending machine title
        System.out.println("-----------------------------");
        System.out.println("Welcome to My Vending Machine");
        System.out.println("-----------------------------");
        // Asks the user to put in their coins
        System.out.println("Please put your money in: ");
        // Asks for number of quarters
        System.out.println("How many quarters?");
        int numOfQuarters = reader.nextInt();
        // Asks for number of dimes
        System.out.println("How many dimes?");
        int numOfDimes = reader.nextInt();
        // Asks for number of nickels
        System.out.println("How many nickels?");
        int numOfNickels = reader.nextInt();
        // Calculates total amount by adding the coins
        int money = (quarter * numOfQuarters) + (dime * numOfDimes) + (nickel * numOfNickels);

        System.out.println("-----------------------------");
        System.out.println("         PROCESSING");
        System.out.println("-----------------------------");
        // Display the number of coins the user put and how much total money is in the machine
        System.out.println("You put in " + numOfQuarters + " quarters, " + numOfDimes + " dimes, and " + numOfNickels + " nickels.");
        // Formats display to show decimals since money is an int
        System.out.printf("Current value: $%.2f\n", money / 100.0);
        // Prints vending machine menu
        //printMenu();
        //
        System.out.println("-----------------------------");
        System.out.println("Food    | Quantity  | Price");
        System.out.println("-----------------------------");
        System.out.printf("Chips   |        %2d | $%4.2f\n", chipsQty, chipsPrice / 100.0);
        System.out.println("-----------------------------");
        System.out.printf("Cookies |        %2d | $%4.2f\n", cookiesQty, cookiesPrice / 100.0);
        System.out.println("-----------------------------");
        System.out.printf("Candies |        %2d | $%4.2f\n", candiesQty, candiesPrice / 100.0);
        System.out.println("-----------------------------");
        System.out.println("Please make your selection: ");
        System.out.println("Type \"1\" for Chips, \"2\" for Cookies, \"3\" for Candies");
        // Asks for user selection and reads input
        int selection = reader.nextInt();
        while (chipsQty > 0 || cookiesQty > 0 || candiesQty > 0) {
            // If user enters "1" they will buy chips
            if (selection == 1 && chipsQty != 0) {
                System.out.println("You selected chips");
                money = money - chipsPrice;
                System.out.printf("change: %.2f\n", money / 100.0);
                calculateChange(money);
                chipsQty--;
                System.out.println("chips left: " + chipsQty);
                // If user selects "2" then they will buy cookies
            } else if (selection == 2 && cookiesQty != 0) {
                money = money - cookiesPrice;
                System.out.printf("change: %.2f\n", money / 100.0);
                calculateChange(money);
                cookiesQty--;
                System.out.println("cookies left: " + cookiesQty);
                // If user selects "3" then they will buy candies
            } else if (selection == 3) {
                money = money - candiesPrice;
                System.out.printf("change: %.2f\n", money / 100.0);
                calculateChange(money);
                System.out.println("candies left: " + candiesQty);
                // If user enters anything else then it will prompt invalid
            } else {
                System.out.println("Invalid selection");
            }
        }
        System.out.println("All items are sold out.");
    }

    public static void printMenu() {
        // Initialize quantity of each vending machine items
        int chipsQty = 1;
        int cookiesQty = 1;
        int candiesQty = 1;
        // Initialize price of each vending machine item
        double chipsPrice = 1.25;
        double cookiesPrice = 0.85;
        double candiesPrice = 0.95;
        // Prints vending machine menu
        System.out.println("-----------------------------");
        System.out.println("Food    | Quantity  | Price");
        System.out.println("-----------------------------");
        System.out.printf("Chips   |        %2f | $%4.2f\n", chipsQty, chipsPrice);
        System.out.println("-----------------------------");
        System.out.printf("Cookies |        %2f | $%4.2f\n", cookiesQty, cookiesPrice);
        System.out.println("-----------------------------");
        System.out.printf("Candies |        %2f | $%4.2f\n", candiesQty, candiesPrice);
        System.out.println("-----------------------------");
        System.out.println("Please make your selection: ");
        System.out.println("Type \"1\" for Chips, \"2\" for Cookies, \"3\" for Candies");
    }

    public static void calculateChange(int money) {
        double change = Math.round(money * 100.0) / 100.0;
        // Calculate number of quarters
        int numQuarters = (int) (change / quarter);
        System.out.println("quarters:" + numQuarters);
        // Set money as remainder after counting quarters
        change = change % quarter;
        // Calculate number of dimes
        int numDime = (int) (change / dime);
        System.out.println("dimes: " + numDime);
        // Set money as remainder after counting dimes
        change = change % dime;
        // Calculate number of nickels
        int numNickel  = (int) (change / nickel);
        System.out.println("nickels: " + numNickel);
        // Set money as remainder after nickels
        change = change % nickel;

    }


    // Test Cases (Repeat for all foods)
    // Buyer selects a food that is available, and inserts the exact amount as the price
    // Buyer selects a food that is in stock, and inserts less money than the price
    // Buyer selects a food that is in stock, and inserts more money than the price
    // Buyer selects a food that is sold out
    // Buyer selects a food that does not exist


}
