package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;

/**
 * Created by JonathanGescheit on 1/19/17.
 */
public class FirePowerAndCommissionYearComparator implements Comparator<Spaceship> {
    @Override
    public int compare(Spaceship o1, Spaceship o2) {
        return o1.getFirePower() != o2.getFirePower() ? o2.getFirePower() - o1.getFirePower() :
                o1.getCommisionYear() != o2.getCommisionYear() ? o2.getCommisionYear() - o1.getCommisionYear() :
                        o1.getName().compareTo(o2.getName());
    }
}
