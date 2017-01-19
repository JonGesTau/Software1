package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider implements Spaceship {
	private static final int MAINTENANCE_COST_PER_YEAR = 3000;
	private static final int ENGINE_COST = 1000;

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	public int getAnnualMaintenanceCost() {
		return MAINTENANCE_COST_PER_YEAR + ENGINE_COST;
	}
}
