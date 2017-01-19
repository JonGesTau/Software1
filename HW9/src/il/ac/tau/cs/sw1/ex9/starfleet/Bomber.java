package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bomber extends AbstractSpaceship {
	private int numberOfTechnicians;

	private static int instances = 0;

	private static final int MAINTENANCE_COST_PER_YEAR = 5000;
	private static final double TECH_DISCOUNT = 0.1;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
		instances++;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return (int) Math.round(MAINTENANCE_COST_PER_YEAR + TECH_DISCOUNT * numberOfTechnicians + getWeaponsCost());
	}

	public int getNumberOfTechnicians() {
		return numberOfTechnicians;
	}

	@Override
	public String toString() {
		Map<String, String> params = new HashMap<>();
		params.put("WeaponArray", getWeaponArrayString());
		params.put("NumberOfResearchLabs", String.valueOf(getNumberOfTechnicians()));

		return super.toString(params);
	}

	public static int getInstances() {
		return instances;
	}
}
