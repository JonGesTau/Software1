/**
 * Print string if ASCII value is even.
 */
public class Assignment02Q01Sec01 {
    public static void main(String[] args) {
        // Loop over the arguments
        for (String string : args) {
            // Convert each string to a character.
            char charValue = string.charAt(0);

            // Get ASCII value.
            int asciiValue = (int) charValue;

            // If the ASCII value is even, print the original string.
            if (asciiValue % 2 == 0) {
                System.out.println(string);
            }
        }
    }
}
