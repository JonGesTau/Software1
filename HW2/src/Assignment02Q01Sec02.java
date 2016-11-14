/**
 * Created by JonathanGescheit on 11/14/16.
 */
public class Assignment02Q01Sec02 {
    public static void main(String[] args) {
        double max = 0;
        double almostMax = 0;

        // Iterate over the arguments
        for (String string : args) {
            double d = Double.parseDouble(string);

            // If the current number is larger than the max, make the current max almostMax and make the new number king.
            if (d > max) {
                almostMax = max;
                max = d;
            } else if (d > almostMax) {
                // If the number isn't larger than max, but is larger than almostMax, make him almostMax.
                almostMax = d;
            }
        }
        
        System.out.println(max);
        System.out.println(almostMax);
    }
}
