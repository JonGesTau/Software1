import java.util.Arrays;

/**
 * String Utilities
 * @author Jonathan Gescheit
 */
public class StringUtils {
    /**
     * Lexicographically sort a string of words.
     * @param str
     * @return the sorted string.
     */
    public static String sortStringWords (String str) {
        String result = "";

        // Create a words array and sort it.
        String[] words = str.split(" ");
        Arrays.sort(words);

        // Construct a string from the words array.
        for (String word : words) {
            result += word + " ";
        }

        return result;
    }

    /**
     * Merge strings and delete all repeating characters.
     * @param a first string
     * @param b second string
     * @return the merged string without duplicates.
     */
    public static String mergeStrings(String a, String b) {
        String usedChars = "";
        String ab = a + b;
        String result = "";

        for (int i = 0; i < ab.length(); i++) {
            char letterChar = ab.charAt(i);
            String letter = String.valueOf(letterChar);

            // If the letter is used somewhere in the string, delete all occurences.
            if (usedChars.indexOf(letter) > -1) {
                result = result.replace(letter, "");
            } else {
                // Else, add the letter to the used characters and to the result string.
                usedChars += letter;
                result += letter;
            }
        }

        return result;
    }

    /**
     * Is a and anagram of b.
     * @param a first string
     * @param b second string
     * @return true if is anagaram, false otherwise.
     */
    public static boolean isAnagram(String a, String b) {
        // Delete all spaces.
        a = a.replace(" ","");
        b = b.replace(" ","");

        // Create an array from the string.
        String[] array1 = a.split("");
        String[] array2 = b.split("");

        // Sort arrays lexicographically.
        Arrays.sort(array1);
        Arrays.sort(array2);

        // Compare the arrays' content.
        return Arrays.equals(array1, array2);
    }
}
