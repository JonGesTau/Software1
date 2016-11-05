/**
 * HW1 - If the num1 id divisible by num2 without remainder, print the result of the division.
 * If there's a remiainder, the remainder will be printed as well.
 */
public class Assignment1 {
    public static void main(String[] args) {
        // Initialize arguments
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);

        // If num2 is 0, don't divide and let the user know it's impossible to divide.
        if (num2 == 0) {
            System.out.print("Cannot perform zero division!");
        } else {
            // Given a valid num2
            int result = num1 / num2;
            int remainder = num1 % num2;

            if (remainder == 0) {
                System.out.println("The division result is: " + result);
            } else {
                System.out.println("The division result is: " + result + ", remainder is: " + remainder);
            }
        }
    }
}
