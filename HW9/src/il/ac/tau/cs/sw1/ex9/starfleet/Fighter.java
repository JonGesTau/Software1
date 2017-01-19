package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends AbstractSpaceship {
	private static final int MAINTENANCE_COST_PER_YEAR = 2500;
	private static final int ENGINE_COST = 1000;

	public Fighter(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	public int getAnnualMaintenanceCost() {
		return MAINTENANCE_COST_PER_YEAR + ENGINE_COST * (int) maximalSpeed + getWeaponsCost();
	}

	public static int getMaintenanceFixedCost() {
		return MAINTENANCE_COST_PER_YEAR;
	}
}
