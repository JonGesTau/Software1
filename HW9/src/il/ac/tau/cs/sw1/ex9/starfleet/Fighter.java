package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Fighter extends AbstractSpaceship {
	private static int instances = 0;

	private static final int MAINTENANCE_COST_PER_YEAR = 2500;
	private static final int ENGINE_COST = 1000;

	public Fighter(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		instances++;
	}

	public int getAnnualMaintenanceCost() {
		return MAINTENANCE_COST_PER_YEAR + Math.round(ENGINE_COST * maximalSpeed) + getWeaponsCost();
	}

	public static int getMaintenanceFixedCost() {
		return MAINTENANCE_COST_PER_YEAR;
	}

	@Override
	public String toString() {
		Map<String, String> params = new HashMap<>();

		return super.toString(params);
	}

	public static int getInstances() {
		return instances - StealthCruiser.getInstances();
	}
}
