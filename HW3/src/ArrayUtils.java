import java.util.Arrays;

/**
 * Array Utilities
 * @author Jonathan Gescheit
 */
public class ArrayUtils {

    /**
     * Increment the i'th element by i. Doesn't change the original array.
     * @param array the given array
     * @return the new array.
     */
    public static int[] incArray (int[] array) {
        int[] result = Arrays.copyOf(array, array.length);

        for (int i = 0; i < result.length; i++) {
            result[i] += i;
        }

        return result;
    }

    /**
     * Create a new array where every element is the sum of 2 items of the given array.
     * @param array given array.
     * @return the new array.
     */
    public static int[] sumArray (int[] array) {
        // Calculate the result array's size and then convert to int.
        Double d = new Double(Math.ceil((double)array.length / 2));
        int arrayLength = d.intValue();
        int[] result = new int[arrayLength];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            boolean isIndexOdd = i % 2 != 0;

            // If the index is odd, sum the 2 last items and increment index.
            if (isIndexOdd) {
                result[index] = array[i-1] + array[i];
                index++;
            } else if (i == array.length - 1) {
                // If the array's length is odd, assign the last item in array as the result's last item.
                result[index] = array[i];
                break;
            }
        }

        return result;
    }

    /**
     * Return the minimal alternating sum.
     * @param array the given array.
     * @return the minimal alternating sum.
     */
    public static int alternateSum(int[] array) {
        int min = 0;

        for (int i = 0; i < array.length; i++) {
            int sum = array[i];
            int sign = 1;

            for (int j = i+1; j < array.length; j++) {
                // Alternating sign
                sign *= -1;
                sum += sign * array[j];

                // If current sum is smaller than the minimum, set it as the new minimum.
                min = sum < min ? sum : min;
            }
        }

        return min;
    }
}
