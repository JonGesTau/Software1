/**
 * Count in how many strings does a character appear.
 */
public class Assignment02Q03 {
    public static void main(String[] args) {
        String result = "";
        String usedLetters = "";

        // Create a string containing all the characters used in all strings according to their appeareance order.
        for (String string : args) {
            for (int i = 0; i < string.length(); i++) {
                char letter = string.charAt(i);
                if (usedLetters.indexOf(letter) == -1) {
                    usedLetters += letter;
                }
            }
        }

        // Convert the string to a chars array.
        char[] usedLettersArray = usedLetters.toCharArray();

        // Count in how many strings each letter appears.
        for (char letter : usedLettersArray) {
            int counter = 0;

            for (String string : args) {
                if (string.indexOf(letter) > -1) {
                    counter++;
                }
            }

            result += letter + ":" + counter + '\t';
        }

        System.out.println(result);
    }
}
