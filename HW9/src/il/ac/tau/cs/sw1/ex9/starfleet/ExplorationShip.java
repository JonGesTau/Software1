package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExplorationShip extends AbstractSpaceship {
	private int numberOfResearchLabs;

	private static final int MAINTENANCE_COST_PER_YEAR = 4000;
	private static final int LABS_COST_PER_YEAR = 2500;

	public ExplorationShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int numberOfResearchLabs){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.numberOfResearchLabs = numberOfResearchLabs;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return MAINTENANCE_COST_PER_YEAR + LABS_COST_PER_YEAR * numberOfResearchLabs;
	}

	public int getNumberOfResearchLabs() {
		return numberOfResearchLabs;
	}

	@Override
	public String toString() {
		Map<String, String> params = new HashMap<>();
		params.put("NumberOfResearchLabs", String.valueOf(getNumberOfResearchLabs()));

		return super.toString(params);
	}
}
