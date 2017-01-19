package il.ac.tau.cs.sw1.ex9.starfleet;

public interface Spaceship {
    public String getName();

    public int getCommisionYear();

    public float getMaximalSpeed();

    public int getFirePower();

    public Set<? Extends CrewMember> getCrewMembers();

    public int getAnnualMaintenanceCost();
}
