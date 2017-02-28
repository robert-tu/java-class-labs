/**
 * Created by Rob on 2/2/2017.
 */
public class DoubleInvestment {

    public static void main(String[] args) {
        final double RATE = 2.01;
        final double INITIAL_BAL = 25000;
        final double TARGET = 2 * INITIAL_BAL;

        double balance = INITIAL_BAL;
        int year = 0;

        while (balance < TARGET) {
            double interest = balance * RATE / 100;
            balance = balance + interest;
            year++;
            System.out.printf("Year: %d, ", year);
            System.out.printf("Balnce: $%.2f\n", balance);
        }
        System.out.println("Investment doubled in: " + year + " years.");
    }
}
