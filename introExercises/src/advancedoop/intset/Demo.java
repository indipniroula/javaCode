package advancedoop.intset;

import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static IntSet readIntegers(int n) throws IOException {
        Scanner scanner = new Scanner(System.in);
        IntSet result;

        if (n > 10) {
            result = new MemoryEfficientIntSet();

            while (n > 0) {
                System.out.println("Please enter an int: ");
                result.add(scanner.nextInt());
                n--;
            }
            scanner.close();
            return result;

        } else {
            result = new SpeedEfficientIntSet();

            while (n > 0) {
                System.out.println("Please enter an int: ");
                result.add(scanner.nextInt());
                n = n -1;
            }
            scanner.close();
            return result;

        }
    }

    public static void main(String[] args) throws IOException {
        IntSet set = readIntegers(2);
        System.out.println("Set is " + set);

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter int to be tested for membership: ");
            int intTest = 2;
            System.out.print("Set contains " + intTest + ": " +
                    (set.contains(intTest) ? "True" : "False")) ;
        } while (scanner.hasNextInt());

    }

}
