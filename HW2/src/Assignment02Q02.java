import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Convert Fahrenheit to Celsius.
 */
public class Assignment02Q02 {
    public static void main(String[] args) {
        if (args.length > 0) {
            // Use this format to round up to the nearest 1 decimal point.
            DecimalFormat df = new DecimalFormat("#.#");
            df.setRoundingMode(RoundingMode.HALF_DOWN);

            // Iterate over args
            for (String string : args) {
                double fahrenheit = Double.parseDouble(string);
                double celsius = (fahrenheit - 32) / 1.8;

                System.out.println("Fahrenheit: " + fahrenheit + " Celsius: " + df.format(celsius));
            }
        }
    }
}
