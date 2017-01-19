package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CylonRaider extends AbstractSpaceship {
	private static int instances = 0;

	private static final int MAINTENANCE_COST_PER_YEAR = 3000;
	private static final int MEMBER_COST = 500;
	private static final int ENGINE_COST = 1000;

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		instances++;
	}

	public int getAnnualMaintenanceCost() {
		return MAINTENANCE_COST_PER_YEAR + Math.round(ENGINE_COST * maximalSpeed) + MEMBER_COST * crewMembers.size() +  + getWeaponsCost();
	}

	@Override
	public String toString() {
		Map<String, String> params = new HashMap<>();
		params.put("WeaponArray", getWeaponArrayString());

		return super.toString(params);
	}

	public static int getInstances() {
		return instances;
	}
}
