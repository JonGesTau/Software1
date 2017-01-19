package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter {
	private static final int CLOAKING_COST = 0;
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		List<Weapon> weapons = List<>();
		weapons.add(new Weapon ("Laser Cannons",10,100));

		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	public int getAnnualMaintenanceCost() {
		return getMaintenanceFixedCost() + CLOAKING_COST;
	}
}
