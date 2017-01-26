package riddles;

import java.util.Objects;

/**
 * Created by jonathangescheit on 1/26/17.
 */
public class C implements Comparable<C> {
    int int1;
    int int2;
    String string;

    C(int int1, int int2) {
        this.int1 = int1;
        this.int2 = int2;
    }

    C(int int1, String string) {
        this.int1 = int1;
        this.int2 = Integer.parseInt(string);
    }

    @Override
    public boolean equals(Object obj) {
        C other = (C) obj;
        return this.int1 == other.int1 && this.int2 == other.int2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.int1, this.int2);
    }

    @Override
    public int compareTo(C o) {
        return this.int2 - o.int2;
    }
}
