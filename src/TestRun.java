/**
 * Created by Rob on 1/26/2017.
 */
public class TestRun {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";

        boolean even = ((231 %2) == 0);
        if (even = true) {
            System.out.println("it's even");
        }
        System.out.println("odd");

        int y = 0;
        int x = 0;
        boolean moop = (y > 0) && (1 > x++);
        if (moop == true)











        if(str1 == str2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        int year = 0;
        double balance = 10000.00;

        while (balance < 20000.00) {
            balance = balance + (balance * 0.05);
            year++;
            System.out.println(year + ":" + balance);
        }

        System.out.println(addTax(10, 7.5));
        System.out.println(39 + 3);


    }

    public static double addTax(double price, double rate) {
        double tax = price * rate / 100;
        price = price + tax;

        return price;
    }
}
