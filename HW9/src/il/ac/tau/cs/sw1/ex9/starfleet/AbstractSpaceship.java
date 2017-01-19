package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Map;
import java.util.Set;

abstract public class AbstractSpaceship implements Spaceship {
    String name;
    int commisionYear;
    float maximalSpeed;
    Set<CrewMember> crewMembers;
    private List<Weapon> weapons;

    public AbstractSpaceship(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers) {
        this.name = name;
        this.commisionYear = commissionYear;
        this.maximalSpeed = maximalSpeed;
        this.crewMembers = crewMembers;
    }

    public AbstractSpaceship(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
        this.name = name;
        this.commisionYear = commissionYear;
        this.maximalSpeed = maximalSpeed;
        this.crewMembers = crewMembers;
        this.weapons = weapons;
    }

    public String getName(){
        return name;
    }

    public int getCommisionYear() {
        return commisionYear;
    }

    public float getMaximalSpeed() {
        return maximalSpeed;
    }

    public int getFirePower();

    public Set<CrewMember> getCrewMembers() {
        return crewMembers;
    }

    public int getAnnualMaintenanceCost();

    public List<Weapon> getWeapon() {
        return weapons;
    }

    public int getWeaponsCost() {
        int cost = 0;
        for (Weapon weapon : weapons) {
            cost += weapon.getAnnualMaintenanceCost();
        }

        return cost;
    }

    public toString(Map<String, String> params) {
        Map<String, String> printValues = new Map<>();

        printValues.put("Name", getName());
        printValues.put("CommissionYear", String.valueOf(getCommisionYear()));
        printValues.put("MaximalSpeed", String.valueOf(getMaximalSpeed()));
        printValues.put("FirePower", String.valueOf(getFirePower()));
        printValues.put("CrewMembers", String.valueOf(getCrewMembers()));
        printValues.put("AnnualMaintenanceCost", String.valueOf(getAnnualMaintenanceCost()));

        printValues.putAll(params);

        for (Map.Entry<String, String> entry : printValues.entrySet())
        {
            String field = entry.getKey();
            String value = entry.getValue();

            System.out.println("\t" + field + "=" + value);
        }
    }
}
