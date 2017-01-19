package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends AbstractSpaceship {
	private int numberOfTechnicians;

	private static final int MAINTENANCE_COST_PER_YEAR = 5000;
	private static final int TECH_DISCOUNT = 0.1;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return MAINTENANCE_COST_PER_YEAR + Math.round(TECH_DISCOUNT * numberOfTechnicians) + getWeaponsCost();
	}

	public int getNumberOfTechnicians() {
		return numberOfTechnicians;
	}
}