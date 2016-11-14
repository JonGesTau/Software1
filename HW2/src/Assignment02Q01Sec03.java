/**
 * Print the amount of numbers with an even number mod 6 result.
 */
public class Assignment02Q01Sec03 {
    public static void main(String[] args) {
        int counter = 0;

        // Iterate over the arguments
        for (String string : args) {
            int number = Integer.parseInt(string);
            double mod = number % 6;

            // If mod is even, increase counter by 1, else leave counter as it is.
            counter = mod % 2 == 0 ? ++counter : counter;
        }

        System.out.println(counter);
    }
}
