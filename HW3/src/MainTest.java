import java.util.Arrays;

/**
 * Created by JonathanGescheit on 11/19/16.
 */
public class MainTest {
    public static void main (String[] args) {
        int[] array1 = {1,2};
        int[] array2 = {3,4};
        int[] array3 = {5,6};

        int[] array4 = {1,1};
        int[] array5 = {2,2};

        int[][] m = {array1, array2, array3};
        int[][] n = {array4, array5};

        int[][] result = ArrayUtils.matrixMultiplication(m, n);

//        System.out.println(Arrays.toString(result));
//        System.out.println(Arrays.toString(array));
    }
}
