package riddles;

import java.util.Objects;

/**
 * Created by jonathangescheit on 1/26/17.
 */
public class D implements Comparable<D>{
    int int1;
    int int2;
    String string;

    D(int int1, int int2) {
        this.int1 = int1;
        this.int2 = int2;
    }

    D(int int1, String string) {
        this.int1 = int1;
        this.string = string;
    }

    @Override
    public boolean equals(Object obj) {
        D other = (D) obj;
        return this.int1 == other.int1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.int1);
    }

    @Override
    public int compareTo(D o) {
        return this.int1 - o.int1;
    }
}
