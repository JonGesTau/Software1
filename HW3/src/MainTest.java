import java.util.Arrays;

/**
 * Created by JonathanGescheit on 11/19/16.
 */
public class MainTest {
    public static void main (String[] args) {
        int[] array = {1,2,-3,4,5};
        int result = ArrayUtils.alternateSum(array);

        System.out.println(result);
//        System.out.println(Arrays.toString(result));
//        System.out.println(Arrays.toString(array));
    }
}
