package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TransportShip extends AbstractSpaceship {
	private int cargoCapacity;
	private int passengerCapacity;

	private static final int MAINTENANCE_COST_PER_YEAR = 3000;
	private static final int CARGO_COST_PER_MT = 5;
	private static final int COST_PER_PASSENGER = 3;

	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return MAINTENANCE_COST_PER_YEAR + CARGO_COST_PER_MT * cargoCapacity + COST_PER_PASSENGER * passengerCapacity;
	}

	public int getCargoCapacity() {
		return cargoCapacity;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	@Override
	public String toString() {
		Map<String, String> params = new HashMap<>();
		params.put("NumberOfResearchLabs", String.valueOf(getCargoCapacity()));
		params.put("NumberOfResearchLabs", String.valueOf(getPassengerCapacity()));

		return super.toString(params);
	}
}
