package il.ac.tau.cs.sw1.ex9.starfleet;

import sun.jvm.hotspot.memory.Space;

import java.util.*;

public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and then in ascending order of the names
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear(Collection<Spaceship> fleet) {
		List<Spaceship> fleetList = new ArrayList<>(fleet);
		List<String> result = new ArrayList<>();

		Collections.sort(fleetList, new FirePowerAndCommissionYearComparator());

		for (Spaceship spaceship : fleetList) {
			result.add(spaceship.toString());
		}

		return result;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> result = new TreeMap<>();
		int count = 0;

		for (Spaceship spaceship : fleet) {
			String type = spaceship.getClass().getSimpleName();

			switch (type) {
				case "Bomber":
					count = ((Bomber) spaceship).getInstances();
					break;
				case "CylonRaider":
					count = ((CylonRaider) spaceship).getInstances();
					break;
				case "ExplorationShip":
					count = ((ExplorationShip) spaceship).getInstances();
					break;
				case "Fighter":
					count = ((Fighter) spaceship).getInstances();
					break;
				case "StealthCruiser":
					count = ((StealthCruiser) spaceship).getInstances();
					break;
				case "TransportShip":
					count = ((TransportShip) spaceship).getInstances();
					break;
			}

			if (count != 0) {
				result.put(type, count);
			}
		}

		return result;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		return 0;
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		return null;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		return 0;
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		return 0f;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		return null;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted descendingly based on the number of occurrences, and then in descending order of the ranks
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		return null;
	}
}
