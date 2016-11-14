/**
 * Count in how many strings does a character appear.
 */
public class Assignment02Q03 {
    public static void main(String[] args) {
        String result = "";
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        // Iterate over the alphabet
        for (char letter : alphabet) {
            int counter = 0;

            // Iterate over the command line arguments
            for (String string : args) {
                // If the current letter appears in the string, increase counter.
                if (string.indexOf(letter) > -1) {
                    counter++;
                }
            }

            // Add counter to result line if the letter appeared anywhere.
            if (counter > 0) {
                result += letter + ":" + counter + '\t';
            }
        }

        System.out.println(result);
    }
}
