package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.*;

abstract public class AbstractSpaceship implements Spaceship {
    String name;
    int commisionYear;
    float maximalSpeed;
    Set<? extends CrewMember> crewMembers;
    List<Weapon> weapons;

    private static final int BASE_FIRE_POWER = 10;

    public AbstractSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers) {
        this.name = name;
        this.commisionYear = commissionYear;
        this.maximalSpeed = maximalSpeed;
        this.crewMembers = crewMembers;
    }

    public AbstractSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons) {
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

    public int getFirePower() {
        int result = BASE_FIRE_POWER;
        if (weapons != null) {
            for (Weapon weapon : weapons) {
                result += weapon.getFirePower();
            }
        }

        return result;
    }

    public Set<? extends CrewMember> getCrewMembers() {
        return crewMembers;
    }

    public int getAnnualMaintenanceCost() {
        return 0;
    }

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

    public String getWeaponArrayString() {
        String[] result = new String[weapons.size()];

        for (int i = 0; i < weapons.size(); i++) {
            Weapon weapon = weapons.get(i);

            result[i] = weapon.toString();
        }

        return Arrays.toString(result);
    }

    public String toString(Map<String, String> params) {
        String result = getClass().getSimpleName() + "\n";
        Map<String, String> printValues = new LinkedHashMap<>();

        printValues.put("Name", getName());
        printValues.put("CommissionYear", String.valueOf(getCommisionYear()));
        printValues.put("MaximalSpeed", String.valueOf(getMaximalSpeed()));
        printValues.put("FirePower", String.valueOf(getFirePower()));
        printValues.put("CrewMembers", String.valueOf(getCrewMembers().size()));
        printValues.put("AnnualMaintenanceCost", String.valueOf(getAnnualMaintenanceCost()));

        printValues.putAll(params);

        for (Map.Entry<String, String> entry : printValues.entrySet())
        {
            String field = entry.getKey();
            String value = entry.getValue();

            result += ("\t" + field + "=" + value + "\n");
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
