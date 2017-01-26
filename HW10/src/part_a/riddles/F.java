package riddles;

/**
 * Created by jonathangescheit on 1/26/17.
 */
public class F implements Comparable<F>{
    int int1;
    int int2;
    String string;

    F(int int1, int int2) {
        this.int1 = int1;
        this.int2 = int2;
    }

    F(int int1, String string) {
        this.int1 = int1;
        this.string = string;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(F o) {
        return this.int2 - o.int2;
    }
}
