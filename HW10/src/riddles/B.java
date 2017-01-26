package riddles;

import java.util.Objects;

/**
 * Created by jonathangescheit on 1/26/17.
 */
public class B {
    int int1;
    int int2;
    String string;

    B(int int1, int int2) {
        this.int1 = int1;
        this.int2 = int2;
    }

    B(int int1, String string) {
        this.int1 = int1;
        this.string = string;
    }

    @Override
    public boolean equals(Object obj) {
        B other = (B) obj;
        return this.int1 == other.int1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.int1);
    }
}
