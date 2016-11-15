import java.util.Arrays;

/**
 * Find the bug #2.
 */
public class Assignment02Q05 {
    public static void  main(String[] args) {
        int[] primes = new int[20];
        primes[0] = 2;
        int num = 3;
        int status = 1;
        int index = 1;
        for (int i = 2; i <= 20 ; i++) {
            // START
            for (int j = 2; j <= Math.sqrt(num) ; j++) {
                if (num % j == 0) {
                    status = 0;
                }
            }
            if (status != 0) {
                primes[index] = num;
                index ++;
            }
            i -= status != 0 ? 0 : 1; // Added this line: Repeat iteration if not prime.
            status = 1;
            num += 2; // Changed this line: Increment by 2 instead of by 1.
            // END
        }

        System.out.println(Arrays.toString(primes));
    }
}