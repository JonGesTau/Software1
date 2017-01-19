package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.*;

public class StealthCruiser extends Fighter {
	public static int numStealthCruisers = 0;

	private static final int CLOACK_COST = 50;

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		numStealthCruisers++;
	}
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers) {
		this(name, commissionYear, maximalSpeed, crewMembers, Arrays.asList(new Weapon("Lase Cannons", 10, 100)));
	}

	public int getAnnualMaintenanceCost() {
		return getMaintenanceFixedCost() + numStealthCruisers * CLOACK_COST;
	}

	@Override
	public String toString() {
		Map<String, String> params = new HashMap<>();
		params.put("WeaponArray", getWeaponArrayString());

		return super.toString(params);
	}

}
