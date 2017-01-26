package riddles;

import java.util.Objects;

/**
 * Created by jonathangescheit on 1/26/17.
 */
public class A {
    int int1;
    int int2;
    String string;

    A(int int1, int int2) {
        this.int1 = int1;
        this.int2 = int2;
    }

    A(int int1, String string) {
        this.int1 = int1;
        this.int2 = Integer.parseInt(string);
    }

    @Override
    public boolean equals(Object obj) {
        A other = (A) obj;
        return this.int1 == other.int1 && this.int2 == other.int2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.int1, this.int2);
    }
}
